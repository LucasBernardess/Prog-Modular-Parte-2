package Jogo;

import Robo.*;
import Terreno.Terreno;
import java.util.ArrayList;
import java.util.List;

public class Equipe{
    private String nomeEquipe;
    private List<Robo> robos;
    private List<String> tiposRobos;
    private double pontuacaoEquipe;

    public Equipe(String nome) {
        this.nomeEquipe = nome;
        this.tiposRobos = new ArrayList<>();
        this.pontuacaoEquipe = 0;
    }

    public String getNomeEquipe(){
        return nomeEquipe;
    }

    public List<Robo> getRobos() {
        if(robos != null){
            return new ArrayList<>(robos);
        }else{
            return new ArrayList<>();
        }
    }

    public int getQuantidadeRobos() {return robos.size();}

    public void somarPontuacao(){
        this.pontuacaoEquipe = 0;
        for (Robo robo : robos) {
            this.pontuacaoEquipe += robo.getHelioColetadoPeloRobo();
        }
    }

    public double getPontuacaoEquipe(){
        somarPontuacao();
        return pontuacaoEquipe;
    }

    public void adicionarRobo(Robo robo) {
        if (this.robos == null) {
            this.robos = new ArrayList<>();
        }
        robos.add(robo);
    }

    public void adicionarTipos(String tipoRobo) {
        tiposRobos.add(tipoRobo);
    }

    public void setRobos(List<Robo> listaRobos) {
        this.robos = listaRobos;
    }

    public List<String> getTiposRobos() {
        return tiposRobos;
    }

    public void criarRobos(Terreno terreno){
        this.robos = new ArrayList<>();
        Robo robo;
        for (String tipoRobo : tiposRobos) {
            if (tipoRobo.equals("XYZ")) {
                robo = new RoboXYZ(terreno);
                adicionarRobo(robo);
            }else if(tipoRobo.equals("FTT")){
                robo = new RoboFTT(terreno);
                adicionarRobo(robo);
            }else if(tipoRobo.equals("V")){
                robo = new RoboV(terreno);
                adicionarRobo(robo);
            }

        }
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "nomeEquipe='" + nomeEquipe + '\'' +
                ", robos=" + robos +
                ", pontuacaoEquipe=" + pontuacaoEquipe +
                '}';
    }
}