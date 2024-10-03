
package edu.poo.controlador;

import edu.poo.modelo.Carro;
import edu.poo.persistencia.DAOCarro;
import edu.poo.recurso.utilidad.Efecto;
import edu.poo.vista.carro.VistaCarroCrear;
import javafx.scene.layout.StackPane;


public class ControladorCarroVentana {
    
    public static StackPane carroCrear(double ancho, double alto){
        VistaCarroCrear carroCreSub = new  VistaCarroCrear(ancho, alto);
        StackPane contenedor = carroCreSub.getMiStackPane();
        
        Efecto.transicionX(contenedor, 1.5);
        
        return contenedor;
    }
    
     public static boolean grabar(String mar, String mod, String desc){
        boolean correcto = false;
        
        
         DAOCarro miDao = new DAOCarro();
         Carro miCarro = new Carro(mar, mod, desc);
        if (miDao.insertInto(miCarro)) {
            correcto = true;
        }
        return correcto;
    }
}
