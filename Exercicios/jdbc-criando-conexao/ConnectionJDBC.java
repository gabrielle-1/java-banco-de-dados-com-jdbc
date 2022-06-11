import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static void main(String[] args) throws SQLException {
        // Definindo parâmetros para se conectar ao Banco de Dados
        String driver = "mysql";
        String dataBaseAddress = "localhost";
        String dataBaseName = "banco_java";
        String user = "root";
        String password = "";

        // Construindo String de conexão
        // protocolo:drive:endereço
        StringBuilder stringBuilder = new StringBuilder("jdbc:")
                .append(driver).append("://")
                .append(dataBaseAddress).append("/")
                .append(dataBaseName);

        String urlConnection = stringBuilder.toString();

        // Utilizando try with resources
        try (Connection connection = DriverManager.getConnection(urlConnection, user, password)) { // estabelece a
                                                                                                   // conexão){
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException sqlException) {
            System.out.println("Falha ao estabelecer a conexão com o banco de dados. \n" + sqlException.getMessage());
        }

        /*
         * AlunoDAO alunoDAO = new AlunoDAO();
         * List<Aluno> alunos = null;
         * Aluno aluno = null;
         * 
         * //================CONSULTA======================//
         * System.out.println("\nConsulta geral:");
         * alunos = alunoDAO.list();
         * alunos.stream().forEach(System.out::println);
         * 
         * //================CONSULTA COM FILTRO======================//
         * System.out.println("\nConsulta com o id:3:");
         * aluno = alunoDAO.getById(3);
         * System.out.println(aluno);
         * 
         * //================CRIAR NOVO ALUNO======================//
         * System.out.println("\nCriação:");
         * alunoDAO.create(new Aluno("Manoel", 40, "Pernambuco"));
         * 
         * //================DELETAR ALUNO======================//
         * System.out.println("\nExclusão:");
         * alunoDAO.delete(6);
         * alunoDAO.delete(7);
         * alunoDAO.delete(8);
         * 
         * //================ATUALIZAR ALUNO======================//
         * System.out.println("\nAtualização:");
         * aluno = alunoDAO.getById(4);
         * aluno.setNome("Emanuel Ferreira");
         * aluno.setIdade(28);
         * 
         * alunoDAO.update(aluno);
         * 
         * //================CONSULTA======================//
         * System.out.println("\nConsulta geral:");
         * alunos = alunoDAO.list();
         * alunos.stream().forEach(System.out::println);
         */

    }

}
