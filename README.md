# Micro Service - Order Manager


###### Projeto Back-end 
API Rest contendo operações e fluxo para gerenciar pedidos. 


## Tecnologias

- Java JDK 8      -> https://www.oracle.com/java/technologies/javase-jdk8-downloads.html
- Maven           -> https://maven.apache.org/
- Swagger         -> https://swagger.io/
- SpringBoot      -> https://spring.io/projects/spring-boot
- SpringData      -> https://spring.io/projects/spring-data
- Lombok          -> https://projectlombok.org/
- Hibernate       -> https://hibernate.org/



## Serviços

| Metodo  |  End Point  | Descrição |
| ------------| ---------|---------|
|  POST  | /v1/order/create     | Cria o Pedido do Cliente  |
|  GET  |  /v1/order/find     | Obtém a informação de um Pedido |
|  GET  |  /v1/order/list   | Obtém a lista de todos os Pedidos |
|  DELETE  |  /v1/order/cancel     | Cancela um Pedido. |
|  PUT  |  /v1/order/update     | Atualizar Pedido. |

## Documentação


## Swagger  
 - Localhost
    http://localhost:8080/clientes/swagger-ui/index.html
 
 - Testes - Heroku 
    https://order-manager-ms.herokuapp.com/order-manager/swagger-ui/index.html#/
  
## Executar projeto (Maven)
1 - Entrar na pasta do projeto

2 - mvn clean package

3 - java -jar target/order-manager-0.0.1-SNAPSHOT.jar



## Construção

**Time Line**






 **Contato**
* leonardobarrosbhz@gmail.com
