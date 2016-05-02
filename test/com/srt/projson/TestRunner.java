package com.srt.projson;

import org.junit.Test;

import java.util.Date;

public class TestRunner {
    @Test
    public void testRunner() throws Exception {
        System.out.println(new JsonFormatter().prettify(ProJson.jsonify(new Demo())));
    }

    private class Demo{
        private int id = 10;
        private String name = "Prateek Srivastava";
        private Date date = new Date();
    }
}
