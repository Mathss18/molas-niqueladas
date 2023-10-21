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
public class Saida {
    private int ID_saida;
    private String nome;
    private Produto produto;

    public int getID_saida() {
        return ID_saida;
    }

    public void setID_saida(int ID_saida) {
        this.ID_saida = ID_saida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
