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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ReclamationRepository;
import com.example.demo.entity.Reclamation;
import com.example.demo.entity.User;
import com.example.demo.service.ReclamationService;

@RestController
@RequestMapping("/api/user")
public class ReclamationController {

	@Autowired
	private ReclamationService reclamService;
	
	@GetMapping("/reclamations")
	public ResponseEntity<List<Reclamation>> getAll() {
        return new ResponseEntity<>(this.reclamService.getAllReclamation(), HttpStatus.OK);
      }
	
	@PostMapping("/addReclamation")
	public ResponseEntity<Reclamation> addReclamation(@Validated @RequestBody Reclamation reclam){
        return new ResponseEntity<>(this.reclamService.addReclamation(reclam),HttpStatus.CREATED);
     }
	
	 @DeleteMapping("/reclamation/{id}")
	public ResponseEntity<?> deleteReclamation(@PathVariable Long id) {
        this.reclamService.deleteReclamation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
	 
	/* @GetMapping("/reclamationById/{id}")
	    public ResponseEntity<Reclamation> getReclamationByIdUser(@PathVariable Long id){
	        return new ResponseEntity<>(this.reclamService.getReclamationByIdUser(id),HttpStatus.OK);
	    }*/
	 
	 @PutMapping("/reclamation/{id}")
    public ResponseEntity<Reclamation> updateReclamation(@PathVariable Long id,@Validated @RequestBody Reclamation reclam) {
        return new ResponseEntity<>(this.reclamService.updateReclamation(id, reclam),HttpStatus.OK);
     }
	
	
}
