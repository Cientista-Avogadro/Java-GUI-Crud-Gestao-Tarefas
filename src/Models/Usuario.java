
package Models;

public class Usuario {
    private Integer Id;
    private String UserOrEmail;
    private String Password;

    public Usuario(Integer Id, String UserOrEmail, String Password) {
        this.Id = Id;
        this.UserOrEmail = UserOrEmail;
        this.Password = Password;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getUserOrEmail() {
        return UserOrEmail;
    }

    public void setUserOrEmail(String UserOrEmail) {
        this.UserOrEmail = UserOrEmail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
