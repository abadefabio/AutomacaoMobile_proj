package br.com.next.automacao.core.constantes;

public enum Jornadas {

    TRANSFERENCIA("Transfer�ncia"),

    OBJETIVOS("Objetivos"),

    MIMOS("Mimos"),

    INVESTIMENTOS("Investimentos"),

    RECARGA("Recarga"),

    TRAZER_MEU_SALARIO("Trazer Meu Sal�rio"),

    CONTINGENCIA("Conting�ncia"),

    LOGIN_CONTINGENCIA("Login Conting�ncia"),

    PAGAMENTOS_CONTINGENCIA("Pagamentos Conting�ncia"),

    TRANSFERENCIA_CONTINGENCIA("Transfer�ncia Conting�ncia"),

    SEGURANCA("Seguranca"),

    VAQUINHA("Vaquinha"),

    CREDITO("Cr�dito"),

    CARTOES("Cart�es"),

    ADESAO("Ades�o"),

    FATURA("Fatura"),

    LIMITES("Limites"),

    VISAO_GERAL("Vis�o Geral"),

    MEIOS_DE_PAGAMENTO("Meios de Pagamento"),

    PAGAMENTOS_E_COMPROVANTES("Pagamentos e Comprovantes"),

    DEPOSITOS_E_SAQUES("Dep�sitos e Saques"),

    FLOW("Flow"),

    SALDO_EXTRATO("Saldo e Extrato"),

    PAGAMENTOS("Pagamentos"),

    PARCERIAS_COMERCIAIS("Parcerias Comerciais"),

    PERFIL_CONFIGURACOES("Perfil e Configura��es"),

    JOY("Joy"),

    PIX("Pix"),

    SEGUROS("Seguros"),

    STAFF_CHANNEL("Staff Channel"),

    NEXTSHOP("Nextshop"),

    FNEXT("Fnext"),

    TELAS("Telas"),

    ATENDIMENTO("Atendimento"),

    SISTEMA_DE_GESTAO("Sistema de Gest�o"),

    AJUDA_E_AREA_NAO_LOGADA("Ajuda de �rea N�o Logada"),

    OPEN_FINANCE("Open Finance"),

    COCKPIT_DE_ATENDIMENTO("Cockpit de Atendimento");

    private String value;

    private Jornadas(String value) {
        this.value = value;
    }
}
