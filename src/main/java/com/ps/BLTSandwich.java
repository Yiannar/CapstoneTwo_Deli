package com.ps;

public class BLTSandwich implements SignatureSandwich {
    @Override
    public String getSize() {
        return "8\"";
    }

    @Override
    public String[] getBread() {
        return new String[]{"White"};
    }

    @Override
    public String[] getMeat() {
        return new String[]{"Bacon"};
    }

    @Override
    public String[] getCheese() {
        return new String[]{"Cheddar"};
    }

    @Override
    public String[] getToppings() {
        return new String[]{"Lettuce", "Tomato"};
    }

    @Override
    public String[] getSauces() {
        return new String[]{"Ranch"};
    }

    @Override
    public boolean isToasted() {
        return true;
    }
}