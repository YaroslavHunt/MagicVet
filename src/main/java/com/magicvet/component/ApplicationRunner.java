package com.magicvet.component;

import com.magicvet.model.Client;
import com.magicvet.model.Pet;
import com.magicvet.service.ClientService;
import com.magicvet.service.PetService;

public class ApplicationRunner {

    private ClientService clientService = new ClientService();
    private PetService petService = new PetService();

    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if(client != null) {
                System.out.println("Adding a new pet.");
                Pet pet = petService.registerNewPet();
                client.setPet(pet);
                pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                System.out.println("Pet has been added.");
            }
        }
    }
}
