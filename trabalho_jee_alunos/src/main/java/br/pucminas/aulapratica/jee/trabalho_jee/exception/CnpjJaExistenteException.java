package br.pucminas.aulapratica.jee.trabalho_jee.exception;

public class CnpjJaExistenteException extends RuntimeException
{

    private static final long serialVersionUID = 1L;

    public CnpjJaExistenteException(String cnpj)
    {
        super("CPNJ " + cnpj + " já existe.");
    }

    public CnpjJaExistenteException(String cnpj, Throwable throwable)
    {
        super("CPNJ " + cnpj + " já existe.");
    }

}
