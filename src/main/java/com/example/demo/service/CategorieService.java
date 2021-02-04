package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategorieRepository;
import com.example.demo.entity.Categorie;
import com.example.demo.exception.NotFoundException;

//import com.example.demo.exception.ConfilctException;
//import com.example.demo.exception.NotFoundException;

@Service



public class CategorieService   {
	@Autowired
	private CategorieRepository categorieRepository;
	
	 public List<Categorie> getAll(){
	        return this.categorieRepository.findAll();
	    }
/*	 public Categorie getOneById(Long id){
		 Categorie categorie=this.categorieRepository.findCategorieById(id);
	        return categorie;
}*/
	 /*public Categorie getOneByLabel(String label){
		 Categorie categorie=this.categorieRepository.findCategorieByLabel(label);
	        return categorie;
}*/
	 public Categorie addCategorie(Categorie categorie) {
		 //Categorie categorie1=this.categorieRepository.findCategorieByLabel(categorie.getLabel());
	       // if(categorie1!=null) throw new ConfilctException("Label existe déja");
	      //  categorie.setLabel(String categorie1.label );
	        return this.categorieRepository.save(categorie);
	     }
	 public void deleteCategorie(Long id){
		 Categorie categorie=this.categorieRepository.findById(id).orElseThrow(()-> new NotFoundException(" categorie n'existe pas"));
         this.categorieRepository.deleteById(id);
       }
	 public Categorie getOneById(Long id){
		 Categorie categorie=this.categorieRepository.getOne(id);
         return categorie;
     }
	  public Categorie updateCategorie(Long id,Categorie categorie) {
		  Categorie categorie1=this.categorieRepository.findById(id).orElseThrow(()->new NotFoundException("categorie n'existe pas"));
		  categorie1.setLabel(categorie.getLabel());
          
          return categorieRepository.save(categorie1);
       }
	     
	 }
