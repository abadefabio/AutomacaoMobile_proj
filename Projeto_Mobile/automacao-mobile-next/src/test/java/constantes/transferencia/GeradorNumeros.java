package constantes.transferencia;

import br.com.next.automacao.core.tools.Utilitarios;

import static br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio;

public enum GeradorNumeros {

    CONTA_ALEATORIA(String.valueOf(numeroAleatorio(10000,99999))),
    AGENCIA_ALEATORIA(String.valueOf(numeroAleatorio(1000,9999))),
    CPF_ALEATORIO(Utilitarios.gerarCpf()),
    CPF_INVALIDO("00000000000"),
    CNPJ_INVALIDO("00000000000000");

    private String valor;

    GeradorNumeros(String valor) {
       this.valor = valor;
    }


    public String toString() {
        return this.valor;
    }

}