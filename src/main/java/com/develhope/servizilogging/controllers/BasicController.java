package com.develhope.servizilogging.controllers;

import com.develhope.servizilogging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @Autowired
    private Environment environment;

    @Value("${myCustomVar.n1}")
    int myCustomVar1;

    @Value("${myCustomVar.n2}")
    int myCustomVar2;

    @Autowired
    BasicService basicService;
    Logger logger = LoggerFactory.getLogger(BasicController.class);


    @GetMapping("/")
    public ResponseEntity welcomeMessage(){
        try {
            logger.info("Starting BasicController on mapped (/)");
            logger.info("Welcome in logger!");
            return ResponseEntity.ok("Welcome in logger!");
        }catch (Exception e){
            logger.error("An exception occurred", e.getMessage(), e.getStackTrace());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }finally {
            logger.info("Ending BasicController on mapped (/)");
        }
    }

    @GetMapping("/exp")
    public ResponseEntity getService(){
        try {
            logger.info("Starting BasicController on mapped (/exp)");
            return ResponseEntity.ok(basicService.calculateEXP(myCustomVar1,myCustomVar2));
        }catch (Exception e){
            logger.error("An exception occurred", e.getMessage(), e.getStackTrace());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }finally {
            logger.info("Ending BasicController on mapped (/exp)");
        }
    }

    @GetMapping("/get-errors")
    public ResponseEntity getErrors(){
        try {
            logger.info("Starting BasicController on mapped (/get-errors)");
            Error error = new Error("This is the Error");
            logger.error("This is the ERROR logging",error);
            return ResponseEntity.ok("Error generated:\n" + error);
        }finally {
            logger.info("Ending BasicController on mapped (/get-errors)");
        }
    }
}
