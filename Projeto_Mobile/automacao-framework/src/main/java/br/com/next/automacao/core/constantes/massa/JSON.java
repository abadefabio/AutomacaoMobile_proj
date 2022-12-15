package br.com.next.automacao.core.constantes.massa;

public enum JSON {

    CPF( "cpf" ),

    CPF_ADICIONAL( "cpfAdicional" ),

    SENHA( "senha" ),

    TELEFONE( "telefone" ),

    TELEFONE_ADICIONAL( "telefoneAdicional" ),

    TELEFONE_ADICIONAL_2( "telefoneAdicionalDois" ),

    OPERADORA( "operadora" ),

    NOVA_OPERADORA( "operadoraNova" ),

    MENSAGEM( "mensagem" ),

    NOME("nome"),

    SOBRENOME("sobrenome"),

    SOBRENOME_FAVORECIDO("sobrenomeFavorecido"),

    NOME_FAVORECIDO("nomeFavorecido"),

    INSTITUICAO_FAVORECIDO( "favorecidoInstituicao" ),

    CONTA_FAVORECIDO( "favorecidoConta" ),

    CPF_FAVORECIDO( "favorecidoCpf" ),

    DATA( "data" ),

    DATA_AGENDAMENTO("dataAgendamento"),

    VALOR( "valor" ),

    MENSAGEM_ADICIONAL( "mensagemAdicional" ),

    DATA_ADICIONAL( "dataAdicional" ),

    OBJETIVO( "objetivo" ),

    DESCRICAO( "descricao" ),

    TEXTO( "texto" ),

    CONTATO_NOME( "contato" ),

    CONTATO_TELEFONE( "contatoTelefone" ),

    CONTATO_SOBRENOME( "contatoSobrenome" ),

    CONTATO_ADICIONAL( "contatoAdicional" ),

    SALDO( "saldo" ),

    SALDO_REMANESCENTE( "saldoRemanescente" ),

    SALDO_INICIAL( "saldoInicial" ),

    CREDITO( "credito" ),

    LIMITE( "limite" ),

    CNPJ( "cnpj" ),

    NOME_EMPRESA( "nomeEmpresa" ),

    RAZAO_SOCIAL( "razaoSocial" ),

    NOME_FANTASIA( "nomeFantasia" ),

    VENCIMENTO("vencimento"),

    AGENCIA( "agencia" ),

    ENDERECO("endereco"),

    ENDERECO_NUMERO("enderecoNumero"),

    ENDERECO_COMPLEMENTO("enderecoComplemento"),

    ENDERECO_REFERENCIA("enderecoReferencia"),

    BAIRRO("bairro"),

    CEP("cep"),

    DIA("dia"),

    DIA_ADICIONAL(" "),

    MES("mes"),

    MES_ADICIONAL("mesAdicional"),

    ANO("ano"),

    ANO_ADICIONAL("anoAdicional"),

    NUMERO("numero"),

    NUMERO_ADICIONAL("numeroAdicional"),

    NUMERO_ADICIONAL_2("numeroAdicionalDois"),

    ;

    private String value;

    private JSON(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
