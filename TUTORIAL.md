# Mockup de classes - Mockito 

## Introdução:
No desenvolvimento de software, garantir a qualidade do código é crucial. Para isso, os desenvolvedores utilizam testes automatizados que verificam se as funcionalidades implementadas funcionam corretamente. Uma das técnicas mais importantes nesse processo é o teste unitário, que avalia pequenas unidades de código de forma isolada.

Um dos desafios nos testes unitários é a necessidade de isolar a unidade de código em teste (geralmente uma função ou método) das suas dependências externas. Essas dependências podem ser outras classes, serviços externos, bancos de dados, entre outros. Quando um método depende de outra classe, testar esse método diretamente pode ser problemático por várias razões de complexidade e tempo de execução e imprevisibilidade.

Para resolver esses problemas, os desenvolvedores utilizam mocks, que são objetos simulados que imitam o comportamento das dependências reais. Aqui entra o Mockito.

Mockito é um framework popular para a criação de mocks em testes unitários na linguagem Java. Ele permite que os desenvolvedores criem objetos simulados e definam o comportamento esperado desses objetos durante o teste. Isso facilita o isolamento da unidade de código em teste, garantindo que o foco esteja exclusivamente na funcionalidade sendo verificada.

Como Mockito Resolve o Problema:
- Isolamento de Dependências: Mockito permite simular dependências externas, fornecendo um comportamento controlado e previsível. Isso garante que os testes unitários avaliem apenas o código em teste, sem interferências externas.

- Controle sobre o Comportamento dos Mocks: Com Mockito, os desenvolvedores podem definir explicitamente como os mocks devem se comportar em diferentes situações. Por exemplo, é possível especificar que um método simulado deve retornar um valor específico ou lançar uma exceção quando chamado.

- Facilidade de Uso: Mockito é projetado para ser fácil de usar, com uma API intuitiva que permite criar e configurar mocks com poucas linhas de código. Isso acelera o processo de escrita de testes e reduz a complexidade envolvida.

- Integração com Ferramentas de Teste: Mockito se integra bem com outras ferramentas de teste, como JUnit, facilitando a inclusão de mocks nos testes existentes e melhorando a eficiência do processo de desenvolvimento de testes.

## Instalação & Configuração:
Para começar a usar o Mockito em seus projetos Java, você precisará configurar as dependências necessárias no seu ambiente de desenvolvimento. A seguir, descrevemos os passos para instalar e configurar o Mockito utilizando duas das ferramentas de build mais comuns: Maven e Gradle.

1. **Configuração com Maven**  
Se você estiver usando Maven como ferramenta de build, precisará adicionar a dependência do Mockito no arquivo pom.xml do seu projeto. Siga os seguintes passos:

- Abra o arquivo pom.xml do seu projeto.
- Adicione a dependência do Mockito dentro da seção <dependencies>.

<dependencies>
    <!-- Outras dependências -->

    <!-- Dependência do Mockito -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>5.3.1</version> <!-- Verifique sempre a última versão disponível -->
        <scope>test</scope>
    </dependency>
</dependencies>

- Atualize o projeto Maven para baixar e incluir a dependência.


2. **Configuração com Gradle**  
Se você estiver usando Gradle como ferramenta de build, precisará adicionar a dependência do Mockito no arquivo build.gradle do seu projeto. Siga os seguintes passos:

- Abra o arquivo build.gradle do seu projeto.
- Adicione a dependência do Mockito dentro da seção <dependencies>.

<dependencies>
    <!-- Outras dependências -->

    <!-- Dependência do Mockito -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>5.3.1</version> <!-- Verifique sempre a última versão disponível -->
        <scope>test</scope>
    </dependency>
</dependencies>

- Atualize o projeto Maven para baixar e incluir a dependência.

## Getting Started:
Nesta seção, vamos elaborar um pequeno tutorial de uso exemplificando como o Mockito pode ser utilizado no desenvolvimento de uma aplicação Java. Vamos demonstrar um cenário simples de uma aplicação de pedido de compras.

**Passo 1:** Criar as Classes de Serviço  
Crie duas classes de serviço: `OrderService` e `PaymentService`. `OrderService` depende de `PaymentService` para processar pagamentos.

```java
// Classe que representa o serviço de pagamento
public class PaymentService {
    public boolean processPayment(double amount) {
        // Lógica de processamento de pagamento
        return true;
    }
}


// Classe que representa um pedido
public class Order {
    private double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

// Classe que representa o serviço de pedido, que depende do serviço de pagamento
public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean processOrder(Order order) {
        return paymentService.processPayment(order.getAmount());
    }
}
```

**Passo 2:** Criar o Teste com Mockito  
Crie uma classe de teste para `OrderService` e use Mockito para simular `PaymentService`.

```java
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    public void testProcessOrder() {
        // Cria um mock de PaymentService
        PaymentService mockPaymentService = mock(PaymentService.class);

        // Define o comportamento do mock
        when(mockPaymentService.processPayment(anyDouble())).thenReturn(true);

        // Cria uma instância de OrderService com o mock de PaymentService
        OrderService orderService = new OrderService(mockPaymentService);
        Order order = new Order(100.0);

        // Executa o método processOrder
        boolean result = orderService.processOrder(order);

        // Verifica se o resultado é o esperado
        assertTrue(result);

        // Verifica se o método processPayment foi chamado uma vez com o valor correto
        verify(mockPaymentService, times(1)).processPayment(100.0);
    }
}
```
**Passo 3:** Executar o Teste
Aqui estão os comandos para executar testes com Maven e Gradle:

- Maven:  
`mvn test`

- Gradle:  
`gradle test
`
## Ferramentas similares:
Existem várias outras ferramentas que lidam com mockup de classes em diferentes linguagens de programação. Abaixo, três alternativas populares:

- **JMockit**: é um framework de testes para Java que suporta mocking, stubbing e verificações de comportamento.   
Página Principal: https://jmockit.github.io/

- **EasyMock**: é outro framework de mocking para Java. Ele permite criar mocks facilmente para interfaces e definir comportamentos esperados para os métodos chamados nos mocks.   
Página Principal: https://easymock.org/

- **Sinon.js**: é uma biblioteca de teste para JavaScript que permite criar mocks, stubs e spies para testar código JavaScript, especialmente útil em ambientes de teste de front-end e Node.js.   
Página Principal: https://sinonjs.org/

