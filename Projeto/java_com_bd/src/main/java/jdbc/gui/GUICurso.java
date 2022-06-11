package jdbc.gui;

import jdbc.Main;
import jdbc.negocio.entity.Curso;
import jdbc.negocio.FachadaCurso;
import jdbc.negocio.interfaces.IFachadaCurso;

import java.util.Scanner;

public class GUICurso extends Main {

    static Scanner in = new Scanner(System.in);
    static IFachadaCurso fachadaCurso = new FachadaCurso();

    public static void menuCurso(){
        System.out.println("1- Listar cursos.");
        System.out.println("2- Criar curso.");
        System.out.println("3- Alterar curso.");
        System.out.println("4- Deletar curso.");

        int escolha = in.nextInt();

        switch (escolha){
            case 1:
                System.out.println("//================CONSULTA======================//");
                fachadaCurso.list();
                break;
            case 2:
                System.out.println("//============CRIAR NOVO CURSO===============//");
                System.out.println("Digite o nome do curso:");
                String nome = in.next();
                System.out.println("Digite a duração do curso:");
                int duracaoHoras = in.nextInt();
                Curso curso =  new Curso(nome, duracaoHoras);
                fachadaCurso.create(curso);
                break;
            case 3:
                System.out.println("//================ATUALIZAR CURSO======================//");
                System.out.println("Digite o id do curso:");
                int id = in.nextInt();
                curso = fachadaCurso.getById(id);
                System.out.println("Digite o novo nome do curso:");
                nome = in.next();
                System.out.println("Digite a nova duração do curso:");
                duracaoHoras = in.nextInt();
                curso.setNome(nome);
                curso.setDuracaoHoras(duracaoHoras);
                fachadaCurso.update(curso);
                break;
            case 4:
                System.out.println("//================DELETAR CURSO======================//");
                System.out.println("Digite o id do curso:");
                id = in.nextInt();
                fachadaCurso.delete(id);
                break;
            case 0:
                System.out.println("Bye bye!!");
            default:
                System.out.println("Opção inválida!");
        }
    }

}
