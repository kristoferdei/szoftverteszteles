package pti.gyak;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testResult() {
        assertEquals(6.0, (new Calculator()).enter(5).enter(Operation.ADD).enter(1).result);
    }

    @Test
    public void testHistory() {
        assertEquals("5 + 1 = 6", (new Calculator()).enter(5).enter(Operation.ADD).enter(1).getHistory());
    }

    @Test
    public void testSubstract() {
        assertEquals(4.0, (new Calculator()).enter(5).enter(Operation.SUBSTRACT).enter(1).result);
    }

    @Test
    public void testMultiply() {
        assertEquals(10.0, (new Calculator()).enter(5).enter(Operation.MULTIPLY).enter(2).result);
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, (new Calculator()).enter(10).enter(Operation.DIVIDE).enter(5).result);
    }

    @Test
    public void testDivide2() {
        assertEquals( Double.POSITIVE_INFINITY, (new Calculator()).enter(10).enter(Operation.DIVIDE).enter(0).result);
    }

    @Test
    public void testDivide3() {
        assertEquals( Double.NEGATIVE_INFINITY, (new Calculator()).enter(-10).enter(Operation.DIVIDE).enter(0).result);
    }

    @Test
    public void testRemainder() {
        assertEquals( 1.0, (new Calculator()).enter(10).enter(Operation.REMAINDER).enter(3).result);
    }

    @Test
    public void testPower() {
        assertEquals( 8.0, (new Calculator()).enter(2).enter(Operation.POWER).enter(3).result);
    }

    @Test
    public void testClear() {
        assertEquals(0, (new Calculator()).enter(5).enter(Operation.CLEAR).result);
    }

    @Test
    public void testSQRT() {
        assertEquals(2.0, (new Calculator()).enter(4).enter(Operation.SQRT).result);
    }

    @Test
    public void testNoNumberAndNoOperation() {
        assertEquals(0, (new Calculator()).result);
    }
}