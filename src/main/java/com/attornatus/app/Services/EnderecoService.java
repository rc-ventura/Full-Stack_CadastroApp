
package com.attornatus.app.Services;

import com.attornatus.app.Entities.Endereco;
import com.attornatus.app.Entities.Endereco;
import com.attornatus.app.Entities.Pessoa;
import com.attornatus.app.Imp.EnderecoImp;
import com.attornatus.app.Repositories.EnderecoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RC_Ventura
 */
@Service
public class EnderecoService implements EnderecoImp {

    private final EnderecoRepository  enderecoRepository;
    
    @Autowired
    public EnderecoService (EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }
    
    //GET
    @Override
    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }
        
     //GET {id}
    @Override
    public Endereco findById(Long id) {
       return enderecoRepository.findById(id).get();
    }
    
    //POST
    @Override
    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    //DELETE
    @Override
    public void delete(Long id) {
       enderecoRepository.deleteById(id);
    }

    //PUT
    @Override
    public Endereco update(Long id, Endereco endereco) {
    Endereco enderecoEntity = enderecoRepository.getReferenceById(id);
    enderecoEntity.setLogradouro(endereco.getLogradouro());
    enderecoEntity.setCep(endereco.getCep());
    enderecoEntity.setNumero(endereco.getNumero());
    enderecoEntity.setPrincipal(endereco.getPrincipal());
    enderecoEntity.setCidade(endereco.getCidade());
    enderecoEntity.setPessoa(endereco.getPessoa());
   
    return enderecoRepository.save(enderecoEntity);
    
    }


  
    //SQL
    //GET - Busca personalizada - Todos Enderecos
    public List <Endereco> findByAllEndereco(Long id_pessoa) {
    return enderecoRepository.findByAllEndereco(id_pessoa);
    }    
    
     //GET - Busca personalizada - Endereço Principal
    public Endereco findByPrincipalEndereco(Long id_pessoa) {
    return enderecoRepository.findByPrincipalEndereco(id_pessoa);
    }    
}
