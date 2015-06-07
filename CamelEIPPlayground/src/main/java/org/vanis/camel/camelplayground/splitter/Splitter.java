package org.vanis.camel.camelplayground.splitter;

import org.apache.camel.Predicate;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class Splitter {

    private static class MyRouteBuilder extends RouteBuilder {

        public static final Processor FILENAME_PROCESSOR = exchange -> {
            String body = exchange.getIn().getBody(String.class);
            String id = body.split("\"")[1];
            exchange.getIn().setHeader("filename", id);
        };

        public static final Predicate EVEN_NUMBER_ACCEPTOR = exchange -> {
            int id = Integer.parseInt(exchange.getIn()
                    .getHeader("filename", String.class));
            return id % 2 == 0;
        };

        @Override
        public void configure() throws Exception {
            from("file://d:/tmp/CW/splitter/source/")
                    .split()
                    .tokenizeXML("item").process(FILENAME_PROCESSOR)
                    .to("log:MESSAGEPROCESSED?level=INFO")
//                    .filter(EVEN_NUMBER_ACCEPTOR)
                    .to("file://d:/tmp/CW/splitter/target?fileName=${header.filename}.xml");
        }
    }



























    private Main main;

    public static void main(String[] args) throws Exception {
        Splitter example = new Splitter();
        example.boot();
    }

    public void boot() throws Exception {
        main = new Main();
        main.enableHangupSupport();
        main.addRouteBuilder(new MyRouteBuilder());
        main.run();
    }

}
