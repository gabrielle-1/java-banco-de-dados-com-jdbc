package jdbc.gui;

import com.sun.tools.javac.Main;
import jdbc.negocio.entity.Aluno;
import jdbc.negocio.FachadaAluno;
import jdbc.negocio.interfaces.IFachadaAluno;

import java.util.Scanner;

public class GUIAluno extends Main {

    static Scanner in = new Scanner(System.in);
    static IFachadaAluno fachadaAluno = new FachadaAluno();

    public static void menuAluno(){
        System.out.println("1- Listar alunos.");
        System.out.println("2- Criar aluno.");
        System.out.println("3- Alterar aluno.");
        System.out.println("4- Deletar aluno.");

        int escolha = in.nextInt();

        switch (escolha){
            case 1:
                System.out.println("//================CONSULTA======================//");
                fachadaAluno.list();
                break;
            case 2:
                System.out.println("//============CRIAR NOVO ALUNO===============//");
                System.out.println("Digite o nome do aluno:");
                String nome = in.next();
                System.out.println("Digite a idade do aluno:");
                int idade = in.nextInt();
                System.out.println("Digite ao endereço do aluno:");
                String endereco = in.next();
                Aluno aluno =  new Aluno(nome, idade,endereco);
                fachadaAluno.create(aluno);
                break;
            case 3:
                System.out.println("//================ATUALIZAR ALUNO======================//");
                System.out.println("Digite o id do aluno:");
                int id = in.nextInt();
                aluno = fachadaAluno.getById(id);
                System.out.println("Digite o novo nome do aluno:");
                nome = in.next();
                System.out.println("Digite a nova idade do aluno:");
                idade = in.nextInt();
                aluno.setNome(nome);
                aluno.setIdade(idade);
                fachadaAluno.update(aluno);
                break;
            case 4:
                System.out.println("//================DELETAR ALUNO======================//");
                System.out.println("Digite o id do aluno:");
                id = in.nextInt();
                fachadaAluno.delete(id);
                break;
            case 0:
                System.out.println("Bye bye!!");
            default:
                System.out.println("Opção inválida!");
        }
    }

}
