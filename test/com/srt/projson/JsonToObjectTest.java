package com.srt.projson;

import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class JsonToObjectTest {
    @Test
    @Ignore
    public void shouldConvertJsonWithStringFieldToObject() throws Exception {
        ClassWithStringAttribute object = ProJson.objectify("{'value':'prateek'}",ClassWithStringAttribute.class);
        assertNotNull(object);

    }
}
