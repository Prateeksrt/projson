package com.srt.projson;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class JsonPrettifyTest {

    @Test
    public void prettifyJsonStringWithStringValue() throws Exception {
        String result  = new JsonFormatter().prettify("{'value':'prateek'}");
        assertEquals("{\n\t'value':'prateek'\n}", result);
    }

    @Test
    public void prettifyJsonStringWithIntValue() throws Exception {
        String result  = new JsonFormatter().prettify("{'value':5}");
        assertEquals("{\n\t'value':5\n}", result);
    }

    @Test
    public void prettifyJsonStringWithIntAndStringValues() throws Exception {
        String result  = new JsonFormatter().prettify("{'value':5,'value2':'prateek'}");
        assertEquals("{\n\t'value':5,\n\t'value2':'prateek'\n}", result);
    }

    @Test
    public void prettifyJsonStringWithIntArray() throws Exception {
        String result  = new JsonFormatter().prettify("{'value':[1,2,3,4,5]}");
        assertEquals("{\n\t'value':[\n\t\t1,\n\t\t2,\n\t\t3,\n\t\t4,\n\t\t5\n\t]\n}", result);
    }

    @Test
    public void prettifyJsonStringWithStringArray() throws Exception {
        String result  = new JsonFormatter().prettify("{'value':['prateek','richi','pooja','iti','mummy']}");
        assertEquals("{\n\t'value':[\n\t\t'prateek',\n\t\t'richi',\n\t\t'pooja',\n\t\t'iti',\n\t\t'mummy'\n\t]\n}", result);
    }

    @Test
    public void prettifyJsonStringWithObjectArray() throws Exception {
        String result  = new JsonFormatter().prettify("{'values':[{'value':'prateek'},{'value':'prateek'}]}");
        assertEquals("{\n\t'values':[\n\t\t{\n\t\t\t'value':'prateek'\n\t\t},\n\t\t{\n\t\t\t'value':'prateek'\n\t\t}\n\t]\n}", result);
    }
}