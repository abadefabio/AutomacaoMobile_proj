package br.com.next.automacao.core.tools.geradores.agencia;

import org.testng.util.Strings;

public class AgenciaConta {

    private String banco;
    private String agencia;
    private String digitoAgencia = "";
    private String conta;
    private String tipoDeContaSantander;
    private String tipoDeContaCaixaEconomicaFederal;

    public String getTipoDeContaCaixaEconomicaFederal() {
        if (tipoDeContaCaixaEconomicaFederal == null)
            return "N/A";
        return tipoDeContaCaixaEconomicaFederal;
    }
    public void setTipoDeContaCaixaEconomicaFederal(String tipoDeContaCaixaEconomicaFederal) {
        this.tipoDeContaCaixaEconomicaFederal = tipoDeContaCaixaEconomicaFederal;
    }

    public String getTipoDeContaSantander() {
        if (tipoDeContaSantander == null)
            return "N/A";
        return tipoDeContaSantander;
    }
    public void setTipoDeContaSantander(String tipoDeContaSantander) {
        this.tipoDeContaSantander = tipoDeContaSantander;
    }

    public String getConta() {
        return conta;
    }
    public void setConta(String conta) {
        this.conta = removeZerosEsquerda(conta);
    }

    protected void setAgencia(String agencia) {
        this.agencia = removeZerosEsquerda(agencia);
    }

    public String getAgencia() {
        return agencia;
    }

    protected void setBanco(String banco) {
        this.banco = banco;
    }
    public String getBanco() {
        return banco;
    }

    public String getDigitoAgencia() {
        return digitoAgencia;
    }

    protected void setDigitoAgencia(String digitoAgencia) {
        this.digitoAgencia = digitoAgencia;
    }


    /**
     * Tratamento para remover zeros a esquerda da agência e conta
     * @param numero
     * @return
     */
    private String removeZerosEsquerda(String numero){
        int contaZeros = 0;
        for(int i = 0; i < numero.length(); i++){
            if(numero.charAt(i) == '0'){
                contaZeros++;
            }
            else{
                break;
            }
        }
        return numero.substring(contaZeros, numero.length());
    }

}
