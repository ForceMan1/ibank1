import forceman.ibank.dao.ClientDAOJpa;
import forceman.ibank.dao.EmployeeDAOJpa;
import forceman.ibank.dao.IClientDAO;
import forceman.ibank.dao.IEmployeeDAO;
import forceman.ibank.entity.Client;
import forceman.ibank.entity.Employee;
import junit.framework.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by Igor on 01.11.2016.
 */
public class DAOTest {
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;
    private static EntityTransaction trx = null;
    private static IClientDAO clientDAO = null;
    private static IEmployeeDAO employeeDAO = null;

    private static Client client;
    private static Employee employee;

    @BeforeClass
    public static void createObjects(){
        emf = Persistence.createEntityManagerFactory("ibankJPATest");
        em = emf.createEntityManager();
        trx = em.getTransaction();
        clientDAO = new ClientDAOJpa(em);
        employeeDAO = new EmployeeDAOJpa(em);
    }

    @Test(priority = 1)
    public static void removeAllClients(){
        trx.begin();
        clientDAO.removeAll();
        Assert.assertTrue(clientDAO.getCount() == 0);
        trx.commit();
    }

    @Test(priority = 2)
    public static void createClients(){
        trx.begin();
        client = new Client("Zhernovkov", "Igor", "igor", "12345");
        clientDAO.persist(client);
        em.flush();
        trx.commit();
        //em.persist(cl);
        //em.flush();
        //cl = new Client("Smirnov", "Ivan", "ivan", "54321");
    }

    @AfterClass
    public static void destroyObjects(){
        em.close();
        emf.close();
    }


}
