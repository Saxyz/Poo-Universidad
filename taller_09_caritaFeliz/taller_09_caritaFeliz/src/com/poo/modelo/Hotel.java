package com.poo.modelo;


public class Hotel {
    private int codHotel;
    private String nombrePelicula;
    private String direccionHotel;
    private String ciudadHotel;
    private String telefonoReservasHotel;

    public Hotel() {
    }

    public Hotel(int codHotel, String nombrePelicula, String direccionHotel, String ciudadHotel, String telefonoReservasHotel) {
        this.codHotel = codHotel;
        this.nombrePelicula = nombrePelicula;
        this.direccionHotel = direccionHotel;
        this.ciudadHotel = ciudadHotel;
        this.telefonoReservasHotel = telefonoReservasHotel;
    }

    public int getCodHotel() {
        return codHotel;
    }

    public void setCodHotel(int codHotel) {
        this.codHotel = codHotel;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getDireccionHotel() {
        return direccionHotel;
    }

    public void setDireccionHotel(String direccionHotel) {
        this.direccionHotel = direccionHotel;
    }

    public String getCiudadHotel() {
        return ciudadHotel;
    }

    public void setCiudadHotel(String ciudadHotel) {
        this.ciudadHotel = ciudadHotel;
    }

    public String getTelefonoReservasHotel() {
        return telefonoReservasHotel;
    }

    public void setTelefonoReservasHotel(String telefonoReservasHotel) {
        this.telefonoReservasHotel = telefonoReservasHotel;
    }
    
    
    
}
