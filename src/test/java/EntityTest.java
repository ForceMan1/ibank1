import forceman.ibank.dao.ClientDAOJpa;
import forceman.ibank.dao.EmployeeDAOJpa;
import forceman.ibank.dao.IClientDAO;
import forceman.ibank.dao.IEmployeeDAO;
import forceman.ibank.entity.Client;
import forceman.ibank.entity.Employee;
import junit.framework.Assert;
import org.testng.annotations.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by Igor on 22.09.2016.
 */


public class EntityTest {
    private static EntityManager em = null;
    private static EntityTransaction trx = null;
    private static Client cl;
    private static Employee empl;
    private static IClientDAO clientDAO;
    private static IEmployeeDAO emplDAO;

    @BeforeClass
    public void createEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ibankJPATest");
        em = emf.createEntityManager();
        trx = em.getTransaction();
        clientDAO = new ClientDAOJpa(em);
        emplDAO = new EmployeeDAOJpa(em);

    }

    @Test(priority=1, description="??????? ???????? ????????/??????/????????/????????? ???????? ??????")
    public static void testEntityClient(){
       try {
            trx.begin();
            cl = new Client("Zhernovkov", "Igor", "igor", "12345");
            em.persist(cl);
            em.flush();
            cl = new Client("Smirnov", "Ivan", "ivan", "54321");
            em.persist(cl);
            em.flush();
            em.clear();

            //cl = new Client("Smirnov", "Ivan", "ivan", "54321");
            cl.setLogin("SmirnovBoss");
            clientDAO.update(cl);
            trx.commit();
        }catch(Exception exc){
            exc.printStackTrace();
            if(trx.isActive())
                trx.rollback();
        }
      }

    @Test(priority=2, description = "??????? ???????? ????????/??????/????????/????????? ???????? ????????")
    public static void testEntityEmployee(){
        try {
            empl = new Employee("?????????? ??????? ?????????????", "rabotnik", "12345");
            em.persist(empl);
            em.flush();
            empl = new Employee("???????? ???? ??????", "rab", "12345");
            em.persist(empl);
            em.flush();
            em.clear();

            empl.setLogin("rab1");

        }catch(Exception exc){

        }

    }

    @Test(priority=3)
    public static void removeAllObjects(){
        trx.begin();
        clientDAO.removeAll();
        trx.commit();
        Assert.assertTrue(clientDAO.getCount() == 0);
        trx.begin();
        emplDAO.removeAll();
        trx.commit();
        Assert.assertTrue(emplDAO.getCount() == 0);
    }
    //@Test(priority=2, description="??????????")
    //public static void

    @AfterClass
    public static void closeEntityManager(){
        em.close();
    }
}
