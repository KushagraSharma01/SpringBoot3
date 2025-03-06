package com.example.SpringBoot3.controllers;

import com.example.SpringBoot3.dto.*;
import com.example.SpringBoot3.interfaces.IAuthInterface;
//import com.example.SpringBoot3.services.iAuthInterface;
import com.example.SpringBoot3.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    EmailService emailService;

    @Autowired
    IAuthInterface iAuthInterface;

    //UC9 --> For Registration of a user
    @PostMapping(path = "/register")
    public String register(@RequestBody AuthUserDTO user){
        return iAuthInterface.register(user);
    }

    //UC10 --> For User Login
    @PostMapping(path ="/login")
    public String login(@RequestBody LoginDTO user){
        return iAuthInterface.login(user);
    }

    //UC11 --> For sending mail to another person
    @PostMapping(path = "/sendMail")
    public String sendMail(@RequestBody MailDTO message){
        emailService.sendEmail(message.getTo(), message.getSubject(), message.getBody());
        return "Mail sent";
    }

    //UC12 --> Added Swagger Config to use Swagger at url(/swagger)


    @PutMapping("/forgotpassword")
    public AuthUserDTO forgotpassword(@RequestBody PassDTO pass){
        return iAuthInterface.forgotpassword(pass);
    }
}
