package org.vanis.camel.camelplayground.dynamicbean;

import org.apache.camel.BeanInject;
import org.apache.camel.Exchange;
import org.apache.camel.Handler;

import javax.inject.Named;

@Named
public class Client {

    @BeanInject
    Invoker invoker;

    @Handler
    public void handle(Exchange exchange) throws Exception {
        Entity e = new Entity();
        invoker.set(e, "setStringToEntity", "sssssssss");

        System.out.println(invoker.get(e, "getStringFromEntity", String.class));
        invoker.set(e, "setLongToEntity", 555L);
        System.out.println(invoker.get(e, "getLongFromEntity", Long.class));
    }
}
