# Behaviour Driven Development (BDD)

Behaviour Driven Development (BDD) é uma técnica de desenvolvimento ágil que foi originada do Test Driven Development (TDD).

O TDD se baseia na ideia de ciclo de repetições, no qual o desenvolvedor escreve o teste que representa uma nova funcionalidade e, após isso, implementa um código que passará pelo teste e depois será refatorado.

O BDD segue a mesma linha, porém o foco é no comportamento do produto, ou seja, o que o sistema deve fazer.

![Using BDD/TDD in OutSystems](https://www.outsystems.com/blog/-/media/images/blog/posts/using-bdd-tdd/using-bdd-tdd-01.png?h=465&w=750&updated=20210608141021)
# Vantagens
A linguagem de negócios do BDD é extraída das histórias ou especificações fornecidas pelo cliente na fase de levantamento de requisitos. Ao aplicar essa técnica é possível obter as seguintes vantagens:

 - uma melhora na comunicação entre as equipes de desenvolvimento e de testes, além de compartilhamento de conhecimento entre os times
- ocorre a documentação dinâmica através dos frameworks de BDD
- a equipe de desenvolvimento tem uma visão geral do objetivo do projeto antes de implementá-lo

Consequentemente, o resultado obtido é um código com boa qualidade, alta coesão e reduzido número de erros, o que proporciona maior vida útil e menor manutenção no futuro.

# Cucumber 

O [Cucumber](https://cucumber.io/) é uma ferramenta de software que suporta BDD usada para descrever como o software deve se comportar. Essa escrita é feita em texto simples, definindo as especificações através de exemplos. A estrutura que o Cucumber usa é o formato **Given/When/Then**, proveniente da linguagem **Gherkin**, que foi criada especificamente para descrição de comportamentos. O formato é descrito da seguinte maneira:
- **Given:** descreve as pré-condições e o estado antes do início de um teste
- **When:** descreve as ações executadas por um usuário durante um teste
- **Then:** descreve o resultado das ações realizadas no "When"
![](https://lh4.googleusercontent.com/_JFOe-o30XlVd8GINVz8XFXtYmJ9F1A4c3lRYp93YsBjdEZgLnAZpQNTl4oUxxp98yeCvV1mo8aZIUW8_snku-_KYhAc7oAqwJOhaENAFNqUNxcU9uOAkuGiPDBoB85isbCGOaNE)
O Cucumber verifica se o software está em conformidade com a especificação e gera um relatório indicando o sucesso ou a falha. Ao executar cada etapa do Gherkin, é buscado as definições da etapa, responsável por conectar o Gherkin ao código de programação. 
Abaixo o exemplo em Java e Kotlin, respectivamente. 

```java
package com.example;
import io.cucumber.java.en.Given;

public class StepDefinitions {
    @Given("I have {int} cukes in my belly")
    public void i_have_n_cukes_in_my_belly(int cukes) {
        System.out.format("Cukes: %n\n", cukes);
    }
}
```
```kotlin
package com.example
import io.cucumber.java8.En

class StepDefinitions : En {

    init {
        Given("I have {int} cukes in my belly") { cukes: Int ->
                prinln("Cukes: $cukes")
        }
    }

}
```
## Instalação & Configuração: 

O Cucumber está disponível para a maioria das linguagens de programação convencionais, sendo recomendado escolher uma implementação para a mesma plataforma ou linguagem de programação do código de produção. Existem quatro categorias que definem as linguagens:
- oficial: as implementações são hospedadas em Cucumber
- semi-oficial: as implementações são hospedadas em outro lugar, mas usam componentes Cucumber
- não oficial: as implementações são hospedadas em outro lugar e não usam componentes Cucumber
- sem manutenção: as implementações são oficiais, mas não mantidas e precisam de novos mantenedores 

No caso da linguagem Java, é usado o [Cucumber-JVM](https://github.com/cucumber/cucumber-jvm), sendo que este é categorizado como oficial. 

### Instalação
O primeiro passo para iniciar a instalação é adicionar as dependências no projeto. É preciso ter certeza de que a versão do Cucumber é a mesma para todas as outras dependências Cucumber.

#### Maven
Caso o projeto esteja usando Java 8 para escrever as definições de etapa, as seguintes dependências devem ser adicionadas ao arquivo `pom.xml` 
```xml
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java8</artifactId>
    <version>6.10.4</version>
    <scope>test</scope>
</dependency>
```
Caso contrário, basta adicionar as dependências abaixo ao arquivo `pom.xml`: 
```xml
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>6.10.4</version>
    <scope>test</scope>
</dependency>
```
Por fim, o Cucumber já pode ser executado no terminal de comando ou executar Cucumber com Maven. 
#### Gradle
Para versões **4.10.3 ou anteriores** do Gradle e **Java 8** para escrever as definições de etapa,as seguintes dependências devem ser adicionadas ao arquivo `build.gradle`:
```
dependencies {
    testCompile 'io.cucumber:cucumber-java8:6.10.4'
    testCompile 'io.cucumber:cucumber-junit:6.10.4'
}

repositories {
    mavenCentral()
}

```
Caso contrário, também para para versões **4.10.3 ou anteriores** do Gradle, basta adicionar as dependências abaixo ao arquivo `build.gradle`: 
```
dependencies {
    testCompile 'io.cucumber:cucumber-java:6.10.4'
    testCompile 'io.cucumber:cucumber-junit:6.10.4'
}

repositories {
    mavenCentral()
}
```
Por fim, para versões **5.0 ou mais recentes** do Gradel e **Java 8** para escrever as definições de etapa, as seguintes dependências devem ser adicionadas ao arquivo `build.gradle`:
```
dependencies {
    testImplementation 'io.cucumber:cucumber-java8:6.10.4'
    testImplementation 'io.cucumber:cucumber-junit:6.10.4'
}

repositories {
    mavenCentral()
}
```
Caso contrário, também para para versões **5.0 ou mais recentes** do Gradle, basta adicionar as dependências abaixo ao arquivo `build.gradle`: 
```
dependencies {
    testImplementation 'io.cucumber:cucumber-java:6.10.4'
    testImplementation 'io.cucumber:cucumber-junit:6.10.4'
}

repositories {
    mavenCentral()
}
```
Por fim, o Cucumber já pode ser executado no terminal de comando ou adicionando um Cucumber task ao `build.gradle`.
 
## Getting Started

No desenvolvimento de aplicações Java, a forma como vamos utilizar o Cucumber depende de com qual gerenciador de dependências estamos trabalhando. A seguir, trazemos um exemplo de uso para cada um dos gerenciadores mais usados: Maven e Gradle. 

### Maven
Inicialmente, temos que criar um diretório de projeto com o plugin Maven cucumber.archetype. Para isso, no terminal, navegamos até a pasta onde desejamos iniciar o projeto e executamos o seguinte comando: 
 
```
mvn archetype:generate                                      \
“-DarchetypeGroupId=io.cucumber”                            \
“-DarchetypeArtifactId=cucumber-archetype”                  \
“-DarchetypeVersion=6.10.4”                                 \
“-DgroupId=hellocucumber”                                   \
“-DartifactId=hellocucumber”                                \
“-Dpackage=hellocucumber”                                   \
“-Dversion=1.0.0-SNAPSHOT”                                  \
“-DinteractiveMode=false”                                   \

```

Como resultado, devemos obter a seguinte saída no terminal: 

```
[INFO] Project created from Archetype in dir: <directory where you created the project>/cucumber
[INFO]  ---------------------------------------------------------------------------------------------
[INFO]  BUILD SUCCESS
[INFO]  ---------------------------------------------------------------------------------------------

```

Para acessar o diretório criado com o comando acima, é preciso executar o seguinte comando (ainda no terminal):

```
cd hellocucumber

```

Por fim, abrimos o projeto no IntelliJ IDEA: 

```
Arquivo -> Abrir… -> (Selecione o pom.xml)
Selecione Abrir como Projeto

```

Para verificar se tudo ocorreu como o esperado, execute: 

```
mvn test
```

A saída deverá ser a seguinte: 

```
-------------------------------------------------------
 TESTS
-------------------------------------------------------
Running hellocucumber.RunCucumberTest
No features found at [classpath:hellocucumber]
0 Scenarios
0 Steps
0m0.004s
Tests run: 0, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.541 sec
Results :
Tests run: 0, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] 
------------------------------------------------------------
```

### Gradle
Uma forma de criar o projeto Cucumber no Gradle é transformar o modelo Maven criado com os comandos demonstrados acima. No diretório hellocucumber, que acessamos via terminal, devemos executar o seguinte comando: 

```
gradle init
```

Após isso, adicionamos, no build.gradle, as seguintes configurações de dependência: 

```
configurations {
	cucumberRuntime {
		extendsFrom testImplementation
	}
}

```

Ainda no arquivo build.gradle, adicionamos a seguinte task: 

```
task cucumber( ) {
    dependsOn assemble, testClasses
        doLast {
            javaexec {
                main = “io.cucumber.core.cli.Main”
                classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
                args = [‘--plugin’, ‘pretty’, ‘--glue’, ‘hellocucumber’, ‘src/test/resources’] 
			}
		}
	}
```

Para testar se tudo foi feito corretamente, execute:

```
gradle cucumber
```

A saída deve ser como a seguinte: 

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running hellocucumber.RunCucumberTest
No features found at [classpath:hellocucumber]
0 Scenarios
0 Steps
0m0.004s
Tests run: 0, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.541 sec
Results :
Tests run: 0, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] 
------------------------------------------------------------

```

Agora é possível testar os cenários utilizando os seguintes códigos, como já foi demonstrado na introdução: 

```
Feature: Is it Friday yet?
  Everybody wants to know when it's Friday
  
  Scenario: Sunday isn't Friday
    Given today is Sunday
    When I ask whether it's Friday yet
    Then I should be told "Nope"

```

Na primeira linha, vemos que a palavra-chave Feature é seguida de um nome que, de preferência, deve ser o mesmo nome do arquivo. Na segunda linha, temos uma descrição dessa feature: “todos querem saber quando é sexta-feira”. Temos na terceira linha uma definição do cenário de teste. Por fim, as linhas seguintes descrevem os passos do cenário e é isso que o Cucumber irá testar. 

## Ferramentas Similares

Vimos neste breve tutorial a ferramenta Cucumber aplicada ao Java para o desenvolvimento de testes baseado em BDD. Contudo, há pelo menos mais três ferramentas com a mesma finalidade que podem ser utilizadas com a linguagem Java. 

### JBehave
Framework para desenvolvimento orientado a testes de comportamento, tem como plataforma de aplicação de testes o BDD. Podemos utilizar esse framework integrado ao IntelliJ IDEA, JUnit, Apache Ant, Eclipse e Maven. Para mais informações,[clique aqui](https://jbehave.org/).

### JBehave Web
Esse framework, também utilizado para desenvolvimento orientado a testes, tem como base o BDD aplicado à funcionalidades relacionadas ao desenvolvimento Web. Sendo uma extensão do JBehave Core, o JBehave Web oferece uma interface simples e que depende de poucos conhecimentos técnicos para a aplicação de BDD, sendo que os testes podem ser aplicados de forma síncrona ou assíncrona. Para mais informações,[clique aqui](https://jbehave.org/reference/web/stable/).

### Concordion
O Concordion é um framework que permite a aplicação de BDD de duas formas principais: 1) invocando códigos diretamente das aplicações para realizar os testes; 2) direcionando as interfaces implantadas do aplicativo. Para utilizar esse framework em aplicações Web é necessário ter uma camada de driver, como o Selenium Web Driver. Já para bancos de dados, demanda a utilização do JDBC. Para mais informações,[clique aqui](https://concordion.org/coding/java/html/).
