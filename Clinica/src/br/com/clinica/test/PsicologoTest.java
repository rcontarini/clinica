package br.com.clinica.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.clinica.dao.PerfilDAO;
import br.com.clinica.dao.PessoaDAO;
import br.com.clinica.dao.PsicologoDAO;
import br.com.clinica.model.Perfil;
import br.com.clinica.model.Pessoa;
import br.com.clinica.model.Psicologo;

public class PsicologoTest {
	
	@Test
	public void salvar(){
		Perfil perfil = new Perfil();
		PerfilDAO perfilDAO = new PerfilDAO();
		perfil = perfilDAO.buscar(1L);
		
		Pessoa pessoa = new Pessoa();
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoa = pessoaDAO.buscar(1L);
		
		Psicologo psicologo = new Psicologo();
		psicologo.setCrp("44");
		psicologo.setSenha("1234");
		psicologo.setPerfil(perfil);
		psicologo.setPessoa(pessoa);
		
		PsicologoDAO psicologoDAO = new PsicologoDAO();
		psicologoDAO.salvar(psicologo);
	}

}
