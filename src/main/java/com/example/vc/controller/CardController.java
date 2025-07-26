package com.example.vc.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Nodir
 * @date: 26.07.2025
 * @group: Meloman
 **/

@RestController
@RequestMapping("/api/card")
public class CardController {

    /**
     * curl --location --request POST 'http://localhost:8080/api/card/new' \
     * --header 'Accept: application/vnd.company.api.v1+json'
     */

    @PostMapping(
            value = "/new",
            produces = "application/vnd.company.api.v1+json"
    )
    public ResponseEntity<?> addNewCardV1() {
        //todo call service

        return ResponseEntity.ok("Card v1 added");
    }


    /**
     * curl --location --request POST 'http://localhost:8080/api/card/new' \
     * --header 'Accept: application/vnd.company.api.v2+json'
     */

    @PostMapping(
            value = "/new",
            produces = "application/vnd.company.api.v2+json"
    )
    public ResponseEntity<?> addNewCardV2() {
        //todo call service

        return ResponseEntity.ok("Card v2 added");
    }
}
