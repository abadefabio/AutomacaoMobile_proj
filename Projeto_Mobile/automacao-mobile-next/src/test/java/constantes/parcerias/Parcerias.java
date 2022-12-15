package constantes.parcerias;

import static br.com.next.automacao.core.tools.Utilitarios.calcularDataRelativaHoje;

public enum Parcerias {
    MENSAGEM_PROXIMA_DATA_INDICACAO("Você só pode reenviar esse convite em " + calcularDataRelativaHoje(10)), // data é calculada; não inserir letras na mensagem após o sinal do pipe "|".
    MENSAGEM_VALIDACAO_CONSULTOR_JEQUETI("Como a gente ama te mimar, você receberá um produto Jequiti no seu próximo pedido assim que a pessoa indicada abrir a conta e movimentar."),
    NOME_CONSULTOR_JEQUETI("Debora Perez"),
    MENSAGEM_MAXIMO_INDICACOES_ULTRAPASSADO("Você poderá indicar mais números amanhã."),
    MAXIMO_INDICACOES_POSSIVEIS("30"),
    NOME_PALAVRAO("Puta Merda"),
    VALIDAR_TEXTO_QUEM_ABRE_CONTA("Quem abre a conta tem:"),
    VALIDAR_TEXTO_BANCODIGITAL("PRA FAZER ACONTECER COM UM BANCO 100% DIGITAL E GRATUITO"),
    NOME_INVALIDO("Nome inválido, tente outro."),
    VALIDA_CELULAR_INCOMPLETO_ANDROID("Número de celular incompleto"),
    VALIDA_TELEFONE_INCOMPLETO_IOS("Número de telefone incompleto"),
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
