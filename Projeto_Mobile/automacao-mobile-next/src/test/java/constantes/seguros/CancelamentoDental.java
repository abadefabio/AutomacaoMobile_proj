package constantes.seguros;

public enum CancelamentoDental {
    TEXTO_CANCELAMENTO_1("Já ouviu aquela expressão"),
    TEXTO_CANCELAMENTO_2("Emergência e urgência a qualquer hora"),
    TEXTO_CANCELAMENTO_3("Radiografias e documentações ortodônticas"),
    TEXTO_CANCELAMENTO_4("Mais de 200 procedimentos");
    private String value;

    private CancelamentoDental(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
