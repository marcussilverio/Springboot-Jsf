package br.dev.marcussilverio.smartbrapi.rest;

import br.dev.marcussilverio.smartbrapi.model.CompanyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CnpjWsRequestImpl implements CnpjWsRequestInterface<CompanyResponse> {
   private final RestTemplate restTemplate;
   private final String CNPJ_WS_URI = "https://publica.cnpj.ws/cnpj/";
   private final Class<CompanyResponse> responseType;
   @Autowired
   public CnpjWsRequestImpl(RestTemplate restTemplate) {
      this.restTemplate = restTemplate;
      this.responseType = CompanyResponse.class;
   }
   @Override
   public ResponseEntity<CompanyResponse> execute(String cnpj) {
      String final_url = CNPJ_WS_URI + cnpj.trim();
      try {
         return restTemplate.getForEntity(final_url, responseType);
      }catch (Exception ex){
         throw new RuntimeException(ex.getMessage());
      }
   }
}
