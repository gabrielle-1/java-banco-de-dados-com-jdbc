package jdbc.negocio.conexao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    //Construtor privado para evitar instâncias da fábrica
    private ConnectionFactory() {throw new UnsupportedOperationException();}

    public static Connection getConnection(){
        //Declaração do objeto conexão
        Connection connection = null;

        //Carregando arquivo de propriedades para resgatar parâmetros necessários para a comunicação com o banco
        try (InputStream inputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream("connection.properties")) {

            //Definição de parâmetros para conexão com o banco de dados
            Properties prop = new Properties();
            prop.load(inputStream);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            //Construindo String de conexão --> protocolo:drive:endereço
            StringBuilder stringBuilder = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAddress).append("/")
                    .append(dataBaseName);

            String urlConnection = stringBuilder.toString();// ==> "jdbc:mysql://localhost/banco_java"

            //Criar conexão usando o DriverManager, passando como parâmetros a string de conexão, usuário e senha
            try {
                connection = DriverManager.getConnection(urlConnection, user, password);
            } catch (SQLException e) {
                System.out.println("Falha na conexão com o banco de dados.");
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;
    }
}

