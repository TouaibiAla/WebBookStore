package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findUserByEmail(String email); 
	
	@Transactional
    @Modifying
    @Query("update User user set user.password=:Pass where user.id =:Uid")
    public void UpdatePass(@Param("Uid") Long id,@Param("Pass") String pass);
}
