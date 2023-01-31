
package com.attornatus.app.Controllers;

import com.attornatus.app.Entities.Pessoa;
import com.attornatus.app.Services.PessoaService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author RC_Ventura
 */
@RestController
public class PessoaController {
    
    private  PessoaService  pessoaService;
    
    //Injeção de Dependência
   
    @Autowired
    public PessoaController (PessoaService pessoaService){
        this.pessoaService = pessoaService;
}
    
    
    //GET
    @GetMapping(value="/pessoas")
    public ResponseEntity <List<Pessoa>> findAll() {
        List <Pessoa> pessoas = pessoaService.findAll();
        return ResponseEntity.ok().body(pessoas);
    }
    
    
 
   //GET{id}
    
    @GetMapping(value= "pessoas/{id}")
    public ResponseEntity <Pessoa> findById (@PathVariable Long id){
        Pessoa pessoa = pessoaService.findById(id);
        return ResponseEntity.ok().body(pessoa);
    }     
    
    
    //POST
    
    @PostMapping(value= "pessoas")
    public ResponseEntity <Pessoa> save (@RequestBody Pessoa pessoa){
        Pessoa savedPessoa = pessoaService.save(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path
        ("pessoas/{id}").buildAndExpand(savedPessoa.getId()).toUri();
       return ResponseEntity.created(uri).body(savedPessoa);
        
    }
    
    //Post
    //Endpoint para criar uma lista de enderecos associada a uma pessoa
    
     @PostMapping(value= "pessoas/addEnderecos")
    public ResponseEntity <Pessoa> insertEnderecos (@RequestBody Pessoa pessoa){
        Pessoa savedPessoa = pessoaService.insertEnderecos(pessoa);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path
        ("pessoas/{id}").buildAndExpand(savedPessoa.getId()).toUri();
       return ResponseEntity.created(uri).body(savedPessoa);
    }
    
    
    //PUT
    
    @PutMapping (value = "pessoas/{id}")
    public ResponseEntity <Pessoa> update (@RequestBody Pessoa pessoa, @PathVariable Long id){
        pessoa = pessoaService.update(id, pessoa);
        return ResponseEntity.ok().body(pessoa);
    }
    
    //DELETE
    
    @DeleteMapping (value = "pessoas/{id}")
    public ResponseEntity <String> delete (@PathVariable Long id){
        pessoaService.delete(id);
        return ResponseEntity.ok().body("Pessoa deletada com sucesso");
    }
}
