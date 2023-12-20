package Jogo;

public class Tempo {
    private long tempoInicial;
    private long tempoFinal;

    public Tempo(){
        this.tempoInicial = 0;
        this.tempoFinal = 0;
    }

    public void setTempoInicial() {
        this.tempoInicial = System.currentTimeMillis();
    }

    public long getTempoInicial() {
        return tempoInicial;
    }

    public void setTempoFinal() {
        this.tempoFinal = System.currentTimeMillis();
    }

    public long getTempoFinal() {
        return tempoFinal;
    }

    public long DuracaoDoJogo(){
        setTempoFinal();
        return (tempoFinal - tempoInicial);
    }

    public void sleep(long segundos){
        segundos = segundos*1000;

        try {
            Thread.sleep(segundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}