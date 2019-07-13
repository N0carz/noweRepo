package com.sda.exercises.person;

import com.sda.exercises.animals.Animal;
import com.sda.exercises.animals.Dog;
import com.sda.exercises.exceptions.FullOfFoodException;
import com.sda.exercises.exceptions.NoFoodException;
import com.sda.exercises.food.Food;
import com.sda.exercises.food.StockFood;

import java.util.*;

public class Person implements Runnable{

    private Random random = new Random();

    public List<Animal> getAnimals() {
        return animals;
    }

    private List<Animal> animals = new ArrayList<>();
    private List<StockFood> stockFoods = new ArrayList<>();

    public Person() {

        Food[] values = Food.values();
        for (Food food : values) {
            stockFoods.add(new StockFood(food));
        }
    }

    @Override
    public void run() {
        this.buyAnimal(new Dog());

        int ms = random.nextInt(3000);

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            this.feedAnimals();
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
