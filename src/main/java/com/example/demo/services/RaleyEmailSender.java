package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RaleyEmailSender implements Sender{

    /*private String userEmail;

    public RaleyEmailSender(String userEmail) {
        this.userEmail = userEmail;
    }*/

    @Override
    public Boolean sender(String message) {
        //TODO Lógica para Raley
        return true;
    }

    /*@Override
    public Boolean senderSlack(String notification, List<String> emails) {
        return true;
    }*/
}
