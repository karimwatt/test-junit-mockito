package com.sesam.formation.impl;

import com.sesam.formation.api.Auditor;
import org.apache.log4j.Logger;

/**
 * Created by Karim on 29/06/2016.
 */
public class AuditorLog4j implements Auditor{

    private static final Logger LOGGER = Logger.getLogger(AuditorLog4j.class);

    @Override
    public void audit(String message) {

        LOGGER.info(message);

    }
}
