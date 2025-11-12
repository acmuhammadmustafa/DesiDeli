package com.pluralsight.SignatureSandwiches;

import com.pluralsight.ToppingsPackage.Cheese;
import com.pluralsight.ToppingsPackage.Meat;
import com.pluralsight.ToppingsPackage.Sauce;
import com.pluralsight.ToppingsPackage.Toppings;

public class Philly extends SignSandwich{

    public Philly(){
    super("white",8,true);
    }

    @Override
    protected void addSignToppings() {
        // Sets the permanent toppings for a Philly
        addTopping(new Meat("Steak", false));
        addTopping(new Cheese("American cheese",false));
        addTopping(new Toppings("Peppers") {});
        addTopping(new Sauce("Mayo"));
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
