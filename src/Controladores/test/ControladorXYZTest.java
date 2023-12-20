import Controladores.ControladorXYZ;
import Robo.RoboXYZ;
import Terreno.Terreno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControladorXYZTest {
    private ControladorXYZ controladorXYZ;
    private Terreno terreno;
    private RoboXYZ roboXYZ;

    @BeforeEach
    public void setUp() {
        terreno = new Terreno(5, 5); 
        roboXYZ = new RoboXYZ("RoboTest", terreno); 

        controladorXYZ = new ControladorXYZ(roboXYZ, terreno);
    }

    @Test
    public void testMovimentarRobo() {
        
        roboXYZ.setPosicaoRoboNoEixoX(2);
        roboXYZ.setPosicaoRoboNoEixoY(2);

        controladorXYZ.movimentarRobo();

        // Verificando se o robô se moveu para uma posição válida no terreno
        int posX = roboXYZ.getPosicaoRoboNoEixoX();
        int posY = roboXYZ.getPosicaoRoboNoEixoY();

        assertTrue(posX >= 0 && posX < terreno.getLargura());
        assertTrue(posY >= 0 && posY < terreno.getAltura());

        // Verificando se a célula em que o robô está agora está marcada como ocupada
        assertTrue(terreno.getCelulaNaPosicao(posY, posX).getTemRoboNessaCelula());
    }
}
