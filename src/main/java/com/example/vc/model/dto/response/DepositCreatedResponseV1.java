package com.example.vc.model.dto.response;


/**
 * @author: Nodir
 * @date: 27.07.2025
 * @group: Meloman
 **/


public class DepositCreatedResponseV1 implements DepositCreatedResponse {
    private String type = "v1";
    private Boolean isSuccess;


    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public DepositCreatedResponseV1(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public DepositCreatedResponseV1() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DepositCreatedResponseV1{" +
                "type='" + type + '\'' +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
