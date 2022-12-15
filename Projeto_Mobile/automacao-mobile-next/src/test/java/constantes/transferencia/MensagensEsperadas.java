package constantes.transferencia;

import io.appium.java_client.android.AndroidDriver;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.retornarPrimeiroNome;
import static pagina.mobile.jornadas.transferencia.para.outra.MeusContatosTela.retornaNomeContato;

public enum MensagensEsperadas {

    TITULO_TELA_TNSTRUCOES("Instruções"),
    CAMPO_SALDO_CONTA_CORRENTE_INSTRUCOES("Saldo na Conta Corrente"),
    CAMPO_SALDO_POUPANCA_INSTRUCOES("Saldo na Conta Poupança"),
    CONFIRMACAO_CRIACAO_CONTATO("Contato criado com sucesso"),
    DATA_TRANSFERENCIA("Escolha uma data para fazer a transferência"),
    DATA_TRANSFERENCIAIOS("Escolhe uma data pra fazer a transferência"),
    TIPOCONTA_TRANSFERENCIA("Pra qual tipo de conta você quer transferir?"),
    CONFIRMACAO_EDICAO("Contato atualizado com sucesso ;)"),
    CONFIRMACAO_EDICAO_CONTATO("Contato atualizado com sucesso"),
    CONFIRMACAO_EXCLUSAO("Pronto, tá deletado ;)"),
    ACAO_EXCLUSAO_CONTATO("Vai mesmo excluir"),
    CONFIRMACAO_EXCLUSAO_CONTA("Quer mesmo deletar essa conta?"),
    CONFIRMACAO_TRANSFERENCIA("Pronto, a transferência tá feita.", "Pronto, a transferência tá feita."), // (Android, iOS)
    CONFIRMACAO_AGENDAMENTO_TRANSFERENCIA("Pronto, tá agendado.", "Agendamento realizado com sucesso."), // (Android, iOS)
    CONFIRMACAO_CADASTRO_SEM_SALVAR_TRANSFERENCIA("Pronto, a transferência tá feita.", "Pronto, a transferência tá feita."),
    CONFIRMACAO_DE_TRANSFERENCIA_DATA_ATUAL("Pronto, a transferência tá feita.","Pronto, a transferência tá feita."),
    CADASTRO_CPF_INVALIDO("CPF/CNPJ Inválido.", "CPF/CNPJ Inválido."),
    CADASTRO_CNPJ_INVALIDO("CPF/CNPJ Inválido.", "CPF/CNPJ Inválido."),
    MSG_JORNADA_TRANSFERENCIA("Bora lá. Escolhe pra quem vai transferir.");



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

