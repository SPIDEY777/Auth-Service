package com.example.auth.serializer;


import com.example.auth.model.UserInfoDTO;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;


import java.util.Map;

public class UserInfoSerializer implements Serializer<UserInfoDTO> {



    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, UserInfoDTO data) {
        byte[] retVal = null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            retVal = mapper.writeValueAsString(data)
                    .getBytes();

        }
        catch (Exception e){
            e .printStackTrace();
        }
        return retVal;


    }

    @Override
    public void close() {

    }
}
