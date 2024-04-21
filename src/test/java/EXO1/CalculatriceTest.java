package EXO1;

import EXO1.Calculatrice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {
    @Mock
    private Calculatrice calculatrice;

    @Test
    public void testAdditionner() {
        // Définition du comportement de la méthode "additionner"
        when(calculatrice.getState()).thenReturn("test valid");

        when(calculatrice.additionner(2, 3)).thenReturn(5);

        // Appel de la méthode à tester
        int resultat = calculatrice.additionner(2, 3);

        // Vérification du résultat
        assertEquals(5, resultat);

        // Vérification que la méthode "additionner" a été appelée avec les arguments 2 et 3
        verify(calculatrice).additionner(2, 3);

        //TODO : Vérification qu'aucune autre méthode n'a été appelée sur
        //l'objet après l'appel de la méthode "additionner", utiliser la
        // méthode « verifyNoMoreInteractions »
        verifyNoMoreInteractions(calculatrice) ;

        // Vérification qu'aucune autre méthode n'a été appelée sur l'objet après l'appel de la méthode "additionn


        String result= calculatrice.getState();
        Assert.assertEquals("test valid",result);
        verify(calculatrice).getState();
    }
}