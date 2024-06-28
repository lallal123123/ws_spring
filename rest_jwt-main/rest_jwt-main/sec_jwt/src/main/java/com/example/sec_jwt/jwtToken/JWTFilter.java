package com.example.sec_jwt.jwtToken;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.sec_jwt.entity.ReporterEntity;
import com.example.sec_jwt.secu.CustomUserDetails;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTFilter extends OncePerRequestFilter{

	private final JWTUtil jwtUtil; //토큰에서 사용자 정보 얻기, 토큰 발급하기 등
	
	public JWTFilter(JWTUtil jwtUtil) {

        this.jwtUtil = jwtUtil;
    }
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//요청헤더에서 'Authorization' 헤더 찾기
		String authorization = request.getHeader("Authorization");
		
		if(authorization == null || !authorization.startsWith("Bearer ")) {
			System.out.println("token null............");
			filterChain.doFilter(request, response);	//다음 필터로 넘긴다는 메서드
			
			return; // 필수
		}
		
		System.out.println("token 발견...");
		// Bearer 부분 제외한 순수 토큰 획득
		String token = authorization.split(" ")[1];
		System.out.println("token : " + token);
		
		if(jwtUtil.isExpired(token)) { // 토큰이 만료되었다면...
			System.out.println("token expired");
			filterChain.doFilter(request, response);
			
			return; //필수
		}
		
		String username = jwtUtil.getUsername(token);
		String email = jwtUtil.getEmail(token);
		String role = jwtUtil.getRole(token);
		
		System.out.println("userdata : " + username + ", " + email + ", " + role);
		
		ReporterEntity userEntity = new ReporterEntity();
		userEntity.setUsername(username);
		userEntity.setPassword("temppassword");	//중요한 데이터라서 여기서는 아무데이터를 넣음(로그인하는 경우가 아니라서 필요 x)
		userEntity.setEmail(email);
		userEntity.setRole(role);
		
		// UserDetails에 사용자 정보 객체 담기
		CustomUserDetails customUserDetails = new CustomUserDetails(userEntity);
		// 스프링 시큐리티 인증 토큰 생성
		Authentication authToken = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
		//시큐리티 세션에 사용자 등록 - 요청 종료 후 자동 삭제 ,여기서 잠시 세션을 씀
		SecurityContextHolder.getContext().setAuthentication(authToken);
		
		filterChain.doFilter(request, response);
	}

}
