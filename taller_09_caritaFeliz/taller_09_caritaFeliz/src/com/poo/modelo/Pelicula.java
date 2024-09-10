package com.poo.modelo;

/*A plain old java object*/
public class Pelicula {
   private int codPelicula;
   private String nombrePelicula;
   private String protagonistaPelicula;
   
    public Pelicula() {
    }

    public Pelicula(String nombrePelicula, String protagonistaPelicula) {
        this.nombrePelicula = nombrePelicula;
        this.protagonistaPelicula = protagonistaPelicula;
    }
    
    

    public Pelicula(int codPelicula, String nombrePelicula, String protagonistaPelicula) {
        this.codPelicula = codPelicula;
        this.nombrePelicula = nombrePelicula;
        this.protagonistaPelicula = protagonistaPelicula;
    }

    public int getCodPelicula() {
        return codPelicula;
    }

    public void setCodPelicula(int codPelicula) {
        this.codPelicula = codPelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getProtagonistaPelicula() {
        return protagonistaPelicula;
    }

    public void setProtagonistaPelicula(String protagonistaPelicula) {
        this.protagonistaPelicula = protagonistaPelicula;
    }
   
   
}
