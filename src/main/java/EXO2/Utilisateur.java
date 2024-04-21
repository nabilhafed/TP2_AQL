package EXO2;

public class Utilisateur {
    public String UserName ;
    public String UserFamilyName ;
    public String Email ;

    public Utilisateur(String userName, String userFamilyName, String email) {
        UserName = userName;
        UserFamilyName = userFamilyName;
        Email = email;
    }

    public String getUserName() {
        return UserName;
    }

    public String getUserFamilyName() {
        return UserFamilyName;
    }

    public String getEmail() {
        return Email;
    }
}
