
package com.poo.aplicacion;

import com.poo.controlador.ControladorSalida;
import com.poo.recurso.dominio.Configuracion;
import com.poo.recurso.dominio.Ruta;
import com.poo.vista.VistaAdmin;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Principal extends Application {
    private VistaAdmin adminVista;

    public Principal() {
    }
    
    public static void main(String[] args) {
        launch();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        String rutaIcono = Ruta.RUTA_IMAGENES + Configuracion.ICONO_APP;
        Image inconito = new Image(getClass().getResourceAsStream(rutaIcono));
        
        adminVista = new VistaAdmin();
        stage = adminVista.getMiEscenario();
        stage.setTitle("APP");
        stage.getIcons().add(inconito);
        stage.show();
        
        habilitaLaX(stage);
    }
    
    private void habilitaLaX(Stage miEsce){
        miEsce.setOnCloseRequest((event)->{
        event.consume();
            ControladorSalida.verificar(miEsce);
        });
    }
    
}
