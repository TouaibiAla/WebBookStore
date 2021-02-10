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

import com.example.demo.entity.Livre;
import com.example.demo.service.LivreService;

@RestController
@RequestMapping("/api")
public class LivreController {
	@Autowired
    private LivreService livreService;
	@GetMapping("/livres")
	public ResponseEntity<List<Livre>> getAll() {
        return new ResponseEntity<>(this.livreService.getAll(), HttpStatus.OK);
      }
	@GetMapping("/livres/search={text}")
	public ResponseEntity<List<Livre>> getByAnything(@PathVariable String text){
	return new ResponseEntity<>(this.livreService.getAll(), HttpStatus.OK);
      }
	
	@PostMapping("/addLivre")
	public ResponseEntity<Livre> ajouterLivre(@Validated @RequestBody Livre livre){
        return new ResponseEntity<>(this.livreService.addLivre(livre),HttpStatus.CREATED);
     }
	
	 @DeleteMapping("/deleteLivre/{id}")
	public ResponseEntity<?> deleteLivre(@PathVariable Long id) {
        this.livreService.deleteLivre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

	  @GetMapping("/livreById/{id}")
	    public ResponseEntity<Livre> getOneById(@PathVariable Long id){
		 
	        return new ResponseEntity<>(this.livreService.getOneById(id),HttpStatus.OK);
	    }
	@PutMapping("/updateLivre/{id}")
    public ResponseEntity<Livre> updateLivre(@PathVariable Long id,@Validated @RequestBody Livre livre ) {
        return new ResponseEntity<>(this.livreService.updateLivre(id,livre),HttpStatus.OK);
     }
}