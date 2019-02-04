package com.khantzen.calculatrice.expression;


public class ExpressionReducer {
    public boolean isReducible(String expression) {
        String nonReducibleExpressionRegexp = "(\\d+? [+*\\/\\-] \\d+)|\\d+";
        return !expression.matches(nonReducibleExpressionRegexp);
    }
}
