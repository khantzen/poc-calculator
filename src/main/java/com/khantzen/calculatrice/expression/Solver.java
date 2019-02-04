package com.khantzen.calculatrice.expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solver {
    public int solve(String expression) throws Exception {
        Pattern expressionPattern = Pattern.compile("(?<left>\\d+) (?<operation>[+*\\/-]) (?<right>\\d+)|(?<single>\\d+)");

        Matcher expressionMatcher = expressionPattern.matcher(expression);

        if (expressionMatcher.find()) {
            String singleResult = expressionMatcher.group("single");
            boolean isSingleResult = singleResult != null;

            if (!isSingleResult) {
                int leftMember = Integer.parseInt(expressionMatcher.group("left"));
                int rightMember = Integer.parseInt(expressionMatcher.group("right"));

                String operation = expressionMatcher.group("operation");

                switch (operation) {
                    case "+":
                        return leftMember + rightMember;
                    case "*":
                        return leftMember * rightMember;
                    case "-":
                        return leftMember - rightMember;
                    default:
                        throw new Exception("Invalid expression");
                }

            } else {
                return Integer.parseInt(singleResult);
            }

        } else {
            throw new Exception("Invalid expression");
        }

    }
}
