package com.magicvet.comparator;

import com.magicvet.model.Pet;

import java.util.Comparator;

public class PetComparator implements Comparator<Pet> {

    @Override
    public int compare(Pet pet1, Pet pet2) {
        return pet1.getName().compareTo(pet2.getName());
    }
}
