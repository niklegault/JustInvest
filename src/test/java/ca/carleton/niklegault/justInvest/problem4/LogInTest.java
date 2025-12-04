package ca.carleton.niklegault.justInvest.problem4;

import ca.carleton.niklegault.justInvest.problem1.Roles;
import ca.carleton.niklegault.justInvest.problem1.User;
import ca.carleton.niklegault.justInvest.problem3.SignUp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class LogInTest {
    LogIn logIn = new LogIn();
    SignUp signUp = new SignUp();
    User testUser = new User(Roles.TELLER, "teller");
    String tellerPass = "G00dPas$";
    static final String FILEPATH = "test_passwd.txt";

    @AfterEach
    void tearDown() {
        File toDelete = new File(FILEPATH);
        if(toDelete.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("File not deleted");
        }
    }

    @BeforeEach
    void setUp() {
        signUp.register(tellerPass, testUser, FILEPATH);
    }

    @Test
    void logInRegisteredUserCorrectPassword() {
        assertEquals(logIn.logIn(testUser.getName(), tellerPass, FILEPATH), testUser);
    }

    @Test
    void logInNotRegisteredUser() {
        assertNull(logIn.logIn("telller", tellerPass, FILEPATH));
    }

    @Test
    void logInRegisteredUserIncorrectPassword() {
        assertNull(logIn.logIn(testUser.getName(), "should fail", FILEPATH));
    }
}