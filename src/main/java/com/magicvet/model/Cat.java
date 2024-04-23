package com.magicvet.model;

public class Cat extends Pet {

    @Override
    public String toString() {
        return "Pet {"
                + "\ttype = " + getType()
                + ", sex = " + getSex()
                + ", age = " + getAge()
                + ", name = " + getName()
                + ", ownerName = " + getOwnerName()
                + "\t}";
    }
}