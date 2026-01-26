package dev.santosh.productservice.auth;

import dev.santosh.productservice.user.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String email;
    private String password;
    private Role role;
}
