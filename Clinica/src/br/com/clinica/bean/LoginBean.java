package br.com.clinica.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.swing.plaf.metal.MetalPopupMenuSeparatorUI;

import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import br.com.clinica.dao.PsicologoDAO;
import br.com.clinica.enums.PaginasValues;
import br.com.clinica.model.Perfil;
import br.com.clinica.model.Pessoa;
import br.com.clinica.model.Psicologo;

@ManagedBean
@SessionScoped
public class LoginBean extends AbstractManagedBean {
	
	private Perfil perfil;
	private Pessoa pessoa;
	private Boolean loggedIn;
	private PsicologoDAO psicologoDAO;
	private Psicologo psicoTela;
	private Psicologo psicoBanco;
	private String senha;
	
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}
	

	@PostConstruct
	public void init(){
		this.psicoTela = new Psicologo();
		this.psicologoDAO = new PsicologoDAO();
	}
	
	public void login(){
		if(this.psicoTela.getCrp().equalsIgnoreCase("admin") &&
				this.psicoTela.getSenha().equalsIgnoreCase("admin")){
			
			Perfil perfil2 = new Perfil();
			perfil2.setNome("administrador");
			this.psicoTela.setPerfil(perfil2);
			
			loggedIn = true;
			
		} else if (this.psicoTela.getCrp() != null && 
				this.psicoTela.getSenha() != null){
			
		this.psicoBanco = new Psicologo();
		this.psicoBanco = this.psicologoDAO.buscarPorCRP(this.psicoTela.getCrp().toString());
		
		if(this.psicoBanco != null && this.psicoBanco.getSenha().equals(this.psicoTela.getSenha())){
			System.out.println("Senhas iguais" + this.psicoBanco.getSenha().toString() + ":" + 
								this.psicoTela.getSenha().toString());
			loggedIn = true;
			
			}else{
				addMessageError("Login ou senha invalidos!", "");
				loggedIn = false;
				System.out.println("Chamar tela novamente");
			}
			
		} if (loggedIn = true){
			if(this.psicoTela.getCrp().equalsIgnoreCase("admin") && 
					this.psicoTela.getSenha().equalsIgnoreCase("admin")){
				Messages.addGlobalInfo("adm logado!");
				String url = this.getContextPath().concat(PaginasValues.PACIENTE_VIEW.getCaminho()+"?faces-redirect=true");
				redirectToPage(url);
			} else if(this.psicoBanco != null && this.psicoBanco.getSenha().equalsIgnoreCase("1234")){
				
				RequestContext.getCurrentInstance().execute("PF('dialog.senha').show()");
			} else {
				System.out.println("Redirecionar para sistema!");
			}
		} 
		
	}
	
	public void alterarSenha(){
		PsicologoDAO psicologoDAO2 = new PsicologoDAO();
		this.psicoBanco.setSenha(this.senha);
		this.psicoBanco.getSenha();
		psicologoDAO2.merge(this.psicoBanco);
		RequestContext.getCurrentInstance().execute("PF('dialog.senha').hide()");
		addMessageInfo("Senha Alterada Com Sucesso!", "");
	}
	


	public Perfil getPerfil() {
		return perfil;
	}


	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	public PsicologoDAO getPsicologoDAO() {
		return psicologoDAO;
	}
	
	public void setPsicologoDAO(PsicologoDAO psicologoDAO) {
		this.psicologoDAO = psicologoDAO;
	}

	public Psicologo getPsicoBanco() {
		return psicoBanco;
	}
	
	public void setPsicoBanco(Psicologo psicoBanco) {
		this.psicoBanco = psicoBanco;
	}
	
	public Psicologo getPsicoTela() {
		return psicoTela;
	}
	
	public void setPsicoTela(Psicologo psicoTela) {
		this.psicoTela = psicoTela;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}