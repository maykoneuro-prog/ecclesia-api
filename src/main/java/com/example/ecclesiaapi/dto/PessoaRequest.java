package com.example.ecclesiaapi.dto;

import java.time.LocalDate;

public class PessoaRequest {

    // IDENTIDADE
    public String nome;
    public String cpf;
    public String email;
    public String telefone;

    // PAPEL ECLESIÁSTICO
    public String tipo; // MEMBRO, PASTOR, BISPO, VISITANTE, CLERO

    // VÍNCULO INSTITUCIONAL
    public String igreja;

    // STATUS
    public Boolean ativo;
    public LocalDate dataInativacao;

    // FOTO
    public String foto;

    // ENDEREÇO
    public String cep;
    public String pais;
    public String endereco;
    public String numero;
    public String complemento;
    public String bairro;
    public String cidade;
}