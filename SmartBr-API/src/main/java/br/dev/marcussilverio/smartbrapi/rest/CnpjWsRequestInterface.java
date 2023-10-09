package br.dev.marcussilverio.smartbrapi.rest;

import org.springframework.http.ResponseEntity;

public interface CnpjWsRequestInterface <T>{
   ResponseEntity<T> execute(String url);
}
