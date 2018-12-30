package pl.sidor.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {


    private Integer id;
    @NotEmpty
    @Size(min = 5, max = 15, message = "Nazwa użytkownika musi zawierać min. 3 znaków !!!")
    private String name;
    @NotEmpty
    @Email(message = "Niepoprawnie wpisany adres eamil !!!")
    private String email;
    @NotEmpty
    @Size(min = 5, max = 15, message = "Login musi zawierać min. 5 znaków !!!")
    private String login;
    @NotEmpty
    @Size(min = 5, max = 15, message = "Hasło musi zawierać min. 5 znaków !!!")
    private String password;

    public User() {
    }

    public User(Integer id, String name, String email, String login, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", login='" + login + '\'' + ", password='" + password + '\'' + '}';
    }
}