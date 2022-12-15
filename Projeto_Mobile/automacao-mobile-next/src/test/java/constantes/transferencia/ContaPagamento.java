package constantes.transferencia;

import br.com.next.automacao.core.constantes.transferencia.TransferirPara;

import static br.com.next.automacao.core.tools.Utilitarios.geradorCnpj;
import static br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio;
import static constantes.transferencia.TipoDeInstituicaoFinanceira.BANCO;
import static constantes.transferencia.TipoDeInstituicaoFinanceira.INSTITUICAO_DE_PAGAMENTO;

public enum ContaPagamento {

    TRANSFERENCIA_MIM_CC_CC_BRADESCO_INTERNA_1(BANCO,
            "",
            "BANCO BRADESCO S.A.",
            "237 - BANCO BRADESCO S.A.",
            "1382",
            "7811",
            "53645901868",
            TransferirPara.MIM,
            TipoDeConta.CONTA_CORRENTE, // conta de origem
            TipoDeConta.CONTA_CORRENTE, // conta de destino
            TipoTransferencia.INTERNA,  // entre contas Bradesco ou Next
            NomeTransferencia.NAO_PREENCHER, // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ALEATORIO_100_A_500), // valor da transferência

    TRANSFERENCIA_OUTRA_CC_CP_NEXT_INTERNA_1_ANDROID(BANCO,
            "Contato Next",
            "NEXT",
            "237 - NEXT",
            "3750",
            "91367", // conta com dígito 8: 15638-8
            "",
            TransferirPara.OUTRA_PESSOA,
            TipoDeConta.CONTA_CORRENTE, // conta de origem
            TipoDeConta.CONTA_POUPANCA, // conta de destino
            TipoTransferencia.INTERNA,  // entre contas Bradesco ou Next
            NomeTransferencia.NAO_PREENCHER, // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ALEATORIO_ATE_5000), // valor da transferência

    TRANSFERENCIA_OUTRA_CC_CP_NEXT_INTERNA_1_IOS(BANCO,
            "Contato Next",
            "NEXT",
            "237NEXT",
            "3750",
            "91367", // conta com dígito 8: 15638-8
            "",
            TransferirPara.OUTRA_PESSOA,
            TipoDeConta.CONTA_CORRENTE, // conta de origem
            TipoDeConta.CONTA_POUPANCA, // conta de destino
            TipoTransferencia.INTERNA,  // entre contas Bradesco ou Next
            NomeTransferencia.NAO_PREENCHER, // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ALEATORIO_ATE_5000), // valor da transferência

    /*
    Conta CNPJ fictícia de banco terceiro
     */
    TRANSFERENCIA_OUTRA_CP_CC_ITAU_DOC_1(BANCO,
            "Cnpj Itau",
            "ITAU UNIBANCO S.A.",
            "341 - ITAU UNIBANCO S.A.",
            "7657",   // agência fictícia
            "171349", // conta fictícia com dígito 9: 17134-9
            "83721681000104", // CNPJ fictício
            TransferirPara.OUTRA_PESSOA,
            TipoDeConta.CONTA_POUPANCA, // conta de origem
            TipoDeConta.CONTA_CORRENTE, // conta de destino
            TipoTransferencia.DOC,  // entre contas Bradesco ou Next
            NomeTransferencia.NAO_PREENCHER, // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ALEATORIO_100_A_500), // valor da transferência

    /*
    Conta CNPJ fictícia de banco terceiro
     */
    TRANSFERENCIA_OUTRA_CC_CC_ITAU_TED_1(BANCO,
            "Cnpj Itau",
            "ITAU UNIBANCO S.A.",
            "341 - ITAU UNIBANCO S.A.",
            "7657",   // agência fictícia
            "171349", // conta fictícia com dígito 9: 17134-9
            "83721681000104", // CNPJ fictício
            TransferirPara.OUTRA_PESSOA,
            TipoDeConta.CONTA_CORRENTE, // conta de origem
            TipoDeConta.CONTA_CORRENTE, // conta de destino
            TipoTransferencia.TED,  // entre contas Bradesco ou Next
            NomeTransferencia.NOME_TRANSFERENCIA, // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ALEATORIO_100_A_500), // valor da transferência

    TRANSFERENCIA_MIM_CC_CP_ITAU_TED_1(BANCO,
            "",
            "ITAU UNIBANCO S.A.",
            "341 - ITAU UNIBANCO S.A.",
            "7657",   // agência fictícia
            "171349", // conta fictícia com dígito 9: 17134-9
            "83721681000104", // CNPJ fictício
            TransferirPara.MIM,
            TipoDeConta.CONTA_CORRENTE, // conta de origem
            TipoDeConta.CONTA_POUPANCA, // conta de destino
            TipoTransferencia.TED,  // entre contas Bradesco ou Next
            NomeTransferencia.NOME_TRANSFERENCIA_TED, // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ALEATORIO_5_A_10), // valor da transferência

    TRANSFERENCIA_MIM_CP_CC_ITAU_DOC_2(BANCO,
            "",
            "ITAU UNIBANCO S.A.",
            "341 - ITAU UNIBANCO S.A.",
            "7657",   // agência fictícia
            "171349", // conta fictícia com dígito 9: 17134-9
            "73440565696", // CNPJ fictício
            TransferirPara.MIM,
            TipoDeConta.CONTA_POUPANCA, // conta de origem
            TipoDeConta.CONTA_CORRENTE, // conta de destino
            TipoTransferencia.DOC,  // entre contas Bradesco ou Next
            NomeTransferencia.NOME_TRANSFERENCIA_DOC, // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ALEATORIO_100_A_500), // valor da transferência

    TRANSFERENCIA_MIM_CP_CC_ITAU_TED_3(BANCO,
            "",
            "ITAU UNIBANCO S.A.",
            "341 - ITAU UNIBANCO S.A.",
            "3123",   // agência fictícia
            "41144", // conta fictícia com dígito 9: 17134-9
            "73440565696", // CNPJ fictício
            TransferirPara.MIM,
            TipoDeConta.CONTA_POUPANCA, // conta de origem
            TipoDeConta.CONTA_CORRENTE, // conta de destino
            TipoTransferencia.TED,  // entre contas Bradesco ou Next
            NomeTransferencia.NOME_TRANSFERENCIA_ACENTUACAO, // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ALEATORIO_100_A_500), // valor da transferência

    TRANSFERENCIA_OUTRA_CP_CP_BRADESCO(BANCO,
            "Conta",
            "BANCO BRADESCO S.A.",
            "237 - BANCO BRADESCO S.A.",
            "1382",
            "221",
            null,
            TransferirPara.OUTRA_PESSOA,
            TipoDeConta.CONTA_POUPANCA, // conta de origem
            TipoDeConta.CONTA_POUPANCA, // conta de destino
            TipoTransferencia.INTERNA,  // entre contas Bradesco ou Next
            NomeTransferencia.NAO_PREENCHER, // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ALEATORIO_100_A_500), // valor da transferência

    TRANSFERENCIA_OUTRA_CP_PG_BRADESCARD_TED_1(INSTITUICAO_DE_PAGAMENTO,
            "BANCO BRADESCARD",
            "BANCO BRADESCARD S.A",
            "BANCO BRADESCARD S.A", //"063 - BANCO BRADESCARD S.A"
            "1382",
            "221",
            "83721681000104",
            TransferirPara.OUTRA_PESSOA,
            TipoDeConta.CONTA_POUPANCA, // conta de origem
            TipoDeConta.CONTA_PAGAMENTO, // conta de destino
            TipoTransferencia.TED,  // entre contas Bradesco ou Next
            NomeTransferencia.NOME_TRANSFERENCIA_TED, // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ALEATORIO_100_A_500), // valor da transferência


    TRANSFERENCIA_MIM_CC_PG_BRADESCARD_TED_1(INSTITUICAO_DE_PAGAMENTO,
            "",
            "BANCO BRADESCARD S.A",
            "BANCO BRADESCARD S.A", //"063 - BANCO BRADESCARD S.A"
            "1382",
            "221",
            "53645901868",
            TransferirPara.MIM,
            TipoDeConta.CONTA_CORRENTE, // conta de origem
            TipoDeConta.CONTA_PAGAMENTO, // conta de destino
            TipoTransferencia.TED,  // entre contas Bradesco ou Next
            NomeTransferencia.NAO_PREENCHER, // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ALEATORIO_100_A_500), // valor da transferência

    CADASTRO_TRANSFERENCIA_OUTRA_CC_CC_BRADESCARD_1(BANCO,
            "",
            "BANCO BRADESCARD S.A",                         // qualquer banco
            "063 - BANCO BRADESCARD S.A",
            GeradorNumeros.AGENCIA_ALEATORIA.toString(),
            GeradorNumeros.CONTA_ALEATORIA.toString(),
            GeradorNumeros.CPF_ALEATORIO.toString(),
            TransferirPara.OUTRA_PESSOA,
            TipoDeConta.CONTA_CORRENTE,          // conta de origem (porque aparece por padrão na tela)
            TipoDeConta.CONTA_CORRENTE,          // conta de destino (porque aparece por padrão na tela)
            TipoTransferencia.TED,               // (porque aparece por padrão na tela)
            NomeTransferencia.NAO_PREENCHER,     // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ALEATORIO_100_A_500),  // valor da transferência

    CADASTRO_TRANSFERENCIA_OUTRA_CC_CC_BANCO_BRASIL_1(BANCO,
            "",
            "BANCO DO BRASIL S.A",
            "1 - BANCO DO BRASIL S.A.", // note que não é "001", mas "1" (como aparece na cortina de validação)
            "1382",
            "147478",
            "53645901868",
            TransferirPara.OUTRA_PESSOA,
            TipoDeConta.CONTA_CORRENTE,          // conta de origem (porque aparece por padrão na tela)
            TipoDeConta.CONTA_CORRENTE,          // conta de destino (porque aparece por padrão na tela)
            TipoTransferencia.TED,               // (porque aparece por padrão na tela)
            NomeTransferencia.NAO_PREENCHER,     // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ALEATORIO_100_A_500),  // valor da transferência

    CADASTRO_TRANSFERENCIA_OUTRA_CC_CP_BANCO_BRASIL_1(BANCO,
            "",
            "BANCO DO BRASIL S.A",
            "1 - BANCO DO BRASIL S.A.", // note que não é "001", mas "1" (como aparece na cortina de validação)
            "1382",
            "147478",
            "53645901868",
            TransferirPara.OUTRA_PESSOA,
            TipoDeConta.CONTA_CORRENTE,          // conta de origem (porque aparece por padrão na tela)
            TipoDeConta.CONTA_POUPANCA,          // conta de destino (porque aparece por padrão na tela)
            TipoTransferencia.TED,               // (porque aparece por padrão na tela)
            NomeTransferencia.NAO_PREENCHER,     // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ALEATORIO_100_A_500),  // valor da transferência

    CONTA_TRANSFERENCIA_BRADESCO_FR(BANCO,
            "",
            "BANCO BRADESCO S.A.",
            "237 - BANCO BRADESCO S.A.", // note que não é "001", mas "1" (como aparece na cortina de validação)
            "1217",
            "528579",
            "80271732059",
            TransferirPara.MIM,
            TipoDeConta.CONTA_CORRENTE,          // conta de origem (porque aparece por padrão na tela)
            TipoDeConta.CONTA_CORRENTE,          // conta de destino (porque aparece por padrão na tela)
            TipoTransferencia.INTERNO,               // (porque aparece por padrão na tela)
            NomeTransferencia.NAO_PREENCHER,     // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ALEATORIO_ACIMA_DE_5000),  // valor da transferência


    CONTA_BANCO_SANTANDER(BANCO,
            "",
            "BANCO SANTANDER (BRASIL) S.A.",
            "", // note que não é "001", mas "1" (como aparece na cortina de validação)
            "3565",
            "450881247",
            "44061563807",
            TransferirPara.OUTRA_PESSOA,
            TipoDeConta.CONTA_CORRENTE,          // conta de origem (porque aparece por padrão na tela)
            TipoDeConta.CONTA_POUPANCA,          // conta de destino (porque aparece por padrão na tela)
            TipoTransferencia.DOC,               // (porque aparece por padrão na tela)
            NomeTransferencia.NOME_TRANSFERENCIA,     // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
            ValorTransferencia.VALOR_ACIMA_LIMITE),  // valor da transferência

    CONTA_BANCO_CADASTRO_BRADESCARD_1(BANCO, "BANCO BRADESCARD S.A","3929", "147478", "53645901868"),
    CONTA_BANCO_CADASTRO_BANCO_TERCEIRO_PJ(BANCO, "ITAU UNIBANCO",
            String.valueOf(numeroAleatorio(1000, 9999)),
            String.valueOf(numeroAleatorio(10000, 99999)), geradorCnpj()),

    CONTA_BANCO_BRADESCO_1(BANCO, "BANCO BRADESCO S.A.", "237 - BANCO BRADESCO S.A.", "1382", "7811", "53645901868"),
    CONTA_BANCO_BRADESCO_2(BANCO, "BANCO BRADESCO S.A.", "1382", "27", "53645901868"),
    CONTA_BANCO_BRADESCO_3(BANCO, "BANCO BRADESCO S.A.", "1382", "221", null),
    CONTA_BANCO_SANTANDER_1(BANCO, "BANCO SANTANDER S.A.", "1091", null, null),
    CONTA_INSTITUICAO_SANTANDER(INSTITUICAO_DE_PAGAMENTO, "BANCO SANTANDER (BRASIL) S.A.",null, "007811",null),
    CONTA_BANCO_NEXT(BANCO, null, "3750", null, null),
    CONTA_BANCO_BRADESCO_4(BANCO, "BANCO BRADESCO S.A.", "1382", "00221", null),
    CONTA_INSTITUICAO_BRADESCARD_1(INSTITUICAO_DE_PAGAMENTO, "BANCO BRADESCARD S.A",null, "0016993", "53645901868"),
    CONTA_INSTITUICAO_BRADESCARD_2(INSTITUICAO_DE_PAGAMENTO, "BANCO BRADESCARD S.A","3929", "147478", "53645901868"),
    CONTA_INSTITUICAO_BRADESCARD_3(INSTITUICAO_DE_PAGAMENTO, "BANCO BRADESCARD", "BANCO BRADESCARD S.A", "BANCO BRADESCARD S.A", null, "7811", "53645901868"),
    CONTA_BANCO_ITAU(BANCO, "ITAU UNIBANCO S.A.", "263", "26963", "44061563807"),
    CONTA_INSTITUICAO_BANCO_DO_BRASIL_1(INSTITUICAO_DE_PAGAMENTO, "BANCO DO BRASIL S.A","0000", "007811", "53645901868"),
    CONTA_BANCO_BRADESCO_5(BANCO, "BANCO BRADESCO S.A.", "237 - BANCO BRADESCO S.A.", "1217", "528579", "80271732059"),
    CONTA_BANCO_CAIXA_ECONOMICA(BANCO, "CAIXA ECONOMICA FEDERAL", "104 - CAIXA ECONOMICA FEDERAL", "4071", "265030", "72049723504"),

    CONTA_INSTITUICAO_PAGAMENTO_NU(INSTITUICAO_DE_PAGAMENTO,
            "INSTITUICAO PAGAMENTO",
                    "NU PAGAMENTOS S.A.",
                    "",
                    "3728",
                    "21745",
                    "76016922056",
                         TransferirPara.OUTRA_PESSOA,
                         TipoDeConta.CONTA_POUPANCA,          // conta de origem (porque aparece por padrão na tela)
                         TipoDeConta.CONTA_PAGAMENTO,          // conta de destino (porque aparece por padrão na tela)
                         TipoTransferencia.TED,               // (porque aparece por padrão na tela)
                         NomeTransferencia.NOME_TRANSFERENCIA,     // descrição da transferência: sendo null, deverá ser ignorada no método que escreve o valor
                         ValorTransferencia.VALOR_ALEATORIO_50_A_100);  // valor da transferência

    private TipoDeInstituicaoFinanceira tipoInstituicao;
    private String contato;
    private String banco;
    private String bancoValidacaoTransf;
    private String agencia;
    private String conta;
    private String cpf;
    private TransferirPara transferirPara;
    private TipoDeConta tipoOrigem;
    private TipoDeConta tipoDestino;
    private TipoTransferencia tipoTransferencia;
    private NomeTransferencia nomeTransferencia;
    private ValorTransferencia valorTransferencia;

    ContaPagamento(TipoDeInstituicaoFinanceira tipoInstituicao, String banco, String agencia, String conta, String cpf){
        this.tipoInstituicao = tipoInstituicao;
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.cpf = cpf;
    }

    ContaPagamento(TipoDeInstituicaoFinanceira tipoInstituicao, String banco, String agencia, String conta){
        this.tipoInstituicao = tipoInstituicao;
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
    }

    ContaPagamento(TipoDeInstituicaoFinanceira tipoInstituicao, String contato, String banco, String bancoValidacaoTransf,
                   String agencia, String conta, String cpf, TransferirPara transferirPara,TipoDeConta tipoOrigem,
                   TipoDeConta tipoDestino, TipoTransferencia tipoTransferencia, NomeTransferencia nomeTransferencia,
                   ValorTransferencia valorTransferencia) {
        this.tipoInstituicao = tipoInstituicao;
        this.contato = contato;
        this.banco = banco;                               // Exemplo: NEXT
        this.bancoValidacaoTransf = bancoValidacaoTransf; // Exemplo: "237 - NEXT"
        this.agencia = agencia;
        this.conta = conta;
        this.cpf = cpf;
        this.transferirPara = transferirPara;
        this.tipoOrigem = tipoOrigem;
        this.tipoDestino = tipoDestino;
        this.tipoTransferencia = tipoTransferencia;
        this.nomeTransferencia = nomeTransferencia;
        this.valorTransferencia = valorTransferencia;
    }

    ContaPagamento(TipoDeInstituicaoFinanceira tipoInstituicao, String banco, String bancoValidacaoTransf, String agencia, String conta, String cpf){
        this.tipoInstituicao = tipoInstituicao;
        this.banco = banco;                               // Exemplo: NEXT
        this.bancoValidacaoTransf = bancoValidacaoTransf; // Exemplo: "237 - NEXT"
        this.agencia = agencia;
        this.conta = conta;
        this.cpf = cpf;
    }

    ContaPagamento(TipoDeInstituicaoFinanceira tipoInstituicao, String contato, String banco, String bancoValidacaoTransf, String agencia, String conta, String cpf){
        this.tipoInstituicao = tipoInstituicao;
        this.contato = contato;
        this.banco = banco;
        this.bancoValidacaoTransf = bancoValidacaoTransf;
        this.agencia = agencia;
        this.conta = conta;
        this.cpf = cpf;
    }

    public String recuperarContato(){
        return this.contato;
    }

    public TipoDeInstituicaoFinanceira recuperarTipoInstituicao(){
        return this.tipoInstituicao;
    }

    public String recuperarBanco(){
        return this.banco;
    }

    public String recuperarBancoValidacaoTransf(){
        return this.bancoValidacaoTransf;
    }

    public String recuperarAgencia(){
        return this.agencia;
    }

    public String recuperarConta(){
        return this.conta;
    }

    public String recuperarCPF(){
        return this.cpf;
    }

    public TransferirPara recuperarTransferirPara(){
        return this.transferirPara;
    }

    public TipoDeConta recuperarTipoContaOrigem(){
        return this.tipoOrigem;
    }

    public TipoDeConta recuperarTipoContaDestino(){
        return this.tipoDestino;
    }

    public TipoTransferencia recuperarTipoTransferencia(){
        return this.tipoTransferencia;
    }

    public NomeTransferencia recuperarNomeTransferencia() {
        return this.nomeTransferencia;
    }

    public ValorTransferencia recuperarValorTransferencia() {
        return this.valorTransferencia;
    }
}
