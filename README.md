# Desafio_quality

# Descrição

Esse projeto implementa o backend de uma aplicação que permite o usuário calcular a metragem e o custo dos
diferentes imóveis que possui em sua carteira de clientes.

O objetivo deste projeto é utilizar a regra de negócio acima para exercitar os conceitos de Testes e Validações, portante
neste projeto foi Criado a seguitente API Rest: 

* US-0001: Calcular a área total de uma propriedade.
* US-0002: Indicar o preço dessa mesma propriedade com base na área total.
* US-0003: Determinar qual é o maior cômodo da propriedade.
* US-0004: Determinar a área de cada cômodo.

Cada Imóvel deve ter:
- um nome do imóvel,
- um bairro,
- e a lista de cômodos.

Um Bairro deve ter:
- nome do bairro,
- valor do metro quadrado no bairro

Cada cômodo deve ter:
- um nome,
- uma largura e
- um comprimento.

## Tecnologias utilizadas

* Maven
* Java 11
* Spring Boot
* Spring Web
* Spring Open Api
* Spring DevTools
* Spring Validation
* Lombok
* Junit



### Clone

```console
https://github.com/Bootcamp-Time7/desafio_quality.git```

## Requisições

### Postman
Coleção disponibilizada no postman.

https://www.getpostman.com/collections/6e4ae1ed6cb3e9191d22

### Swagger

Endereço : Swagger:  http://localhost:8080/swagger-ui/index.html

```
{"openapi":"3.0.1","info":{"title":"OpenAPI definition","version":"v0"},"servers":[{"url":"http://localhost:8080","description":"Generated server url"}],"paths":{"/Residence/registerResidence":{"post":{"tags":["residence-controller"],"operationId":"registerResidence","requestBody":{"content":{"application/json":{"schema":{"$ref":"#/components/schemas/Residence"}}},"required":true},"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"$ref":"#/components/schemas/Residence"}}}}}}},"/District/registerDistrict":{"post":{"tags":["district-controller"],"operationId":"registerDistrict","requestBody":{"content":{"application/json":{"schema":{"$ref":"#/components/schemas/District"}}},"required":true},"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"$ref":"#/components/schemas/District"}}}}}}},"/Residence/roomSquare/{residence}":{"get":{"tags":["residence-controller"],"operationId":"getSquareRoom","parameters":[{"name":"residence","in":"path","required":true,"schema":{"type":"string"}}],"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"array","items":{"$ref":"#/components/schemas/RoomDto"}}}}}}}},"/Residence/read":{"get":{"tags":["residence-controller"],"operationId":"readResidence","parameters":[{"name":"residenceName","in":"query","required":true,"schema":{"type":"string"}}],"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"$ref":"#/components/schemas/Residence"}}}}}}},"/Residence/getAll":{"get":{"tags":["residence-controller"],"operationId":"findAll","responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"array","items":{"$ref":"#/components/schemas/Residence"}}}}}}}},"/Residence/calculateBiggestCommode/{residenceName}":{"get":{"tags":["residence-controller"],"operationId":"calculateBiggestCommode","parameters":[{"name":"residenceName","in":"path","required":true,"schema":{"type":"string"}}],"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"$ref":"#/components/schemas/Room"}}}}}}},"/Residence/calcTotalPrice/{residenceName}":{"get":{"tags":["residence-controller"],"operationId":"totalPrice","parameters":[{"name":"residenceName","in":"path","required":true,"schema":{"type":"string"}}],"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"number","format":"double"}}}}}}},"/Residence/calcTotalArea/{residenceName}":{"get":{"tags":["residence-controller"],"operationId":"calculateTotalArea","parameters":[{"name":"residenceName","in":"path","required":true,"schema":{"type":"string"}}],"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"number","format":"double"}}}}}}},"/District/getAll":{"get":{"tags":["district-controller"],"operationId":"findAll_1","responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"array","items":{"$ref":"#/components/schemas/District"}}}}}}}}},"components":{"schemas":{"District":{"required":["name","valuePerSquare"],"type":"object","properties":{"name":{"maxLength":45,"minLength":0,"pattern":"([A-Z]{1}[a-z]+\\s??)+","type":"string"},"valuePerSquare":{"type":"number","format":"double"}}},"Residence":{"required":["listRooms","residenceDistrict","residenceName"],"type":"object","properties":{"residenceName":{"maxLength":30,"minLength":0,"pattern":"([A-Z]{1}[a-z]+\\s??)+","type":"string"},"residenceDistrict":{"$ref":"#/components/schemas/District"},"listRooms":{"type":"array","items":{"$ref":"#/components/schemas/Room"}},"districtName":{"type":"string"}}},"Room":{"required":["roomLength","roomName","roomWidth"],"type":"object","properties":{"roomName":{"maxLength":30,"minLength":0,"pattern":"([A-Z]{1}[a-z]+\\s??)+","type":"string"},"roomWidth":{"maximum":25,"exclusiveMaximum":false,"type":"number","format":"double"},"roomLength":{"maximum":33,"exclusiveMaximum":false,"type":"number","format":"double"}}},"RoomDto":{"type":"object","properties":{"nameRoomDto":{"type":"string"},"square":{"type":"number","format":"double"}}}}}}

```
