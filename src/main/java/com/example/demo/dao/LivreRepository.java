package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Livre;
@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {
 @Query("select l from Livre l where l.nomLivre = ?1")
  Livre findByNomLivre(String name);
  

  Query("select l from Livre l, Categorie c where l.categorie = c.id and (l.nomLivre = ?1 l.edision = ?1 or l.auteur = ?1 or c.libelle= ?1)")
  List<Livre> findByAnything (String text);
}