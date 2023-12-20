package Robo;

import Carrocerias.CarroceriaTurbo;
import Controladores.ControladorXYZ;
import Jogo.Tempo;
import Sondas.SondaPerfuracaoRapida;
import Terreno.Celula;
import Terreno.Terreno;
import Controladores.Controlador;
import Carrocerias.Carroceria;
import Sondas.Sonda;
import java.util.Random;

public class RoboXYZ extends Robo {

    public RoboXYZ(Terreno terreno) {
        super(terreno);
        this.controlador = new ControladorXYZ(this,terreno);
        this.sonda = new SondaPerfuracaoRapida(this,terreno);
        this.carroceria = new CarroceriaTurbo(this, terreno);
    }

    public double capacidadeDeCarga() {
        return super.getHelioColetadoPeloRobo() / 2;
    }

    public void deteccaoConcentracaoHelio(Terreno terreno) {
        Celula celulaAtual = terreno.getCelulaNaPosicao(getPosicaoRoboNoEixoY(), getPosicaoRoboNoEixoX());
        double concentracao = celulaAtual.getConcentracaoDeHelio3();

        if (Math.random() < 0.25) {
            double erro = (Math.random() - 0.5) * 2;
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