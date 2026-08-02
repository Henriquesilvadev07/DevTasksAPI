package com.rickdev.DevTasks.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityBeanConfig {

    //classe para criacao da service temporario

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
