package constantes.investimentos;

import static br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio;

public enum Valor {

    DE_UM_A_NOVENTA_E_NOVE(String.valueOf(numeroAleatorio(1, 9999))),
    DE_CEM_A_DUZENTOS_E_CINQUENTA(String.valueOf(numeroAleatorio(10000, 25000))),
    DE_CEM_A_NOVECENTOS_E_NOVENTA_E_NOVE(String.valueOf(numeroAleatorio(10000, 99999))),
    DE_DOIS_MIL_A_TRES_MIL(String.valueOf(numeroAleatorio(200000, 300000)));

    private String value;

    Valor(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
