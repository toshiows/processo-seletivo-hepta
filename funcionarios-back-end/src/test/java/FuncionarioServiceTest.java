package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;

class FuncionarioServiceTest {

	private static Funcionario funcionario;
	private static Setor setor;
	
	static WebTarget service;
	static final String URL = "http://localhost:8080/funcionarios/rs/";
	
	@BeforeEach
	public void setUpBeforeClass() throws Exception {
	    service = TestUtil.target(URL, "funcionarios");
	    
	    setor = new Setor();
	    setor.setNome("TesteSetor");
	    
	    funcionario = new Funcionario();
	    funcionario.setNome("Teste");
	    funcionario.setEmail("teste@teste.com");
	    funcionario.setSalario(1500.00);
	    funcionario.setSetor(setor);
	    funcionario.setIdade(30);
	}
	
	@Test
	public void testFuncionarioRead() {
		Response resp = service.request().get();
		assertEquals(Response.Status.OK.getStatusCode(), resp.getStatusInfo().getStatusCode());
	}

	@Test
	public void testFuncionarioCreate() {
		Response resp = service.request().post(Entity.entity(funcionario, MediaType.APPLICATION_JSON));
		assertEquals(Response.Status.OK.getStatusCode(), resp.getStatusInfo().getStatusCode());
	}

	@Test
	public void testFuncionarioUpdate() throws JsonParseException, JsonMappingException, IOException {
		Response resp = service.request().post(Entity.entity(funcionario, MediaType.APPLICATION_JSON));
		assertEquals(Response.Status.OK.getStatusCode(), resp.getStatusInfo().getStatusCode());
	
		resp = service.request().get();
		String responseAsString = resp.readEntity(String.class);

			
		funcionario = TestUtil.ultimoAdicionado(responseAsString);
		funcionario.setNome("Atualizado");
		
		

		service = TestUtil.target(URL, "funcionarios/"+funcionario.getId());
		Response upd = service.request().put(Entity.entity(funcionario, MediaType.APPLICATION_JSON));
		assertEquals(Response.Status.OK.getStatusCode(), upd.getStatusInfo().getStatusCode());
		
	}

	@Test
	public void testFuncionarioDelete() throws JsonParseException, JsonMappingException, IOException {
		Response resp = service.request().post(Entity.entity(funcionario, MediaType.APPLICATION_JSON));
		assertEquals(Response.Status.OK.getStatusCode(), resp.getStatusInfo().getStatusCode());
	
		resp = service.request().get();
		String responseAsString = resp.readEntity(String.class);

		funcionario = TestUtil.ultimoAdicionado(responseAsString);
		
		service = TestUtil.target(URL, "funcionarios/"+funcionario.getId());
		resp = service.request().delete();
		assertEquals(Response.Status.OK.getStatusCode(), resp.getStatusInfo().getStatusCode());
	}
	
	@Test
	public void testFuncionarioReadError() {
		
		service = TestUtil.target(URL, "funciona");
		Response resp = service.request().get();
		System.out.println(resp.getStatusInfo().getStatusCode());
		assertNotEquals(Response.Status.OK.getStatusCode(), resp.getStatusInfo().getStatusCode());
	}
	

}
