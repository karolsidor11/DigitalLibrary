package pl.sidor.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Data")
public class Login implements Serializable {


    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotEmpty(message = "Wprowadź poprawnie login !")
    @Size(min = 3, message = "Login powinien zawierać min 3 znaki !")
    private String login;

    @Column
    @NotEmpty(message = "Wprowadż poprawnie hasło !")
    @Size(min = 5, message = "Hasło powinno zawierać min. 5 znaków !")
    private String password;

    @OneToOne(mappedBy = "login")
    private User user;

    public User getUser() {
        return user;
    }

    public Login() {
    }

    public Login(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Login{" + "id=" + id + ", login='" + login + '\'' + ", password='" + password + '\'' + ", user=" + user + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login1 = (Login) o;
        return id == login1.id && Objects.equals(login, login1.login) && Objects.equals(password, login1.password) && Objects.equals(user, login1.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password, user);
    }
}
