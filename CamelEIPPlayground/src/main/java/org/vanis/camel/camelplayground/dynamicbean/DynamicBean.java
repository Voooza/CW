package org.vanis.camel.camelplayground.dynamicbean;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class DynamicBean {

    private static class MyRouteBuilder extends RouteBuilder {

        public static final Processor PRINT_BODY = exchange -> {
            System.out.println(exchange.getIn().getBody(String.class));
        };

        @Override
        public void configure() throws Exception {
            from("timer://foo?fixedRate=true&period=5000").log(LoggingLevel.INFO, "ticked")
                    .bean(Client.class);

            from("direct:executor").recipientList(simple("${header.RL}"));
        }


    }

    // ----------------------------------------------------------------------------------------------------
    // Boilerplate coded to make camel run as executable standalone app
    // ----------------------------------------------------------------------------------------------------
    private Main main;

    public static void main(String[] args) throws Exception {
        DynamicBean example = new DynamicBean();
        example.boot();
    }

    public void boot() throws Exception {
        main = new Main();
        main.enableHangupSupport();
        main.addRouteBuilder(new MyRouteBuilder());
        main.bind("dynamic", new DynamicalyInvocable());
        Invoker i = new Invoker(main);
        main.bind("invoker", i);
        main.bind("client", new Client());
        main.run();
    }
}
