
package com.attornatus.app.Services;

import com.attornatus.app.Entities.Endereco;
import com.attornatus.app.Entities.Pessoa;
import com.attornatus.app.Imp.PessoaImp;
import com.attornatus.app.Repositories.EnderecoRepository;
import com.attornatus.app.Repositories.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RC_Ventura
 */
@Service
public class PessoaService implements PessoaImp {

    //Injecao de dependência
    private  PessoaRepository  pessoaRepository;
    
    @Autowired
    public PessoaService (PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }
    
    @Autowired
    private EnderecoRepository enderecoRepository;
    
   
    
    //GET
    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }
        
    
    //GET {id}
    @Override
    public Pessoa findById(Long id) {
       return pessoaRepository.findById(id).get();
    }
    
    //POST
    @Override
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    //DELETE
    @Override
    public void delete(Long id) {
       pessoaRepository.deleteById(id);
    }
    
    //PUT
    @Override
    public Pessoa update(Long id, Pessoa pessoa) {
    Pessoa pessoaEntity = pessoaRepository.getReferenceById(id);
    pessoaEntity.setNome(pessoa.getNome());
    pessoaEntity.setDataDeNascimento(pessoa.getDataDeNascimento());
    return pessoaRepository.save(pessoaEntity);
    
    }
    
    //POST FULL
    //Insere uma lista de endereços associada a uma pessoa
    
    public Pessoa insertEnderecos (Pessoa pessoa){
        Pessoa savedPessoa = pessoaRepository.save(pessoa);
        
        for (Endereco endereco: pessoa.getEnderecos()) {
            endereco.setPessoa(savedPessoa);
        }
        
        enderecoRepository.saveAll(pessoa.getEnderecos());
        
        return findById(savedPessoa.getId());
    }
    
    

}
