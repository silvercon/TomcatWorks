package com.ex03;

import java.io.IOException;

import com.ex03.connector.http.HttpRequest;
import com.ex03.connector.http.HttpResponse;

public class StaticResourceProcessor {

    public void process(HttpRequest request, HttpResponse response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
