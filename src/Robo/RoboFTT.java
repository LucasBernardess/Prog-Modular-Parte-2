
package Robo;

import Carrocerias.CarroceriaFortaleza;
import Controladores.ControladorFTT;
import Jogo.Tempo;
import Sondas.SondaAltaCapacidade;
import Terreno.Celula;
import Terreno.Terreno;
import Controladores.Controlador;
import Carrocerias.Carroceria;
import Sondas.Sonda;
import java.util.Random;

public class RoboFTT extends Robo {

    public RoboFTT(Terreno terreno) {
        super(terreno);
        this.controlador = new ControladorFTT(terreno, this);
        this.sonda = new SondaAltaCapacidade(this, terreno);
        this.carroceria = new CarroceriaFortaleza(this, terreno);
    }

    public double capacidadeDeCarga() {
        return super.getHelioColetadoPeloRobo() * 3;
    }

    public void deteccaoConcentracaoHelio(Terreno terreno) {
        Celula celulaAtual = terreno.getCelulaNaPosicao(getPosicaoRoboNoEixoY(), getPosicaoRoboNoEixoX());
        double concentracao = celulaAtual.getConcentracaoDeHelio3();

        if (Math.random() < 0.25) {
            double erro = (Math.random() - 0.5) * 0.5;
            concentracao += concentracao * erro;
        }

        System.out.println("Concentração de Hélio-3: " + concentracao);
    }

    public void imprimirInformacoes() {
        System.out.println("Nome do Robô: " + getNomeRobo());
        System.out.println("Posição atual: (" + getPosicaoRoboNoEixoX() + ", " + getPosicaoRoboNoEixoY() + ")");
        System.out.println("Quantidade de Hélio-3 coletado: " + getHelioColetadoPeloRobo());
        System.out.println("Capacidade de carga restante: " + capacidadeDeCarga());
    }
}
