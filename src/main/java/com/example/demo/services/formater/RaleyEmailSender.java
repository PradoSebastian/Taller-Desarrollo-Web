package com.example.demo.services.formater;

import org.springframework.stereotype.Service;

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
