package constantes;

import br.com.next.automacao.core.tools.Utilitarios;

public enum GeradorGlobal {

    CPF_NUMERICO_INVALIDO("00000000000"),
    CPF_ALFABETICO_INVALIDO("ABCDEFGHIJK"),
    CPF_EM_BRANCO(""),
    CPF_ALEATORIO_VALIDO(Utilitarios.gerarCpf()),
    URL_REGEX_NEXTME(".*next.me.*"),
    NEXTME("O next é um banco");

    String value;
    GeradorGlobal(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return this.value;
    }
}
