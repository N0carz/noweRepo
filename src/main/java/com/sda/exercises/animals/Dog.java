package com.sda.exercises.animals;

import static com.sda.exercises.food.Food.BONES;
import static com.sda.exercises.food.Food.MEAT;

public class Dog extends Animal {

    public Dog() {
        super();
        favoriteFoods.add(BONES);
        favoriteFoods.add(MEAT);
    }
}
