package forceman.ibank.entity;

import javax.persistence.*;

/**
 * Created by Igor on 20.09.2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Client.QUERY_COUNT, query = "SELECT COUNT(c.id) FROM Client c"),
        @NamedQuery(name = Client.QUERY_GET_CLIENTS, query = "SELECT c FROM Client c"),
        @NamedQuery(name=Client.QUERY_DELETE_ALL_CLIENTS, query="DELETE FROM Client c")
})
public class Client {
    public static final String QUERY_COUNT="countClients";
    public static final String QUERY_GET_CLIENTS="getClients";
    public static final String QUERY_DELETE_ALL_CLIENTS="deleteAllClients";

    @GeneratedValue
    @Id
    private Long id;

    @Basic(optional=false)
    private String surname;

    @Basic(optional=false)
    private String name;

    @Basic(optional=false)
    private String login;


    private String pass;

    public Client(){}

    public Client(String surname, String name, String login, String pass){
        this.surname = surname;
        this.name = name;
        this.login = login;
        this.pass = pass;
    }

    public void update(Client updClient) throws IllegalArgumentException {
        if( !this.getId().equals( updClient.getId() ) )
            throw new IllegalArgumentException("Primary keys of objects are not the same");
        surname = updClient.getSurname();
        name = updClient.getName();
        login = updClient.getLogin();
        pass = updClient.getPass();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
