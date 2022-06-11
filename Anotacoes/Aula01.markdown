#### Java com Banco de Dados utilizando JDBC e JPA

+ Configuração do Banco de Dados.
+ JDBC e Drivers de Conexão.
+ Consultas ao Banco de Dados com JDBC.

Requisitos: 

MySQL e noções de SQL;

JDK 1.8 ou superior;

IDE(Intellij ou qualquer outro);

Gradle 5.3.1 ou baixar manualmente o Driver JDBC.

##### Configuração do Banco de Dados:

Um Banco de Dados(BD) armazena dados de forma estruturada, tornando o acesso e atualização dos dados mais rápido, aumentrando a eficiência computacional(um menor gasto de memória, processamento e tempo).

Utilizaremos o banco de dados relacional MySQL(um SGBD de Banco de Dados Relacionais, ou seja, um Gerenciador de Bancos de Dados).

##### Passos:

- Eu utilizarei o XAMPP e o phpMyAdmin.

1. Instalar o MySQL;
1. Configurar usuário e senha - Padrão:root;
1. Criar Banco de Dados - Nomeei de banco_java;
1. Criar uma tabela - Nomeei de aluno.

O comando SQL para criar a tabela foi:

CREATE TABLE `banco_java`.`aluno` (`id` INT NOT NULL AUTO_INCREMENT , `nome` VARCHAR(255) NULL DEFAULT NULL , `idade` INT NOT NULL , `estado` VARCHAR(255) NULL DEFAULT NULL , `status` VARCHAR(55) NULL DEFAULT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

Portanto, a tabela de aluno possui os seguintes campos:
    id, nome, idade, estado, status


Agora, inseri dados nesta tabela, utilizando o comando SQL:

INSERT INTO `aluno` (`id`, `nome`, `idade`, `estado`, `status`) VALUES 
(NULL, 'Ana Paula', '19', 'Pernambuco', 'SIM'), 
(NULL, 'Bruno Silva', '21', 'Pernambuco', 'SIM'), 
(NULL, 'Luan Santos', '18', 'Pernambuco', 'SIM'), 
(NULL, 'Maria Clara', '25', 'Pernambuco', 'SIM');


##### JDBC e drivers de conexão:

JDBC(Java Database Connectivity) é uma API com diversas classes e interfaces escritas em Java presentes nos pacotes java.sql e javax.sql. Permitindo os programas em Java realizar operações de conexão com bancos de dados para realizar consultas. Uma das classes principais é o driver JDBC.

Sem a API JDBC, seria necessário conhecer o protocolo proprietário de cada banco de dados para se conectar e realizar consultas. 

Já com a API JDBC, é utilizada somente UMA interface Java para qualquer banco de dados, deixando o driver implementar as especificações de cada banco de dados, enquanto o desenvolvedor se precoupa apenas em selecionar o driver.


#### Classes e interfaces utilizadas:

+ DriverManager - Faz a comunicação com os drivers disponíveis. Utilizada para a criação de uma Connection com o BD através de uma URL, especificando driver, localização do BD e o seu respectivo nome.

+ Interface Connection - Representa a conexão com o banco de dados. Permite criar "Statements" que constroem consultas SQL.

#### Passos para se conectar ao BD:

1. Download do driver específico para o BD que será utilizado(no nosso caso será o MySQL), podendo realizar essa operação manualmente ou pelo Gradle ou Maven.
1. Criar URL(string de conexão) com os parâmetros driver, endereço do BD e nome do BD.
1. Criar uma connection através do "DriverManager" utilizando o método "getConnection" passando os parâmetros string de conexão, usuário e senha.

Através do Gradle, no arquivo de dependência, adicionamos a linha:
        compile group: 'mysql', name: 'mysql-connector-java', version: '8.0.17'


#### Consultas com JDBC

Existem 3 interfaces para montar comandos SQL:

+ Statement - Executar SQL comuns(utiliza-se uma forma estática, o que não é muito comum e recomendável);
+ PreparedStatement - Executar SQL parametrizáveis;
+ CallableStatement - Executar stored procedures;

O recomendável é dar preferência a PreparedStatement ao Statement quando for parametrizar a consulta, pois:

+ Previne SQL Injection
+ Melhora legibilidade
+ Melhora desempenho


Existem 3 métodos para executar comandos SQL:

+ execute - Executa qualquer tipo de SQL, porém não recomendável.
+ executeQuery - Usado para executar consultas de "SELECT".
+ executeUpdate - Usado para comandos de alteração de banco de dados (INSERT, UPDATE, DELETE, CREATE, ALTER).



Ao buscar os dados no banco, representamos ele em um objeto chamado ResultSet.

+ **ResultSet** - Contém o retorno com os dados de uma determinada consulta no banco de dados.

São utilizados os métodos getters para buscar dados do ResultSet. Tais como getInt, getFloat, etc.

Um método **next()** é utilizado para percorrer o registro do ResultSet(geralmente utilizado com um loop, como o while).
















	



