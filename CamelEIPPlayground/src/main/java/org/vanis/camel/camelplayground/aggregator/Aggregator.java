package org.vanis.camel.camelplayground.aggregator;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import java.io.File;
import java.nio.file.Files;

public class Aggregator {

    private static class MyRouteBuilder extends RouteBuilder {


        @Override
        public void configure() throws Exception {
            from("file://d:/tmp/CW/aggregator/source/")
                    .process(FILE2CONTENT_PROCESSOR)
                    .log(LoggingLevel.INFO, "AGGREGATOR", "processing body: ${body}")
                    .process(CORRELATION_PROCESSOR)
                    .aggregate(header(CORREL_PARAM), AGGREGATION_STRATEGY)
                    .completionTimeout(2000L)
                    .process(WRAPPING_PROCESSOR)
                    .to("file://d:/tmp/CW/aggregator/target?fileName=output_${header."+ CORREL_PARAM + "}.xml");
        }























        // ----------------------------------------------------------------------------------------------------
        // Simple constants
        // ----------------------------------------------------------------------------------------------------
        private static final String HEADER_PARAM = "hp";
        private static final String CORREL_PARAM = "correlate";


        // ----------------------------------------------------------------------------------------------------
        // Lambda constants
        // ----------------------------------------------------------------------------------------------------
        /**
         * Sets header params to either EVEN or ODD so that we can use this
         * in aggregation
         */
        public static final Processor CORRELATION_PROCESSOR = exchange -> {

            String body = exchange.getIn().getBody(String.class);
            String idString = body.split("\"")[1];
            int id = Integer.parseInt(idString);
            if (id % 2 == 0) {
                exchange.getIn()
                        .setHeader(CORREL_PARAM, "EVEN");
            } else {
                exchange.getIn()
                        .setHeader(CORREL_PARAM, "ODD");
            }
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
         * Takes file contents and puts it into body instead of
         * {@link File} that camel puts there by default
         */
        public static final Processor FILE2CONTENT_PROCESSOR = new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                File f = exchange.getIn().getBody(File.class);
                String content = new String(Files.readAllBytes(f.toPath()));
                exchange.getIn().setBody(content);
            }
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
        Aggregator example = new Aggregator();
        example.boot();
    }

    public void boot() throws Exception {
        main = new Main();
        main.enableHangupSupport();
        main.addRouteBuilder(new MyRouteBuilder());
        main.run();
    }
}
