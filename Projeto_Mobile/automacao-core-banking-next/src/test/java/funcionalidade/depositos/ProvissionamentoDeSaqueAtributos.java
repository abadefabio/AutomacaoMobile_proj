package funcionalidade.depositos;

import io.restassured.http.Header;
import org.json.simple.JSONObject;

import static api.base.LoginApiCorporativa.abrirSessaoApiCorporativa;

public class ProvissionamentoDeSaqueAtributos {


    protected static Header[] obterHeaderRequisicao(String cpf) throws Exception {
        return new Header[] {
                new Header("access-token", "wFvPZv4unKWJ"),
                new Header("idSessao", abrirSessaoApiCorporativa(cpf,0)),
                new Header("ticket", abrirSessaoApiCorporativa(cpf,1)),
                new Header("user", cpf),
        };
    }


    protected static JSONObject obterCorpoRequisicaoInclusao(String cpf, String dataPrevistaSaque,
                                                             String valorSaque, String agencia, String conta){

        JSONObject requisicao = new JSONObject();
            requisicao.put("agenciaInclusaoProvisao", agencia);
            requisicao.put("codigoAgencia",agencia);
            requisicao.put("codigoAgenciaPagadora", 1);
            requisicao.put("codigoBanco", 237);
            requisicao.put("codigoBancoPagador",237);
            requisicao.put("codigoConta" ,conta);
            requisicao.put("codigoControleCpfCnpjDestinatario", cpf.substring(9, 11));
            requisicao.put("codigoControleCpfCnpjSolicitante", cpf.substring(9, 11));
            requisicao.put("codigoCpfCnpjDestinatario", cpf.substring(0,9));
            requisicao.put("codigoCpfCnpjSolicitante",cpf.substring(0,9));
            requisicao.put("codigoFilialCnpjSolicitante",0);
            requisicao.put("codigoFilialCnpjDestinatario",0);
            requisicao.put("comentario", "") ;
            requisicao.put("dataPrevistaSaque", dataPrevistaSaque);
            requisicao.put("midia", 515);
            requisicao.put("nomeSolicitante", "FULANO BELTRANO DA SILVA PERFIL NOVO");
            requisicao.put("origemSolicitacao",515);
            requisicao.put("tipoSolicitacao", "I");
            requisicao.put("valorSolicitacao", valorSaque);

        return requisicao;
    }

    protected static JSONObject obterCorpoRequisicaoExclusao(String cpf, String dataHoraInclusaoSolicitacao,String agencia, String conta) {
        JSONObject requisicao = new JSONObject();
            requisicao.put("codigoBanco", agencia);
            requisicao.put("codigoAgencia",agencia);
            requisicao.put("codigoConta" ,conta);
            requisicao.put("dataHoraInclusaoSolicitacao", dataHoraInclusaoSolicitacao);
            requisicao.put("midia", 515);
            requisicao.put("origemSolicitacao",515);
            requisicao.put("tipoSolicitacao", "V");

        return requisicao;
    }

    protected static JSONObject obterParametroConsulta(
            String cpf, String dataHoraInclusaoSolicitacao, String agencia, String conta) {

        JSONObject requisicao = new JSONObject();
            requisicao.put("midia", 515);
            requisicao.put("origemSolicitacao",515);
            requisicao.put("codigoBanco" ,237);
            requisicao.put("codigoAgencia", agencia);
            requisicao.put("codigoConta", conta);
            requisicao.put("dataHoraInclusaoSolicitacao", dataHoraInclusaoSolicitacao);

        return requisicao;
    }

    protected static JSONObject obterParametroAtivoDoAmbiente() {

        JSONObject requisicao = new JSONObject();
            requisicao.put("midia", 515);
            requisicao.put("origemSolicitacao",515);
        return requisicao;
    }

    protected static JSONObject obterParametroListaProvisionamentoDeSaque(String agencia, String conta,
                                                                          String dataInicioPesquisa, String dataFimPesquisa) {

        JSONObject requisicao = new JSONObject();
            requisicao.put("midia", 515);
            requisicao.put("origemSolicitacao",515);
            requisicao.put("situacaoProvisionamento", 0);
            requisicao.put("codigoBanco",237);
            requisicao.put("codigoAgencia",agencia);
            requisicao.put("codigoConta",conta);
            requisicao.put("dataInicioPesquisa",dataInicioPesquisa);
            requisicao.put("dataFimPesquisa",dataFimPesquisa);
        return requisicao;
    }

    protected static JSONObject obterCorpoRequisicaoExclusao(String agencia,
                                                             String conta,
                                                             String dataHoraInclusaoSolicitacao){

        JSONObject requisicao = new JSONObject();

        requisicao.put("codigoBanco", 237);
        requisicao.put("codigoAgencia", agencia);
        requisicao.put("codigoConta", conta);
        requisicao.put("dataHoraInclusaoSolicitacao", dataHoraInclusaoSolicitacao);
        requisicao.put("midia",515);
        requisicao.put("origemSolicitacao", 515);
        requisicao.put("tipoSolicitacao","V");

        return requisicao;
    }


}

