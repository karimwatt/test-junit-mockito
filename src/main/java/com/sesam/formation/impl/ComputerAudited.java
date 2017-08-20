package com.sesam.formation.impl;

import com.sesam.formation.api.Auditor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Karim on 29/06/2016.
 */
public class ComputerAudited extends ComputerDefault{

    @Getter @Setter
    Auditor auditor;

    public ComputerAudited() {}
    public ComputerAudited(Auditor auditor) {
        this.auditor = auditor;
    }

    @Override
    public int multiply(int i, int j) {

        return super.multiply(i,j);
    }

    @Override
    public int divide(int i, int j) {
        return super.divide(i,j);
    }

    @Override
    public int add(int i, int j) {
        return super.add(i,j);
    }
}
