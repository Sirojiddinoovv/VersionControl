package com.example.vc.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Nodir
 * @date: 27.07.2025
 * @group: Meloman
 **/

@RestController
@RequestMapping("/api/transaction")

/**
 * Resolved [org.springframework.web.bind.UnsatisfiedServletRequestParameterException: Parameter conditions "version=1" OR "version=2" not met for actual request parameters: ]
 */
public class ParamsControlController {

    /**
     curl --location --request POST 'http://localhost:8080/api/transaction/create?version=1'
     */

    @PostMapping(value = "/create", params = "version=1")
    public ResponseEntity<String> addNewV1() {
        return ResponseEntity.ok("Transaction v1");
    }

    /**
     curl --location --request POST 'http://localhost:8080/api/transaction/create?version=2'
     */

    @PostMapping(value = "/create", params = "version=2")
    public ResponseEntity<String> addNewV2() {
        return ResponseEntity.ok("Transaction v2");
    }

}
