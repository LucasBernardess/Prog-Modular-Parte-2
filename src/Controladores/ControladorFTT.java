package Controladores;

import Robo.Robo;
import Terreno.Terreno;
import Terreno.Celula;
public class ControladorFTT extends Controlador {

    public ControladorFTT(Terreno terreno, Robo robo) {
        super(terreno, robo);
    }

    public void movimentarRobo() {
        if (robo.carroceria.getCapacidadeOcupada() < robo.carroceria.getCapacidadeMaxima() * 0.8) {
            Celula celulaAdjacenteComMaiorHelio = encontrarCelulaAdjacenteComMaiorHelio();

            if (celulaAdjacenteComMaiorHelio != null) {
                celulaAdjacenteComMaiorHelio.setEstaSendoSondadaPorAlgumRobo(true);
            } else {
                moverParaCelulaAdjacenteComMaiorHelio();
            }
        } else {
            robo.carroceria.descarregaHelio();
        }
    }

    private Celula encontrarCelulaAdjacenteComMaiorHelio() {
        Celula[][] celulasAdjacentes = terreno.getCelulasAdjacentes(robo.getPosicaoRoboNoEixoY(),
                robo.getPosicaoRoboNoEixoX());

        Celula melhorCelula = null;
        double maiorConcentracao = -1;

        for (Celula[] linha : celulasAdjacentes) {
            for (Celula celula : linha) {
                if (celula != null && !celula.getTemRoboNessaCelula() &&
                        !celula.isEstaSendoSondadaPorAlgumRobo()) {
                    if (celula.getConcentracaoDeHelio3() > maiorConcentracao) {
                        maiorConcentracao = celula.getConcentracaoDeHelio3();
                        melhorCelula = celula;
                    }
                }
            }
        }

        if (melhorCelula != null) {
            int posY = melhorCelula.getPosicaoDaCelulaNoEixoX();
            int posX = melhorCelula.getGetPosicaoDaCelulaNoEixoY();

            if (posY >= 0 && posY < terreno.getAltura() && posX >= 0 && posX < terreno.getLargura()) {
                return melhorCelula;
            }
        }

        return null;
    }

    private void moverParaCelulaAdjacenteComMaiorHelio() {
        Celula melhorCelula = encontrarCelulaAdjacenteComMaiorHelio();

        if (melhorCelula != null) {
            int posY = melhorCelula.getPosicaoDaCelulaNoEixoX();
            int posX = melhorCelula.getGetPosicaoDaCelulaNoEixoY();

            if (posY >= 0 && posY < terreno.getAltura() && posX >= 0 && posX < terreno.getLargura()) {
                robo.setPosicaoRoboNoEixoY(posY);
                robo.setPosicaoRoboNoEixoX(posX);
            }
        }

        robo.getSonda().prospectaHelio();
    }
}
