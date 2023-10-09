# TESTE - SMARTBR - CNPJ.ws

O Desafio consiste em construir uma aplicação separada entre backend, frontend e banco de dados fazendo integração entre si e com API externa, de modo a possibilitar fazer uma consulta por cnpj no frontend, o backend processar a requisição e utilizar uma API externa <a href="https://www.cnpj.ws/" target="_blank">CNPJ.ws</a> para trazer os dados referentes ao cnpj consultado e tambem possibilitar a adição de dados extras, mantidos em banco de dados.
<br>
## Tecnologias Utilizadas
 * Java SpringBoot 3.0
 * Java JSF 2.3
 * PostgreSQL
 * Docker
 * Tomcat
## Download e Instalação

### Via Docker
#### Download

* Clone do Projeto
* <a href="https://docs.docker.com/desktop/" target="_blank">Download Docker</a>
* <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html" target="_blank">Download JDK 17+</a>

#### Build
* Navegue ate a pasta raiz de cada projeto e execute o comando:
    ```bash 
        mvn clean package
    ```
#### Executar
* Com o terminal aberto no diretorio em que esta localizado o arquivo `docker-compose.yml` execute o comando:
    ```bash
        docker-compose up
    ```
* Acessar pela url: `http://localhost:8080/SmartBr-1/index.xhtml`
## Considerações importantes
* Tive algumas dificuldades com relação a configuração inicial do projeto frontend por nunca ter trabalhado com JSF, pois existem varios detalhes de configuração que são impressindiveis pra que a apicação rode.
* Tentei implementar algumas funcionalidades como um dialog para quando o salvamento é efetuado com sucesso, porém não obtive exito, penso que por conta da pouca familiaridade com JSF. Ao clicar no botão `Salvar` não há nenhum feedback da página, mas ao realizar nova consulta no mesmo CNPJ verifica-se que os dados foram persistidos.
* Com a relação ao Backend, apensar de não ter trabalhado profissionalmente com SpringBoot, não tive dificuldades pois ja fiz alguns projetos pessoais utilizando essa tecnologia.



