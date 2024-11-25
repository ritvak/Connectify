package com.connectify.Connectify_BackEnd.Service;

import com.connectify.Connectify_BackEnd.Model.Chat;
import com.connectify.Connectify_BackEnd.Model.User;
import com.connectify.Connectify_BackEnd.Repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImplementation implements ChatService{

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserService userService;

    @Override
    public Chat createChat(User reqUser, User user) {
        Chat isExist= chatRepository.findChatByUsersId(user,reqUser);

        if(isExist!=null)
        {
            return isExist;
        }
        Chat chat=new Chat();

        chat.getUsers().add(user);
        chat.getUsers().add(reqUser);
        chat.setTimestamp(LocalDateTime.now());
        return chatRepository.save(chat);
    }

    @Override
    public Chat findChatById(Integer chatId) throws Exception {
        Optional<Chat> opt=chatRepository.findById(chatId);

        if(opt.isEmpty())
        {
            throw new Exception("Chat does not exist with id "+ chatId);
        }
        return opt.get();
    }

    @Override
    public List<Chat> findUserChat(Integer userId) {
        return chatRepository.findByUsersId(userId);
    }
}
