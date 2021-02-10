package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LivreRepository;
import com.example.demo.entity.Livre;
import com.example.demo.exception.NotFoundException;

@Service
public class LivreService {
	@Autowired
	private LivreRepository livreRepository;
	
	
    public List<Livre> getAll(){
        return this.livreRepository.findAll();
    }
   
    
     public Livre addLivre(Livre livre) {
        
        return  this.livreRepository.save(livre);
     }
     
 

       public void deleteLivre(Long id){
    	  Livre livre=this.livreRepository.findById(id).orElseThrow(()-> new NotFoundException("Livre n'existe pas"));
         this.livreRepository.deleteById(id);
       }
       public void deleteLivreByName(String name){
		  Livre livre=this.livreRepository.findByNomLivre(name);
		 this.livreRepository.deleteById((long) livre.getIdLivre());		 
	   }
      
     
       public Livre getOneById(Long id){
    	   Livre livre=this.livreRepository.getOne(id);
           return livre;
       }
	   public Livre getOneByName(String name){
    	   Livre livre=this.livreRepository.findByNomLivre(name);
           return livre;
       }
      /* public List<Livre> getByAnything(String text)
	       return this.livreRepository.findByAnything(text);
          
       }*/
     
        public Livre updateLivre(Long id,Livre livre) {
        	Livre l=this.livreRepository.findById(id).orElseThrow(()->new NotFoundException("Livre n'existe pas"));
        	l.setNomLivre(livre.getNomLivre());
        	l.setAuteur(livre.getAuteur());
        	l.setEdition((livre.getEdition()));
			l.setPrix(livre.getPrix());
        	l.setDateCreation(livre.getDateCreation());
        	//l.setCategorie(livre.getCategorie());
			l.setStock(livre.getStock());
           return livreRepository.save(l);
        }
}