package ca.carleton.niklegault.justInvest;

import ca.carleton.niklegault.justInvest.problem1.AccessControl;
import ca.carleton.niklegault.justInvest.problem1.Actions;
import ca.carleton.niklegault.justInvest.problem1.Roles;
import ca.carleton.niklegault.justInvest.problem1.User;
import ca.carleton.niklegault.justInvest.problem2.PasswordHashing;

import java.util.Scanner;

/**
 * Currently just a placeholder, will be the main method for the JustInvest system.
 * @author Nik Legault 101229919
 */
public class Application {
    private static boolean running;
    private static boolean loggedIn;

    public static void main(String[] args) {
        running = true;
        loggedIn = false;
        while(running) {
            printOptions();
            takeInput();
        }
    }

    private static void printOptions() {
        System.out.println("justInvest System");
        System.out.println("----------------------------------------");
        System.out.println("Operations available on the system:");
        System.out.println("1. View account balance");
        System.out.println("2. View investment portfolio");
        System.out.println("3. Modify investment portfolio");
        System.out.println("4. View Financial Advisor contact info");
        System.out.println("5. View Financial Planner contact info");
        System.out.println("6. View money market instruments");
        System.out.println("7. View private consumer instruments\n");
        if(!loggedIn) {
            System.out.println("(S)ign up");
            System.out.println("(L)og in");
        }
        System.out.println("(E)xit");
    }

    private static void takeInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

    }
}
