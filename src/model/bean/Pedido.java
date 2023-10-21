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
public class Pedido {
    
    private int ID_pedido;
    private String OF;
    private String codigo;
    private String data_pedido;
    private String data_entrega;
    private int quantidade;
    private String tipo;
    private Cliente cliente;
    private String status;
    private String path_desenho;
    private String nome_cliente;//nao nativa
    private String qtde_itens_mes;//nao nativa

    public String getQtde_itens_mes() {
        return qtde_itens_mes;
    }

    public void setQtde_itens_mes(String qtde_itens_mes) {
        this.qtde_itens_mes = qtde_itens_mes;
    }

    public String getPath_desenho() {
        return path_desenho;
    }

    public void setPath_desenho(String path_desenho) {
        this.path_desenho = path_desenho;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  
   
    
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   
    

    public int getID_pedido() {
        return ID_pedido;
    }

    public void setID_pedido(int ID_pedido) {
        this.ID_pedido = ID_pedido;
    }

    public String getOF() {
        return OF;
    }

    public void setOF(String OF) {
        this.OF = OF;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(String data_pedido) {
        this.data_pedido = data_pedido;
    }

    public String getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(String data_entrega) {
        this.data_entrega = data_entrega;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
