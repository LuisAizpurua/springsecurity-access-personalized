package com.sec.practice.oauth.exceptions;

public class NotExistUser extends RuntimeException{

    public NotExistUser(String msg){
        super(msg);
    }

    public NotExistUser(){
    }

    public NotExistUser getMessageException(){
        return new NotExistUser("Not exist user" );
    }
}
