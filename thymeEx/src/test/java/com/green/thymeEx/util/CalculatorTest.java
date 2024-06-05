package com.green.thymeEx.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CalculatorTest {
	
	@Autowired
	Calculator calc;
	
	
	

	@Test
	void testAddMethod() {
		//Calculator calc = new Calculator();
		
		int result = calc.add(5, 1);
	
		assertEquals(result,7,1);	//세번째 숫자는 +-오차범위
	
	}
	@Test
	void testCreateCalculatorInstanced() {
		//Calculator calc = new Calculator();
		
		assertNotNull(calc);	//conn같은 받아오는 객체 일떄 확인함
		//assertNull(calc);
	}
	
	@Test
	void test2() {
		String s =null;
		int a =10;
		//assertThat(s).isEmpty(); //null인 경우 false임 비어있는것과  null은 다름
		
		assertThat(a).isPositive();
	}

}
