package com.cloud.simpleusermanagement.adapter.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    private String name;
    private String email;
    private String individualUii;
    private String contactNumber;
}
