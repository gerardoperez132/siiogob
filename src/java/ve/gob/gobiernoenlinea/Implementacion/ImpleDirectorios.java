/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.gob.gobiernoenlinea.Implementacion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;
/*import javax.ejb.Schedule;
import javax.ejb.Singleton;*/


import ve.gob.gobiernoenlinea.factory.ServiceFactory;
import ve.gob.gobiernoenlinea.modelo.Contentlet;
import ve.gob.gobiernoenlinea.Buscador.SNC;
import ve.gob.gobiernoenlinea.modelo.SiIoGob;
import ve.gob.gobiernoenlinea.borrarCacheDotcms.BorrarCacheDotcms;
     
//import ve.gob.gobiernoenlinea.Implementacion.LimpiadorEtiquetas;
/**
 *
 * @author gerardo
 */
//@Singleton
/*Singleton es un metodo que garantiza que una clase 
 * solo tenga unas instancia y proporcione un punto de acceso 
 * global a ella.
 * 
 */

public class ImpleDirectorios {
private static Logger log = Logger.getLogger(ImpleDirectorios.class);   
   int falla = 0 ; 
   String cadenaInicio ;
   String cadenaFin ;  
   //String dato;
   int Tipo_de_datos;
   String urlEnte  ;
   static String Inst ;     //Es usado para saber el nombre de la institucion
   int estructura ;
   int identificador;
   String null1 = null;
   //static final String LOGON_SITE = "127.0.0.1";
   //static final int    LOGON_PORT = 9090;
   //metodos
   //  @Scheduled (second="*/20", minute="*",cron="*", persistent=false)
     /* Metodo que programa la Tarea especifica para repetirce cada cierto
      * tiempo comensando a la hora especifica.
      */
      public void Actualizacion () throws IOException{
          log.info("INICIO DE LA ACTUALIZACION DEL DIRECTORIO");
          
         //System.out.println("INICIO DE LA ACTUALIZACION DEL DIRECTORIO" + new Date ());
         falla = 0;
         SNC snc = new SNC();
         BorrarCacheDotcms Cache = new BorrarCacheDotcms();
         List<SiIoGob> l = ServiceFactory.geServiceGen().encontrar();
          
          for (SiIoGob a : l){
              
   //  TipoDato tipoDatos = (TipoDato) ServiceFactory.getServiceTipoDato().getTipoDato(a.getTipo_de_datos());
           // System.out.println("--" + a.getCadenaFin() +" h: "+ a.getCadenaIni());  
            cadenaInicio  = a.getCadenaInicio();         // System.out.println("ci1"+a.getCadenaIni()); 
            cadenaFin     = a.getCadenaFin();            // System.out.println("cf1"+a.getCadenaFin());
            urlEnte       = a.getUrl();                  // System.out.println("URL"+a.getUrl());
            //dato          = tipoDatos.getDescripcion();  // System.out.println("Td" +a.getTipo_de_datos());
            Tipo_de_datos  = a.getTipo_de_datos();         
            identificador = a.getIdentificador();        // System.out.println("Ide"+a.getIdentificador());
            //estructura = a.getStructure_inode() ;
            // System.out.println
       try {
            snc.Buscar(cadenaInicio, cadenaFin, urlEnte);
            
       }catch(Exception e) {
          // log.error("SIS002E: Problemas de Conexion contra = "+urlEnte);
           log.error("SIS002E: Problemas de Conexion contra"+urlEnte);
           //System.err.println("\"SIS002E\" : Problemas de Conexion contra = " +urlEnte);
          falla = 1;
        //  break;
       }
            //System.out.println("buscar 11"+ snc.getdatosEncontrados());
            //busca en base de dato "Contentlet" el ultimo registro vivo que corresponda al identificdor de institucion
             List<Contentlet>l2 = ServiceFactory.getServiceCon().encontrarIdCont(identificador, 123910); //snc/directorios
             
             for (Contentlet c : l2){
                   if (falla == 1) {break;}
                 //if identificador es == a snc.getdatosEncontrados()
                  if ( 1 == Tipo_de_datos & snc.getdatosEncontrados() != null ){  // 1 es el tipo de Dato "NomInst"    
                     Inst = snc.getdatosEncontrados();
                   //System.out.println(" Yo Actualizo Esto: "+snc.getdatosEncontrados());
                   //c.setText7(snc.getdatosEncontrados());
                }    
                 if (1 == Tipo_de_datos & snc.getdatosEncontrados() != null){ // 1 es el tipo de Dato "NomInst"
                    //System.out.println("Actualizando El Nombre del "+Inst);
                    log.info("Actualizando El NOMBRE del "+Inst);
                    String Nombre = Jsoup.clean(snc.getdatosEncontrados(),Whitelist.basic()); //Limpio Etiquetado html en caso de
                    c.setTitle(Nombre); //Inserto en Base de datos
                    c.setFriendly_name(Nombre); //Inserto en base de datos
                    c.setText1(Nombre); //inserto en base de datos
                    //System.out.println(" Yo Actualizo Esto: "+Nombre);
                }
                 if (2 == Tipo_de_datos & snc.getdatosEncontrados() != null){ // 2 es el tipo de Dato "DirInst"
                    //System.out.println("Actualizando La DIRECCION de "+Inst);
                    log.info("Actualizando La DIRECCION de "+Inst);
                   //limpiador.Limpiar(snc.getdatosEncontrados()) ;
                   //String Direccion = limpiador.getDatoLimpio() ;
                   //c.setText6(limpiador.DatoLimpio);
                   //System.out.println("Prueba:"+Direccion);
                   //---------------------------------------------------------------------//
                   //String Direccion = snc.getdatosEncontrados() ;  
                   String Direccion = Jsoup.clean(snc.getdatosEncontrados(),Whitelist.basic());
                   //System.out.println(":"+Direccion);
                   c.setText6(Direccion);
                   System.out.println("Yo Actualizo Esto: "+Direccion);
                //-------------------------------------------------------------------//
                }
                 if (3 == Tipo_de_datos & snc.getdatosEncontrados() != null){
                    //System.out.println("Actualizando El Responsable de la "+Inst);
                    log.info("Actualizando El RESPONSABLE de la "+Inst);
                    String Responsable = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
                    c.setText3(Responsable);
                    System.out.println(" Yo Actualizo Esto: "+Responsable);
                }
                 if (4 == Tipo_de_datos & snc.getdatosEncontrados() != null){ // 4 es el tipo de Dato "TelAteClienteInst"
                    //System.out.println("Telefono de atencion al cliente de la intitucion "+Inst);
                    log.info("Actualizando El TELEFONO DE ATENCION AL CLIENTE de la "+Inst);
                    String TelAtencionCliente = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
                    c.setText7(TelAtencionCliente);
                    System.out.println(" Yo Actualizo Esto: "+TelAtencionCliente);
                }
                 if (5 == Tipo_de_datos & snc.getdatosEncontrados() != null){ // 5 es el tipo de Dato "DesbreInst"
                    //System.out.println("Actualizando La Descripcion breve de la "+Inst);
                     log.info("Actualizando La DESCRIPCION de la "+Inst);
                    String DesBre = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
                    c.setText1_area1(DesBre);
                    System.out.println(" Yo Actualizo Esto: "+DesBre);
                }
                 if (6 == Tipo_de_datos & snc.getdatosEncontrados() != null){ // 6 es el tipo de Dato "PorWebInst"
                    //System.out.println("Actualizando El Portal Web de la "+Inst);
                     log.info("Actualizando El PORTAL WEB de la "+Inst);
                    String PorWeb = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
                    c.setText8(PorWeb);
                    System.out.println(" Yo Actualizo Esto: "+PorWeb);       
                }
                 if (7 == Tipo_de_datos & snc.getdatosEncontrados() != null){ // 7 es el tipo de Dato "CorInst"
                    //System.out.println("Actualizando El Correo "+Inst);
                    log.info("Actualizando El CORREO de la "+Inst);
                    String Correo = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
                    c.setText4(Correo);
                    System.out.println(" Yo Actualizo Esto: "+Correo);
                } 
                 if (8 == Tipo_de_datos & snc.getdatosEncontrados() != null){
                    //System.out.println("Actualizando La Descripcion Larga de "+Inst);
                    log.info("Actualizando La DESCRIPCION LARGA de la "+Inst);
                    String DesLar = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
                    c.setText1_area2(DesLar);
                    System.out.println("Yo Actualizo Esto: "+DesLar);
                } 
                if (9 == Tipo_de_datos & snc.getdatosEncontrados() != null) { //4 es el tipo de Datos "TelAteClienteInst"
                    //System.out.println("Actualizando El Telefono del" +Inst);
                    log.info("Actualizando El TELEFONO de la "+Inst);
                    String Tel = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
                    c.setText5(Tel);
                    System.out.println(" Yo Actualizo Esto: "+Tel);
                   // c.setMod_user("AKI ID DEL USUARIO"); //Usuario que modifico, en este caso coloco el id del usuario Servicio de Informacion
                   // c.setLocked(true);  //si otro usuario intenta cambiar mi registro manda un msj de advertencia
                }
                if(41 == Tipo_de_datos & snc.getdatosEncontrados() != null) {//Coor X
                  //System.out.println("Actualizando La Coordenada X de" +Inst);
                  log.info("Actualizando LA COORDENADA X de la "+Inst);
                    String Coor_X = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
                    c.setText5(Coor_X);
                    System.out.println(" Yo Actualizo Esto: "+Coor_X);  
                }
                 if(42 == Tipo_de_datos & snc.getdatosEncontrados() != null) {//Coor y
                  //System.out.println("Actualizando La Coordenada X de" +Inst);
                    log.info("Actualizando LA COORDENADA Y de la "+Inst); 
                    String Coor_Y = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
                    c.setText5(Coor_Y);
                    System.out.println(" Yo Actualizo Esto: "+Coor_Y);  
                }
                 /*
           // Contentlet c = new Contentlet();
             //c.setMod_user(""); //Usuario que modifico en este caso coloco el id del usuario Servicio de Informacion
            c.setLive(true);   //Siempre seguira siendo mi registro vivo
            c.setWorking(true); //Siempre Seguira mi registro que este trabajando
            c.setLocked(true);  //si otro usuario intenta cambiar mi registro manda un msj de advertencia

        */
          
            
        if (snc.getdatosEncontrados() != null){
            try {
        ServiceFactory.getServiceCon().actualizaCon(c);
                 System.out.println("Actualizacion Nivel 1");        
        ServiceFactory.getServiceCon().Persistencia();
                 System.out.println(" Actualizacion Nivel 2");
                 }catch(Exception e){
                   // System.err.println("\"SIS003E\" : Error de actualizacion verificar configuracion con la base de datos de Gobierno en Linea");
                    log.error("\"SIS003E\" : Error de actualizacion verificar configuracion con la base de datos de Gobierno en Linea");
                 }
             }
         }//for (Contentlet c : l2){        
      } //fin del   for (SiIoGob a : l) 
          
          if (falla != 1) {
              try {
////Metodo Para Limpiar el Cahce del dotCMS Luego de cada Actualización///
                 Cache.BorrarCache();
                ///
////////////////////////////////////////////////////////////////////////// 
                 log.info("FIN DE LA ACTUALIZACION DE DIRECTORIOS");
          }catch (IOException e){
              
            System.err.println("\"SIS004E\" : Error Durante el borrado de cache por favor verificar la configuracion de esta funcion");
            log.error("\"SIS004E\" : Error Durante el borrado de cache por favor verificar la configuracion de esta funcion");
        }//catch
      }//if
    } //metodo
  } //clase

