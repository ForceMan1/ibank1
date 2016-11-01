package forceman.ibank.dao;

import forceman.ibank.entity.Client;
import forceman.ibank.entity.Employee;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.NoSuchElementException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

/**
 * Created by Igor on 24.10.2016.
 */

public class EmployeeDAOJpa implements IEmployeeDAO {
    private EntityManager em;

    /**
     * �����������
     * @param em JPA Entity Manager
     * @throws NullPointerException ���� Entity Manager �� ������������������
     */
    public EmployeeDAOJpa(EntityManager em){ this.em = em; }


    /**
     * �������� ������ ��������
     *
     * @param id ������������� ��������
     * @return ������ �������� ��� null, ���� ������ �� ������
     * @throws IllegalArgumentException ���� ������ �������� �� �������� ����� �������� ���
     *                                  ������ �������� ������������� ���� ��� null
     */
    @Override
    public Employee get(Object id) {
        return em.find(Employee.class, id);
    }

    /**
     * �������� ������ �� ������ �������� ��� �� �������������
     *
     * @param id ������������� ��������
     * @return ������ �������� ��� ������������� ��� ������ ��� null, ���� ������ �� ������
     */
    @Override
    public Employee getLazy(Object id) {
        return em.getReference(Employee.class, id);
    }

    /**
     * ������� ��������
     *
     * @param employee ������ ��������
     * @throws IllegalArgumentException     �������� � ��������� ��������������� �� ����������
     * @throws TransactionRequiredException � ������ ���������� �������� ���������� ��� �������� ��������
     */
    @Override
    public void remove(Employee employee) {
        em.remove(employee);
    }

    /**
     * �������� ���-�� �������� ��������
     *
     * @return ���-�� �������� ��������
     */
    @Override
    public long getCount() {
        return em.createNamedQuery(Employee.QUERY_COUNT, Long.class).getSingleResult();
    }

    /**
     * ������� ��� ���������
     */
    @Override
    public void removeAll() {
        em.createNamedQuery(Employee.QUERY_DELETE_ALL_EMPLOYEES).executeUpdate();
    }

    /**
     * �������� ������ �������� ��������
     *
     * @param firstIndex ������ ������ ������� ������� ��������
     * @param maxResults ������������ ���-�� ������� ������� ��������
     * @return ������ �������� ��������
     */
    @Override
    public List<Employee> getEintities(int firstIndex, int maxResults) {
        return em.createNamedQuery(Employee.QUERY_GET_EMPLOYEES, Employee.class).setFirstResult(firstIndex)
                .setMaxResults(maxResults).getResultList();
    }

    /**
     * �������� ������ ������� ��������
     *
     * @param employee ������ ��������
     * @return ������ ��������
     * @throws NoSuchElementException ���� ������ �������� � ��������� ��������������� �� ����������
     */
    @Override
    public Employee update(Employee employee) {
        Employee e = em.find(Employee.class, employee.getId());
        if( e == null)
            throw new NoSuchElementException("Object of entity Employee with id=" + employee.getId() + " is not exist");
        e.update(employee);
        return e;
    }

    /**
     * Make an instance managed and persistent.
     *
     * @param employee entity instance
     * @throws EntityExistsException - if the entity already exists
     * @throws PersistenceException  may be thrown at flush or commit time
     */
    @Override
    public void persist(Employee employee) {
        em.persist(employee);
    }
}
