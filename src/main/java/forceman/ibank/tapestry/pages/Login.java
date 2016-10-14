package forceman.ibank.tapestry.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.Messages;

import javax.inject.Inject;

/**
 * Created by Igor on 21.09.2016.
 */
public class Login {
    @Inject
    private Messages messages;

    @Property
    @Validate("minLength=6, maxLength=20")
    private String login;

    @Validate("minLength=8, maxLength=20")
    @Property
    private String password;

    @InjectComponent("loginForm")
    private Form loginForm;

    @InjectComponent("login")
    private TextField loginField;

    @InjectComponent("password")
    private PasswordField passwordField;

    public String getTitle(){
        return messages.get("LOGIN_FORM_TITLE");
    }

    public String getSubmit(){
        return messages.get("LOGIN_FORM_SUBMIT_VALUE");
    }

    void onValidateFromLoginForm(){
        if(login == null || login.isEmpty()){
            loginForm.recordError(loginField, messages.get("VALIDATE_ERROR_EMPTY_LOGIN"));
        }
        if(password == null || password.isEmpty()) {
            loginForm.recordError(passwordField, messages.get("VALIDATE_ERROR_EMPTY_PASSWORD"));
        }
    }

    void onSuceessFromLoginForm(){

    }
}
