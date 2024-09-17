package com.dailycodebuffer.spring_security_client.event;

import com.dailycodebuffer.spring_security_client.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private User user;
    private String applicationUrl; //Url that we create for the user, so that when he clicks on it an email is sent to him

    public RegistrationCompleteEvent(User user, String applicationUrl){
        super(user);
        this.user=user;
        this.applicationUrl=applicationUrl;
    }
}
