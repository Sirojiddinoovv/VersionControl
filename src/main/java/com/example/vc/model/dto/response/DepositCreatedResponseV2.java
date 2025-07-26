package com.example.vc.model.dto.response;


/**
 * @author: Nodir
 * @date: 27.07.2025
 * @group: Meloman
 **/


public class DepositCreatedResponseV2 implements DepositCreatedResponse {
    private String type = "v2";
    private Boolean isSuccess;
    private String transactionId;

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public DepositCreatedResponseV2(Boolean isSuccess, String transactionId) {
        this.isSuccess = isSuccess;
        this.transactionId = transactionId;
    }

    public DepositCreatedResponseV2() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DepositCreatedResponseV2{" +
                "type='" + type + '\'' +
                ", isSuccess=" + isSuccess +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}
