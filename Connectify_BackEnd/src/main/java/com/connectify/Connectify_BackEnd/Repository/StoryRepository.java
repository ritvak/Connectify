package com.connectify.Connectify_BackEnd.Repository;

import com.connectify.Connectify_BackEnd.Model.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story,Integer> {

    public List<Story> findByUserId(Integer userId);

}
