
package edu.poo.vista.acerca;

import edu.poo.recurso.dominio.Ruta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VistaAcerca {
    private final static String LBL_TEXTO = "#FFFD55";
    private final static String ACERCA_FOTO = "acercaDe01.png";
    private final static String ACERCA_CORREO = "cguerreroalar@gmail.com";
    private final static String COLOR_FONDO = "-fx-backgound-color: #961414";
      
   public static void mostrar(double anchoPanel, double  altoPanel){
          Stage nuevoSceneario = new Stage();
          String ruta = Ruta.RUTA_IMAGENES + ACERCA_FOTO;
          
          VBox miPanel = new VBox(6);
          miPanel.setAlignment(Pos.CENTER);
          miPanel.setPadding(new Insets(10,0,0,0));
          miPanel.setStyle(COLOR_FONDO);
          
          Image miImagen = new Image(ruta);
          ImageView foto = new ImageView(miImagen);
          foto.setFitWidth(200);
          foto.setPreserveRatio(true);
          
          Font fuente = Font.font("Verdana", FontWeight.BOLD, 14);
          Label lblCorreo = new Label(ACERCA_CORREO);
          lblCorreo.setTextFill(Color.web(LBL_TEXTO));
          lblCorreo.setFont(fuente);
          
          Button btnCerrar = new Button("Aceptar");
          btnCerrar.setPrefWidth(160);
          btnCerrar.setOnAction(event-> nuevoSceneario.close());
          
          miPanel.getChildren().addAll(foto, lblCorreo, btnCerrar);
          
          Scene nuevaEscena = new Scene(miPanel, anchoPanel, altoPanel);
          
          nuevoSceneario.setScene(nuevaEscena);
          nuevoSceneario.initStyle(StageStyle.UTILITY);
          nuevoSceneario.initModality(Modality.APPLICATION_MODAL);
          
          nuevoSceneario.setTitle("Acerca de mi...");
          
          nuevoSceneario.show();
      }
}
