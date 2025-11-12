package com.pluralsight.SignatureSandwiches;

import com.pluralsight.ToppingsPackage.Cheese;
import com.pluralsight.ToppingsPackage.Meat;
import com.pluralsight.ToppingsPackage.Sauce;
import com.pluralsight.ToppingsPackage.Toppings;

public class RoastBeef extends SignSandwich{

    public RoastBeef(){
        super("wheat",8,true); // Following the format of the signSandwich (super(bread,length,toasted));
    }

    @Override
    protected void addSignToppings() {
        // Sets the permanent toppings for a Roast Beef
        addTopping(new Meat("Roast beef", false));
        addTopping(new Cheese("Provolone",false));
        addTopping(new Toppings("Lettuce") {});
        addTopping(new Toppings("Onions") {});
        addTopping(new Toppings("Tomatoes") {});
        addTopping(new Sauce("Mayo"));
    }

    @Override
    public String getSignName() {
        return "Roast Beef Sandwich";
    }

    @Override
    public String toString() {
        return getSignName() + " | " + super.toString();
    }

}
