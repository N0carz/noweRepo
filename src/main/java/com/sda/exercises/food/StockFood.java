package com.sda.exercises.food;

import com.sda.exercises.exceptions.NoFoodException;

public class StockFood {
    private Food food;
    private int amount;


    public StockFood(Food food) {
        this.food = food;
        amount = 0;
    }

    public void increaseFood(int buyAmount) {
        this.amount = this.amount + buyAmount;
    }

    public void decreaseFood() throws NoFoodException {
        if (amount > 0)
            amount -= 1;
        else
            throw new NoFoodException("Brak " + food.name());
    }




    public Food getFood() {
        return food;
    }
}
