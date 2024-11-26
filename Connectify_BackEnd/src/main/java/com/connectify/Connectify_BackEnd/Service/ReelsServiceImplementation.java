package com.connectify.Connectify_BackEnd.Service;

import com.connectify.Connectify_BackEnd.Exception.ReelsException;
import com.connectify.Connectify_BackEnd.Exception.UserException;
import com.connectify.Connectify_BackEnd.Model.Reels;
import com.connectify.Connectify_BackEnd.Model.User;
import com.connectify.Connectify_BackEnd.Repository.ReelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReelsServiceImplementation implements ReelsService{

    @Autowired
    private ReelsRepository reelsRepository;

    @Autowired
    private UserService userService;

    @Override
    public Reels createReel(Reels reel, User user) {
        Reels createReel=new Reels();
        createReel.setTitle(reel.getTitle());
        createReel.setVideo(reel.getVideo());
        createReel.setUser(user);

        return reelsRepository.save(createReel);
    }

    @Override
    public List<Reels> findAllReels() {

        return reelsRepository.findAll();
    }

    @Override
    public List<Reels> findUsersReel(Integer userId) throws ReelsException, UserException {
        userService.findUserById(userId);
        return reelsRepository.findByUserId(userId);
    }
}
