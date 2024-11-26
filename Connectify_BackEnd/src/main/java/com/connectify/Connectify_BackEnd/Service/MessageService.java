package com.connectify.Connectify_BackEnd.Service;

import com.connectify.Connectify_BackEnd.Exception.ChatException;
import com.connectify.Connectify_BackEnd.Exception.MessageException;
import com.connectify.Connectify_BackEnd.Model.Chat;
import com.connectify.Connectify_BackEnd.Model.Message;
import com.connectify.Connectify_BackEnd.Model.User;

import java.util.List;

public interface MessageService {

    public Message createMessage(User user, Integer chatId, Message req) throws MessageException, ChatException;

    public List<Message> findChatsMessages(Integer chatId) throws MessageException, ChatException;
}
