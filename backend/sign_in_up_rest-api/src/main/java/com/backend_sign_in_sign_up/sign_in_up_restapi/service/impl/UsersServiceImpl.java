package com.backend_sign_in_sign_up.sign_in_up_restapi.service.impl;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend_sign_in_sign_up.sign_in_up_restapi.exception.ResourceNotFoundException;
import com.backend_sign_in_sign_up.sign_in_up_restapi.model.Users;
import com.backend_sign_in_sign_up.sign_in_up_restapi.repository.UsersRepository;
import com.backend_sign_in_sign_up.sign_in_up_restapi.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{


    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository)   {
        super();
        this.usersRepository = usersRepository;
    }  


    @Override
    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public Users getUserById(long id) {
        Optional<Users> user=usersRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new ResourceNotFoundException("User","Id",id);
        }
    }

    @Override
    public Users updateUser(Users user, long id) {
        Users existingUser=usersRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("User", "Id", id));
        existingUser.setEmail(user.getEmail()); // fonksiyona gönderilen yeni bilgileri burada önce veritabanından ilgiili kullanıcı alıp sonra set ediyoruz
        existingUser.setPassword(user.getPassword());
        
        // update edilmiş kullanıcı veritabanına kaydediyoruz.
        usersRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(long id) {
        //usersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Users", "Id", id));
        usersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
        usersRepository.deleteById(id);
    }
    
}
