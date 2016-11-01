package forceman.ibank.dao;

import forceman.ibank.entity.Client;

import javax.persistence.*;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Igor on 14.10.2016.
 */
public class ClientDAOJpa implements IClientDAO {
    private EntityManager em;

    /**
     * Конструктор
     * @param em JPA Entity Manager object
     * @throws NullPointerException Если Entity Manager не инициализирован
     */
    public ClientDAOJpa(EntityManager em){
        if( em == null )
            throw new NullPointerException("Entity Manager is not initialized");
        this.em = em;
    }


    /**
     * Получить объект сущности
     *
     * @param id Идентификатор сущности
     * @return Объект сущности или null, если объект не найден
     * @throws IllegalArgumentException Если первый аргумент не является типом сущности или
     *                                  второй аргумент некорректного типа или null
     */
    @Override
    public Client get(Object id) {
        return em.find(Client.class, id);
    }

    /**
     * Получить ссылку на объект сущности без ее инициализации
     *
     * @param id Идентификатор сущности
     * @return Объект сущности без инициализации его данных или null, если объект не найден
     */
    @Override
    public Client getLazy(Object id) {
        return em.getReference(Client.class, id);
    }

    /**
     * Удалить сущность
     *
     * @param client Объект сущности
     * @throws IllegalArgumentException Если указанный объект не экземпляр сущности Client или удален из контекста EntityManager
     * @c
     */
    @Override
    public void remove(Client client) {
        em.remove(client);

    }

    /**
     * Получить кол-во объектов сущности
     *
     * @return кол-во объектов сущности
     */
    @Override
    public long getCount() {
        return em.createNamedQuery(Client.QUERY_COUNT, Long.class).getSingleResult();
    }

    /**
     * Удалить все элементыы
     */
    @Override
    public void removeAll() {
        em.createNamedQuery(Client.QUERY_DELETE_ALL_CLIENTS).executeUpdate();
    }

    /**
     * Получить список объектов сущности
     *
     * @param firstIndex Индекс записи первого объекта сущности
     * @param maxResults Макисмальное количество записей объекта сущности
     * @return список объектов сущности
     */
    @Override
    public List<Client> getEintities(int firstIndex, int maxResults) {
       return em.createNamedQuery(Client.QUERY_GET_CLIENTS, Client.class).setFirstResult(firstIndex)
               .setMaxResults(maxResults).getResultList();

    }

    /**
     * Обновить данные объекта сущности
     *
     * @param client Объект сущности
     * @return Объект сущности
     * @throws NoSuchElementException Если объект сущности с указанным идентификатором не существует
     */
    @Override
    public Client update(Client client) throws NoSuchElementException {
        //Client cl = getLazy(client.getId());
        Client cl = get(client.getId());
        if(cl == null)
            throw new NoSuchElementException("Object of Client entity (id = " + client.getId() + " ) is not exists");
        cl.update(client);
        return cl;
     }

    /**
     * Make an instance managed and persistent.
     *
     * @param client entity instance
     * @throws EntityExistsException - if the entity already exists
     * @throws PersistenceException  may be thrown at flush or commit time
     */
    @Override
    public void persist(Client client) {
        em.persist(client);
    }
}
