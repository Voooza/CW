package org.vanis.camel.camelplayground.resequencer;

import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class Resequencer {

    private static class MyRouteBuilder extends RouteBuilder {
        // ----------------------------------------------------------------------------------------------------
        // Simple constants
        // ----------------------------------------------------------------------------------------------------
        private static final String HEADER_PARAM = "hp";
        private static final String CORREL_PARAM = "correlate";

        @Override
        public void configure() throws Exception {
            from("file://d:/tmp/CW/resequencer/source/")

                    .split()
                    .tokenizeXML("item")
                    .process(ID2HEADER_PROCESSOR)
                    .log(LoggingLevel.INFO, "Resequencer", "processing body: ${body}")
                    .resequence(header(HEADER_PARAM))
                    .log(LoggingLevel.INFO, "Resequencer", "processing body: ${body}")
                    .aggregate(header(CORREL_PARAM), AGGREGATION_STRATEGY)
                    .completionTimeout(2000L)

                    .process(WRAPPING_PROCESSOR)
                    .to("file://d:/tmp/CW/resequencer/target?fileName=output.xml");
        }


        /**
         * sets item id to exchange header param
         * and additionaly sets CORREL_PARAM same for all
         */
        public static final Processor ID2HEADER_PROCESSOR = exchange -> {
            String idString = exchange.getIn()
                    .getBody(String.class)
                    .split("\"")[1];
            int id = Integer.parseInt(idString);
            exchange.getIn()
                    .setHeader(HEADER_PARAM, id);
            exchange.getIn()
                    .setHeader(CORREL_PARAM, CORREL_PARAM);
        };

        /**
         * Adds additional &lt;request&gt;&lt;/request&gt; wrapping tags
         */
        public static final Processor WRAPPING_PROCESSOR = exchange -> {
            String oldBody = exchange.getIn()
                    .getBody(String.class);
            String newBody = "<request>\n\t" + oldBody + "\n</request>";
            exchange.getIn().setBody(newBody);
        };


        /**
         * Basically just a string concat of old and new body
         */
        public static final AggregationStrategy AGGREGATION_STRATEGY = (oldExchange, newExchange) -> {
            if (oldExchange == null) {
                return newExchange;
            }
            String oldBody = oldExchange.getIn().getBody(String.class);
            String newBody = newExchange.getIn().getBody(String.class);
            oldExchange.getIn().setBody(oldBody + "\n\t" + newBody);
            return oldExchange;
        };
    }





















    // ----------------------------------------------------------------------------------------------------
    // Boilerplate coded to make camel run as executable standalone app
    // ----------------------------------------------------------------------------------------------------
    private Main main;

    public static void main(String[] args) throws Exception {
        Resequencer example = new Resequencer();
        example.boot();
    }

    public void boot() throws Exception {
        main = new Main();
        main.enableHangupSupport();
        main.addRouteBuilder(new MyRouteBuilder());
        main.run();
    }
}
