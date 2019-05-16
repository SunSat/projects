package com.sunsat.sathish.j2ee.spboot.camelrouteing;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.file.FileComponent;
import org.springframework.stereotype.Component;

@Component
public class MyCustomRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:post").id("PostAPI").setHeader(Exchange.HTTP_METHOD,constant("GET")).
                to("https://jsonplaceholder.typicode.com/todos/1").log("${body}");

                /*pipeline("https://jsonplaceholder.typicode.com/todos/1",
                        "file://Users/sathishkumar_su/yapstone/temp/Sample1.txt?append=true");*/
                //to("https://jsonplaceholder.typicode.com/todos/1").
                //to("file://Users/sathishkumar_su/yapstone/temp/Sample.txt")

        from("direct:comments").id("CommentsAPI").setHeader(Exchange.HTTP_METHOD,constant("GET")).
                to("https://jsonplaceholder.typicode.com/comments/1").log("${body}");

    }

}