package Controladores;
import Terreno.Terreno;
import Terreno.Celula;

import java.util.LinkedList;

public class Caminho {
    private LinkedList<Celula> caminho;

    public Caminho() {
        this.caminho = new LinkedList<>();
    }

    public Caminho(LinkedList<Celula> caminho) {
        this.caminho = caminho;
    }

    public LinkedList<Celula> getCaminho() {
        return caminho;
    }

    public void setCaminho(LinkedList<Celula> caminho) {
        this.caminho = caminho;
    }
}
