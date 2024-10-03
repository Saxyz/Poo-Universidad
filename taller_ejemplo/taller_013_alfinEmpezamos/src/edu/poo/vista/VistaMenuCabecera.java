
package edu.poo.vista;

import edu.poo.controlador.ControladorCarroVentana;
import edu.poo.recurso.dominio.Configuracion;
import edu.poo.recurso.dominio.Contenedor;
import edu.poo.vista.acerca.VistaBotonAcerca;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class VistaMenuCabecera extends SubScene{
    private final int btnTamanioX = 120;
    private final int btnTamanioY = 20;
   private final int btnEspacioX = 20;
   
   private Pane panelCuerpo;
   private final HBox panelCabecera;
   private final Stage miEscenario;
   private final BorderPane panelPrincipal;

    public VistaMenuCabecera(Stage esce,BorderPane princi,Pane pane, double anchoPanel, double altoPanel) {
        super(new HBox(), anchoPanel, altoPanel);
        panelCabecera = (HBox) this.getRoot();
        miEscenario = esce;
        panelPrincipal = princi;
        panelCuerpo = pane;
        
        panelCabecera.setSpacing(btnEspacioX);
        panelCabecera.setPadding(new Insets(15,10,15,10));
        panelCabecera.setPrefHeight(Contenedor.ALTO_CABECERA.getValor());
        panelCabecera.setStyle(Configuracion.CABECERA_COLOR_FONDO);
        
        crearBotones();
                
    }

    private void crearBotones() {
        btnCarroCrear("CrearCarros");
        btnCarroListar("listar carros");
        btnCarroDetalle("detalle fotos");
        btnCarroSalir("salir");
        btnAcerca(Configuracion.ACERCA_ANCHO,  
                Configuracion.ACERCA_ALTO);

      
    }

    private void agregarBtnCabeccera(Button boton){
        boton.setCursor(Cursor.HAND);
        boton.setPrefSize(btnTamanioX, btnTamanioY);
        
        panelCabecera.getChildren().add(boton);
    }
    private void btnCarroCrear(String titulo) {
        Button btnCrear = new Button(titulo);
        btnCrear.setOnAction((t)->{
            panelCuerpo = ControladorCarroVentana.carroCrear(
            Configuracion.ANCHO_APP, Contenedor.ALTO_CUERPO.getValor());
            panelPrincipal.setCenter(null);
            panelPrincipal.setCenter(panelCuerpo);
        });
        
        agregarBtnCabeccera(btnCrear);
    }

    private void btnCarroListar(String titulo) {
           Button btnListar = new Button(titulo);
        btnListar.setOnAction((t)->{
            System.out.println("hiciste clip en listar jejejejejejejejeje");
        });
        
        agregarBtnCabeccera(btnListar);
    }

    private void btnCarroDetalle(String titulo) {
      Button btnDetalle = new Button(titulo);
        btnDetalle.setOnAction((t)->{
            System.out.println("hiciste clip en detalle jejejejejejejejeje");
        });
        
        agregarBtnCabeccera(btnDetalle);
    }
   
     private void btnCarroSalir(String titulo) {
            Button btnSalir = new Button(titulo);
        btnSalir.setOnAction((t)->{
            System.out.println("ah");
        });
        
        agregarBtnCabeccera(btnSalir); 
        }

    private void btnAcerca(Double ancho, Double alto) {
        VistaBotonAcerca btnAcerca = new VistaBotonAcerca(ancho, alto);
        panelCabecera.getChildren().add(btnAcerca);
        
        StackPane panelIcono = btnAcerca.obtener();
        panelCabecera.getChildren().add(panelIcono);
        HBox.setHgrow(panelIcono, Priority.ALWAYS);
        
//         agregarBtnCabeccera(btnAcerca); 
    }

    public HBox getPanelCabecera() {
        return panelCabecera;
    }
}
