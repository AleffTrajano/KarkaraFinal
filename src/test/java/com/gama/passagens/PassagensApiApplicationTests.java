package com.gama.passagens;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
class PassagensApiApplicationTests {

	@Test
	void initTestes() {
		assertThat(1).isEqualTo(1);
	}

}
