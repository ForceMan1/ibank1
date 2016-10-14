package forceman.ibank.dao;
import forceman.ibank.dao.exception.*;

/**
 * Created by Igor on 21.09.2016.
 */

/**
 * Интерфейс аутентификации клиентов/работников
 */
public interface IAuthDAO {
    /**
     *  Проверка аутентификации клиента
     * @param login Логин клиента
     * @param password Пароль клиента
     * @return Идентификатор клиента
     * @throws IncorrectCredentialsException Ошибка неколлектных данных аутентификации
     */
    public long authUser(String login, String password) throws IncorrectCredentialsException;

    /**
     * Проверка аутентификации работника
     * @param login Логин работника
     * @param password Пароль работника
     * @return Идентификатор работника
     * @throws IncorrectCredentialsException Ошибка неколлектных данных аутентификации
     */
    public int authEmployee(String login, String password) throws IncorrectCredentialsException;
}
