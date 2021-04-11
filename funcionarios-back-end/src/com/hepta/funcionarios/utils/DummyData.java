package com.hepta.funcionarios.utils;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.FuncionarioDAO;

public class DummyData {

	public static void main(String ... args) throws Exception {
		FuncionarioDAO dao = new FuncionarioDAO();
		Setor s = new Setor();
		//s.setId(1);
		s.setNome("Dev");
		
		Funcionario f = new Funcionario();
		//f.setId(1);
		f.setEmail("teste");
		f.setIdade(25);
		f.setNome("Toshio");
		f.setSalario(1500.00);
		f.setSetor(s);
		
		dao.save(f);
	}
	 

}
