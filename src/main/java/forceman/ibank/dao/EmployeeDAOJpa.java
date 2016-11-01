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
     * Конструктор
     * @param em JPA Entity Manager
     * @throws NullPointerException Если Entity Manager не проинициализирован
     */
    public EmployeeDAOJpa(EntityManager em){ this.em = em; }


    /**
     * Получить объект сущности
     *
     * @param id Идентификатор сущности
     * @return Объект сущности или null, если объект не найден
     * @throws IllegalArgumentException Если первый аргумент не является типом сущности или
     *                                  второй аргумент некорректного типа или null
     */
    @Override
    public Employee get(Object id) {
        return em.find(Employee.class, id);
    }

    /**
     * Получить ссылку на объект сущности без ее инициализации
     *
     * @param id Идентификатор сущности
     * @return Объект сущности без инициализации его данных или null, если объект не найден
     */
    @Override
    public Employee getLazy(Object id) {
        return em.getReference(Employee.class, id);
    }

    /**
     * Удалить сущность
     *
     * @param employee Объект сущности
     * @throws IllegalArgumentException     Сущность с указанным идентификатором не существует
     * @throws TransactionRequiredException В случае отсутствия активной транзакции при удалении сущности
     */
    @Override
    public void remove(Employee employee) {
        em.remove(employee);
    }

    /**
     * Получить кол-во объектов сущности
     *
     * @return кол-во объектов сущности
     */
    @Override
    public long getCount() {
        return em.createNamedQuery(Employee.QUERY_COUNT, Long.class).getSingleResult();
    }

    /**
     * Удалить все элементыы
     */
    @Override
    public void removeAll() {
        em.createNamedQuery(Employee.QUERY_DELETE_ALL_EMPLOYEES).executeUpdate();
    }

    /**
     * Получить список объектов сущности
     *
     * @param firstIndex Индекс записи первого объекта сущности
     * @param maxResults Максимальное кол-во записей объекта сущности
     * @return список объектов сущности
     */
    @Override
    public List<Employee> getEintities(int firstIndex, int maxResults) {
        return em.createNamedQuery(Employee.QUERY_GET_EMPLOYEES, Employee.class).setFirstResult(firstIndex)
                .setMaxResults(maxResults).getResultList();
    }

    /**
     * Обновить данные объекта сущности
     *
     * @param employee Объект сущности
     * @return Объект сущности
     * @throws NoSuchElementException Если объект сущности с указанным идентификатором не существует
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
