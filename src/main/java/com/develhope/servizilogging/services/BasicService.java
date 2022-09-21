package com.develhope.servizilogging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    Logger logger = LoggerFactory.getLogger(BasicService.class);

    public String calculateEXP(int myCustomVar1, int myCustomVar2){
        try {
            logger.info("Start of EXP calculation");
            logger.info("myCustomVar1: " + myCustomVar1 + " & myCustomVar2: " + myCustomVar2);
            logger.debug("Calculating exponent for the environment variable myCustomVar1");
            double exp1 = Math.getExponent(myCustomVar1);
            logger.debug("Exponent calculated and assigned to the variable exp1");
            logger.debug("Calculating exponent for the environment variable myCustomVar2");
            double exp2 = Math.getExponent(myCustomVar2);
            logger.debug("Exponent calculated and assigned to the variable exp2");
            return "Exponent of myCustomVar1 is: " + exp1 + " - Exponent of myCustomVar2 is:  " + exp2;
        }catch (Exception e){
            logger.error("An exception occurred", e.getMessage(), e.getStackTrace());
            return null;
        }finally {
            logger.info("Ending of EXP calculation");
        }
    }
}