package jdbc.dados.dao;

import jdbc.negocio.entity.Aluno;
import jdbc.negocio.conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    //Consulta
    public void list(){

        //Lista que irá retornas os alunos após consulta no banco de dados:
        List<Aluno> alunos = new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnection()){

            //Preparando a consulta SQL
            String sql = "SELECT * FROM aluno WHERE status =?";

            //Preparando o statement com os parâmetros recebidos, nesse caso não terá parâmetros pois irá retornar todos os valores contidos na tabela aluno
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setString(1,"SIM");

            //Executando a consulta e armazenando o retorno no objeto "rs"
            ResultSet rs = prst.executeQuery();

            //Criando um objeto aluno e guardando na lista de alunos:
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String estado = rs.getString("estado");

                alunos.add(new Aluno(
                        id,nome,idade,estado
                ));
            }

        }catch(SQLException e){
            System.out.println("Listagem de alunos falhou.");
            e.printStackTrace();
        }
        //Exibir os alunos encontrados no banco de dados
        alunos.stream().forEach(System.out::println);
    }

    //Consulta com filtro
    public Aluno getById(int idQuery) {
        Aluno aluno=null;

        try(Connection connection = ConnectionFactory.getConnection()){

            //Preparando a consulta SQL
            String sql = "SELECT * FROM aluno WHERE id =?";

            //Preparando o statement com os parâmetros recebidos, nesse caso não terá parâmetros pois irá retornar todos os valores contidos na tabela aluno
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setInt(1, idQuery);
            //Executando a consulta e armazenando o retorno no objeto "rs"
            ResultSet rs = prst.executeQuery();

            //Criando um objeto aluno e guardando na lista de alunos:
            if(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String estado = rs.getString("estado");


                //Lista que irá retornas os alunos após consulta no banco de dados:
                aluno = new Aluno(
                        id,nome,idade,estado);
            }

        }catch(SQLException e){
            System.out.println("Listagem de alunos falhou.");
            e.printStackTrace();
        }
        //Retornar os alunos encontrados no banco de dados
        return aluno;
    }

    //Criar aluno
    public void create(Aluno aluno) {
        try(Connection connection = ConnectionFactory.getConnection()){

            //Preparando SQL para inserção do novo aluno no banco de dados
            String sql = "INSERT INTO aluno(nome, idade, estado, status) VALUES(?, ?, ?, ?)";

            //Preparando o statement com os parâmetros recebidos, nesse caso não terá parâmetros pois irá retornar todos os valores contidos na tabela aluno
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setString(1, aluno.getNome());
            prst.setInt(2, aluno.getIdade());
            prst.setString(3, aluno.getEstado());
            prst.setString(4, "SIM");

            //Executando a consulta e armazenando o retorno no objeto "rs"
            int rowsAffected = prst.executeUpdate();
            System.out.println("Inserção bem sucedida! - Foi adicionada " + rowsAffected + " linha.");

        }catch(SQLException e){
            System.out.println("Inserção falhou.");
            e.printStackTrace();
        }
    }

  //Deletar aluno
    public void delete(int id) {
        try(Connection connection = ConnectionFactory.getConnection()){

            //Preparando SQL para inserção do novo aluno no banco de dados
            String sql = "DELETE FROM aluno WHERE id =?";

            //Preparando o statement com os parâmetros recebidos, nesse caso não terá parâmetros pois irá retornar todos os valores contidos na tabela aluno
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

  //Atualizar aluno
    public void update(Aluno aluno) {
        try(Connection connection = ConnectionFactory.getConnection()){

            //Preparando SQL para inserção do novo aluno no banco de dados
            String sql = "UPDATE aluno SET nome =?, idade =? WHERE id =?";

            //Preparando o statement com os parâmetros recebidos, nesse caso não terá parâmetros pois irá retornar todos os valores contidos na tabela aluno
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setString(1, aluno.getNome());
            prst.setInt(2, aluno.getIdade());
            prst.setInt(3, aluno.getId());

            //Executando a consulta e armazenando o retorno no objeto "rs"
            int rowsAffected = prst.executeUpdate();
            System.out.println("Atualização bem sucedida! - Foi alterada " + rowsAffected + " linha.");

        }catch(SQLException e){
            System.out.println("Atualização falhou.");
            e.printStackTrace();
        }
    }

}
