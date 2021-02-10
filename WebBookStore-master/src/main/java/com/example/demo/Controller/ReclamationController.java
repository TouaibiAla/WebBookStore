package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ReclamationRepository;
import com.example.demo.entity.Etat;
import com.example.demo.entity.Reclamation;
import com.example.demo.entity.User;
import com.example.demo.service.ReclamationService;

@RestController
@RequestMapping("/api/user")
public class ReclamationController {

	@Autowired
	private ReclamationService reclamService;
	
	@GetMapping("/reclamations")
	public ResponseEntity<List<Reclamation>> getAllReclamation() {
        return new ResponseEntity<>(this.reclamService.getAllReclamation(), HttpStatus.OK);
      }
	
	@PostMapping("/addReclamation")
	public ResponseEntity<Reclamation> addReclamation(@Validated @RequestBody Reclamation reclam){
        return new ResponseEntity<>(this.reclamService.addReclamation(reclam),HttpStatus.CREATED);
     }
	
	 @DeleteMapping("/deleteReclamation/{id}")
	public ResponseEntity<?> deleteReclamation(@PathVariable Long id) {
        this.reclamService.deleteReclamation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
	 
	 @GetMapping("/reclamationById/{id}")
	 public ResponseEntity<Reclamation> getReclamationById(@PathVariable Long id){
	      return new ResponseEntity<>(this.reclamService.getReclamationById(id),HttpStatus.OK);
	    }
	 
	 @PutMapping("/updateReclamation/{id}")
    public ResponseEntity<Reclamation> updateReclamation(@PathVariable Long id,@Validated @RequestBody Reclamation reclam) {
        return new ResponseEntity<>(this.reclamService.updateReclamation(id, reclam),HttpStatus.OK);
     }
	 
	 @GetMapping("/reclamationByUser/{idUser}")
	 public ResponseEntity<List<Reclamation>> getReclamationByUser(@PathVariable Long idUser){
		 return new ResponseEntity<>(this.reclamService.getReclamationByUser(idUser), HttpStatus.OK);
	 }
	 
	 @GetMapping("/reclamationEtatByUser/{idUser}/{etat}")
	 @ResponseBody
	 public ResponseEntity<List<Reclamation>> getReclamationEtatByUser(@PathVariable("idUser") Long idUser, @PathVariable("etat") Etat etat){
		 return new ResponseEntity<>(this.reclamService.getReclamationEtatByUser(idUser, etat), HttpStatus.OK);
	 }
	 
	 @GetMapping("/reclamationByCommande/{idCommande}")
	 public ResponseEntity<List<Reclamation>> getReclamationByCommande(@PathVariable Long idCommande){
		 return new ResponseEntity<>(this.reclamService.getReclamationByCommande(idCommande), HttpStatus.OK);
	 }
	 
	 @PutMapping("/affecterCommandeAReclamation/{idCommande}/{idReclamation}")
	    public void affecterCommandeAReclamation(@PathVariable("idCommande") Long idCommande,@PathVariable("idReclamation") Long idReclamation) {
	        this.reclamService.affecterCommandeAReclamation(idCommande, idReclamation);
	     }

	 @GetMapping("/nombreReclamationByEtat/{etat}")
	 public ResponseEntity<Integer> getNombreReclamationByEtat(@PathVariable("etat") Etat etat){
		 return new ResponseEntity<>(this.reclamService.getNombreReclamationByEtat(etat), HttpStatus.OK);
	 }
	 
	 @GetMapping("/nombreReclamation")
	 public ResponseEntity<Integer> getNombreReclamation(){
		 return new ResponseEntity<>(this.reclamService.getNombreReclamation(), HttpStatus.OK);
	 }
}
