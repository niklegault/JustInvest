package ca.carleton.niklegault.justInvest.problem4;

import ca.carleton.niklegault.justInvest.problem1.Roles;
import ca.carleton.niklegault.justInvest.problem1.User;
import ca.carleton.niklegault.justInvest.problem2.PasswordHashing;

public class LogIn {
    private PasswordHashing passwordHashing;

    public LogIn() {
        this.passwordHashing = new PasswordHashing();
    }

    public User logIn(String username, String password) {
        String filename = "passwd.txt";
        return logIn(username, password, filename);
    }

    protected User logIn(String username, String password, String filename) {
        Roles userRole = this.passwordHashing.readPassword(username, password, filename);
        if (userRole != null) {
            return new User(userRole, username);
        }
        return null;
    }
}
