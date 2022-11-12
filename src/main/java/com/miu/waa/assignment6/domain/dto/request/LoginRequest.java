package com.miu.waa.assignment6.domain.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    private String name;
    private String password;
}
