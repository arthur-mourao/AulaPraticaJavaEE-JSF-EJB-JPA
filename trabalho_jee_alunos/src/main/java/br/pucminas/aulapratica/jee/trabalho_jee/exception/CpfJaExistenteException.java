package br.pucminas.aulapratica.jee.trabalho_jee.exception;

public class CpfJaExistenteException extends RuntimeException
{

    private static final long serialVersionUID = 1L;

    public CpfJaExistenteException(String cpf)
    {
        super("CPF " + cpf + " já existe.");
    }

    public CpfJaExistenteException(String cpf, Throwable throwable)
    {
        super("CPF " + cpf + " já existe.");
    }

}
