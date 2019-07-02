package com.sda.exercises;

import com.sda.exercises.animals.Dog;
import com.sda.exercises.person.Person;

public class Main {

    public static void main(String[] args) {

        Person person = new Person();
        person.buyAnimal(new Dog());

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            person.feedAnimals();
        }
    }
}
