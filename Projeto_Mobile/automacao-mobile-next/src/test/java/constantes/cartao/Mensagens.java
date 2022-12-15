package constantes.cartao;

public interface Mensagens {

    String TELA_AVISO_VIAGEM_CANCELADO = "Aviso de Viagem cancelado";
    String REENVIO_DO_CARTAO_SOLICITADO = "Reenvio do cartão Solicitado";
    String SEU_CARTAO_JA_ESTA_SENDO_PRODUZIDO = "Seu cartão já está sendo produzido";
    String[] MENSAGENS_CANCELAMENTO = {"Cartão cancelado", "Após o cancelamento, as funções do seu cartão"};

    String CARTAO_DANIFICADO = "Cartão danificado";
    String[] MENSAGENS_SOLICITACAO_CARTAO_CREDITO = {"Ainda não temos cartão de crédito", "Limite pré-aprovado"};

    String[] MENSAGENS_CANCELAMENTO_POR_ESTAR_DANIFICADO = {
            "Após a confirmação, seu cartão atual",
            "O novo cartão será entregue em até",
            "Essa operação não poderá ser cancelada"};
}
