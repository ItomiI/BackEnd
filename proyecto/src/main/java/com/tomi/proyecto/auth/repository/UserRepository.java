
package com.tomi.proyecto.auth.repository;

import com.tomi.proyecto.auth.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User,Long>{
    
    
    
    @Query(value = "SELECT * FROM usuario WHERE usuario = ?1", nativeQuery = true)
    Optional<User> verSiExisteUser(String usuario);
    
    @Query(value = "SELECT * FROM usuario WHERE usuario = ?1 AND contra = ?2", nativeQuery = true)
    Optional<User> Logear(String user,String pass);
    
    
    
    
    

    
}
