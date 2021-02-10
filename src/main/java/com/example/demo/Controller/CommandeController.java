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
import com.example.demo.entity.User;
import com.example.demo.service.CommandeService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class CommandeController {
	@Autowired
    private CommandeService commandeService;
	@GetMapping("/commandes")
	public ResponseEntity<List<Commande>> getAll() {
        return new ResponseEntity<>(this.commandeService.getAll(), HttpStatus.OK);
      }
	@GetMapping("/commandeByUserId")
    public ResponseEntity<List<Commande>> getAllbyUserId(@Validated @RequestBody User user){
		
        return new ResponseEntity<>(this.commandeService.getAllbyUserId(user),HttpStatus.OK);
    }
	
	@PostMapping("/addCommande")
	public ResponseEntity<Commande> addCommande(@Validated @RequestBody Commande commande){
        return new ResponseEntity<>(this.commandeService.addCommande(commande),HttpStatus.CREATED);
     }
	
	 @DeleteMapping("/commande/{id}")
	public ResponseEntity<?> deleteCommande(@PathVariable Long id) {
        this.commandeService.deleteCommande(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
	 
	 @GetMapping("/commandeById/{id}")
	    public ResponseEntity<Commande> getOneById(@PathVariable Long id){
		 
	        return new ResponseEntity<>(this.commandeService.getOneById(id),HttpStatus.OK);
	    }
	 
	 @PutMapping("/updateCommande/{id}")
    public ResponseEntity<Commande> updateCommonde(@PathVariable Long id,@Validated @RequestBody Commande commande ) {
        return new ResponseEntity<>(this.commandeService.updateCommande(id,commande),HttpStatus.OK);
     }
}
