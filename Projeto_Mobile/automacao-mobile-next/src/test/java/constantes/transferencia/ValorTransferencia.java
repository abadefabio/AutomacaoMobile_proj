package constantes.transferencia;

import static br.com.next.automacao.core.tools.Utilitarios.*;

public enum ValorTransferencia {

    VALOR_ALEATORIO_ATE_5000(String.valueOf(numeroAleatorio(1000,499999))),
    VALOR_ALEATORIO_100_A_500(String.valueOf(numeroAleatorio(10000,49999))),
    VALOR_ACIMA_LIMITE(String.valueOf(5000001)),
    VALOR_ALEATORIO_5_A_10(String.valueOf(numeroAleatorio(500,999))),
    VALOR_ALEATORIO_50_A_100(String.valueOf(numeroAleatorio(5000,9999))),
    VALOR_ALEATORIO_ACIMA_DE_5000(String.valueOf(numeroAleatorio(500000,1000000)));

    private String valor;

    ValorTransferencia(String valor) {
       this.valor = valor;
    }

    public String recuperarValor() {
        return this.valor;
    }

    public String toString() {
        return recuperarValor();
    }
}
