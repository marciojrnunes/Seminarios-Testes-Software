<h1 align="center"> Mockup de dados (Java Faker) </h1>
  <h1 align="center"> <img alt="JavaFaker" src="JavaFaker.png" /> </h1>

<p align="center">
  <a href="#Introdução">Introdução</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#Instalação & Configuração">Instalação & Configuração</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#Getting Started">Getting Started</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#Ferramentas Similares">Ferramentas Similares</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#Referências">Referências</a>
</p>


# 1. Introdução:
Essa seção deverá introduzir os conceitos do assunto que seu grupo irá abordar. Você deverá mostrar o problema e como a ferramenta se propõe a resolver esse problema.

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
Liste pelo menos três ferramentas que também lidam com o tópico selecionado. Se não encontrar algo similar em Java procure em outras linguagens (PHP, C#, JavaScript, etc.). Fale resumidamente cada uma dessas bibliotecas e referencie para sua página principal.

# 5. Referências
* **BAELDUNG.** A Guide to JavaFaker. Baeldung, 11 Maio. 2024. Disponível em: [Link](https://www.baeldung.com/java-faker)
* **MARTINS, Rodrigo.** Como Gerar Dados para Testes com Java Faker. Atitude Reflexiva, 01 Jul. 2022. Disponível em: [Link](https://atitudereflexiva.wordpress.com/2022/07/01/como-gerar-dados-para-testes-com-java-faker/)
* **FELTEX.** Como gerar massa de dados com Java Faker. YouTube, 14 Mar. 2023. Disponível em: [Link](https://youtu.be/teVyz17rVX4)
