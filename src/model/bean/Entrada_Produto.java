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
public class Entrada_Produto {
    private int ID_entrada; //PK
    private Produto ID_produto; //FK
    private Double qtde;
    private double valor_unitario;

    public int getID_entrada() {
        return ID_entrada;
    }

    public void setID_entrada(int ID_entrada) {
        this.ID_entrada = ID_entrada;
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
