package org.vanis.java.se.designpatterns.builder.niceandsaveburger;

public class NiceAndSafeBurger implements Burger{

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


    private NiceAndSafeBurger(Builder builder) {
        this.pastry = builder.pastry;
        this.meat = builder.meat;
        this.cheese = builder.cheese;
        this.peppers = builder.peppers;
        this.tomatoes = builder.tomatoes;
        this.bacon = builder.bacon;
        this.letuce = builder.letuce;
        this.catchup = builder.catchup;
        this.tatarSauce = builder.tatarSauce;
        this.onion = builder.onion;
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
        return "NiceAndSafeBurger{" +
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


    public static final class Builder {
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

        public Builder(String pastry, String meat) {
            this.pastry = pastry;
            this.meat = meat;
        }

        public Builder cheese(String cheese){
            this.cheese = cheese;
            return this;
        }

        public Builder peppers(String peppers){
            this.peppers = peppers;
            return this;
        }

        public Builder tomatoes(){
            this.tomatoes = true;
            return this;
        }

        public Builder bacon(){
            this.bacon = true;
            return this;
        }

        public Builder letuce(){
            this.letuce = true;
            return this;
        }

        public Builder catchup(){
            this.catchup = true;
            return this;
        }

        public Builder tatarSauce(){
            this.tatarSauce = true;
            return this;
        }

        public Builder onion(){
            this.onion = true;
            return this;
        }

        public Burger makeBurger(){
            return new NiceAndSafeBurger(this);
        }

    }
}
