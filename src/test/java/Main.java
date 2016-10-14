import forceman.ibank.dao.ClientDAOJpa;
import forceman.ibank.dao.IClientDAO;
import forceman.ibank.entity.Client;
import org.testng.annotations.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Igor on 22.09.2016.
 */


public class Main {
    private static EntityManager em = null;
    private static Client cl;
    private static IClientDAO clientDAO;

    @BeforeSuite
    public void createEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ibankJPATest");
        em = emf.createEntityManager();
        clientDAO = new ClientDAOJpa(em);

    }

    @Test(priority=1, description="Сохранение")
    public static void persistClient(){
        cl = new Client("Zhernovkov", "Igor", "igor", "12345");
        em.persist(cl);
        cl = new Client("Smirnov", "Ivan", "ivan", "54321");
        em.persist(cl);
        //em.clear();

        clientDAO.update(cl);

    }

    //@Test(priority=2, description="Обновление")
    //public static void

    @AfterSuite
    public static void closeEntityManager(){
        em.close();
    }
}
