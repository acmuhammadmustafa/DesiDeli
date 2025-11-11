package com.pluralsight;

public class BLT extends SignSandwich{

    public BLT(){
        super("white",8,true); // Following the format of the signSandwich (super(bread,length,toasted));
    }

    @Override
    protected void addSignToppings() {
        // Sets the permanent toppings for a BLT
        addTopping(new Meat("bacon", false));
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
