package com.marketdongnae.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

public class AjaxAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
	// ajax security 테스트 중
	public AjaxAuthenticationEntryPoint(String loginFormUrl) {
		super(loginFormUrl);
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
       
//		String ajaxHeader = request.getHeader("X-Requested-With");
//        // AJAX 요청인지 검사 (헤더 검사, 비동기인지 체크)
//        boolean isAjax = "XMLHttpRequest".equals(ajaxHeader);
//        // 403 Error를 반환한다.
//        if (isAjax) {
//            response.sendError(HttpServletResponse.SC_FORBIDDEN, "세션 만료로 인해서 거부되었습니다.");
//        } else {
//            super.commence(request, response, authException);
//        }
		System.out.println("###AjaxAuthenticationEntryPoint들어옴!");
		super.commence(request, response, authException);
	}
	
	

}
