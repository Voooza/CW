package org.vanis.camel.camelplayground.dynamicbean;

import org.apache.camel.main.Main;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
public class Invoker {

    Main m;

    public Invoker(Main m) {
        this.m = m;
    }

    public <T> T get(Object o, String method, Class<T> clazz) throws Exception {
        Object body = o;
        Map<String, Object> headers = new HashMap<>();
        headers.put("RL", String.format("bean:dynamic?method=%s",method));
        return m.getCamelTemplate().requestBodyAndHeaders("direct:executor", body, headers, clazz);
    }

    public void set(Object o, String method, Object param) throws Exception {
        Object[] body = {o, param};
        Map<String, Object> headers = new HashMap<>();
        headers.put("RL", String.format("bean:dynamic?method=%s&multiParameterArray=true",method));
        m.getCamelTemplate().requestBodyAndHeaders("direct:executor", body, headers);
    }
}
