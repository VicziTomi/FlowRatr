package hu.flowacademy.FlowRatr.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column
    private String username;

    @Column
    private String fullname;

    @Column
    private String password;

    @Column
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Badge> badges;


    public User(String username, String fullname, String password, String role) {
        this.username = Objects.requireNonNull(username);
        this.fullname = fullname;
        this.password = password;
        this.role = role;
    }

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}