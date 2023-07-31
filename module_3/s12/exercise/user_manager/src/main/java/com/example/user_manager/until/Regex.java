package com.example.user_manager.until;

public class Regex {
    public static boolean checkNumPhone(String hone){
        return hone.matches("^0\\d{9}$");
    }
    public static boolean checkEmail(String email){
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}
