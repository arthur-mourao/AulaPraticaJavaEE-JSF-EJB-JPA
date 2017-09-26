package br.pucminas.aulapratica.jee.trabalho_jee.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import br.pucminas.aulapratica.jee.trabalho_jee.business.ClienteBusiness;
import br.pucminas.aulapratica.jee.trabalho_jee.resource.ClienteResource;

@Model
public class ClienteBean {

	/*Neste ponto deve-se incluir o EJB para ser usado nos desafions 1 e 2*/
	@EJB
	private ClienteBusiness clienteBusiness;
	/*Neste ponto, serão incluídas as propriedades de classe que serão usadas para 
	 * exibir as informações em tela.*/
	private ClienteResource clienteResource = new ClienteResource();

	/* Implementação da listagem de clientes conforme desafio 2 */
	

	public void salvarCliente() {
		/*Implementação da lógica de salvar um cliente. Neste ponto deve-se tratar as mensagens 
		 * conforme solicitado no desafio 1*/
		try {
			clienteBusiness.salvarCliente(clienteResource);
			FacesContext.getCurrentInstance().addMessage("formCliente:messages", 
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Adicionado com Sucesso!", ""));
		}catch (RuntimeException e) {
			FacesContext.getCurrentInstance().addMessage("formCliente:messages", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public List<ClienteResource> getListaClientes(){
		return clienteBusiness.listarClientes();
	}


	public ClienteBusiness getClienteBusiness() {
		return clienteBusiness;
	}


	public void setClienteBusiness(ClienteBusiness clienteBusiness) {
		this.clienteBusiness = clienteBusiness;
	}


	public ClienteResource getClienteResource() {
		return clienteResource;
	}


	public void setClienteResource(ClienteResource clienteResource) {
		this.clienteResource = clienteResource;
	}

}
