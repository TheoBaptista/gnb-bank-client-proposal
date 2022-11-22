package br.com.gnb.loginapi.user;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@ToString
@NoArgsConstructor
@Entity(name = "users")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @EqualsAndHashCode.Include
    @Column(nullable = false,unique = true, name = "client_id")
    private String clientId;
    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true, name = "email")
    private String email;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "last_name")
    private String lastName;
    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;
    @Column(nullable = false, name = "birthdate")
    private LocalDate birthdate;
    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true, name = "cpf")
    private String cpf;
    @Column(nullable = false, name = "password")
    private String password;

    @CreationTimestamp
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

    public User(String email, String name, String lastName, String phoneNumber, LocalDate birthdate, String cpf, String password) {
        this.clientId = UUID.randomUUID().toString();
        this.email = email.toUpperCase(Locale.ROOT);
        this.name = name.toUpperCase(Locale.ROOT);
        this.lastName = lastName.toUpperCase(Locale.ROOT);
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.cpf = cpf;
        this.password = PasswordEncoder.build().encode(password);
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getCpf() {
        return cpf;
    }
    public String getClientId() {
        return clientId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
