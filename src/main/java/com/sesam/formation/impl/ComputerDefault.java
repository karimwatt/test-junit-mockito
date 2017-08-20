package com.sesam.formation.impl;

import com.sesam.formation.api.Computer;

/**
 * Created by Karim on 29/06/2016.
 */
public class ComputerDefault implements Computer {

    public int multiply(int i, int j) {
        return i *j;
    }

    @Override
    public int divide(int i, int j) {
        if (j==0) throw new IllegalArgumentException("division par 0");
        return i/j;
    }

    @Override
    public int add(int i, int j) {
        return i+j;
    }
}
