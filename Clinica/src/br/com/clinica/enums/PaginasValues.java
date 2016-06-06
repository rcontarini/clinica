package br.com.clinica.enums;

public enum PaginasValues {
	
	INDEX_LOGIN ("/login.xhtml"),
	PACIENTE_VIEW ("/pages/paciente/paciente_view.xhtml"),
	PACIENTE_MENU_TRN ("/pages/paciente/paciente_menu_principal.xhtml"),
	PACIENTE_TRN_CADASTRO ("/pages/paciente/paciente_trn_cadastro.xhtml"),
	PACIENTE_TRN_FINAL ("/pages/paciente/paciente_trn_final.xhtml"),
	PACIENTE_INI_VIEW ("/pages/paciente/paciente_ini_view.xhtml"),
	PACIENTE_TRN ("/pages/paciente/paciente_trn.xhtml");
	
	
	
	String caminho;
	
	private PaginasValues(String caminho) {
		this.caminho = caminho;
	}
	
	public String getCaminho(){
		return caminho;
	}
}
