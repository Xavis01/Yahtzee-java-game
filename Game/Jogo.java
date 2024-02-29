package Yahtzee.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Jogo {
    private Sistema sistema = new Sistema();
    private Scanner scan = new Scanner(System.in);
    private ArrayList<Jogador> listaJogadores = sistema.getListaJogador();
    private Dado dado1 = new Dado();
    private Dado dado2 = new Dado();
    private Dado dado3 = new Dado();
    private Dado dado4 = new Dado();
    private Dado dado5 = new Dado();

    public void jogar() {
        sistema.inicializarJogadores();
        if (listaJogadores.isEmpty()) {
            System.out.println("Lista de jogadores vazia. Adicione jogadores antes de começar o jogo.");
            return;  // Encerra o método, pois não há jogadores para jogar.
        }

        int rodada = 0;
        

        while(rodada < 13) {
            rodada++;
        
            for (Jogador jogadorAtual : listaJogadores) {
                System.out.println("\nJogador: " + jogadorAtual.getNome());
                ArrayList<Integer> listaPontuacao = new ArrayList<>();

                System.out.println("\nRodada " + rodada);

                

                System.out.print("Digite 1 para jogar os dados ou 0 para Sair => ");
                int resp = scan.nextInt();

                if (resp == 0) {
                    return;
                }

                dado1.rolar();
                dado2.rolar();
                dado3.rolar();
                dado4.rolar();
                dado5.rolar();

                ArrayList<Integer> resultados = new ArrayList<>(); // Adiciona os valores da variaveis na lista resultados
                resultados.add(dado1.getValor());
                resultados.add(dado2.getValor());
                resultados.add(dado3.getValor());
                resultados.add(dado4.getValor());
                resultados.add(dado5.getValor());

                System.out.println("Dados: " + dado1.getValor() + ", " + dado2.getValor() + ", " + dado3.getValor() + ", " + dado4.getValor() + ", " + dado5.getValor());

                int frequenciaDeUm = Collections.frequency(resultados,1);
                int frequenciaDeDois = Collections.frequency(resultados,2);
                int frequenciaDeTres = Collections.frequency(resultados,3);
                int frequenciaDeQuatro = Collections.frequency(resultados, 4);
                int frequenciaDeCinco = Collections.frequency(resultados,5);
                int frequenciaDeSeis = Collections.frequency(resultados,6);

                int ContarDuplas = 0; // Para verificar no if casos de full house onde há uma dupla e uma trinca
                int ContarTrincas = 0;

                int pontuacao = 0;
                
                int soma = dado1.getValor() + dado2.getValor() + dado3.getValor() + dado4.getValor() + dado5.getValor();

                

                switch (frequenciaDeUm) {
                    case 2:
                        System.out.println("Há uma dupla de 1 " + "(+2)");
                        listaPontuacao.add(2);
                        pontuacao++;
                        ContarDuplas++;
                        break;
                    case 3:
                        System.out.println("Há uma trinca de 1 " + "(+" + soma + ")");
                        listaPontuacao.add(soma);
                        pontuacao++;
                        ContarTrincas++;
                        break;
                    case 4:
                        System.out.println("Há uma quadra de 1 " + "(+" + soma + ")");
                        listaPontuacao.add(soma);
                        pontuacao++;
                        break;
                    case 5:
                        System.out.println("Há uma Yahtzee de 1! (+50)");
                        listaPontuacao.add(50);
                        pontuacao++;
                        break;
                    default:
                        break;
                }
                switch (frequenciaDeDois) {
                    case 2:
                        System.out.println("Há uma dupla de 2 " + "(+4)");
                        listaPontuacao.add(4);
                        pontuacao++;
                        ContarDuplas++;
                        break;
                    case 3:
                        System.out.println("Há uma trinca de 2 " + "(+" + soma + ")");
                        listaPontuacao.add(soma);
                        pontuacao++;
                        ContarTrincas++;
                        break;
                    case 4:
                        System.out.println("Há uma quadra de 2 " + "(+" + soma + ")");
                        listaPontuacao.add(soma);
                        pontuacao++;
                        break;
                    case 5:
                        System.out.println("Há uma Yahtzee de 2! (+50)");
                        listaPontuacao.add(50);
                        pontuacao++;
                        break;
                    default:
                        break;
                }
                switch (frequenciaDeTres) {
                    case 2:
                        System.out.println("Há uma dupla de 3 " + "(+6)");
                        listaPontuacao.add(6);
                        pontuacao++;
                        ContarDuplas++;
                        break;
                    case 3:
                        System.out.println("Há uma trinca de 3 " + "(+" + soma + ")");
                        listaPontuacao.add(soma);
                        pontuacao++;
                        ContarTrincas++;
                        break;
                    case 4:
                        System.out.println("Há uma quadra de 3 " + "(+" + soma + ")");
                        listaPontuacao.add(soma);
                        pontuacao++;
                        break;
                    case 5:
                        System.out.println("Há uma Yahtzee de 3! (+50)");
                        listaPontuacao.add(50);
                        pontuacao++;
                        break;
                    default:
                        break;
                }
                switch (frequenciaDeQuatro) {
                    case 2:
                        System.out.println("Há uma dupla de 4 " + "(+8)");
                        listaPontuacao.add(8);
                        pontuacao++;
                        ContarDuplas++;
                        break;
                    case 3:
                        System.out.println("Há uma trinca de 4 " + "(+" + soma + ")");
                        listaPontuacao.add(soma);
                        pontuacao++;
                        ContarTrincas++;
                        break;
                    case 4:
                        System.out.println("Há uma quadra de 4 " + "(+" + soma + ")");
                        listaPontuacao.add(soma);
                        pontuacao++;
                        break;
                    case 5:
                        System.out.println("Há uma Yahtzee de 4! (+50)");
                        listaPontuacao.add(50);
                        pontuacao++;
                        break;
                    default:
                        break;
                }
                switch (frequenciaDeCinco) {
                        case 2:
                        System.out.println("Há uma dupla de 5 " + "(+10)");
                        listaPontuacao.add(10);
                        pontuacao++;
                        ContarDuplas++;
                        break;
                    case 3:
                        System.out.println("Há uma trinca de 5 " + "(+" + soma + ")");
                        listaPontuacao.add(soma);
                        pontuacao++;
                        ContarTrincas++;
                        break;
                    case 4:
                        System.out.println("Há uma quadra de 5 " + "(+" + soma + ")");
                        listaPontuacao.add(soma);
                        pontuacao++;
                        break;
                    case 5:
                        System.out.println("Há uma Yahtzee de 5! (+50)");
                        listaPontuacao.add(50);
                        pontuacao++;
                        break;
                    default:
                        break;
                }
                switch (frequenciaDeSeis) {
                    case 2:
                        System.out.println("Há uma dupla de 6 " + "(+12)");
                        listaPontuacao.add(12);
                        pontuacao++;
                        ContarDuplas++;
                        break;
                    case 3:
                        System.out.println("Há uma trinca de 6 " + "(+" + soma + ")");
                        listaPontuacao.add(soma);
                        pontuacao++;
                        ContarTrincas++;
                        break;
                    case 4:
                        System.out.println("Há uma quadra de 6 " + "(+" + soma + ")");
                        listaPontuacao.add(soma);
                        pontuacao++;
                        break;
                    case 5:
                        System.out.println("Há uma Yahtzee de 6! (+50)");
                        listaPontuacao.add(50);
                        pontuacao++;
                        break;
                    default:
                        break;
                }
                if (ContarDuplas==1){
                    if(ContarTrincas==1){
                        System.out.println("Há um caso de Full House: uma dupla e uma trinca! (+25)");
                        listaPontuacao.add(25);
                        pontuacao++;
                    }
                }
                    
                boolean sequencia1234 = (resultados.get(0) == 1 && resultados.get(1) == 2 && resultados.get(2) == 3 && resultados.get(3) == 4);

                boolean sequencia2345 = (resultados.get(0) == 2 && resultados.get(1) == 3 && resultados.get(2) == 4 && resultados.get(3) == 5);

                boolean sequencia3456 = (resultados.get(0) == 3 && resultados.get(1) == 4 && resultados.get(2) == 5 && resultados.get(3) == 6);

                boolean sequencia12345 = (resultados.get(0) == 1 && resultados.get(1) == 2 && resultados.get(2) == 3 && resultados.get(3) == 4 && resultados.get(4) == 5);

                boolean sequencia23456 = (resultados.get(0) == 2 && resultados.get(1) == 3 && resultados.get(2) == 4 && resultados.get(3) == 5 && resultados.get(4) == 6);

                if (sequencia1234) {
                    System.out.println("Há uma sequência curta: 1, 2, 3, 4! (+30)");
                    listaPontuacao.add(30);
                    pontuacao++;
                }

                if (sequencia2345) {
                    System.out.println("Há uma sequência curta: 2, 3, 4, 5! (+30)");
                    listaPontuacao.add(30);
                    pontuacao++;
                }

                if (sequencia3456) {
                    System.out.println("Há uma sequência curta: 3, 4, 5, 6! (+30)");
                    listaPontuacao.add(30);
                    pontuacao++;
                }

                if (sequencia12345) {
                    System.out.println("Há uma sequência longa: 1, 2, 3, 4, 5! (+40)");
                    listaPontuacao.add(40);
                    pontuacao++;
                }

                if (sequencia23456) {
                    System.out.println("Há uma sequência longa: 2, 3, 4, 5, 6! (+40)");
                    listaPontuacao.add(40);
                    pontuacao++;
                }

                System.out.println("Sorte: soma de todos os dados (+" + soma + ")");
                listaPontuacao.add(soma);
                pontuacao++;

                System.out.println("Onde deseja pontuar?");
                for (int i = 1; i < pontuacao + 1; i++) {
                    System.out.print("(" + i + ") ");
                }
                System.out.print("=> ");

                while (true) {
                    int escolha = scan.nextInt();
                
                    if (escolha >= 1 && escolha <= pontuacao) {
                        int indice = escolha - 1;
                        int pontuacaoEscolhida = listaPontuacao.get(indice);
                        jogadorAtual.adcPontos(pontuacaoEscolhida);
                        System.out.println("Pontuação escolhida: " + pontuacaoEscolhida);
                        break;
                    } 

                    else {
                        System.out.println("Escolha inválida. Tente novamente.");
                    }
                }
                
                if (rodada == 13) {
                    System.out.println("\nFim de Jogo!");
                    for (Jogador jogador : listaJogadores) {
                        System.out.println("Pontuação do Jogador " + jogador.getNome() + ": " + jogador.getPontos());
                    }
                    limparPontuacaoJogadores();
                } else {
                    System.out.println("Fim da rodada ");
                }
            }
        }
    }

    public void limparPontuacaoJogadores() {
        for (Jogador jogador : listaJogadores) {
            jogador.limparPontuacao();
        }
    }

}

