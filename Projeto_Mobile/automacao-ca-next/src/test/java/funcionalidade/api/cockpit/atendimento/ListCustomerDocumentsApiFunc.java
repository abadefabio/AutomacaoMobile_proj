package funcionalidade.api.cockpit.atendimento;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.exception.NextException;
import funcionalidade.api.cockpit.base.CaApi;
import org.json.simple.JSONObject;

import static br.com.next.automacao.core.base.TesteBase.*;
import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class ListCustomerDocumentsApiFunc extends FuncionalidadeBase {

    protected RespostaBase respostaBase;

    /**
     * Envia uma requisição uma única vez por instanciação da funcionalidade,
     * A resposta é mantida na instância para futuras validações.
     *
     * @param esteira
     * @param endpoint
     * @param token
     * @throws NextException
     */
    public void enviarRequisicaoGet(String endpoint, String token, String esteira) throws NextException {
        getDadosRequisicao()
                .limparDadosRequisicao()
                .definirCaminhoRequisicao(endpoint);
        respostaBase = new CaApi(getDadosRequisicao())
                .enviarRequisicaoGet(token, esteira);
        logarPasso(respostaBase.getResponse().asPrettyString());
    }

    /**
     *
     * Valida retorno do vídeo de aceite do cliente
     *
     * @param jsonObject
     * @throws NextException
     */
    public void validarVideoMp4(JSONObject jsonObject) throws NextException {
        final String UPLOADDATE = "documentResponses.uploadDate[0]";
            respostaBase.getResponse().then()
                    .body("documentResponses.journey[0]", is("Adesão"))
                    .body("documentResponses.mimeType[0]", is("VIDEO/MP4"))
                    .body("documentResponses.documentTypeId[0]", is("919"))
                    .body("documentResponses.documentName[0]", containsString(".MP4"))
                    .body("documentResponses.documentType[0]", is("Video De Aceite Do Cliente"))
                    .body(UPLOADDATE, is(jsonObject.get(UPLOADDATE)));
    }

    /**
     *
     * Valida registro geral Cpf em jpeg
     *
     * @param jsonObject
     */
    public void validarRegistroGeralCpfEmJpeg(JSONObject jsonObject) {
        final String UPLOADDATE = "documentResponses.uploadDate[1]";
        respostaBase.getResponse().then()
                .body("documentResponses.journey[1]", is("Adesão"))
                .body("documentResponses.mimeType[1]", is("IMAGE/JPEG"))
                .body("documentResponses.documentTypeId[1]", is("547"))
                .body("documentResponses.documentName[1]", containsString(".JPEG"))
                .body("documentResponses.documentType[1]", is("Registro Geral Com Cpf"))
                .body(UPLOADDATE, is(jsonObject.get(UPLOADDATE)));
    }

    /**
     *
     * Valida arquivo informacoes essenciais conta next
     *
     * @param jsonObject
     */
    public void validarArquivoInformacoesEssenciaisContaNext(JSONObject jsonObject) {
        final String UPLOADDATE = "documentResponses.uploadDate[2]";
        respostaBase.getResponse().then()
                .body("documentResponses.journey[2]", is("Adesão"))
                .body("documentResponses.mimeType[2]", is("APPLICATION/PDF"))
                .body("documentResponses.documentTypeId[2]", is("967"))
                .body("documentResponses.documentName[2]", containsString(".pdf"))
                .body("documentResponses.documentType[2]", is("Inform Essenciais Conta Next"))
                .body(UPLOADDATE, is(jsonObject.get(UPLOADDATE)));
    }

    /**
     * Valida termo adesao prodserv pdf
     *
     * @param jsonObject
     */
    public void validarTermoAdesaoProdEServPdf(JSONObject jsonObject) {
        final String UPLOADDATE = "documentResponses.uploadDate[3]";
        respostaBase.getResponse().then()
                .body("documentResponses.journey[3]", is("Adesão"))
                .body("documentResponses.mimeType[3]", is("APPLICATION/PDF"))
                .body("documentResponses.documentName[3]", containsString(".pdf"))
                .body("documentResponses.documentTypeId[3]", is("969"))
                .body("documentResponses.documentType[3]", is("Reg Abert Cta Dep Prod Serv Pf"))
                .body(UPLOADDATE, is(jsonObject.get(UPLOADDATE)));
    }

    /**
     *
     * Valida arquivo termo de condicao
     *
     * @param jsonObject
     */
    public void validarArquivoTermoDeCondicao(JSONObject jsonObject) {
        final String UPLOADDATE = "documentResponses.uploadDate[4]";
        respostaBase.getResponse().then()
                .body("documentResponses.journey[4]", is("Adesão"))
                .body("documentResponses.documentTypeId[4]", is("916"))
                .body("documentResponses.mimeType[4]", is("APPLICATION/PDF"))
                .body("documentResponses.documentName[4]", containsString(".pdf"))
                .body("documentResponses.documentType[4]", is("Termo Condição App Next"))
                .body(UPLOADDATE, is(jsonObject.get(UPLOADDATE)));
    }

    /**
     *
     * Valida arquivo diretivas de privacidade
     *
     * @param jsonObject
     */
    public void validarArquivoDiretivasDePrivacidade(JSONObject jsonObject) {
        final String UPLOADDATE = "documentResponses.uploadDate[5]";
        respostaBase.getResponse().then()
              .body("documentResponses.journey[5]", is("Adesão"))
              .body("documentResponses.mimeType[5]", is("APPLICATION/PDF"))
              .body("documentResponses.documentName[5]", containsString(".pdf"))
              .body("documentResponses.documentType[5]", is("Diretivas De Privacidade Next"))
              .body("documentResponses.documentTypeId[5]", is("917"))
              .body(UPLOADDATE, is(jsonObject.get(UPLOADDATE)));
    }

    /**
     *
     * Valida retorno proposta avertura conta de pf
     *
     * @param jsonObject
     */
    public void validarRetornoPropostaAberturaContaDepPf(JSONObject jsonObject) {
        final String UPLOADDATE = "documentResponses.uploadDate[7]";
        respostaBase.getResponse().then()
                .body("documentResponses.journey[7]", is("Adesão"))
                .body("documentResponses.mimeType[7]", is("APPLICATION/PDF"))
                .body("documentResponses.documentName[7]", containsString(".pdf"))
                .body("documentResponses.documentType[7]", is("Proposta Abertura Conta Dep Pf"))
                .body("documentResponses.documentTypeId[7]", is("96"))
                .body(UPLOADDATE, is(jsonObject.get(UPLOADDATE)));
    }

    /**
     *
     * Valida retorno abertura conta cesta servico
     *
     * @param jsonObject
     */
    public void validarRetornoAberturaContaCestaServico(JSONObject jsonObject) {
        final String UPLOADDATE = "documentResponses.uploadDate[8]";
        respostaBase.getResponse().then()
                .body("documentResponses.journey[8]", is("Adesão"))
                .body("documentResponses.mimeType[8]", is("APPLICATION/PDF"))
                .body("documentResponses.documentName[8]", containsString(".pdf"))
                .body("documentResponses.documentType[8]", is("Abertura conta cesta serviço"))
                .body("documentResponses.documentTypeId[8]", is("955"))
                .body(UPLOADDATE, is(jsonObject.get(UPLOADDATE)));
    }
}
