
package edu.poo.recurso.utilidad;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Efecto {
    public static void transicionX(Pane contendor, double segundos){
        TranslateTransition cambio = new TranslateTransition();
        cambio.setDuration(Duration.seconds(segundos));
        cambio.setNode(contendor);
        cambio.setToX(0);
        cambio.play();
    }
    
    public static void transicionY(Pane contendor, double segundos){
        TranslateTransition cambio = new TranslateTransition();
        cambio.setDuration(Duration.seconds(segundos));
        cambio.setNode(contendor);
        cambio.setToY(0);
        cambio.play(); 
    }
}
