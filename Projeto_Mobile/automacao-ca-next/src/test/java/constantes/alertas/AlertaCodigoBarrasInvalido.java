package constantes.alertas;

public enum AlertaCodigoBarrasInvalido {

    ALERTA_BLOCO_1_INVALIDO("Bloco 1 inv�lido!"),
    ALERTA_BLOCO_2_INVALIDO("Bloco 2 inv�lido!"),
    ALERTA_BLOCO_3_INVALIDO("Bloco 3 inv�lido!"),
    ALERTA_BLOCO_4_INVALIDO("C�digo de barras inv�lido");

    private String value;

    AlertaCodigoBarrasInvalido(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
