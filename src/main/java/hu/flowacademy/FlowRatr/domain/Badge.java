package hu.flowacademy.FlowRatr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "badge")
public class Badge {

    @Id
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private byte[] content;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_badge_user_id"))
    private User user;

    @JsonIgnore
    @ManyToMany(mappedBy = "badgeSet")
    private Set<User> userSet;

    public Badge(long id, String name, byte[] content, User user) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.content = content;
        this.user = Objects.requireNonNull(user);
    }

    public void addUser(User user) {
        this.userSet.add(user);
    }

    public Badge() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
