package com.example.auth.service;

import com.example.auth.entities.UserInfo;
import com.example.auth.eventProducer.UserInfoProducer;
import com.example.auth.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.auth.model.UserInfoDTO;


import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

@Component
@AllArgsConstructor
@Data
public class UserServiceDetailsImpl implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final UserInfoProducer userInfoProducer;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserInfo user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Could not found user : "+username);
        }
        return new CustomUserDetails(user);
    }

    public UserInfo checkUserAlreadyExists(UserInfoDTO user){
         return  userRepository.findByUsername(user.getUsername());
    }

    public Boolean signUpUser(UserInfoDTO user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(Objects.nonNull(checkUserAlreadyExists(user))){
            return false;
        }
        String userId  = UUID.randomUUID().toString();
        userRepository.save(new UserInfo(userId,user.getUsername(),user.getPassword(),new HashSet<>()));
        userInfoProducer.sendEventToKafka(user);
        return true;
    }




}
