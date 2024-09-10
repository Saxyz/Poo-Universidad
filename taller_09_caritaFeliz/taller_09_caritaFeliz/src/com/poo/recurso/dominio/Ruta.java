package com.poo.recurso.dominio;

public class Ruta {
    public final static String RUTA_IMAGENES = 
            "/com/poo/recurso/imagen/";
    
    //Rutas relativas
    //obtiene la ruta del proyecto 
    public final static String RUTA_PROYECTO = System.getProperty("user.dir");
    //abre de una las ventanias en el home del usuario
    public final static String RUTA_USUARIO = System.getProperty("user.home");
    
    //Rutas de la persistencia
    public final static String RUTA_PERSISTENCIA = RUTA_PROYECTO + "\\" + "baseDatos";
    public final static String RUTA_FOTOS_EXTERNAS = RUTA_PERSISTENCIA + "\\" + "meteFotos";
    
}
