# Tutorial de Mockup de classes usando a ferramenta Mockito

## Introdução

Um software é uma estrutura complexa, e, por isso, está sujeito aos mais variados tipos de inconsistências. Para evitar tais problemas, existem os testes de unidade, que, hoje em dia, são automatizados e possuem ferramentas para sua realização.

Uma das características fundamentais de um bom teste de unidade é ser isolado. Porém, muitas classes dependem de informações ou métodos de outras classes, ou dependem de serviços remotos, em bancos de dados, na web, em outros softwares, ou mesmo depende de um dispositivo, como um sensor.

Para realizar um teste nesse tipo de situação, seria necessário implementar todo um cenário para o teste, podendo ultrapassar até mesmo o código do método a ser testado.

São nesses casos que surgem os mocks, objetos que emulam um objeto real de maneira mais simples para permitir testes.

### O que é mockup de classes?

Mockup significa modelo ou maquete. O mockup de classes são a criação de  uma classe que imita as características de outra classe.

Fazendo isso, é possível testar uma pequena parte do software sem ter que usar suas dependências. As classes mock cuidam de fazer o trabalho delas.

Para fazer esse tipo de teste, existem diversas ferramentas disponíveis. Uma delas é o Mockito.

### O que é Mockito?

O [Mockito](https://site.mockito.org/) é um framework usado para simular essa instância de uma classe, de maneira simples e limpa, e possui uma boa [documentação](https://www.javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html).

Para usá-lo, existem algumas restrições:

* É necessário uso da versão 1.6 ou superior do Java.
* Não é possível criar mocks de classes final.
* Não é possível fazer mocks de métodos estáticos.
* Não é possível fazer mocks de métodos privados.

#
## Instalação & Configuração

A maneira recomendada de instalar o Mockito é adicioná-lo como uma dependência do projeto (mockito-core), mas também é possível adicioná-lo manualmente, basta baixar os arquivos .jar no [Maven Central](https://repo1.maven.org/maven2/org/mockito/mockito-core/).

Exemplo: adicianando ao Gradle:

```
repositories { 
    mavenCentral()
}
```
```
dependencies { 
    testImplementation 'org.mockito:mockito-core:+'
}
```

Para Android, são duas dependências, além do repositório do Maven Central. Eles vão no build.gradle do módulo: 

```
 dependencies {
   testImplementation 'org.mockito:mockito-core:+'
   androidTestImplementation 'org.mockito:mockito-android:+'
 }
```

Você pode substituir o "+" pela versão mais recente, IDEs como o IntelliJ e Android Studio podem te ajudar com isso.

Lembre-se que testes não são realizados na mesma classe do software. Você pode usar a IDE para ajudar a criar diretório e arquivos de teste, ou criá-los manualmente. No IntelliJ e Android Studio, basta abrir a classe ou método que você quer testar e pressionar Ctrl+Shift+T, e no menu exibido, clicar em Create New Test.

#
## Getting Started

Após a instalação, basta importar o Mockito na sua classe de testes e começar a usar. O import pode ser static, para simplificar o código.

`import static org.mockito.Mockito.*;`

O Mockito possui diversas opções de teste, porém focaremos no mock de classes, usando um exemplo.

### Exemplo prático

Imagine que você possua um software que gerencia uma carteira de ações. O preço de uma ação muda várias vezes, então esse gerenciador se comunica com uma API para conseguir o preço atual de cada ação, para assim saber o valor da carteira.

Para simplificar, imagine que o software possui a seguinte estrutura:

Uma classe `Acao`, com id, nome identificador e quantidade de ações de determinada empresa;

Uma classe `Carteira`, com uma lista de ações e uma instância do serviço de preços de ações;

Uma interface (representativa) que consegue os preços das ações;

```
public class Acao {
    private String acaoId;
    private String nome;
    private int quantidade;

    public Acao(String acaoId, String nome, int quantidade){
        this.acaoId = acaoId;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getAcaoId() { return acaoId; }

    public void setAcaoId(String acaoId) {
        this.acaoId = acaoId;
    }

    public int getQuantidade() { return quantidade; }

    public String getNome() {
        return nome;
    }
}

public class Portifolio {
    private AcaoService acaoService;
    private List<Acao> acoes;

    public AcaoService getAcaoService() {
        return acaoService;
    }

    public void setAcaoService(AcaoService acaoService) {
        this.acaoService = acaoService;
    }

    public List<Acao> getAcoes() {
        return acoes;
    }

    public void setAcoes(List<Acao> acoes) {
        this.acoes = acoes;
    }

    public double getValorCarteira(){
        double valorCarteira = 0.0;

        for(Acao acao : acoes){
            valorCarteira += acaoService.getPreco(acao) * acao.getQuantidade();
        }
        return valorCarteira;
    }
}

public interface AcaoService {
    public double getPreco(Acao acao);
}
```
Como testar a classe `Carteira`, que depende de dados externos?

Começamos criando uma classe de testes e chamando o Mockito como static.

O primeiro setup consiste em criar um objeto mock para o serviço de preços de ações, usando o `mock()`, e usá-lo em uma carteira:

classeMock = mock(ClasseMock.class);

```
import static org.mockito.Mockito.*;
class CarteiraTest {

  public void setUp(){
        // Criar um objeto mock do serviço de preços de ações
        acaoService = mock(AcaoService.class);

        // Criar um objeto carteira para ser testado
        Carteira testCarteira = new Carteira();

        // Setar o mock no objeto de teste
        testCarteira.setAcaoService(acaoService);
    }
}
```

Após isso, podemos criar o teste do método `getValorCarteira()`. Para isso, usamos o `when().thenReturn()`. 

Esse método de nome literal retorna o que foi informado quando algo for executado. Nesse exemplo, quando solicitarmos a API o preço da uma ação qualquer, ele retornará o valor informado.

```
public boolean testValorCarteira(){

        // Criar uma lista de ações para a carteira teste
        List<Acao> acoes = new ArrayList<Acao>();
        Acao acaoGoogle = new Acao("1e49", "Google", 10);
        Acao acaoApple = new Acao("22ff", "Apple", 100);

        acoes.add(acaoGoogle);
        acoes.add(acaoApple);

        carteira.setAcoes(acoes);

        //Fazer o mock do serviço de preços de ações para retornar os valores especificados
        when(acaoService.getPreco(acaoGoogle)).thenReturn(50.00);
        when(acaoService.getPreco(acaoApple)).thenReturn(1000.00);

        //Testa se funcionou
        double valorCarteira = carteira.getValorCarteira();
        return valorCarteira == 100500.0;
    }
```

Foi usado uma função do tipo boolean para retornar a asserção para executar o teste, se verdadeiro imprimir "Funcionou", senão "Falhou":

```
public static void main(){
        // Instância do teste
        CarteiraTest test = new CarteiraTest();
        // Preparo do teste
        test.setUp();
        // Realização do teste
        System.out.println(test.testValorCarteira() ? "Funcionou" : "Falhou");
    }
```
#

## Ferramentas similares

* [EasyMock](https://easymock.org/) - Java
* [JMock](http://jmock.org/) - Java
* [Roboeletric](http://robolectric.org/) - Java (Android)
* [Jest](https://jestjs.io/pt-BR/) - Javascript
* [Sinon.js](https://sinonjs.org/) - Javascript
* [Mockery](http://docs.mockery.io/en/latest/) - PHP
* [Cucumber](https://cucumber.io/) - Java, Javascript, Ruby

  
#

### Princípios de Desenvolvimento de Software - COLTEC

#### Seminários de Teste de Software
##### Autores: Mateus Damasceno e Jefferson Abreu
##### Professor: João Eduardo Montandon