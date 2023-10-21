/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Date;

/**
 *
 * @author gilberto
 */
public class Estoque {
    private int ID_estoque; //PK
    private Produto ID_produto; //FK
    private Double qtde;
    private String nome;
    private double valor_unitario;
    private String utilizacao;
    //----------------------------------------
    private Date data;//nao nativa
    private Double estoque_minimo;//nao nativa
    private Float ideal_dia;//nao nativa
    private Float quantidade_utilizada;//nao nativa
    private int dias_trabalhados;//nao nativa
    private String produto_coringa;

    public String getProduto_coringa() {
        return produto_coringa;
    }

    public void setProduto_coringa(String produto_coringa) {
        this.produto_coringa = produto_coringa;
    }

    public int getDias_trabalhados() {
        return dias_trabalhados;
    }

    public void setDias_trabalhados(int dias_trabalhados) {
        this.dias_trabalhados = dias_trabalhados;
    }
    public Float getIdeal_dia() {
        return ideal_dia;
    }

    public void setIdeal_dia(Float ideal_dia) {
        this.ideal_dia = ideal_dia;
    }

    public Float getQuantidade_utilizada() {
        return quantidade_utilizada;
    }

    public void setQuantidade_utilizada(Float quantidade_utilizada) {
        this.quantidade_utilizada = quantidade_utilizada;
    }

    

    public Double getEstoque_minimo() {
        return estoque_minimo;
    }

    public void setEstoque_minimo(Double estoque_minimo) {
        this.estoque_minimo = estoque_minimo;
    }

    

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
    

    public String getNome() {
        return nome;
    }

    public String getUtilizacao() {
        return utilizacao;
    }

    public void setUtilizacao(String utilizacao) {
        this.utilizacao = utilizacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public int getID_estoque() {
        return ID_estoque;
    }

    public void setID_estoque(int ID_estoque) {
        this.ID_estoque = ID_estoque;
    }

    public Produto getID_produto() {
        return ID_produto;
    }

    public void setID_produto(Produto ID_produto) {
        this.ID_produto = ID_produto;
    }

    public Double getQtde() {
        return qtde;
    }

    public void setQtde(Double qtde) {
        this.qtde = qtde;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
    
}
