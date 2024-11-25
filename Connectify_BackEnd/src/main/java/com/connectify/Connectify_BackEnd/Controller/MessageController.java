package com.connectify.Connectify_BackEnd.Controller;

import com.connectify.Connectify_BackEnd.Model.Message;
import com.connectify.Connectify_BackEnd.Model.User;
import com.connectify.Connectify_BackEnd.Service.MessageService;
import com.connectify.Connectify_BackEnd.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/messages/chat/{chatId}")
    public Message createMessage(@RequestBody Message req, @RequestHeader("Authorization")String jwt, @PathVariable Integer chatId) throws Exception {
        User reqUser=userService.findUserByJwt(jwt);
        Message message=messageService.createMessage(reqUser,chatId,req);
        return message;
    }

    @GetMapping("/api/messages/chat/{chatId}")
    public List<Message> findChatsMessages( @RequestHeader("Authorization")String jwt,@PathVariable Integer chatId) throws Exception {
        User reqUser=userService.findUserByJwt(jwt);
        List<Message> messages=messageService.findChatsMessages(chatId);
        return messages;
    }
}
