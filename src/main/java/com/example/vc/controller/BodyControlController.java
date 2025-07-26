package com.example.vc.controller;


import com.example.vc.model.dto.request.DepositRequest;
import com.example.vc.model.dto.request.DepositRequestV1;
import com.example.vc.model.dto.request.DepositRequestV2;
import com.example.vc.model.dto.response.DepositCreatedResponse;
import com.example.vc.service.DepositService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Nodir
 * @date: 27.07.2025
 * @group: Meloman
 **/

@RestController
@RequestMapping("/api/deposit")

/**
 * Errors:
 * JSON parse error: Could not resolve type id 'v3' as a subtype of `com.example.vc.model.dto.request.DepositRequest`: known type ids = [v1, v2]]
 * JSON parse error: Could not resolve subtype of [simple type, class com.example.vc.model.dto.request.DepositRequest]: missing type id property 'type']
 */
public class BodyControlController {
    private final DepositService depositService;

    public BodyControlController(DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping("/new")
    public ResponseEntity<DepositCreatedResponse> addNew(@RequestBody DepositRequest request) {
        return ResponseEntity.ok(depositService.open(request));
    }
}
