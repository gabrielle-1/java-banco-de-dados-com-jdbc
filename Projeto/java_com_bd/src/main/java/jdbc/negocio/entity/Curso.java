package jdbc.negocio.entity;

public class Curso {
    private int id;
    private String nome;
    private int duracaoHoras;

    public Curso(int id, String nome, int duracaoHoras) {
        this.id = id;
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso(String nome, int duracao_horas) {
        this.nome = nome;
        this.duracaoHoras = duracao_horas;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(int duracao_horas) {
        this.duracaoHoras = duracao_horas;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", duracao_horas=" + duracaoHoras +
                '}';
    }
}
