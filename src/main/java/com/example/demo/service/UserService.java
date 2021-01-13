package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.exception.ConfilctException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.utile.ModifyPassword;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=this.userRepository.findUserByEmail(email);
		if(user == null)throw new UsernameNotFoundException(email);
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
	}
	
	/**
     * function
     * @return list of all Users
     */
    public List<User> getAll(){
        return this.userRepository.findAll();
    }
    
    /**
     *a function taking one argument and returning an object of User which has the same email.
     *@param email of the User
     * @return an object of User
     */
    public User getOneByEmail(String email){
        User user=this.userRepository.findUserByEmail(email);
        return user;
    }
    
    /**
     *a function taking one argument and returning an object of User. the purpose of the function is to a add new User.
     * @param user an object of User.
     * @return an object of User
     */

     public User addUser(User user) {
        User user1=this.userRepository.findUserByEmail(user.getEmail());
        if(user1!=null) throw new ConfilctException("email déjà existant");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
     }
     
     /**
      *a function taking one argument and deleting an object of User which has the same id.
      *@param id of the user to delete
      */

       public void deleteUser(Long id){
         User user=this.userRepository.findById(id).orElseThrow(()-> new NotFoundException(" user n'existe pas"));
         this.userRepository.deleteById(id);
       }
       
       /**
        *a function taking two arguments.
        * @param  pass an object of Pass.
        *@param id of the User.
        */
       public void updatePass(ModifyPassword pass, Long id){
    	     User user=this.userRepository.getOne(id);
    	      if(bCryptPasswordEncoder.matches(pass.getAncienPass(),user.getPassword())){
    	          if(pass.getConfirmPass().equals(pass.getNouveauPass())){
    	              this.userRepository.UpdatePass(id,bCryptPasswordEncoder.encode(pass.getNouveauPass()));
    	          }
    	      }
    	      else {
    	          throw new NotFoundException("Ancien mot de passe est incorrecte");
    	      }
    	    }
       /**
        *a function taking one argument and returning an object of User which has the same id.
        *@param id of the User
        * @return an object of User
        */
       public User getOneById(Long id){
           User user=this.userRepository.getOne(id);
           return user;
       }
       
       /**
        *a function taking two arguments and returning an object of User updated.
        * @param user an object of User.
        *@param id of the User.
        * @return an object of User updated.
        */
        public User updateUser(Long id,User user) {
           User user1=this.userRepository.findById(id).orElseThrow(()->new NotFoundException("user n'existe pas"));
           user1.setFirstName(user.getFirstName());
           user1.setEmail(user.getEmail());
           user1.setLastName(user.getLastName());
           user1.setPhoneNumber(user.getPhoneNumber());
           user1.setRole(user.getRole());
           return userRepository.save(user1);
        }
       
       
}
