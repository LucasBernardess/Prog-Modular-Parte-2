package Carrocerias;

import Jogo.Tempo;
import Robo.Robo;

public abstract class Carroceria{
    private double capacidadeMaxima;
    private double capacidadeOcupada;
    protected Robo robo;
    protected Terreno terreno;

    public Carroceria(double capacidadeMaxima, Robo robo, Terreno terreno) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.capacidadeOcupada = 0;
        this.robo = robo;
        this.terreno = terreno;
    }
    public double getCapacidadeMaxima() {

        return capacidadeMaxima;
    }
    public double getCapacidadeOcupada() {

        return capacidadeOcupada;
    }
    public void setCapacidadeMaxima(double capacidadeMaxima) {

        this.capacidadeMaxima = capacidadeMaxima;
    }
    public void setCapacidadeOcupada(double capacidadeOcupada) {

        this.capacidadeOcupada = capacidadeOcupada;
    }
    public abstract long calculaTempoDescarga();
    public void descarregaHelio(){
        Tempo tempo = new Tempo();
        tempo.sleep(calculaTempoDescarga(capacidadeOcupada));
        setCapacidadeOcupada(0);
    }

}
