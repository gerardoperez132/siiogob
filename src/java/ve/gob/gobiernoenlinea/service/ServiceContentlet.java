package ve.gob.gobiernoenlinea.service;

//import java.util.List;
import java.util.List;
import ve.gob.gobiernoenlinea.modelo.Contentlet;

/**
 *
 * @author gerardo
 */
public interface ServiceContentlet {
    
    public void actualizaCon (Contentlet contentlet);
    public List<Contentlet> encontrarIdCont(int identificador, int secciones );
    public int Persistencia ();

   // public List<Contentlet> encontrarIdCont(int identificador, String estructura);

    
}