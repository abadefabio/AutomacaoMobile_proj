package constantes.transferencia;

import static constantes.transferencia.TipoDeInstituicaoFinanceira.BANCO;

public enum TransferenciaAgendamento {TITULO_TELA_TNSTRUCOES("Instruções"),

    MENSAGEM_CONFIRMACAO_AGENDAMENTO("Agendamento realizado com sucesso");

    private String value;

    TransferenciaAgendamento(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return this.value;
    }
}
