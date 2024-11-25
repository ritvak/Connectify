package com.connectify.Connectify_BackEnd.Repository;

import com.connectify.Connectify_BackEnd.Model.Chat;
import com.connectify.Connectify_BackEnd.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat,Integer> {

    public List<Chat> findByUsersId(Integer userId);

    @Query("select c from Chat c Where :user Member of c.users And :reqUser Member of c.users")
    public Chat findChatByUsersId(@Param("user") User user,@Param("reqUser") User reqUser);

}
