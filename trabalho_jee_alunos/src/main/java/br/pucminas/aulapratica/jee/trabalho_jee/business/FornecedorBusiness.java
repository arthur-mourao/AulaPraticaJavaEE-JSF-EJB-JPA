package br.pucminas.aulapratica.jee.trabalho_jee.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.pucminas.aulapratica.jee.trabalho_jee.entity.FornecedorEntity;
import br.pucminas.aulapratica.jee.trabalho_jee.exception.CnpjJaExistenteException;
import br.pucminas.aulapratica.jee.trabalho_jee.repository.FornecedorRepository;
import br.pucminas.aulapratica.jee.trabalho_jee.resource.FornecedorResource;

@Stateless
public class FornecedorBusiness {
	
	@Inject
	private FornecedorRepository fornecedorRepository;
	
	public void salvarFornecedor(FornecedorResource fornecedorResource){
		String cnpj = fornecedorResource.getCnpj();
		if(fornecedorRepository.getQtdFornecedorByCPNJ(cnpj) == 0 ){
			/*Implementação da lógica de salvar um cliente*/
			FornecedorEntity fornecedorEntity = new FornecedorEntity();
			fornecedorEntity.setId(fornecedorResource.getId());
			fornecedorEntity.setCnpj(fornecedorResource.getCnpj());
			fornecedorEntity.setRazaoSocial(fornecedorResource.getRazaoSocial());
			fornecedorEntity.setEmail(fornecedorResource.getEmail());
			fornecedorEntity.setInscricaoMunicipal(fornecedorResource.getInscricaoMunicipal());
			fornecedorEntity.setEndereco(fornecedorResource.getEndereco());
			fornecedorRepository.salvar(fornecedorEntity);
		}
		else {
			throw new CnpjJaExistenteException(cnpj);
		}
	}
	
	/* Implementação da listagem de clientes conforme desafio 2 */
	public List<FornecedorResource> listarFornecedores(){
		List<FornecedorResource> fornecedorResourceList = new ArrayList<FornecedorResource>();
		for (FornecedorEntity fornecedorEntity : fornecedorRepository.listarFornecedores()) {
			FornecedorResource fornecedorResource = new FornecedorResource();
			fornecedorResource.setId(fornecedorEntity.getId());
			fornecedorResource.setRazaoSocial(fornecedorEntity.getRazaoSocial());
			fornecedorResource.setCnpj(fornecedorEntity.getCnpj());
			fornecedorResource.setEmail(fornecedorEntity.getEmail());
			fornecedorResource.setInscricaoMunicipal(fornecedorEntity.getInscricaoMunicipal());
			fornecedorResource.setEndereco(fornecedorEntity.getEndereco());
			fornecedorResourceList.add(fornecedorResource);
		} 
		
		return fornecedorResourceList;
	}
	
}
