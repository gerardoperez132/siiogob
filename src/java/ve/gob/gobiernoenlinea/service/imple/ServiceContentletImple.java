package ve.gob.gobiernoenlinea.service.imple;

//import java.util.ArrayList;
//import java.util.List;
import java.util.List;
import ve.gob.gobiernoenlinea.dao.Dao;
import ve.gob.gobiernoenlinea.modelo.Contentlet;
import ve.gob.gobiernoenlinea.service.ServiceContentlet;

/**
 *
 * @author gerardo
 */
public class ServiceContentletImple implements ServiceContentlet {
    
    private Dao instDao;
    
    
    @Override
    public void actualizaCon(Contentlet contentlet) {
        instDao.guardaroactualizar(contentlet);
    }
    
    @Override
    public  List<Contentlet> encontrarIdCont(int identificador, int secciones ){
        
        /*String sql="Select c.inode, c.title, c.friendly_name, c.text1 "
                + " from Contentlet c where c.inode=145073" ;*/
        
        
           String  sql="Select c from Contentlet c , Inode ino"
                    + " where  ino.Type='contentlet'"
                    + " and    live ='t'"
                    + " and    ino.Identifier="+ identificador +" and c.inode = ino.Inode "
                    + " and    c.structure_inode ="+ secciones ;
              
        return instDao.encontrarID(sql);
    }    
    @Override
    public int Persistencia () {
       
        return instDao.persistencia();
        
        
    }

    public Dao getInstDao() {
        return instDao;
    }

    public void setInstDao(Dao instDao) {
        this.instDao = instDao;
    }

    
    
    
    
    
            
}
