package com.khantzen.calculatrice.expression;

import com.khantzen.calculatrice.model.CalculTree;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class TreeBuilderTest {

    private TreeBuilder treeBuilder;

    @Before
    public void setUp() {
        this.treeBuilder = new TreeBuilder();
    }

    @Test
    public void noLeafTree_Test() {
        this.treeBuilder.buildTree("5 + 5");
        CalculTree expTree = this.treeBuilder.getTree();

        Assertions.assertThat(expTree.getExpression()).isEqualTo("5 + 5");
        Assertions.assertThat(expTree.getLeft()).isNull();
        Assertions.assertThat(expTree.getRight()).isNull();
    }

    @Test
    public void twoLeafTree_Test() {
        this.treeBuilder.buildTree("5 * 10 + 5");

        CalculTree expTree = this.treeBuilder.getTree();
        Assertions.assertThat(expTree.getExpression()).isEqualTo("5 * 10 + 5");

        CalculTree left = expTree.getLeft();
        Assertions.assertThat(left).isNotNull();
        Assertions.assertThat(left.getExpression()).isEqualTo("5 * 10");

        CalculTree right = expTree.getRight();
        Assertions.assertThat(right).isNotNull();
        Assertions.assertThat(right.getExpression()).isEqualTo("5");
    }

    @Test
    public void solveTree_Test() throws Exception {
        this.treeBuilder.buildTree("5 * 6 + 7");
        CalculTree expTree = this.treeBuilder.getTree();
        int result = expTree.solveTree();
        Assertions.assertThat(result).isEqualTo(37);
    }
}
