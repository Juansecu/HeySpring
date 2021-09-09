package com.juansecu.HeySpring.util;

public class EncryptorTests {
    public static void main(String[] args) {
        String encryptedPassword1 = Encryptor.encrypt("5f0a1ad6-0e58-4874-a90e-42bdc4dda7ba");
        String encryptedPassword2 = Encryptor.encrypt("1323");

        System.out.println("encryptedPassword1 = " + encryptedPassword1);
        System.out.println("encryptedPassword2 = " + encryptedPassword2);
    }
}
