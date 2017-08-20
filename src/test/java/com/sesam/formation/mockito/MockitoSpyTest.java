package com.sesam.formation.mockito;

import com.sesam.formation.impl.BankSystemDefault;
import com.sesam.formation.impl.ComputerDefault;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;


public class MockitoSpyTest {

    @Spy
    ComputerDefault computer;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void test() {

        BankSystemDefault bankSystem = new BankSystemDefault();
        bankSystem.setComputer(computer);

        when(computer.add(1,2)).thenReturn(0);

        assertEquals("should be 0", 3, bankSystem.computeAccount(1,2,3));

        verify(computer, times(3)).add(anyInt(),anyInt());

    }

}