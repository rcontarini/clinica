package br.com.clinica.bean;

import java.io.Serializable;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import br.com.clinica.model.Convenio;
import br.com.clinica.rn.ConvenioRN;

@ManagedBean
@ViewScoped
public class ConvenioBean extends AbstractManagedBean implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2378460767569529023L;
	
	private Convenio convenio;
	private List<Convenio> listaConvenio;
	private ConvenioRN convenioRN;
	private String pesquisar;
	
	@PostConstruct
	public void init(){
		this.convenio = new Convenio();
		this.convenioRN = new ConvenioRN();
		this.listaConvenio = this.convenioRN.listarConvenios();
		
	}
	
	public void salvar(){
		this.convenioRN.salvar(this.convenio);
		addMessageInfo("Cadastro salvo com sucesso!", "Info");
		RequestContext.getCurrentInstance().execute("PF('cadastro').hide()");
		this.listaConvenio = this.convenioRN.listarConvenios();
		this.convenio = new Convenio();
	}
	
	public void editar(ActionEvent e){
		this.convenio = (Convenio) e.getComponent().getAttributes().get("editarConvenio");
	}
	
	public void excluirConvenio(ActionEvent e){
		this.convenio = (Convenio) e.getComponent().getAttributes().get("excluirConvenio");
		this.convenioRN.excluir(this.convenio);
		this.listaConvenio = this.convenioRN.listarConvenios();
	}
	
	public Convenio getConvenio() {
		return convenio;
	}
	
	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	
	public ConvenioRN getConvenioRN() {
		return convenioRN;
	}
	
	public void setConvenioRN(ConvenioRN convenioRN) {
		this.convenioRN = convenioRN;
	}
	
	public List<Convenio> getListaConvenio() {
		return listaConvenio;
	}
	
	public void setListaConvenio(List<Convenio> listaConvenio) {
		this.listaConvenio = listaConvenio;
	}
	
	public String getPesquisar() {
		return pesquisar;
	}
	
	public void setPesquisar(String pesquisar) {
		this.pesquisar = pesquisar;
	}

}
