package ve.gob.gobiernoenlinea.service;

//import java.util.List;
import java.util.List;
import ve.gob.gobiernoenlinea.modelo.Contentlet;
import ve.gob.gobiernoenlinea.modelo.TipoDato;

/**
 *
 * @author gerardo
 */
public interface ServiceTipoDato {
    
   
     List<TipoDato> getTipoDato(long id_Structure_inode);

   // public List<Contentlet> encontrarIdCont(int identificador, String estructura);

    
}