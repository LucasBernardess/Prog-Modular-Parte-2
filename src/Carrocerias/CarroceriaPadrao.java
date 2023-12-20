package Carrocerias;

import Jogo.Tempo;
import Robo.Robo;
import Terreno.Terreno;

public class CarroceriaPadrao extends Carroceria{
    public CarroceriaPadrao(Robo robo, Terreno terreno){
        super(10, robo, terreno);
    }

    public long calculaTempoDescarga(double capacidadeOcupada){
        return Math.round(capacidadeOcupada); 
    }

}
