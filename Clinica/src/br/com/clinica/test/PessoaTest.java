package br.com.clinica.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.clinica.dao.PerfilDAO;
import br.com.clinica.dao.PessoaDAO;
import br.com.clinica.model.Perfil;
import br.com.clinica.model.Pessoa;

public class PessoaTest {
	
	@Test
	@Ignore
	public void salvar(){
		Pessoa pessoa = new Pessoa();
		pessoa.setBairro("Rio das Pedras");
		pessoa.setCelular("996017021");
		pessoa.setCep("06703785");
		pessoa.setCidade("Cotia");
		pessoa.setComplemento("Residencial Villa Deste");
		pessoa.setCpf("376.834.768-03");
		pessoa.setEmail("contbeiro@gmail.com");
		pessoa.setNome("Rodrigo Contarini Ribeiro");
		pessoa.setNumero(new Short("888"));
		pessoa.setTelefone("4612-6176");
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
		
	}

}
