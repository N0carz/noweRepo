package com.sda.exercises.animals;

import static com.sda.exercises.food.Foods.BONES;
import static com.sda.exercises.food.Foods.MEAT;

public class Dog extends Animal {

    public Dog() {
        super();
        favoriteFoods.add(BONES);
        favoriteFoods.add(MEAT);
    }
}
