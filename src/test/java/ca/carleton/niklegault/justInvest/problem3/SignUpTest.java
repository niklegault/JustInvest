package ca.carleton.niklegault.justInvest.problem3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignUpTest {

    @Test
    void validPassword() {
        SignUp signUp = new SignUp();

        String username = "Testing1!";
        String p1  = "Testing1!"; // matches username
        String p2  = "pAssword"; // common password
        String p3  = "Abcd1234@"; // common password
        String p4  = "G00dPas$"; // good password
        String p5  = "Sh0rt!"; // too short
        String p6  = "TooL0ngPa$$w0rD"; // too long
        String p7  = "NoNumber!"; // no number
        String p8  = "NoSymbol1"; // no symbol
        String p9  = "nocap$123"; // no caps
        String p10 = "NOLOWER$1"; // no lowercase

        assertFalse(signUp.validPassword(p1, username));
        assertFalse(signUp.validPassword(p2, username));
        assertFalse(signUp.validPassword(p3, username));
        assertTrue(signUp.validPassword(p4, username));
        assertFalse(signUp.validPassword(p5, username));
        assertFalse(signUp.validPassword(p6, username));
        assertFalse(signUp.validPassword(p7, username));
        assertFalse(signUp.validPassword(p8, username));
        assertFalse(signUp.validPassword(p9, username));
        assertFalse(signUp.validPassword(p10, username));


    }

}