package com.sda.exercises.animals;

import com.sda.exercises.exceptions.FullOfFoodException;
import com.sda.exercises.food.Food;

import java.util.HashSet;
import java.util.Set;

public abstract class Animal {

    Set<Food> favoriteFoods;
    private int hungry;

    Animal() {
        favoriteFoods = new HashSet<>();
        hungry = 3;
    }

    public Set<Food> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void eat(Food food) throws FullOfFoodException {
        decreaseHungry();
        System.out.println("mniam mniam:  " + food);

    }

    public void increaseHungry() {
        hungry++;
    }

    private void decreaseHungry() throws FullOfFoodException {
        if (hungry > 0)
            hungry--;
        else
            throw new FullOfFoodException();
    }
}
