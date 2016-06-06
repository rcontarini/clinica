package br.com.clinica.test;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.com.clinica.dao.PacienteDAO;
import br.com.clinica.dao.PessoaDAO;
import br.com.clinica.dao.PsicologoDAO;
import br.com.clinica.model.Paciente;
import br.com.clinica.model.Pessoa;
import br.com.clinica.model.Psicologo;

public class PacienteTest {
	
	@Test
		public void salvar(){
		Pessoa pessoa = new Pessoa();
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoa = pessoaDAO.buscar(1L);
		
		Psicologo psicologo = new Psicologo();
		PsicologoDAO psicologoDAO = new PsicologoDAO();
		psicologo = psicologoDAO.buscar(1L);
		
		Paciente paciente = new Paciente();
		paciente.setConvenio("não");
		paciente.setGrauDeEscolaridade("Terceio grau");
		paciente.setHoraSessao(new Date(2016, 04, 20, 13, 30));
		paciente.setObservacao("Primeiro loquinho");
		paciente.setPessoa(pessoa);
		paciente.setProfissao("Pedreiro");
		paciente.setPsicologo(psicologo);
		paciente.setSexo("Masculino");
		paciente.setValorPorSessão(new Long(80));
		
		PacienteDAO pacienteDAO = new PacienteDAO();
		pacienteDAO.salvar(paciente);
	}
	

}
