import Jogo.Partida;
import Jogo.Tempo;
import Terreno.Terreno;
import Jogo.LeitorArquivoJson;
import Jogo.Equipe;
import Robo.Robo;

public class Main {
    public static void main(String[] args) {

        Terreno mapa = LeitorArquivoJson.lerArquivoTerreno("src/terreno.json");
        Partida configuracao = LeitorArquivoJson.lerArquivoConfiguracao("src/config.json");

        configuracao.gameplay(mapa);

        configuracao.finalDaPartida();

    }
}