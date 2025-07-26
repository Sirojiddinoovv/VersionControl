package com.example.vc.model.dto.request;


/**
 * @author: Nodir
 * @date: 27.07.2025
 * @group: Meloman
 **/


public class DepositRequestV1 implements DepositRequest {
    private Long amount;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public DepositRequestV1() {
    }

    @Override
    public String toString() {
        return "DepositRequestV1{" +
                "amount=" + amount +
                '}';
    }
}
