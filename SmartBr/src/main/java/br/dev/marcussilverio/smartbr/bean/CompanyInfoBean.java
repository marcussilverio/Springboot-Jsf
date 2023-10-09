package br.dev.marcussilverio.smartbr.bean;

import br.dev.marcussilverio.smartbr.bean.dto.CompanyDto;
import br.dev.marcussilverio.smartbr.rest.RestClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named("companyInfoBean")
@RequestScoped
@Getter
@Setter
public class CompanyInfoBean {
   CompanyDto company;
   private RestClient restClient;
   private SessionBean sessionBean;
   @Inject
   public CompanyInfoBean(RestClient restClient,SessionBean sessionBean) {
      this.restClient = restClient;
      this.sessionBean = sessionBean;
      this.company = sessionBean.getCompany();
   }
   public void redirect() {
      ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
      try {
         externalContext.redirect("index.xhtml");
      } catch (IOException e) {
         e.printStackTrace();
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro ao redirecionar."));
      }
   }
   public void save(){
      if((company.getAddress() == null || company.getAddress().isEmpty()) && ((company.getPhone() == null || company.getPhone().isEmpty()))){
         return;
      }
      restClient.saveCompany(company);
   }
}
