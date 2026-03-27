package koala.kommunity.DTOs.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateUserRequest {
    @NotBlank(message = "Nome é obrigatório")
    String name;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    String email;

    @NotBlank(message = "Senha é obrigatória")
    String password;

    @NotNull(message = "Role é obrigatório")
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