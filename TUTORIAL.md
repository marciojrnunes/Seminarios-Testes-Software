Introdução: 
Para evitar que possíveis erros e inconsistências nos sistemas de software cheguem aos seus usuários finais é de suma importância introduzir atividades de testes em projetos de desenvolvimento de software.
Anteriormente, as atividades de testes ocorriam em uma fase posterior ao momento de levantamento de requisitos, análise, projeto e codificação do software e contavam com uma equipe própria para a sua realização. Para aferir se a implementação correspondia aos requisitos, essa equipe especializada realizava os testes de forma manual, informando dados de entrada e verificando se as saídas eram as esperadas. 
Hoje a prática de teste de software foi completamente reformulada, deixando de ser uma atividade realizada por uma equipe própria e em um momento posterior à codificação para também ser realizada também pelos desenvolvedores e no momento da codificação.  Nesse modelo de testes os desenvolvedores implementam um código para tornar as classes do sistema auto testáveis, sendo que este código pode até mesmo preceder e direcionar a implementação.
Os testes atualmente são divididos em três grandes grupos: Testes de unidade que verificam individualmente as classes do software; testes de integração / testes de serviços que verificam uma determinada funcionalidade do sistema, abarcando um conjunto de classes e/ou o acesso a componentes externos como um banco de dados; testes de interface com o usuário / testes de sistema que tem por objetivo simular, com a maior fidelidade possível, o uso do sistema por um usuário real.

Testes de unidade: Mocks
Mocks são recursos utilizados em testes de unidade cuja função é “simular” objetos e/ou serviços visando restringir o escopo dos testes a uma determinada classe do sistema, isto é, isolando a classe testada das interferências de serviços e requisições externas.  Caso a classe implemente, por exemplo, algum serviço ou possua algum método que realize requisições a serviços, um mock pode ser criado com o objetivo de fornecer o resultado daquela requisição. 

Mockup de dados: Java Faker
Por vezes utilizamos uma série de dados fictícios para compor objetos na implementação de testes de softwares como, por exemplo, nomes e endereços para simular o cadastro de usuários.
O Java Faker é uma biblioteca Java utilizada para a criação de objetos mock que possui dados reais sobre as mais diversas temáticas.  Essa biblioteca pode fornecer dados localizados sobre diversos países como, por exemplo, nomes e siglas dos estados, nomes de cidades e bairros, profissões, placas de veículos, dentre outras temas.

Instalação / configuração:
Para utilizar o Java Faker com o Gradle é necessário incluir no build.gradle:
repositories {
    mavenCentral()
}

dependencies {
    implementation 'com.github.javafaker:javafaker:1.0.2'
}

Para utilizar o Java Faker com o Maven é necessário incluir no arquivo pom.xml
<dependency>
      <groupId>com.github.javafaker</groupId>
      <artifactId>javafaker</artifactId>
      <version>1.0.2</version>
  </dependency>

Getting Started: 
A utilização do Java Faker é muito simples. Inicialmente devemos importar a biblioteca: 
import com.github.javafaker.Faker

Depois devemos criar uma instância do Java Faker:
Faker f = new Faker();

Por padrão, a localização recuperada pela instância do Java Faker é a “en-US”. Para localizar os dados para pt-BR é só instanciar uma nova localidade e indicá-la como parâmetro ao instanciar o objeto Java Faker.
Faker f = new Faker(new Locale("pt-Br"))

Por fim, basta associar ao atributo desejado o método correspondente:
        String name = f.name().fullName(); //Fernanda Rebouças
        String job = f.job().title(); //Representante Saúde Regional
        String address = f.address().streetAddress(); //s/n Ponte Amanda
        String city = f.address().cityName(); //Coronel Barros
        String state = f.address().state(); //Distrito Federal
        String postCode = f.address().zipCode(); //52540-039

Ferramentas similares:
Faker.js: Essa biblioteca de dados é utilizada para gerar dados fictícios em browser e node.js. https://github.com/marak/Faker.js/
Fony: Ferramenta de linha de comando que gera dados no formato JSON a partir de um modelo fornecido. https://github.com/captainsafia/fony
Casual: Biblioteca de dados fictícios para javascript. https://github.com/boo1ean/casual
Fake Data: Extensão do Google Chrome que insere dados fictícios em qualquer campo de formulário. https://chrome.google.com/webstore/detail/fake-data-a-form-filler-y/gchcfdihakkhjgfmokemfeembfokkajj?hl=en
Random User: API que cria usuário aleatórios. Fornece um objeto JSON, XML, CSV ou YAML.  https://randomuser.me/
