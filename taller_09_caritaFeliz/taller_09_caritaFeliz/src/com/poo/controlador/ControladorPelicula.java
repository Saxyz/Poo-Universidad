
package com.poo.controlador;

import com.poo.modelo.Pelicula;
import com.poo.persistencia.DaoPelicula;

public class ControladorPelicula {
    public static boolean grabar(String nom, String pro){
        boolean correcto = false;
        
        
        DaoPelicula miDao = new DaoPelicula();
        Pelicula miPeli = new Pelicula(nom, pro);
        if (miDao.insertInto(miPeli)) {
            correcto = true;
        }
        return correcto;
    }
}
