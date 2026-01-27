package koala.kommunity.Persistence;

import jakarta.persistence.*;
import koala.kommunity.DTOs.User.EnumUserRole;

@Entity
@Table(name = "users")
public class UserJPA {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumUserRole role;
    
    public UserJPA() {}
    
    public UserJPA(String name, String email, String password, EnumUserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
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
    
    public void setRole(EnumUserRole role) {
        this.role = role;
    }
}
