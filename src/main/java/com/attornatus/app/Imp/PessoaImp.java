
package com.attornatus.app.Imp;

import com.attornatus.app.Entities.Pessoa;
import java.util.List;

/**
 *
 * @author RC_Ventura
 */
public interface PessoaImp {
    
    
      //GET
    public List <Pessoa> findAll();
   
    //GET{id}
    public Pessoa findById (Long id);
    
    //POST
    public Pessoa save (Pessoa pessoa);
      
    //DELETE
    public void delete (Long id);
     
    //PUT
    public Pessoa update (Long id, Pessoa pessoa);
      
    
    
}
