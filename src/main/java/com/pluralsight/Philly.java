package com.pluralsight;

public class Philly extends SignSandwich{

    public Philly(){
    super("white",8,true);
    }

    @Override
    protected void addSignToppings() {
        // Sets the permanent toppings for a Philly
        addTopping(new Meat("steak", false));
        addTopping(new Cheese("american cheese",false));
        addTopping(new Toppings("peppers") {});
        addTopping(new Sauce("mayo"));
    }

    @Override
    public String getSignName() {
        return "Philly Cheese Steak";
    }

    @Override
    public String toString() {
        return getSignName() + " | " + super.toString();
    }

}
