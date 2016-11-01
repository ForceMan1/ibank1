package forceman.ibank.dao;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
import java.util.List;

/**
 * Created by Igor on 14.10.2016.
 */

/**
 * Интрефейс управления сущностями
 * @param <T> Тип сущности
 */
public interface IEntityDAO <T> {
    /**
     * Получить объект сущности
     * @param id Идентификатор сущности
     * @return Объект сущности или null, если объект не найден
     * @throws IllegalArgumentException Если первый аргумент не является типом сущности или
     *                                             второй аргумент некорректного типа или null
     */
    T get(Object id);

    /**
     * Получить ссылку на объект сущности без ее инициализации
     * @param id Идентификатор сущности
     * @return Объект сущности без инициализации его данных или null, если объект не найден
     */
    T getLazy(Object id);

    /**
     * Удалить сущность
     * @param t Объект сущности
     * @throws IllegalArgumentException Сущность с указанным идентификатором не существует
     * @throws TransactionRequiredException В случае отсутствия активной транзакции при удалении сущности
     */
    void remove(T t);

    /**
     * Получить кол-во объектов сущности
     * @return кол-во объектов сущности
     */
    long getCount();

    /**
     * Удалить все элементыы
     */
    void removeAll();


    /**
     * Получить список объектов сущности
     * @param firstIndex Индекс записи первого объекта сущности
     * @param maxResults Максимальное кол-во записей объекта сущности
     * @return список объектов сущности
     */
    List<T> getEintities(int firstIndex, int maxResults);

    /**
     * Обновить данные объекта сущности
     * @param t Объект сущности
     * @return Объект сущности
     */
    T update(T t);

    /**
     * Make an instance managed and persistent.
     * @param t entity instance
     * @throws EntityExistsException  - if the entity already exists
     * @throws PersistenceException may be thrown at flush or commit time
     *
     */
    void persist(T t);
}
