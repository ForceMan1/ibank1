package forceman.ibank.dao;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
import java.util.List;

/**
 * Created by Igor on 14.10.2016.
 */

/**
 * ��������� ���������� ����������
 * @param <T> ��� ��������
 */
public interface IEntityDAO <T> {
    /**
     * �������� ������ ��������
     * @param id ������������� ��������
     * @return ������ �������� ��� null, ���� ������ �� ������
     * @throws IllegalArgumentException ���� ������ �������� �� �������� ����� �������� ���
     *                                             ������ �������� ������������� ���� ��� null
     */
    T get(Object id);

    /**
     * �������� ������ �� ������ �������� ��� �� �������������
     * @param id ������������� ��������
     * @return ������ �������� ��� ������������� ��� ������ ��� null, ���� ������ �� ������
     */
    T getLazy(Object id);

    /**
     * ������� ��������
     * @param t ������ ��������
     * @throws IllegalArgumentException �������� � ��������� ��������������� �� ����������
     * @throws TransactionRequiredException � ������ ���������� �������� ���������� ��� �������� ��������
     */
    void remove(T t);

    /**
     * �������� ���-�� �������� ��������
     * @return ���-�� �������� ��������
     */
    long getCount();

    /**
     * ������� ��� ���������
     */
    void removeAll();


    /**
     * �������� ������ �������� ��������
     * @param firstIndex ������ ������ ������� ������� ��������
     * @param maxResults ������������ ���-�� ������� ������� ��������
     * @return ������ �������� ��������
     */
    List<T> getEintities(int firstIndex, int maxResults);

    /**
     * �������� ������ ������� ��������
     * @param t ������ ��������
     * @return ������ ��������
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
