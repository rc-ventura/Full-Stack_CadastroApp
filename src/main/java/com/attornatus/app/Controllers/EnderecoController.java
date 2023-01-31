
package com.attornatus.app.Controllers;

import com.attornatus.app.Entities.Endereco;
import com.attornatus.app.Entities.Endereco;
import com.attornatus.app.Entities.Pessoa;
import com.attornatus.app.Services.EnderecoService;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author RC_Ventura
 */
@RestController
public class EnderecoController {
    
    private final EnderecoService  enderecoService;
    
    @Autowired
    public EnderecoController (EnderecoService enderecoService){
        this.enderecoService = enderecoService;
}
    
    
    //GET
    @GetMapping(value="/enderecos")
    public ResponseEntity <List<Endereco>> findAll() {
        List <Endereco> enderecos = enderecoService.findAll();
        return ResponseEntity.ok().body(enderecos);
    }
 
    //GET{id}
    
    @GetMapping(value= "enderecos/{id}")
    public ResponseEntity <Endereco> findById (@PathVariable Long id){
        Endereco endereco = enderecoService.findById(id);
        return ResponseEntity.ok().body(endereco);
    }     
    
    
    //POST
    
    @PostMapping(value= "enderecos")
    public ResponseEntity <Endereco> save (@RequestBody Endereco endereco){
        Endereco savedEndereco = enderecoService.save(endereco);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path
        ("enderecos/{id}").buildAndExpand(savedEndereco.getId()).toUri();
       return ResponseEntity.created(uri).body(savedEndereco);
        
    }
    
    
    
    
    //PUT
    
    @PutMapping (value = "enderecos/{id}")
    public ResponseEntity <Endereco> update (@RequestBody Endereco endereco, @PathVariable Long id){
        endereco = enderecoService.update(id, endereco);
        return ResponseEntity.ok().body(endereco);
    }
    
    //DELETE
    
    @DeleteMapping (value = "enderecos/{id}")
    public ResponseEntity <String> delete (@PathVariable Long id){
        enderecoService.delete(id);
        return ResponseEntity.ok().body("Endereço deletado com sucesso");
    }
    
    
    
    //SQl
    //Busca por todos endereços associado a uma pessoa
    
    @GetMapping (value = "enderecos/findByEnderecos/{id_pessoa}")
    public ResponseEntity <List <Endereco>> findByAllEndereco (@PathVariable Long id_pessoa){
    List <Endereco> enderecos = enderecoService.findByAllEndereco(id_pessoa);
    return ResponseEntity.ok().body(enderecos);

    }
    
    //SQL
    //Busca por endereço principal
    
    @GetMapping (value = "enderecos/findByPrincipal/{id_pessoa}")
    public ResponseEntity  <Endereco> findByPrincipalEndereco (@PathVariable Long id_pessoa){
     Endereco endereco = enderecoService.findByPrincipalEndereco(id_pessoa);
    return ResponseEntity.ok().body(endereco);

    }
    
}

    
    
    
 
