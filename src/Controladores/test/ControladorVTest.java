import Controladores.ControladorV;
import Robo.RoboV;
import Terreno.Terreno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControladorVTest {
    private ControladorV controladorV;
    private Terreno terreno;
    private RoboV robo;

    @BeforeEach
    public void setUp() {
        terreno = new Terreno(5, 5); 
        robo = new RoboV("Nome do Robô", terreno); 

        controladorV = new ControladorV(terreno, robo);
    }

    @Test
    public void testMovimentarRobo() {
        
        robo.setPosicaoRoboNoEixoX(2);
        robo.setPosicaoRoboNoEixoY(2);

        controladorV.movimentarRobo();

        // Verificando se o robô se moveu para uma posição válida no terreno
        int posX = robo.getPosicaoRoboNoEixoX();
        int posY = robo.getPosicaoRoboNoEixoY();

        assertTrue(posX >= 0 && posX < terreno.getLargura());
        assertTrue(posY >= 0 && posY < terreno.getAltura());

        // Verificando se a célula em que o robô está agora está sendo sondada
        assertTrue(terreno.getCelulaNaPosicao(posY, posX).isEstaSendoSondadaPorAlgumRobo());
    }
}
