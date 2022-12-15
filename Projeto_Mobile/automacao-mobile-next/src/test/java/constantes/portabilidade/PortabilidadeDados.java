package constantes.portabilidade;

import static br.com.next.automacao.core.tools.Utilitarios.gerarCpf;

public enum PortabilidadeDados {
    MENSAGEM_POPUP_CANCELAR_PORTABILIDADE("Ops! Tem certeza que n�o quer trazer seu sal�rio pro next?"),
    TEXTO_FINALIZACAO_PORTABILIDADE("O pedido foi feito. O prazo para efetiva��o � de at� 10 dias �teis." ),
    FINALIZACAO_PORTABILIDADE_BRADESCO("N�o foi poss�vel realizar a PortabilidadeDados para o Banco Bradesco."),
    CONTA_SALARIO("� o banco pelo qual a empresa em que voc� trabalha faz o pagamento do sal�rio. Se voc� estiver com d�vidas, � s� falar com seu RH"),
    CONTA_SALARIO_IOS("� o banco pelo qual a empresa em que voc� trabalha faz o pagamento do sal�rio. Se voc� estiver com d�vidas, � s� falar com seu RH."),
    VOCE_JA_CADASTROU_CPF("Voc� j� cadastrou esse CPF/CNPJ pra trazer seu sal�rio pro next"),
    VOCE_JA_CADASTROU_CPF_OPS("Voc� j� usou esse CPF/CNPJ. O pedido para ele est� em an�lise pelo seu banco."),
    TRAZER_MEU_SALARIO("TRAZER MEU SAL�RIO"),
    TEXTO_PRIMEIRA_PORTABILIDADE("O pedido leva at� 10 dias �teis para efetiva��o. Para confirmar qual � o banco da sua conta sal�rio, converse com o RH da sua empresa."),

    TEXTO_CONFIRMACAO_CANCELAMENTO("Tem certeza que quer cancelar a portabilidade?"),
    CNPJ_INVALIDO("123456789123451"),
    SANTANDER("BANCO SANTANDER"),
    BRADESCO("BANCO BRADESCO S.A."),
    CNPJ_EMPRESA_TST_GATW("19867802000121"),
    NOME_COMPROVANTE_EMPRESA_TST_GATW("CNPJ EMPRESA TST GATW AP 018"),
    FAVORECIDOCPF("53272833056"),
    FAVORECIDOCPFALEATORIO(gerarCpf()),
    FAVORECIDOINSTITUICAO("BANCO SANTANDER"),
    CPF_PORTABILIDADE_ANDAMENTO_E_CONCLUIDA("06402440680"),
    CPF_FULANO_BELTRANO_DA_SILVA_PORT_BRAD("71494295725"),
    CPF_FULANO_BELTRANO_DA_SILVA_PORT_BRAD2("06402440680"),
    FAVORECIDOINSTITUICAO_BANCOBRASIL("BANCO DO BRASIL"),
    CPF_SEGUNDA_PORTABILIDADE("82271705010"),
    INSTITUICAOFAVORECIDO_SEGUNDAPORTABILIDADE("banco santander"),
    MENSAGEM_POPUP_CSAL_PORTABILIDADE("O seu pedido de portabilidade j� est� em an�lise. Se quer mesmo cancelar a solicita��o, tenta de novo no pr�ximo dia �til"),
    SANTANDER_BANESPA("SANTANDER BANESPA"),
    BANCO_BRASIL("1 - BCO DO BRASIL SA"),
    TEXTO_VALIDAR_CONTESTACAO_PORTABILIDADE("Em at� 10 dias �teis voc� receber� a resposta sobre sua contesta��o");



    private String value;

    private PortabilidadeDados(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
