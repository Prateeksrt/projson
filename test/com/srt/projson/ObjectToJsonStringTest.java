package com.srt.projson;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ObjectToJsonStringTest {

    @Test
    public void shouldConvertObjectWithStringFieldToJson() throws Exception {
        ClassWithStringAttribute objectWithStringField = new ClassWithStringAttribute("prateek");
        String result = ProJson.jsonify(objectWithStringField);
        assertEquals("{'value':'prateek'}", result);
    }

    @Test
    public void shouldConvertObjectWithINTFieldToJson() throws Exception {
        ClassWithINTAttribute objectWithINTField = new ClassWithINTAttribute(5);
        String result = ProJson.jsonify(objectWithINTField);
        assertEquals("{'value':5}", result);
    }

    @Test
    public void shouldConvertObjectWithINTEGERFieldToJson() throws Exception {
        ClassWithINTEGERAttribute objectWithIntegerField = new ClassWithINTEGERAttribute(new Integer(500));
        String result = ProJson.jsonify(objectWithIntegerField);
        assertEquals("{'value':500}", result);
    }

    @Test
    public void shouldConvertObjectWithIntegerAndStringFieldToJson() throws Exception {
        ClassWithIntegerAndStringAttribute objectWithIntAndStringField = new ClassWithIntegerAndStringAttribute("prateek", 5);
        String result = ProJson.jsonify(objectWithIntAndStringField);
        assertEquals("{'value':5,'value2':'prateek'}", result);
    }

    @Test
    public void shouldConvertObjectWithIntegerArrayFieldToJson() throws Exception {
        ClassWithIntegerArrayAttribute objectIntegerArrayField = new ClassWithIntegerArrayAttribute(new Integer[]{1, 2, 3, 4, 5});
        String result = ProJson.jsonify(objectIntegerArrayField);
        assertEquals("{'value':[1,2,3,4,5]}", result);
    }

    @Test
    public void shouldConvertObjectWithStringArrayFieldToJson() throws Exception {
        ClassWithStringArrayAttribute objectWithStringArrayField = new ClassWithStringArrayAttribute(new String[]{"prateek", "richi", "pooja", "iti", "mummy"});
        String result = ProJson.jsonify(objectWithStringArrayField);
        assertEquals("{'value':['prateek','richi','pooja','iti','mummy']}", result);
    }

    @Test
    public void shouldConvertObjectWithStringListFieldToJson() throws Exception {
        ClassWithStringListAttribute objectStringListField = new ClassWithStringListAttribute(new
                ArrayList<>(Arrays.asList(new String[]{"prateek", "richi", "pooja", "iti", "mummy"})));
        String result = ProJson.jsonify(objectStringListField);
        assertEquals("{'value':['prateek','richi','pooja','iti','mummy']}", result);
    }

    @Test
    public void shouldConvertObjectWithStringSetFieldToJson() throws Exception {
        ClassWithStringSetAttribute objectWithStringSetField = new ClassWithStringSetAttribute(new
                HashSet<>(Arrays.asList(new String[]{"prateek", "richi", "pooja", "iti", "mummy"})));
        String result = ProJson.jsonify(objectWithStringSetField);
        assertTrue(result.contains("'prateek'"));
        assertTrue(result.contains("'richi'"));
        assertTrue(result.contains("'pooja'"));
        assertTrue(result.contains("'iti'"));
        assertTrue(result.contains("'mummy'"));
        assertTrue(result.contains("{'value':["));
    }

    @Test
    public void shouldConvertObjectWithAnotherObjectAsFieldToJson() throws Exception {
        ClassWithAnotherObjectAttribute objectWithAnotherObjectAsField = new ClassWithAnotherObjectAttribute(new ClassWithStringAttribute("prateek"));
        String result = ProJson.jsonify(objectWithAnotherObjectAsField);
        assertEquals("{'value0':{'value':'prateek'}}", result);
    }

    @Test
    public void shouldConvertObjectWithBigDecimalFieldToJson() throws Exception {
        ClassWithBigDecimalAttribute objectWithBigDecimalField = new ClassWithBigDecimalAttribute(new BigDecimal(1000000000000000000l).multiply(new BigDecimal(1000)));
        String result = ProJson.jsonify(objectWithBigDecimalField);
        assertEquals("{'value0':1000000000000000000000}", result);
    }

    @Test
    public void shouldConvertObjectWithBigIntegerFieldToJson() throws Exception {
        ClassWithBigIntegerAttribute objectWithBigIntegerField = new ClassWithBigIntegerAttribute(new BigInteger("1000000000000000000").multiply(new BigInteger("1000")));
        String result = ProJson.jsonify(objectWithBigIntegerField);
        assertEquals("{'value0':1000000000000000000000}", result);
    }

    @Test
    public void shouldConvertArrayWithObjectOfSpecificClassAsFieldToJson() throws Exception {
        ClassWithStringAttributeClassAsArrayAttribute objectWithArrayOfOtherObjectAsField = new ClassWithStringAttributeClassAsArrayAttribute(new ClassWithStringAttribute[]{new ClassWithStringAttribute("prateek"), new ClassWithStringAttribute("prateek")});
        String result = ProJson.jsonify(objectWithArrayOfOtherObjectAsField);
        assertEquals("{'values':[{'value':'prateek'},{'value':'prateek'}]}", result);
    }

    @Test
    public void shouldConvertArrayWithObjectsFieldToJson() throws Exception {
        ClassWithObjectArrayAttribute objectWithArrayOfDifferentObjectsAsField = new ClassWithObjectArrayAttribute(new Object[]{new ClassWithStringAttribute("prateek"), new ClassWithINTAttribute(5), new ClassWithStringArrayAttribute(new String[]{"prateek", "richi", "pooja", "iti", "mummy"})});
        String result = ProJson.jsonify(objectWithArrayOfDifferentObjectsAsField);
        assertEquals("{'values':[{'value':'prateek'},{'value':5},{'value':['prateek','richi','pooja','iti','mummy']}]}", result);
    }

    @Test
    public void shouldConvertBooleanPrimitiveFieldToJson() throws Exception {
        ClassWithBooleanTypeAttribute objectPrimitiveBooleanField = new ClassWithBooleanTypeAttribute(true);
        String result = ProJson.jsonify(objectPrimitiveBooleanField);
        assertEquals("{'value':true}", result);
    }

    @Test
    public void shouldConvertBooleanClassFieldToJson() throws Exception {
        ClassWithBooleanClassAttribute objectWithBooleanClassField = new ClassWithBooleanClassAttribute(new Boolean(true));
        String result = ProJson.jsonify(objectWithBooleanClassField);
        assertEquals("{'value':true}", result);
    }

    @Test
    public void shouldConvertDoubleTypeFieldToJson() throws Exception {
        ClassWithDoubleTypeAttribute objectWithPrimitiveDoubleField = new ClassWithDoubleTypeAttribute(10.5);
        String result = ProJson.jsonify(objectWithPrimitiveDoubleField);
        assertEquals("{'value':10.5}", result);
    }

    @Test
    public void shouldConvertDoubleClassFieldToJson() throws Exception {
        ClassWithDoubleClassAttribute objectWithClassDoubleField = new ClassWithDoubleClassAttribute(new Double(10.5));
        String result = ProJson.jsonify(objectWithClassDoubleField);
        assertEquals("{'value':10.5}", result);
    }

    @Test
    public void shouldConvertCharacterClassFieldToJson() throws Exception {
        ClassWithCharacterClassAttribute objectWithClassCharacterField = new ClassWithCharacterClassAttribute(new Character('p'));
        String result = ProJson.jsonify(objectWithClassCharacterField);
        assertEquals("{'value':'p'}", result);
    }

    @Test
    public void shouldConvertCharacterTypeFieldToJson() throws Exception {
        String result = ProJson.jsonify(new ClassWithCharacterTypeAttribute('p'));
        assertEquals("{'value':'p'}", result);
    }

    @Test
    public void shouldNotConvertTransientFieldFieldToJson() throws Exception {
        String result = ProJson.jsonify(new ClassWithTransientAttribute('p',10));
        assertEquals("{'value':'p'}", result);
    }
}