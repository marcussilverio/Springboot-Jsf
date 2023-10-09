package br.dev.marcussilverio.smartbrapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import lombok.Data;

import java.util.Date;
@Data
public class Establishment {
   @JsonProperty("cnpj")
   private String cnpj;
   @JsonProperty("situacao_cadastral")
   private String registrationStatus;
   @JsonProperty("cidade")
   private City city;
   @JsonProperty("data_inicio_atividade")
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
   @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
   @JsonSerialize(using = DateSerializer.class)
   private Date registrationDate;

}
