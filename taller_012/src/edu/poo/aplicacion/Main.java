package edu.poo.aplicacion;

import edu.poo.recurso.dominio.Configuracion;
import edu.poo.recurso.dominio.Ruta;
import edu.poo.vista.VistaAdmin;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
    private VistaAdmin vistaAdmin;

    public Main() {
    }
    
    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage stage) throws Exception {
        String icono = Ruta.RUTA_IMAGENES + Configuracion.ICONO_APP;
        Image image = new Image(getClass().
                getResourceAsStream(icono));
        
        vistaAdmin = new VistaAdmin();
        stage = vistaAdmin.getStage();
        stage.setTitle("APP");
        stage.getIcons().add(image);
        stage.show();
    }
}
