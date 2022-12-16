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



# Serviços


## Item Manage

| Metodo  |  End Point  | Descrição |
| ------------| ---------|---------|
|  POST  | /v1/item/create     | Cria um item  |
|  GET  |  /v1/item/find/{id}     | Obtém a informação de um item |
|  GET  |  /v1/item/list   | Obtém a lista de todos os itens |
|  DELETE  |  /v1/item/cancel/{id}     | Exclui um item. |
|  PUT  |  /v1/item/update     | Atualiza item. |

## User Manage

| Metodo  |  End Point  | Descrição |
| ------------| ---------|---------|
|  POST  | /v1/user/create     | Cria um Usuario  |
|  GET  |  /v1/user/find/{id}     | Obtém a informação de um Usuario |
|  GET  |  /v1/user/list   | Obtém a lista de todos os Usuarios |
|  DELETE  |  /v1/user/delete/{id}     | Exclui um Usuario. |
|  PUT  |  /v1/user/update     | Atualiza um Usuario. |

## Order Manage

| Metodo  |  End Point  | Descrição |
| ------------| ---------|---------|
|  POST  | /v1/order/create     | Cria o Pedido do Cliente  |
|  GET  |  /v1/order/find/{id}     | Obtém a informação de um Pedido |
|  GET  |  /v1/order/list   | Obtém a lista de todos os Pedidos |
|  DELETE  |  /v1/order/cancel/{id}     | Cancela um Pedido. |
|  PUT  |  /v1/order/update     | Atualiza um Pedido. |

## Documentação / Swagger

 
 - Localhost
    http://localhost:8080/clientes/swagger-ui/index.html
 
 -  Heroku (Cloud) 
    https://order-manager-ms.herokuapp.com/order-manager/swagger-ui/index.html#/
  
## Executar projeto (Maven)
1 - Entrar na pasta do projeto

2 - mvn clean package

3 - java -jar target/order-manager-0.0.1-SNAPSHOT.jar



## Versões

| Versão  |   Descrição |
| ------------| ---------|
|  1.0.0  |  API - Item Manager     |
|  1.1.0  |  API - User Manager     |Cria um item  |





 **Contato**
* leonardobarrosbhz@gmail.com
