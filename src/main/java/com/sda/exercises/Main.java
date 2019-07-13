package com.sda.exercises;

import com.sda.exercises.animals.AnimalTimer;
import com.sda.exercises.person.Person;

public class Main {

    public static void main(String[] args) {

        Person person = new Person();
        AnimalTimer animalTimer = new AnimalTimer(person.getAnimals());

        Thread threadAnimal = new Thread(animalTimer);
        threadAnimal.start();

        Thread threadPerson = new Thread(person);
        threadPerson.start();
    }
}
