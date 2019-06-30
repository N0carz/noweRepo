package com.sda.exercises.animals;

import com.sda.exercises.food.Foods;

import java.util.HashSet;
import java.util.Set;

public abstract class Animal {

    Set<Foods> favoriteFoods;

    Animal() {
        favoriteFoods = new HashSet<>();
    }

    public Set<Foods> getFavoriteFoods() {
        return favoriteFoods;
    }
}
