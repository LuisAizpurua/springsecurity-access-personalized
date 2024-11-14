package com.sec.practice.oauth.exceptions;

public class NotExistUsername extends RuntimeException{

    public NotExistUsername(String msg){
        super(msg);
    }

    public NotExistUsername(){ }

    public NotExistUsername getMessageException(String username){
        return new NotExistUsername("Not exist username: " + username );
    }
}
