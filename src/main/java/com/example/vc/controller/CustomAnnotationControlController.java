package com.example.vc.controller;


import com.example.vc.model.annotation.ApiVersion;
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
@RequestMapping("/api/client")
/**
 *     "error": "Not Found" if version not set
 */
public class CustomAnnotationControlController {

    @PostMapping(value = "/new")
    @ApiVersion("1")
    public ResponseEntity<?> addNewV1() {
        return ResponseEntity.ok("Client v1 added");
    }

    @PostMapping(value = "/new")
    @ApiVersion("2")
    public ResponseEntity<?> addNewV2() {
        return ResponseEntity.ok("Client v2 added");
    }
}
