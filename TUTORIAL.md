# Seminários: Explicando DBUnit
*Alunas: Karen & Maíra*

## Introdução

O tópico abordado para esse seminário será a ferramenta DBUnit. Ela é uma extensão do JUnit utilizada para automatizar testes de integração com bancos de dados, o que contribui amplamente para garantir a qualidade no desenvolvimento de aplicativos e a confiabilidade do seu banco de dados.

O teste dos bancos de dados, com seus diversos INSTERTs e DELETEs ao longo do caminho, de forma manual, pode ser muito demorado e, em muitos casos, inviável. Com o DBUnit é possível evitar esse problema, pois possui métodos que irão realizar de forma automatizada a comparação dos registros, facilitando a verificação do estado do banco.

Além da comparação de registros, o DBUnit traz outras facilidades, elas são:
* Limpeza de registros após testes.
* Retorno de estado pós-teste.
* Popular o banco antes do teste.

Esse framework possui três conceitos principais:

***DataBaseConnection***: uma interface que vai representar uma conexão com o banco de dados através de JDBC.

***DataSet***: interface que faz a representação em arquivo XML de um conjunto de dados separados logicamente por tabelas.

***DataBaseOperator***: classe abstrata que representa as operações realizadas no banco de dados antes e depois de cada teste. (Carrega, limpa e verifica conjunto de dados no banco)

## Instalação e Configuração

### Pré-requisitos
* Java Development Kit (JDK) instalado  
* Maven (Gerenciador de dependências e ferramenta de construção para projetos Java) instalado
* Banco de Dados instalado e configurado no seu ambiente (O DBUnit suporta diversos bancos de dados populares, como MySQL, PostgreSQL, Oracle e SQL Server)
* IDE Java (como IntelliJ IDEA ou Eclipse)

### Instalação

Para começar, crie um novo projeto Maven e adicione as seguintes dependências necessárias no arquivo `pom.xml`:

```xml
    <dependencies>
        <!-- JUnit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>

        <!-- DBUnit -->
        <dependency>
            <groupId>org.dbunit</groupId>
            <artifactId>dbunit</artifactId>
            <version>2.7.0</version>
            <scope>test</scope>
        </dependency>

        <!-- H2 Database -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>1.4.200</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

Por fim, crie um arquivo XML `dataset.xml` para inserir e validar dados no banco de dados durante os testes:
- Exemplo de `dataset.xml`:

```xml
    <dataset>
        <table name="usuarios">
            <column>id</column>
            <column>nome</column>
            <column>email</column>
            <row>
                <value>1</value>
                <value>Karen Giullia</value>
                <value>a2023954317@teiacoltec.org</value>
            </row>
            <row>
                <value>2</value>
                <value>Maira Amaral</value>
                <value>a2022953562@teiacoltec.org</value>
            </row>
        </table>
    </dataset>
```

## Getting Started

Para entender melhor como utilizar o DBUnit iremos criar um exemplo.

1. Crie uma classe utilitária para configurar a conexão com o banco de dados de teste.

```java
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class ConexaoBancoDados {
        public static Connection getConexao() throws SQLException {
            return DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        }
    }

```

2. Crie uma classe de teste para realizar os testes de integração usando JUnit e DBUnit

```java
    import org.dbunit.IDatabaseTester;
    import org.dbunit.JdbcDatabaseTester;
    import org.dbunit.dataset.IDataSet;
    import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
    import org.dbunit.operation.DatabaseOperation;
    import org.junit.Before;
    import org.junit.Test;

    import java.io.FileInputStream;

    import static org.junit.Assert.assertEquals;

    public class UsuarioDaoTest {

        private IDatabaseTester databaseTester;

        @Before
        public void setUp() throws Exception {
            databaseTester = new JdbcDatabaseTester("org.h2.Driver", "jdbc:h2:mem:testdb", "sa", "");
            IDataSet dataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dataset.xml"));
            databaseTester.setDataSet(dataSet);
            databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
            databaseTester.onSetup();
        }

        @Test
        public void testBuscarUsuarioPorId() throws Exception {
            UsuarioDao usuarioDao = new UsuarioDao(ConexaoBancoDados.getConexao());
            Usuario usuario = usuarioDao.buscarUsuarioPorId(1);
            assertEquals("Karen Giullia", usuario.getNome());
        }
    }
```

Note que a classe `UsuarioDaoTest` usa a notação @Test do JUnit para indicar que o método `testBuscarusuarioPorId` é um teste.

3. Crie a classe UsuarioDAO que contém os métodos para acessar o banco de dados.

```java
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;

    public class UsuarioDao {
        private Connection conexao;

        public UsuarioDao(Connection conexao) {
            this.conexao = conexao;
        }

        public Usuario buscarUsuarioPorId(int id) throws SQLException {
            String query = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Usuario(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("email"));
            } else {
                return null;
            }
        }
    }
```

4. Crie uma classe simples Usuario para representar os dados dos usuários
```java
    public class Usuario {
        private int id;
        private String nome;
        private String email;

        public Usuario(int id, String nome, String email) {
            this.id = id;
            this.nome = nome;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }
    }
```

5. Agora é só utilizar os testes!
* Selecione a classe de teste `UsuarioDaoTest` e execute como um teste JUnit.

Lembre-se de verificar se os testes são executados com sucesso e se os dados do `dataset.xml` foram corretamente inseridos no banco de dados.

É possível concluir que o DBUnit se mostra eficaz ao garantir a consistência e a confiabilidade dos testes de integração de banco de dados. 

Mais informações sobre a utilização da ferramenta, acesse [DBUnit](https://www.dbunit.org)

## Ferramentas Similares
Aqui citamos algumas ferramentas que também lidam com o DBUnit

* **Flyway**: Flyway é uma ferramenta de migração de banco de dados que ajuda a gerenciar alterações incrementais no esquema do banco de dados. Ela é amplamente utilizada para testes de integração ao garantir que a estrutura do banco de dados esteja na versão correta antes dos testes. [Link](https://flywaydb.org/)

* **Liquibase**:  Liquibase é uma ferramenta de migração de banco de dados que permite controlar a versão do esquema do banco de dados. Ela pode ser integrada aos testes de integração para garantir que o banco de dados esteja na versão correta. [Link](https://www.liquibase.org/)

* **PHPUnit**: PHPUnit é uma estrutura de teste para PHP que suporta testes unitários e de integração. Ele permite a criação de testes de integração para verificar a interação entre os módulos da aplicação e o banco de dados. [Link](https://phpunit.de/)

## Referências
* **Documentação DBUnit** Disponível em: [Link](https://www.dbunit.org)
* **Oliveira, Breno** em *""Automatizando testes com JUnit, DBUnit e Spring""*. Disponível em: [Link](https://imasters.com.br/back-end/automatizando-testes-com-junit-dbunit-e-spring)
* **Normandes** em *"Testes de integração com DBUnit"*. Disponível em: [Link](https://blog.algaworks.com/testes-de-integracao-com-dbunit/)
* *"Revista SQL Magazine - Edição 44"*. Disponível em: [Link](https://www.devmedia.com.br/implementando-testes-unitarios-em-bases-de-dados-com-dbunit/7094)