package jdbc;

import java.util.Scanner;

public class Main {

    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int option = 0;

        do {
            Menu menu = Menu.getMenu();

            System.out.println("Bem vindo(a)! Deseja navegar entre cursos ou alunos?");
            System.out.println("1- Cursos | 2-Alunos | 0-Sair do Programa");
            option = s.nextInt();

            switch(option){
                case 1://Cursos
                    menu.exibirMenuCurso();
                    break;
                case 2://Alunos
                    menu.exibirMenuAluno();
                    break;
                case 0:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opcão inválida!");
            }

        }while(option != 0);
    }
}
