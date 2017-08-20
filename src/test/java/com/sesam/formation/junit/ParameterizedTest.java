package com.sesam.formation.junit;

import com.sesam.formation.api.Computer;
import com.sesam.formation.impl.ComputerDefault;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Karim on 29/06/2016.
 */
@RunWith(Parameterized.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ParameterizedTest {

    // fields used together with @Parameter must be public
    @Parameterized.Parameter
    public int m1;
    @Parameterized.Parameter(value = 1)
    public int m2;

    // creates the test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 1 , 2 }, { 5, 10 }, { 121, 4 } };
        return Arrays.asList(data);
    }


    @Test
    public void testMultiplyException() {
        Computer computer = new ComputerDefault();
        assertEquals("Result", m1 * m2, computer.multiply(m1, m2));
    }

    @Test
    public void testDivideException() {
        Computer computer = new ComputerDefault();
        assertEquals("Result", m1 / m2, computer.divide(m1, m2));
    }

    @Test
    public void testAdd() {
        Computer computer = new ComputerDefault();
        assertEquals("Add some values", m1 + m2, computer.add(m1, m2));
    }


}
