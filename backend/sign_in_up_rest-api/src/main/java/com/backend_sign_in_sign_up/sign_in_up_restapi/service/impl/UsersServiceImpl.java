package com.backend_sign_in_sign_up.sign_in_up_restapi.service.impl;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend_sign_in_sign_up.sign_in_up_restapi.DTO.LoginDTO;
import com.backend_sign_in_sign_up.sign_in_up_restapi.exception.EmailAlreadyInUseException;
import com.backend_sign_in_sign_up.sign_in_up_restapi.exception.EmailNotFoundException;
import com.backend_sign_in_sign_up.sign_in_up_restapi.exception.ResourceNotFoundException;
import com.backend_sign_in_sign_up.sign_in_up_restapi.message.LoginMesage;
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

        if (isEmailAlreadyInUse(user.getEmail())) {
            throw new EmailAlreadyInUseException("Bu e-posta adresi zaten kullanımda.","email",user.getEmail());
            
        }else{
            return usersRepository.save(user);
        }
        
        
    }
    private boolean isEmailAlreadyInUse(String email) {
        Users existingUser = usersRepository.findByEmail(email);
        
        return existingUser != null;
    }
    /*@Override
    public String loginUser(Users user) {

        

        if(isEmailAlreadyInUse(user.getEmail())){
            Users existingUser = usersRepository.findByEmail(user.getEmail());
            if(existingUser.getPassword().equals(user.getPassword())){
                return "successfully logged in.";
            }else{
                return "email or password is incorrect.";
            }
            
        }else{
            throw new EmailNotFoundException("E-mail not found.","email",user.getEmail());
            
        }
    }*/

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


    @Override
    public LoginMesage loginUser(LoginDTO loginDTO) {
        Users user1=usersRepository.findByEmail(loginDTO.getEmail());
        if(user1 != null ){
            String password = loginDTO.getPassword();
            Boolean isPwdRight= loginDTO.getPassword().equals(user1.getPassword());     
            if(isPwdRight){
                Optional<Users> user=usersRepository.findByEmailAndPassword(loginDTO.getEmail(), password);
                if(user.isPresent()){
                    return new LoginMesage("Login Success", true);
                }else{
                    return new LoginMesage("Login Failed", false);
                }
            }     else{
                return new LoginMesage("Password is incorrect", false);
            }
        }else{
            return new LoginMesage("Email does not exists", false);
        }

    }


   
    
}
