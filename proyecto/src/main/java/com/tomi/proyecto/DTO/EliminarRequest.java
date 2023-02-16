
package com.tomi.proyecto.DTO;

import com.tomi.proyecto.model.Dato;
import lombok.Data;

@Data
public class EliminarRequest {
      
    private long dato;
    private String clave;
    
}
