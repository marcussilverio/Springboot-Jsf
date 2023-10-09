package br.dev.marcussilverio.smartbrapi.dto;

import br.dev.marcussilverio.smartbrapi.entity.Company;
import br.dev.marcussilverio.smartbrapi.model.CompanyResponse;
import br.dev.marcussilverio.smartbrapi.model.Establishment;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
      private String CNPJ;
      private String companyName;
      private String city;
      private String registrationStatus;
      @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
      @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
      @JsonSerialize(using = DateSerializer.class)
      private Date registrationDate;
      private String phone;
      private String address;
      public static CompanyDto toDto(CompanyResponse response){
            if(response == null) return null;
            CompanyDto dto = new CompanyDto();
            dto.setCompanyName(response.getCompanyName());

            Establishment establishment = response.getEstablishment();
            if(establishment != null){
                  dto.setCNPJ(establishment.getCnpj());
                  dto.setCity(establishment.getCity() != null ? establishment.getCity().getName() : null);
                  dto.setRegistrationStatus(establishment.getRegistrationStatus());
                  dto.setRegistrationDate(establishment.getRegistrationDate());
            }
            return dto;
      }
      public static CompanyDto toDto(Company entity){
            if(entity == null) return null;
            CompanyDto dto = new CompanyDto();
            dto.setCNPJ(entity.getCnpj());
            dto.setCity(entity.getCity());
            dto.setCompanyName(entity.getCompanyName());
            dto.setRegistrationDate(entity.getRegistrationDate());
            dto.setRegistrationStatus(entity.getRegistrationStatus());
            dto.setAddress(entity.getAddress());
            dto.setPhone(entity.getPhone());
            return dto;
      }
   }
