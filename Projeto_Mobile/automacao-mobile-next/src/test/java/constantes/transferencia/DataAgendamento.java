package constantes.transferencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static br.com.next.automacao.core.tools.Utilitarios.proximoDiaUtil;
import static br.com.next.automacao.core.tools.Utilitarios.retornaDataDiaUtil;

public enum DataAgendamento {TITULO_TELA_TNSTRUCOES("Instruções"),

    PROXIMO_DIA_UTIL(proximoDiaUtil(1)),
    PROXIMO_DIA_UTIL_MAIS_2(retornaDataDiaUtil(2)),
    PROXIMO_DIA_UTIL_MAIS_20(retornaDataDiaUtil(20)),
    HOJE(LocalDate.now());

    private String value;

    DataAgendamento(String value){
        this.value = value;
    }

    DataAgendamento(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.value = data.format(formatter);
    }

    @Override
    public String toString(){
        return this.value;
    }
}
