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
public class Faturamento {

    private int ID_faturamento;
    private String vale;
    private String nfe;
    private String situacao;
    private Cliente cliente;
    private Double peso;
    private Double valor;
    private Date data;
    private String firma;

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }
    //======================
    private String nome_cliente; // nao nativa
    private Double valor_total; // nao nativa
    private Double valor_aberto; // nao nativa
    private Double peso_total; // nao nativa

    public Double getValor_aberto() {
        return valor_aberto;
    }

    public void setValor_aberto(Double valor_aberto) {
        this.valor_aberto = valor_aberto;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public Double getPeso_total() {
        return peso_total;
    }

    public void setPeso_total(Double peso_total) {
        this.peso_total = peso_total;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public int getID_faturamento() {
        return ID_faturamento;
    }

    public void setID_faturamento(int ID_faturamento) {
        this.ID_faturamento = ID_faturamento;
    }

    public String getVale() {
        return vale;
    }

    public void setVale(String vale) {
        this.vale = vale;
    }

    public String getNfe() {
        return nfe;
    }

    public void setNfe(String nfe) {
        this.nfe = nfe;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object f) {
        Faturamento faturamento = (Faturamento) f;
        return this.getNome_cliente().equals(faturamento.getNome_cliente());
    }

}
