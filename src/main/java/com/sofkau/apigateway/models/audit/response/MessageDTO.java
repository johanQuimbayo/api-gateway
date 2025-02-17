package com.sofkau.apigateway.models.audit.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
public class MessageDTO {

    private String id;
    @JsonProperty("idEntidad")
    private String idEntidad;

    @JsonProperty("fecha")
    @NonNull
    private String fecha;

    @JsonProperty("mensaje")
    private String mensaje;

    @JsonProperty("recurso")
    private String recurso;

    @JsonProperty("estado")
    private boolean estado;
}


