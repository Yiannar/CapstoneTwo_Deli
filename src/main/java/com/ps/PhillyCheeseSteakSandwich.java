package com.ps;

public class PhillyCheeseSteakSandwich implements SignatureSandwich {
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
        return new String[]{"Steak"};
    }

    @Override
    public String[] getCheese() {
        return new String[]{"American Cheese"};
    }

    @Override
    public String[] getToppings() {
        return new String[]{"Peppers"};
    }

    @Override
    public String[] getSauces() {
        return new String[]{"Mayo"};
    }

    @Override
    public boolean isToasted() {
        return true;
    }
}
