package Yahtzee.Game;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Sistema {
    

    private ArrayList<Jogador> listaJogador = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private String novoNome;


    public void inicializarJogadores() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Nomes.txt"))) {
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                Jogador jogador = new Jogador(linha.trim());
                listaJogador.add(jogador);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }


    public void cadastrarJogador(String nome) {
        System.out.print("\nDigite o nome: ");
        nome = scan.nextLine();
        for (Jogador jogador : listaJogador) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Este jogador já existe.");
                return;
            }
        }


        Jogador jogador = new Jogador(nome);
        listaJogador.add(jogador);

        try (FileWriter fileWriter = new FileWriter("Nomes.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(nome);
                bufferedWriter.newLine();
            } catch (IOException e) {
                System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            }

        System.out.println("Jogador cadastrado com sucesso!");
    }

    private void removerJogadorDoArquivo(String nome) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Nomes.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Nomes_temp.txt"))) {
    
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                if (!linha.trim().equalsIgnoreCase(nome.trim())) {
                    bufferedWriter.write(linha);
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler/escrever no arquivo: " + e.getMessage());
        }
    
        File arquivoOriginal = new File("Nomes.txt");
        File arquivoTemporario = new File("Nomes_temp.txt");
        arquivoOriginal.delete();
        arquivoTemporario.renameTo(arquivoOriginal);
    }

    public void limparListaJogadores() {
        listaJogador.clear();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Nomes.txt", false))) {
            // Limpa o conteúdo do arquivo
        } catch (IOException e) {
            System.err.println("Erro ao limpar o arquivo: " + e.getMessage());
        }
    }

    public void listar() {
        for (Jogador jogador : listaJogador) {
            System.out.println(jogador);
        }
    }

    public ArrayList<Jogador> getListaJogador() {
        return listaJogador;
    }

    public void gerenciarJogadores(String nome) {
        System.out.print("=> ");
        int opcao = scan.nextInt();
        scan.nextLine();
        switch (opcao) {

            case 1:
                System.out.print("\nDigite o nome que deseja alterar: ");

                nome = scan.nextLine();
                System.out.println(nome);
                for (Jogador jogador : listaJogador) {
                    System.out.println(jogador);
                    if (jogador.getNome().trim().equalsIgnoreCase(nome.trim())) {
                        System.out.print("Digite o novo nome: ");
                        novoNome = scan.nextLine();

                        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Nomes.txt"));
                            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Nomes_temp.txt"))) {
                                String linha;
                                while ((linha = bufferedReader.readLine()) != null) {
                                    if (linha.trim().equalsIgnoreCase(nome.trim())) {
                                        linha = novoNome;
                                        jogador.setNome(novoNome);
                                    }
                                    bufferedWriter.write(linha);
                                    bufferedWriter.newLine();
                                }
                        } catch (IOException e) {
                                System.err.println("Erro ao ler/escrever no arquivo: " + e.getMessage());
                        }

                        File arquivoOriginal = new File("Nomes.txt");
                        File arquivoTemporario = new File("Nomes_temp.txt");
                        arquivoOriginal.delete();
                        arquivoTemporario.renameTo(arquivoOriginal);
                        System.out.println("Nome alterado com sucesso!");
                        break;
                    }else {
                        System.out.println("Jogador não encontrado!");
                        break;
                    }
                }
                break;

                case 2:
                System.out.print("\nDigite o nome que deseja apagar: ");
                nome = scan.nextLine();
                Iterator<Jogador> iteratorRemocao = listaJogador.iterator();
                while (iteratorRemocao.hasNext()) {
                    Jogador jogador = iteratorRemocao.next();
                    if (jogador.getNome().equalsIgnoreCase(nome)) {
                        iteratorRemocao.remove();
                        removerJogadorDoArquivo(nome); // Chama o método para remover do arquivo
                        System.out.println("Jogador apagado com sucesso!");
                        break;
                    }else {
                        // System.out.println("Jogador não encontrado!");
                    }
                }
                break;

            case 3:
                System.out.println("\nApagando todos os jogadores...");
                limparListaJogadores();
                System.out.println("Todos os jogadores foram apagados.");                      
                break;

            case 0:
                break;
        
            default:
                System.out.println("Valor inválido!");
                break;
        }
    }

}
