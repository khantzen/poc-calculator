package com.khantzen.calculatrice.model;

import com.khantzen.calculatrice.expression.ExpressionReducer;
import com.khantzen.calculatrice.expression.Solver;

public class CalculTree {
    private String expression;
    private String operation;
    private String result;
    private CalculTree left;
    private CalculTree right;

    public CalculTree(String expression) {
        this.expression = expression;

        ExpressionReducer expressionReducer = new ExpressionReducer();

        boolean isReducibleExpression = expressionReducer.isReducible(expression);

        if (isReducibleExpression) {
            String[] splitedExpression = expression.split("\\+");
            this.operation = "+";
            this.left = new CalculTree(splitedExpression[0].trim());
            this.right = new CalculTree(splitedExpression[1].trim());
        } else {
            this.result = expression;
        }

    }

    public int solveTree() throws Exception {
        Solver solver = new Solver();
        if (result == null) {
            int leftResult = this.left.solveTree();
            int rightResult = this.right.solveTree();

            String reducedExpression = leftResult + " " + operation + " " + rightResult;
            return solver.solve(reducedExpression);
        } else {
            return solver.solve(result);
        }
    }

    public String getExpression() {
        return expression;
    }

    public CalculTree getLeft() {
        return left;
    }

    public CalculTree getRight() {
        return right;
    }
}
