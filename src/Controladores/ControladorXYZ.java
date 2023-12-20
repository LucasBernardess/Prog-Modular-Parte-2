package Controladores;

import Jogo.Tempo;
import Robo.Robo;
import Terreno.Terreno;

public class ControladorXYZ extends Controlador {

    private int direcaoDoRobo;

    public ControladorXYZ(Robo robo, Terreno terreno) {
        super(terreno, robo);
        this.direcaoDoRobo = 0;
    }

    public void movimentarRobo() {
        int novaPosicaoX = this.robo.getPosicaoRoboNoEixoX();
        int novaPosicaoY = this.robo.getPosicaoRoboNoEixoY();

        this.terreno.getCelulaNaPosicao(novaPosicaoY, novaPosicaoX).setTemRoboNessaCelula(false);

        for (int i = 0; i < 4; i++) {
            if (this.direcaoDoRobo == 0) {
                novaPosicaoY = this.robo.getPosicaoRoboNoEixoY() + 1;
            } else if (this.direcaoDoRobo == 1) {
                novaPosicaoX = this.robo.getPosicaoRoboNoEixoX() + 1;
            } else if (this.direcaoDoRobo == 2) {
                novaPosicaoY = this.robo.getPosicaoRoboNoEixoY() - 1;
            } else if (this.direcaoDoRobo == 3) {
                novaPosicaoX = this.robo.getPosicaoRoboNoEixoX() - 1;
            }

            if (novaPosicaoY >= 0 && novaPosicaoY < terreno.getAltura() &&
                    novaPosicaoX >= 0 && novaPosicaoX < terreno.getLargura()) {

                if (!terreno.getCelulaNaPosicao(novaPosicaoY, novaPosicaoX).getTemRoboNessaCelula()) {
                    long rugosidade = Math.round(terreno.getCelulaNaPosicao
                            (novaPosicaoY, novaPosicaoX).getRugosidade());
                    Tempo time = new Tempo();
                    time.sleep(rugosidade * 5);

                    this.robo.setPosicaoRoboNoEixoX(novaPosicaoX);
                    this.robo.setPosicaoRoboNoEixoY(novaPosicaoY);
                    terreno.getCelulaNaPosicao(novaPosicaoY, novaPosicaoX).setTemRoboNessaCelula(true);
                    this.robo.getSonda().prospectaHelio();
                    break;
                }
            }

            this.direcaoDoRobo = (this.direcaoDoRobo + 1) % 4;
        }
    }
}

