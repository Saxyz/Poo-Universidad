
package com.poo.vista;

import com.poo.controlador.ControladorPelicula;
import com.poo.recurso.dominio.Configuracion;
import com.poo.recurso.utilidad.Mensaje;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaAdmin {
    private final Scene miEscena;
    private final Stage miEscenario;
    private final StackPane panelPrincipal;
    
    private double anchoMarco;
    private double altoMarco;
    
    private double xPosMarco;
    private double yPosMarco;

    public VistaAdmin() {
        miEscenario = new Stage();
        panelPrincipal = new StackPane();
        panelPrincipal.setAlignment(Pos.TOP_CENTER);
        
        construirFormulario();
        
        miEscena = new Scene(panelPrincipal, 
                Configuracion.ANCHO_APP, Configuracion.ALTO_APP);
        miEscenario.setScene(miEscena);
    }

    public Stage getMiEscenario() {
        return miEscenario;
    }

    private void construirFormulario() {
        anchoMarco = Configuracion.ANCHO_APP * 0.70;
        altoMarco = Configuracion.ALTO_APP * 0.70;
        
        xPosMarco = -(Configuracion.ANCHO_APP/2) + 
                ((Configuracion.ANCHO_APP - anchoMarco)/2);
        yPosMarco = (Configuracion.ALTO_APP/2) - (altoMarco/2);
        
        pintarMarco();
        pintarTitulo();
        pintarFormulario();
    }

    private void pintarMarco() {
        Rectangle figRectangle = new Rectangle(anchoMarco,altoMarco);
        figRectangle.setFill(Color.web("#ff5733"));
        figRectangle.setTranslateY(yPosMarco);
        panelPrincipal.getChildren().add(figRectangle);
    }
        
    private void pintarTitulo() {
        Label lblTitulo = new Label("Las peliculas");
        lblTitulo.setFont(new Font("Arial", 26));
        
        lblTitulo.setPrefHeight(30);
        lblTitulo.setTextFill(Color.web("#2e4053"));
        lblTitulo.setTranslateY(yPosMarco - lblTitulo.getPrefHeight());
        
        panelPrincipal.getChildren().add(lblTitulo);
    }
    
    private void pintarFormulario() {
        Label lblPelicula = new Label("Nombre pelicula: ");
        lblPelicula.setPrefHeight(25);
        lblPelicula.setPrefWidth(170);
        lblPelicula.setFont(new Font("Arial", 20));
        lblPelicula.setTextFill(Color.web("#1f618d"));
        lblPelicula.setTranslateX(xPosMarco + lblPelicula.getPrefWidth());
        lblPelicula.setTranslateY((yPosMarco + lblPelicula.getPrefHeight()) * 1);
        
        Label lblProtagonista = new Label("El protagonista: ");
        lblProtagonista.setPrefHeight(25);
        lblProtagonista.setPrefWidth(170);
        lblProtagonista.setFont(new Font("Arial", 20));
        lblProtagonista.setTextFill(Color.web("#1f618d"));
        lblProtagonista.setTranslateX(xPosMarco + lblPelicula.getPrefWidth());
        lblProtagonista.setTranslateY((yPosMarco + lblPelicula.getPrefHeight()) * 1.5);
        
        TextField cajaNombre = new TextField();
        cajaNombre.setMaxWidth(150);
        cajaNombre.setTranslateX(120);
        cajaNombre.setTranslateY((yPosMarco + lblPelicula.getPrefHeight()) * 1);
        
        TextField cajaProta = new TextField();
        cajaProta.setMaxWidth(150);
        cajaProta.setTranslateX(120);
        cajaProta.setTranslateY((yPosMarco + lblPelicula.getPrefHeight()) * 1.5);
        
        Button btnGrabar = new Button("Grabar la pelicula");
        btnGrabar.setMaxWidth(200);
        btnGrabar.setTranslateX(100);
        btnGrabar.setTranslateY((yPosMarco + lblPelicula.getPrefHeight()) * 2);
        
        btnGrabar.setOnAction((t)->{
            if (cajasLlenas(cajaNombre, cajaProta)) {
                if (ControladorPelicula.grabar(cajaNombre.getText(), cajaProta.getText())) {
                    cajaNombre.setText("");
                    cajaProta.setText("");
                    cajaNombre.requestFocus();
                    Mensaje.modal(Alert.AlertType.INFORMATION, null, "Lo lo logre", "Mama estoy triunfando");
                } else {
                    Mensaje.modal(Alert.AlertType.ERROR, null, "Pailas", "Ayyyy, snifffff");
                }
            } 
        });
        
        panelPrincipal.getChildren().addAll(lblPelicula, lblProtagonista, 
                cajaNombre, cajaProta, btnGrabar);
    }
    
    private boolean cajasLlenas(TextField caja1,TextField caja2){
        boolean siga = false;
        if (caja1.getText().isBlank()) {
            caja1.requestFocus();
            Mensaje.modal(Alert.AlertType.WARNING, null, "PAILAS", "compita pon el nombre");
        } else {
            if(caja2.getText().isBlank()){
                caja2.requestFocus();
                Mensaje.modal(Alert.AlertType.WARNING, null, 
                        "PAILAS", "Debes colocar el protagonista");
            } else{
                siga = true;
            }
        }
        return siga;
    }
}
