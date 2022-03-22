package com.api.academiafinancialservices.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioDto {

    @NotBlank
    @Size(max = 30)
    private String nome;

    @NotBlank
    @Size(max = 15)
    private String login;

    @NotBlank
    @Size(max = 10)
    private String senha;

    @Size(max = 11)
    private String telefone;

    @Size(max = 100)
    private String email;

    @NotBlank
    private char perfil;

    @NotBlank
    private char status;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getPerfil() {
        return perfil;
    }

    public void setPerfil(char perfil) {
        this.perfil = perfil;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
