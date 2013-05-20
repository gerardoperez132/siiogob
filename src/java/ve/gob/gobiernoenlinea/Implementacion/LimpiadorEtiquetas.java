/*
  2da idea para borrar el cache sino funciona con la libreria jsoup
 */
package ve.gob.gobiernoenlinea.Implementacion;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alexisv
 */
public class LimpiadorEtiquetas {
    public String DatoLimpio;
    private static int indiceI;
    private static int indiceF;
    private static String limpio;
    
    public LimpiadorEtiquetas() {
    }
    
    public void Limpiar (String Dato) {
         do{
        indiceI = 0;
        indiceF = 0;

        char ini = '<';
        char fin = '>';
        indiceI = Dato.indexOf(ini);
        indiceF = Dato.indexOf(fin);
        if (indiceI > 0 || indiceF >0){
        String borrar = Dato.substring(indiceI, (indiceF+1));
        Pattern p = Pattern.compile(borrar);
        Matcher m = p.matcher(Dato);
        if (m.find()){
            limpio = m.replaceAll("");
            DatoLimpio = limpio;
            DatoLimpio.trim();
                }
            }
        }while(indiceI > 0 || indiceF > 0);
    }

    public String getDatoLimpio() {
        return DatoLimpio;
    }

    public void setDatoLimpio(String DatoLimpio) {
        this.DatoLimpio = DatoLimpio;
    }

  
    
    
}


