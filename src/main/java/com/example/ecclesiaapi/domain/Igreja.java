package com.example.ecclesiaapi.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "igrejas")
public class Igreja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    /**
     * SEDE | PAROQUIA | MISSAO | COMUNIDADE
     */
    private String tipo;

    private String cnpj;

    private Boolean ativa;

    /* RELACIONAMENTO HIERÁRQUICO */
    @ManyToOne
    @JoinColumn(name = "igreja_pai_id")
    private Igreja igrejaPai;

    /* RESPONSÁVEL (BISPO / PÁROCO / LÍDER) */
    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Pessoa responsavel;

    /* ENDEREÇO */
    private String cep;
    private String pais;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;

    /* GETTERS E SETTERS */

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public Igreja getIgrejaPai() {
        return igrejaPai;
    }

    public void setIgrejaPai(Igreja igrejaPai) {
        this.igrejaPai = igrejaPai;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
