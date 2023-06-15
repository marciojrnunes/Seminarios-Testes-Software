**Hamcrest**

Hamcrest é um framework utilizado para escrever asserções de testes unitários em Java. Seu principal objetivo é facilitar a legibilidade dos testes, fornecendo classes **'matchers'** que podem ser utilizadas para verificar se um valor atende a um critério específico.

O Hamcrest fornece uma grande variedade de matchers já pré-definidos que podem ser utilizados para verificar coisas como igualdade, comparação, existência de elementos em uma coleção, correspondência de padrões, etc.

Além dos matchers pré-definidos, o Hamcrest também permite a criação de matchers personalizados. Sendo assim, os desenvolvedores podem definir seus próprios matchers para atender às necessidades específicas dos seus testes.


**Utilização**

Para usar o Hamcrest em um projeto Java, é preciso adicionar a dependência no sistema de gerenciamento de dependências, como Maven ou Gradle.

```
dependencies {

testImplementation 'org.junit.jupiter:junit-jupiter-api:5.6.0'
testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine'
testImplementation 'org.hamcrest:hamcrest:2.2'

}
```


Em seguida, os matchers podem ser importados e utilizados nos testes, juntamente com as bibliotecas de teste padrão, como JUnit ou TestNG.


```
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
```


Suponhamos que você faça um método que devolve uma lista ordenada de números. Usando somente o JUnit, seria assim:

```
@Test
public void testListaOrdenada() {

        List<Integer> lista = new ArrayList<>();
        
        lista.add(5);

        lista.add(3);

        lista.add(2);

        lista.add(7);

        List<Integer> listaOrdenada = new Ordenador().ordena(lista);

        assertEquals(4, listaOrdenada.size());
        assertEquals(2, listaOrdenada.get(0));
        assertEquals(3, listaOrdenada.get(1));
        assertEquals(5, listaOrdenada.get(2));
        assertEquals(7, listaOrdenada.get(3));
        
  }
}
```

Mensagem de erro quando colocamos um número na ordem errada:

```
expected: <3> but was: <4>

Expected :3

Actual :4

org.opentest4j.AssertionFailedError: expected: <3> but was: <4>
```

Teríamos que utilizar muitos asserts e a mensagem de erro não seria muito clara.

Com o mesmo método, porém utilizando o Hamcrest, ao invés de utilizar o assertEquals, podemos utilizar o método **assertThat** do JUnit.

Este método recebe dois argumentos: o resultado do teste e um **Matcher** (um objeto do Hamcrest que faz várias verificações, inclusive para listas).

Neste caso, para verificar se a lista devolvida possui os elementos que adicionamos, podemos utilizar o método **contains**, que verifica se a lista possui exatamente os elementos que passarmos como argumentos ao método. O código ficaria assim:


```
@Test
public void testListaOrdenada() {

        List<Integer> lista = new ArrayList<>();
        
        lista.add(5);

        lista.add(3);

        lista.add(2);

        lista.add(7);

        List<Integer> listaOrdenada = new Ordenador().ordena(lista);
        assertThat(listaOrdenada, Matchers.contains(2, 3, 5, 7));

	}
}
```

Utilizando o Hamcrest, as mensagens de erro são mais detalhadas e precisas.

```
java.lang.AssertionError:

Expected: iterable containing [<3>, <2>, <5>, <7>]

but: item 0: was <2>
```

**Matchers**

Lista dos principais matchers que a biblioteca de Hamcrest possui:

**Core**

- **anything** - sempre corresponde, é útil quando você não se importa com o objeto sendo testado
- **describedAs** - decorador para adicionar uma descrição personalizada de falha
- **is** - decorador para melhorar a legibilidade

**Exemplo:**


```
@Test
public void testIs() {

    String str1 = "teste";
    String str2 = "teste";

    assertThat(str1, is(str2));

}
```

**Logical**

- **allOf** - corresponde se todos os correspondentes correspondem, (como o "&&" em Java)
- **anyOf** - corresponde se algum correspondente corresponder, (como o "||" em Java)
- **not** - corresponde se o correspondente envolvido não corresponder e vice-versa

**Exemplo:**

```
@Test
public void testAllOf() {

    String texto = "Hello, World";

    assertThat(texto, allOf(

    startsWith("Hello"), // Verifica se a string começa com "Hello"

    endsWith("World") // Verifica se a string termina com "World"
    ));

}
```

**Object**

- **equalTo** - testa a igualdade de objetos usando Object.equals
- **hasToString** - testa o Object.toString
- **instanceOf, isCompatibleType** - testa o tipo
- **notNullValue, nullValue** - testa se é nulo
- **sameInstance** - testa a identidade do objeto

**Exemplo**:

```
@Test
public void testEqualTo() {

    Pessoa pessoa1 = new Pessoa("Maria", "BH");
    Pessoa pessoa2 = new Pessoa("Maria", "BH");

    assertThat(pessoa1, equalTo(pessoa2));

}
```

**Exemplo 2:**

```
@Test
public void testNotNull() {

    String str = "notnull";
    assertThat(str, notNullValue());

}
```

**Beans**

- **hasProperty** - testa as propriedades de JavaBeans

**Exemplo:**
```
public class Pessoa{

    String nome;
    String endereco;

public Pessoa(String nome, String endereco) { 

    this.nome = nome;
    this.endereco = endereco; 

  } 
}
```

```
@Test
public void exemploBean() {

    Pessoa pessoa = new Pessoa("Maria","BH");
    assertThat(pessoa, hasProperty("nome")); 

}
```

**Collections**

- **array** - testa os elementos de um array em relação a um array de correspondentes
- **hasEntry, hasKey, hasValue** - testa se um mapa contém uma entrada, chave ou valor
- **hasItem, hasItems** - testa se uma coleção contém elementos
- **hasItemInArray** - testa se um array contém um elemento

**Exemplo:**

```
@Test
public void testHasItem() {

    String[] frutas = { "laranja", "uva", "melancia", "banana" };
    assertThat(frutas, hasItemInArray("melancia"));

}
```

**Number**

- **closeTo** - testa se os valores float estão próximos a um determinado valor
- **greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo** - testa a ordenação

**Exemplo:**

```
@Test
public void testGreaterThan() {

    assertThat(10, greaterThan(5));

}
```

**Exemplo 2:**

```
@Test
public void testLessThanOrEqualTo() {

    assertThat(-1, lessThanOrEqualTo(5));

}
```

**Text**

- **equalToIgnoringCase** - testa a igualdade de strings ignorando maiúsculas e minúsculas
- **equalToIgnoringWhiteSpace** - testa a igualdade de strings ignorando diferenças em sequências de espaços em branco
- **containsString, endsWith, startsWith** - testa correspondência de strings

**Exemplo:**

```
@Test
public void TestIgnoringWhiteSpace() {

    String str1 = "text";
    String str2 = " text ";

    assertThat(str1, equalToIgnoringWhiteSpace(str2));

}
```

**Matchers Personalizados**

Como dito anteriormente, através do Hamcrest também é possível escrever matchers personalizados, trazendo assim uma versatilidade e impedindo duplicações de código.

Um exemplo que pode se fazer necessário um Matcher personalizado, é um matcher que verifica se um valor Double tem a propriedade NaN (Not a Number).

Aqui escrevemos o matcher que queremos criar:


```
@Test
public void testIsNotANumber() {

    assertThat(Math.sqrt(-1), is(notANumber())); 
}

```

E aqui está a sua implementação:


```
package org.hamcrest.examples.tutorial;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsNotANumber extends TypeSafeMatcher {

@Override

public boolean matchesSafely(Double number) {

    return number.isNaN();

}

public void describeTo(Description description) {

    description.appendText("not a number");

}

public static Matcher notANumber() {

    return new IsNotANumber();

  }
}
```


E após sua declaração e implementação, basta importar o método de forma estática:

```
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.examples.tutorial.IsNotANumber.notANumber;
```

```
public class NumberTest {

@Test
public void testSquareRootOfMinusOneIsNotANumber() {

    assertThat(Math.sqrt(-1), is(notANumber()));
  }
}

```


E aqui um exemplo da saída do matcher implementado em caso de falha:

```
//Mensagem de falha

java.lang.AssertionError: Expected: is not a number got : <1.0>
```


**Ferramentas semelhantes** 

Outras ferramentas semelhantes ao Hamcrest são:

**JUnit** - Framework presente nas versões mais recentes de IDEs como Eclipse, NetBeans e IntelliJ. Ele oferece integração nativa com o Hamcrest para escrever asserções em testes, melhorando sua legibilidade. Também vem com uma API completa e para construir e facilitar nos testes e aplicações gráficas.

**JMock -** O JMock é uma biblioteca que auxilia o Test Driven Development através dos mock objects. É uma biblioteca que vai criar implementações “falsas” específicas para o seu teste, de uma maneira rápida e simples, sem ter que se preocupar com os métodos que não vamos usar no teste, sem ao menos ficar criando classes "à toa". Com o JMock podemos definir o comportamento necessário do objeto de mentira, para criarmos a situação pedida pelo teste.

**AssertJ -** AssertJ é uma biblioteca opensource de asserções fluentes para Java. Ela oferece suporte ao Hamcrest e estende seus recursos para fornecer uma sintaxe mais fluente e expressiva, facilitando a leitura e a manutenção dos testes.


**Referências**

https://www.alura.com.br/artigos/melhorando-a-legibilidade-dos-seus-testes-com-o-hamcrest  

https://www.vogella.com/tutorials/Hamcrest/article.html

https://hamcrest.org/JavaHamcrest/tutorial

https://www.baeldung.com/java-junit-hamcrest-guide

http://jmock.org/

https://junit.org/junit5/

https://www.baeldung.com/introduction-to-assertj
