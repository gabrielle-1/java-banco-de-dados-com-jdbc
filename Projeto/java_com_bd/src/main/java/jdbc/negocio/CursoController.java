package jdbc.negocio;

import jdbc.negocio.entity.Curso;
import jdbc.dados.dao.CursoDAO;

import java.util.List;

public class CursoController {

    private CursoDAO cursoDAO;

    public CursoController(){
        this.cursoDAO = new CursoDAO();
    }

    public void list(){
         this.cursoDAO.list();
    }

    public Curso getById(int idQuery) {
        return this.cursoDAO.getById(idQuery);
    }

    public void create(Curso curso) {
        this.cursoDAO.create(curso);
    }

    public void delete(int id) {
        this.cursoDAO.delete(id);
    }

    public void update(Curso curso) {
        this.cursoDAO.update(curso);
    }
}
