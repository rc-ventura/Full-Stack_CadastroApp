
package com.attornatus.app.Util;

import com.attornatus.app.Entities.Endereco;
import com.attornatus.app.Entities.Pessoa;
import com.attornatus.app.Repositories.EnderecoRepository;
import com.attornatus.app.Repositories.PessoaRepository;
import java.time.Instant;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author RC_Ve
 */
@Configuration
@Profile("test")
public class Setup implements CommandLineRunner {

    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    
    
    
    @Override
    public void run(String... args) throws Exception {
        
    
   
    Pessoa pessoa1 = new Pessoa (null, "Rafael Ventura", "1985-02-20", null );
    Pessoa pessoa2 = new Pessoa (null, "Alice Maravilha", "2000-03-20", null );
    Pessoa pessoa3 = new Pessoa (null, "Laura Bender", "1994-01-10", null );
    Pessoa pessoa4 = new Pessoa (null, "Amadeu Santos","2010-07-08", null );
    Pessoa pessoa5 = new Pessoa (null, "Carlos Nobrega","1980-11-01", null );

    pessoaRepository.saveAll(Arrays.asList(pessoa1,pessoa2,pessoa3,pessoa4,pessoa5)); //salvando tudo


    Endereco endereco1 = new Endereco ( "Rua Pedro II", 87056125, 100, "Florianopolis", true, pessoa1);
    Endereco endereco2 = new Endereco ( "Rua Ixtepô II", 82056225, 1252, "Florianopolis", false, pessoa1);
    Endereco endereco3 = new Endereco ( "Rua Berbigao II", 98056025, 005, "Balneário Camboriú", true, pessoa2);
    Endereco endereco4 = new Endereco ( "Rua Infante Dom Henrique II", 00056025, 347, "Rio de Janeiro", true, pessoa3);
    Endereco endereco5 = new Endereco ( "Rua Heróis do Ar ", 10056025,2500, "São Paulo", false, pessoa4);
    Endereco endereco6 = new Endereco ( "Rua Pedro I", 88056300, 1000, "São Paulo", true, pessoa4);
    Endereco endereco7 = new Endereco ( "Rua Dom João VI", 10016025, 0, "Rio de Janeiro", false, pessoa3);
    Endereco endereco8 = new Endereco ( "Rua Torta", 21610330, 001, "Florianopolis", true, pessoa5);
    Endereco endereco9 = new Endereco ( "Av Gramado", 22610500, 200, "Florianopolis", false, pessoa5);

    enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2,endereco3,endereco4,
            endereco5,endereco6,endereco7,endereco8,endereco9)); //salvando tudo

    
    //pessoa1.getEndereco().add(endereco9)
    
    
    }
    
}
    
    
    

