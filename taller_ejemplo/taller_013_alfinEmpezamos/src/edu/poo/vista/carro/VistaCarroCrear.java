package edu.poo.vista.carro;

import edu.poo.controlador.ControladorCarroVentana;
import edu.poo.recurso.dominio.Ruta;
import edu.poo.recurso.utilidad.Fondo;
import edu.poo.recurso.utilidad.Marco;
import edu.poo.recurso.utilidad.Mensaje;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.SubScene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class VistaCarroCrear extends SubScene {

    private final GridPane miGrid;

    private final StackPane miStackPane;

    private TextField cajaMarca;
    private TextField cajaModelo;
    private TextArea cajaDescripcion;
    private TextField cajaImagen;

    private String rutaImagenSeleccionada;

    private double nuevoAnchoMarco;
    private double nuevoAltoMarco;

    public VistaCarroCrear(double ancho, double alto) {
        super(new StackPane(), ancho, alto);

        miStackPane = (StackPane) this.getRoot();
        miStackPane.getStylesheets().add(getClass().getResource(Ruta.RUTA_ESTILO_TEXTO).toExternalForm());

        Background fondo = Fondo.asignar("marco03.png", ancho, alto);
        miStackPane.setBackground(fondo);
        nuevoAnchoMarco = ancho - (ancho * 0.4);
        nuevoAltoMarco = alto - (alto * 0.25);

        miGrid = new GridPane(nuevoAnchoMarco, nuevoAltoMarco);

        miStackPane.setTranslateX(ancho - (ancho * 0.2));

        organizarObjetos();
    }

    private void organizarObjetos() {
        String colorBorde = "#6ff3f7";

        Stop[] arrColores = new Stop[]{
            new Stop(0, Color.web("#C90303")),
            new Stop(0.5, Color.web("#e66666")),
            new Stop(1, Color.web("#F26161"))};

        Rectangle marco = Marco.crear(nuevoAnchoMarco, nuevoAltoMarco, arrColores, colorBorde);

        miStackPane.getChildren().add(marco);
        miStackPane.getChildren().add(miGrid);

        miStackPane.setAlignment(Pos.TOP_CENTER);
        marco.setTranslateX(0);
        marco.setTranslateY(30);

        construirFormulario();
    }

    public StackPane getMiStackPane() {
        return miStackPane;
    }

    private void construirFormulario() {
        Stage centradito = null;
        miGrid.setAlignment(Pos.TOP_CENTER);
        miGrid.setPadding(new Insets(40, 0, 10, 0));
        miGrid.setHgap(10);
        miGrid.setVgap(10);

        double anchoGrilla = nuevoAnchoMarco - (nuevoAnchoMarco * 0.15);

        double columna1 = anchoGrilla * 0.25;
        double columna2 = anchoGrilla * 0.75;

        miGrid.getColumnConstraints().add(new ColumnConstraints(columna1));
        miGrid.getColumnConstraints().add(new ColumnConstraints(columna2));

        Text titulo = new Text("Creacion de Carros");

        titulo.setFill(Color.WHITE);
        titulo.setFont(Font.font("verdana", FontWeight.NORMAL, 20));

        miGrid.add(titulo, 0, 0, 2, 1);

        Label lblMarca = new Label("Marca:");
        miGrid.add(lblMarca, 0, 1);
        cajaMarca = new TextField();
        miGrid.add(cajaMarca, 1, 1);

        Label lblModelo = new Label("Modelo:");
        miGrid.add(lblModelo, 0, 2);
        cajaModelo = new TextField();
        miGrid.add(cajaModelo, 1, 2);

        Label lblDescripcion = new Label("Descripcion:");
        miGrid.add(lblDescripcion, 0, 3);
        cajaDescripcion = new TextArea();
        cajaDescripcion.setWrapText(true);
        cajaDescripcion.setPrefHeight(120);
        miGrid.add(cajaDescripcion, 1, 3);

        Label lblImagen = new Label("Imagen: ");
        miGrid.add(lblImagen, 0, 4);
        Button btnSeleccionar = new Button("+");

        cajaImagen = new TextField();
        cajaImagen.setDisable(true);

        HBox.setHgrow(cajaImagen, Priority.ALWAYS);
        HBox panelHorizontalImagen = new HBox(5);
        panelHorizontalImagen.setAlignment(Pos.BOTTOM_RIGHT);
        panelHorizontalImagen.getChildren().addAll(cajaImagen, btnSeleccionar);

        miGrid.add(panelHorizontalImagen, 1, 4);

        FileChooser objSeleccionar = CrearSelectorImagen();

        Button btnGrabar = new Button("Grabe el carro y saque 60 puntos");

        btnGrabar.setOnAction((t) -> {
            if (cajasLlenas(cajaMarca, cajaModelo, cajaDescripcion)) {
                if (ControladorCarroVentana.grabar(cajaMarca.getText(), cajaModelo.getText(), cajaDescripcion.getText())) {
                    System.out.println(cajaMarca.getText());
                    System.out.println(cajaModelo.getText());
                    System.out.println(cajaDescripcion.getText());
                    cajaMarca.setText("");
                    cajaModelo.setText("");
                    cajaDescripcion.setText("");

                    cajaMarca.requestFocus();
                    Mensaje.modal(Alert.AlertType.INFORMATION, null, "Lo lo logre", "Mama estoy triunfando");
                } else {
                    Mensaje.modal(Alert.AlertType.ERROR, null, "Pailas", "Ayyyy, snifffff");
                }
            }
        });

        HBox panelHachito = new HBox(10);
        panelHachito.setAlignment(Pos.BASELINE_RIGHT);
        panelHachito.getChildren().add(btnGrabar);

        miGrid.add(panelHachito, 1, 6);
    }

    private FileChooser CrearSelectorImagen() {
        FileChooser objSeleccionar = new FileChooser();

        return objSeleccionar;
    }

    private boolean cajasLlenas(TextField caja1, TextField caja2, TextArea caja3) {
        boolean siga = false;
        if (caja1.getText().isBlank() || caja2.getText().isBlank() || caja3.getText().isBlank()) {
            caja1.requestFocus();
            Mensaje.modal(Alert.AlertType.WARNING, null, "PAILAS", "Debe llenar todas las casillas");
        } else {
            siga = true;

        }
        return siga;
    }

}
