package jdbc.dados.dao;
import jdbc.negocio.conexao.ConnectionFactory;
import jdbc.negocio.entity.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public void list(){

        //Lista que irá retornas os cursos após consulta no banco de dados:
        List<Curso> cursos = new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnection()){

            //Preparando a consulta SQL
            String sql = "SELECT * FROM curso WHERE status =?";

            //Preparando o statement com os parâmetros recebidos, nesse caso não terá parâmetros pois irá retornar todos os valores contidos na tabela curso
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setString(1,"SIM");

            //Executando a consulta e armazenando o retorno no objeto "rs"
            ResultSet rs = prst.executeQuery();

            //Criando um objeto aluno e guardando na lista de alunos:
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int duracaoHoras = rs.getInt("duracao_horas");

                cursos.add(new Curso(
                        id,nome,duracaoHoras
                ));
            }

        }catch(SQLException e){
            System.out.println("Listagem de cursos falhou.");
            e.printStackTrace();
        }
        //Exibir os cursos encontrados no banco de dados
        cursos.stream().forEach(System.out::println);
    }

    public Curso getById(int idQuery) {
        Curso curso=null;

        try(Connection connection = ConnectionFactory.getConnection()){

            //Preparando a consulta SQL
            String sql = "SELECT * FROM curso WHERE id =?";

            //Preparando o statement com os parâmetros recebidos, nesse caso não terá parâmetros pois irá retornar todos os valores contidos na tabela curso
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setInt(1, idQuery);
            //Executando a consulta e armazenando o retorno no objeto "rs"
            ResultSet rs = prst.executeQuery();

            //Criando um objeto aluno e guardando na lista de alunos:
            if(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int duracaoHoras = rs.getInt("duracao_horas");

                //Lista que irá retornas os alunos após consulta no banco de dados:
                curso = new Curso(
                        id,nome,duracaoHoras);
            }

        }catch(SQLException e){
            System.out.println("Listagem de cursos falhou.");
            e.printStackTrace();
        }
        //Retornar o curso encontrado no banco de dados
        return curso;
    }

    public void create(Curso curso) {
        try(Connection connection = ConnectionFactory.getConnection()){

            //Preparando SQL para inserção do novo curso no banco de dados
            String sql = "INSERT INTO curso(nome, duracao_horas, status) VALUES(?, ?, ?)";

            //Preparando o statement com os parâmetros recebidos, nesse caso não terá parâmetros pois irá retornar todos os valores contidos na tabela aluno
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setString(1, curso.getNome());
            prst.setInt(2, curso.getDuracaoHoras());
            prst.setString(3, "SIM");

            //Executando a consulta e armazenando o retorno no objeto "rs"
            int rowsAffected = prst.executeUpdate();
            System.out.println("Inserção bem sucedida! - Foi adicionada " + rowsAffected + " linha.");

        }catch(SQLException e){
            System.out.println("Inserção falhou.");
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try(Connection connection = ConnectionFactory.getConnection()){

            //Preparando SQL para inserção do novo curso no banco de dados
            String sql = "DELETE FROM curso WHERE id =?";

            //Preparando o statement com os parâmetros recebidos, nesse caso não terá parâmetros pois irá retornar todos os valores contidos na tabela curso
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setInt(1, id);

            //Executando a consulta e armazenando o retorno no objeto "rs"
            int rowsAffected = prst.executeUpdate();
            System.out.println("Exclusão bem sucedida! - Foi deletada " + rowsAffected + " linha.");

        }catch(SQLException e){
            System.out.println("Delete falhou.");
            e.printStackTrace();
        }
    }

    public void update(Curso curso) {
        try(Connection connection = ConnectionFactory.getConnection()){

            //Preparando SQL para inserção do novo aluno no banco de dados
            String sql = "UPDATE curso SET nome =?, duracao_horas =? WHERE id =?";

            //Preparando o statement com os parâmetros recebidos, nesse caso não terá parâmetros pois irá retornar todos os valores contidos na tabela aluno
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setString(1, curso.getNome());
            prst.setInt(2, curso.getDuracaoHoras());
            prst.setInt(2, curso.getId());

            //Executando a consulta e armazenando o retorno no objeto "rs"
            int rowsAffected = prst.executeUpdate();
            System.out.println("Atualização bem sucedida! - Foi alterada " + rowsAffected + " linha.");

        }catch(SQLException e){
            System.out.println("Atualização falhou.");
            e.printStackTrace();
        }
    }

}
