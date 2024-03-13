import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PartieTest {

    private Partie partie;

    @BeforeEach
    public void setUp() {
        Mot mot = new Mot("test", "Ceci est un test");
        partie = new Partie(mot, 5);
    }



    @Test
    public void testDecrementerTentativesRestantes() {
        int tentativesRestantesInitiales = partie.getTentativesRestantes();
        partie.decrementerTentativesRestantes();
        assertEquals(tentativesRestantesInitiales - 1, partie.getTentativesRestantes(), "La méthode decrementerTentativesRestantes devrait réduire le nombre de tentatives restantes de 1.");
    }

    @Test
    public void testEstTentativesEpuisees() {
        partie.decrementerTentativesRestantes();
        partie.decrementerTentativesRestantes();
        partie.decrementerTentativesRestantes();
        partie.decrementerTentativesRestantes();
        partie.decrementerTentativesRestantes();
        assertTrue(partie.estTentativesEpuisees(), "La méthode estTentativesEpuisees devrait retourner vrai lorsque le nombre de tentatives restantes est épuisé.");
    }
}
