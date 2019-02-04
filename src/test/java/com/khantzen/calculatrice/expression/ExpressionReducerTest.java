package com.khantzen.calculatrice.expression;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ExpressionReducerTest {

    private ExpressionReducer reducer;

    @Before
    public void setUp() {
        this.reducer = new ExpressionReducer();
    }

    @Test
    public void isReducibleExpression_Test() {
        Assertions.assertThat(this.reducer.isReducible("5 * 5 + 3")).isTrue();
    }

    @Test
    public void isNonReducibleExpression_Test() {
        Assertions.assertThat(this.reducer.isReducible("5 * 5")).isFalse();
        Assertions.assertThat(this.reducer.isReducible("7 + 3")).isFalse();
        Assertions.assertThat(this.reducer.isReducible("2 - 5")).isFalse();
    }

    @Test
    public void isSingleNumber_Test() {
        Assertions.assertThat(this.reducer.isReducible("5")).isFalse();
    }
}
