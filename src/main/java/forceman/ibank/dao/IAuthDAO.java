package forceman.ibank.dao;
import forceman.ibank.dao.exception.*;

/**
 * Created by Igor on 21.09.2016.
 */

/**
 * ��������� �������������� ��������/����������
 */
public interface IAuthDAO {
    /**
     *  �������� �������������� �������
     * @param login ����� �������
     * @param password ������ �������
     * @return ������������� �������
     * @throws IncorrectCredentialsException ������ ������������ ������ ��������������
     */
    public long authUser(String login, String password) throws IncorrectCredentialsException;

    /**
     * �������� �������������� ���������
     * @param login ����� ���������
     * @param password ������ ���������
     * @return ������������� ���������
     * @throws IncorrectCredentialsException ������ ������������ ������ ��������������
     */
    public int authEmployee(String login, String password) throws IncorrectCredentialsException;
}
