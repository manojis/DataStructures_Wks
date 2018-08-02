package com.datacoral.jsonapp.rest;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manoj.Mohanan Nair
 * @Date 7/27/18
 */
@RestController
@SpringBootApplication
@RequestMapping("api")
public class CodexRestService {

    @RequestMapping("flatten")
    public ResponseEntity flattenJson(
            @RequestParam(value = "file") String filePath){

        String response = "Tested successfully";
        return new ResponseEntity(response, HttpStatus.OK);
    }




}
