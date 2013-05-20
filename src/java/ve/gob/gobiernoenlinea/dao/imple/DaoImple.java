package ve.gob.gobiernoenlinea.dao.imple;


//import java.util.List;
//import javax.management.Query;
//import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import ve.gob.gobiernoenlinea.dao.Dao;
import org.hibernate.Query;

/**
 *
 * @author gerardo
 */
public class DaoImple extends HibernateDaoSupport implements Dao {
    
    @Override
    public void guardaroactualizar(Object tabla) {
       
        getHibernateTemplate().update(tabla);
        
        
    }
    
    @Override
     public <T> List<T> encontrarID(String selec){
         
     //Session s= this.openSession();
     
      List<T> lista =  getHibernateTemplate().find(selec);
     
     return lista;
     
     }
    
    @Override
    public Session openSession() {

		return this.getHibernateTemplate().getSessionFactory().openSession();

	}
    @Override
     public int persistencia () {
         
         Session session = null;
         Transaction tx = null;
         int Bandera = 0 ;

     try {
         session = openSession();
         tx = session.beginTransaction();
         tx.commit();
         Bandera = 1;
         }
      catch(Exception e) {
         if (tx != null)   {
     
             try  {
              tx.rollback();
              Bandera=2;
             }
             catch (HibernateException e1)  {
                 
             }
         }
       
      }
      finally {
          if (session != null) {
            try {
              session.close();
             }
            catch (HibernateException e)  {
            }
           }
     }
      return Bandera ;
    }

    @Override
    public void inser(Object tabla) {
              
        getHibernateTemplate().save(tabla);
        
    }

    // List<T> lista =  getHibernateTemplate().find(selec);
        @Override
        public <T> List<T> ListarAll(Class<T> entityClass) {
		List<T> entities = getHibernateTemplate().loadAll(entityClass);
		return entities;
	}

	@Override
	public <T> T EncontrarporID(Class<T> entityClass, Serializable id) {
		T entity = (T) getHibernateTemplate().get(entityClass, id);
		return entity;
	}
        
        
        public <T> T EncontrarObjectByHQL(String HQL) {
		Session s = this.openSession();
		Query qr = s.createQuery(HQL);
		T entity = (T) qr.uniqueResult();
		s.close();
		return entity;
	}

        
}