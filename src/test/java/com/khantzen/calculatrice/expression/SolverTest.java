package com.khantzen.calculatrice.expression;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class SolverTest {

    public Solver solver;

    @Before
    public void setUp() {
        this.solver = new Solver();
    }

    @Test
    public void solveAddition_Test() throws Exception {
        Assertions.assertThat(this.solver.solve("3 + 8")).isEqualTo(11);
    }

    @Test
    public void solveProduct_Test() throws Exception {
        Assertions.assertThat(this.solver.solve("11 * 44")).isEqualTo(484);
    }

    @Test
    public void solveSimpleSubtraction_Test() throws Exception {
        Assertions.assertThat(this.solver.solve("17 - 12")).isEqualTo(5);
    }

    @Test
    public void solveSingleNumber_Test() throws Exception {
        Assertions.assertThat(this.solver.solve("789")).isEqualTo(789);
    }
}
