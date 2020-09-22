package com.pristavka.patient_card.config;

import com.pristavka.patient_card.model.enums.UserRole;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
    @SneakyThrows
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException
    {
        String redirectUrl = getRedirectUrl(authentication);

        if (httpServletResponse.isCommitted())
        {
            return;
        }

        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.sendRedirect(redirectUrl);
    }

    private String getRedirectUrl(Authentication authentication)
    {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains(UserRole.ADMIN.toString()))
        {
            return "/admin";
        }
        else if (roles.contains(UserRole.USER.toString()))
        {
            return "/user";
        }
        else throw new IllegalStateException();
    }
}

