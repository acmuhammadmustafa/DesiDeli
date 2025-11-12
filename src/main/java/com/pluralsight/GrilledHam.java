package com.pluralsight;

public class GrilledHam extends SignSandwich{
    public GrilledHam(){
        super("rye",8,true); // Following the format of the signSandwich (super(bread,length,toasted));
    }

    @Override
    protected void addSignToppings() {
        // Sets the permanent toppings for a BLT
        addTopping(new Meat("Ham", false));
        addTopping(new Cheese("Swiss",false));
        addTopping(new Toppings("Pickles") {});
        addTopping(new Toppings("Tomatoes") {});
        addTopping(new Sauce("Mayo"));
        addTopping(new Sauce("Mustard"));
    }

    @Override
    public String getSignName() {
        return "Grilled Ham";
    }

    @Override
    public String toString() {
        return getSignName() + " | " + super.toString();
    }

}
