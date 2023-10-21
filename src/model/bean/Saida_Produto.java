/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author gilberto
 */
public class Saida_Produto {
    private int ID_saida; //PK
    private Produto ID_produto; //FK
    private Double qtde;
    private String banho;
    private double valor_unitario;

    public int getID_saida() {
        return ID_saida;
    }

    public void setID_saida(int ID_saida) {
        this.ID_saida = ID_saida;
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

    public String getBanho() {
        return banho;
    }

    public void setBanho(String banho) {
        this.banho = banho;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
   
}
