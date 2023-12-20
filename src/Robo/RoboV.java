package Robo;

import Carrocerias.CarroceriaNavegacaoAvancada;
import Controladores.ControladorV;
import Jogo.Tempo;
import Sondas.SondaPrecisao;
import Terreno.Celula;
import Terreno.Terreno;
import Controladores.Controlador;
import Carrocerias.Carroceria;
import Sondas.Sonda;
import java.util.Random;

public class RoboV extends Robo {

    public RoboV(Terreno terreno) {
        super(terreno);
        this.controlador = new ControladorV(terreno, this);
        this.sonda = new SondaPrecisao(this,terreno);
        this.carroceria = new CarroceriaNavegacaoAvancada(this, terreno);

    }

    public void deteccaoConcentracaoHelio(Terreno terreno) {
        Celula celulaAtual = terreno.getCelulaNaPosicao(getPosicaoRoboNoEixoY(), getPosicaoRoboNoEixoX());
        double concentracao = celulaAtual.getConcentracaoDeHelio3();

        if (Math.random() < 0.25) {
            double erro = (Math.random() - 0.5) ;
            concentracao += concentracao * erro;
        }

        System.out.println("Concentração de Hélio-3: " + concentracao);
    }

    public void imprimirInformacoes() {
        System.out.println("Nome do Robô: " + getNomeRobo());
        System.out.println("Posição atual: (" + getPosicaoRoboNoEixoX() + ", " + getPosicaoRoboNoEixoY() + ")");
        System.out.println("Quantidade de Hélio-3 coletado: " + getHelioColetadoPeloRobo());
        System.out.println("Capacidade de carga ocupada: " + carroceria.getCapacidadeOcupada());
    }
}
