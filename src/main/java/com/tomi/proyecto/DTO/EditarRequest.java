
package com.tomi.proyecto.DTO;

import com.tomi.proyecto.model.Dato;
import lombok.Data;

@Data
public class EditarRequest {
    
    private Dato dato;
    private String clave;
            
}
