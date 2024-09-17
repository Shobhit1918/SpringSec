package com.dailycodebuffer.spring_security_client.service;

import com.dailycodebuffer.spring_security_client.entity.User;
import com.dailycodebuffer.spring_security_client.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
