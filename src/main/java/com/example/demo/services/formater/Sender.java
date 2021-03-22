package com.example.demo.services.formater;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Sender {

    Boolean sender(String message);
    //Boolean senderSlack(String notification, List<String> emails);

}
