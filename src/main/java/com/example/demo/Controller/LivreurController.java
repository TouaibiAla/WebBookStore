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

import com.example.demo.entity.Commande;
import com.example.demo.entity.Livreur;
import com.example.demo.service.LivreurService;

@RestController
@RequestMapping("/api")
public class LivreurController {
	@Autowired
	private LivreurService livreurService;
	
	@GetMapping("/livreurs")
	public ResponseEntity<List<Livreur>> getAllLivreurs(){
		return new ResponseEntity<>(this.livreurService.getAllLivreurs(), HttpStatus.OK);
	}
	@GetMapping("/livreurById/{idLivreur}")
    public ResponseEntity<Livreur> getOneById(@PathVariable Long idLivreur){
        return new ResponseEntity<>(this.livreurService.getLivreurById(idLivreur),HttpStatus.OK);
    }
	
	@PostMapping("/addLivreur")
	public ResponseEntity<Livreur> addLivreur(@Validated @RequestBody Livreur livreur){
		return new ResponseEntity<>(this.livreurService.addLivreur(livreur),HttpStatus.CREATED);
	}
	 @DeleteMapping("/livreur/{idLivreur}")
		public ResponseEntity<?> deleteLivreur(@PathVariable Long idLivreur) {
	        this.livreurService.deleteLivreur(idLivreur);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	     }
	/*@DeleteMapping("/livreur/{idLivreur}")
	public ResponseEntity<?> deleteLivreur(@PathVariable Long id) {
        this.livreurService.deleteLivreur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
	
	@PutMapping("/livreur/{idLivreur}")
    public ResponseEntity<Livreur> updateLivreur(@PathVariable Long id,@Validated @RequestBody Livreur livreur) {
        return new ResponseEntity<>(this.livreurService.updateLivreur(id,livreur),HttpStatus.OK);
     }*/
	@PutMapping("/updateLivreur/{idLivreur}")
    public ResponseEntity<Livreur> updateLivreur(@PathVariable Long idLivreur,@Validated @RequestBody Livreur livreur ) {
        return new ResponseEntity<>(this.livreurService.updateLivreur(idLivreur,livreur),HttpStatus.OK);
     }
}
