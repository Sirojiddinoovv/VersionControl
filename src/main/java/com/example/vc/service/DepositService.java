package com.example.vc.service;


import com.example.vc.model.dto.request.DepositRequest;
import com.example.vc.model.dto.request.DepositRequestV1;
import com.example.vc.model.dto.request.DepositRequestV2;
import com.example.vc.model.dto.response.DepositCreatedResponse;
import com.example.vc.model.dto.response.DepositCreatedResponseV1;
import com.example.vc.model.dto.response.DepositCreatedResponseV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author: Nodir
 * @date: 27.07.2025
 * @group: Meloman
 **/

@Service
public class DepositService {
    private final Logger log = LoggerFactory.getLogger(DepositService.class);

    public DepositCreatedResponse open(DepositRequest request) {
        log.info("Received command to opening deposit with request: {}", request);

        if (request instanceof DepositRequestV1) {
            var response = new DepositCreatedResponseV1(true);
            log.info("Finished command to opening deposit with v1 response: {}", response);
            return response;
        } else if (request instanceof DepositRequestV2) {
            var response = new DepositCreatedResponseV2(true, UUID.randomUUID().toString());
            log.info("Finished command to opening deposit with v2 response: {}", response);
            return response;
        }

        throw new RuntimeException("Invalid type of deposit request");
    }
}
