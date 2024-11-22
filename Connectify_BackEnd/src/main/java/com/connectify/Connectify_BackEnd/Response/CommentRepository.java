package com.connectify.Connectify_BackEnd.Response;

import com.connectify.Connectify_BackEnd.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {


}
