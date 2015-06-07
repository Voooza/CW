package org.vanis.java.se.designpatterns.builder.hardtomakeburger;

public class SkillfullChef implements Chef {


    @Override
    public Burger prepareBurger() {
        HardToMakeBurger burger = new HardToMakeBurger("white", "beef");
        return burger;
    }
}
