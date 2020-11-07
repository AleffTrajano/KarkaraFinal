package com.gama.passagens.clientapi.viacep;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "cepClient", url = "https://viacep.com.br/ws/")
public interface ViaCepClient {
	@GetMapping("{cep}/json")
	Endereco buscarEndereco(@PathVariable("cep") String cep);
}
