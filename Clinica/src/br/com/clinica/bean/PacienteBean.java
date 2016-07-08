package br.com.clinica.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.clinica.dao.PacienteDAO;
import br.com.clinica.dao.PessoaDAO;
import br.com.clinica.enums.PaginasValues;
import br.com.clinica.model.Convenio;
import br.com.clinica.model.Paciente;
import br.com.clinica.model.Pessoa;
import br.com.clinica.rn.ConvenioRN;
import br.com.clinica.rn.PacienteRN;
import helper.Contants;

@ManagedBean
@ViewScoped
public class PacienteBean extends AbstractManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5470093910070941191L;
	private Paciente paciente;
	private List<Paciente> listarPacientes;
	private List<Paciente> listaFiltrada;
	private String pesquisa;
	private PacienteRN pacienteRN;
	private List<Convenio> convenios;
	private ConvenioRN convenioRN;
	private String convenio;
	private String verifica;
	
	@PostConstruct
	public void init() {
			if(getSession().getAttribute(Contants.SESSION_OBJECT_KEY) == null){
				this.pacienteRN = new PacienteRN();
				this.paciente = new Paciente();
				this.listarPacientes = this.pacienteRN.listarPaciente();
				this.listaFiltrada = this.pacienteRN.listarPaciente();
			}else if(getSession().getAttribute(Contants.SESSION_OBJECT_KEY) != null){
				this.paciente = (Paciente) getSession().getAttribute(Contants.SESSION_OBJECT_KEY);

			}
	}
	
	/*
	 * Alterar para buscar do banco
	 */
	public void pesquisar(){
		this.listaFiltrada.clear();
		if(this.pesquisa != null && this.listarPacientes.size() > 0){
			for (int i = 0; i < this.listarPacientes.size(); i++) {
				if(this.listarPacientes.get(i).getPessoa().getNome().toUpperCase().contains(this.pesquisa.toUpperCase())){
					this.listaFiltrada.add(this.listarPacientes.get(i));
				}
			}
		} else {
			System.out.println("Valorentidade Nulo");
		}
	}
	/*
	 * Salvar dados principais paciente
	 */
			
	public void salvar(){
		this.pacienteRN.salvar(this.paciente);
		getSession().setAttribute(Contants.SESSION_OBJECT_KEY, this.paciente);
		addMessageInfo("Cadastro salvo com sucesso!", "Info");
		String url = this.getContextPath().concat(PaginasValues.PACIENTE_INI_VIEW.getCaminho()+"?faces-redirect=true");
		redirectToPage(url);
	}
	
	/*
	 * Salvar dados secundarios pacientes
	 */
	
	public void salvarCadFinal(){
		this.pacienteRN = new PacienteRN();
		this.pacienteRN.salvar(this.paciente);
		addMessageInfo("Cadastro salvo com sucesso!", "Info: ");
	}
	
	/*
	 * Enviar paciente selecionado para tela de opções
	 */
	
	public void dadosGerais(ActionEvent e){
		this.paciente  = (Paciente) e.getComponent().getAttributes().get("continuarCadastro");
		getSession().setAttribute(Contants.SESSION_OBJECT_KEY, this.paciente);
		String url = this.getContextPath().concat(PaginasValues.PACIENTE_INI_VIEW.getCaminho()+"?faces-redirect=true");
		redirectToPage(url);
	}

	/*
	 * Edita cadastro principal paciente
	 */
	
	public void editar(ActionEvent e) {
		this.paciente = (Paciente) e.getComponent().getAttributes().get("editarUsuario");
		getSession().setAttribute(Contants.SESSION_OBJECT_KEY, this.paciente);
		String url = this.getContextPath().concat(PaginasValues.PACIENTE_TRN.getCaminho()+"?faces-redirect=true");
		redirectToPage(url);
	}
	
	/*
	 * Desativar paciente e atualiza datatable
	 */
	public void desativarUsuario(){
		this.pacienteRN.desativarUsuario(this.paciente);
		addMessageInfo("Paciente desativado com sucesso!", "Info: ");
	}
	
	/*
	 * Deleta paciente
	 */
	
	public void excluirPaciente(ActionEvent e){
		this.paciente = (Paciente) e.getComponent().getAttributes().get("excluirUsuario");
		this.pacienteRN.excluir(this.paciente);
		this.listaFiltrada = this.pacienteRN.listarPaciente();
		addMessageInfo("Paciente deletado com sucesso!", "Info: ");
	}
	
	public void verificaConvenio(){
		getVerifica();
		this.convenioRN = new ConvenioRN();
		this.convenios = this.convenioRN.listarConvenios();
	}

	public void cadastrar(){
		String url = getContextPath().concat(PaginasValues.PACIENTE_TRN.getCaminho()+"?faces-redirect=true");
		redirectToPage(url);
	}
	
	public void finalizarCadastro(){
		String url = getContextPath().concat(PaginasValues.PACIENTE_TRN_FINAL.getCaminho()+"?faces-redirect=true");
		redirectToPage(url);
	}
	
	public void listar(){
		getSession().setAttribute(Contants.SESSION_OBJECT_KEY, null);
		String url = getContextPath().concat(PaginasValues.PACIENTE_VIEW.getCaminho()+"?faces-redirect=true");
		redirectToPage(url);
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getListarPacientes() {
		if(listarPacientes == null)
			listarPacientes = new ArrayList<>();
		return listarPacientes;
	}
	public void setListarPacientes(List<Paciente> listarPacientes) {
		this.listarPacientes = listarPacientes;
	}
	
	public String getPesquisa() {
		return pesquisa;
	}
	
	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	public List<Paciente> getListaFiltrada() {
		if(listaFiltrada == null)
			listaFiltrada = new ArrayList<Paciente>();
		return listaFiltrada;
	}
	
	public void setListaFiltrada(List<Paciente> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}
	
	
	public PacienteRN getPacienteRN() {
		if(pacienteRN == null)
			pacienteRN = new PacienteRN();
		return pacienteRN;
	}
	
	public void setPacienteRN(PacienteRN pacienteRN) {
		this.pacienteRN = pacienteRN;
	}
	
	public List<Convenio> getConvenios() {
		if(convenios == null)
			convenios = new ArrayList<Convenio>();
		return convenios;
	}
	
	public void setConvenios(List<Convenio> convenios) {
		this.convenios = convenios;
	}
	
	public ConvenioRN getConvenioRN() {
		if(convenioRN == null)
			convenioRN = new ConvenioRN();
		return convenioRN;
	}
	
	public void setConvenioRN(ConvenioRN convenioRN) {
		this.convenioRN = convenioRN;
	}
	
	public String getConvenio() {
		return convenio;
	}
	
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	
	public String getVerifica() {
		return verifica;
	}
	
	public void setVerifica(String verifica) {
		this.verifica = verifica;
	}
}