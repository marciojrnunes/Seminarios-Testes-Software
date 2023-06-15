# Mockoup de Classes: Mockito

**Integrantes: Gabriella Souza Aguiar e Wallace Freitas Oliveira**

# Introdução

O processo de testes é uma etapa fundamental no desevolvimento de softwares, pois durante a execução dessa se torna possivel verificar e corrigir se necessário diversos aspectos da solução impelementada, garantindo assim a melhor qualidade possivel do projeto. Os teste de softwares se dividem em diferentes tipos: testes unitarios, de integração e de sistema, cada um desses apresentam suas especificidades própias e motivações para seu uso. Nesse pequeno tutorial abordaremos o processo de teste unitário ultilizando da estratégia de mockoup de classes, para realizar a verificação de classes em java, com o auxilio do Framework Mockito.

Iniciamos definindo a motivação para realizar testes de classes, imagine-se na seguinte situação: Você deve implementar uma nova classe X que depende da integração com uma classe Y. No entanto, para assegurar o ideal funcionamento de X, é necessário que essa classe seja testada, mas como realizar esse teste, uma vez que X depende do funcionamento de Y, e é nesse momento que surge a necessidade de realizar o mockoup de classes. O mockoup de classes, consiste na criação de objetos simulados dentro de um sistemas de testes para que outras classes dependentes da classe mockada consigam ser testadas. Esses objetos criados, imitam o comportamento real da classe base (classe da qual foi instânciada) permitindo assim, que as demais as ultilizem para realizar os testes necessários de maneira isolada e verificar o funcionamento da solução.

# Mockito Framework

O framework Mockito, é uma das soluções de código aberto mais conhecidas e amplamente ultilizadas para realização de testes unitários em java quando o foco é na implementação de mocks de classes e interfaces. Atualmente é mantido e atualizado pela comunidade de desenvolvedores através do gitHub (https://github.com/mockito/mockito) e se encontra na versão 5 adotando o suporte ao Java na versão JDK 11.

*OBS - Para execultar ultilizando JDK 8 deve-se ultilizar a versão 4 do Mockito*

# Configurando o Ambiente

Para começar a utilizar o Mockito em um projeto Java é necessario iniciar com a importação do framework atraves do gerenciador de dependências de sua preferência, abaixo exemplificamos como realizar essa importação atraves do Maven ou Gradle:

`Maven`
![Maven](images/pom_xml.png)
*Configuração pom.xml*

`Gradle`
![Gradle](images/build_gradle.png)
*Configuração build.gradle*









