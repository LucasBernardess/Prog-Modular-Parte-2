import Controladores.ControladorFTT;
import Robo.RoboFTT;
import Terreno.Celula;
import Terreno.Terreno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControladorFTTTest {
    private ControladorFTT controladorFTT;
    private Terreno terreno;
    private RoboFTT robo;

    @BeforeEach
    public void setUp() {
        terreno = new Terreno(5, 5); 
        robo = new RoboFTT("RoboTest", terreno); 

        controladorFTT = new ControladorFTT(terreno, robo);
    }

    @Test
    public void testMovimentarRobo() {
        
        robo.setPosicaoRoboNoEixoX(2);
        robo.setPosicaoRoboNoEixoY(2);

        controladorFTT.movimentarRobo();

        // Verificando se o robô se moveu para uma posição válida no terreno
        int posX = robo.getPosicaoRoboNoEixoX();
        int posY = robo.getPosicaoRoboNoEixoY();

        assertTrue(posX >= 0 && posX < terreno.getLargura());
        assertTrue(posY >= 0 && posY < terreno.getAltura());

        // Verificando se a célula em que o robô está agora está sendo sondada
        assertTrue(terreno.getCelulaNaPosicao(posY, posX).isEstaSendoSondadaPorAlgumRobo());
    }
}
