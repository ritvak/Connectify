package com.connectify.Connectify_BackEnd.Request;

import com.connectify.Connectify_BackEnd.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateChatRequest {

    private Integer userId;

    private User user2;

}
