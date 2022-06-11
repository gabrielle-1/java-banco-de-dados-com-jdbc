package jdbc.negocio;

import jdbc.negocio.entity.Curso;
import jdbc.negocio.interfaces.IFachadaCurso;

import java.util.List;

public class FachadaCurso implements IFachadaCurso {

    private CursoController cursoController = new CursoController();

    @Override
    public void list() {
         this.cursoController.list();
    }

    @Override
    public Curso getById(int idQuery) {
        return this.cursoController.getById(idQuery);
    }

    @Override
    public void create(Curso curso) {
        this.cursoController.create(curso);
    }

    @Override
    public void delete(int id) {
        this.cursoController.delete(id);
    }

    @Override
    public void update(Curso curso) {
        this.cursoController.update(curso);
    }
}
