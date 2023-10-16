package com.backend_sign_in_sign_up.sign_in_up_restapi.service;

import com.backend_sign_in_sign_up.sign_in_up_restapi.DTO.LoginDTO;
import com.backend_sign_in_sign_up.sign_in_up_restapi.message.LoginMesage;
import com.backend_sign_in_sign_up.sign_in_up_restapi.model.Users;

public interface UsersService {
    Users saveUser(Users user);
    //List<Users> getAllUsers();
    //String loginUser(Users user);
    Users getUserById(long id);   
    Users updateUser(Users user,long id);
    void deleteUser(long id);
    LoginMesage loginUser(LoginDTO loginDTO);

    
}
