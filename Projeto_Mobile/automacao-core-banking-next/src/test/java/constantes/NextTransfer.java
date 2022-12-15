package constantes;

public interface NextTransfer {
    String LISTA_CONTATOS_TRANSFERENCIAS_FEITAS = "/v1/transfers/recipients/contacts/accounts";
    String LISTA_CONTATOS_TRANSFERENCIAS_FEITAS_RECENTES = "/v1/transfers/recipients/contacts/accounts/recents";
    String LISTA_CONTAS_DESTINATARIOS = "/v1/transfers/recipients/myAccounts";
    String LISTAR_CONTATOS = "/v1/transfers/recipients/contacts/accounts";

    String LISTA_TRANSFERENCIAS_PROGRAMADAS_AGENDADAS = "/v1/transfers/schedules";
    String VALIDAR_CLIENTE_FUNDOS_SUFICIENTE = "/v1/transfers/sufficientFundsValidation?transferAmount=10";
    String LISTA_INSTRUCOES_TRANSFERENCIA = "/v1/transfers/instructions";
    String LISTA_CONTATOS_TRANSFERENCIAS_SEM_RESULTADO = "/v1/transfers/recipients/contacts/accounts/recents";
    String LISTA_OBTER_RECIBO_TRANSFERENCIA_EFEITVADA_SEM_SUCESSO = "/v1/transfers";
}
