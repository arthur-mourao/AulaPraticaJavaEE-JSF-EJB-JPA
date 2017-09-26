package br.pucminas.aulapratica.jee.trabalho_jee.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import br.pucminas.aulapratica.jee.trabalho_jee.business.FornecedorBusiness;
import br.pucminas.aulapratica.jee.trabalho_jee.exception.CnpjJaExistenteException;
import br.pucminas.aulapratica.jee.trabalho_jee.resource.FornecedorResource;

@Model
public class FornecedorBean {

	/*Neste ponto deve-se incluir o EJB para ser usado nos desafions 1 e 2*/
	@EJB
	private FornecedorBusiness fornecedorBusiness;
	/*Neste ponto, serão incluídas as propriedades de classe que serão usadas para 
	 * exibir as informações em tela.*/
	private FornecedorResource fornecedorResource = new FornecedorResource();

	/* Implementação da listagem de clientes conforme desafio 2 */
	

	public void salvarFornecedor() {
		/*Implementação da lógica de salvar um cliente. Neste ponto deve-se tratar as mensagens 
		 * conforme solicitado no desafio 1*/
		try {
		fornecedorBusiness.salvarFornecedor(fornecedorResource);
		FacesContext.getCurrentInstance().addMessage("formFornecedor:messages", 
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornecedor Adicionado com Sucesso!", ""));
		}catch (RuntimeException e) {
			FacesContext.getCurrentInstance().addMessage("formFornecedor:messages", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public List<FornecedorResource> getListaFornecedores(){
		return fornecedorBusiness.listarFornecedores();
	}


	public FornecedorBusiness getFornecedorBusiness() {
		return fornecedorBusiness;
	}


	public void setFornecedorBusiness(FornecedorBusiness fornecedorBusiness) {
		this.fornecedorBusiness = fornecedorBusiness;
	}


	public FornecedorResource getFornecedorResource() {
		return fornecedorResource;
	}


	public void setFornecedorResource(FornecedorResource fornecedorResource) {
		this.fornecedorResource = fornecedorResource;
	}

}
