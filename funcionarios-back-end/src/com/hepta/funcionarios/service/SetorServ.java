package com.hepta.funcionarios.service;

import java.util.List;

import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.SetorDAO;

public class SetorServ {

	private SetorDAO setorDAO;
	
	public SetorServ() {
		setorDAO = new SetorDAO();
	}
	
	public List<Setor> listarSetores() throws Exception {
		return setorDAO.getAll();
	}
	
	public void salvarSetor(Setor setor) throws Exception {
		setorDAO.salvarSetor(setor);
	}
	
	public void deletarSetor(Integer id) throws Exception {
		setorDAO.delete(id);
	}
	
	public void atualizarSetor(Integer id, Setor setor) throws Exception {
		setorDAO.update(id, setor);
	}
}
