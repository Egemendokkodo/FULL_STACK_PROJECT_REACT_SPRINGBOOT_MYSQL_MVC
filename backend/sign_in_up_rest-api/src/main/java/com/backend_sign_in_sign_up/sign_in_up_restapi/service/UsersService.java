package com.backend_sign_in_sign_up.sign_in_up_restapi.service;

import com.backend_sign_in_sign_up.sign_in_up_restapi.model.Users;

public interface UsersService {
    Users saveUser(Users user);
    //List<Users> getAllUsers();
    Users getUserById(long id);   
    Users updateUser(Users user,long id);
    void deleteUser(long id);
}
