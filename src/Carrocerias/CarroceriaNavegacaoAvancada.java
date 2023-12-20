package Carrocerias;

import Jogo.Tempo;
import Robo.Robo;
import Terreno.Terreno;

public class CarroceriaNavegacaoAvancada extends Carroceria{
    public CarroceriaNavegacaoAvancada(Robo robo, Terreno terreno){
        super(1.5 * 15, robo, terreno);
    }

    public long calculaTempoDescarga(double capacidadeOcupada){

        return Math.round(0.75 * capacidadeOcupada);
    }

}