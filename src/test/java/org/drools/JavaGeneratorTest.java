package org.drools;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaGeneratorTest {


    @Test
    public void myTest() {

        String pippo = new JavaGenerator().method("pippo");

        assertEquals("package org.drools;\n" +
                             "\n" +
                             "public class Foo {\n" +
                             "\n" +
                             "    public String bar() {\n" +
                             "        return \"pippo\";\n" +
                             "    }\n" +
                             "}\n", pippo);


    }

}