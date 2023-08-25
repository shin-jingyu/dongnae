package com.marketdongnae.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	 private final RequestCache requestCache = new HttpSessionRequestCache();
	 private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	    
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		log.warn("Login success");
		System.out.println("3번) 성공하면 CustomLoginSuccessHandler로 감");

		clearSession(request);
		
	    SavedRequest savedRequest = requestCache.getRequest(request, response);
		
	    /**
         * prevPage가 존재하는 경우 = 사용자가 직접 /auth/login 경로로 로그인 요청
         * 기존 Session의 prevPage attribute 제거
         */
		String prevPage = (String) request.getSession().getAttribute("prevPage");
		if(prevPage != null)
			request.getSession().removeAttribute("prevPage");
		
		 // 기본 URI
        String uri = "/";
        
        /**
         * savedRequest 존재하는 경우 = 인증 권한이 없는 페이지 접근
         * Security Filter가 인터셉트하여 savedRequest에 세션 저장
         */
        if(savedRequest != null)
        	uri = savedRequest.getRedirectUrl();
        else if(prevPage != null && !prevPage.equals("")) {
            // 회원가입 - 로그인으로 넘어온 경우 "/"로 redirect
        	if(prevPage.contains("/member/regist")) {
        		uri = "/";
        	} else {
        		uri = prevPage;
        	}
        }
        redirectStrategy.sendRedirect(request, response, uri);
        

        

		List<String> roleNames = new ArrayList<>();

		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());

		});
		
//		log.warn("ROLE NAMES : " + roleNames);
//
//		if (roleNames.contains("ROLE_ADMIN")) {
//			response.sendRedirect("/");
//			return;
//		}
//		if (roleNames.contains("ROLE_MEMBER")) {
//			response.sendRedirect("/member/detail"); // test 용
//			return;
//		}
//
//		response.sendRedirect("/");
//		System.out.println("이건 무슨 경우지?");
	}
	
	  // 로그인 실패 후 성공 시 남아있는 에러 세션 제거
    protected void clearSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }
    }

}
