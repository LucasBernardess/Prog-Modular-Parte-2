package Terreno;

public class Celula {

    private double concentracaoDeHelio3;
    private double coeficienteDeErro;
    private double rugosidade;
    private boolean temRoboNessaCelula = false;
    private boolean estaSendoSondadaPorAlgumRobo;
    private int posicaoDaCelulaNoEixoX;
    private int posicaoDaCelulaNoEixoY;


    public Celula(int posicaoDaCelulaNoEixoX, int posicaoDaCelulaNoEixoY){
        this.temRoboNessaCelula = false;
        this.estaSendoSondadaPorAlgumRobo = false;
        this.posicaoDaCelulaNoEixoX = posicaoDaCelulaNoEixoX;
        this.posicaoDaCelulaNoEixoY = posicaoDaCelulaNoEixoY;
    }

    public double getConcentracaoDeHelio3() {
        return concentracaoDeHelio3;
    }

    public void setConcentracaoDeHelio3(double concentracaoDeHelio3) {
        this.concentracaoDeHelio3 = concentracaoDeHelio3;
    }

    public double getCoeficienteDeErro() {
        return coeficienteDeErro;
    }

    public void setCoeficienteDeErro(double coeficienteDeErro) {
        this.coeficienteDeErro = coeficienteDeErro;
    }

    public double getRugosidade() {
        return rugosidade;
    }

    public void setRugosidade(double rugosidade) {
        this.rugosidade = rugosidade;
    }

    public boolean getTemRoboNessaCelula() {
        return temRoboNessaCelula;
    }

    public void setTemRoboNessaCelula(boolean temRoboNessaCelula) {
        this.temRoboNessaCelula = temRoboNessaCelula;
    }

    public boolean isEstaSendoSondadaPorAlgumRobo() {
        return estaSendoSondadaPorAlgumRobo;
    }

    public void setEstaSendoSondadaPorAlgumRobo(boolean estaSendoSondadaPorAlgumRobo) {
        this.estaSendoSondadaPorAlgumRobo = estaSendoSondadaPorAlgumRobo;
    }

    public int getPosicaoDaCelulaNoEixoX(){ return this.posicaoDaCelulaNoEixoX;}

    public int getGetPosicaoDaCelulaNoEixoY(){return this.posicaoDaCelulaNoEixoY;}

    public Celula[] getCelulasAdjacentes(Terreno terreno) {
        int posX = this.posicaoDaCelulaNoEixoX;
        int posY = this.posicaoDaCelulaNoEixoY;

        Celula[][] matrizTerreno = terreno.getMatrizDeCelulas();
        int altura = terreno.getAltura();
        int largura = terreno.getLargura();

        Celula[] celulasAdjacentes = new Celula[4]; // Supondo uma célula com 4 vizinhas

        // Verifique se a célula atual está nas bordas do terreno para calcular as células adjacentes
        if (posY > 0) {
            celulasAdjacentes[0] = matrizTerreno[posY - 1][posX]; // Vizinho superior
        }
        if (posY < altura - 1) {
            celulasAdjacentes[1] = matrizTerreno[posY + 1][posX]; // Vizinho inferior
        }
        if (posX > 0) {
            celulasAdjacentes[2] = matrizTerreno[posY][posX - 1]; // Vizinho à esquerda
        }
        if (posX < largura - 1) {
            celulasAdjacentes[3] = matrizTerreno[posY][posX + 1]; // Vizinho à direita
        }
        return celulasAdjacentes;
    }
}