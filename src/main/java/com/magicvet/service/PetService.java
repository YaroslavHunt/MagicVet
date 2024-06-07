package com.magicvet.service;

import com.magicvet.Main;
import com.magicvet.model.Cat;
import com.magicvet.model.Client;
import com.magicvet.model.Dog;
import com.magicvet.model.Pet;

public class PetService {

    private static final String DOG_TYPE = "dog";
    private static final String CAT_TYPE = "cat";

    public Pet registerNewPet() {
        Pet pet = null;

        System.out.print("Type (dog / cat): ");
        String type = Main.SCANNER.nextLine();

        if (DOG_TYPE.equals(type) || CAT_TYPE.equals(type)) {
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type: " + type);
        }

        return pet;
    }

    private Pet buildPet(String type) {
        Pet pet = type.equals(CAT_TYPE) ? new Cat() : new Dog();
        pet.setType(type);

        System.out.print("Age: ");
        pet.setAge(Main.SCANNER.nextLine());

        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());

        System.out.print("Sex (male / female): ");
        pet.setSex(Main.SCANNER.nextLine());

        System.out.println("Health state (GOOD_HEALTH, " +
                        "INJURY, " +
                        "DIGESTIVE_UPSET, " +
                        "RESPIRATORY_INFECTION, " +
                        "SKIN_IRRITATION, " +
                        "CHRONIC_CONDITION, " +
                        "EMERGENCY): ");
            Pet.HealthState healthState;
            String healthStateInput = Main.SCANNER.nextLine();
                try {
                    healthState = Pet.HealthState.valueOf(healthStateInput);
                } catch (IllegalArgumentException e) {
                    healthState = Pet.HealthState.UNKNOWN;
                    System.out.println("Unable to parse value '" + healthStateInput
                            + "'. Using default value: " + Pet.HealthState.UNKNOWN);
                }
                pet.setHealthState(healthState);


        if (type.equals(DOG_TYPE)) {
            System.out.print("Size (XS / S / M / L / XL): ");
            Dog.Size size;
            String sizeInput = Main.SCANNER.nextLine();
            try {
                size = Dog.Size.valueOf(sizeInput);
            } catch (IllegalArgumentException e) {
                size = Dog.Size.UNKNOWN;
                System.out.println("Unable to parse value '" + sizeInput
                        + "'. Using default value: " + Dog.Size.UNKNOWN);
            }

            ((Dog) pet).setSize(size);
        }

        return pet;
    }

}