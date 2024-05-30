package com.ps;

public interface SignatureSandwich {
    String getSize(); // Get the size of the signature sandwich
    String[] getBread(); // Get the type of bread used
    String[] getMeat(); // Get the type of meat used
    String[] getCheese(); // Get the type of cheese used
    String[] getToppings(); // Get the additional toppings used
    String[] getSauces(); // Get the sauces used
    boolean isToasted(); // Check if the sandwich is toasted
}

