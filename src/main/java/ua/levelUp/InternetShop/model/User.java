package ua.levelUp.InternetShop.model;

//import org.springframework.data.annotation.Id; -----------------------

import javax.persistence.*;


/**
 * Created by java on 15.02.2016.
 */
@Entity
@Table(name = "user")
public class User {
    private long id;
    private String login;
    private String email;
    private String password;
    private Role role;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Enumerated(EnumType.STRING)
    public Role getRole(){
        return role;
    }

    public void setRole(Role role){
        this.role = role;
    }
}
