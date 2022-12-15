package constantes.web.fnext.n1;

import br.com.next.automacao.core.tools.Utilitarios;

public interface ComboN1 {

    String APROVADO = "APROVADO";
    String APROVADO_COM_PENDENCIA = "APROVADO COM PEND�NCIA";
    String RECUSADO = "RECUSADO";

    String CPFDIVERGE = "CPF DIVERGE DA RECEITA FEDERAL";
    String MENORDE18ANOS = "MENOR DE 18 ANOS";
    String SOLICITACAODONEGOCIO = "SOLICITA��O DO NEG�CIO";
    String SOLICITACAODOCLIENTE = "SOLICITA��O DO CLIENTE";
    String ANALFABETO = "ANALFABETO";
    String DOCUMENTO_RESP_IRREGULAR = "DOCUMENTO DO RESPONS�VEL IRREGULAR (REINCID�NCIA)";
    String SUSPEITA_DE_FRAUDE = "SUSPEITA DE FRAUDE";

    String CPFDIVERGEJOYII_RESPONSAVEL = "CPF DIVERGE DA RECEITA FEDERAL - RESPONS�VEL";
    String CPF_DIVERGE_DA_RECEITA_FEDERAL_DEPENDENTE = "CPF DIVERGE DA RECEITA FEDERAL - DEPENDENTE";
    String MENOR_DE_18_ANOS_RESPONS�VEL = "MENOR DE 18 ANOS - RESPONS�VEL";
    String DOCUMENTO_ESTRANGEIRO = "DOCUMENTO ESTRANGEIRO";
    String MAIOR_DE_18_ANOS_DEPENDENTE = "MAIOR DE 18 ANOS - DEPENDENTE";

    String PAIS_NASCIMENTO_BRASIL = "BRASIL";

    String RG_COM_CPF = "RG COM CPF";

    String DETRAN = "DETRAN";
    String SSP = "SECRETARIA SEGURANCA PUBLICA";
    String MINISTERIO_DA_EDUCACAO = "MINISTERIO DA EDUCACAO";
    String CRM = "CRM";

    String AC = "AC";
    String AL = "AL";
    String SP = "SP";

    String SAO_PAULO = "S�o Paulo";
    String ACRELANDIA = "ACRELANDIA";
    String AGUA_BRANCA = "AGUA BRANCA";

    String COPIA = "C�pia";
    String DANIFICADO = "Danificado";
    String DOCUMENTO_RESPONSAVEL = "Documento do Respons�vel";
    String TELA = "Tela";

    String RETORNO_N1 = "RETORNO N1";
    String ERRO_OPERACIONAL = "ERRO OPERACIONAL";

    String DATA_EMISSAO_DOC = Utilitarios.calcularDataRelativaHoje(-365,"ddMMyyyy");
}
