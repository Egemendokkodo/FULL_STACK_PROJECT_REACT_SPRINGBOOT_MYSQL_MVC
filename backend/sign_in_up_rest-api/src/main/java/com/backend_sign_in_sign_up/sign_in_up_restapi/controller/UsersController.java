package com.backend_sign_in_sign_up.sign_in_up_restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend_sign_in_sign_up.sign_in_up_restapi.model.Users;
import com.backend_sign_in_sign_up.sign_in_up_restapi.service.UsersService;




@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController{

    private UsersService usersService;

    public UsersController(UsersService usersService){
        super();
        this.usersService=usersService;
    }





    @PostMapping
    public ResponseEntity<Users> saveUser(@RequestBody Users user) {
       
        
        
        
        
        return new ResponseEntity<>(usersService.saveUser(user),HttpStatus.CREATED); 
    }

   
}
