package com.example.api_equality_food.Produto;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int fk_Administrador_id;
    private String nome;
    private double preco;
    @Column(name = "data_validade")
    private LocalDate data_validade;
    private int quant;
    private String descricao;
    private String categoria;
    private String imagem;
    private boolean ativado;

    public Produto(int id, int fk_Administrador_id, String nome, double preco, LocalDate data_validade, int quant, String descricao, String categoria, String imagem, boolean ativado) {
        this.id = id;
        this.fk_Administrador_id = fk_Administrador_id;
        this.nome = nome;
        this.preco = preco;
        this.data_validade = data_validade;
        this.quant = quant;
        this.descricao = descricao;
        this.categoria = categoria;
        this.imagem = imagem;
        this.ativado = ativado;
    }

    public Produto() {

    }

    public int getQuant() {
        return quant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_Administrador_id() {
        return fk_Administrador_id;
    }

    public void setFk_Administrador_id(int fk_Administrador_id) {
        this.fk_Administrador_id = fk_Administrador_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getData_validade() {
        return data_validade;
    }

    public void setData_validade(LocalDate data_validade) {
        this.data_validade = data_validade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public boolean isAtivado() {
        return ativado;
    }

    public void setAtivado(boolean ativado) {
        this.ativado = ativado;
    }

    public void setQuant(int novaQuant) {
    }
}