package com.magicvet;

import com.magicvet.comparator.DogSizeComparator;
import com.magicvet.model.Dog;

import java.util.Arrays;

public class Sandbox {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(),
                new Dog(Dog.M),
                new Dog(Dog.S),
                new Dog(Dog.XS),
                new Dog(Dog.XL)
        };

        Arrays.sort(dogs, new DogSizeComparator());

        for (Dog dog : dogs ) {
            System.out.println(dog.getSize());
        }
    }
}
