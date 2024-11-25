package com.connectify.Connectify_BackEnd.Controller;

import com.connectify.Connectify_BackEnd.Model.Chat;
import com.connectify.Connectify_BackEnd.Model.User;
import com.connectify.Connectify_BackEnd.Request.CreateChatRequest;
import com.connectify.Connectify_BackEnd.Service.ChatService;
import com.connectify.Connectify_BackEnd.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/chats")
    public Chat createChat(@RequestHeader("Authorization") String jwt,@RequestBody CreateChatRequest req) throws Exception {
        User reqUser=userService.findUserByJwt(jwt);
        User user2=userService.findUserById(req.getUserId());
        Chat chat=chatService.createChat(reqUser,user2);
        return chat;
    }

    @GetMapping("/api/chats")
    public List<Chat> findUsersChat(@RequestHeader("Authorization") String jwt)
    {
        User user=userService.findUserByJwt(jwt);
        List<Chat> chat=chatService.findUserChat(user.getId());
        return chat;
    }
}
