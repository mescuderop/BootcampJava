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
public class ClientModel {

    @JsonProperty("clientId")
    @Builder.Default
    private Long id = null;

    @Builder.Default
    private String dni = null;

    @Builder.Default
    private  String name = null;

    @Builder.Default
    private String lastname = null;

    @Builder.Default
    private String phone = null;

    @Builder.Default
    private String email = null;


}
