package com.hepta.funcionarios.service;

import java.util.List;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.persistence.FuncionarioDAO;

public class FuncionarioServ {

	private FuncionarioDAO funcionarioDAO;
	
	public FuncionarioServ() {
		funcionarioDAO = new FuncionarioDAO();
	}
	
	public List<Funcionario> listarFuncionarios() throws Exception {
		return funcionarioDAO.getAll();
	}
	
	public void salvarFuncionario(Funcionario funcionario) throws Exception{
		funcionarioDAO.save(funcionario);
	}
	
	public void atualizarFuncionario(Integer id, Funcionario funcionario) throws Exception {
		funcionarioDAO.update(id, funcionario);
	}
	
	public void excluirFuncionario(Integer id) throws Exception {
		funcionarioDAO.delete(id);
	}
	
	
}
