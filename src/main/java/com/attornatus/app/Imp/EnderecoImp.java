
package com.attornatus.app.Imp;

import com.attornatus.app.Entities.Endereco;
import com.attornatus.app.Entities.Pessoa;
import java.util.List;

/**
 *
 * @author RC_Ventura
 */

public interface EnderecoImp {
    
    
      //GET
    public List <Endereco> findAll();
   
    //GET{id}
    public Endereco findById (Long id);
    
    //POST
    public Endereco save (Endereco endereco);
      
    //DELETE
    public void delete (Long id);
     
    //PUT
    public Endereco update (Long id, Endereco endereco);
      
    
    
}
