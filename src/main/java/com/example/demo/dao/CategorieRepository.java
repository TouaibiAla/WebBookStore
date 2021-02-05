package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{
/*public Categorie findCategorieByLabel(String label); 
	
	@Transactional
    @Modifying
    @Query("update Categorie categorie set categorie.categorie=:label where categorie.id =:Cid")
    public void UpdateCategorie(@Param("Cid") Long id,@Param("label") String label);*/
}
