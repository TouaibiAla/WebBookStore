package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Commande;
import com.example.demo.entity.User;


@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long>{
	 @Query("select c from Commande c where c.user = :fk_user_id")
	 List<Commande> findByUserId(@Param("fk_user_id") User fk_user_id);
	 
	 @Query("select c.user,SUM(c.prix)  from Commande c  GROUP BY c.user")
	 List usersAchats();
}
