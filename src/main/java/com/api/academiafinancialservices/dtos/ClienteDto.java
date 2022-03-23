package com.api.academiafinancialservices.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClienteDto {

    @NotBlank
    @Size(max = 30)
    private String nome;

    @NotBlank
    @Size(max = 14)
    private String cpfCnpj;

    @NotBlank
    @Size(max = 50)
    private String logradouro;

    @NotBlank
    @Size(max = 40)
    private String cidade;

    @NotBlank
    @Size(max = 2)
    private String uf;

    @NotBlank
    @Size(max = 8)
    private String cep;

    @Size(max = 11)
    private String telefone;

    @Size(max = 100)
    private String email;

    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
}
