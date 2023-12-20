package Terreno;
import java.util.Arrays;

public class Terreno {
    private int alturaDoTerreno;
    private int larguraDoTerreno;
    private Celula[][] terreno;

    public Terreno(int altura, int largura) {
        this.alturaDoTerreno = altura;
        this.larguraDoTerreno = largura;
        this.terreno = new Celula[altura][largura];

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                this.terreno[i][j] = new Celula(i,j);
            }
        }
    }

    public int getAltura() {
        return alturaDoTerreno;
    }

    public void setAltura(int altura) {
        this.alturaDoTerreno = altura;
    }

    public int getLargura() {
        return larguraDoTerreno;
    }

    public void setLargura(int largura) {
        this.larguraDoTerreno = largura;
    }

    public Celula[][] getMatrizDeCelulas() {
        return terreno;
    }

    public void setMatrizDeCelulas(Celula[][] matrizDeCelulas) {
        this.terreno = matrizDeCelulas;
    }

    public Celula getCelulaNaPosicao(int posicaoY, int posicaoX) {
        if (posicaoY < 0 || posicaoY >= alturaDoTerreno || posicaoX < 0 || posicaoX >= larguraDoTerreno) {
            throw new IllegalArgumentException("Posição inválida no terreno.");
        }
        return terreno[posicaoY][posicaoX];
    }

    public void setConcentracaoDeHelio3NaPosicao(int posicaoY, int posicaoX, double valorConcentracaoHelio) {
        if (posicaoY < 0 || posicaoY >= alturaDoTerreno || posicaoX < 0 || posicaoX >= larguraDoTerreno) {
            throw new IllegalArgumentException("Posição inválida no terreno.");
        }

        terreno[posicaoY][posicaoX].setConcentracaoDeHelio3(valorConcentracaoHelio);
    }

    public Celula[][] getCelulasAdjacentes(int posicaoY, int posicaoX) {
        int minY = Math.max(0, posicaoY - 1);
        int maxY = Math.min(alturaDoTerreno - 1, posicaoY + 1);
        int minX = Math.max(0, posicaoX - 1);
        int maxX = Math.min(larguraDoTerreno - 1, posicaoX + 1);

        Celula[][] celulasAdjacentes = new Celula[maxY - minY + 1][maxX - minX + 1];

        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                celulasAdjacentes[i - minY][j - minX] = terreno[i][j];
            }
        }

        return celulasAdjacentes;
    }

    public Celula getCelula(int posicaoY, int posicaoX) {
        if (posicaoY < 0 || posicaoY >= alturaDoTerreno || posicaoX < 0 || posicaoX >= larguraDoTerreno) {
            throw new IllegalArgumentException("Posição inválida no terreno.");
        }
        return terreno[posicaoY][posicaoX];
    }

    public Celula[][] getMapa() {
        return terreno;
    }

    @Override
    public String toString() {
        return "Terreno{" +
                "altura=" + alturaDoTerreno +
                ", largura=" + larguraDoTerreno +
                ", matrizDeCelulas=" + Arrays.deepToString(terreno) +
                '}';
    }
}