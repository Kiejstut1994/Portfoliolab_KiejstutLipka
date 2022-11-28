package pl.coderslab.charity.Classes;

import lombok.Data;
import lombok.ToString;
import org.w3c.dom.stylesheets.LinkStyle;
import pl.coderslab.charity.Classes.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @Size(min = 5,max = 20,message = "Imię między 5 a 20 znaków")
    private String name;
    @Column(name = "surname")
    @Size(min = 5,max = 20,message = "Nazwisko między 5 a 20 znaków")
    private String surname;
    @Column(name = "email")
    @Email(message = "Nieprawidłowy email")
    @NotEmpty(message = "To pole nie może być puste")
    private String username;
    //zamienić email na username
    @Column(name = "password")
    @Size(min = 5,max = 100,message = "Hasło między 5 a 100 znaków")
    private String password;
    @Column(name = "active")
    private boolean isactive;
    @ManyToOne
    @JoinColumn(name = "role_id")
    @ToString.Exclude
    private Role role;

    public User() {
    }

    public User(Long id, String name, String surname, String username, String password,boolean isactive ,Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.isactive=isactive;
        this.role = role;

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
