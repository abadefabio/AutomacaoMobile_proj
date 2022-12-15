package funcionalidade.depositos;

import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.base.api.RequisicaoBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.tools.ReadProperties;
import constantes.Mcir;
import io.restassured.path.json.JsonPath;

import static br.com.next.automacao.core.constantes.MetodoRequisicao.*;
import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class ProvissionamentoDeSaqueFunc extends ProvissionamentoDeSaqueAtributos {

    protected RespostaBase respostaBase;
    private String uri = ReadProperties.getCoreBankingUrl();

    /**
     * REQUEST DE AGENDAMENTO DE PROVISIONAMENTO DE SAQUE
     * @return response
     * @throws Exception
     */
    public void inclusaoProvisionamento(String cpf, String agencia, String conta,
                                        String dataPrevistaSaque, String valorSaque, int statusCode) throws Exception {

        logarPasso("Montando requisição"+ Mcir.INCLUIR_PROVISIONAMENTO_DE_SAQUE);
        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
        dadosRequisicaoBase
                .limparDadosRequisicao()
                .definirHeaders(obterHeaderRequisicao(cpf))
                .definirCorpoRequisicao(obterCorpoRequisicaoInclusao(cpf,dataPrevistaSaque,valorSaque,agencia,conta))
                .definirCaminhoRequisicao(Mcir.INCLUIR_PROVISIONAMENTO_DE_SAQUE);

        respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, POST).validarStatusCodeRequisicao(statusCode);
        logarPasso("Retorno Requisição \nCódigo Retorno: "+ respostaBase.getResponse().statusCode()
                +"\n"+respostaBase.getResponse().asPrettyString());
    }
    /**
     * VALIDAR MENSAGEM DE RETORNO DO MAINFRAME ALTERNATIVA DE ACORDO COM OS PARAMETROS INFORMADOS
     * @return
     */
    public void validarMensagemDeRetorno(String codigo,String mensagem) {
        logarPasso("Validando retorno requisição");
        respostaBase.getResponse()
                .then()
                .body("codigo",is(codigo))
                .body("mensagem",is(mensagem));
    }

    /**
     * VALIDAR MENSAGEM DE RETORNO DO MAINFRAME ALTERNATIVA DE ACORDO COM OS PARAMETROS INFORMADOS
     * @return
     */
    public void validarMensagemDeRetornoExclusao(String codigo,String mensagem, String cpf,String  agencia, String conta) {
        logarPasso("Validando retorno requisição");
        respostaBase.getResponse()
                .then()
                .body("codigoRetorno",is(codigo))
                .body("mensagemRetorno",is(mensagem))
                .body("codigoAgenciaPagadora",notNullValue())
                .body("codigoAgencia", is(Integer.parseInt(agencia)))
                .body("codigoConta", is(Integer.parseInt(conta)))
                .body("dataHoraInclusaoSolicitacao", notNullValue())
                .body("valorSolicitacao", notNullValue())
                .body("dataPrevistaSaque", notNullValue())
                .body("agenciaInclusaoProvisao", is(Integer.parseInt(agencia)))
                .body("codigoBancoPagador", is( 237))
                .body("codigoAgenciaPagadora", is( 1))
                .body("nomeAgenciaPagadora", notNullValue())
                .body("valorSaldoRestanteNaoSacado", notNullValue())
                .body("codigoProtocolo", notNullValue())
                .body("dataComprovante", notNullValue())
                .body("valorSaldoRestanteNaoSacado", notNullValue())
                .body("valorSaldoRestanteNaoSacado", notNullValue())
                .body("codigoCpfCnpjDestinatario",is(Integer.parseInt(cpf.substring(0,9))))
                .body("codigoFilialCnpjDestinatario",notNullValue())
                .body("codigoControleCpfCnpjDestinatario",notNullValue())
                .body("nomeDestinatario",notNullValue())
                .body("codigoCpfCnpjSolicitante",is(Integer.parseInt(cpf.substring(0,9))))
                .body("codigoFilialCnpjSolicitante",notNullValue())
                .body("codigoControleCpfCnpjSolicitante",notNullValue())
                .body("nomeSolicitante",notNullValue())
                .body("situacaoProvisionamentoSaque",notNullValue());
    }
    /**
     * VALIDAR MENSAGEM DE RETORNO DE SUCESSO MAINFRAME
     * DE ACORDO COM OS PARAMETROS INFORMADOS
     *
     * @return
     */
    public ProvissionamentoDeSaqueFunc validarMensagemDeInculsaoComSucesso(String codigoRetorno, String mensagemRetorno,
                                                                           String cpf, String agencia, String conta) {
        logarPasso("Validando retorno requisição");
        respostaBase.getResponse()
                .then()
                .body("codigoRetorno",is(codigoRetorno))
                .body("mensagemRetorno",is(mensagemRetorno))
                .body("codigoAgenciaPagadora",is(1))
                .body("codigoBanco", is( 237))
                .body("codigoBancoPagador", is(237))
                .body("codigoConta", is(Integer.parseInt(conta)))
                .body("codigoControleCpfCnpjDestinatario",is(Integer.parseInt(cpf.substring(9,11))))
                .body("codigoControleCpfCnpjSolicitante",is(Integer.parseInt(cpf.substring(9,11))))
                .body("codigoCpfCnpjDestinatario", is(Integer.parseInt(cpf.substring(0,9))))
                .body("codigoCpfCnpjSolicitante", is(Integer.parseInt(cpf.substring(0,9))))
                .body("codigoFilialCnpjDestinatario",is(0))
                .body("codigoFilialCnpjSolicitante", is(0))
                .body("origemSolicitacao", notNullValue())
                .body("nomeSolicitante", notNullValue())
                .body("tipoSolicitacao", is("I"));

        return this;
    }

    /**
     * REQUEST DE CONSULTA AGENDAMENTO DE PROVISIONAMENTO DE SAQUE
     * @return response
     * @throws Exception
     */
    public ProvissionamentoDeSaqueFunc consultaProvisionamento(String cpf, String agencia, String conta,
                                                               String dataHoraInclusaoSolicitacao, int statusCode) throws Exception {

        logarPasso("Montando requisição"+ Mcir.CONSULTAR_DETALHES_DE_PROVISIONAMENTO_SAQUE);
        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
        dadosRequisicaoBase
                .limparDadosRequisicao()
                .definirHeaders(obterHeaderRequisicao(cpf))
                .definirParametros(obterParametroConsulta(cpf,dataHoraInclusaoSolicitacao, agencia,conta))
                .definirCaminhoRequisicao(Mcir.CONSULTAR_DETALHES_DE_PROVISIONAMENTO_SAQUE);

        respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, GET).validarStatusCodeRequisicao(statusCode);
        logarPasso("Retorno Requisição \nCódigo Retorno: "+ respostaBase.getResponse().statusCode()
                +"\n"+respostaBase.getResponse().asPrettyString());
        return this;
    }

    /**
     * VALIDAR MENSAGEM DE RETORNO DE SUCESSO MAINFRAME
     * DE ACORDO COM OS PARAMETROS INFORMADOS
     *
     * @return
     */
    public ProvissionamentoDeSaqueFunc validarMensagemDeConsultaComSucesso(String codigoRetorno, String mensagemRetorno,
                                                                           String cpf, String agencia, String conta,
                                                                           String dataHoraInclusaoSolicitacao, String dataHoraSolicitacao,
                                                                           String valorSolicitacao, String codigoProtocolo) {
        logarPasso("Validando retorno requisição");
        respostaBase.getResponse()
                .then()
                .body("codigoRetorno",is(codigoRetorno))
                .body("mensagemRetorno",is(mensagemRetorno))
                .body("tipoSolicitacao",is("C"))
                .body("origemSolicitacao", notNullValue())
                .body("codigoBanco", is(237))
                .body("codigoAgencia",is(Integer.parseInt(agencia)))
                .body("codigoConta",is(Integer.parseInt(conta)))
                .body("dataHoraInclusaoSolicitacao",is(dataHoraInclusaoSolicitacao))
                .body("valorSolicitacao",notNullValue())
                .body("dataPrevistaSaque",notNullValue())
                .body("agenciaInclusaoProvisao",is(Integer.parseInt(agencia)))
                .body("codigoBancoPagador",is(237))
                .body("codigoAgenciaPagadora",notNullValue())
                .body("nomeAgenciaPagadora", notNullValue())
                .body("valorSaldoRestanteNaoSacado",notNullValue())
                .body("codigoProtocolo",is(codigoProtocolo))
                .body("dataComprovante",notNullValue())
                .body("codigoCpfCnpjDestinatario",is(Integer.parseInt(cpf.substring(0,9))))
                .body("codigoFilialCnpjDestinatario",notNullValue())
                .body("codigoControleCpfCnpjDestinatario",is(Integer.parseInt(cpf.substring(9,11))))
                .body("nomeDestinatario",notNullValue())
                .body("codigoCpfCnpjSolicitante",is(Integer.parseInt(cpf.substring(0,9))))
                .body("codigoFilialCnpjSolicitante",notNullValue())
                .body("codigoControleCpfCnpjSolicitante",is(Integer.parseInt(cpf.substring(9,11))))
                .body("nomeSolicitante",notNullValue())
                .body("situacaoProvisionamentoSaque",notNullValue());
        return this;
    }


    /**
     * REQUEST DE CONSULTA REGRA ATIVA PROVISIONAMENTO DE SAQUE
     * @return response
     * @throws Exception
     */
    public ProvissionamentoDeSaqueFunc consultaParametroProvisionamentoDeSaque(String cpf, int statusCode) throws Exception {

        logarPasso("Montando requisição"+ Mcir.CONSULTA_PARAMETRO_ATIVO_NO_AMBIENTE);
        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
        dadosRequisicaoBase
                .limparDadosRequisicao()
                .definirHeaders(obterHeaderRequisicao(cpf))
                .definirParametros(obterParametroAtivoDoAmbiente())
                .definirCaminhoRequisicao(Mcir.CONSULTA_PARAMETRO_ATIVO_NO_AMBIENTE);

        respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, GET).validarStatusCodeRequisicao(statusCode);
        logarPasso("Retorno Requisição \nCódigo Retorno: "+ respostaBase.getResponse().statusCode()
                +"\n"+respostaBase.getResponse().asPrettyString());

        return this;
    }

    /**
     * VALIDAR MENSAGEM DE RETORNO DO MAINFRAME COM OS PARAMETROS ATIVOS PARA CLIENTE NEXT
     * @return
     */
    public ProvissionamentoDeSaqueFunc validarMensagemDeRetornoParametroAtivoNoAmbiente(String codigo, String mensagemRetorno) {
        logarPasso("Validando retorno requisição");
        respostaBase.getResponse()
                .then()
                .body("codigoRetorno", is(codigo))
                .body("mensagemRetorno",is(mensagemRetorno))
                .body("dataInicioVigencia", notNullValue())
                .body("quantidadeDiasMinimoInclusao", notNullValue())
                .body("quantidadeDiasMaximoInclusao",notNullValue())
                .body("horarioInicialInclusao",notNullValue())
                .body("horarioFimInclusao",notNullValue())
                .body("valorMinimoProvisao",notNullValue())
                .body("valorMaximoProvisao",notNullValue());

        return this;

    }
    /**
     * REQUEST DE LISTA DE PROVISIONAMENTO DE SAQUE CLIENTE
     * @return response
     * @throws Exception
     */
    public ProvissionamentoDeSaqueFunc ConsultaListaProvisionamentoDeSaque(String cpf,String agencia,String conta,
                                                                           String dataInicioPesquisa, String dataFimPesquisa, int statusCode) throws Exception {
        logarPasso("Montando requisição"+ Mcir.LISTA_PROVISIONAMENTO_DE_SAQUES);
        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
        dadosRequisicaoBase
                .limparDadosRequisicao()
                .definirHeaders(obterHeaderRequisicao(cpf))
                .definirParametros(obterParametroListaProvisionamentoDeSaque(agencia,conta, dataInicioPesquisa,dataFimPesquisa))
                .definirCaminhoRequisicao(Mcir.LISTA_PROVISIONAMENTO_DE_SAQUES);

        respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, GET).validarStatusCodeRequisicao(statusCode);
        logarPasso("Retorno Requisição \nCódigo Retorno: "+ respostaBase.getResponse().statusCode()
                +"\n"+respostaBase.getResponse().asPrettyString());

        return this;
    }

    /**
     * VALIDAR MENSAGEM DE RETORNO DO MAINFRAME COM OS AGENDAMENTOS EFETUADOS NO PERIODO
     * @return
     */
    public ProvissionamentoDeSaqueFunc validarMensagemDeRetornoListaProvisionamentoDeSaque(String codigo, String mensagemRetorno,
                                                                                           String agencia, String conta){
        logarPasso("Validando retorno requisição");
        respostaBase.getResponse()
                .then()
                .body("codigoRetorno", is(codigo))
                .body("mensagemRetorno",is(mensagemRetorno))
                .body("continuaLista",notNullValue())
                .body("codigoBanco",is(237))
                .body("codigoAgencia",is(Integer.parseInt(agencia)))
                .body("codigoConta",is(Integer.parseInt(conta)))
                .body("quantidadeRegistrosLista",notNullValue())
                .body("ocorrenciasProvisionamento",notNullValue());



        return this;

    }
    /**
     * REQUEST DE LISTA DE PROVISIONAMENTO DE SAQUE CLIENTE
     * @return response
     * @throws Exception
     */
    public ProvissionamentoDeSaqueFunc ExclusaoProvisionamentoDeSaque(String cpf,String agencia,String conta,
                                                                           String dataHoraInclusaoSolicitacao, int statusCode) throws Exception {
        logarPasso("Montando requisição"+ Mcir.EXCLUIR_PROVISIONAMENTO_DE_SAQUE);
        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
        dadosRequisicaoBase
                .definirHeaders(obterHeaderRequisicao(cpf))
                .definirCorpoRequisicao(obterCorpoRequisicaoExclusao(agencia, conta, dataHoraInclusaoSolicitacao))
                .definirCaminhoRequisicao(Mcir.EXCLUIR_PROVISIONAMENTO_DE_SAQUE);

        respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, DELETE).validarStatusCodeRequisicao(statusCode);
        logarPasso("Retorno Requisição \nCódigo Retorno: "+ respostaBase.getResponse().statusCode()
                +"\n"+respostaBase.getResponse().asPrettyString());

        return this;
    }

    /**
     * REQUEST DE AGENDAMENTO DE PROVISIONAMENTO DE SAQUE
     * @return dataHoraInclusaoSolicitacao
     * @throws Exception
     */
    public String inclusaoProvisionamentoParaExclusao(String cpf, String agencia, String conta,
                                                      String dataPrevistaSaque, String valorSaque, int statusCode) throws Exception {

        logarPasso("Criando provissionamento para Exclusão "+ Mcir.INCLUIR_PROVISIONAMENTO_DE_SAQUE);
        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
        dadosRequisicaoBase
                .limparDadosRequisicao()
                .definirHeaders(obterHeaderRequisicao(cpf))
                .definirCorpoRequisicao(obterCorpoRequisicaoInclusao(cpf,dataPrevistaSaque,valorSaque,agencia,conta))
                .definirCaminhoRequisicao(Mcir.INCLUIR_PROVISIONAMENTO_DE_SAQUE);

        JsonPath dataHoraInclusaoSolicitacao = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, POST)
                .validarStatusCodeRequisicao(200, "Falha ao criar o provissionamento").obterJsonPath();

        String retorno = dataHoraInclusaoSolicitacao.getString("codigoProtocolo");

        retorno = retorno.substring(24,50);

        return retorno;
    }
}
