package constantes;

public enum MensagemRetornoMcir {

        JA_EXISTE_PROVISIONAMENTO_PARA_A_MESMA_DATA("42", "JA EXISTE PROVISIONAMENTO PARA A MESMA DATA"),
        DATA_DE_INCLUSAO_INVALIDA_OU_NAO_UTIL("55", "DATA DE INCLUSAO INVALIDA OU NAO UTIL"),
        DATA_DE_INCLUSAO_INVALIDA("24", "DATA PREVISTA PARA SAQUE INVALIDA"),
        CODIGO_AGENCIA_INVALIDO("01", "CODIGO DA AGENCIA INVALIDO"),
        CPF_CNPJ_DESTINATARIO_INVALIDO("09", "CODIGO DA CONTA INVALIDO"),
        CODIGO_DA_CONTA_INVALIDO("03", "CODIGO DA CONTA INVALIDO"),
        INCLUSAO_EFETUADA_COM_SUCESSO("00", "INCLUSAO EFETUADA COM SUCESSO"),
        CONSULTA_EFETUADA_COM_SUCESSO("00", "CONSULTA EFETUADA COM SUCESSO"),
        CODIGO_DO_PRODUTO_INEXISTENTE("06", "CODIGO DO PROTOCOLO INEXISTENTE               COD RET: 06   LOCAL: 07"),
        CONSULTA_CODIGO_DA_CONTA_INVALIDO("03", "CODIGO DA CONTA INVALIDO                      COD RET: 03   LOCAL: 05"),
        PERIODO_DE_PESQUISA_MAX_PESQUISA("41", "INFORMAR PERIODO DE PESQUISA - MAXIMO 3 MESES COD RET: 41   LOCAL: 15"),
        LISTA_CODIGO_CONTA_INVALIDO("03", "CODIGO DA CONTA INVALIDO           -000000000 COD RET: 03   LOCAL: 10"),
        LISTA_CODIGO_AGENCIA_INVALIDO("01", "CODIGO DA AGENCIA INVALIDO         -00000     COD RET: 01   LOCAL: 09"),
        DT_EXCL_DEVE_SER_ATE_1_DIA_ANTES_DO_SAQUE("27", "DT EXCL. DEVE SER ATE 1 DIA ANTES DT DO SAQUE COD RET: 27   LOCAL: 09"),
        EXCLUSAO_CODIGO_DO_PRODUTO_INEXISTENTE("06", "CODIGO DO PROTOCOLO INEXISTENTE               COD RET: 06   LOCAL: 14"),
        ERRO_NAO_ESPERADO("0","Erro não esperado ao executar o recurso"),
        EXCLUSAO_COM_SUCESSO("00","VALIDACAO COM SUCESSO - CONFIRME A EXCLUSAO");




    private String codigoRetorno;
    private String mensagemRetorno;


        private MensagemRetornoMcir(String codigoRetorno, String mensagemRetorno) {
            this.codigoRetorno = codigoRetorno;
            this.mensagemRetorno = mensagemRetorno;
        }

        public String getCodigoRetorno() {
            return codigoRetorno;
        }
        public String getMensagemRetorno() {
            return mensagemRetorno;
        }

}
