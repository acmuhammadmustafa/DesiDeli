package com.pluralsight.SignatureSandwiches;

import com.pluralsight.ToppingsPackage.*;

public class ChickenWrap extends SignSandwich{
    public ChickenWrap(){
        super("wrap",8,true); // Following the format of the signSandwich (super(bread,length,toasted));
    }

    @Override
    protected void addSignToppings() {
        // Sets the permanent toppings for a BLT
        addTopping(new Meat("Chicken", false));
        addTopping(new Cheese("Cheddar",false));
        addTopping(new Toppings("Lettuce") {});
        addTopping(new Toppings("Tomatoes") {});
        addTopping(new Toppings("Peppers") {});
        addTopping(new Toppings("Onions") {});
        addTopping(new Sauce("Mayo"));
    }

    @Override
    public String getSignName() {
        return "Chicken Wrap";
    }

    @Override
    public String toString() {
        return getSignName() + " | " + super.toString();
    }

}
