package constantes.transferencia;

import br.com.next.automacao.core.constantes.transferencia.TransferirPara;

import static constantes.transferencia.TipoDeInstituicaoFinanceira.BANCO;
import static constantes.transferencia.TipoDeInstituicaoFinanceira.INSTITUICAO_DE_PAGAMENTO;

public enum CadastroContatoTransferencia {

    CADASTRO_PRIMEIRO_CONTATO_BANCO_BRADESCARD_1(
            true,                                                   // true: primeiríssimo contato
            true,                                                   // false: não cadastrar CPF (ex. banco Bradesco/Next)
            true,                                                   // salvar o contato
            ContaPagamento.CONTA_BANCO_CADASTRO_BANCO_TERCEIRO_PJ,  // dados da conta a cadastrar
            MensagensEsperadas.CONFIRMACAO_CRIACAO_CONTATO),        // mensagem de sucesso para este cadastro

    CADASTRO_SEM_SALVAR_TRANSFERENCIA_BANCO_TERCEIRO_CADASTRADO(
            true,                                              // true: primeiríssimo contato
            true,                                              // true: cadastrar CPF
            false,                                             // salvar o contato
            ContaPagamento.CADASTRO_TRANSFERENCIA_OUTRA_CC_CC_BANCO_BRASIL_1,  // dados da conta a cadastrar
            null);                                           // este contato não é salvo (sem mensagem sucesso)

    private boolean primeiroContato;
    private boolean cadastrarCPF;
    private boolean salvarContato;
    private ContaPagamento contaPagamento;
    private MensagensEsperadas mensagensEsperadas;


    CadastroContatoTransferencia(boolean primeiroContato,
                                 boolean cadastrarCPF,
                                 boolean salvarContato,
                                 ContaPagamento contaPagamento,
                                 MensagensEsperadas mensagensEsperadas) {
        this.primeiroContato = primeiroContato;
        this.cadastrarCPF = cadastrarCPF;
        this.contaPagamento = contaPagamento;
        this.salvarContato = salvarContato;
        this.mensagensEsperadas = mensagensEsperadas;
    }

    public boolean recuperarPrimeiroContato(){
        return this.primeiroContato;
    }

    public boolean recuperarCadastrarCpf(){
        return this.cadastrarCPF;
    }

    public ContaPagamento recuperarContaPagamento(){
        return this.contaPagamento;
    }

    public MensagensEsperadas recuperarMensagemEsperada(){
        return this.mensagensEsperadas;
    }

    public boolean retornaSalvarContato() {
        return this.salvarContato;
    }
}
