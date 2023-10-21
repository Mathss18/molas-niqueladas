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
public class Qualidade {
    private int ID_qualidade;
    private int of;
    private String codigo;
    private Cliente cliente;
    private int qtde;
    private int sobra;
    private String abertura;
    private String arame;
    private String externo;
    private String interno;
    private String passo;
    private String lo_corpo;
    private String lo_total;
    private String espiras;
    private String acabamento;
    private String obs;
    
    //========NAO NATIVA========
    private int ID_cliente;
    private String nome_cliente;

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public int getID_qualidade() {
        return ID_qualidade;
    }

    public void setID_qualidade(int ID_qualidade) {
        this.ID_qualidade = ID_qualidade;
    }

    public int getOf() {
        return of;
    }

    public void setOf(int of) {
        this.of = of;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public int getSobra() {
        return sobra;
    }

    public void setSobra(int sobra) {
        this.sobra = sobra;
    }

    public String getAbertura() {
        return abertura;
    }

    public void setAbertura(String abertura) {
        this.abertura = abertura;
    }

    public String getArame() {
        return arame;
    }

    public void setArame(String arame) {
        this.arame = arame;
    }

    public String getExterno() {
        return externo;
    }

    public void setExterno(String externo) {
        this.externo = externo;
    }

    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
    }

    public String getPasso() {
        return passo;
    }

    public void setPasso(String passo) {
        this.passo = passo;
    }

    public String getLo_corpo() {
        return lo_corpo;
    }

    public void setLo_corpo(String lo_corpo) {
        this.lo_corpo = lo_corpo;
    }

    public String getLo_total() {
        return lo_total;
    }

    public void setLo_total(String lo_total) {
        this.lo_total = lo_total;
    }

    public String getEspiras() {
        return espiras;
    }

    public void setEspiras(String espiras) {
        this.espiras = espiras;
    }

    public String getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(String acabamento) {
        this.acabamento = acabamento;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    private Date data;
}
