package com.sda.exercises.person;

import com.sda.exercises.animals.Animal;
import com.sda.exercises.exceptions.FullOfFoodException;
import com.sda.exercises.exceptions.NoFoodException;
import com.sda.exercises.food.Food;
import com.sda.exercises.food.StockFood;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Person {
    private List<Animal> animals = new ArrayList<>();
    private List<StockFood> stockFoods = new ArrayList<>();

    public Person() {

        Food[] values = Food.values();
        for (Food food : values) {
            stockFoods.add(new StockFood(food));
        }
    }

    private void buyFood(Food food) {
        System.out.println("Kupuje " + food.name());
        Optional<StockFood> stockFoodOptional =
                stockFoods.stream().filter(s -> s.getFood() == food).findFirst();
        stockFoodOptional.
                ifPresent(stockFood -> stockFood.increaseFood(5));
    }


    public void buyAnimal(Animal animal) {
        animals.add(animal);
    }

    public void feedAnimals() {
        for (Animal animal : animals) {
            Set<Food> favoriteFoods = animal.getFavoriteFoods();
            for (final Food food : favoriteFoods) {

                Optional<StockFood> stockFoodOptional =
                        stockFoods.stream().filter(f -> f.getFood() == food).findFirst();
                if (stockFoodOptional.isPresent()) {
                    boolean isAte = false;
                    while (!isAte)
                        try {
                            eatAnimal(animal, food, stockFoodOptional.get());
                            isAte = true;
                        } catch (NoFoodException e) {
                            buyFood(food);
                        } catch (FullOfFoodException e) {
                            System.out.println("Animal is full.");
                            isAte = true;
                        }
                }
            }
        }

    }

    private void eatAnimal(Animal animal, Food food, StockFood stockFoodOptional) throws NoFoodException, FullOfFoodException {
        stockFoodOptional.decreaseFood();
        animal.eat(food);
    }
}
