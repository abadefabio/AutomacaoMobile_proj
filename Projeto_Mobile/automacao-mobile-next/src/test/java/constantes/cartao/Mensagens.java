package constantes.cartao;

public interface Mensagens {

    String TELA_AVISO_VIAGEM_CANCELADO = "Aviso de Viagem cancelado";
    String REENVIO_DO_CARTAO_SOLICITADO = "Reenvio do cart�o Solicitado";
    String SEU_CARTAO_JA_ESTA_SENDO_PRODUZIDO = "Seu cart�o j� est� sendo produzido";
    String[] MENSAGENS_CANCELAMENTO = {"Cart�o cancelado", "Ap�s o cancelamento, as fun��es do seu cart�o"};

    String CARTAO_DANIFICADO = "Cart�o danificado";
    String[] MENSAGENS_SOLICITACAO_CARTAO_CREDITO = {"Ainda n�o temos cart�o de cr�dito", "Limite pr�-aprovado"};

    String[] MENSAGENS_CANCELAMENTO_POR_ESTAR_DANIFICADO = {
            "Ap�s a confirma��o, seu cart�o atual",
            "O novo cart�o ser� entregue em at�",
            "Essa opera��o n�o poder� ser cancelada"};
}
