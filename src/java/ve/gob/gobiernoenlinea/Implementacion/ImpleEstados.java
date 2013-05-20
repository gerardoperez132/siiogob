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
/**
 *
 * @author gerardo
 */
public class ImpleEstados {
   int falla = 0 ; 
   String cadenaInicio ;
   String cadenaFin ;
   int Tipo_de_datos;
   String urlEnte  ;
   String Inst ;     //Es usado para saber el nombre de la institucion
   int estructura ;
   int identificador; 
    
    public void ActualiciacionEst() {
         System.out.println("INICIO DE LA ACTUALIZACION DE LOS ESTADOS" + new Date ());
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
        List<Contentlet>l2 = ServiceFactory.getServiceCon().encontrarIdCont(identificador, 122777);
        for (Contentlet c : l2){
                   if (falla == 1) {break;}
                   
        
        if (snc.getdatosEncontrados() != null){
            switch (Tipo_de_datos){
                case 22:// Coor X
               String Coor_X = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
               //Float.parseFloat(Coor_X);
               c.setFloat1(Float.parseFloat(Coor_X));
               System.out.println("Yo actualizo:"+Coor_X);
                break;    
                case 23: //Coor Y
               String Coor_Y = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
               c.setFloat2(Float.parseFloat(Coor_Y));
               System.out.println("Yo actualizo:"+Coor_Y);
                break;    
                case 24:
               String NombreEst = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
               c.setText1(NombreEst);
               System.out.println("Yo actualizo:"+NombreEst);
                break;   
                case 25:
               String BreveDes = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
               c.setText1_area1(BreveDes);
               System.out.println("Yo actualizo"+BreveDes);
                break;
                case 26:
               String DetEsta = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
               c.setText1_area2(DetEsta);
               System.out.println("Yo actualizo"+DetEsta);
                break;
                case 27:
               String HimEsta = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
               c.setText_area4(HimEsta);
               System.out.println("Yo actualizo"+HimEsta);
                break;
                case 28:
               String GobEsta = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
               c.setText5(GobEsta);
               System.out.println("Yo actualizo"+GobEsta);
                break;
                case 29:
               String GobernadorEsta = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
               c.setText9(GobernadorEsta);
               System.out.println("Yo actualizo"+GobernadorEsta);
                case 30:
               String PagWebGobEsta = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
               c.setText8(PagWebGobEsta);
               System.out.println("Yo actualizo"+PagWebGobEsta);
                break;
                case 31:
               String DirGobEsta = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
               c.setText7(DirGobEsta);
               System.out.println("Yo actualizo"+DirGobEsta);
                break;
                case 43:
               String TelGobEsta = Jsoup.clean(snc.getdatosEncontrados(), Whitelist.basic());
               c.setText6(TelGobEsta);
               System.out.println("Yo actualizo"+TelGobEsta);
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
    }//ActualizacionEstados
}//ImpleEstados