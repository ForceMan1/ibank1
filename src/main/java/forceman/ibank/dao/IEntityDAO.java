package forceman.ibank.dao;

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
     * @throws IllegalArgumentException, TransactionRequiredException
     */
    void remove(T t);

    /**
     * �������� ���-�� �������� ��������
     * @return ���-�� �������� ��������
     */
    long getCount();

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
}
