package com.github.fromi.openidconnect;

import static java.util.Optional.empty;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

public class SimpleSignInAdapter implements SignInAdapter {



	@Override
	public String signIn(String arg0, Connection<?> arg1, NativeWebRequest arg2) {
		
		PreAuthenticatedAuthenticationToken auth = new PreAuthenticatedAuthenticationToken(new User(arg0, "asd", Arrays.asList(new SimpleGrantedAuthority("USER"))), empty(), Arrays.asList(new SimpleGrantedAuthority("USER")));
		SecurityContextHolder.getContext().setAuthentication(auth);
		return "/test";
	}

}
