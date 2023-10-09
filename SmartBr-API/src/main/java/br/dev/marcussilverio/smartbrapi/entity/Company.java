package br.dev.marcussilverio.smartbrapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Entity
@Getter
@Setter
@ToString
public class Company {
   @Id
   private String cnpj;
   private String companyName;
   private String city;
   private String registrationStatus;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
   @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
   @JsonSerialize(using = DateSerializer.class)
   private Date registrationDate;
   private String phone;
   private String address;
}
