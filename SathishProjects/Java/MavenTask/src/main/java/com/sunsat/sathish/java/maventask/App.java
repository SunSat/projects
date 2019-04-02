package com.sunsat.sathish.java.maventask;
import java.io.File;
import java.util.Collections;
import java.util.Properties;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;

/*
import org.apache.maven.cli.MavenCli;
import org.apache.maven.cli.*;
*/
/**
 * Hello world!
 *
 */

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! I am Sathish How Are you." );

        System.out.println("The CMD Is : " + args[0]);

        String[][] paths = {{"payment/payment.yaml","payment"},{"refund/refund.yaml","refund"}};

        for(int i=0;i<2;i++) {
            InvocationRequest request = new DefaultInvocationRequest();
            request.setPomFile(new File(args[0]+"/pom_generate.xml"));
            request.setGoals(Collections.singletonList("generate-sources"));
            Properties prop = new Properties();
            prop.setProperty("swagger.codegen.inputSpec",args[0] + "/src/main/resource/" + paths[i][0]);
            prop.setProperty("swagger.codegen.outputDir",args[1] + "/generated-sources/" + paths[i][1]);
            request.setProperties(prop);
            Invoker invoker = new DefaultInvoker();
            try {
                invoker.execute(request);
            } catch (MavenInvocationException e) {
                e.printStackTrace();
            }
        }
    }
}
