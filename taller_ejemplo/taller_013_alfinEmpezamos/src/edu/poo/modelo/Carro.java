package edu.poo.modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Carro {

    private IntegerProperty identificadoCarro;
    private StringProperty marcaCarro;
    private StringProperty modeloCarro;
    private StringProperty descripcionCarro;
    private StringProperty nombreImagenCarro;
    private StringProperty nombreImagenOcultaCarro;

    public Carro() {
    }

    public Carro(Integer identificadoCarro, String marcaCarro, String modeloCarro, String descripcionCarro, String nombreImagenCarro, String nombreImagenOcultaCarro) {
        //Ahora volvemos
        armar(identificadoCarro, marcaCarro, modeloCarro, modeloCarro, marcaCarro, modeloCarro);
    }
    private void armar(Integer id, String ma, String mod, String desc, String ima, String ocu) {
        setIdentificador(id);
        setMarcaCarro(ma);
        setModeloCarro(mod);
        setDescripcionCarro(desc);
        setNombreImagenCarro(ima);
        setNombreImagenOcultaCarro(ocu);
    }

    public Carro(String marcaCarro, String modeloCarro, String descripcionCarro) {
        armar2(marcaCarro, modeloCarro, descripcionCarro);
    }
    
    private void armar2(String marcaCarro, String modeloCarro, String descripcionCarro) {
        setMarcaCarro(marcaCarro);
        setModeloCarro(modeloCarro);
        setDescripcionCarro(descripcionCarro);
    }
    


    // Propiedad identificador (Setter y Getter)
    public IntegerProperty propiedadIdentificador() {
        if (this.identificadoCarro == null) {
            this.identificadoCarro = new SimpleIntegerProperty(this, "identificador");
        }
        return this.identificadoCarro;
    }

    public void setIdentificador(Integer id) {
        propiedadIdentificador().set(id);
    }
    //*************************************************
      // Propiedad marca (Setter y Getter)
    public StringProperty propiedadMarca() {
        if (this.marcaCarro == null) {
            this.marcaCarro = new SimpleStringProperty(this, "marca");
        }
        return this.marcaCarro;
    }

    public void setMarcaCarro(String marca) {
        propiedadMarca().set(marca);
    }
    //*************************************************
    
    
      //*************************************************
      // Propiedad modeloCarro (Setter y Getter)
    public StringProperty propiedadModeloCarro() {
        if (this.modeloCarro == null) {
            this.modeloCarro = new SimpleStringProperty(this, "modelo");
        }
        return this.modeloCarro;
    }

    public void setModeloCarro(String modelo) {
        propiedadModeloCarro().set(modelo);
    }
    //*************************************************
    
      // Propiedad descripcionCarro (Setter y Getter)
    public StringProperty propiedadDescripcionCarro() {
        if (this.descripcionCarro == null) {
            this.descripcionCarro = new SimpleStringProperty(this, "descripcion");
        }
        return this.descripcionCarro;
    }

    public void setDescripcionCarro(String descripcion) {
        propiedadDescripcionCarro().set(descripcion);
    }
    //*************************************************
    
    
      
      // Propiedad nombreImagenCarro (Setter y Getter)
    public StringProperty propiedadNombreImagenCarro() {
        if (this.nombreImagenCarro == null) {
            this.nombreImagenCarro = new SimpleStringProperty(this, "nombreImagen");
        }
        return this.nombreImagenCarro;
    }

    public void setNombreImagenCarro(String nombreImagen) {
        propiedadDescripcionCarro().set(nombreImagen);
    }
    //*************************************************
    
        // Propiedad nombreImagenOcultaCarro (Setter y Getter)
    public StringProperty propiedadNombreImagenOcultaCarro() {
        if (this.nombreImagenOcultaCarro == null) {
            this.nombreImagenOcultaCarro = new SimpleStringProperty(this, "nombreImagenOculta");
        }
        return this.nombreImagenOcultaCarro;
    }

    public void setNombreImagenOcultaCarro(String nombreImagenOculta) {
        propiedadDescripcionCarro().set(nombreImagenOculta);
    }
    //*************************************************

    
}
