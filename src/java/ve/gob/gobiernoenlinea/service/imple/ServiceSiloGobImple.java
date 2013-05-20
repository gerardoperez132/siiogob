package ve.gob.gobiernoenlinea.service.imple;

import java.util.List;
import ve.gob.gobiernoenlinea.dao.Dao;
import ve.gob.gobiernoenlinea.modelo.SiIoGob;
import ve.gob.gobiernoenlinea.service.ServiceGen;

/**
 *
 * @author gerardo
 */
public class ServiceSiloGobImple implements ServiceGen {

    private Dao instDao ;
    
    public Dao getInstDao() {
        return instDao;
    }

    public void setInstDao(Dao instDao) {
        this.instDao = instDao;
    }
   
  
    
    
    @Override
    public List<SiIoGob> encontrar() {
        
       List<SiIoGob> c=null;
       
        try {
      
           String selec = "Select s from SiIoGob s" ;
           
           c =  instDao.encontrarID(selec);
        }
       catch (Exception t) {
        
        System.out.println("SIS001"+ t.getMessage());
        t.printStackTrace();
       }        
      return c;           
    }

    @Override
    public void insertar(SiIoGob siiogob) {
        instDao.inser(siiogob);
    }
    
}
