# Karkara
🚀Sistema de compra e reserva de passagens aéreas, integrado com meio de pagamento.
🚧 🚀 Em construção... 🚧

🛠 Ferramentas utilizadas

- [Java 8](https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR)
- [SpringBoot](https://spring.io/)
- [Amadeus Java SDK](https://developers.amadeus.com/self-service/category/air?s_kwcid=AL!10969!3!452455070593!b!!g!!%2Bamadeus%20%2Bair%20%2Bapi)
- [Pagar.me Java SDK](https://docs.pagar.me/reference)
- [Heroku](https://www.heroku.com/)

Equipe:

- [Aleff Diniz](https://github.com/aleffTrajano) 🚀
- [João Wanderley](https://github.com/joaowanderley) 🚀
- [Wendell Edgard](https://github.com/wendelledgard) 🚀

Organizamos daily scrumm todos os dias para alinharmos o nosso desenvolvimento, porém definimos por optar a documentação em sprints de 1 semana.

## Semana 1 🚀
Ao receber o nosso desafio dedicamos a primeira semana a pesquisar e dividir igualmente as tecnologias e tecnicas que aplicariamos. Tudo começou bem até que recebemos o contato da Accenture para fazer a retirada de nossos computadores. Tendo em vista que todos os integrantes da equipe são de estados vizinhos a Pernambuco, tivemos que nos locomover para para fazer a retirada, logo então perdemos um bom tempo de horas de projeto. Em seguida, focamos o nosso feriadão para construção da api, alinhar as ideias e unificar todo conteúdo produzido como também recuperar as aulas que perdemos da Accademia Gama rs.

## Semana 2 🚀
Pensavamos que a primeira semana teria sido difícil por conta da viagem a Pernambuco, porém logo que se iniciou a segunda semana estavamos totalmente inseridos no Onboarding da Accenture, onde obtivemos diversos tipos de treinamento, com isso tinhamos o dia todo para absorver conteudos passado no Onboarding e curso da gama na parte da noite. Realmente, foi uma semana de muito esforço, poucas horas dormidas (afinal, programadores né? rs) e muito código a ser produzido. Graças ao nosso instrutor da accademia, tivemos um suporte muito grande na construção de nossa API.

Tivemos um certo problema para organizar nossos commits e seguir com um deploy limpo, então decidimos criar esse repositório deixando o último como legado apenas afim de consultas: https://github.com/AleffTrajano/karkara

## Considerações finais
Foram as duas semanas mais insanas de nossas vidas, obtivemos longas horas de aprendizados, desafios que ainda não tinhamos passados e uma grande lição foi aprendida, que nós mesmos somos o nosso maior desafio e juntos temos a força de alcançar nossos objetivos.

Desde já expressamos a nossa profunda gratidão a cada palavra, cada ajuda e a oportunidade de vivermos esse momento, sabemos que é apenas o começo de uma caminhada de acertos e erros e juntos vamos todos fazer a diferença.

## Agradecimentos especias
- Primeiramente a Accenture por ver em nós a capacidade de se mostrar solicita com essa oportunidade. 🙏
- A Gama por nos ter proporcionado grandes momentos de aprendizado. 🙏
- Aos professores Marcos(<i>Melhor que isso, só bem feito</i>) e Gleyson(<i>ihuuuu</i>) por nos guiarem nessa jornada, compartilhando vossas experiências e mostrando todo o potencial que podemos alcançar. E por fim e não menos importante, a Kai que a todo momento estava cuidando de nós, com todo feedback e sempre se mostrando solicita a nós. 🙏

## Instruções

Fizemos o deploy da aplicação no heroku, estamos utilizando o Swagger para gerar nossa documentação listando todos os endpoints e guiar para o consumo da mesma.passagens-api
API - Para Gerenciamento de Passagens Aereas
Ao iniciar a aplicação pela classe PassagensApiApplication sera realizada a criação das tabelas de dominio e a inclusão de 2 perfis de acesso ADIM e USER, além da inclusão do Usuário MASTER (admin:admin).

Voce pode validar a autenticação do usuaário MASTER atraves da documentação: {HOST}:{PORTA}/swagger-ui.html
POST: http://{HOST}:{PORTA}/login { "senha": "admin", "usuario": "admin" }
Response:
{ "login": "admin", "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInNjb3BlcyI6IlJPTEVfQURNSU4iLCJpYXQiOjE2MDQ3MDI4MjEsImV4cCI6MTYwNDcwNjQyMX0.cAY_X-VnqogmYFDZ3E2v4YKC_1qhGT7R8gAWQAQE1gc", "userId": 1 }

Se preferir está disponível a inclusão dos viajantes (clientes) ou consulta dos voos pela API
VOSS
POST: http://{HOST}:{PORTA}/flights { "originLocationCode" : "NYC", "destinationLocationCode" : "PAR", "departureDate" : "2020-12-01" , "returnDate" : "2020-12-06", "adults" : "1", "max":"2" }
Response:
"data": [ { "response": null, "deSerializationClass": null, "type": "flight-offer", "id": "1", "source": "GDS", "instantTicketingRequired": false, "nonHomogeneous": false, "oneWay": false, "lastTicketingDate": "2020-11-06", "numberOfBookableSeats": 3, "itineraries": [
  ...
]
Para prosseguir na iteração da API é necessário realizar o cadastro do viajante:
POST: http://{HOST}:{PORTA}/viajantes
"cpfCnpj": "1234", "dataNascimento": "1990-10-10", "documento": { "numeroDocumento": "123123", "tipoDocumento": "PASSPORT" }, "email": "viajante@gmail.com", "login": "test", "senha": "test", "nome": "VIAJANTE TEST", "sexo": "M", "telefone": { "ddd": 11, "nomeContato": "teste", "numero": 89980998 }


Agora é o momento de realizar a geração da reserva (order)
POST: http://{HOST}:{PORTA}/flights/order/{viajante} - Onde o viajante é o id do cadastro
Para exemplo utilizar o arquivo createOrder.txt como body da requisição
Response: "data": { "type": "flight-order", "id": "eJzTd9f39QlxtTAGAAs9AkM%3D", "associatedRecords": [ ... ]

Além da resposta é armezado dados relevantes em nossa base de dados como id, preco e data da reserva.
A partir agora para consultar as reservas é necessário realizar o login como ADMIN ou Viajante acessando a url de login para obter o token
GET: http://{HOST}:{PORTA}/reservas
Parametros: inicio: 2020-11-01 00:00:00 fim: 2020-11-30 23:59:59 viajanteId: 3
{ "viajante": { "id": 3, "nome": "VIAJANTE TEST", "cpfCnpj": "1234", "email": "viajante1@gmail.com", "telefone": { "ddd": 11, "numero": 89980998, "nomeContato": "teste" }, "documento": { "numeroDocumento": "123123", "tipoDocumento": "PASSPORT" }, "dataNascimento": "1990-10-10", "sexo": "M" }, "reservas": [ { "id": 1, "orderId": "eJzTd9f39QlxtTAGAAs9AkM%3D", "price": 100, "viajanteId": 3, "dataHora": "2020-11-06T20:12:41", "status": "PP" } ] }

As reservas por padrão estarão como PP (Pendentes de pagamentos), para integrar a Reserva com uma API de pagamentos (Pagarme), é necessário realizar a chamada conforme abaixo:
GET: http://{HOST}:{PORTA}/reservas/pagamento
Parametros: orderId: {orderId}
Response: { "viajante": { .... }, "reservas": [ { "id": 1, "orderId": "QlxtTAGAAs9AkM%3D", "price": 100, "viajanteId": 3, "dataHora": "2020-11-06T21:12:41", "status": "PG", "idPagamento": 10287154 } ] }
NOTA: Se houve a confirmação do pagamento o status da reserva estará como PG (Pago) e o id do pagamento de api de pagamentos.


https://apikarkara.herokuapp.com/swagger-ui.html

