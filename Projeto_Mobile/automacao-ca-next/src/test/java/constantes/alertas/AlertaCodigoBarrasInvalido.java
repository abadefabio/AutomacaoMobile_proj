package constantes.alertas;

public enum AlertaCodigoBarrasInvalido {

    ALERTA_BLOCO_1_INVALIDO("Bloco 1 inválido!"),
    ALERTA_BLOCO_2_INVALIDO("Bloco 2 inválido!"),
    ALERTA_BLOCO_3_INVALIDO("Bloco 3 inválido!"),
    ALERTA_BLOCO_4_INVALIDO("Código de barras inválido");

    private String value;

    AlertaCodigoBarrasInvalido(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
