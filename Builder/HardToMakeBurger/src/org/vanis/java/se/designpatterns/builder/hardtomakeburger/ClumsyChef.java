package org.vanis.java.se.designpatterns.builder.hardtomakeburger;

public class ClumsyChef implements Chef{

    @Override
    public Burger prepareBurger() {

        // Poor chef cannot know what to put in burger
        return new HardToMakeBurger("YES", "NO", "YES", 7, "YES", "YES", "NO", "YES", "YES", "NO");

    }
}
