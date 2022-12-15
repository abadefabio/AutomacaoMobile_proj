package br.com.next.automacao.core.constantes;

public enum Jornadas {

    TRANSFERENCIA("Transferência"),

    OBJETIVOS("Objetivos"),

    MIMOS("Mimos"),

    INVESTIMENTOS("Investimentos"),

    RECARGA("Recarga"),

    TRAZER_MEU_SALARIO("Trazer Meu Salário"),

    CONTINGENCIA("Contingência"),

    LOGIN_CONTINGENCIA("Login Contingência"),

    PAGAMENTOS_CONTINGENCIA("Pagamentos Contingência"),

    TRANSFERENCIA_CONTINGENCIA("Transferência Contingência"),

    SEGURANCA("Seguranca"),

    VAQUINHA("Vaquinha"),

    CREDITO("Crédito"),

    CARTOES("Cartões"),

    ADESAO("Adesão"),

    FATURA("Fatura"),

    LIMITES("Limites"),

    VISAO_GERAL("Visão Geral"),

    MEIOS_DE_PAGAMENTO("Meios de Pagamento"),

    PAGAMENTOS_E_COMPROVANTES("Pagamentos e Comprovantes"),

    DEPOSITOS_E_SAQUES("Depósitos e Saques"),

    FLOW("Flow"),

    SALDO_EXTRATO("Saldo e Extrato"),

    PAGAMENTOS("Pagamentos"),

    PARCERIAS_COMERCIAIS("Parcerias Comerciais"),

    PERFIL_CONFIGURACOES("Perfil e Configurações"),

    JOY("Joy"),

    PIX("Pix"),

    SEGUROS("Seguros"),

    STAFF_CHANNEL("Staff Channel"),

    NEXTSHOP("Nextshop"),

    FNEXT("Fnext"),

    TELAS("Telas"),

    ATENDIMENTO("Atendimento"),

    SISTEMA_DE_GESTAO("Sistema de Gestão"),

    AJUDA_E_AREA_NAO_LOGADA("Ajuda de Área Não Logada"),

    OPEN_FINANCE("Open Finance"),

    COCKPIT_DE_ATENDIMENTO("Cockpit de Atendimento");

    private String value;

    private Jornadas(String value) {
        this.value = value;
    }
}
