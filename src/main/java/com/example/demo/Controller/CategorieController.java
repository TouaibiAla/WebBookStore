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

import com.example.demo.entity.Categorie;
import com.example.demo.service.CategorieService;


@RestController
@RequestMapping("/api")
public class CategorieController {
	
	@Autowired
    private CategorieService categorieService;
	@GetMapping("/Categories")
	public ResponseEntity<List<Categorie>> getAll() {
        return new ResponseEntity<>(this.categorieService.getAll(), HttpStatus.OK);
      }
	@PostMapping("/addCategorie")
	public ResponseEntity<Categorie> addCategorie(@Validated @RequestBody Categorie categorie){
        return new ResponseEntity<>(this.categorieService.addCategorie(categorie),HttpStatus.CREATED);
	}
	 @DeleteMapping("/Categorie/{id}")
	public ResponseEntity<?> deleteCategorie(@PathVariable Long id) {
       this.categorieService.deleteCategorie(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	 @GetMapping("/CategorieById/{id}")
	    public ResponseEntity<Categorie> getOneById(@PathVariable Long id){
		 
	        return new ResponseEntity<>(this.categorieService.getOneById(id),HttpStatus.OK);
	    }
	 @PutMapping("/Categorie/{id}")
	    public ResponseEntity<Categorie> updateUser(@PathVariable Long id,@Validated @RequestBody Categorie categorie) {
	        return new ResponseEntity<>(this.categorieService.updateCategorie(id,categorie),HttpStatus.OK);
	     }
}
