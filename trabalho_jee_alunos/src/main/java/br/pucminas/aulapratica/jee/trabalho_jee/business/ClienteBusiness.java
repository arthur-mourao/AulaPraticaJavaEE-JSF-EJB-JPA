package br.pucminas.aulapratica.jee.trabalho_jee.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.pucminas.aulapratica.jee.trabalho_jee.entity.ClienteEntity;
import br.pucminas.aulapratica.jee.trabalho_jee.exception.CpfJaExistenteException;
import br.pucminas.aulapratica.jee.trabalho_jee.repository.ClienteRepository;
import br.pucminas.aulapratica.jee.trabalho_jee.resource.ClienteResource;

/**
 * Classe que gerenciar a criação e listagem de clientes
 *
 */
@Stateless
public class ClienteBusiness
{

    @Inject
    private ClienteRepository clienteRepository;

    /**
     * Salva um cliente no Repository, se o CPF fornecido não existir no banco
     *
     * @param clienteResource
     *            Recurso a ser armazenado
     */
    public void salvarCliente(ClienteResource clienteResource)
    {
        String cpf = clienteResource.getCpf();
        if (clienteRepository.getQtdClienteByCPF(cpf) == 0)
        {
            /* Implementação da lógica de salvar um cliente */
            ClienteEntity clienteEntity = new ClienteEntity();
            clienteEntity.setId(clienteResource.getId());
            clienteEntity.setCpf(clienteResource.getCpf());
            clienteEntity.setNome(clienteResource.getNome());
            clienteEntity.setEmail(clienteResource.getEmail());
            clienteEntity.setDataNascimento(clienteResource.getDataNascimento());
            clienteRepository.salvar(clienteEntity);
        }
        else
        {
            throw new CpfJaExistenteException(cpf);
        }
    }

    /**
     * Implementação da listagem de clientes conforme desafio 2
     *
     * @return Lista de Clientes existentes no banco
     */
    public List<ClienteResource> listarClientes()
    {
        List<ClienteResource> clienteResourceList = new ArrayList<ClienteResource>();
        for (ClienteEntity clienteEntity : clienteRepository.listarClientes())
        {
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
