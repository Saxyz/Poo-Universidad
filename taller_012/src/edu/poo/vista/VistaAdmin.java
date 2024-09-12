/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.vista;


import edu.poo.recurso.dominio.Configuracion;
import edu.poo.recurso.dominio.Ruta;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Estudiantes
 */
public class VistaAdmin {
    private final Scene scene;
    private final Stage stage;
    private final BorderPane borderPane;
    
    private StackPane panelArriba;
    private StackPane panelDerecha;
    private StackPane panelAbajo;
    private StackPane panelIzquierda;
    private StackPane panelCentro;

    private String border;

    public VistaAdmin() {
        stage = new Stage();
        borderPane = new BorderPane();
        
        armarTodoAqui();
        
        scene = new Scene(borderPane, Configuracion.ANCHO_APP, Configuracion.ALTO_APP);
        stage.setScene(scene);
              
    }

    public Stage getStage() {
        return stage;
    }
    
    private void armarTodoAqui(){
        border = "-fx-border-color: red";
        pintarCabecera();
        pintarDerecha();
        pintarAbajo();
        pintarIzquierda();
        pintarCentro();
        
        borderPane.setTop(panelArriba);
        borderPane.setRight(panelDerecha);
        borderPane.setBottom(panelAbajo);
        borderPane.setLeft(panelIzquierda);
        borderPane.setCenter(panelCentro);
        
    }

    private void pintarCabecera() {
        Label labelTitulo = new Label("Titulo cabecera");
        labelTitulo.setFont(new Font("Arial",20));
        labelTitulo.setTextFill(Color.web("#E44C62"));
        
        
        panelArriba = new StackPane();
        panelArriba.setPrefHeight(Configuracion.ALTO_APP * 0.15);
        panelArriba.setStyle(border);
        panelArriba.getChildren().add(labelTitulo);
        
    }

    private void pintarDerecha() {
        String rutaImagen = Ruta.RUTA_IMAGENES + "linda.jpg";
        Image image = new Image(getClass().getResourceAsStream(rutaImagen));
        ImageView nodoImagen = new ImageView(image);
        
        panelDerecha = new StackPane();
        panelDerecha.setPrefWidth(Configuracion.ANCHO_APP * 0.2);
        panelDerecha.setStyle(border);
        panelDerecha.getChildren().add(nodoImagen);
       
    }

    private void pintarAbajo() {
        Label labelTitulo = new Label("Titulo cabecera");
        labelTitulo.setFont(new Font("Arial",20));
        labelTitulo.setTextFill(Color.web("#E44C62"));
        
        panelAbajo = new StackPane();
        panelAbajo.setPrefHeight(Configuracion.ALTO_APP * 0.10);
        panelAbajo.setStyle(border);
        panelAbajo.getChildren().add(labelTitulo);
       
    }

    private void pintarIzquierda() {
        Circle circle = new Circle(20);
        
        panelIzquierda = new StackPane();
        panelIzquierda.setPrefWidth(Configuracion.ANCHO_APP * 0.2);
        panelIzquierda.setStyle(border);
        panelIzquierda.getChildren().add(circle);
        
    }

    private void pintarCentro() {
        double posX, posY, ancho, alto;
        ancho = (Configuracion.ANCHO_APP * 0.5);
        alto = (Configuracion.ALTO_APP * 0.4);
        
        posX = (Configuracion.ANCHO_APP / 2) - (ancho/2);
        posY = (Configuracion.ALTO_APP / 2) - (alto/2);
        
        Rectangle rectangle = new Rectangle(posX, posY, ancho, alto);
        rectangle.setFill(Color.web("#C04CE4"));
        
        panelCentro = new StackPane();
        panelCentro.setStyle(border);
        panelCentro.getChildren().add(rectangle);
    }
    
}
