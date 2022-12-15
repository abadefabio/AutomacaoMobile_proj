package constantes.pix;

import static br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio;

public enum ValorPix {
    MINIMO("0"),
    MAXIMO("60000"),
    TRINTA_MIL("30000"),
    TRINTA_MIL_ANDROID("3000000"),
    ALEATORIO(String.valueOf(numeroAleatorio(50000,1000000))),
    ALEATORIO_MINIMO(String.valueOf(numeroAleatorio(100,499))),
    ALEATORIO_MAXIMO(String.valueOf(numeroAleatorio(50000,60000)));

    private String value;

    ValorPix(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
