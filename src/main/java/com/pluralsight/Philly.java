package com.pluralsight;

public class Philly extends SignSandwich{

    public Philly(){
    super("white",8,true);
    }

    @Override
    protected void addSignToppings() {
        // Sets the permanent toppings for a BLT
        addTopping(new Meat("steak", false));
        addTopping(new Toppings("lettuce") {});
        addTopping(new Toppings("tomato") {});
        addTopping(new Sauce("mayo"));
    }

    @Override
    public String getSignName() {
        return "BLT";
    }

    @Override
    public String toString() {
        return getSignName() + " | " + super.toString();
    }

}
