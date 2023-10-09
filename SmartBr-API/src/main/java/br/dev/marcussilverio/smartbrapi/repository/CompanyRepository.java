package br.dev.marcussilverio.smartbrapi.repository;

import br.dev.marcussilverio.smartbrapi.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
public interface CompanyRepository  extends JpaRepository<Company, String> {
   Company findByCnpj(String cnpj);
}
