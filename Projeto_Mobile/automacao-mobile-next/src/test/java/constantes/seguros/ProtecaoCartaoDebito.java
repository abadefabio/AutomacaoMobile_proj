package constantes.seguros;

public enum ProtecaoCartaoDebito {
    DEBITO("debito"),
    CREDITO("credito"),
    ODONTO("odonto"),
    VALIDARCONTRATACAOCARTAODEBITO("Agora � s� aguardar a ativa��o"),
    TEXTOCARTAODEBITO("Proteja seu cart�o de d�bito contra transa��es decorrentes de roubo do cart�o ou coa��o.");

    private String value;

    private ProtecaoCartaoDebito(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
