package com.example.ecclesiaapi.dto;

public class AprovacaoRequest {

    // USUÁRIO (ACESSO AO SISTEMA)
    private String perfilUsuario; // MASTER, SEDE, FILIAL

    // PESSOA (REGRA ECLESIÁSTICA)
    private String nome;
    private String email;
    private String tipoPessoa; // MEMBRO, PASTOR, BISPO, VISITANTE

    public String getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(String perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}