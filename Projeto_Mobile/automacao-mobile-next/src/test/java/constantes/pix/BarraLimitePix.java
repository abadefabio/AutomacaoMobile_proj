package constantes.pix;

import static br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio;

public enum BarraLimitePix {
    ALEATORIO_MINIMO(numeroAleatorio(1,49)),
    ALEATORIO_MAXIMO(numeroAleatorio(51,100));

    private int value;

    BarraLimitePix(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
