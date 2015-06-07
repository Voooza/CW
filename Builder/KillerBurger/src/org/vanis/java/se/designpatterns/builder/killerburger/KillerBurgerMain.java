package org.vanis.java.se.designpatterns.builder.killerburger;

public class KillerBurgerMain {

    public static void main(String args[]) throws InterruptedException {

        test(new Honza(), new ClumsyChef());
        test(new Honza(), new SkillfullChef());
        test(new Honza(), new BastardChef());

    }

    static void test(Developer developer, Chef chef){
        System.out.println("\n***********************************************************************************\n");
        try{
            System.out.println("Testing burger from: " + chef.getClass().getSimpleName());
            Burger burger = chef.prepareBurger();
            System.out.println(burger.toString());
            System.out.println("Honza says: " + developer.haveLunch(burger));
        } catch (Exception e){
            handleException(e);
        }
        System.out.println("\n***********************************************************************************\n");
    }


    static void handleException(Exception e){
        if(e instanceof Honza.TomatoesMakeMeSick){
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Your developer died because he was fed tomatoes unexpectedly!");
        }
    }
}
