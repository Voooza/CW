package org.vanis.camel.camelplayground.dynamicbean;

import javax.inject.Named;

@Named
public class DynamicalyInvocable {

    public String getStringFromEntity(Entity e){
        return e.getString();
    }
    public void setStringToEntity(Entity e, String s){
        e.setString(s);
    }


    public String getAnotherStringFromEntity(Entity e){
        return e.getAnotherString();
    }

    public void setLongToEntity(Entity e, Long l){
        e.setNumber(l);
    }

    public Long getLongFromEntity(Entity e){
        return e.getNumber();
    }

    public Long getAnotherLongFromEntity(Entity e){
        return e.getAnotherNumber();
    }
}
