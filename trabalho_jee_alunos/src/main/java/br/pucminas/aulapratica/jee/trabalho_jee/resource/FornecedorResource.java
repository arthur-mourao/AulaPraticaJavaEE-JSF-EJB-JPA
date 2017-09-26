package br.pucminas.aulapratica.jee.trabalho_jee.resource;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FornecedorResource {

	private Long id;
	
	@NotNull
	@Size(min=15,max=300)
	private String razaoSocial;
	
	@NotNull
	@Size(min=14,max=14)
	private String cnpj;

	private String endereco;
	
	private String inscricaoMunicipal;

	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
