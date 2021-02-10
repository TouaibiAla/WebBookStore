package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
    private UserService userService;
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(this.userService.getAll(), HttpStatus.OK);
      }
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@Validated @RequestBody User user){
        return new ResponseEntity<>(this.userService.addUser(user),HttpStatus.CREATED);
     }
	
	 @DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
	 
	 @GetMapping("/userByEmail/{email}")
	    public ResponseEntity<User> getOneByUsername(@PathVariable String email){
	        return new ResponseEntity<>(this.userService.getOneByEmail(email),HttpStatus.OK);
	    }
	 
	 @GetMapping("/userById/{id}")
	    public ResponseEntity<User> getOneById(@PathVariable Long id){
		 
	        return new ResponseEntity<>(this.userService.getOneById(id),HttpStatus.OK);
	    }
	 
	 @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@Validated @RequestBody User user) {
        return new ResponseEntity<>(this.userService.updateUser(id,user),HttpStatus.OK);
     }
}
