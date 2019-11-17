package com.toystore.security.service;



import com.toystore.security.model.entity.User;
import com.toystore.security.model.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;


    public void save(User user){
        repo.save(user);
    }
    public User findByUserName(String userName){
        return repo.findByUsername(userName);
    }

}
