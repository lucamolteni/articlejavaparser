package org.drools;

import java.io.InputStream;
import java.util.List;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.StringLiteralExpr;

public class JavaGenerator {

    public String method(String name) {
        InputStream resourceAsStream = String.class.getResourceAsStream("/Foo.java");
        CompilationUnit parse = StaticJavaParser.parse(resourceAsStream);

        List<StringLiteralExpr> nodes = parse.findAll(StringLiteralExpr.class, sl -> sl.toString().equals("\"_____whatever\""));

        nodes.forEach(n -> n.replace(new StringLiteralExpr(name)));

        return parse.toString();
    }
}
