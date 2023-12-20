import Carrocerias.CarroceriaTurbo;
import Robo.Robo;
import Terreno.Terreno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarroceriaTurboTest {
    private CarroceriaTurbo carroceria;
    private Terreno terreno;
    private Robo robo;

    @BeforeEach
    public void setUp() {
        terreno = new Terreno(5, 5); // Terreno 5x5 para teste
        robo = new Robo("Nome do Robô", terreno); // Criando um Robo fictício para teste
        carroceria = new CarroceriaTurbo(robo, terreno);
    }

    @Test
    public void testCalculaTempoDescarga() {
        // Definindo um valor de capacidade ocupada para o teste
        double capacidadeOcupada = 10;
        double metadeCapacidadeOcupada = this.capacidadeOcupada * 0,5;
        
        // Calculando o tempo de descarga com a capacidade ocupada definida
        long tempoDescarga = carroceria.calculaTempoDescarga(capacidadeOcupada);

        // Verificando se o tempo calculado está correto com uma margem de erro de 1 unidade
        assertEquals(metadeCapacidadeOcupada, tempoDescarga); 
    }
}
