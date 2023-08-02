package com.marketdongnae.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.warn("Login success");
		System.out.println("3번) 성공하면 CustomLoginSuccessHandler로 감");

		List<String> roleNames = new ArrayList<>();

		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());

		});

		log.warn("ROLE NAMES : " + roleNames);

		if (roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/");
			return;
		}
		if (roleNames.contains("ROLE_MEMBER")) {
			HttpSession session = request.getSession();
			// getName이 사실 m_id 가져오는 거라 m_name가져오게 바꿔야함
			session.setAttribute("m_id", authentication.getName());
			response.sendRedirect("/"); // test 용
			return;
		}
//		if (roleNames.contains("ROLE_USER")) {
//			response.sendRedirect("/");
//			return;
//
//		}

		response.sendRedirect("/");
		System.out.println("이건 무슨 경우지?");
	}

}
