package br.com.next.automacao.core.massa.portabilidade;

public class ModeloPortabilidade {
    private String dataCriacaoPortabilidade = null;
    private String CnpjPortabilidade = null;
    private String codigoBancoPortabilidade = null;
    private String nomeBancoPortabilidade = null;
    private String cpfPortabilidade= null;

    public String getCnpjPortabilidade() {
        return CnpjPortabilidade;
    }

    public String getCodigoBancoPortabilidade() {
        return codigoBancoPortabilidade;
    }

    public String getCpfPortabilidade() {
        return cpfPortabilidade;
    }

    public String getDataCriacaoPortabilidade() {
        return dataCriacaoPortabilidade;
    }

    public String getNomeBancoPortabilidade() {
        return nomeBancoPortabilidade;
    }


    public void setCnpjPortabilidade(String cnpjPortabilidade) {
        CnpjPortabilidade = cnpjPortabilidade;
    }

    public void setCodigoBancoPortabilidade(String codigoBancoPortabilidade) {
        this.codigoBancoPortabilidade = codigoBancoPortabilidade;
    }

    public void setCpfPortabilidade(String cpfPortabilidade) {
        this.cpfPortabilidade = cpfPortabilidade;
    }

    public void setDataCriacaoPortabilidade(String dataCriacaoPortabilidade) {
        this.dataCriacaoPortabilidade = dataCriacaoPortabilidade;
    }

    public void setNomeBancoPortabilidade(String nomeBancoPortabilidade) {
        this.nomeBancoPortabilidade = nomeBancoPortabilidade;
    }
}
