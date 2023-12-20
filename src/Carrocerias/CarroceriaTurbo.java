package Carrocerias;

import Jogo.Tempo;
import Robo.Robo;
import Terreno.Terreno;

public class CarroceriaTurbo extends Carroceria{
    public CarroceriaTurbo(Robo robo, Terreno terreno){
        super(15, robo, terreno);
    }

    public long calculaTempoDescarga(double capacidadeOcupada){
        return Math.round(0.5 * capacidadeOcupada); // Redução de 50% no tempo necessário para descargas
    }

}
