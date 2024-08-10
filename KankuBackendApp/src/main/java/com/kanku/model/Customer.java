package com.kanku.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String fullName;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String contact;
    @Column(columnDefinition = "LONGTEXT")
    private String address;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<ProductOrder> productOrders;
    private LocalDate date;
    private String role;
    private String pinCode;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Cart> carts;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> authority = new HashSet<>();
        Authority auth = new Authority();
        auth.setAuthority(role);
        authority.add(auth);
        return authority;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
