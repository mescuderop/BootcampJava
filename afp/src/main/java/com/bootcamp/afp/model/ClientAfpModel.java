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
public class ClientAfpModel {

    @JsonProperty("clientAfpId")
    @Builder.Default
    private Long id = null;

    @Builder.Default
    private Long client_id = null;

    @Builder.Default
    private Long afp_id = null;

}
