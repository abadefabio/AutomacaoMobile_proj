package br.com.next.automacao.core.constantes.massa.tdm;

public enum StatusPortabilidade {
    PENDENTE("01 - PENDENTE"),
    APROVADA_PARTICIPANTE_FOLHA_PAGAMENTO("02 - APROVADA PELO PARTICIPANTE (FOLHA DE PAGAMENTO)"),
    REPROVADA_PARTICIPANTE_FOLHA_PAGAMENTO("03 - REPROVADA PELO PARTICIPANTE (FOLHA DE PAGAMENTO)"),
    CANCELADA_PARTICIPANTE_DESTINO("04 - CANCELADA PELO PARTICIPANTE DESTINO"),
    CANCELADA_DECURSO_PRAZO_FALTA_RESPOSTA_PARTICIPANTE("05 - CANCELADA P/DECURSO DE PRAZO P/FALTA DE RESPOSTA DO PARTIC."),
    ACEITE_COMPULSORIO_FALTA_RESPOSTA_PARTICIPANTE("06 - ACEITE COMPULSORIO P/ FALTA DE RESPOSTA DO PARTICIPANTE"),
    PENDENTE_SEM_ENVIO_PARTICIPANTE_FOLHA_PAGAMENTO("51 - PENDENTE (SEM ENVIO AO PARTICIPANTE FOLHA DE PAGAMENTO)"),
    APROVADA_SEM_ENVIO_PARTICIPANTE_DESTINO("52 - APROVADA (SEM ENVIO AO PARTICIPANTE DESTINO)"),
    REPROVADA_SEM_ENVIO_PARTICIPANTE_DESTINO("53 - REPROVADA (SEM ENVIO AO PARTICIPANTE DESTINO)"),
    PENDENTE_EM_PROCESSAMENTO("61 - PENDENTE (EM PROCESSAMENTO)"),
    APROVADA_EM_PROCESSAMENTO("62 - APROVADA (EM PROCESSAMENTO)"),
    REPROVADA_EM_PROCESSAMENTO("63 - REPROVADA (EM PROCESSAMENTO)"),
    CANCELADA_EM_PROCESSAMENTO("64 - CANCELADA (EM PROCESSAMENTO)"),
    PENDENTE_INCONSISTENTE("91 - PENDENTE (INCONSISTENTE)"),
    APROVADA_INCONSISTENTE("92 - APROVADA (INCONSISTENTE)"),
    REPROVADA_INCONSISTENTE("93 - REPROVADA (INCONSISTENTE)"),
    CANCELADA_INCONSISTENTE("94 - CANCELADA (INCONSISTENTE)");

    private String value;

    private StatusPortabilidade(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
