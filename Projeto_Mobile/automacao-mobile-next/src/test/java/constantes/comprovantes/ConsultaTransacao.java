package constantes.comprovantes;

public enum ConsultaTransacao {

    DEBITOS_DE_VEICULOS("DEBEITOS DE VEICULOS"),
    CONTA_DE_CONSUMO("CONTA DE CONSUMO"),
    BOLETO_DE_COBRANCA("BOLETO DE COBRANÇA"),
    CONTA_DE_PAGAMENTO("CONTA DEP AGAMENTO"),
    TRANSFERENCIA_BANCARIA("TRANSFERÊNCIA BANCÁRIA"),
    TRANSFERENCIA_INTERBANCARIA("TRANSFERÊNCIA INTERBANCÁRIA"),
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
