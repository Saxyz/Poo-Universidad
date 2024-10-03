package edu.poo.persistencia;

import edu.poo.modelo.Carro;
import edu.poo.recurso.dominio.Configuracion;
import edu.poo.recurso.dominio.Ruta;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import unimag.poo.persistencia.ArchivoPlanoNIO;

public class DAOCarro {

    private ArchivoPlanoNIO miArchivo;
    private String nombrePersistencia;

    public DAOCarro() {
        try {
            nombrePersistencia = Ruta.RUTA_PERSISTENCIA + "\\" + Configuracion.PERSISTENCIA_NOMBRE;
            miArchivo = new ArchivoPlanoNIO(nombrePersistencia);
        } catch (IOException ex) {
            Logger.getLogger(DAOCarro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean insertInto(Carro miCarro) {
        String cadena;
        boolean correcto = false;
        
        try{
            cadena = miCarro.propiedadMarca() + Configuracion.SEPARADOR_COLUMNA +
                    miCarro.propiedadModeloCarro() + Configuracion.SEPARADOR_COLUMNA +
                    miCarro.propiedadDescripcionCarro();
            miArchivo.agregarRegistro(cadena);
            correcto = true;
        }catch(IOException ex){
          Logger.getLogger(DAOCarro.class.getName()).log(Level.SEVERE, null, ex);  
        }
        
        return correcto;
    }

}
