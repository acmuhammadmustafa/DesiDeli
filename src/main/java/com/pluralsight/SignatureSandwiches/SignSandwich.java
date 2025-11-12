package com.pluralsight.SignatureSandwiches;

import com.pluralsight.Orders.Sandwich;

public abstract class SignSandwich extends Sandwich {

    public SignSandwich(String bread, int length, boolean toasted){
        super(bread,length,toasted);
        addSignToppings(); // This allows the signature toppings to automatically be added.
    }

    // These two methods allow for assigning own toppings.
    protected abstract void addSignToppings();

    public abstract String getSignName();
}
