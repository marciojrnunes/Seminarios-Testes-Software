<h1 align="center"> Mockup de dados </br> Por Pedro H. N. Oliveira & Davih G. Duque </h1>
  <h1 align="center"> <img alt="JavaFaker" src="JavaFaker.png" /> </h1>

<p align="center">
  <a href="#Introdução">Introdução</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#Instalação & Configuração">Instalação & Configuração</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#Getting Started">Getting Started</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#Ferramentas Similares">Ferramentas Similares</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#Referências">Referências</a>
</p>


# 1. Introdução:
* O que é Mockup na programação? 

Antes de iniciarmos a apresentação sobre a ferramenta que selecionamos, devemos explicar sobre o Mockup, que é essencial para o nosso contexto.

Mock no dicionário americano significa “algo feito como uma imitação.” Partindo disso, o Mockup é usado principalmente em testes unitários. Quando um objeto em teste depende de outros objetos (complexos), você pode substituir esses objetos por simulações para isolar o comportamento do objeto que deseja testar. Isso é especialmente útil se os objetos reais forem difíceis de incluir no teste unitário. Em resumo, um Mockup cria objetos que imitam o comportamento de objetos reais.

* Java Faker

Vindo dessa perspectiva, nasce o Java Faker, que é uma biblioteca robusta e flexível usada para criar dados fictícios. É especialmente útil para programadores que estão enfrentando problemas para popular bancos de dados, testar interfaces de usuário e validar funcionalidades. O Java Faker trabalha criando esses dados falsos, de forma simples e rápida, atendendo a essas necessidades. Ele fornece um extenso conjunto de opções para personalizar os dados gerados, permitindo que você personalize a saída para suas necessidades específicas.


# 2. Instalação & Configuração:
* Depois de iniciado um projeto, podemos fazer a referência de dependência para o JavaFaker.

Com o Gradle como responsável pelos pacotes, podemos referencia-lo no arquivo "Build.gradle", assim:
  
```javascript
    compile group: 'com.github.javafaker', name: 'javafaker', version: '0.15'
```
E então, devemos executar o seguinte comando no terminal para atualizar o projeto:
```javascript
    gradle build
```


Com o Maven como responsável pelos pacotes, podemos referencia-lo no arquivo "pom.xml", assim:
```xml
    <dependency>
      <groupId>com.github.javafaker</groupId>
      <artifactId>javafaker</artifactId>
      <version>0.15</version>
    </dependency>
```
E então, devemos executar o seguinte comando no terminal para atualizar o projeto:
```javascript
    mvn clean install
```

Com tudo configurado, podemos começar a utilizar essa biblioteca.

# 3. Getting Started:
Para usar o Faker, podemos começar com coisas simples como, adicionar um nome, cidade e telefone, como é ilustrado no código abaixo:
```java
import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        // Cria uma instância do Faker configurada para o idioma português do Brasil
        Faker faker = new Faker(new Locale("pt-BR"));

        // Gera dados falsos
        String nome = faker.name().fullName();
        String cidade = faker.address().city();
        String telefone = faker.phoneNumber().phoneNumber();

        // Imprime os dados falsos
        System.out.println("Nome: " + nome);
        System.out.println("Cidade: " + cidade);
        System.out.println("Telefone: " + telefone);
    }
}
```
Agora partindo para um exemplo mais detalhado

Considerando que temos uma classe de Cliente, que segue a seguinte estrutura:
```java
public class Cliente {
    private int id;
    private String nome;
    private String sobrenome;
    private String endereco;
    private String email;
    private String telefone;

//  Getters & Setters
   public int getId() {
        return id;
   }

  public void setId(int id) {
        this.id = id;
  }

  public String getNome() {
        return nome;
  }

  public void setNome(String nome) {
        this.nome = nome;
  }
}
  ...
```

Podemos popular essa classe de forma simples, como é mostrado no código a seguir:

```java

//          Cria uma instância do Faker configurada para o idioma português do Brasil
            Faker faker = new Faker(new Locale("pt-BR"));

//          Criando um ID aleatório de 1 a 1000
            cliente.setId(faker.random().nextInt(1, 1000));

//          Criando nome e sobrenome
            cliente.setNome(faker.name().firstName());
            cliente.setSobrenome(faker.name().lastName());

//          Criando um email com base ao nome e sobrenome
            cliente.setEmail(cliente.getNome() + cliente.getSobrenome() + "@ufmg.br");

//          Definindo um padrão para o número de telefone
            cliente.setTelefone(faker.numerify("9####-####"));

//          Definindo os dados de endereço
            cliente.setEndereco(faker.address().fullAddress());
            cliente.setCep(faker.address().zipCode());
            cliente.setCidade(faker.address().city());
            cliente.setEstado(faker.address().state());
```

Como notamos, usar o mockup de dados nos oferece os seguintes benefícios:

* **Economia de Tempo:** Automatiza a criação de dados de teste, permitindo que os desenvolvedores se concentrem no comportamento do código.

* **Repetibilidade:** Facilita a criação de conjuntos de dados consistentes e repetíveis para testes automatizados.

* **Variedade de Dados:** O Faker pode gerar uma ampla gama de dados, incluindo endereços, números de telefone, datas, textos, e muito mais, em diversos idiomas.

Com isso, você pode focar no que realmente importa: 
O comportamento e a funcionalidade do seu software. Adicione o Faker ao seu projeto e comece a explorar todas as possibilidades que essa poderosa biblioteca oferece para gerar dados falsos e melhorar seus processos de desenvolvimento e teste.

# 4. Ferramentas Similares:
Aqui o que você pode trabalhar em cima:

Faker.js:
Similar ao Java Faker, o Faker.js é uma biblioteca para JavaScript que permite gerar dados falsos de maneira realista.
Assim como o Java Faker, o Faker.js é amplamente utilizado para criar conjuntos de dados fictícios em projetos JavaScript.
Oferece suporte para vários idiomas e tipos de dados, permitindo uma geração flexível e personalizável de dados falsos.

Mimesis.Python:
Para os usuários de Python, o Mimesis é a escolha equivalente ao Java Faker.
Assim como o Java Faker, o Mimesis é uma biblioteca Python que oferece uma API simples e intuitiva para gerar dados fictícios de alta qualidade.
É amplamente utilizado na comunidade Python para criar conjuntos de dados fictícios para testes e prototipagem, seguindo uma abordagem semelhante à do Java Faker.

Mockaroo:
Enquanto o Java Faker é uma biblioteca para Java, o Mockaroo é uma ferramenta online que oferece funcionalidades semelhantes, mas sem a necessidade de escrever código.
Assim como o Java Faker, o Mockaroo é amplamente utilizado para gerar grandes volumes de dados fictícios para testes e prototipagem.
Oferece uma ampla variedade de tipos de dados e formatos de saída, tornando-se uma opção conveniente para gerar dados fictícios rapidamente.

Links das ferramentas
* [**Faker.JS**](https://fakerjs.dev)
* [**Mimesis.PYTHON**](https://mimesis.name/en/master/)
* [**Mockaroo**](https://www.mockaroo.com)


# 5. Referências
* [**BAELDUNG.** A Guide to JavaFaker. Baeldung, 11 Maio. 2024.](https://www.baeldung.com/java-faker)
* [**DiUS.** Java-Faker. DiUS, 12 Jan. 2022.](https://github.com/DiUS/java-faker)
* [**MARTINS, Rodrigo.** Como Gerar Dados para Testes com Java Faker. Atitude Reflexiva, 01 Jul. 2022.](https://atitudereflexiva.wordpress.com/2022/07/01/como-gerar-dados-para-testes-com-java-faker/)
* [**FELTEX.** Como gerar massa de dados com Java Faker. YouTube, 14 Mar. 2023.](https://youtu.be/teVyz17rVX4)
* [**Stackoverflow.** O que é Mockup. Stackoverflow, 9 Out. de 2022.](https://stackoverflow.com/questions/2665812/what-is-mocking)
