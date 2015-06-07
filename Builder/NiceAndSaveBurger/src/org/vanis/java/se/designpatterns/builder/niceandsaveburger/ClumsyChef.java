package org.vanis.java.se.designpatterns.builder.niceandsaveburger;

public class ClumsyChef implements Chef{

    @Override
    public Burger prepareBurger() {
        Burger burger = new NiceAndSafeBurger.Builder("WHITE", "BEEF")
                .bacon()
                .catchup()
                .cheese("CHEDAR")
                .tomatoes()
                .peppers("HABANERRO")
                .makeBurger();
        return burger;
    }
}
