
package com.tomi.proyecto.repository;

import com.tomi.proyecto.model.Dato;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DatoRepository extends JpaRepository<Dato,Long>{
    
    /*
        @Transactional
        @Modifying(clearAutomatically = true)
        @Query(value = 
                "UPDATE superdatos SET "
                + "link=:link,"
                + "numero=:numero,"
                + "rutaimagen=:rutaimagen,"
                + "texto=:texto,"
                + "titulo=:titulo  "
                + "WHERE id = :id", nativeQuery = true)
        void editarDato(@Param("id") long id,
                        @Param("link") String link,
                        @Param("numero") int  numero,
                        @Param("rutaimagen") String rutaimagen,
                        @Param("texto") String texto,
                        @Param("titulo") String titulo);
  */
       // @Query(value = "UPDATE superdatos SET link=:nd.link,numero=:nd.numero,rutaimagen=:nd.rutaimagen,texto=:nd.texto,titulo=:nd.titulo  WHERE id = :nd.id", nativeQuery = true)
        //void editarDato(@Param("nd") Dato nd); //no funciona
        
    
    
    
}
