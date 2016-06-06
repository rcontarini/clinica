package br.com.clinica.auth;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public class SessionContext {

	private static SessionContext instance;

	public static SessionContext getInstance() {
		if (instance == null) {
			instance = new SessionContext();
		}
		return instance;
	}

	private ExternalContext currentExternalContext() {
		if (FacesContext.getCurrentInstance() == null) {
			throw new RuntimeException("dsd");
		} else {
			return FacesContext.getCurrentInstance().getExternalContext();
		}
	}

	public void redirectToPage(String url) {
		try {
			this.currentExternalContext().redirect(url);
		} catch (IOException e) {
			throw new RuntimeException("Não foi possível acessar a página " + url);
		}
	}

	public FacesContext getCurrentInstance() {
		return FacesContext.getCurrentInstance();

	}

	public RequestContext getRequestContext() {
		return RequestContext.getCurrentInstance();

	}

	public String getContextPath() {
		return currentExternalContext().getRequestContextPath();

	}

	public void encerrarSessao() {
		currentExternalContext().invalidateSession();

	}

	public Object getAttribute(String nome) {
		return currentExternalContext().getSessionMap().get(nome);

	}

	public void setAttribute(String nome, Object valor) {
		currentExternalContext().getSessionMap().put(nome, valor);

	}
}
