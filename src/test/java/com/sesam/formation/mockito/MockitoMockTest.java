package com.sesam.formation.mockito;

import com.sesam.formation.api.Computer;
import com.sesam.formation.impl.BankSystemDefault;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;


public class MockitoMockTest {

    @Mock
    Computer computer;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void test() {

        BankSystemDefault bankSystem = new BankSystemDefault();
        bankSystem.setComputer(computer);

        when(computer.add(anyInt(),anyInt())).thenReturn(0);

        assertEquals("should be 0", 0, bankSystem.computeAccount(1,2,3));

        verify(computer, times(3)).add(anyInt(),anyInt());
        verify(computer, times(1)).add(0,1);
        verify(computer, times(1)).add(0,2);
    }

}