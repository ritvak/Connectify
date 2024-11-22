package com.connectify.Connectify_BackEnd.Service;

import com.connectify.Connectify_BackEnd.Model.Reels;
import com.connectify.Connectify_BackEnd.Model.User;

import java.util.List;

public interface ReelsService {

    public Reels createReel(Reels reel, User userId);

    public List<Reels> findAllReels();

    public List<Reels> findUsersReel(Integer userId) throws Exception;

}
