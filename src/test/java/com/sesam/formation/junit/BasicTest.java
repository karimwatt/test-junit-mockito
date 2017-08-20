package com.sesam.formation.junit;

import com.sesam.formation.api.Computer;
import com.sesam.formation.impl.ComputerDefault;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Karim on 29/06/2016.
 */
public class BasicTest {

    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrown() {
        Computer tester = new ComputerDefault();
        tester.divide(1000,0);
    }

    @Test
    public void testMultiply() {
        Computer tester = new ComputerDefault();
        assertEquals("10 x 5 must be 50", 50, tester.multiply(10, 5));
    }

    @Test
    public void testDivide() {
        Computer tester = new ComputerDefault();
        assertEquals("10 / 5 must be 2", 2, tester.divide(10, 5));
    }

    @Test(timeout = 1000L)
    public void testTimeOut() {
        Computer tester = new ComputerDefault();
        assertEquals("10 / 5 must be 2", 2, tester.divide(10, 5));
    }
}
