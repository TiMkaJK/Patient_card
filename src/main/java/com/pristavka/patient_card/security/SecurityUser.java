package com.pristavka.patient_card.security;

import com.pristavka.patient_card.model.User;
import com.pristavka.patient_card.model.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityUser implements UserDetails
{
    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return null;
    }

    @Override
    public String getPassword()
    {
        return user.getPassword();
    }

    @Override
    public String getUsername()
    {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return checkStatus(UserStatus.EXPIRED);
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return checkStatus(UserStatus.BANNED);
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return checkStatus(UserStatus.EXPIRED);
    }

    @Override
    public boolean isEnabled()
    {
        return checkStatus(UserStatus.ACTIVE);
    }


    protected boolean checkStatus(Enum<UserStatus> userStatusEnum)
    {
        if (user.getStatus().equals(userStatusEnum))
        {
            return true;
        }
        return false;
    }

    public UserDetails fromUser()
    {
        return new org.springframework.security.core.userdetails.User(
                getUsername(),
                getPassword(),
                getAuthorities()
        );
    }
}

