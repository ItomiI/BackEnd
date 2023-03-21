package com.tomi.proyecto.service;

import com.tomi.proyecto.model.Dato;
import com.tomi.proyecto.model.Tipodato;
import java.util.List;


public interface MiService {
    Dato saveDato(Dato dato);
    Dato getDatobyid(long id);
    Tipodato saveTipodato(Tipodato tipodato);
    Tipodato getTipodatobyid(long id);
    void DeleteTipodatobyid(long id);
    void DeleteDatobyid(long id);
    List<Dato> getAllDatos();
    Dato editarDato(Dato dato);
    List<Tipodato> getTipoDatos();
}
