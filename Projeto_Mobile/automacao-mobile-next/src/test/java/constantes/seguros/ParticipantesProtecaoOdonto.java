package constantes.seguros;

public enum ParticipantesProtecaoOdonto {
    PRA_MIM("Pra Mim"),
    PRA_MIM_E_DEPENDENTES("Pra mim e Dependentes"),
    APENAS_DEPENDENTES("Apenas Dependentes");

    private String value;

    private ParticipantesProtecaoOdonto(String value) {
        this.value = value;
    }
}
