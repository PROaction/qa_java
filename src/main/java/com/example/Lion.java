package com.example;

import java.util.List;

import static com.example.Constants.FAMALE;
import static com.example.Constants.MALE;

public class Lion {

    boolean hasMane;
    Feline feline;

    public Lion(Feline feline, String sex) throws Exception {
        this.feline = feline;

        if (MALE.equals(sex)) {
            hasMane = true;
        } else if (FAMALE.equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
