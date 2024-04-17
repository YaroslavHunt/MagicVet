package com.magicvet.service;

import com.magicvet.Main;
import com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static String FIRST_LAST_NAME_PATTERN = "^[a-zA-Z]+[-a-zA-Z]{3,}$";

    public Client registerNewClient() {
        Client client = null;

        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();
        System.out.print("First name: ");
        String firstName = Main.SCANNER.nextLine();
        System.out.print("Last name: ");
        String lastName = Main.SCANNER.nextLine();

        if(!isEmailValid(email)) {
            System.out.println("Provided email is invalid.");
        }
        if(!isFirstNameValid(firstName)){
            System.out.println("Provided name is invalid.");
        }
        if(!isLastNameValid(lastName)){
            System.out.println("Provided lastname is invalid.");
        }
        if(isEmailValid(email) && isFirstNameValid(firstName) && isLastNameValid(lastName)) {
            client = buildClient(email, firstName, lastName);
            System.out.println("New client: " + client.getFirstName() + " "
                    + client.getLastName() + " ("
                    + client.getEmail() + ")");
        } else {
            System.out.println("Try again.");
        }
        return client;
    }

    private static Client buildClient(String email, String firstName, String lastName) {
        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);

        return client;
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private static boolean isFirstNameValid(String firstName) {
        Pattern pattern = Pattern.compile(FIRST_LAST_NAME_PATTERN);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }
    private static boolean isLastNameValid(String lastName) {
        Pattern pattern = Pattern.compile(FIRST_LAST_NAME_PATTERN);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }
}
