package constantes.transferencia;

import io.appium.java_client.android.AndroidDriver;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.retornarPrimeiroNome;
import static pagina.mobile.jornadas.transferencia.para.outra.MeusContatosTela.retornaNomeContato;

public enum MensagensEsperadas {

    TITULO_TELA_TNSTRUCOES("Instru��es"),
    CAMPO_SALDO_CONTA_CORRENTE_INSTRUCOES("Saldo na Conta Corrente"),
    CAMPO_SALDO_POUPANCA_INSTRUCOES("Saldo na Conta Poupan�a"),
    CONFIRMACAO_CRIACAO_CONTATO("Contato criado com sucesso"),
    DATA_TRANSFERENCIA("Escolha uma data para fazer a transfer�ncia"),
    DATA_TRANSFERENCIAIOS("Escolhe uma data pra fazer a transfer�ncia"),
    TIPOCONTA_TRANSFERENCIA("Pra qual tipo de conta voc� quer transferir?"),
    CONFIRMACAO_EDICAO("Contato atualizado com sucesso ;)"),
    CONFIRMACAO_EDICAO_CONTATO("Contato atualizado com sucesso"),
    CONFIRMACAO_EXCLUSAO("Pronto, t� deletado ;)"),
    ACAO_EXCLUSAO_CONTATO("Vai mesmo excluir"),
    CONFIRMACAO_EXCLUSAO_CONTA("Quer mesmo deletar essa conta?"),
    CONFIRMACAO_TRANSFERENCIA("Pronto, a transfer�ncia t� feita.", "Pronto, a transfer�ncia t� feita."), // (Android, iOS)
    CONFIRMACAO_AGENDAMENTO_TRANSFERENCIA("Pronto, t� agendado.", "Agendamento realizado com sucesso."), // (Android, iOS)
    CONFIRMACAO_CADASTRO_SEM_SALVAR_TRANSFERENCIA("Pronto, a transfer�ncia t� feita.", "Pronto, a transfer�ncia t� feita."),
    CONFIRMACAO_DE_TRANSFERENCIA_DATA_ATUAL("Pronto, a transfer�ncia t� feita.","Pronto, a transfer�ncia t� feita."),
    CADASTRO_CPF_INVALIDO("CPF/CNPJ Inv�lido.", "CPF/CNPJ Inv�lido."),
    CADASTRO_CNPJ_INVALIDO("CPF/CNPJ Inv�lido.", "CPF/CNPJ Inv�lido."),
    MSG_JORNADA_TRANSFERENCIA("Bora l�. Escolhe pra quem vai transferir.");



    private String value;
    private String androidValue;
    private String iosValue;

    MensagensEsperadas(String value){
        this.value = value;
    }

    MensagensEsperadas(String androidValue, String iosValue){
        this.androidValue = androidValue;
        this.iosValue = iosValue;
    }

    @Override
    public String toString() {
        switch (this){
            case ACAO_EXCLUSAO_CONTATO:
                return this.value + " " + retornarPrimeiroNome(retornaNomeContato()  + "?");
            case CONFIRMACAO_AGENDAMENTO_TRANSFERENCIA:
            case CADASTRO_CPF_INVALIDO:
            case CADASTRO_CNPJ_INVALIDO:
            case CONFIRMACAO_TRANSFERENCIA:
            case CONFIRMACAO_CADASTRO_SEM_SALVAR_TRANSFERENCIA:
            case CONFIRMACAO_DE_TRANSFERENCIA_DATA_ATUAL:
                return getDriver() instanceof AndroidDriver ? androidValue : iosValue;
            default: return this.value;
        }
    }

}

