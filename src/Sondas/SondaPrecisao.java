package Sondas;

import Jogo.Tempo;
import Robo.Robo;
import Terreno.Terreno;

public class SondaPrecisao extends Sonda{


    public SondaPrecisao(Robo robo, Terreno terreno){
        super(robo, terreno);
    }

    public void prospectaHelio() {
        Tempo tempo = new Tempo();
        long segundos = Math.round(terreno.getCelulaNaPosicao(robo.getPosicaoRoboNoEixoY(),
                robo.getPosicaoRoboNoEixoX()).getConcentracaoDeHelio3());
        if (segundos == 0) {
            segundos = 1;
        }
        tempo.sleep(segundos);
        double concentracaoDeHelio = terreno.getCelulaNaPosicao(robo.getPosicaoRoboNoEixoY(),
                robo.getPosicaoRoboNoEixoX()).getConcentracaoDeHelio3();
        robo.setHelioColetadoPeloRobo(robo.getHelioColetadoPeloRobo() + (concentracaoDeHelio ));
        terreno.setConcentracaoDeHelio3NaPosicao(robo.getPosicaoRoboNoEixoY(), robo.getPosicaoRoboNoEixoX(), 0);
    }
}