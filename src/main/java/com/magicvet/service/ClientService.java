package com.magicvet.service;

import com.magicvet.Main;
import com.magicvet.model.Client;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String FIRST_LAST_NAME_PATTERN = "^[A-Z][a-z]{2,}(-[A-Z][a-z]{2,})?$";

    public Optional<Client> registerNewClient() {
        Client client = null;
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.println("Please provide client details.");
            System.out.print("Email: ");
            String email = Main.SCANNER.nextLine();
            System.out.print("First name: ");
            String firstName = Main.SCANNER.nextLine();
            System.out.print("Last name: ");
            String lastName = Main.SCANNER.nextLine();

            if (!isEmailValid(email)) {
                System.out.println("Provided email is invalid.");
            }
            if (!isFirstNameValid(firstName)) {
                System.out.println("Provided name is invalid."
                        + "The name must start with a capital letter and contain at least three characters");
            }
            if (!isLastNameValid(lastName)) {
                System.out.println("Provided lastname is invalid."
                        + "The lastname must start with a capital letter and contain at least three characters");
            }
            if (isEmailValid(email) && isFirstNameValid(firstName) && isLastNameValid(lastName)) {
                client = buildClient(email, firstName, lastName);
                System.out.println("New client: " + client.getFirstName() + " "
                        + client.getLastName() + " ("
                        + client.getEmail() + ")");
                isValidInput = true;
            } else {
                System.out.println("Try again.");
            }
        }
        return Optional.ofNullable(client);
    }

    private static Client buildClient(String email, String firstName, String lastName) {
        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);

        System.out.print("Location: ");
        Client.Location location;
        String locationInput = Main.SCANNER.nextLine();
        try {
            location = Client.Location.valueOf(locationInput);
        } catch (IllegalArgumentException e) {
            location = Client.Location.UNKNOWN;
            System.out.println("Unable to parse value '" + locationInput
                    + "'. Using default value: " + Client.Location.UNKNOWN);
        }

        client.setLocation(location);

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
