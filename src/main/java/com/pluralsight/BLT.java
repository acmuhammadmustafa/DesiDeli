package com.pluralsight;

public class BLT extends SignSandwich{

    public BLT(){
        super("white",8,true); // Following the format of the signSandwich (super(bread,length,toasted));
    }

    @Override
    protected void addSignToppings() {
        // Sets the permanent toppings for a BLT
        addTopping(new Meat("Bacon", false));
        addTopping(new Cheese("Cheddar",false));
        addTopping(new Toppings("Lettuce") {});
        addTopping(new Toppings("Tomatoes") {});
        addTopping(new Sauce("Mayo"));
    }

    @Override
    public String getSignName() {
        return "BLT";
    }

    @Override
    public String toString() {
        return getSignName() + " | " + super.toString(); // super.toString = BLT | 8" | white bread | Toasted | Toppings: bacon, lettuce, tomato, mayo | $7.50" and super.getSignName = "BLT"
    }

}