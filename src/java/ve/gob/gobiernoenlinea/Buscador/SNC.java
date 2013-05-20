/*
 * Clase Servicio Nacional de Contrataciones
 * 
 */
package ve.gob.gobiernoenlinea.Buscador;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author   gerardo
 */
 
 
public class SNC {
    
   String datosEncontrados ;

    public SNC()  {
    }
    
    public void Buscar(String cadenaInicio, String cadenaFin, String urlEnte) throws IOException {
    
 int linea = 0;
 String FinalHtml = "</html>";
 String FinalBody = "</body>";
        URL url = new URL(urlEnte);
      //  System.out.println("antes de crear mi objeto que un archivo linea por linea");
        
        BufferedReader webEnteGobierno = new BufferedReader(new InputStreamReader(url.openStream()));
        
//La clase Buffered Reader es muy usada para leer archivos de texto plano que contenga información que el programa pueda usar.
//http://www.chuidiang.com/java/novatos/entrada_standard_java.php
// InputStream es para leer bytes,
        StringBuilder datos = new StringBuilder();//Segun Algunos Articulos de Buenas Practicas el StringBuilder es mas optimo
        //StringBuffer datos = new StringBuffer();
       // System.out.println("Antes de entrar al ciclo");
        while ((datos.append(webEnteGobierno.readLine())) != null) {
           
            linea += 1;
            
        //   System.out.println("BUSCO LA LINEA"+linea+"La caFin:"+ cadenaFin + " y caIni" + cadenaInicio);
          //  System.out.println("Busque en la linea:"+linea);
            if (datos.indexOf(cadenaFin) > datos.indexOf(cadenaInicio) + cadenaInicio.length()) {
            //     System.out.println("En tro a la condicion");
                datos = new StringBuilder(datos.substring(datos.indexOf(cadenaInicio) + cadenaInicio.length(), datos.indexOf(cadenaFin)));                 
                datosEncontrados = datos.toString();
           //     System.out.println("Te encontre en la linea"+linea);
                break;  
            }
            if ( datos.indexOf(FinalHtml) > datos.indexOf(FinalBody)) {
                System.err.println("\"SIS001E\": No Encuentro las Etiquetas en la Url especificada :"+urlEnte);
                //datosEncontrados = "SIS001E";
                break;
            } 
            
          // break; </body>
         //</html>
        // System.out.println("Traje Esto:" + nombreSNC );
      
        }

        webEnteGobierno.close();
    }

    public String getdatosEncontrados() {
        return datosEncontrados;
    }

    public void setNombreSNC(String datosEncontrados) {
        this.datosEncontrados = datosEncontrados;
    }
}
