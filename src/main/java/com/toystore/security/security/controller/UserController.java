package com.toystore.security.security.controller;



import com.toystore.security.model.entity.Role;
import com.toystore.security.model.entity.User;
import com.toystore.security.model.repo.UserRepository;
import com.toystore.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/uaa")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserService service;
    @Autowired
    UserRepository repository;


    @GetMapping(value = "/currentUser")
    public User getUser(Principal principal, HttpServletResponse response) {
        if (principal != null) {
            System.out.println(principal.getName());
            return userService.findByUserName(principal.getName());
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
    }

    @GetMapping(value = "/signup/{name}/{username}/{email}/{password}")
    public boolean saveUser(@PathVariable("name")String name, @PathVariable("username")String userName, @PathVariable(value = "email")String email, @PathVariable("password")String password){
        if (repository.findByUsername(userName) == null) {
            //String username, String name,String email,String password
            service.save(new User(userName, name,email,passwordEncoder.encode(password),  Arrays.asList(new Role("ADMIN"), new Role("ACTUATOR"))));

            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public Principal getUser(Principal principal, HttpServletRequest request) {
        return principal;
    }


}
