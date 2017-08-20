package com.sesam.formation.mockito;

import com.sesam.formation.impl.ComputerDefault;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;


public class MockitoCaptorTest {

    //@Captor
    ComputerDefault computer;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void test() {
    }
    }