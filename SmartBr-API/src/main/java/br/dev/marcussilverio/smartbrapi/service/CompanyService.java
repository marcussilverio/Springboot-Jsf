package br.dev.marcussilverio.smartbrapi.service;

import br.dev.marcussilverio.smartbrapi.dto.CompanyDto;
import br.dev.marcussilverio.smartbrapi.entity.Company;
import br.dev.marcussilverio.smartbrapi.model.CompanyResponse;
import br.dev.marcussilverio.smartbrapi.rest.CnpjWsRequestImpl;
import br.dev.marcussilverio.smartbrapi.rest.CnpjWsRequestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.dev.marcussilverio.smartbrapi.repository.CompanyRepository;

@Service
public class CompanyService {
   private final CompanyRepository companyRepository;
   private final CnpjWsRequestInterface<CompanyResponse> cnpjWsRequest;

   public CompanyService(CompanyRepository companyRepository, CnpjWsRequestImpl cnpjWsRequest) {
      this.companyRepository = companyRepository;
      this.cnpjWsRequest = cnpjWsRequest;
   }
   public CompanyDto getCompany(String cnpj){
      try {
         Company company = companyRepository.findByCnpj(cnpj);
         if(company != null){
            return CompanyDto.toDto(company);
         }
         CompanyResponse companyResponse = cnpjWsRequest.execute(cnpj).getBody();
         System.out.println("Getting info [ Company CNPJ: " + cnpj + " ]");
         return CompanyDto.toDto(companyResponse);
      }catch (Exception ex){
         throw new RuntimeException(ex);
      }
   }
   public boolean save(CompanyDto dto){
      Company company = dtoToEntity(dto);
      try {
         companyRepository.save(company);
         return true;
      }catch (Exception ex){
         return false;
      }
   }
   private Company dtoToEntity(CompanyDto dto){
      Company entity = new Company();
      entity.setCnpj(dto.getCNPJ());
      entity.setCity(dto.getCity());
      entity.setCompanyName(dto.getCompanyName());
      entity.setRegistrationStatus(dto.getRegistrationStatus());
      entity.setRegistrationDate(dto.getRegistrationDate());
      entity.setAddress(dto.getAddress());
      entity.setPhone(dto.getPhone());
      return entity;
   }
}
