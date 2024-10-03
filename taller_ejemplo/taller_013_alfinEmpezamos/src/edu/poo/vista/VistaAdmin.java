
package edu.poo.vista;

import edu.poo.recurso.dominio.Configuracion;
import edu.poo.recurso.dominio.Contenedor;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VistaAdmin {
  private final Scene miEscena;
  private final Stage miEscenario;
  private final Pane panelCuerpo;
  private final HBox panelCabecera;
  private final BorderPane panelPrincipal;

    public VistaAdmin() {
        miEscenario = new Stage();
        panelCuerpo = new Pane();
        panelPrincipal = new BorderPane();
        
       VistaMenuCabecera vistaCabecera = new VistaMenuCabecera(miEscenario, panelPrincipal, panelCuerpo, Configuracion.ANCHO_APP
               , Contenedor.ALTO_CABECERA.getValor());
       
       panelCabecera = vistaCabecera.getPanelCabecera();
       panelCuerpo.setPrefHeight(Contenedor.ALTO_CUERPO.getValor());
       
       panelPrincipal.setTop(panelCabecera);
       panelPrincipal.setCenter(panelCuerpo);
       
       miEscena = new Scene(panelPrincipal, Configuracion.ANCHO_APP, Configuracion.ALTO_APP); 
       miEscenario.setScene(miEscena);
    }

    public Stage getMiEscenario() {
        return miEscenario;
    }

 
  
  
}
