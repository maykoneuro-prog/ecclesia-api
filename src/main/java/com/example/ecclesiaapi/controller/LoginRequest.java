package com.example.ecclesiaapi.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {

    @JsonProperty("email")
    private String email;

    @JsonProperty("senha")
    private String senha;

    // GETTERS
    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    // SETTERS (OBRIGATÓRIOS)
    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}