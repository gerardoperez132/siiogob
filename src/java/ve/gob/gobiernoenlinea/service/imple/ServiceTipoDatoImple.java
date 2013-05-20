package ve.gob.gobiernoenlinea.service.imple;

//import java.util.ArrayList;
//import java.util.List;
import java.util.List;
import ve.gob.gobiernoenlinea.dao.Dao;
import ve.gob.gobiernoenlinea.modelo.TipoDato;
import ve.gob.gobiernoenlinea.service.ServiceTipoDato;

/**
 *
 * @author gerardo
 */
public class ServiceTipoDatoImple implements ServiceTipoDato {
    
    private Dao instDao;
    
    @Override
    public List<TipoDato> getTipoDato(long id_Structure_inode) {
        String sql = "select td from TipoDato td where id_Structure_inode = " +id_Structure_inode;
        return  instDao.encontrarID(sql);
    }

    public Dao getInstDao() {
        return instDao;
    }

    public void setInstDao(Dao instDao) {
        this.instDao = instDao;
    }
  
    
    
            
}
