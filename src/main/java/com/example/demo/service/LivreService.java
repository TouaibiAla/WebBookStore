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
        return this.LivreRepository.findAll();
    }
   
    
     public Livre addLivre(Livre livre) {
        
        return  this.livreRepository.save(Livre);
     }
     
 

       public void deleteLivre(Long id){
    	  Livre livre=this.livreRepository.findById(id).orElseThrow(()-> new NotFoundException("Livre n'existe pas"));
         this.livreRepository.deleteById(id);
       }
       public void deleteLivreByName(String name){
		  Livre livre=this.livreRepository.findByNomLivre(name).orElseThrow(()-> new NotFoundException("Livre n'existe pas"));
		 this.livreRepository.deleteById(livre.getId());		 
	   }
      
     
       public Livre getOneById(Long id){
    	   Livre livre=this.livreRepository.getOne(id);
           return livre;
       }
	   public Livre getOneByName(String name){
    	   Livre livre=this.livreRepository.findByNomLivre(name);
           return livre;
       }
       public List<Livre> getByAnything(String text)
	       return this.livreRepository.findByAnything(text);
          
       }
     
        public Livre updateLivre(Long id,Livre livre) {
        	Livre l=this.LivreRepository.findById(id).orElseThrow(()->new NotFoundException("Livre n'existe pas"));
        	l.setnomLivre(livre.nomLivre());
        	l.setAuteur(livre.getAuteur());
        	l.setEdision(livre.getEdision());
			l.setPrix(livre.getPrix());
        	l.setDateCreation(livre.getDateCreation());
        	l.setCategorie(livre.getCategorie());
			l.setStock(livre.getStock());
           return livreRepository.save(l);
        }
}