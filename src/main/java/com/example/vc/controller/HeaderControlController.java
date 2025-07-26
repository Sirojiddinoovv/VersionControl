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
@RequestMapping("/api/loan")
/**
 *     "error": "Not Found" if header not set
 */
public class HeaderControlController {

    /**
     * curl --location --request POST 'http://localhost:8080/api/loan/new' \
     * --header 'X-API-Version: 1'
     */

    @PostMapping(value = "/new", headers = "X-API-Version=1")
    public ResponseEntity<?> addNewV1() {
        return ResponseEntity.ok("Loan v1 added");
    }

    /**
     * curl --location --request POST 'http://localhost:8080/api/loan/new' \
     * --header 'X-API-Version: 2'
     */

    @PostMapping(value = "/new", headers = "X-API-Version=2")
    public ResponseEntity<?> addNewV2() {
        return ResponseEntity.ok("Loan v2 added");
    }
}
