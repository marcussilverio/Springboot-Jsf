package br.dev.marcussilverio.smartbrapi.controller;

import br.dev.marcussilverio.smartbrapi.dto.CompanyDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.dev.marcussilverio.smartbrapi.service.CompanyService;

@RestController
@RequestMapping("company")
public class CompanyController {
   private final CompanyService companyService;
   public CompanyController(CompanyService companyService) {
      this.companyService = companyService;
   }
   @GetMapping("/{cnpj}")
   public CompanyDto getCompanyInfo(@PathVariable String cnpj){
      return companyService.getCompany(cnpj);
   }
   @PostMapping("/save")
   public boolean save(@RequestBody CompanyDto dto){
      return companyService.save(dto);
   }
}
