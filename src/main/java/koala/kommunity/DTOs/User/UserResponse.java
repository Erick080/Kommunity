package koala.kommunity.DTOs.User;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserResponse implements UserDetails {
    String name;
    String email;
    String password;
    EnumUserRole role;

    public UserResponse(String name, String email, EnumUserRole role, String password) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    public String getUserName() {
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

    public EnumUserRole getRole() {
        return role;
    }

    public void setRole(EnumUserRole role) {
        this.role = role;
    }

    @Override public String getUsername(){return email;}
    @Override public String getPassword(){return password;}
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

}
