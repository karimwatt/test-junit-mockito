package com.sesam.formation.impl;

/**
 * Created by Karim on 29/06/2016.
 */
public class ComputerDelayed extends ComputerCorrected {

   private long delay = 15000;

    @Override
    public int multiply(int i, int j) {

        delay();

        return super.multiply(i,j);
    }

    @Override
    public int divide(int i, int j) {

        delay();

        return super.divide(i,j);
    }

    private void delay() {
        try {
            Thread.sleep(delay);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
