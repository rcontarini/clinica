package br.com.clinica.test;
import org.junit.Ignore;
import org.junit.Test;

import br.com.clinica.dao.PerfilDAO;
import br.com.clinica.model.Perfil;

public class PerfilTest {
	
	@Test
	@Ignore
	public void salvar(){
		Perfil perfil = new Perfil();
		perfil.setNome("Administrador");
		
		PerfilDAO perfilDAO = new PerfilDAO();
		perfilDAO.salvar(perfil);
	}
	

}