package constantes.seguros;

public enum ProtecaoCartaoDebito {
    DEBITO("debito"),
    CREDITO("credito"),
    ODONTO("odonto"),
    VALIDARCONTRATACAOCARTAODEBITO("Agora é só aguardar a ativação"),
    TEXTOCARTAODEBITO("Proteja seu cartão de débito contra transações decorrentes de roubo do cartão ou coação.");

    private String value;

    private ProtecaoCartaoDebito(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
