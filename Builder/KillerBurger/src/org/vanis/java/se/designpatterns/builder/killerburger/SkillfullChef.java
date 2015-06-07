package org.vanis.java.se.designpatterns.builder.killerburger;

public class SkillfullChef implements Chef {


    @Override
    public Burger prepareBurger() {
        KillerBurger burger = new KillerBurger("light", "beef");
        burger.setBacon(true);
        burger.setTatarSauce(true);
        burger.setOnion(true);
        return burger;
    }
}
