package Yahtzee.Game;

public class Jogador  {

    private String nome;
    private int pontos;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void adcPontos(int pontos) {
        this.pontos += pontos;
    }

    public void limparPontuacao() {
        this.pontos = 0;
    }

    public String toString() {
        return nome;
    }
}