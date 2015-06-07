package org.vanis.java.se.designpatterns.builder.hardtomakeburger;

public class Honza implements Developer{

    public Honza() {
    }

    public String haveLunch(Burger burger){
        // I am allergic lets check if it has tomatoes
        if(burger.hasTomatoes()){
            // It has tomatoes!!! I need to avoid this burger
            return "I can't eat this burger! It has tomatoes in it.";
        }else{
            // Cool I can eat this, but first check out this PIRANHA walking by.
            getDistractedByPiranhas();
            return eat(burger);
        }
    }

    private String eat(Burger burger){
        if(burger.hasTomatoes()){
            TomatoesMakeMeSick up = new TomatoesMakeMeSick("Call 911!!! I have eaten tomatoes!!! Someone help!!! !@#$%^&*()");
            throw up; // :-)
        }else{
            return "Yummy, yummy";
        }
    }


    private void getDistractedByPiranhas(){
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
        }
    }

    public static final class TomatoesMakeMeSick extends RuntimeException {
        public TomatoesMakeMeSick(String message) {
            super(message);
        }
    }
}
