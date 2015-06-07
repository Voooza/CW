package org.vanis.java.se.designpatterns.builder.killerburger;

public class KillerBurger implements Burger{

    private String pastry;
    private String meat;
    private String cheese;
    private String peppers;
    private boolean tomatoes;
    private boolean bacon;
    private boolean letuce;
    private boolean catchup;
    private boolean tatarSauce;
    private boolean onion;

    public KillerBurger(String pastry, String meat) {
        this.pastry = pastry;
        this.meat = meat;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setPeppers(String peppers) {
        this.peppers = peppers;
    }

    public void setTomatoes(boolean tomatoes) {
        this.tomatoes = tomatoes;
    }

    public void setBacon(boolean bacon) {
        this.bacon = bacon;
    }

    public void setLetuce(boolean letuce) {
        this.letuce = letuce;
    }

    public void setCatchup(boolean catchup) {
        this.catchup = catchup;
    }

    public void setTatarSauce(boolean tatarSauce) {
        this.tatarSauce = tatarSauce;
    }

    public void setOnion(boolean onion) {
        this.onion = onion;
    }

    public String getPastry() {
        return pastry;
    }

    public String getMeat() {
        return meat;
    }

    public String getCheese() {
        return cheese;
    }

    public String getPeppers() {
        return peppers;
    }

    public boolean hasTomatoes() {
        return tomatoes;
    }

    public boolean hasBacon() {
        return bacon;
    }

    public boolean hasLetuce() {
        return letuce;
    }

    public boolean hasCatchup() {
        return catchup;
    }

    public boolean hasTatarSauce() {
        return tatarSauce;
    }

    public boolean hasOnion() {
        return onion;
    }

    @Override
    public String toString() {
        return "KillerBurger{" +
                "pastry='" + pastry + '\'' +
                ", meat='" + meat + '\'' +
                ", cheese='" + cheese + '\'' +
                ", peppers='" + peppers + '\'' +
                ", tomatoes=" + tomatoes +
                ", bacon=" + bacon +
                ", letuce=" + letuce +
                ", catchup=" + catchup +
                ", tatarSauce=" + tatarSauce +
                ", onion=" + onion +
                '}';
    }
}
