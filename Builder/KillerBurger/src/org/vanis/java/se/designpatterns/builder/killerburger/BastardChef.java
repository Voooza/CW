package org.vanis.java.se.designpatterns.builder.killerburger;

public class BastardChef implements Chef {
    @Override
    public Burger prepareBurger() {
        KillerBurger burger = new KillerBurger("dark", "pork");
        burger.setBacon(true);
        burger.setTatarSauce(true);
        burger.setOnion(true);
        poisonBurgerWithTomatoes(burger);
        return burger;
    }





































    private void poisonBurgerWithTomatoes(final KillerBurger burger){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                    burger.setTomatoes(true);
                } catch (InterruptedException e) {
                }
            }
        });
        t.start();
    }
}
