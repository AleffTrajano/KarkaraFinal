package com.gama.karkara.model.pagamento;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.pagar.model.PagarMe;

@Configuration
public class PagarmeConfiguration {

	@Value("${token}")
	private String token;
	
	@Bean
	public void initPagarme() {
		PagarMe.init(token);
	}
}
