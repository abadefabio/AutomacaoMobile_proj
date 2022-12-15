package br.com.next.automacao.core.constantes.massa.callcenter;

public enum StatusAdesaoOnboarding {

    ATIVACAO_DE_INTEGRACAO(0),
    SOB_ANALISE(1),
    REPROVADA(2),
    DOCUMENTO_PRENDENTE(3),
    APROVADA_NAO_FINALIZADA(4),
    APROVADA_FINALIZADA(5),
    EM_SUBLIMISSAO(6);

    private int codigoOnboarding;

    private StatusAdesaoOnboarding(int codigoOnboarding) {
        this.codigoOnboarding = codigoOnboarding;

    }
    public int getCodigoOnboarding() {
        return codigoOnboarding;
    }
    }
