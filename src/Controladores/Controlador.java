package Controladores;

import Jogo.Tempo;
import Robo.Robo;
import Terreno.Terreno;

public abstract class Controlador {
    protected Robo robo;
    protected Terreno terreno;
    protected int direcaoDoRobo;

    public Controlador(Terreno terreno, Robo robo) {
        this.direcaoDoRobo = 0;
        this.terreno = terreno;
        this.robo = robo;
    }

    public abstract void movimentarRobo();
}
