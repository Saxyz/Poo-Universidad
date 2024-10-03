
package edu.poo.recurso.dominio;


public class Ruta {
    //ruta APP
    public final static String RUTA_APP = System.getProperty("user.dir");
    public final static String RUTA_USER = System.getProperty("user.home");
   
    
    //rutas de las imagenes 
     public final static String RUTA_IMAGENES = "/edu/poo/recurso/imagen/";
     
     //rutas de los estilos
     public final static String RUTA_ESTILO_BTN_ACERCA = "/edu/poo/recurso/estilo/BtnAcerca.css/";
     
       public final static String RUTA_ESTILO_TEXTO = "/edu/poo/recurso/estilo/CarroCrear.css/";
     
     public final static String RUTA_PERSISTENCIA = RUTA_APP + "\\" + "baseDatos";
     public final static String RUTA_PERSISTENCIA_FOTOS = RUTA_PERSISTENCIA + "\\" + "fotosAca";
}
