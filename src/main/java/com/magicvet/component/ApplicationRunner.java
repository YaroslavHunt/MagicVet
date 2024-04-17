package com.magicvet.component;

import com.magicvet.Main;
import com.magicvet.model.Client;
import com.magicvet.model.Pet;
import com.magicvet.service.ClientService;
import com.magicvet.service.PetService;

import java.util.regex.Pattern;

public class ApplicationRunner {

    private ClientService clientService = new ClientService();
    private PetService petService = new PetService();

    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if(client != null) {
                System.out.print("Do you want add a pet? ('y'/'n'): ");
                char choice = Main.SCANNER.next().charAt(0);

                switch (choice) {
                    case 'y' -> {
                        System.out.println("Adding a new pet.");
                        Pet pet = petService.registerNewPet();
                        client.setPet(pet);
                        pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                        System.out.println("Pet has been added.");
                    }
                    case 'n' ->
                        System.out.println("No pet added.");

                    default ->
                        System.out.println("You must enter only one of the values yes('y') or no('n'). Try again.");
                }

            }
        }
    }
}
