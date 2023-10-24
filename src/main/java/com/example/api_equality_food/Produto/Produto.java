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
    private String tipo;
    private double preco;
    @Column(name = "data_validade")
    private LocalDate data_validade;

    private String descricao;
    private String categoria;
    private String imagem;

    public Produto(int id, int fk_Administrador_id, String nome, String tipo, double preco, LocalDate data_validade, String descricao, String categoria, String imagem) {
        this.id = id;
        this.fk_Administrador_id = fk_Administrador_id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.data_validade = data_validade;
        this.descricao = descricao;
        this.categoria = categoria;
        this.imagem = imagem;
    }

    public Produto() {

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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


}