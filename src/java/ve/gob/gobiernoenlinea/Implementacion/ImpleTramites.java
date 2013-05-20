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
 * **/

public class ImpleTramites {
   private static Logger log = Logger.getLogger(ImpleTramites.class);
   int falla = 0 ; 
   String cadenaInicio ;
   String cadenaFin ;
   int Tipo_de_datos;
   static String Tra ;
   String urlEnte  ;
   String Inst ;     //Es usado para saber el nombre de la institucion
   int estructura ;
   int identificador;
   
   public void ActualizacionTra () throws IOException{
         log.info("INICIO DE LA ACTUALIZACION DE LOS TRAMITES");
        // System.out.println("INICIO DE LA ACTUALIZACION DE LOS TRAMITES" + new Date ());
         falla = 0;
         SNC snc = new SNC();
         BorrarCacheDotcms Cache = new BorrarCacheDotcms();
         
     List<SiIoGob> l = ServiceFactory.geServiceGen().encontrar();
          
          for (SiIoGob a : l){
               
            cadenaInicio  = a.getCadenaInicio();         // System.out.println("ci1"+a.getCadenaIni()); 
            cadenaFin     = a.getCadenaFin();            // System.out.println("cf1"+a.getCadenaFin());
            urlEnte       = a.getUrl();                  // System.out.println("URL"+a.getUrl());
            //dato          = tipoDatos.getDescripcion();  // System.out.println("Td" +a.getTipo_de_datos());
            Tipo_de_datos  = a.getTipo_de_datos();         
            identificador = a.getIdentificador();        // System.out.println("Ide"+a.getIdentificador());
            //estructura = a.getStructure_inode() ;            
       try {
            snc.Buscar(cadenaInicio, cadenaFin, urlEnte);
            
       }catch(Exception e) {
           log.error("SIS002E : Problemas de Conexion contra = "+urlEnte);
           //System.err.println("\"SIS002E\" : Problemas de Conexion contra = " +urlEnte);
          falla = 1;
        //  break;
       }
        List<Contentlet>l2 = ServiceFactory.getServiceCon().encontrarIdCont(identificador, 107379);
        for (Contentlet c : l2){
                   if (falla == 1) {break;}
                   
        
        if (snc.getdatosEncontrados() != null){
            if (Tipo_de_datos == 10 & snc.getdatosEncontrados() != null){
            Tra = Jsoup.parse(snc.getdatosEncontrados()).text();
            }
            switch (Tipo_de_datos){
                case 10:
               String NombreTra = Jsoup.parse(snc.getdatosEncontrados()).text();
               c.setText1(NombreTra);
               log.info("Actualizando El NOMBRE del Tramite:"+Tra);
               //System.out.println("Yo actualizo:"+NombreTra);
                break;
                case 11:
               String HorAteTra = Jsoup.parse(snc.getdatosEncontrados()).text();
               c.setText5(HorAteTra);
               log.info("Actualizando El HORARIO DE ATENCION AL CLIENTE del Tramite:"+Tra);
               //System.out.println("Yo actualizo:"+HorAteTra);
                break;    
                case 12:
               String DesTra = Jsoup.parse(snc.getdatosEncontrados()).text();
               c.setText1_area1(DesTra);
               log.info("Actualizando La DESCRIPCION del Tramite:"+Tra);
               //System.out.println("Yo actualizo"+DesTra);
                break;    
                case 13:
               String TelTra = Jsoup.parse(snc.getdatosEncontrados()).text();
               c.setText4(TelTra);
               log.info("Actualizando El TELEFONO del Tramite:"+Tra);
               //System.out.println("Yo actualizo"+TelTra);
                break;
                case 14:
               String DitTra = Jsoup.parse(snc.getdatosEncontrados()).text();
               c.setText5(DitTra);
               log.info("Actualizando La DIRRECION del Tramite:"+Tra);
               //System.out.println("Yo actualizo"+DitTra);
                break;
                case 15:
               String ComTra = Jsoup.parse(snc.getdatosEncontrados()).text();
               c.setText1_area2(ComTra);
               log.info("Actualizando LOS COMENTARIOS del Tramite:"+Tra);
               //System.out.println("Yo actualizo"+ComTra);
                break;
                case 16:
               String TieResTra = Jsoup.parse(snc.getdatosEncontrados()).text();
               c.setText6(TieResTra);
               log.info("Actualizando EL TIMPO DE RESPUESTA del Tramite:"+Tra);
               //System.out.println("Yo actualizo"+TieResTra);
                break;
                case 17:
               String CosTra  = Jsoup.parse(snc.getdatosEncontrados()).text();
               c.setText4(CosTra);
               log.info("Actualizando EL COSTO del Tramite:"+Tra);
               //System.out.println("Yo actualizo"+CosTra);
                break;     
                case 18:
               String BasLeg = Jsoup.parse(snc.getdatosEncontrados()).text();
               c.setText_area3(BasLeg);
               log.info("Actualizando LAS BASES LEGALES del Tramite:"+Tra);
               //System.out.println("Yo actualizo"+BasLeg);
                break;
                case 19:
               String ProTra = Jsoup.parse(snc.getdatosEncontrados()).text();
               c.setText_area7(ProTra);
               log.info("Actualizando LOS PORCEDIMIENTOS del Tramite:"+Tra);
               //System.out.println("Yo actualizo"+ProTra);
                break;
                case 20:
               String ReqTra = Jsoup.parse(snc.getdatosEncontrados()).text();
               c.setText_area8(ReqTra);
               log.info("Actualizando LOS REQUERIMIENTOS del Tramite:"+Tra);
               //System.out.println("Yo actualizo"+ReqTra);
                break;
                case 21:
               String RecTra = Jsoup.parse(snc.getdatosEncontrados()).text();
               c.setText_area9(RecTra);
               log.info("Actualizando LOS RECAUDOS del Tramite:"+Tra);
               //System.out.println("Yo actualizo"+RecTra);    
                break;   
          } //Switch
        } //if snc
/////////////////////////////////////////////////////////////////////////////////////////////        
         if (snc.getdatosEncontrados() != null){
            try {
        ServiceFactory.getServiceCon().actualizaCon(c);
                 System.out.println("Actualizacion Nivel 1");        
        ServiceFactory.getServiceCon().Persistencia();
                 System.out.println(" Actualizacion Nivel 2");
                 }catch(Exception e){
                    //System.err.println("\"SIS003E\" : Error de actualizacion verificar configuracion con la base de datos de Gobierno en Linea");
                    log.error("\"SIS003E\" : Error de actualizacion verificar configuracion con la base de datos de Gobierno en Linea");
                 }
             }
/////////////////////////////////////////////////////////////////////////////////////////////////        
      } //for Contentlet
    } // For siiogob    
if (falla != 1) {
              try {
////Metodo Para Limpiar el Cahce del dotCMS Luego de cada Actualización///
                 Cache.BorrarCache();                                  ///
////////////////////////////////////////////////////////////////////////// 
                 log.info("FIN DE LA ACTUALIZACION DE TRAMITES");
          }catch (IOException e){
            //System.err.println("\"SIS004E\" : Error Durante el borrado de cache por favor verificar la configuracion de esta funcion");
           log.error("\"SIS004E\" : Error Durante el borrado de cache por favor verificar la configuracion de esta funcion");
          }//catch
      }//if                               
    }//ActualizacionTra
}//ImpleTramites