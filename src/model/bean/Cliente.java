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
public class Cliente {
    private int ID_CLIENTE;
    private String NOME;
    private String CPF_CNPJ;
    private String CONTATO;
    //Endereço e Contato
    private String LOGRADOURO;
    private String CIDADE;
    private String NUMERO;
    private String UF;
    private String TELEFONE;
    private String TELEFONE2;
    private String INSCRICAO_ESTADUAL;
    private String EMAIL;
    private String CEP;
    private String BAIRRO;

    public String getINSCRICAO_ESTADUAL() {
        return INSCRICAO_ESTADUAL;
    }

    public void setINSCRICAO_ESTADUAL(String INSCRICAO_ESTADUAL) {
        this.INSCRICAO_ESTADUAL = INSCRICAO_ESTADUAL;
    }

    public String getTELEFONE2() {
        return TELEFONE2;
    }

    public void setTELEFONE2(String TELEFONE2) {
        this.TELEFONE2 = TELEFONE2;
    }

    public String getCONTATO() {
        return CONTATO;
    }

    public void setCONTATO(String CONTATO) {
        this.CONTATO = CONTATO;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getBAIRRO() {
        return BAIRRO;
    }

    public void setBAIRRO(String BAIRRO) {
        this.BAIRRO = BAIRRO;
    }
    

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }


    public String getLOGRADOURO() {
        return LOGRADOURO;
    }

    public void setLOGRADOURO(String LOGRADOURO) {
        this.LOGRADOURO = LOGRADOURO;
    }

    public String getCIDADE() {
        return CIDADE;
    }

    public void setCIDADE(String CIDADE) {
        this.CIDADE = CIDADE;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getTELEFONE() {
        return TELEFONE;
    }

    public void setTELEFONE(String TELEFONE) {
        this.TELEFONE = TELEFONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
    
    @Override
    public String toString() {
        return getNOME(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
