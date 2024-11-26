package com.connectify.Connectify_BackEnd.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ChatException.class)
    public ResponseEntity<ErrorDetails> chatExceptionHandler(ChatException ue, WebRequest req)
    {
        ErrorDetails error=new ErrorDetails(ue.getMessage(), req.getDescription(false), LocalDateTime.now() );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CommentException.class)
    public ResponseEntity<ErrorDetails> commentExceptionHandler(CommentException ue, WebRequest req)
    {
        ErrorDetails error=new ErrorDetails(ue.getMessage(), req.getDescription(false), LocalDateTime.now() );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MessageException.class)
    public ResponseEntity<ErrorDetails> messageExceptionHandler(MessageException ue, WebRequest req)
    {
        ErrorDetails error=new ErrorDetails(ue.getMessage(), req.getDescription(false), LocalDateTime.now() );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PostException.class)
    public ResponseEntity<ErrorDetails> postExceptionHandler(PostException ue, WebRequest req)
    {
        ErrorDetails error=new ErrorDetails(ue.getMessage(), req.getDescription(false), LocalDateTime.now() );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReelsException.class)
    public ResponseEntity<ErrorDetails> reelsExceptionHandler(ReelsException ue, WebRequest req)
    {
        ErrorDetails error=new ErrorDetails(ue.getMessage(), req.getDescription(false), LocalDateTime.now() );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StoryException.class)
    public ResponseEntity<ErrorDetails> storyExceptionHandler(StoryException ue, WebRequest req)
    {
        ErrorDetails error=new ErrorDetails(ue.getMessage(), req.getDescription(false), LocalDateTime.now() );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDetails> userExceptionHandler(UserException ue, WebRequest req)
    {
        ErrorDetails error=new ErrorDetails(ue.getMessage(), req.getDescription(false), LocalDateTime.now() );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> otherExceptionHandler(Exception ue, WebRequest req)
    {
        ErrorDetails error=new ErrorDetails(ue.getMessage(), req.getDescription(false), LocalDateTime.now() );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
