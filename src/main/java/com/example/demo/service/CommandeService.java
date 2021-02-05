package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommandeRepository;
import com.example.demo.entity.Commande;
import com.example.demo.exception.NotFoundException;

@Service
public class CommandeService {
	@Autowired
	private CommandeRepository commandeRepository;
	/**
     * function
     * @return list of all Commande
     */
    public List<Commande> getAll(){
        return this.commandeRepository.findAll();
    }
   
    
    /**
     *a function taking one argument and returning an object of Commande. the purpose of the function is to a add new Commande.
     * @param commande an object of Commande.
     * @return an object of Commande
     */

     public Commande addCommande(Commande commande) {
        
        return  this.commandeRepository.save(commande);
     }
     
     /**
      *a function taking one argument and deleting an object of Commande which has the same id.
      *@param id of the commande to delete
      */

       public void deleteCommande(Long id){
    	  Commande commande=this.commandeRepository.findById(id).orElseThrow(()-> new NotFoundException(" commande n'existe pas"));
         this.commandeRepository.deleteById(id);
       }
       
      
       /**
        *a function taking one argument and returning an object of Commande which has the same id.
        *@param id of the Commande
        * @return an object of Commande
        */
       public Commande getOneById(Long id){
    	   Commande commande=this.commandeRepository.getOne(id);
           return commande;
       }
       
       /**
        *a function taking two arguments and returning an object of Commande updated.
        * @param commande an object of Commande.
        *@param id of the Commande.
        * @return an object of Commande updated.
        */
        public Commande updateCommande(Long id,Commande commande) {
        	Commande commande1=this.commandeRepository.findById(id).orElseThrow(()->new NotFoundException("commande n'existe pas"));
        	commande1.setDate(commande.getDate());
        	commande1.setEtat(commande.getEtat());
        	commande1.setPrix(commande.getPrix());
           return commandeRepository.save(commande1);
        }
}
