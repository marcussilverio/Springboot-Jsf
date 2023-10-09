package br.dev.marcussilverio.smartbr.bean;

import br.dev.marcussilverio.smartbr.bean.dto.CompanyDto;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@ManagedBean
@SessionScoped
@Getter
@Setter
@Named("sessionBean")
public class SessionBean implements Serializable {
   private CompanyDto company;
}
