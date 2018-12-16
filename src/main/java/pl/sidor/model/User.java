package pl.sidor.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotEmpty(message = "Proszę wprowadzić imię !")
    private String name;

    @Column
    @NotEmpty(message = "Proszę wprowadzić nazwisko !")
    private String lastName;


    @Column
//    @Email(message = "Proszę wprowadzić  poprawnie email !")
    @NotEmpty(message = "Proszę wprowadzić email !")
    private String email;

    @Column
    @NotEmpty(message = "Proszę wprowadzić adres ! ")
    private String adres;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id")
    private Login login;


    public User() {
    }

    public User(String name, String lastName, String email, String adres, Login login) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.adres = adres;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", adres='" + adres + '\'' + ", login=" + login + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(adres, user.adres) && Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, lastName, email, adres, login);
    }
}
