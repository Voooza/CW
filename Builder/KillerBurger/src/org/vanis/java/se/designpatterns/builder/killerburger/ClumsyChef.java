package org.vanis.java.se.designpatterns.builder.killerburger;

public class ClumsyChef implements Chef{

    @Override
    public Burger prepareBurger() {
        KillerBurger burger = new KillerBurger("light", "beef");
        burger.setBacon(true);
        burger.setTatarSauce(true);
        burger.setOnion(true);
        burger.setTomatoes(true);// Am I clumsy or what?
        return burger;
    }
}
