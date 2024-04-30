package com.example.bkshlf.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse
{
    private String accessToken;
    private String refreshToken;
}
