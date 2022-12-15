package constantes.seguros;

public enum CancelamentoDental {
    TEXTO_CANCELAMENTO_1("J� ouviu aquela express�o"),
    TEXTO_CANCELAMENTO_2("Emerg�ncia e urg�ncia a qualquer hora"),
    TEXTO_CANCELAMENTO_3("Radiografias e documenta��es ortod�nticas"),
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
