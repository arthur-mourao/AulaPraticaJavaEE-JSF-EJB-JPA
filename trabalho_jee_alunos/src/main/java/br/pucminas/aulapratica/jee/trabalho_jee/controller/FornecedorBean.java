package br.pucminas.aulapratica.jee.trabalho_jee.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.pucminas.aulapratica.jee.trabalho_jee.business.FornecedorBusiness;
import br.pucminas.aulapratica.jee.trabalho_jee.resource.FornecedorResource;

@Model
public class FornecedorBean
{

    @EJB
    private FornecedorBusiness fornecedorBusiness;

    /**
     * Propriedades de classe que serão usadas para exibir as informações em
     * tela.
     */
    private FornecedorResource fornecedorResource = new FornecedorResource();

    /**
     * Invoca o EJB para armezenar um novo fornecedor
     */
    public void salvarFornecedor()
    {
        /*
         * Implementação da lógica de salvar um fornecedor. Tratando as
         * mensagens conforme solicitado no desafio 1
         */
        try
        {
            fornecedorBusiness.salvarFornecedor(fornecedorResource);
            FacesContext.getCurrentInstance().addMessage("formFornecedor:messages",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornecedor Adicionado com Sucesso!", ""));
        } catch (RuntimeException e)
        {
            FacesContext.getCurrentInstance().addMessage("formFornecedor:messages",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        }
    }

    /**
     * Invoca o EJB para listar os fornecedores cadastrados
     *
     * @return Lista de fornecedores
     */
    public List<FornecedorResource> getListaFornecedores()
    {
        return fornecedorBusiness.listarFornecedores();
    }

    public FornecedorBusiness getFornecedorBusiness()
    {
        return fornecedorBusiness;
    }

    public void setFornecedorBusiness(FornecedorBusiness fornecedorBusiness)
    {
        this.fornecedorBusiness = fornecedorBusiness;
    }

    public FornecedorResource getFornecedorResource()
    {
        return fornecedorResource;
    }

    public void setFornecedorResource(FornecedorResource fornecedorResource)
    {
        this.fornecedorResource = fornecedorResource;
    }

}
