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
public class ImpleUniversidades {
int falla = 0 ; 
   String cadenaInicio ;
   String cadenaFin ;
   int Tipo_de_datos;
   String urlEnte  ;
   String Inst ;     //Es usado para saber el nombre de la institucion
   int estructura ;
   int identificador;
   
   public void ActualizacionUni () throws IOException{
         System.out.println("INICIO DE LA ACTUALIZACION DE LAS UNIVERSIDADES" + new Date ());
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
           System.err.println("\"SIS002E\" : Problemas de Conexion contra = " +urlEnte);
          falla = 1;
        //  break;
       }
        List<Contentlet>l2 = ServiceFactory.getServiceCon().encontrarIdCont(identificador, 130663);
        for (Contentlet c : l2){
                   if (falla == 1) {break;}                           
        if (snc.getdatosEncontrados() != null){
            switch (Tipo_de_datos){             
                case 37:
               String NombreUni = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
               c.setText1(NombreUni);
               System.out.println("Yo actualizo:"+NombreUni);
                break;
                case 38:
               String TelUni = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
               c.setText2(TelUni);
               System.out.println("Yo actualizo:"+TelUni);
                break;
                case 39:
               String DirUni = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
               c.setText3(DirUni);
               System.out.println("Yo actualizo:"+DirUni);
                break;
                case 40:
               String PagWebUni = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
               c.setText3(PagWebUni);
               System.out.println("Yo actualizo:"+PagWebUni);     
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
                    System.err.println("\"SIS003E\" : Error de actualizacion verificar configuracion con la base de datos de Gobierno en Linea");}
             }
/////////////////////////////////////////////////////////////////////////////////////////////////        
      } //for Contentlet
    } // For siiogob    
if (falla != 1) {
              try {
////Metodo Para Limpiar el Cahce del dotCMS Luego de cada Actualización///
                 Cache.BorrarCache();                                  ///
////////////////////////////////////////////////////////////////////////// 
          }catch (IOException e){
            System.err.println("\"SIS004E\" : Error Durante el borrado de cache por favor verificar la configuracion de esta funcion");
        }//catch
      }//if                               
    }//ActualizacionUniversidades       
} //ImpleUniversidades
