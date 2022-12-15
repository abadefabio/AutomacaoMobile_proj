package constantes.portabilidade;

import static br.com.next.automacao.core.tools.Utilitarios.gerarCpf;

public enum PortabilidadeDados {
    MENSAGEM_POPUP_CANCELAR_PORTABILIDADE("Ops! Tem certeza que não quer trazer seu salário pro next?"),
    TEXTO_FINALIZACAO_PORTABILIDADE("O pedido foi feito. O prazo para efetivação é de até 10 dias úteis." ),
    FINALIZACAO_PORTABILIDADE_BRADESCO("Não foi possível realizar a PortabilidadeDados para o Banco Bradesco."),
    CONTA_SALARIO("é o banco pelo qual a empresa em que você trabalha faz o pagamento do salário. Se você estiver com dúvidas, é só falar com seu RH"),
    CONTA_SALARIO_IOS("É o banco pelo qual a empresa em que você trabalha faz o pagamento do salário. Se você estiver com dúvidas, é só falar com seu RH."),
    VOCE_JA_CADASTROU_CPF("Você já cadastrou esse CPF/CNPJ pra trazer seu salário pro next"),
    VOCE_JA_CADASTROU_CPF_OPS("Você já usou esse CPF/CNPJ. O pedido para ele está em análise pelo seu banco."),
    TRAZER_MEU_SALARIO("TRAZER MEU SALÁRIO"),
    TEXTO_PRIMEIRA_PORTABILIDADE("O pedido leva até 10 dias úteis para efetivação. Para confirmar qual é o banco da sua conta salário, converse com o RH da sua empresa."),

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
    MENSAGEM_POPUP_CSAL_PORTABILIDADE("O seu pedido de portabilidade já está em análise. Se quer mesmo cancelar a solicitação, tenta de novo no próximo dia útil"),
    SANTANDER_BANESPA("SANTANDER BANESPA"),
    BANCO_BRASIL("1 - BCO DO BRASIL SA"),
    TEXTO_VALIDAR_CONTESTACAO_PORTABILIDADE("Em até 10 dias úteis você receberá a resposta sobre sua contestação");



    private String value;

    private PortabilidadeDados(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
