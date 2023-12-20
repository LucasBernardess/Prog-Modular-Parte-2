package Sondas;

import Jogo.Tempo;
import Robo.Robo;
import Terreno.Terreno;

public abstract class Sonda{

    protected Robo robo;
    protected Terreno terreno;

    public Sonda(Robo robo, Terreno terreno){
        this.robo = robo;
        this.terreno = terreno;
    }

    public abstract void prospectaHelio();

}
