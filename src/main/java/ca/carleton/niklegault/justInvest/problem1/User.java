package ca.carleton.niklegault.justInvest.problem1;

import java.util.Objects;

/**
 * A user of the JustInvest System
 * @author Nik Legault 101229919
 */
public class User {
    private Roles role;
    private String name; // Username of the user for login purposes

    public User(Roles role, String name) {
        this.name = name;
        this.role = role;
    }

    public Roles getRole() {
        return this.role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return role == user.role && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, name);
    }
}
