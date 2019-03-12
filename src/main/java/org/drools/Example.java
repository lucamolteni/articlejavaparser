package org.drools;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.LambdaExpr;
import com.github.javaparser.ast.expr.LongLiteralExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

public class Example {

    public static void main(String[] args) throws Exception {
        Expression e = StaticJavaParser.parseExpression("name == \"Luca\"");

        System.out.println("e = " + e);

        Expression lambda = StaticJavaParser.parseExpression("(_this) -> _this.length() > 3");

// Comparison Expression
        MethodCallExpr left = new MethodCallExpr(new NameExpr("_this"), "length");
        BinaryExpr comparisonExpr = new BinaryExpr(left, new IntegerLiteralExpr(3), BinaryExpr.Operator.GREATER);

// Lambda Parameter
        ClassOrInterfaceType stringType = new ClassOrInterfaceType(null, String.class.getCanonicalName());
        Parameter parameter = new Parameter(stringType, "_this");

// Lambda Expression
        BlockStmt body = new BlockStmt();
        body.addStatement(comparisonExpr);
        LambdaExpr lambdaExpression = new LambdaExpr(parameter, body);

        System.out.println("lambdaExpr = " + lambdaExpression);


        // Avoid String concatenation (qs-playground/CanonicalModelKieProject.java:150)
        // DMN templating ( JavaParserSourceGenerator.java)
        // POJO templating (POJOGenerator.java)
        // Visiting nodes (ExpressionTyper.java)
        // Utility in model compiler (DrlxParseUtil.java)
        // Reloading class from ClassLoader (CanonicalModelKieProject.java:80)
        // Quasi quoting?

//        "public class Foo { } ";

    }
}
