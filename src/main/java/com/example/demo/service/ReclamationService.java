package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ReclamationRepository;
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
	private UserService userService;
	
	/**
     * function
     * @return list of all Reclamations
     */
    public List<Reclamation> getAllReclamation(){
        return this.reclamRepo.findAll();
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
        *a function taking one argument and returning an object of Reclamation which has the same id of User.
        *@param id of the User
        * @return a List of Reclamation
        */
      /* public List<Reclamation> getReclamationByIdUser(Long id){
           return this.reclamRepo.getOne(this.userService.getOneById(id).getId());
       }*/
       
       /**
        *a function taking two arguments and returning an object of Reclamation updated.
        * @param reclam an object of Reclamatio,.
        *@param idReclamation of the Reclamation.
        * @return an object of Reclamation updated.
        */
        public Reclamation updateReclamation(Long idReclamation,Reclamation reclam) {
           Reclamation reclam1=this.reclamRepo.findById(idReclamation).orElseThrow(()->new NotFoundException("reclamation n'existe pas"));
           reclam1.setSujet(reclam.getSujet());
           reclam1.setDescription(reclam.getDescription());
           reclam1.setIdUtilisateur(reclam.getIdUtilisateur());
           return reclamRepo.save(reclam1);
        }
}
