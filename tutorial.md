
# **Introdução**

O tópico abordado será o Behavior Driven Development(BDD),
ele é uma prática de desenvolvimento ágil que tem coo objetivo uma maior colaboração entre os desenvolvedores,
testers e stakeholders. A metodologia BDD aborda o Test Driven Development(TDD) ao escrever testes em uma linguagem natural
que descreve o comportamento do software. O Cucumber é uma ferramenta para BDD em Java, ele permite que os requisitos sejam descritos em Gherkin,
uma linguagem de domínio específico que segue a sintaxe de Given-When-Then.

Given(Dado): Descreve o estado inicial do sistema.

When(Quando): Descreve a ação ou evento que esta sendo testado.

Then(Então): Descreve o resultado esperado após a ação ou evento.

Exemplo: Feature: Adição na calculadora.

- Given: Eu tenho uma calculadora
- When: Eu quero somar 2 com 3
- Then: O resultado é 5


O problema que o Cucumber resolve é exatamente a comunicação entre os envolvidos no desenvolvimento do software.
Muitas vezes, a comunicação é mal interpretada ou até esquecida, resultando em um software que não atende às expectativas que foram colocadas.
O Cucumber ajuda a mitigar esse problema ao criar uima base comum de entendimento através de cenários de teste legíveis.


## **Instalação e Configuração**

### **Pré-requisitos**

- Java
- Gradle
- IDE (IntelliJ IDEA, Netbeans, Eclipse, etc)


### **Passos para instalação**

Para o arquivo "pom.xml", adicione as seguintes dependências:

```xml
<dependencies>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.2.3</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>7.2.3</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

Agora no arquivo do gradle 'build.gradle', adicione o seguinte:
```groovy
dependencies {
    testImplementation 'io.cucumber: cucumber-java:7.2.3'
    testImplementation 'io.cucumber: cucumber-junit:7.2.3'
    testImplementation 'junit:junit:4.13.2'
}
```
## **Getting Started**
### **Passos para criar um teste BDD com Cucumber**

**1. Criar um diretório para os arquivos de feature**

No diretório `src/test/resources`, crie um diretório/pasta chamado 'features'

**2. Escrever um arquivo de feature.**

Crie um arquivo chamado `example.feature` dentro do diretório `features` com o seguinte conteúdo:

```gherkin
Feature: Example feature

    Cenario: Somar dois númerops
    Given Eu tenho uma calculadora
    When Eu somo 2 e 3
    Then O resulto deveria ser 5=
```

**3. Criar uma classe de testes Cucumber**
No diretório `src/test/java`, cire uma classe chamada `RunCucumberTest.java`

```java
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features")
public class RunCucumberTest {
}
```

**4. Implementar os passos do teste**
Crie um pacote `stepdefinitions` no diretório `src/test/java` e adicione a classe `CalculatorSteps.java`:

```Java
package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class CalculatorSteps {
    private int total;

    @Given("Eu tenho uma calculadora")
    public void tenho_calculadora() {
        total = 0;
    }

    @When("Eu somo 2 e 3")
    public void soma(int num1, int num2) {
        total = num1 + num2;
    }

    @Then("O resulto deveria ser 5")
    public void resultado(int result) {
        assertEquals(result, total);
    }
}
```

**5. Executar os testes**

Execute a classe `RunCucumberTest` para rodar os cenários definidos no arquvio de feature.
O Cucumber irá executar os passos definidos e verificar se são os resultados esperados.

### **Ferramentas similiares**

*1. SpecFlow(C#)*

- **Descrição**: SpecFlow é uma ferramenta BDD para  a plataforma.NET que utiliza a linguagem Gherkin para definir os testes.
- Página: https://specflow.org

*2. Behat(PHP)*

- **Descrição**:  Behat é uma ferramenta BDD para PHP que permite definir testes em Gherkin e executá-los para validar o comportamento do software.
- Página: https://docs.behat.org/en/latest/

*3. Jasmine(JavaScript)*

- **Descrição**:  Jasmine é um framework de testes comportamentais para JavaScript que permite escrever testes claros e descritivos para código JavaScript.
- Pagina: https://jasmine.github.io

## **Conclusão**
O Cucumber facilita a prática de BDD ao permitir que os requisitos sejam escritos em uma linguagem natural e transformados em testes automatizados.
Isso promove uma melhor comunicação entre as partes interessadas e ajuda a garantir que o software atenda às expectativas.
Além disso, com a crescente popularidade do BDD, muitas outras ferramentas estão disponíveis em diferentes linguagens de programação, cada uma ajudando a implementar os princípios do BDD de forma eficaz.

![Cucumber Logo](https://cdn.icon-icons.com/icons2/2415/PNG/512/cucumber_plain_wordmark_logo_icon_146572.png)