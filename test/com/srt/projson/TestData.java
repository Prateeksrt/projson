package com.srt.projson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class ClassWithStringAttribute {
    private String value;

    public ClassWithStringAttribute(String value) {
        this.value = value;
    }
}

class ClassWithINTAttribute {
    private int value;

    public ClassWithINTAttribute(int value) {
        this.value = value;
    }
}

class ClassWithINTEGERAttribute {
    private Integer value;

    public ClassWithINTEGERAttribute(Integer value) {
        this.value = value;
    }
}

class ClassWithIntegerAndStringAttribute {
    private Integer value;
    private String value2;

    public ClassWithIntegerAndStringAttribute(String value2, Integer value) {
        this.value2 = value2;
        this.value = value;
    }
}

class ClassWithIntegerArrayAttribute {
    private Integer[] value;

    public ClassWithIntegerArrayAttribute(Integer[] value) {
        this.value = value;
    }
}

class ClassWithStringArrayAttribute {
    private String[] value;

    public ClassWithStringArrayAttribute(String[] value) {
        this.value = value;
    }
}

class ClassWithStringListAttribute {
    private List<String> value;

    public ClassWithStringListAttribute(List<String> value) {
        this.value = value;
    }
}

class ClassWithStringSetAttribute {
    private Set<String> value;

    public ClassWithStringSetAttribute(Set<String> value) {
        this.value = value;
    }
}

class ClassWithAnotherObjectAttribute {
    private ClassWithStringAttribute value0;

    public ClassWithAnotherObjectAttribute(ClassWithStringAttribute value0) {
        this.value0 = value0;
    }
}

class ClassWithBigDecimalAttribute {
    private BigDecimal value0;

    public ClassWithBigDecimalAttribute(BigDecimal value0) {
        this.value0 = value0;
    }
}

class ClassWithBigIntegerAttribute {
    private BigInteger value0;

    public ClassWithBigIntegerAttribute(BigInteger value0) {
        this.value0 = value0;
    }
}

class ClassWithStringAttributeClassAsArrayAttribute {
    private ClassWithStringAttribute[] values;

    public ClassWithStringAttributeClassAsArrayAttribute(ClassWithStringAttribute[] values) {
        this.values = values;
    }
}

class ClassWithObjectArrayAttribute {
    private Object[] values;

    public ClassWithObjectArrayAttribute(Object[] values) {
        this.values = values;
    }
}

class ClassWithBooleanTypeAttribute {
    private boolean value;

    public ClassWithBooleanTypeAttribute(boolean value) {
        this.value = value;
    }
}

class ClassWithBooleanClassAttribute {
    private Boolean value;

    public ClassWithBooleanClassAttribute(Boolean value) {
        this.value = value;
    }
}

class ClassWithDoubleTypeAttribute {
    private double value;

    public ClassWithDoubleTypeAttribute(double value) {
        this.value = value;
    }
}

class ClassWithDoubleClassAttribute {
    private Double value;

    public ClassWithDoubleClassAttribute(Double value) {
        this.value = value;
    }
}

class ClassWithCharacterClassAttribute {
    private Character value;

    public ClassWithCharacterClassAttribute(Character value) {
        this.value = value;
    }
}

class ClassWithCharacterTypeAttribute {
    private char value;

    public ClassWithCharacterTypeAttribute(char value) {
        this.value = value;
    }
}

class ClassWithTransientAttribute {
    private char value;
    private transient int a;

    public ClassWithTransientAttribute(char value, int a) {
        this.value = value;
        this.a = a;
    }
}
