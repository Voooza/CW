package org.vanis.java.se.designpatterns.builder.niceandsaveburger;

public class BastardChef implements Chef {
    @Override
    public Burger prepareBurger() {
        Burger burger = new NiceAndSafeBurger.Builder("WHITE", "BEEF")
                .bacon()
                .catchup()
                .cheese("CHEDAR")
                .peppers("HABANERRO")
                .makeBurger();
        poisonBurgerWithTomatoes((NiceAndSafeBurger) burger);
        return burger;
    }



    private void poisonBurgerWithTomatoes(final NiceAndSafeBurger burger){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);

                    // compile time error. Burger is immutable.
                    // Bastard cannot kill Honza
//                    burger.tomatoes();


                } catch (InterruptedException e) {
                }
            }
        });
        t.start();
    }
}
