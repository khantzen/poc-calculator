package com.khantzen.calculatrice.expression;

import com.khantzen.calculatrice.model.CalculTree;

public class TreeBuilder {
    private CalculTree tree;

    public void buildTree(String expression) {
        this.tree = new CalculTree(expression);
    }

    public CalculTree getTree() {
        return this.tree;
    }
}
