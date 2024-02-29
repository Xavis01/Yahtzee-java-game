package Yahtzee.Game;

import java.util.Scanner;

public class YahtzeeGame {
    
    private static Scanner scan = new Scanner(System.in);
    private static Menu menu = new Menu();
    private static Sistema sistema = new Sistema();
    private static Jogo jogo = new Jogo();

    private static String nome;
    private static int opcao;

    public static void main(String[] args) {
        sistema.inicializarJogadores();
        do {

            
            menu.menuPrincipal();
            System.out.print("=> ");
            //sistema.listar();
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    jogo.jogar();
                    break;
            
                case 2:
                    sistema.cadastrarJogador(nome);
                    break;

                case 3:
                    menu.menuGerenciar();
                    sistema.gerenciarJogadores(nome);
                    break;

                case 4:
                    menu.menuRegras();
                    break;

                default:
                    System.out.println("\nValor inválido");
                    break;

                case 0:
                    System.out.println("Sistema finalizado.");

                case 9:
                System.out.println(sistema.getListaJogador());
            }

        }while(opcao != 0);
    }

}
