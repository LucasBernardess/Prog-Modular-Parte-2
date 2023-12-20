import Robo.RoboXYZ;
import Sondas.SondaAltaCapacidade;
import Terreno.Terreno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SondaAltaCapacidadeTest {
    private SondaAltaCapacidade sonda;
    private Terreno terreno;
    private RoboXYZ robo;

    @BeforeEach
    public void setUp() {
        terreno = new Terreno(5, 5); 
        robo = new RoboXYZ("Nome do Robô", terreno); 
        sonda = new SondaAltaCapacidade(robo, terreno);
    }

    @Test
    public void testProspectaHelio() {
        
        int posX = 2;
        int posY = 2;
        int concentracaoFicticia = 50,
        terreno.setConcentracaoDeHelio3NaPosicao(posY, posX, concentracaoFicticia);

        robo.setPosicaoRoboNoEixoX(posX);
        robo.setPosicaoRoboNoEixoY(posY);

        // Prospeção de hélio pela sonda
        sonda.prospectaHelio();

        // Verificando se a quantidade de hélio coletado pelo robô é correta após a prospecção
        assertEquals(concentracaoFicticia * 3, robo.getHelioColetadoPeloRobo());
    }
}
