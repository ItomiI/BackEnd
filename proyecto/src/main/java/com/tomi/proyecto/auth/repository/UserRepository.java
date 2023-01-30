
package com.tomi.proyecto.auth.repository;

import com.tomi.proyecto.auth.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User,Long>{
    
    
    
     @Query(value = "SELECT * FROM usuario WHERE contra = ?1 AND nombre = ?2", nativeQuery = true)
    Optional<User> buscarUser(String contra, String nombre);
    
    @Query(value = "SELECT * FROM usuario WHERE nombre = ?1", nativeQuery = true)
    Optional<User> verificarUser(String nombre);
    
}
