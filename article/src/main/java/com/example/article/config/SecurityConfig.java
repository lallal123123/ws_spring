package com.example.article.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity		//설정을 활성화를 위해 사용
public class SecurityConfig {
	
	//메서드의 반환타입을 빈으로 등록할때 @Bean을 씀
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {		//BCryptPasswordEncoder의 객체를 생성하기 위한 메서드
		return new BCryptPasswordEncoder();
		}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((auth) -> auth
//				.requestMatchers("/","/registForm","/registProc").permitAll()	//해당 리퀘스트에서는 인증을 안해도 됨(전부허용)
				.requestMatchers("/journalist/**").hasAnyRole("EDITOR","JOURNALIST")	//2개이상일때 hasAnyRole
				.requestMatchers("/editor/**").hasRole("EDITOR")					//1개일때 hasRole
				.anyRequest().permitAll()									//나머지 리퀘스트는 인증을 거치도록 함
		);
		
		http.formLogin((auth) ->auth											
				//.loginPage("/loginPage")		//로그인폼 지정-쓰지 않으면 Spring Security가 제공하는 로그인 폼 사용
				.loginProcessingUrl("/loginProc")		//로그인 폼 지정 후 폼 파라미터 보내는 경로 지정 - 컨트롤러에 직접 만들지 않는다.(Spring Security가 알아서 처리함)
				.defaultSuccessUrl("/")		//로그인에 성공했을때 이동할 리퀘스트
				.permitAll()
				);
		
		http.csrf(AbstractHttpConfigurer::disable);		//csrf 기능 끄기
		return http.build();
	}
}
