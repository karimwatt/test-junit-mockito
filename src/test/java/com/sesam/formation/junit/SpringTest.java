package com.sesam.formation.junit;

import com.sesam.formation.api.Computer;
import com.sesam.formation.impl.ComputerDelayed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Karim on 29/06/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class SpringTest {

    @Autowired
    Computer computer;

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrown() {
        computer.divide(1000,0);
    }

    @Test
    public void testMultiply() {
        assertEquals("10 x 5 must be 50", 50, computer.multiply(10, 5));
    }

    @Test
    public void testDivide() {
        assertEquals("10 / 5 must be 2", 2, computer.divide(10, 5));
    }

    @Test(timeout = 1000L)
    public void testTimeOut() {
        Computer tester = new ComputerDelayed();
        assertEquals("10 / 5 must be 2", 2, computer.divide(10, 5));
    }
}
