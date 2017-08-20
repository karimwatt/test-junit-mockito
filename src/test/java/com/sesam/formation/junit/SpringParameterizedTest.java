package com.sesam.formation.junit;

import com.sesam.formation.api.Computer;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Karim on 29/06/2016.
 */
@RunWith(Parameterized.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class SpringParameterizedTest {

    // fields used together with @Parameter must be public
    @Parameterized.Parameter
    public int m1;
    @Parameterized.Parameter(value = 1)
    public int m2;

    @Autowired
    Computer computer;

    @ClassRule
    public static final SpringClassRule SCR = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    // creates the test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 1 , 2 }, { 5, 3 }, { 121, 4 } };
        return Arrays.asList(data);
    }

    @Test
    public void testMultiplyException() {
        assertEquals("Result", m1 * m2, computer.multiply(m1, m2));
    }


}
