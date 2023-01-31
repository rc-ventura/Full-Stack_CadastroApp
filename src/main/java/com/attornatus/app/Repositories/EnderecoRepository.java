
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
public interface EnderecoRepository extends JpaRepository <Endereco, Long> {
    
    @Query(value= " SELECT * FROM ENDERECO WHERE PESSOA_ID  LIKE %?1", nativeQuery = true)
    List <Endereco> findByAllEndereco (Long id_pessoa);
    
    @Query(value = "SELECT * FROM ENDERECO WHERE PESSOA_ID LIKE %?1 AND PRINCIPAL = TRUE", nativeQuery = true)
     Endereco  findByPrincipalEndereco (Long id_pessoa);
    
    
    
    
    
}
