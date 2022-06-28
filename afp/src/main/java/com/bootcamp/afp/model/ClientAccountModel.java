package com.bootcamp.afp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientAccountModel {
    @JsonProperty("clientAccountId")
    @Builder.Default
    private Long id = null;

    @Builder.Default
    private Long client_afp_id= null;

    @Builder.Default
    private Float amount= null;

    @Builder.Default
    private Date retire_date= null;

    @Builder.Default
    private String account= null;
}
