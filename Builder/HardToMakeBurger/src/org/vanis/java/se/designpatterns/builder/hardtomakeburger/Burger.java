package org.vanis.java.se.designpatterns.builder.hardtomakeburger;

public interface Burger {
   String getPastry();

   String getMeat();

   String getCheese();

   int getPeppers();

   boolean hasTomatoes();

   boolean hasBacon();

   boolean hasLettuce();

   boolean hasCatchup();

   boolean hasTatarSauce();

   boolean hasOnion();
}
