package forceman.ibank.entity;

import javax.persistence.*;

/**
 * Created by Igor on 20.09.2016.
 */


@NamedQueries({
    @NamedQuery(name=Employee.QUERY_COUNT, query = "SELECT COUNT(e.id) FROM Employee e"),
        @NamedQuery(name=Employee.QUERY_GET_EMPLOYEES, query="SELECT e FROM Employee e"),
        @NamedQuery(name=Employee.QUERY_DELETE_ALL_EMPLOYEES, query = "DELETE FROM Employee e")
})
@Entity
public class Employee {
    public static final String QUERY_COUNT="countEmployees";
    public static final String QUERY_GET_EMPLOYEES="getEmployees";
    public static final String QUERY_DELETE_ALL_EMPLOYEES="deleteAllEmployees";

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

    public void update(Employee e) throws IllegalArgumentException {
        if(getId() != e.getId())
            throw new IllegalArgumentException("Primary keys of objects are not the same");
        this.fio = e.getFio();
        this.login = e.getLogin();
        this.pass = e.getPass();
    }
}
