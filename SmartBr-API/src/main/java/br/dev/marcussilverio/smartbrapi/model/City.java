package br.dev.marcussilverio.smartbrapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class City {
   @JsonProperty("nome")
   private String name;
}
