package EXO3;

import EXO2.ServiceException;
import EXO2.UserService;
import EXO2.Utilisateur;
import EXO2.UtilisateurApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Captor
    private ArgumentCaptor<Utilisateur> argumentCaptor;
    @Test
    public void testCreationUtilisateur_EchecCreation_Exception() throws ServiceException {
        // Scénario : Lever une exception lors de la création de l'utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(false);

        UserService userService = new UserService(utilisateurApiMock);

        // Appel de la méthode à tester
        try {
            userService.creerUtilisateur(utilisateur);
        } catch (ServiceException e) {
            // Vérification que l'exception a été levée avec le bon message
            assertEquals("Echec de la création de l'utilisateur", e.getMessage());
        }
    }

    @Test
    public void testCreationUtilisateur_ErreurValidation() throws ServiceException {
        // Scénario : Erreur de validation lors de la création de l'utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "email_invalide"); // email invalide
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(false);

        UserService userService = new UserService(utilisateurApiMock);

        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // Vérification que la méthode creerUtilisateur a été appelée avec l'utilisateur invalide
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
        // Vérification qu'aucune autre méthode n'a été appelée sur l'objet utilisateurApiMock////
        verifyNoMoreInteractions(utilisateurApiMock);
    }

    @Test
    public void testCreationUtilisateur_EnvoiReussi_IDUtilisateur() throws ServiceException {
        // Scénario : Envoi réussi de l'utilisateur à l'API avec renvoi de l'ID utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(true);

        // Définition d'un ID fictif
        int idUtilisateur = 123;
        // Configuration du mock pour renvoyer l'ID
        when(utilisateurApiMock.recupererIdUtilisateur(utilisateur)).thenReturn(idUtilisateur);

        UserService userService = new UserService(utilisateurApiMock);

        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // Vérification de l'ID de l'utilisateur
        int idUtilisateurRetourne = utilisateurApiMock.recupererIdUtilisateur(utilisateur);
        assertEquals(idUtilisateur, idUtilisateurRetourne);
    }
    @Test
    public void testCreationUtilisateur_ArgumentsCaptures() throws ServiceException {
        // Création d'un utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // Capturer les arguments passés à la méthode creerUtilisateur du mock
        when(utilisateurApiMock.creerUtilisateur(any(Utilisateur.class))).thenReturn(true);
        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());

        // Obtenir l'utilisateur capturé
        Utilisateur utilisateurCapture = argumentCaptor.getValue();

        // Vérification des arguments capturés en utilisant les getters de l'objet utilisateurCapture
        assertEquals(utilisateur.getUserName(), utilisateurCapture.getUserName());
        assertEquals(utilisateur.getUserFamilyName(), utilisateurCapture.getUserFamilyName());
        assertEquals(utilisateur.getEmail(), utilisateurCapture.getEmail());
    }
}
