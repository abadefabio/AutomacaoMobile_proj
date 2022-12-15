package constantes.perfil.investidor;

public enum DescobrindoSeuPerfil {

    //PÁGINA UM: Agora, escolhe a opção que melhor descreve o quanto você sabe sobre investimentos.
    TENHO_FORMACAO_MAS_NAO_TENHO_EXPERIENCIA("Tenho formação acadêmica, mas não tenho experiência na área."),
    NAO_TENHO_FORMACAO_MAS_TENHO_EXPERIENCIA("Não tenho formação acadêmica, mas tenho experiência na área."),
    NAO_TENHO_FORMACAO_NAO_ENTENDO_DO_ASSUNTO("Não tenho formação acadêmica e não entendo do assunto."),
    NAO_TENHO_FORMACAO_E_SEI_POUCO_SOBRE_ASSUNTO("Não tenho formação acadêmica relacionada a investimentos e sei pouco sobre o assunto."),


    //PÁGINA DOIS: Você fez algum invesmemto nos últimos 12 meses?
    JA_FIZ_INVESTIMENTO_NOS_ULTIMOS_12_MESES("Já sim! Investi em Poupança e/ou investimentos de Renda Fixa (CDBs, LCIs, LCAs) e/ou fundos conservadores."),
    JA_INVESTI_EM_TODAS_OPCOES_ANTERIORES_E_DERIVATIVOS("Já investi em todas as opções anteriores e, também, em derivativos."),
    NUNCA_INVESTI_MAS_SEI_POUCO_SOBRE_TIPOS_DE_INVESTIMENTOS("Nunca investi, mas sei um pouco sobre os tipos de investimento que existem."),
    NUNCA_FIZ_UM_INVESTIMENTO("Nunca fiz um investimento."),

    //PÁGINA TRÊS: Quantas vezes você fez investimentos nos últimos 12 meses?
    MUITAS_VEZES_FIZ_UMAS_DOZE_APLICACOES("Muitas vezes, fiz umas 12 aplicações."),
    QUASE_NAO_FIZ_FORAM_NO_MAXIMO_DUAS_APLICACOES("Quase não fiz, foram no máximo 2 aplicações."),
    NAO_FIZ_APLICACOES("Não fiz aplicações."),

    //PÁGINA QUATRO: A gente tá quase lá ;) Conta o que te motiva a aplicar seu dinheiro?
    QUERO_JUNTAR_DINHEIRO_PRA_MINHA_APOSENTADORIA("Quero juntar dinheiro pra minha aposentadoria (acima de 7 anos)."),
    QUERO_APLICAR_PRA_TER_UMA_RESERVA_DEVO_DEIXAR_INVESTIDO_POR_ATE_UM_ANO("Quero aplicar pra ter uma reserva, e devo deixar meu dinheiro investido por até 1 ano."),
    QUERO_TER_RESERVA_PARA_IMPREVISTOS_E_TIRAR_QUANDO_PRECISAR("Quero ter uma reserva pra imprevistos e quero poder tirar meu dinheiro quando precisar."),

    //PÁGINA CINCO: De tudo o que você ganha (freela, dinheiro que cai na conta), quanto você investe?
    MAIS_DE_QUARENTA_PORCENTO_DA_MINHA_RENDA("Mais de 40% da minha renda."),
    ATE_DEZ_PORCENTO_DA_MINHA_RENDA("Até 10% da minha renda."),
    NUNCA_INVESTI("Nunca investi."),

    //PÁGINA SEIS: Quanto, em Reais, você tem em bens materiais e investimentos?
    MAIS_QUE_TRES_MM("Mais que R$ 3 MM."),
    ENTRE_QUINHENTOSMIL_E_UMQUINHENTOS_MM("Entre R$ 500 mil e R$ 1,5 MM."),
    ATE_DUZENTOS_E_CINQUENTA_MIL("Até R$ 250 mil."),

    //PÁGINA SETE: E como esse dinheiro foi investido nos últimos 12 meses?
    MAIS_DE_70_POR_CENTO_EM_PRODUTOS_FINANCEIROS("Mais de 70% em produtos financeiros."),
    ENTRE_TRINTA_E_SETENTA_PORCENTO_EM_PRODUTOS_FINANCEIROS("Entre 30% e 70% em produtos financeiros."),
    ATE_QUINZE_PORCENTO_EM_PRODUTOS_FINANCEIROS("Até 15% em produtos financeiros."),
    AINDA_NAO_INVESTI("Ainda não investi."),

    //PÁGINA OITO: Pensando nas suas necessidades futuras, o que você espera dos seus investimentos?
    NAO_PRECISO_DO_DINHEIRO_AGORA_E_NEM_INVESTIRIA_MAIS("Não preciso do dinheiro agora e nem investiria mais."),
    NAO_PRECISO_AGORA_E_CONTINUARIA_INVESTINDO("Não preciso do dinheiro agora e continuaria investindo."),
    TALVEZ_USARIA_UMA_PARTE_PARA_PAGAR_ALGUMAS_DESPESAS("Talvez usaria uma parte pra pagar algumas despesas."),
    NAO_TENHO_PLANOS_COMO_USAR_ESSE_DINHEIRO_NO_FUTURO("Não tenho planos sobre como usar esse dinheiro no futuro."),

    //PÁGINA NOVE: Última pergunta: Você faria um investimento de risco para tentar um retorno melhor?
    FARIA_E_ATE_PODERIA_CONTINUAR_INVESTINDO_MESMO_RISCO_PERDER_TUDO("Faria e até poderia continuar investindo, mesmo com o risco de perder tudo."),
    INVESTIRIA_POUCO_PORQUE_NAO_SINTO_CONFORTAVEL_COM_O_RISCO_DE_PERDER("Investiria pouco porque não me sinto confortável com o risco de perder parte do dinheiro."),
    PREFIRO_NAO_CORRER_RISCO_DE_PERDER_DINHERIO("Não, prefiro não correr o risco de perder dinheiro.");








    private String value;

    DescobrindoSeuPerfil(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }


}
