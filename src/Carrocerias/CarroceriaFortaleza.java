package Carrocerias;

import Jogo.Tempo;
import Robo.Robo;
import Terreno.Terreno;

public class CarroceriaFortaleza extends Carroceria{
    public CarroceriaFortaleza(Robo robo, Terreno terreno){
        super(30, robo, terreno);
    }

    public long calculaTempoDescarga(double capacidadeOcupada){
        long capacidade = Math.round(capacidadeOcupada);
        return capacidade;
    }

}
