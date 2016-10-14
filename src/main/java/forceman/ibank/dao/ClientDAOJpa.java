package forceman.ibank.dao;

import forceman.ibank.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Igor on 14.10.2016.
 */
public class ClientDAOJpa implements IClientDAO {
    private EntityManager em;

    public ClientDAOJpa(EntityManager em){
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
     * @throws TransactionRequiredException
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
     * @throws NoSuchElementException Если объектс сущности с указанным идентификатором не существует
     */
    @Override
    public Client update(Client client) throws NoSuchElementException {
        Client cl = getLazy(client.getId());
        if(cl == null)
            throw new NoSuchElementException("Object of Client entity (id = " + client.getId() + " ) is not exists");
        cl.update(client);

        return null;
    }
}
