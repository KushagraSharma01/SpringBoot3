package com.example.SpringBoot3.interfaces;

import com.example.SpringBoot3.dto.AuthUserDTO;
import com.example.SpringBoot3.dto.LoginDTO;
import org.springframework.stereotype.Service;

@Service
public interface IAuthInterface {

    public String register(AuthUserDTO user);


    public String login(LoginDTO user);


}
