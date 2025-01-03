package com.connectify.Connectify_BackEnd.Service;

import com.connectify.Connectify_BackEnd.Exception.PostException;
import com.connectify.Connectify_BackEnd.Exception.UserException;
import com.connectify.Connectify_BackEnd.Model.Post;
import com.connectify.Connectify_BackEnd.Model.User;
import com.connectify.Connectify_BackEnd.Repository.PostRepository;
import com.connectify.Connectify_BackEnd.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Post createNewPost(Post post, Integer userId) throws PostException, UserException {

        Post newPost=new Post();
        newPost.setCaption(post.getCaption());
        newPost.setImage(post.getImage());
        newPost.setVideo(post.getVideo());
        newPost.setCreatedAt(LocalDateTime.now());

        User user=userService.findUserById(userId);
        newPost.setUser(user);

        postRepository.save(newPost);

        return newPost;
    }

    @Override
    public String deletePost(Integer postId, Integer userId) throws PostException, UserException {

        Post post= findPostById(postId);
        User user=userService.findUserById(userId);

        if(post.getUser().getId()!=user.getId())
        {
            throw new PostException("User not found with id "+userId);
        }
        postRepository.deleteById(postId);
        return "post deleted successfully" ;
    }

    @Override
    public List<Post> findPostByUserId(Integer userId) {
        return postRepository.findPostByUserId(userId);
    }

    @Override
    public Post findPostById(Integer postId) throws PostException {

        Optional<Post> opt=postRepository.findById(postId);

        if(opt.isEmpty())
        {
            throw new PostException("post not found with id "+postId);
        }
        return opt.get();
    }

    @Override
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Post savedPost(Integer postId, Integer userId) throws PostException, UserException {
        Post post= findPostById(postId);
        User user=userService.findUserById(userId);

        if(user.getSavedPost().contains(post))
        {
            user.getSavedPost().remove(post);
        }
        else {
            user.getSavedPost().add(post);
        }
        userRepository.save(user);
       return post;
    }

    @Override
    public Post likePost(Integer postId, Integer userId) throws PostException, UserException {
        Post post= findPostById(postId);
        User user=userService.findUserById(userId);

        if(post.getLiked().contains(user))
        {
            post.getLiked().remove(user);
        }
        else {
            post.getLiked().add(user);
        }

        return postRepository.save(post);
    }
}
