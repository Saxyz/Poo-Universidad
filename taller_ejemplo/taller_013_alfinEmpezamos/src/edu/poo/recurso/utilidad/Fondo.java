
package edu.poo.recurso.utilidad;

import edu.poo.recurso.dominio.Ruta;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;

public class Fondo {
    public static Background asignar(String nombreFondo, double alto, double ancho){
        String rutaFondo = Ruta.RUTA_IMAGENES + nombreFondo;
        Image img = new Image(rutaFondo, ancho, alto, false, true);
        BackgroundImage fondoListo = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT ,
                BackgroundPosition.DEFAULT, null);
        return new Background(fondoListo);
    }
}
