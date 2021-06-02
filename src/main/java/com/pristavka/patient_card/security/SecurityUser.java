package com.pristavka.patient_card.security;

import com.pristavka.patient_card.model.Role;
import com.pristavka.patient_card.model.User;
import com.pristavka.patient_card.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityUser implements UserDetails {

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<Role> roles = this.user.getRoles();

        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getUserRole().toString()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return checkStatus(UserStatus.EXPIRED);
    }

    @Override
    public boolean isAccountNonLocked() {
        return checkStatus(UserStatus.BANNED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return checkStatus(UserStatus.EXPIRED);
    }

    @Override
    public boolean isEnabled() {
        return checkStatus(UserStatus.ACTIVE);
    }

    protected boolean checkStatus(Enum<UserStatus> userStatusEnum) {
        return this.user.getStatus().equals(userStatusEnum);
    }

    public UserDetails getUserDetails() {
        return new org.springframework.security.core.userdetails.User(
                getUsername(),
                getPassword(),
                getAuthorities()
        );
    }
}

