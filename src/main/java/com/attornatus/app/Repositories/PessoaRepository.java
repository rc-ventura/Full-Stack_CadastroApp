
package com.attornatus.app.Repositories;

import com.attornatus.app.Entities.Endereco;
import com.attornatus.app.Entities.Pessoa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RC_Ventura
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    
    }
