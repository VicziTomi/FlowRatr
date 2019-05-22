package hu.flowacademy.FlowRatr.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "users_badge",
            joinColumns = @JoinColumn(name = "users_username"),
            inverseJoinColumns = @JoinColumn(name = "badge_id"))
    private Set<Badge> badgeSet;


    public User(String username, String fullname, String password, String role) {
        this.username = Objects.requireNonNull(username);
        this.fullname = fullname;
        this.password = password;
        this.role = role;
    }

    public User() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) &&
                Objects.equals(fullname, user.fullname) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role) &&
                Objects.equals(badges, user.badges) &&
                Objects.equals(badgeSet, user.badgeSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, fullname, password, role, badges, badgeSet);
    }

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
