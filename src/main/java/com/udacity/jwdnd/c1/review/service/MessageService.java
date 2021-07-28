package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Service
public class MessageService{


    private List<ChatMessage> chatMessages;


    @PostConstruct
    public void postConstruct(){


        System.out.println("Creating MessageService Bean");

        this.chatMessages = new ArrayList();

    }


    public void addMessage(ChatForm chatForm){

        ChatMessage newMessage = new ChatMessage();

        newMessage.setUsername(chatForm.getUsername());

        switch (chatForm.getMessageType()){

            case "Say":

                newMessage.setMessage(chatForm.getMessageText());

                break;


            case "Whisper":


                newMessage.setMessage(chatForm.getUsername().toUpperCase());


            case "shout":


                newMessage.setUsername(chatForm.getUsername().toLowerCase());

                break;




        }

        this.chatMessages.add(newMessage);



    }


    public List<ChatMessage> getChatMessages(){


        return chatMessages;
    }




}
