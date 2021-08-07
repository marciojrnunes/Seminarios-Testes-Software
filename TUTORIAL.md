# Seminários: Teste de Software

## Mockup de dados ([Java Faker](https://dius.github.io/java-faker/))

 Esse é um tutorial para o uso do [JavaFaker](https://github.com/DiUS/java-faker), feito em Agosto de 2021.

##  - Introdução:

 Precisa de alguns dados fictícios para testar seu projeto? [JavaFaker](https://github.com/DiUS/java-faker) é um port do stympy / faker gem do Ruby (bem como da biblioteca Data :: Faker do Perl) que gera dados falsos. É útil quando você está desenvolvendo um novo projeto e precisa de alguns dados bonitos para demonstração. É também uma biblioteca que pode ser usada para gerar uma grande variedade de dados reais a partir de um número de celular, endereços, nomes e referências culturais populares. Isso é muito útil quando queremos usar algum espaço reservado, mas não temos dados reais. Como quando você deseja gerar dados de cartão de crédito e deseja fazer a validação contra eles. A biblioteca Faker o ajudará a gerar isso.

 Essa biblioteca fornece acesso a mais de 35 domínios diferentes e fornece dados para quase todos os casos de uso da vida real, como os domínios abaixo:

- Finança
- Comida
- Livros
- Nome
- Endereço
- O negócio
- ChuckNorris
- HarryPotter
- Senhor dos Anéis

Verifique toda a lista de domínios e localidades disponíveis que ele suporta:

https://github.com/DiUS/java-faker



##  - Instalação e  Configuração:

 **a)** Para projetos **Maven**, como no **No IntelliJ**:

 **Crie um novo projeto Maven﻿**

1. Se nenhum projeto estiver aberto no IntelliJ IDEA, clique em **Novo projeto** na tela de boas-vindas. Caso contrário, selecione **Arquivo | Novo | Projeto** do menu principal.

2. Selecione **Maven** nas opções à esquerda.

3. Especifique o SDK do projeto (JDK) ou use o padrão e um arquétipo se quiser usar um modelo de projeto predefinido (configure seu próprio arquétipo clicando em **Adicionar arquétipo**).

   Clique em **Avançar** .

4. Na próxima página do assistente, especifique as seguintes coordenadas Maven que são adicionadas ao arquivo pom.xml:

   - **GroupId** - um pacote de um novo projeto.
   - **ArtifactId** - um nome de seu projeto.
   - **Versão** - uma versão de um novo projeto. Por padrão, este campo é especificado automaticamente.

   Para obter mais informações sobre as coordenadas do Maven, consulte as [convenções de nomenclatura do Maven](https://maven.apache.org/guides/mini/guide-naming-conventions.html).

   Clique em **Avançar**.

5. Se você estiver criando um projeto usando um arquétipo do Maven, o IntelliJ IDEA exibe as configurações do [Maven](https://www.jetbrains.com/help/idea/new-projects-from-scratch-maven-settings-page.html) que você pode usar para definir o diretório inicial do Maven e os repositórios do Maven. Além disso, você pode verificar as propriedades do arquétipo.

   Clique em **Avançar** .

6. Especifique as configurações de nome e localização.

   Clique em **Concluir** .

   O IntelliJ IDEA cria um projeto Maven com o arquivo **pom.xml** que inclui o compilador e as versões de destino do Java, a janela da ferramenta Maven dedicada e todas as dependências necessárias para começar a trabalhar.

 Em pom.xml, adicione o seguinte entre `<dependencies> ... </dependencies>`.

```
<dependency>
    <groupId>com.github.javafaker</groupId>
    <artifactId>javafaker</artifactId>
    <version>1.0.2</version>
</dependency>
```

 Para finalizar, clique em **Load Maven Changes**.



 **b)** Para usuários do **Gradle**, como no **Android Studio**, adicione o seguinte ao seu arquivo **build.gradle**, no nível de app.

```
dependencies {
    implementation 'com.github.javafaker:javafaker:1.0.2'
}
```



##  - Getting Started:

 Em seu código Java

```
//Importe o Java Faker:
import com.github.javafaker.Faker;
```

```
//Em seu código:
Faker faker = new Faker();

String name = faker.name().fullName(); // Miss Samanta Schmidt
String firstName = faker.name().firstName(); // Emory
String lastName = faker.name().lastName(); // Barton

String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
```

 Pronto! Agora você pode criar qualquer atributo que quiser. Basta instanciar a classe Faker e chamar seus métodos para criar dados para seus atributos, que o Java Faker criará um dado falso para cada um desses atributos, como visto no exemplo acima. 



## - Ferramentas similares:

 **1 -** [jFairy](https://github.com/Devskiller/jfairy) é um projeto de gerador de dados falsos em Java. [jFairy](https://github.com/Devskiller/jfairy) permite que você crie conjuntos de dados contendo diversos tipos de dados, incluindo nomes, endereços, números de telefone, datas, números inteiros grandes, nomes de usuário, endereços de e-mail e muito mais.

https://github.com/Devskiller/jfairy

 **2 -** [DataFactory](http://www.andygibson.net/blog/article/generate-test-data-with-datafactory/) é um projeto que permite gerar dados de teste facilmente em projetos Maven. Ele foi escrito principalmente para preencher banco de dados para ambientes de desenvolvimento ou teste, fornecendo valores para nomes, endereços, endereços de e-mail, números de telefone, texto e datas.

http://www.andygibson.net/blog/article/generate-test-data-with-datafactory/

 **3 -** [mockaroo](https://www.mockaroo.com/) permite que você baixe de forma rápida e fácil grandes quantidades de dados de teste gerados aleatoriamente com base nas especificações que você definir.

 A coisa maravilhosa sobre esta plataforma é que **nenhuma programação é necessária** e você pode baixá-los em muitos formatos diferentes (por exemplo, SQL, XML, JSON, CSV) para serem carregados diretamente em seu ambiente de teste. Ao se inscrever, você também pode criar e salvar seus esquemas para reutilização futura.

 Com o Mockaroo, você pode [projetar suas próprias APIs simuladas](https://www.mockaroo.com/mock_apis) ou implantá-las em sua própria nuvem privada, aproveitando a [imagem docker](https://github.com/mockaroo/mockaroo-enterprise) do Mockaroo .

https://www.mockaroo.com/

