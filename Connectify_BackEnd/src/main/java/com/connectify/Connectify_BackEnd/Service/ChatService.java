package com.connectify.Connectify_BackEnd.Service;

import com.connectify.Connectify_BackEnd.Exception.ChatException;
import com.connectify.Connectify_BackEnd.Model.Chat;
import com.connectify.Connectify_BackEnd.Model.User;

import java.util.List;
import java.util.Optional;

public interface ChatService {

    public Chat createChat(User reqUser, User user);

    public Chat findChatById(Integer chatId) throws ChatException;

    public List<Chat> findUserChat(Integer userId);

}
