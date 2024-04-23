package com.magicvet.component;

import com.magicvet.Main;
import com.magicvet.model.Client;
import com.magicvet.model.Pet;
import com.magicvet.service.ClientService;
import com.magicvet.service.PetService;

public class ApplicationRunner {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if (client != null) {
                boolean isValidInput = false;

                while (!isValidInput) {
                    System.out.print("Do you want add a pet? ('y'/'n'): ");
                    char choice = Main.SCANNER.next().charAt(0);
                    Main.SCANNER.nextLine();


                    switch (choice) {
                        case 'y' -> {
                            System.out.println("Adding a new pet.");
                            Pet pet = petService.registerNewPet();
                            if (pet != null) {
                                client.setPet(pet);
                                pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                                System.out.println("Pet has been added.");
                            }

                            System.out.println(client);
                            isValidInput = true;
                        }
                        case 'n' -> {
                            System.out.println("No pet added.");
                            System.out.println(client);
                            isValidInput = true;
                        }

                        default ->
                                System.out.println("You must enter only one of the values yes('y') or no('n'). "
                                        + "Try again.");
                    }
                }

            }
        }
    }
}
