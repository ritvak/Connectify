package com.connectify.Connectify_BackEnd.Repository;

import com.connectify.Connectify_BackEnd.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
