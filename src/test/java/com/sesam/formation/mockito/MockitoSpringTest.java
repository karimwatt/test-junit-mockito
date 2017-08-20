package com.sesam.formation.mockito;

import com.sesam.formation.impl.BankSystemDefault;
import com.sesam.formation.impl.ComputerDefault;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MockitoSpringTest {

    @Autowired
    ComputerDefault computer;

    @Autowired
    BankSystemDefault bankSystem;

    @ClassRule
    public static final SpringClassRule SCR = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Before
    public void init() {
        computer = spy((computer));
        bankSystem.setComputer(computer);
    }

    @Test
    public void test() {

        when(computer.add(anyInt(),anyInt())).thenReturn(0);

        assertEquals("should be 0", 0, bankSystem.computeAccount(1,2,3));

        verify(computer, times(3)).add(anyInt(),anyInt());

    }

}