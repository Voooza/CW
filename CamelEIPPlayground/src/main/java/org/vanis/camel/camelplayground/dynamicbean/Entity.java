package org.vanis.camel.camelplayground.dynamicbean;

public class Entity {

    private String string = "simple string";
    private String anotherString = "another string";

    private Long number = 0L;
    private Long anotherNumber = 1L;

    public Entity() {
    }

    public Entity(String entityString, String entityAnotherString, Long entityLong, Long entityAnotherLong) {
        this.string = entityString;
        this.anotherString = entityAnotherString;
        this.number = entityLong;
        this.anotherNumber = entityAnotherLong;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getAnotherString() {
        return anotherString;
    }

    public void setAnotherString(String anotherString) {
        this.anotherString = anotherString;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getAnotherNumber() {
        return anotherNumber;
    }

    public void setAnotherNumber(Long anotherNumber) {
        this.anotherNumber = anotherNumber;
    }
}
