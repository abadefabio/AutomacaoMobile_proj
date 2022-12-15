package constantes.perfil.investidor;

public enum DescobrindoSeuPerfil {

    //P�GINA UM: Agora, escolhe a op��o que melhor descreve o quanto voc� sabe sobre investimentos.
    TENHO_FORMACAO_MAS_NAO_TENHO_EXPERIENCIA("Tenho forma��o acad�mica, mas n�o tenho experi�ncia na �rea."),
    NAO_TENHO_FORMACAO_MAS_TENHO_EXPERIENCIA("N�o tenho forma��o acad�mica, mas tenho experi�ncia na �rea."),
    NAO_TENHO_FORMACAO_NAO_ENTENDO_DO_ASSUNTO("N�o tenho forma��o acad�mica e n�o entendo do assunto."),
    NAO_TENHO_FORMACAO_E_SEI_POUCO_SOBRE_ASSUNTO("N�o tenho forma��o acad�mica relacionada a investimentos e sei pouco sobre o assunto."),


    //P�GINA DOIS: Voc� fez algum invesmemto nos �ltimos 12 meses?
    JA_FIZ_INVESTIMENTO_NOS_ULTIMOS_12_MESES("J� sim! Investi em Poupan�a e/ou investimentos de Renda Fixa (CDBs, LCIs, LCAs) e/ou fundos conservadores."),
    JA_INVESTI_EM_TODAS_OPCOES_ANTERIORES_E_DERIVATIVOS("J� investi em todas as op��es anteriores e, tamb�m, em derivativos."),
    NUNCA_INVESTI_MAS_SEI_POUCO_SOBRE_TIPOS_DE_INVESTIMENTOS("Nunca investi, mas sei um pouco sobre os tipos de investimento que existem."),
    NUNCA_FIZ_UM_INVESTIMENTO("Nunca fiz um investimento."),

    //P�GINA TR�S: Quantas vezes voc� fez investimentos nos �ltimos 12 meses?
    MUITAS_VEZES_FIZ_UMAS_DOZE_APLICACOES("Muitas vezes, fiz umas 12 aplica��es."),
    QUASE_NAO_FIZ_FORAM_NO_MAXIMO_DUAS_APLICACOES("Quase n�o fiz, foram no m�ximo 2 aplica��es."),
    NAO_FIZ_APLICACOES("N�o fiz aplica��es."),

    //P�GINA QUATRO: A gente t� quase l� ;) Conta o que te motiva a aplicar seu dinheiro?
    QUERO_JUNTAR_DINHEIRO_PRA_MINHA_APOSENTADORIA("Quero juntar dinheiro pra minha aposentadoria (acima de 7 anos)."),
    QUERO_APLICAR_PRA_TER_UMA_RESERVA_DEVO_DEIXAR_INVESTIDO_POR_ATE_UM_ANO("Quero aplicar pra ter uma reserva, e devo deixar meu dinheiro investido por at� 1 ano."),
    QUERO_TER_RESERVA_PARA_IMPREVISTOS_E_TIRAR_QUANDO_PRECISAR("Quero ter uma reserva pra imprevistos e quero poder tirar meu dinheiro quando precisar."),

    //P�GINA CINCO: De tudo o que voc� ganha (freela, dinheiro que cai na conta), quanto voc� investe?
    MAIS_DE_QUARENTA_PORCENTO_DA_MINHA_RENDA("Mais de 40% da minha renda."),
    ATE_DEZ_PORCENTO_DA_MINHA_RENDA("At� 10% da minha renda."),
    NUNCA_INVESTI("Nunca investi."),

    //P�GINA SEIS: Quanto, em Reais, voc� tem em bens materiais e investimentos?
    MAIS_QUE_TRES_MM("Mais que R$ 3 MM."),
    ENTRE_QUINHENTOSMIL_E_UMQUINHENTOS_MM("Entre R$ 500 mil e R$ 1,5 MM."),
    ATE_DUZENTOS_E_CINQUENTA_MIL("At� R$ 250 mil."),

    //P�GINA SETE: E como esse dinheiro foi investido nos �ltimos 12 meses?
    MAIS_DE_70_POR_CENTO_EM_PRODUTOS_FINANCEIROS("Mais de 70% em produtos financeiros."),
    ENTRE_TRINTA_E_SETENTA_PORCENTO_EM_PRODUTOS_FINANCEIROS("Entre 30% e 70% em produtos financeiros."),
    ATE_QUINZE_PORCENTO_EM_PRODUTOS_FINANCEIROS("At� 15% em produtos financeiros."),
    AINDA_NAO_INVESTI("Ainda n�o investi."),

    //P�GINA OITO: Pensando nas suas necessidades futuras, o que voc� espera dos seus investimentos?
    NAO_PRECISO_DO_DINHEIRO_AGORA_E_NEM_INVESTIRIA_MAIS("N�o preciso do dinheiro agora e nem investiria mais."),
    NAO_PRECISO_AGORA_E_CONTINUARIA_INVESTINDO("N�o preciso do dinheiro agora e continuaria investindo."),
    TALVEZ_USARIA_UMA_PARTE_PARA_PAGAR_ALGUMAS_DESPESAS("Talvez usaria uma parte pra pagar algumas despesas."),
    NAO_TENHO_PLANOS_COMO_USAR_ESSE_DINHEIRO_NO_FUTURO("N�o tenho planos sobre como usar esse dinheiro no futuro."),

    //P�GINA NOVE: �ltima pergunta: Voc� faria um investimento de risco para tentar um retorno melhor?
    FARIA_E_ATE_PODERIA_CONTINUAR_INVESTINDO_MESMO_RISCO_PERDER_TUDO("Faria e at� poderia continuar investindo, mesmo com o risco de perder tudo."),
    INVESTIRIA_POUCO_PORQUE_NAO_SINTO_CONFORTAVEL_COM_O_RISCO_DE_PERDER("Investiria pouco porque n�o me sinto confort�vel com o risco de perder parte do dinheiro."),
    PREFIRO_NAO_CORRER_RISCO_DE_PERDER_DINHERIO("N�o, prefiro n�o correr o risco de perder dinheiro.");








    private String value;

    DescobrindoSeuPerfil(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }


}
