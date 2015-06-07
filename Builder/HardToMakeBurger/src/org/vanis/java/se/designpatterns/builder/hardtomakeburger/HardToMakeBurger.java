package org.vanis.java.se.designpatterns.builder.hardtomakeburger;

public class HardToMakeBurger implements Burger{

    private String pastry;
    private String meat;
    private String cheese;
    private int peppers;
    private String tomatoes;
    private String bacon;
    private String lettuce;
    private String catchup;
    private String tatarSauce;
    private String onion;

    public HardToMakeBurger(String pastry, String meat, String cheese, int peppers, String tomatoes, String bacon, String lettuce, String catchup, String tatarSauce, String onion) {
        this.pastry = pastry;
        this.meat = meat;
        this.cheese = cheese;
        this.peppers = peppers;
        this.tomatoes = tomatoes;
        this.bacon = bacon;
        this.lettuce = lettuce;
        this.catchup = catchup;
        this.tatarSauce = tatarSauce;
        this.onion = onion;
    }

    @Override
    public String getPastry() {
        return pastry;
    }

    @Override
    public String getMeat() {
        return meat;
    }

    @Override
    public String getCheese() {
        return cheese;
    }

    @Override
    public int getPeppers() {
        return peppers;
    }

    public boolean hasTomatoes() {
        return tomatoes.equals("YES");
    }

    public boolean hasBacon() {
        return bacon.equals("YES");
    }

    public boolean hasLettuce() {
        return lettuce.equals("YES");
    }

    public boolean hasCatchup() {
        return catchup.equals("YES");
    }

    public boolean hasTatarSauce() {
        return tatarSauce.equals("YES");
    }

    public boolean hasOnion() {
        return onion.equals("YES");
    }


    public HardToMakeBurger(String pastry, String meat, String cheese, int peppers, String tomatoes, String bacon, String lettuce, String catchup, String tatarSauce) {
        this(pastry, meat, cheese, peppers, tomatoes, bacon, lettuce, catchup, tatarSauce, "NO");
    }

    public HardToMakeBurger(String pastry, String meat, String cheese, int peppers, String tomatoes, String bacon, String lettuce, String catchup) {
        this(pastry, meat, cheese, peppers, tomatoes, bacon, lettuce, catchup, "NO");
    }

    public HardToMakeBurger(String pastry, String meat, String cheese, int peppers, String tomatoes, String bacon, String lettuce) {
        this(pastry, meat, cheese, peppers, tomatoes, bacon, lettuce, "NO");
    }

    public HardToMakeBurger(String pastry, String meat, String cheese, int peppers, String tomatoes, String bacon) {
        this(pastry, meat, cheese, peppers, tomatoes, bacon, "NO");
    }

    public HardToMakeBurger(String pastry, String meat, String cheese, int peppers, String tomatoes) {
        this(pastry, meat, cheese, peppers, tomatoes, "NO");
    }

    public HardToMakeBurger(String pastry, String meat, String cheese, int peppers) {
        this(pastry, meat, cheese, peppers, "NO");
    }

    public HardToMakeBurger(String pastry, String meat, String cheese) {
        this(pastry, meat, cheese, 0);
    }

    public HardToMakeBurger(String pastry, String meat) {
        this(pastry, meat, "NO");
    }

    @Override
    public String toString() {
        return "HardToMakeBurger{" +
                "pastry='" + pastry + '\'' +
                ", meat='" + meat + '\'' +
                ", cheese='" + cheese + '\'' +
                ", peppers='" + peppers + '\'' +
                ", tomatoes='" + tomatoes + '\'' +
                ", bacon='" + bacon + '\'' +
                ", lettuce='" + lettuce + '\'' +
                ", catchup='" + catchup + '\'' +
                ", tatarSauce='" + tatarSauce + '\'' +
                ", onion='" + onion + '\'' +
                '}';
    }
}
