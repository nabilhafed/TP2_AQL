import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UtilisateurApi utilisateurApiMock;
    @Test
    public void testCreerUtilisateur() throws ServiceException {
// Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont","jeandupont@email.com");
// TODO : Configuration du comportement du mock, utiliser la
//directive « when » avec sa méthode « thenReturn »
    when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(true);

// TODO : Création du service avec le mock

   UserService userService= new UserService(utilisateurApiMock);



 // TODO : Appel de la méthode à tester7

// ...
        userService.creerUtilisateur(utilisateur) ;

// TODO : Vérification de l'appel à l'API
// ...
        Assertions.assertTrue(userService.creerUtilisateur(utilisateur));


    }
}