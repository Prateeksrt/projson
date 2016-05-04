package com.srt.projson;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class JsonToObjectTest {
    @Test
    public void shouldConvertJsonWithStringFieldToNotNullObject() throws Exception {
        ClassWithStringAttribute object = ProJson.objectify("{'value':'prateek'}",ClassWithStringAttribute.class);
        assertNotNull(object);
    }

    @Test
    public void shouldConvertJsonWithStringFieldToObject() throws Exception {
        ClassWithStringAttribute object = ProJson.objectify("{'value':'prateek'}",ClassWithStringAttribute.class);
        assertEquals("prateek",object.getValue());
    }

    @Test(expected = NoDefaultConstructorDefined.class)
    public void shouldNoDefaultConstructorDefinedExceptionIfTheClassDoesnotHaveOne() throws Exception {
         ProJson.objectify("{'value':5}",ClassWithWithoutDefaultConstructor.class);
    }

    @Test
    public void shouldConvertJsonWithINTFieldToObject() throws Exception {
        ClassWithINTAttribute object = ProJson.objectify("{'value':115}",ClassWithINTAttribute.class);
        assertEquals(115,object.getValue());
    }

    @Test
    public void shouldConvertJsonWithINTEGERFieldToObject() throws Exception {
        ClassWithINTEGERAttribute object = ProJson.objectify("{'value':115}",ClassWithINTEGERAttribute.class);
        assertEquals(new Integer(115),object.getValue());
    }

    @Test
    public void shouldConvertJsonWithIntAndStringFieldToObject() throws Exception {
        ClassWithIntegerAndStringAttribute object = ProJson.objectify("{'value':5,'value2':'prateek'}",ClassWithIntegerAndStringAttribute.class);
        assertEquals(new Integer(5),object.getValue());
        assertEquals("prateek",object.getValue2());
    }
}