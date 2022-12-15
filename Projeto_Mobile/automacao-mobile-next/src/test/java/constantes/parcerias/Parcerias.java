package constantes.parcerias;

import static br.com.next.automacao.core.tools.Utilitarios.calcularDataRelativaHoje;

public enum Parcerias {
    MENSAGEM_PROXIMA_DATA_INDICACAO("Voc� s� pode reenviar esse convite em " + calcularDataRelativaHoje(10)), // data � calculada; n�o inserir letras na mensagem ap�s o sinal do pipe "|".
    MENSAGEM_VALIDACAO_CONSULTOR_JEQUETI("Como a gente ama te mimar, voc� receber� um produto Jequiti no seu pr�ximo pedido assim que a pessoa indicada abrir a conta e movimentar."),
    NOME_CONSULTOR_JEQUETI("Debora Perez"),
    MENSAGEM_MAXIMO_INDICACOES_ULTRAPASSADO("Voc� poder� indicar mais n�meros amanh�."),
    MAXIMO_INDICACOES_POSSIVEIS("30"),
    NOME_PALAVRAO("Puta Merda"),
    VALIDAR_TEXTO_QUEM_ABRE_CONTA("Quem abre a conta tem:"),
    VALIDAR_TEXTO_BANCODIGITAL("PRA FAZER ACONTECER COM UM BANCO 100% DIGITAL E GRATUITO"),
    NOME_INVALIDO("Nome inv�lido, tente outro."),
    VALIDA_CELULAR_INCOMPLETO_ANDROID("N�mero de celular incompleto"),
    VALIDA_TELEFONE_INCOMPLETO_IOS("N�mero de telefone incompleto"),
    MENSAGEM_CONVITE_ENVIADO("Convite Enviado!"),
    NUMERO_CELULAR_INCOMPLETO("119710543"),
    CAMPO_CELULAR_VAZIO("Telefone"),
    CAMPO_NOME_VAZIO("Nome");


    private String value;

    private Parcerias(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
