# Seminários: Testes de Software: Hamcrest

**Vicente do Carmo Sá e Silva**

## Introdução
Hamcrest é um framework utilizado para averiguar a asserção de testes de software de forma declarativa, focando principalmente na legibilidade de códigos, com o intuito de tornar a leitura e o entendimento do código mais claros e intuitivos. A maior legibilidade dos códigos é alcançada por meio de "_matchers_", que são objetos fornecidos pela própria biblioteca e que são responsáveis por fazer os testes necessários. 
    
Com Hamcrest, é possível realizar diversos testes, como por exemplo: 
- Igualdade (equalTo, equalToIgnoringCase)
- Comparação (greaterThan, lessThan, lessThanOrEqualTo)
- Lógica (allOf(operador AND/&&), anyOf(operador OR/||))
- Testes dentro de Collections (hasEntry, hasKey, hasValue)

Além dos matchers fornecidos, a biblioteca permite a criação de novos matchers para realizar testes específicos para cada aplicação.

Como visto nos exemplos acima, o principal foco do Hamcrest é tornar o código o mais legível possível, e o matchers fornecidos seguem exatamente o mesmo padrão de frases ditas/escritas fora do meio computacional, tornando o código compreensível até mesmo para não-programadores.
    
O tutorial a seguir terá foco em Java, mas a ferramenta pode ser utilizada em diversas outras linguagens como C++, C#, Python, PHP e JavaScript.

## Instalação e Configuração

O primeiro passo para utilizar o Hamcrest em seu projeto é baixar o arquivo .jar disponibilizado diretamente no MavenCentral (https://search.maven.org/artifact/org.hamcrest/hamcrest).
Caso o projeto possua algum sistema de automação de builds, o processo é mais simples ainda.

Num projeto que utiliza Gradle, basta acessar o arquivo build.gradle e declarar a seguinte dependência:

    dependencies {
        testImplementation 'org.hamcrest:hamcrest:2.2'
    }

Já num projeto Maven, basta acessar o arquivo pom.xml e inserir o seguinte texto na seção de dependências:

    <dependency>
        <groupId>org.hamcrest</groupId>
        <artifactId>hamcrest</artifactId>
            <version>2.2</version>
        <scope>test</scope>
    </dependency>

Após isso, você está pronto para utilizar o Hamcrest no seu projeto!

## Getting Started: 

Nos exemplos de testes a seguir, utilizaremos a seguinte classe:

    public class Cachorro {
        private String nome;
        private int idade;

        public Cachorro(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

            public int getIdade() {
                return idade;
            }

            public String getNome() {
                return nome;
            }
        }

Para testar se os dados estão sendo salvos de maneira correta, além de realizar algumas comparações, criaremos a classe CachorroTest com os seguintes imports:
    
    import org.junit.jupiter.api.Test;
    import java.util.ArrayList;
    import java.util.List;
    import static org.hamcrest.MatcherAssert.assertThat;
    import static org.hamcrest.Matchers.*;

    public class CachorroTest {

    }

Lembrando que o Hamcrest pode ser utilizado em conjunto com diversas outras ferramentas de testes, como o próprio JUnit.

Em seguida, iremos testar se todos os objetos foram inseridos corretamente numa Collection de Cachorros:

    @Test
    public void testMyDogs() {
        List<Cachorro> cachorrosDoVicente = new ArrayList<>();

        Cachorro A = new Cachorro("Bartholomeu", 16);
        Cachorro B = new Cachorro("Kika", 19);
        Cachorro C = new Cachorro("Luna", 1);

        cachorrosDoVicente.add(A);
        cachorrosDoVicente.add(B);
        cachorrosDoVicente.add(C);

        assertThat(cachorrosDoVicente, contains(C, B, A));
    }

Ao executar o teste acima, podemos perceber uma característica muito interessante do Hamcrest: A facilidade de leitura das mensagens de erro.
O método 'contains' verifica se a lista possui exatamente aqueles elementos naquela ordem. Como eles foram inseridos fora de ordem, recebemos a seguinte mensagem de erro:

    Expected: iterable containing [<Cachorro@2235eaab>, <Cachorro@17503f6b>, <Cachorro@3bcd05cb>]
    but: item 0: was <Cachorro@3bcd05cb>

Além de receber uma StackTrace comum, também recebemos uma explicação exata sobre o erro: O que era esperado e o que foi recebido. No exemplo acima, o comparador esperava receber o objeto "A" na primeira posição da lista, mas ele recebeu "C". Para resolver o problema, basta organizar a lista da maneira correta (contains(A,B,C)), ou utilizar o método containsInAnyOrder.

No segundo teste, iremos testar algumas informações sobre nosso amigos peludos:

    @Test
    public void testInfo() {
        Cachorro Bartholomeu = new Cachorro("Bartholomeu", 16);
        Cachorro Kika = new Cachorro("Kika", 19);

        assertThat("Idade do Bartholomeu", Bartholomeu.getIdade(), equalTo(16));
        assertThat("Nome da Kika", Kika.getNome(), equalTo("Kika"));
        assertThat("Bartholomeu é mais velho que a mãe?", Bartholomeu.getIdade(), greaterThan(Kika.getIdade()));
    }

Nesses exemplos, podemos ver uma outra funcionalidade bastante útil para aumentar a legibilidade dos testes. O primeiro argumento de cada verificação preenche o campo de "motivo", que é exatamente utilizado para explicitar o motivo pelo qual o teste está sendo realizado. No caso do código acima, as duas primeiras verificações passam o teste sem nenhum problema, enquanto na terceira recebemos a seguinte mensagem: 

    java.lang.AssertionError: Bartholomeu é mais velho que a mãe?
    Expected: a value greater than <19>
    but: <16> was less than <19>

Assim como era esperado, é impossível um cachorro ser mais velho do que a própria mãe!

E como podemos ver, a string de "motivo" do teste aparece na mensagem de erro, facilitando ainda mais o entendimento do motivo pelo qual o teste falhou.

Esses são apenas alguns casos no qual o Hamcrest pode facilitar a leitura e o processo de depuração de códigos. Além do que foi demonstrado, também é possível realizar uma série de outros testes padronizados e uma infinidade de outros testes customizados. Para saber mais sobre o que é possível fazer com a biblioteca, a documentação pode ser encontrada em ([Hamcrest.org](https://hamcrest.org/JavaHamcrest/index))

## Ferramentas Similares:

JUnit: É uma das ferramentas de testes unitários mais populares em Java, presente de forma nativa em diversas IDEs como o JetBrains IntelliJ IDEA e o NetBeans. Como dito anteriormente, o Hamcrest possui integração nativa com o JUnit.

Truth: Ferramenta de asserção da Google. Diferente do Hamcrest, as asserções no Truth são feitas por meio de chamadas de método encadeadas, diferente do Hamcrest que utiliza matchers. Em Android essa é a ferramenta de asserção nativa.

AssertJ: Biblioteca também focada em asserções claras e de fácil legibilidade, fortemente focada no tipo dos objetos que estão sendo verificados.

## Referências:

[Hamcrest.org](https://hamcrest.org/JavaHamcrest/index)

[AssertJ](https://github.com/assertj/assertj)

[JUnit](https://junit.org/junit5/)

[Truth vs. AssertJ and Hamcrest](https://truth.dev/comparison.html)

[Alura - Melhorando a legibilidade dos seus testes com o Hamcrest](https://www.alura.com.br/artigos/melhorando-a-legibilidade-dos-seus-testes-com-o-hamcrest)
