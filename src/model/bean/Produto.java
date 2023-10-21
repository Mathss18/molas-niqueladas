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
public class Produto {
    private int ID_produto;
    private String nome;
    private String utilizacao;
    private String estoque_minimo;
    private Double ideal_dia;

    public String getEstoque_minimo() {
        return estoque_minimo;
    }

    public void setEstoque_minimo(String estoque_minimo) {
        this.estoque_minimo = estoque_minimo;
    }

    public Double getIdeal_dia() {
        return ideal_dia;
    }

    public void setIdeal_dia(Double ideal_dia) {
        this.ideal_dia = ideal_dia;
    }

    
    

    public int getID_produto() {
        return ID_produto;
    }

    public void setID_produto(int ID_produto) {
        this.ID_produto = ID_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUtilizacao() {
        return utilizacao;
    }

    public void setUtilizacao(String utilizacao) {
        this.utilizacao = utilizacao;
    }

    @Override
    public String toString() {
        return getNome(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
