package jdbc.negocio.interfaces;
import jdbc.negocio.entity.Aluno;

import java.util.List;

public interface IFachadaAluno {

    void list();

    Aluno getById(int idQuery);

    void create(Aluno aluno);

    void delete(int id);

    void update(Aluno aluno);
}
