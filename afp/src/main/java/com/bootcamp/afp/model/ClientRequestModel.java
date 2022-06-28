package com.bootcamp.afp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestModel {
    @JsonProperty("clientRequestId")
    @Builder.Default
    private Long id = null;

    @Builder.Default
    private Long client_account_id= null;

    @Builder.Default
    private Float amount= null;


}
