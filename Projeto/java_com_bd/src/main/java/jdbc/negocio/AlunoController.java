package jdbc.negocio;

import jdbc.negocio.entity.Aluno;
import jdbc.dados.dao.AlunoDAO;

import java.util.List;

public class AlunoController {

    private AlunoDAO alunoDAO;

    public AlunoController(){
        this.alunoDAO = new AlunoDAO();
    }

    public void list(){
        this.alunoDAO.list();
    }

    public Aluno getById(int idQuery) {
        return this.alunoDAO.getById(idQuery);
    }

    public void create(Aluno aluno) {
        this.alunoDAO.create(aluno);
    }

    public void delete(int id) {
        this.alunoDAO.delete(id);
    }

    public void update(Aluno aluno) {
        this.alunoDAO.update(aluno);
    }

}
