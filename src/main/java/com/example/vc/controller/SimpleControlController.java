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


public class SimpleControlController {

    /**
     * curl --location --request POST 'http://localhost:8080/api/v1/account/new'
     */

    @RestController
    @RequestMapping("/api/v1/account")
    static class AccountV1Controller {
        @PostMapping(value = "/new")
        public ResponseEntity<?> addNew() {
            return ResponseEntity.ok("Account v1 added");
        }
    }

    /**
     * curl --location --request POST 'http://localhost:8080/api/v2/account/new'
     */

    @RestController
    @RequestMapping("/api/v2/account")
    static class AccountV2Controller {
        @PostMapping(value = "/new")
        public ResponseEntity<?> addNew() {
            return ResponseEntity.ok("Account v2 added");
        }
    }
}
