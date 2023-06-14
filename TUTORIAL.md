# 1. Introdução: Java Faker

#### Muitas vezes, nossos testes unitários precisam apenas de um conjunto de caracteres ou números para passarem. Porém, às vezes não estamos nos sentindo muito criativos e acabamos utilizando a velha sequência “12345” e o famoso “José”. O Java Faker é uma biblioteca que gera dados falsos, ela é uma versão da gem stympy/faker do Ruby (bem como da biblioteca Data:: Faker do Perl). É útil quando você está desenvolvendo um novo projeto e precisa de alguns dados bonitos para mostrar.

#### Essa biblioteca gera diversos falsificadores: 

- Endereço
- Aplicativo
- Cerveja
- Livro
- Bool
- Negócios
- ChuckNorris
- Código
- Cor
- Comércio
- Empresa
- Data e hora
- Educador
- Finança
- Hacker
- Número de identidade
- Internet
- Lorem
- Número
- Opções
- Número de telefone
- Shakespeare
- Super heroi
- Equipe
- Universidade

# 2. Instalação & Configuração:

## Etapa 1: Iniciar um projeto utilizando o IntelliJ

 ####  a) Ao abrir o IntelliJ, clique em “New Project” para começar.

  #### b) Na próxima janela você terá que preencher algumas informações: 

1. Name: Nome do seu projeto.
2. Location: Diretório onde ficará o seu projeto.
3. Language: Linguagem que será utilizada para o desenvolvimento.
4. Build system: Escolha a opção “Maven”.
5. JDK: Especifique o SDK do projeto (JDK) ou use o padrão.
6. Advanced Settings → GroupId: um pacote de um novo projeto; →  ArtifactId: um nome de seu projeto.

  #### c) Clique em “create”.

   
## Etapa 2: Adicionando dependências

#### O IntelliJ cria um projeto Maven com o arquivo pom.xml, nele será declarada todas as dependências necessárias para utilização da biblioteca Java Faker.

#### a) Em pom.xml, adicione a seguinte estrofe xml entre `<dependencies> … </dependencies>`

```
<dependency>
       <groupId>com.github.javafaker</groupId>
       <artifactId>javafaker</artifactId>
       <version>1.0.2</version>
</dependency>
```

#### b) Clique em “Load Maven Changes”.

#### Para usuários Gradle, adicione o seguinte ao seu arquivo build.gradle.

```
dependencies {
   implementation 'com.github.javafaker:javafaker:1.0.2'
}
```


# 3. Gettind Started: Em seu código Java.
      
```
 //Importação da biblioteca
import com.github.javafaker.Faker; 
```

#### Se você precisa preencher um endereço, pode utilizar o “address”. Em sua versão localizada, você pode gerar nomes em seu indioma de preferência:

```
public static void addressFaker() {
    Faker faker = new Faker(new Locale("pt-BR"));
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String streetName = faker.address().streetName();
    System.out.println("Nome: " + firstName);
    System.out.println("Sobrenome: " + lastName);
    System.out.println("Logradouro: " + streetName);
}
```

#### Se você for fã de alguma série, livro, etc., pode ser que exista um faker específico, como no caso do Harry Potter Faker:

```
public static void harryPotterFaker() {
    Faker faker = new Faker();
    String character = faker.harryPotter().character();
    String book = faker.harryPotter().book();
    System.out.println("Personagem: " + character);
    System.out.println("Livro: " + book);
}
```

#### Aqui estão dois exemplos de uso da biblioteca Java Faker, a partir disso você pode ser criativo em seu projeto, utilizando diversos falsificadores.


# 4. Ferramentas similares:


#### a) A FakeDataGen é uma ferramenta desenvolvida em Python que gera de forma aleatória dados falsos, contendo nomes, e-mails, data de nascimento, telefone, cidade, cartão de crédito, entre outros., para que você possa utilizá-los em seus testes.

https://github.com/JoelGMSec/FakeDataGen

#### b) Com o Mockaroo, é possível gerar rapidamente dados de teste realistas, personalizando os campos, o número de dados gerados e o formato desejado do documento final.

#### A ferramenta é disponibilizada online através do link https://mockaroo.com

#### c) O jFairy é uma ótima biblioteca geradora de dados falsos construída em Java que é muito fácil de usar. Essa biblioteca permite que você crie conjuntos de dados contendo diversos tipos de dados, incluindo nomes, endereços, números de telefone, datas, números inteiros grandes, nomes de usuários, endereços de e-mail e muito mais.

https://github.com/Devskiller/jfairy 