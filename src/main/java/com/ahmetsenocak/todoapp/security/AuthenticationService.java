package com.ahmetsenocak.todoapp.security;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String name, String password) {
        boolean isValidUsername = name.equalsIgnoreCase("ahmet");
        boolean isValidPassword = password.equalsIgnoreCase("123");

        return isValidUsername && isValidPassword;
    }


}
