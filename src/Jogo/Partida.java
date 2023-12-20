package Jogo;

import java.util.ArrayList;
import java.util.List;
import Robo.*;
import Terreno.Terreno;
import java.util.Random;

public class Partida{
    public List<Equipe> equipes;
    public long duracaoPartida;

    public Partida(int tempo){
        this.equipes = new ArrayList<>();
        this.duracaoPartida = tempo;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }
    public long getDuracao(){
        return duracaoPartida;
    }

    public void finalDaPartida() {
        System.out.println("Classificação Final:\n");

        for (Equipe equipe : equipes) {
            System.out.println("Equipe -> " + equipe.getNomeEquipe());
            System.out.println("Pontuação total -> " + equipe.getPontuacaoEquipe());
            System.out.println("Robos:");

            for (Robo robo : equipe.getRobos()) {
                System.out.println("Nome -> " + robo.getNomeRobo());
                System.out.println("Pontuação -> " + robo.getHelioColetadoPeloRobo());
            }

            System.out.println("\n");
        }
    }

    public void gameplay(Terreno mapa){
        for(Equipe equipe : this.getEquipes()){
            equipe.criarRobos(mapa);
        }

        Tempo tempoDejogo = new Tempo();
        tempoDejogo.setTempoInicial();

        int quantidadeEquipes = this.equipes.size();
        int quantidadeRobos = this.equipes.get(0).getQuantidadeRobos();
        System.out.println("----------------------------INICIO DO JOGO----------------------------\n");

        do {
            for (int indiceRobos = 0; indiceRobos < quantidadeRobos; indiceRobos++) {
                for (int indiceEquipe = 0; indiceEquipe < quantidadeEquipes; indiceEquipe++) {
                    this.equipes.get(indiceEquipe).getRobos().get(indiceRobos).controlador.movimentarRobo();
                    int posicaoX = this.equipes.get(indiceEquipe).getRobos().get(indiceRobos).getPosicaoRoboNoEixoX();
                    int posicaoY = this.equipes.get(indiceEquipe).getRobos().get(indiceRobos).getPosicaoRoboNoEixoY();

                    double helio3NaCelula = mapa.getCelulaNaPosicao(posicaoY, posicaoX).getConcentracaoDeHelio3();

                    System.out.println("Equipe -> " + this.equipes.get(indiceEquipe).getNomeEquipe());
                    System.out.println("Robo -> " + this.equipes.get(indiceEquipe).getRobos().get(indiceRobos).getNomeRobo());
                    System.out.println("Posicao -> x: " + posicaoX + "\ty: " + posicaoY);
                    System.out.println("Helio3 na célula -> " + helio3NaCelula);
                    System.out.println("Rugosidade na célula -> " + mapa.getCelulaNaPosicao(posicaoY, posicaoX).getRugosidade());
                    System.out.println("Helio3 coletado pelo robo -> " +
                            String.format("%.2f", this.equipes.get(indiceEquipe).
                                    getRobos().get(indiceRobos).getHelioColetadoPeloRobo()));
                    System.out.println("Helio3 coletado pela equipe -> " +
                            String.format("%.2f", this.equipes.get(indiceEquipe).getPontuacaoEquipe()));
                    System.out.println("\n");
                }
            }

            tempoDejogo.setTempoFinal();

        }while(this.getDuracao() > tempoDejogo.DuracaoDoJogo());

        System.out.println("\n----------------------------FIM DO JOGO---------------------------");
    }


    public void adicionarEquipe(Equipe equipe) {
        equipes.add(equipe);
    }
}

