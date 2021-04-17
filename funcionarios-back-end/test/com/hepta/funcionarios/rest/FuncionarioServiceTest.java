package com.hepta.funcionarios.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.utils.TestUtil;

class FuncionarioServiceTest {

	private Funcionario funcionario;
	static WebTarget service;
	static final String URL = "http://localhost:8080/mercado/rs/";
	
	@BeforeEach
	void setUpBeforeClass() throws Exception {
	    service = TestUtil.target(URL, "funcionarios");
	    funcionario = new Funcionario();
	    Setor setor = new Setor();
	    setor.setId(1);
	    setor.setNome("TesteSetor");
	    funcionario.setNome("Teste");
	    funcionario.setId(30);
	    funcionario.setEmail("teste@teste.com");
	    funcionario.setSalario(1500.00);
	    funcionario.setSetor(setor);
	}
	
	@Test
	void testFuncionarioRead() {
		Response response = service.request().get();
		System.out.println("OI");
		assertEquals(Response.Status.OK.getStatusCode(),response.getStatusInfo().getStatusCode());
	}

	@Test
	void testFuncionarioCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testFuncionarioUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testFuncionarioDelete() {
		fail("Not yet implemented");
	}

}
