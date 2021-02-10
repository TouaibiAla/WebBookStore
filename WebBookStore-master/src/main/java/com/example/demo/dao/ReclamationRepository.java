package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Etat;
import com.example.demo.entity.Reclamation;
import com.example.demo.entity.User;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long>{

	@Query("SELECT user FROM Reclamation WHERE user_id = :idUser")
	public User findByUser( @Param("idUser") long idUser);
	
	@Query("SELECT COUNT(*) FROM Reclamation WHERE etat = :etat")
	public int getNombreReclamationByEtat(@Param ("etat") Etat etat);
	
	@Query("SELECT COUNT(*) FROM Reclamation")
	public int getNombreReclamation();
}
