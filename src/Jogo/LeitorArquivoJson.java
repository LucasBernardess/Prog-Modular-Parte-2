package Jogo;

import Terreno.Terreno;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivoJson {

    public static Terreno lerArquivoTerreno(String caminhoArquivo) {
        try (FileReader readerTerreno = new FileReader(caminhoArquivo)) {
            Gson gson = new Gson();
            return gson.fromJson(readerTerreno, Terreno.class);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + caminhoArquivo);
            throw new RuntimeException("Erro na leitura do arquivo do terreno.", e);
        } catch (IOException e) {
            System.err.println("Erro de leitura do arquivo: " + caminhoArquivo);
            throw new RuntimeException("Erro na leitura do arquivo do terreno.", e);
        }
    }

    public static Partida lerArquivoConfiguracao(String caminhoArquivo) {
        try (FileReader readerJogo = new FileReader(caminhoArquivo)) {
            Gson gson = new Gson();
            return gson.fromJson(readerJogo, Partida.class);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + caminhoArquivo);
            throw new RuntimeException("Erro na leitura do arquivo de configuração da partida.", e);
        } catch (IOException e) {
            System.err.println("Erro de leitura do arquivo: " + caminhoArquivo);
            throw new RuntimeException("Erro na leitura do arquivo de configuração da partida.", e);
        }
    }

}