package br.com.clinica.rn;

import java.util.List;

import br.com.clinica.bean.AbstractManagedBean;
import br.com.clinica.dao.ConvenioDAO;
import br.com.clinica.model.Convenio;

public class ConvenioRN extends AbstractManagedBean {
	
	private ConvenioDAO convenioDAO;
	
	public ConvenioRN() {
		this.convenioDAO = new ConvenioDAO();
	}
	
	
	public List<Convenio> listarConvenios(){
		return this.convenioDAO.listar();
		
	}
	
	public void salvar(Convenio convenio){
		Long id = convenio.getId();
		
		if(id == null || id == 0 ){
			this.convenioDAO.salvar(convenio);
		} else {
			this.convenioDAO.editar(convenio);
		}
	}
	
	public void excluir(Convenio convenio){
		Long id = convenio.getId();
		
		if(id == null || id == 0){
			addMessageError("Selecione um convênio", "Error!");
		} else {
			this.convenioDAO.excluir(convenio);
			addMessageInfo("Convênio excluído com sucesso!", "Info!");
		}
	}
	
	public ConvenioDAO getConvenioDAO() {
		return convenioDAO;
	}
	
	public void setConvenioDAO(ConvenioDAO convenioDAO) {
		this.convenioDAO = convenioDAO;
	}

}
