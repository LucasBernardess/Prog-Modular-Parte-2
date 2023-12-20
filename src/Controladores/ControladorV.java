package Controladores;

import java.util.*;

import Jogo.Tempo;
import Robo.Robo;
import Terreno.Terreno;
import Terreno.Celula;
import Controladores.Caminho;

public class ControladorV extends Controlador {

    private Celula destinoAlvo;
    private Caminho melhorCaminho;
    private Set<Celula> visitados;

    public ControladorV(Terreno terreno, Robo robo) {
        super(terreno, robo);
        this.visitados = new HashSet<>();
    }

    public void movimentarRobo() {
        if (destinoAlvo == null) {
            destinoAlvo = encontrarRegiaoMaiorConcentracao();
        }
        if (destinoAlvo != null) {
            if (melhorCaminho == null) {
                melhorCaminho = encontrarMelhorCaminhoParaCelula(destinoAlvo);
            }
            if (melhorCaminho != null && !melhorCaminho.getCaminho().isEmpty()) {
                Celula proximaCelula = melhorCaminho.getCaminho().poll();
                robo.getSonda().prospectaHelio();
                movimentarRoboParaCelula(proximaCelula);
            } else {
                finalizarMovimentoRobo();
            }
        } else {
            robo.getCarroceria().descarregaHelio();
            finalizarMovimentoRobo();
        }
    }

    private void finalizarMovimentoRobo() {
        this.destinoAlvo = null;
        this.melhorCaminho = null;
        this.visitados.clear();
    }

    private Celula encontrarRegiaoMaiorConcentracao() {
        Celula[][] mapa = terreno.getMapa();

        Celula celulaComMaiorConcentracao = null;
        double maiorConcentracao = -1;

        for (int i = 0; i < terreno.getAltura(); i++) {
            for (int j = 0; j < terreno.getLargura(); j++) {
                Celula celulaAtual = mapa[i][j];
                if (!visitados.contains(celulaAtual) &&
                        celulaAtual.getConcentracaoDeHelio3() > maiorConcentracao) {
                    maiorConcentracao = celulaAtual.getConcentracaoDeHelio3();
                    celulaComMaiorConcentracao = celulaAtual;
                }
            }
        }

        return celulaComMaiorConcentracao;
    }

    private Caminho encontrarMelhorCaminhoParaCelula(Celula destino) {
        Celula origem = this.robo.getPosicaoAtual();

        Queue<Caminho> fila = new LinkedList<>();
        visitados.clear();

        Caminho caminhoInicial = new Caminho();
        caminhoInicial.getCaminho().add(origem);
        fila.add(caminhoInicial);
        visitados.add(origem);

        while (!fila.isEmpty()) {
            Caminho caminhoAtual = fila.poll();
            Celula celulaAtual = caminhoAtual.getCaminho().peek();

            if (celulaAtual.equals(destino)) {
                return caminhoAtual;
            }

            Celula[] celulasAdjacentes = celulaAtual.getCelulasAdjacentes(terreno);
            for (Celula vizinha : celulasAdjacentes) {
                if (vizinha != null && !visitados.contains(vizinha)) {
                    visitados.add(vizinha);
                    Caminho novoCaminho = new Caminho(new LinkedList<>(caminhoAtual.getCaminho()));
                    novoCaminho.getCaminho().add(vizinha);
                    fila.add(novoCaminho);
                }
            }
        }
        return null;
    }

    private void movimentarRoboParaCelula(Celula destino) {
        Caminho caminhoParaDestino = encontrarMelhorCaminhoParaCelula(destino);

        if (caminhoParaDestino != null && !caminhoParaDestino.getCaminho().isEmpty()) {
            while (!caminhoParaDestino.getCaminho().isEmpty()) {
                Celula proximaCelula = caminhoParaDestino.getCaminho().poll();
                moverRoboParaCelula(proximaCelula);
                robo.getSonda().prospectaHelio();
            }
        }
    }

    private void moverRoboParaCelula(Celula celula) {
        int posY = celula.getGetPosicaoDaCelulaNoEixoY();
        int posX = celula.getPosicaoDaCelulaNoEixoX();

        this.robo.setPosicaoRoboNoEixoY(posY);
        this.robo.setPosicaoRoboNoEixoX(posX);

        celula.setTemRoboNessaCelula(true);
    }
}
