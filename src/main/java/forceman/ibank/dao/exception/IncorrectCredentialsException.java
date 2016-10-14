package forceman.ibank.dao.exception;

/**
 * Created by Igor on 21.09.2016.
 * Ошибка некорректной пары логин-пароль при аутентификации
 */
public class IncorrectCredentialsException extends Exception {
    public IncorrectCredentialsException(String message){
        super(message);
    }

    public IncorrectCredentialsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
