package org.vanis.camel.camelplayground.json;

import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.main.Main;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Json {

    private static class MyRouteBuilder extends RouteBuilder {

        private static final Processor STORE_JSON_IN_BODY = exchange -> {
            File f = exchange.getIn().getBody(File.class);
            exchange.getProperties().put("TASKID", f.getName().split("\\.")[0]);
            exchange.getIn().setBody(new String(Files.readAllBytes(f.toPath())));
        };

        private static final Processor STORE_JSON_IN_PROPERTIES = exchange -> {
            Map params = exchange.getIn().getBody(Map.class);
            exchange.getIn().setBody(exchange.getProperties().get("TASKID"));
            exchange.getProperties().put("PARAMS", params);
        };

        @Override
        public void configure() throws Exception {
            from("file://d:/tmp/CW/json/source/")
                    .process(STORE_JSON_IN_BODY)
                    .log(LoggingLevel.INFO, "before: ${body}")
                    .unmarshal(new JacksonDataFormat())
                    .log(LoggingLevel.INFO, "after: ${body}")
                    .process(STORE_JSON_IN_PROPERTIES)
                    .log(LoggingLevel.INFO, "before end: ${body}")
                    .end();
        }

    }

    private static Map<String, List<String>> getMap() {
        Map<String, List<String>> ret = new HashMap<>();
        ret.computeIfAbsent("myKey_01", s -> new ArrayList<>())
                .add("myValue_001");
        ret.computeIfAbsent("myKey_01", s -> new ArrayList<>())
                .add("myValue_002");
        ret.computeIfAbsent("myKey_02", s -> new ArrayList<>())
                .add("myValue_003");
        ret.computeIfAbsent("myKey_02", s -> new ArrayList<>())
                .add("myValue_011");
        ret.computeIfAbsent("myKey_02", s -> new ArrayList<>())
                .add("myValue_012");
        ret.computeIfAbsent("myKey_03", s -> new ArrayList<>())
                .add("myValue_013");
        ret.computeIfAbsent("myKey_03", s -> new ArrayList<>())
                .add("myValue_024");
        ret.computeIfAbsent("myKey_03", s -> new ArrayList<>())
                .add("myValue_025");
        ret.computeIfAbsent("myKey_03", s -> new ArrayList<>())
                .add("myValue_026");
        return ret;
    }

    // ----------------------------------------------------------------------------------------------------
    // Boilerplate coded to make camel run as executable standalone app
    // ----------------------------------------------------------------------------------------------------
    private Main main;

    public static void main(String[] args) throws Exception {
        Json example = new Json();
        example.boot();
    }

    public void boot() throws Exception {
        main = new Main();
        main.enableHangupSupport();
        main.addRouteBuilder(new MyRouteBuilder());
        main.run();
    }
}
