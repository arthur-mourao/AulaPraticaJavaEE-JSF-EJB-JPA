package br.pucminas.aulapratica.jee.trabalho_jee.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.pucminas.aulapratica.jee.trabalho_jee.entity.ClienteEntity;
import br.pucminas.aulapratica.jee.trabalho_jee.repository.ClienteRepository;
import br.pucminas.aulapratica.jee.trabalho_jee.resource.ClienteResource;

@Stateless
public class ClienteBusiness {
	
	@Inject
	private ClienteRepository clienteRepository;
	
	public void salvarCliente(ClienteResource clienteResource){
		/*Implementação da lógica de salvar um cliente*/
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setId(clienteResource.getId());
		clienteEntity.setCpf(clienteResource.getCpf());
		clienteEntity.setNome(clienteResource.getNome());
		clienteEntity.setEmail(clienteResource.getEmail());
		clienteEntity.setDataNascimento(clienteResource.getDataNascimento());
		clienteRepository.salvar(clienteEntity);
	}
	
	/* Implementação da listagem de clientes conforme desafio 2 */
	public List<ClienteResource> listarClientes(){
		List<ClienteResource> clienteResourceList = new ArrayList<ClienteResource>();
		for (ClienteEntity clienteEntity : clienteRepository.listarClientes()) {
			ClienteResource clienteResource = new ClienteResource();
			clienteResource.setId(clienteEntity.getId());
			clienteResource.setNome(clienteEntity.getNome());
			clienteResource.setCpf(clienteEntity.getCpf());
			clienteResource.setEmail(clienteEntity.getEmail());
			clienteResource.setDataNascimento(clienteEntity.getDataNascimento());
			clienteResourceList.add(clienteResource);
		} 
		
		return clienteResourceList;
	}
	
}
