package constantes.transferencia;

public enum TransferenciaMotivo {

    CREDITO_EM_CONTA_CORRENTE("CREDITO EM CONTA CORRENTE"),
    CREDITO_EM_CONTA_PG("CREDITO EM CONTA - PG"),
    CREDITO_EM_CONTA("CREDITO EM CONTA"),
    DOC_PARA_POUPANCA("DOC PARA POUPANCA"),
    DOC_PARA_POUPANCA_COM_ESPACO_DUPLO("DOC  PARA POUPANCA"),
    TRANSF_ENTRE_CTAS_MM_TITULARID("TRANSF ENTRE CTAS MM TITULARID"),
    TRANSF_ENTRE_CTAS_MM_TITULA_PG("TRANSF ENTRE CTAS MM TITULA PG"),
    OUTROS("OUTROS");

    private String value;

    TransferenciaMotivo(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return this.value;
    }
}
