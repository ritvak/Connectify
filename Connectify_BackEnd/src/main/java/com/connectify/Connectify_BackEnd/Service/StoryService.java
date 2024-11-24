package com.connectify.Connectify_BackEnd.Service;

import com.connectify.Connectify_BackEnd.Model.Story;
import com.connectify.Connectify_BackEnd.Model.User;
import com.connectify.Connectify_BackEnd.Repository.StoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StoryService {

    public Story createStory(Story story, User user);

    public List<Story> findStoryByUserId(Integer userId) throws Exception;
}
