package constantes.comprovantes;

public enum ConsultaTransacao {

    DEBITOS_DE_VEICULOS("DEBEITOS DE VEICULOS"),
    CONTA_DE_CONSUMO("CONTA DE CONSUMO"),
    BOLETO_DE_COBRANCA("BOLETO DE COBRAN�A"),
    CONTA_DE_PAGAMENTO("CONTA DEP AGAMENTO"),
    TRANSFERENCIA_BANCARIA("TRANSFER�NCIA BANC�RIA"),
    TRANSFERENCIA_INTERBANCARIA("TRANSFER�NCIA INTERBANC�RIA"),
    TRIBUTOS("TRIBUTOS");

    private String value;

    ConsultaTransacao(String value){
        this.value = value;

    }

    @Override
    public String toString(){
        return this.value;

    }
}
