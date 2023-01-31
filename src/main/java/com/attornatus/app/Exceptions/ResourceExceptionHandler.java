
package com.attornatus.app.Exceptions;

import java.sql.SQLException;
import java.time.Instant;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.ufsc.curso.AulaSpringBoot.Exceptions.StandardError;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author RC_Ventura
 */

@ControllerAdvice 
public class ResourceExceptionHandler {
    
    
    
    
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFound(EntityNotFoundException ex ) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( ex.getMessage()); //criando uma classe log posso colocar timestamp
    }
    
    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    public ResponseEntity<String> emptyResultDataAccess(EmptyResultDataAccessException ex ) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( "acesso aos dados de resultado vazio\n" + ex.getMessage());
    }

    //excecoes de relacionamentos
    
     @ExceptionHandler({DataIntegrityViolationException.class, ConstraintViolationException.class, SQLException.class})
     public ResponseEntity<StandardError> dataIntegrityViolationException(Exception ex, HttpServletRequest request ) {
        
         HttpStatus status = HttpStatus.NOT_FOUND;
         String path = request.getRequestURI(); // HttpServletRequest = classe que armazena as requisições 
        
        StandardError standard = new StandardError (Instant.now(), status.value(), ex.getMessage(), path);   // metodo value faz a conversao da classe HttpStatus para um int
        
        return  ResponseEntity.status(status).body( standard);
         
        
    
}   

}

