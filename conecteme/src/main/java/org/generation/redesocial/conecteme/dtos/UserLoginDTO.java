package org.generation.redesocial.conecteme.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginDTO {
	
	@NotBlank(message = "Inserir 'email' valido")
	@Email
	private String email;
	
	@NotBlank(message = "Inserir 'senha' de 4 a 15 caracteres")
	@Size(min = 3, max = 15)
	private String senha;
	
	private String token;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
