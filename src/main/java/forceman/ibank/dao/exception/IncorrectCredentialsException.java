package forceman.ibank.dao.exception;

/**
 * Created by Igor on 21.09.2016.
 * ������ ������������ ���� �����-������ ��� ��������������
 */
public class IncorrectCredentialsException extends Exception {
    public IncorrectCredentialsException(String message){
        super(message);
    }

    public IncorrectCredentialsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
