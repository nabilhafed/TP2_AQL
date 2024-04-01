public class UserService {
    private final UtilisateurApi utilisateurApi;
    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }
    public boolean creerUtilisateur(Utilisateur utilisateur) throws
            ServiceException {
       boolean result =  utilisateurApi.creerUtilisateur(utilisateur);
        return true;
    }
}