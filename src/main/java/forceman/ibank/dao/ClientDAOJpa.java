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
     * �������� ������ ��������
     *
     * @param id ������������� ��������
     * @return ������ �������� ��� null, ���� ������ �� ������
     * @throws IllegalArgumentException ���� ������ �������� �� �������� ����� �������� ���
     *                                  ������ �������� ������������� ���� ��� null
     */
    @Override
    public Client get(Object id) {
        return em.find(Client.class, id);
    }

    /**
     * �������� ������ �� ������ �������� ��� �� �������������
     *
     * @param id ������������� ��������
     * @return ������ �������� ��� ������������� ��� ������ ��� null, ���� ������ �� ������
     */
    @Override
    public Client getLazy(Object id) {
        return em.getReference(Client.class, id);
    }

    /**
     * ������� ��������
     *
     * @param client ������ ��������
     * @throws IllegalArgumentException ���� ��������� ������ �� ��������� �������� Client ��� ������ �� ��������� EntityManager
     * @throws TransactionRequiredException
     */
    @Override
    public void remove(Client client) {
        em.remove(client);

    }

    /**
     * �������� ���-�� �������� ��������
     *
     * @return ���-�� �������� ��������
     */
    @Override
    public long getCount() {
        return em.createNamedQuery(Client.QUERY_COUNT, Long.class).getSingleResult();
    }

    /**
     * �������� ������ �������� ��������
     *
     * @param firstIndex ������ ������ ������� ������� ��������
     * @param maxResults ������������ ���������� ������� ������� ��������
     * @return ������ �������� ��������
     */
    @Override
    public List<Client> getEintities(int firstIndex, int maxResults) {
       return em.createNamedQuery(Client.QUERY_GET_CLIENTS, Client.class).setFirstResult(firstIndex)
               .setMaxResults(maxResults).getResultList();

    }

    /**
     * �������� ������ ������� ��������
     *
     * @param client ������ ��������
     * @return ������ ��������
     * @throws NoSuchElementException ���� ������� �������� � ��������� ��������������� �� ����������
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
