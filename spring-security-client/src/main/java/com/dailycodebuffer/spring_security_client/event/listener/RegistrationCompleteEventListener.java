package com.dailycodebuffer.spring_security_client.event.listener;

import com.dailycodebuffer.spring_security_client.entity.User;
import com.dailycodebuffer.spring_security_client.event.RegistrationCompleteEvent;
import com.dailycodebuffer.spring_security_client.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event)
    {
        //Create the Verification Token for the User, so that when the user clicks on it,he will be redirected to the application
        User user=event.getUser();
        String token= UUID.randomUUID().toString(); //So that we can save a token for a particular user,so that whenevr link is hit by the user we can match the token witht the token present in the database
        userService.saveVerificationTokenForUser(token,user);

        //After the link is created we can send mail to the user
        String url= event.getApplicationUrl() + "verifyRegistration?token=" + token;
       //sendVerificationEmail()
        log.info("Click the link to verify your account: {}",url);
    }
}
