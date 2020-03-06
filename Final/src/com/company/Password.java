package com.company;

public class Password {
    private static final int key = 3246767;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encrypt(password);
    }

    private int encrypt(int password){
        return password ^ key;
    }

    public final void sotrePassword(){
        System.out.println("Encrypted password is " + encryptedPassword);
    }

    public void letMeIn(int password){
        if(encrypt(password) == this.encryptedPassword){
            System.out.println("Welcome");
        } else {
            System.out.println("Try again");
        }
    }
}
