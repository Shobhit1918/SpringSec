package com.dailycodebuffer.spring_security_client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//Use @Configuration to define and configure beans in a centralized way, allowing Spring to manage them within its IoC container.
//@Configuration
//The @EnableWebSecurity annotation in Spring Security is used to enable Spring Security's web security support in a Spring Boot application. It allows you to customize the security configuration by extending the WebSecurityConfigurerAdapter class or implementing the SecurityConfigurer interface.
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(11);
    }
    //@Bean: This annotation indicates that the method returns an object that should be registered as a Spring bean. In this case, it's a PasswordEncoder. Now you can autowire this function anywhere in your code
    //PasswordEncoder: This is an interface provided by Spring Security for encoding passwords. It's used to ensure that passwords are stored in an encrypted format, enhancing security.
    //BCryptPasswordEncoder(11): This is an implementation of PasswordEncoder that uses the BCrypt hashing function. The parameter 11 specifies the strength of the encryption, where higher values result in more computationally intensive encoding, thus more security.
}
