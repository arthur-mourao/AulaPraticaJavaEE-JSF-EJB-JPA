package br.pucminas.aulapratica.jee.trabalho_jee.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.pucminas.aulapratica.jee.trabalho_jee.entity.FornecedorEntity;

public class FornecedorRepository {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public FornecedorEntity salvar(FornecedorEntity fornecedor) {
		//Implementar a lógica para persistir um cliente na base de dados usando o EntityManager
		em.persist(fornecedor);
		return fornecedor;
	}
	
	public List<FornecedorEntity> listarFornecedores(){
		return em.createQuery("Select f From FornecedorEntity f", FornecedorEntity.class).getResultList();
	}
	
	public Long getQtdFornecedorByCPNJ(String cnpj){
		return (Long)em.createQuery("Select Count(f) From FornecedorEntity f Where f.cnpj =:cnpj").setParameter("cnpj", cnpj).getSingleResult();
	}


}
