package koala.kommunity.DTOs.User;

public class CreateUserRequest {
    String name;
    String email;
    String password;
    EnumUserRole role;

    public CreateUserRequest(String name, String email, String password, EnumUserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EnumUserRole getRole() {
        return role;
    }
    
}