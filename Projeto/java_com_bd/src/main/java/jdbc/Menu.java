package jdbc;

import jdbc.gui.GUIAluno;
import jdbc.gui.GUICurso;

public class Menu{

    static GUIAluno guiAluno;
    static GUICurso guiCurso;

    static Menu menu;

    private Menu(){
        guiAluno = new GUIAluno();
        guiCurso = new GUICurso();
    }

    public static Menu getMenu(){
        if(menu == null){
            menu = new Menu();
        }
        return menu;
    }

    public static void exibirMenuCurso() {
        guiCurso.menuCurso();
    }

    public static void exibirMenuAluno() {
        guiAluno.menuAluno();
    }

}