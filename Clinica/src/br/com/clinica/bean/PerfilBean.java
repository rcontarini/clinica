package br.com.clinica.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.clinica.dao.PerfilDAO;
import br.com.clinica.model.Perfil;

@ManagedBean
public class PerfilBean {
	
	private Perfil perfil;
	private PerfilDAO perfilDAO;
	
	public PerfilBean() {
		
	}
	
	@PostConstruct
	public void init(){
		this.perfil = new Perfil();
		this.perfilDAO = new PerfilDAO();
		
	}
	
	public void salvar(){
		this.perfilDAO.salvar(perfil);
	}
	
	public PerfilDAO getPerfilDAO() {
		return perfilDAO;
	}
	
	public void setPerfilDAO(PerfilDAO perfilDAO) {
		this.perfilDAO = perfilDAO;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}
	
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	

}
