package com.sesam.formation.impl;

import com.sesam.formation.api.BankSystem;
import com.sesam.formation.api.Computer;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Karim on 29/06/2016.
 */
public class BankSystemDefault implements BankSystem {

    @Getter @Setter
    Computer computer;

    @Override
    public int computeAccount(Integer... operations) {

        int credit = 0;

        for( Integer operation : operations)
        {
            credit = computer.add(credit,operation);
        }
        return credit;
    }
}
