package Robo;

import Jogo.Tempo;
import Terreno.Celula;
import Terreno.Terreno;
import Controladores.Controlador;
import Carrocerias.Carroceria;
import Sondas.Sonda;
import java.util.Random;

public abstract class Robo {
    protected String nomeRobo;
    protected Terreno terreno;
    protected int posicaoRoboNoEixoX;
    protected int posicaoRoboNoEixoY;
    protected double helioColetadoPeloRobo;
    public Controlador controlador;
    public Carroceria carroceria;
    public Sonda sonda;

    public Robo(Terreno terreno) {
        Random rand = new Random();
        this.nomeRobo = geraNomeAleatório();
        this.terreno = terreno;
        this.posicaoRoboNoEixoX = rand.nextInt(terreno.getLargura());
        this.posicaoRoboNoEixoY = rand.nextInt(terreno.getAltura());
        this.helioColetadoPeloRobo = 0;
    }

    public String getNomeRobo() {
        return nomeRobo;
    }

    public int getPosicaoRoboNoEixoX() {
        return posicaoRoboNoEixoX;
    }

    public void setPosicaoRoboNoEixoX(int novaPosicaoX){
        this.posicaoRoboNoEixoX = novaPosicaoX;
    }

    public int getPosicaoRoboNoEixoY() {
        return posicaoRoboNoEixoY;
    }

    public void setPosicaoRoboNoEixoY(int novaPosicaoY){
        this.posicaoRoboNoEixoY = novaPosicaoY;
    }

    public double getHelioColetadoPeloRobo() {
        return helioColetadoPeloRobo;
    }

    public void setHelioColetadoPeloRobo(double helioColetadoPeloRobo) {
        this.helioColetadoPeloRobo = helioColetadoPeloRobo;
    }

    public void imprimeConcentracaoDeHelio3NaCelula(Celula celula){
        System.out.println("Concentração: " + celula.getConcentracaoDeHelio3());
    }

    public void imprimePosicaoDaCelula(){
        System.out.println("O Robo está nas coordenadas" + getPosicaoRoboNoEixoX() + getPosicaoRoboNoEixoY());
    }

    public void imprimeRugosidadeDaCelula(Celula celula){
        System.out.println("A rugosidade da celula é: " + celula.getRugosidade());
    }

    public int verificaSondasVizinhas(Terreno terreno){
        return 0;
    }

    public void tempoDaPartida(Tempo tempo){
        System.out.println("Tempo de partida -> " + tempo.DuracaoDoJogo()/1000);
    }

    public Sonda getSonda(){return this.sonda;}

    public Celula getPosicaoAtual() {
        return terreno.getCelulaNaPosicao(posicaoRoboNoEixoY, posicaoRoboNoEixoX);
    }

    public Carroceria getCarroceria(){return this.carroceria;}

    private String geraNomeAleatório() {
        String[] names = {"Alpha", "Beta", "Gamma", "Delta", "Omega", "Sigma", "Theta", "Zeta"};
        Random random = new Random();
        return names[random.nextInt(names.length)] + "_" + random.nextInt(1000);
    }
}