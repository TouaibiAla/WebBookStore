package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {
	@Autowired
	  private UserService userService;
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	public static void main(String[] args)  {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//User u=new User("aa","123","alaa", "159357", "admin");
		//userService.addUser(u);
		
	}
    
}
