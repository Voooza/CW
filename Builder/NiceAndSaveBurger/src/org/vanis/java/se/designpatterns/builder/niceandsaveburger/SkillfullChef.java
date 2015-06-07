package org.vanis.java.se.designpatterns.builder.niceandsaveburger;

public class SkillfullChef implements Chef {


    @Override
    public Burger prepareBurger() {
        Burger burger = new NiceAndSafeBurger.Builder("WHITE", "BEEF")
                .bacon()
                .catchup()
                .cheese("CHEDAR")
                //.tomatoes() // I am skillful. I am aware that Jan hates tomatoes
                .peppers("HABANERRO")
                .makeBurger();
        return burger;
    }
}
