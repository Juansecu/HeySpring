package com.juansecu.HeySpring.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encryptor {
    public static String encrypt(String str) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(str);
    }
}
