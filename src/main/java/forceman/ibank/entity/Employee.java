package forceman.ibank.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Igor on 20.09.2016.
 */

@Entity
public class Employee {
    @GeneratedValue
    @Id
    private Integer id;

    @Basic(optional=false)
    private String fio;

    @Basic(optional = false)
    private String login;

    private String pass;

    public Employee(){}

    public Employee(String fio, String login, String pass) {
        this.fio = fio;
        this.login = login;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }




}
