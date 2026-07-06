package com.example.auth.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponseDTO {
    private String token;
    private String accessToken;

}
