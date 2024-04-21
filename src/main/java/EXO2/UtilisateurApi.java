package EXO2;

public interface UtilisateurApi {
    // Définition d'un ID fictif
       int idUtilisateur = 123 ;
      boolean creerUtilisateur(Utilisateur utilisateur) ;
      int getIdUtilisateur();

    int recupererIdUtilisateur(Utilisateur utilisateur);
}
