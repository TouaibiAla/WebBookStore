package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommandeRepository;
import com.example.demo.dao.ReclamationRepository;
import com.example.demo.entity.Commande;
import com.example.demo.entity.Etat;
import com.example.demo.entity.Reclamation;
import com.example.demo.entity.User;
import com.example.demo.exception.ConfilctException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.utile.ModifyPassword;

@Service
public class ReclamationService {

	@Autowired
	private ReclamationRepository reclamRepo;
	
	@Autowired
	private CommandeRepository commandeRepo;
	
	@Autowired
	private UserService userService;
	
	/**
     * function
     * @return list of all Reclamations
     */
    public List<Reclamation> getAllReclamation(){
        return this.reclamRepo.findAll();
    }
    
    /**
     *a function taking one argument and returning an object of Reclamation which has the same id of Recalamtion.
     *@param id of the Reclamation
     * @return a List of Reclamation
     */
     public Reclamation getReclamationById(Long id){
        return this.reclamRepo.getOne(id);
    }
    
    /**
     *a function taking one argument and returning an object of Reclamation. the purpose of the function is to a add new Reclamation.
     * @param reclamation an object of Reclamation.
     * @return an object of Reclamation
     */

     public Reclamation addReclamation(Reclamation reclamation) {
    	 return reclamRepo.save(reclamation);
        
     }
     
     /**
      *a function taking one argument and deleting an object of Reclamation which has the same idReclamation.
      *@param idReclamation of the reclamation to delete
      */

       public void deleteReclamation(Long idReclamation){
         Reclamation reclam=this.reclamRepo.findById(idReclamation).orElseThrow(()-> new NotFoundException(" reclamation n'existe pas"));
         this.reclamRepo.deleteById(idReclamation);
       }
       
       /**
        *a function taking two arguments and returning an object of Reclamation updated.
        * @param reclam an object of Reclamation.
        *@param idReclamation of the Reclamation.
        * @return an object of Reclamation updated.
        */
        public Reclamation updateReclamation(Long idReclamation,Reclamation reclam) {
           Reclamation reclam1=this.reclamRepo.findById(idReclamation).orElseThrow(()->new NotFoundException("reclamation n'existe pas"));
           reclam1.setSujet(reclam.getSujet());
           reclam1.setDescription(reclam.getDescription());
           reclam1.setEtat(reclam.getEtat());
           reclam1.setUser(reclam.getUser());
           reclam1.setCommande(reclam.getCommande());
           return reclamRepo.save(reclam1);
        }
        
        /**
         *a function taking one argument and returning a List of all Reclamations which has the same id of User.
         *@param id of the User
         * @return a List of all Reclamations
         */
         public List<Reclamation> getReclamationByUser(Long idUser){
            List<Reclamation> reclamations = new ArrayList<Reclamation>();
            User user = reclamRepo.findByUser(idUser);
            for(Reclamation reclam : user.getReclamation()){
            	reclamations.add(reclam);
            }
            return reclamations;
        }
         
         
         /**
          *a function taking two arguments and returning a list of all Reclamations which has the same id of User and the same etat.
          *@param id of the User
          *@param etat
          * @return a List of all Reclamations
          */
         public List<Reclamation> getReclamationEtatByUser(Long idUser , Etat etat){
        	 List<Reclamation> reclamations = new ArrayList<>();
        	 User user = reclamRepo.findByUser(idUser);
        	 for(Reclamation reclam : user.getReclamation()){
        		 if(reclam.getEtat().equals(etat)){
        			 reclamations.add(reclam);
        		}
        	 }
        	 return reclamations;
         }
        
         /**
          *a function taking one argument and returning a List of all Reclamations which has the same id of Commande.
          *@param id of the Commande
          * @return a List of all Reclamations
          */
         public List<Reclamation> getReclamationByCommande(Long idCommande){
             List<Reclamation> reclamations = new ArrayList<Reclamation>();
             Commande commande = commandeRepo.findById(idCommande).get();
             for(Reclamation reclam : commande.getReclamation()){
             	reclamations.add(reclam);
             }
             return reclamations;
         }
        
         /**
          *a function taking two arguments.
          *@param id of the Commande
          *@param id of the Reclamation
          */
         public void affecterCommandeAReclamation(long idCommande , long idReclamation){
        	 Reclamation reclamation= reclamRepo.findById(idReclamation).get();
        	 Commande commande= commandeRepo.findById(idCommande).get();
        	 reclamation.setCommande(commande);
        	 reclamRepo.save(reclamation);
         }
         
         /**
          * a function taking one argument and returning a nombre of Reclamations by etat
          * @param etat
          * @return integer 
          */
         public int getNombreReclamationByEtat(Etat etat){
        	 return reclamRepo.getNombreReclamationByEtat(etat);
         }
         
        /**
         * a function returning a nombre of all Reclamations
         * @return integer
         */
         public int getNombreReclamation(){
        	 return reclamRepo.getNombreReclamation();
         }
}
