package com.dailycodebuffer.spring_security_client.service;

import com.dailycodebuffer.spring_security_client.entity.User;
import com.dailycodebuffer.spring_security_client.entity.VerificationToken;
import com.dailycodebuffer.spring_security_client.model.UserModel;
import com.dailycodebuffer.spring_security_client.repository.UserRepository;
import com.dailycodebuffer.spring_security_client.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserModel userModel) {
        //Create the object of the User from the entity class
        User user=new User();

        //User should have all the values from userModel

        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //password here is the plain simple password we get from the userModel, but when
        //we save the password to the database we need to encrpyt it using PasswordEncoder

        userRepository.save(user);
        return null;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken= new VerificationToken(user,token);
        verificationTokenRepository.save(verificationToken);

    }
}
