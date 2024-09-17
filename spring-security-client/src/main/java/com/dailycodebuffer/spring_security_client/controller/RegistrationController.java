package com.dailycodebuffer.spring_security_client.controller;

import com.dailycodebuffer.spring_security_client.entity.User;
import com.dailycodebuffer.spring_security_client.event.RegistrationCompleteEvent;
import com.dailycodebuffer.spring_security_client.model.UserModel;
import com.dailycodebuffer.spring_security_client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel){
        User user=userService.registerUser(userModel);
        // Now Sending a Verification Email Event for Registration
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,"url"
        ));
        return "Success";

    }
}