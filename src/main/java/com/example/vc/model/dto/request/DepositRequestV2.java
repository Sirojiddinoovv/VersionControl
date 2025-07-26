package com.example.vc.model.dto.request;


/**
 * @author: Nodir
 * @date: 27.07.2025
 * @group: Meloman
 **/


public class DepositRequestV2 implements DepositRequest {
    private String name;
    private Long amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public DepositRequestV2() {
    }

    @Override
    public String toString() {
        return "DepositRequestV2{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
