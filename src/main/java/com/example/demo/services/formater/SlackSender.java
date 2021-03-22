package com.example.demo.services.formater;

public class SlackSender implements Sender{
    @Override
    public Boolean sender(String message) {
        return false;
    }

    /*@Override
    public Boolean senderSlack(String notification, List<String> emails) {
        //TODO Notificación Slack Lógica
        return true;
    }*/
}
