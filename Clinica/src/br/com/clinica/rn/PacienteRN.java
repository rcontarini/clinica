package br.com.clinica.rn;

import java.util.List;

import br.com.clinica.dao.PacienteDAO;
import br.com.clinica.model.Paciente;

public class PacienteRN {
	
	private PacienteDAO pacienteDAO;
	
	public PacienteRN() {
		this.pacienteDAO = new PacienteDAO();
	}
	

	public List<Paciente> listarPaciente(){
		return this.pacienteDAO.listar();
	}
	
	public void salvar(Paciente paciente){
		Long id = paciente.getId();
		if(id == null || id == 0){
			this.pacienteDAO.salvar(paciente);
		} else {
			this.pacienteDAO.editar(paciente);
		}
	}
	
	public void desativarUsuario(Paciente paciente){
		Paciente usuarioDesativar = this.pacienteDAO.buscar(paciente.getId());
		usuarioDesativar.setStatus(false);
		this.pacienteDAO.editar(usuarioDesativar);
	}
	
	public void excluir(Paciente paciente){
		this.pacienteDAO.excluir(paciente);
	}
	
	public PacienteDAO getPacienteDAO() {
		return pacienteDAO;
	}
	
	public void setPacienteDAO(PacienteDAO pacienteDAO) {
		this.pacienteDAO = pacienteDAO;
	}

}
