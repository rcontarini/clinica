package br.com.clinica.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.clinica.auth.SessionContext;

public abstract class AbstractManagedBean {

	private SessionContext session;
	private String contextPath;

	public AbstractManagedBean() {
		this.session = new SessionContext();
		this.contextPath = session.getContextPath();
	}

	public void redirectToPage(String url) {
		try {

			FacesContext.getCurrentInstance().getExternalContext().redirect(url);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logOut(ActionEvent action) {
		action.getSource();
		SessionContext.getInstance().encerrarSessao();
		String url = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestContextPath()
				.concat("/" + "login.xhtml?faces-redirect=true");
		redirectToPage(url);
	}
	
	public void addMessageError(String msg, String param) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , msg);
		FacesContext.getCurrentInstance().addMessage(null,  message);		
	}
	
	public void addMessageInfo(String msg, String param) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg);
		FacesContext.getCurrentInstance().addMessage(null,  message);
	}

	public SessionContext getSession() {
		return session;
	}

	public void setSession(SessionContext session) {
		this.session = session;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

}