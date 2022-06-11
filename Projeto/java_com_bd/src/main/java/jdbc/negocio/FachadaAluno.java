package jdbc.negocio;

import jdbc.negocio.entity.Aluno;
import jdbc.negocio.interfaces.IFachadaAluno;

import java.util.List;

public class FachadaAluno implements IFachadaAluno {

    private AlunoController alunoController = new AlunoController();

    @Override
    public void list() {
         this.alunoController.list();
    }

    @Override
    public Aluno getById(int idQuery) {
        return this.alunoController.getById(idQuery);
    }

    @Override
    public void create(Aluno aluno) {
        this.alunoController.create(aluno);
    }

    @Override
    public void delete(int id) {
        this.alunoController.delete(id);
    }

    @Override
    public void update(Aluno aluno) {
        this.alunoController.update(aluno);
    }
}

