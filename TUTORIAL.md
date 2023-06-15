# Seminário Mock de classes, com *,Mockito*,
## Introdução
Mockito é o nome de uma biblioteca de testes do java que permite criar um objeto simulado, ou um mockup, justamente para que possa simular as ações de uma classe do nosso projeto, evitando que ela seja chamada de fato no nosso projeto.
Essa biblioteca é amplamente utilizada para facilitar o desenvolvimento de testes unitários e integração, permitindo isolar o código a ser testado de suas dependências.
O Mockito fornece uma maneira fácil e intuitiva de criar mockups cm comportamentos predefinidos pelo desenvolvedor, verificando as interações entre objetos e realizando asserções em seus estados.

## Install && Config

Para utilizar o Mockito é necessário implementar a dependência de teste do Mockito, que será explicado no passo a passo:

1) Com seu A.S aberto, abra sua Estrutura de Projeto utilizando Ctrl+Alt+Shift+S (verifique seu comando caso sistema operacional diferente);
Você pode abrir sua Estrutura de Projeto pela guia File:

![image](https://github.com/lamenkazu/Seminarios-Testes-Software/assets/23318318/a2ea07b7-1332-4d7b-a980-b13cb3228fd4)

ou pelas ferramentas do projeto: 

![image](https://github.com/lamenkazu/Seminarios-Testes-Software/assets/23318318/bb928211-866a-4c7e-b1f2-3827e3ff3fea)
 
2)Então vá até as dependências do seu módulo ao qual quer implementar o teste, e clique em adicionar dependência
    ![image](https://github.com/lamenkazu/Seminarios-Testes-Software/assets/23318318/6c72dee0-685b-4ee0-a159-742df96a9268)
   .
   e adicione uma Library Dependency
   ![image](https://github.com/lamenkazu/Seminarios-Testes-Software/assets/23318318/a660d02c-5dbb-44af-b66a-688eb5d6dcaa)

pesquise por Mockito procurando por: org.mockito
![image](https://github.com/lamenkazu/Seminarios-Testes-Software/assets/23318318/a71c3f03-2306-4ef6-b9e7-35caba0814f6)

.
adicione o mockito-core
![image](https://github.com/lamenkazu/Seminarios-Testes-Software/assets/23318318/d04f6703-88b7-44ae-b52c-d21849287318)

selecione a configuração da dependencia como testImplementation
![image](https://github.com/lamenkazu/Seminarios-Testes-Software/assets/23318318/7e34f53e-9c69-4ce4-a53d-08325083f6a3)

Confirme tudo e você está com o Mockito pronto no seu projeto.


 
 ## Getting Started
 Aqui está um exemplo básico de como usar o Mockito para criar um Mockup de classe e definir seu comportamento:
 
 1- primeiro definir uma classe 
 
 public class MinhaClasse {

    public String algumMetodo() {
        return "duvido que você está lendo isso";
    }
}


então criando uma classe teste 

import org.junit.Test;
  
import org.mockito.Mock;
  
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

package com.example.seminariomaterial;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*; //Trás todos os métodos de Assert para utilizar nos testes

import static org.mockito.Mockito.*; //Trás todos os métodos de Mockito para utilizar na classe.

public class MinhaClasseTest {

    @Mock
    private MinhaClasse mockClass;

    @Test
    public void testMyMethod() {
        // Criando o Mockup
        mockClass = mock(MinhaClasse.class);

        // Definindo o comportamento do método com o metodo when do Mockito
        when(mockClass.algumMetodo()).thenReturn("Resultado Simulado");

        // Chamando o método que utiliza o mock
        String result = mockClass.algumMetodo();

        // Verificando se o comportamento esperado ocorreu
        assertEquals("Resultado Simulado", result);
    }
}



Neste exemplo, criei um mockup da classe MinhaClasse usando a anotação @Mock.
Em seguida, defini o comportamento do método algumMetodo() do mock para retornar "Resultado Simulado" usando o método when().thenReturn() do Mockito.
Por fim, verificamos se o comportamento esperado ocorre, comparando o resultado com um valor esperado através do assertEquals do JUnit.

Rode o teste:

![image](https://github.com/lamenkazu/Seminarios-Testes-Software/assets/23318318/b30e037b-995c-42da-9cc6-fc73d2bccaa2)

se emocione com essa tela fofa:
![image](https://github.com/lamenkazu/Seminarios-Testes-Software/assets/23318318/fce2a556-a4a3-44d2-8e08-b5461970ba07)

aprovite, você não vai ver essa tela muito verde.


## Ferramentas símiles
Existem várias ferramentas similares ao Mockito que podem ser usadas para testes de unidades e criação de mockups em diferentes linguagens de programação. 
Algumas delas são:
1) EasyMock: Uma biblioteca de criação de mockups para Java. Ela fornece uma sintaxe simples para criar e configurar objetos simulados. Página principal: https://easymock.org/.
2) PowerMock: Uma extensão do Mockito que permite criar mockups de classes estáticas, métodos finais e construtores privados. Ele oferece recursos adicionais para testar código legado. Página principal: https://powermock.github.io/.
3) Moq: Uma biblioteca de criação de mockups para C#. Ela permite criar objetos simulados e definir comportamentos e expectativas de chamada de método. Página principal: https://github.com/moq/moq4.

Essas são apenas algumas opções.
Este é o tutorial básico que ninguém vai ler sobre como começar a utilizar o Mockito para criar simulações de classes no A.S. Se tiver alguma dúvida adicional, não tenha!

