# interviewVivo
Esse projeto se trata de uma entrevista, no intervalo de 05/09 - 08/09 foi desenvolvido 3 projetos Java spring boot para 3 exercícios testes.

Esse projeto é referente a seguinte questão:

2. Transforme o algoritmo anterior em uma API Rest. Você receberá como
parâmetro uma lista com os valores de An e deverá retornar a saída do
algoritmo no formato JSON.

Para sua utilização, clone e importe o repositório, então execute os seguintes comandos:

mvn clean package
mvn clean install -DskipTests 

A porta utilizada foi a padrão 8080, então as url de acesso a api e o swagger estarão disponíveis na 8080.
Esse projeto conta com a documentação openAPI para o swagger, então recomendo a sua utilização para testar os endpoints.

Ao clicar na InterviewApplication com o botão direito e selecionar run, o código está pronto e poderá verificar no endereço:
http://localhost:8080/swagger-ui/index.html?

![image](https://user-images.githubusercontent.com/29410618/189125229-e10b465d-acea-4516-b6ff-baa38a2a6909.png)

Ao adicionar os parâmetros e executar o endpoint /imageBitmap/getOccurrences/{elements} deverá retornar os elementos com suas ocorrências correspondidas, 
e gerando uma imagem bitmap genérica de tamanho 5x5 para sua execução.
exemplo:

 ![image](https://user-images.githubusercontent.com/29410618/189125734-bcaa60ec-2780-46fb-b6a0-4abb8aa4cfa4.png)

Caso aja alguma não conformidade com os padrões, receberá a responsta com o problema relacionado.

Testes unitários de cenário ruim referentes as validaçoes foram desenvolvidos e podem ser encontrados no pacote test
![image](https://user-images.githubusercontent.com/29410618/189126260-762e0ffd-6fcf-4d22-8b61-097cfa8a85a9.png)

Os demais projetos se encontram nos:
https://github.com/rafapiazza/interviewVivo1/tree/master
https://github.com/rafapiazza/interviewVivo3/tree/master
