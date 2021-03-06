package com.ex05.startup;

import java.sql.Wrapper;

import org.apache.catalina.Loader;
import org.apache.catalina.Pipeline;
import org.apache.catalina.Valve;

import com.ex03.connector.http.HttpConnector;
import com.ex05.core.SimpleLoader;
import com.ex05.core.SimpleWrapper;
import com.ex05.valves.ClientIPLoggerValve;
import com.ex05.valves.HeaderLoggerValve;

public final class Bootstrap1 {
    public static void main(String[] args) {

        /*
         * call by using http://localhost:8080/ModernServlet, but could be
         * invoked by any name
         */

        HttpConnector connector = new HttpConnector();
        Wrapper wrapper = new SimpleWrapper();
        wrapper.setServletClass("ModernServlet");
        Loader loader = new SimpleLoader();
        Valve valve1 = new HeaderLoggerValve();
        Valve valve2 = new ClientIPLoggerValve();

        wrapper.setLoader(loader);
        ((Pipeline) wrapper).addValve(valve1);
        ((Pipeline) wrapper).addValve(valve2);

        connector.setContainer(wrapper);

        try {
            connector.initialize();
            connector.start();

            // make the application wait until we press a key.
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
