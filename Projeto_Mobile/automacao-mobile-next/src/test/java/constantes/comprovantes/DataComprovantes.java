package constantes.comprovantes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static br.com.next.automacao.core.tools.Utilitarios.proximoDiaUtil;

public enum DataComprovantes {TITULO_TELA_TNSTRUCOES("Instruções"),

    ANTERIOR_DIA_UTIL(proximoDiaUtil(-1)),
    PROXIMO_DIA_UTIL(proximoDiaUtil(1)),
    PROXIMO_DIA_UTIL_MAIS_2(proximoDiaUtil(2)),
    HOJE(LocalDate.now());

    private String value;

    DataComprovantes(String value){
        this.value = value;
    }

    DataComprovantes(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.value = data.format(formatter);
    }

    @Override
    public String toString(){
        return this.value;
    }
}
