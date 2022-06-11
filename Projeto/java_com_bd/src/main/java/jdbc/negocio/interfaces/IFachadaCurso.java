package jdbc.negocio.interfaces;

import jdbc.negocio.entity.Curso;

import java.util.List;

public interface IFachadaCurso {

    void list();

    Curso getById(int idQuery);

    void create(Curso curso);

    void delete(int id);

    void update(Curso curso);

}
