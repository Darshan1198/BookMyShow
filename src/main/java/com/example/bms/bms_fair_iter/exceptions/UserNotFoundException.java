package com.example.bms.bms_fair_iter.exceptions;

public class UserNotFoundException extends  Exception {
    public  UserNotFoundException(){
        super("User not found");
    }
}
