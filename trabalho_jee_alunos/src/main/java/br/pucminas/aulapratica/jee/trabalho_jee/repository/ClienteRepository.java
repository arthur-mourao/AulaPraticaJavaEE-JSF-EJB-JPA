package br.pucminas.aulapratica.jee.trabalho_jee.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.pucminas.aulapratica.jee.trabalho_jee.entity.ClienteEntity;

public class ClienteRepository
{

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm()
    {
        return em;
    }

    public ClienteEntity salvar(ClienteEntity cliente)
    {
        em.persist(cliente);
        return cliente;
    }

    public List<ClienteEntity> listarClientes()
    {
        return em.createQuery("Select c From ClienteEntity c", ClienteEntity.class).getResultList();
    }

    public Long getQtdClienteByCPF(String cpf)
    {
        return (Long) em.createQuery("Select Count(c) From ClienteEntity c Where c.cpf =:cpf").setParameter("cpf", cpf)
                .getSingleResult();
    }

}
