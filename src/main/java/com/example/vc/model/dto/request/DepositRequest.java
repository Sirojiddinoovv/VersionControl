package com.example.vc.model.dto.request;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author: Nodir
 * @date: 27.07.2025
 * @group: Meloman
 **/

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DepositRequestV1.class, name = "v1"),
        @JsonSubTypes.Type(value = DepositRequestV2.class, name = "v2")
})
public interface DepositRequest {

}
