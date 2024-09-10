
package com.poo.persistencia;

import com.poo.modelo.Pelicula;
import com.poo.recurso.dominio.Configuracion;
import com.poo.recurso.dominio.Ruta;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import unimag.poo.persistencia.ArchivoPlanoNIO;


public class DaoPelicula {
    
    private ArchivoPlanoNIO miArchivo;
    private String nombrePersistencia;

    public DaoPelicula() {
        try {
            nombrePersistencia = Ruta.RUTA_PERSISTENCIA + "\\" + Configuracion.PERSISTENCIA_NOMBRE;
            miArchivo = new ArchivoPlanoNIO(nombrePersistencia);
        } catch (IOException ex) {
            Logger.getLogger(DaoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean insertInto(Pelicula miPeli){
            String cadena;
            boolean correcto = false;
            
        try {
            cadena = miPeli.getNombrePelicula()
                    +Configuracion.SEPARADOR_COLUMNA
                    +miPeli.getProtagonistaPelicula();
            miArchivo.agregarRegistro(cadena);
            correcto = true;
        } catch (IOException ex) {
            Logger.getLogger(DaoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }
    
}
