package com.connectify.Connectify_BackEnd.Service;


import com.connectify.Connectify_BackEnd.Exception.CommentException;
import com.connectify.Connectify_BackEnd.Exception.UserException;
import com.connectify.Connectify_BackEnd.Model.Comment;

public interface CommentService {

    public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception;

    public Comment findCommentById(Integer commentId) throws CommentException;

    public Comment likeComment(Integer commentId, Integer userId) throws CommentException, UserException;
}
