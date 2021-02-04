package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LivreurRepository;
import com.example.demo.entity.Livreur;
import com.example.demo.exception.NotFoundException;

@Service
public class LivreurService {
	@Autowired
	private LivreurRepository livreurRepository;
	
	public List<Livreur> getAllLivreurs(){
		return this.livreurRepository.findAll();
	}

	public Livreur getLivreurById(Long idLivreur){
		Livreur livreur=this.livreurRepository.getOne(idLivreur);
		return livreur;
	}
	
	public Livreur addLivreur(Livreur livreur){
		return this.livreurRepository.save(livreur);
	}
	
	public void deleteLivreur(Long idLivreur){
		Livreur livreur=this.livreurRepository.findById(idLivreur).orElseThrow(()-> new NotFoundException("Livreur n'existe pas"));
		this.livreurRepository.deleteById(idLivreur);
	}
	
	public Livreur updateLivreur(Long idLivreur,Livreur livreur) {
        Livreur livreur1=this.livreurRepository.findById(idLivreur).orElseThrow(()->new NotFoundException("Livreur n'existe pas"));
        livreur1.setNomLivreur(livreur.getNomLivreur());
        livreur1.setPrenomLivreur(livreur.getPrenomLivreur());
        livreur1.setDisponibilite(livreur.isDisponibilite());
        return livreurRepository.save(livreur1);
     }
}
