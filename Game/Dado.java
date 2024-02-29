package Yahtzee.Game;

import java.util.Random;

public class Dado {
    
    private int valorFace;

    public void rolar() {
        Random gerador = new Random();
        valorFace = gerador.nextInt(6) + 1;
    }

    public int getValor() {
        return valorFace;
    }
}
