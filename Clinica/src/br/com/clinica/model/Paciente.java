package br.com.clinica.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity(name="tb_paciente")
public class Paciente extends GenericModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4809995234316205786L;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private Pessoa pessoa;
	
	@Column
	private String convenio;
	
	@Column
	private String telefoneParente;
	
	@Column
	private Long valorSessao;
	
	@Column
	private String sexo;
	
	@Column
	private String grauDeEscolaridade;
	
	@Column
	private String nomeParente;
	
	@Column
	private String profissao;
	
	@Column(length = 500)
	private String observacao;
	
	@Column
	private Date horaSessao;
	
	@Column
	private String grupo;
	
	@Column
	private boolean status;
	
	@OneToOne
	@JoinColumn
	private Psicologo psicologo;
	
	public String getTelefoneParente() {
		return telefoneParente;
	}
	
	public void setTelefoneParente(String telefoneParente) {
		this.telefoneParente = telefoneParente;
	}
	
	public Psicologo getPsicologo() {
		return psicologo;
	}
	
	public void setPsicologo(Psicologo psicologo) {
		this.psicologo = psicologo;
	}

	public Pessoa getPessoa() {
		if(pessoa == null)
			pessoa = new Pessoa();
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public Long getValorSessao() {
		return valorSessao;
	}
	
	public void setValorSessao(Long valorSessao) {
		this.valorSessao = valorSessao;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getGrauDeEscolaridade() {
		return grauDeEscolaridade;
	}

	public void setGrauDeEscolaridade(String grauDeEscolaridade) {
		this.grauDeEscolaridade = grauDeEscolaridade;
	}

	public String getNomeParente() {
		return nomeParente;
	}
	
	public void setNomeParente(String nomeParente) {
		this.nomeParente = nomeParente;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getHoraSessao() {
		return horaSessao;
	}

	public void setHoraSessao(Date horaSessao) {
		this.horaSessao = horaSessao;
	}
	
	public String getGrupo() {
		return grupo;
	}
	
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public boolean isStatus() {
		return status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((convenio == null) ? 0 : convenio.hashCode());
		result = prime * result + ((grauDeEscolaridade == null) ? 0 : grauDeEscolaridade.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((horaSessao == null) ? 0 : horaSessao.hashCode());
		result = prime * result + ((nomeParente == null) ? 0 : nomeParente.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((profissao == null) ? 0 : profissao.hashCode());
		result = prime * result + ((psicologo == null) ? 0 : psicologo.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((telefoneParente == null) ? 0 : telefoneParente.hashCode());
		result = prime * result + ((valorSessao == null) ? 0 : valorSessao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (convenio == null) {
			if (other.convenio != null)
				return false;
		} else if (!convenio.equals(other.convenio))
			return false;
		if (grauDeEscolaridade == null) {
			if (other.grauDeEscolaridade != null)
				return false;
		} else if (!grauDeEscolaridade.equals(other.grauDeEscolaridade))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (horaSessao == null) {
			if (other.horaSessao != null)
				return false;
		} else if (!horaSessao.equals(other.horaSessao))
			return false;
		if (nomeParente == null) {
			if (other.nomeParente != null)
				return false;
		} else if (!nomeParente.equals(other.nomeParente))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (profissao == null) {
			if (other.profissao != null)
				return false;
		} else if (!profissao.equals(other.profissao))
			return false;
		if (psicologo == null) {
			if (other.psicologo != null)
				return false;
		} else if (!psicologo.equals(other.psicologo))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (status != other.status)
			return false;
		if (telefoneParente == null) {
			if (other.telefoneParente != null)
				return false;
		} else if (!telefoneParente.equals(other.telefoneParente))
			return false;
		if (valorSessao == null) {
			if (other.valorSessao != null)
				return false;
		} else if (!valorSessao.equals(other.valorSessao))
			return false;
		return true;
	}
	
	
	

}