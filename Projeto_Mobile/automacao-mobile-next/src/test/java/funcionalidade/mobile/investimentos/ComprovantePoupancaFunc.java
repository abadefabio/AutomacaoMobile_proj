package funcionalidade.mobile.investimentos;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.investimentos.Mensagem;
import framework.MobileUtils;
import io.appium.java_client.ios.IOSDriver;
import pagina.mobile.comum.next.CarregamentoTela;
import pagina.mobile.comum.next.PopUpTela;
import pagina.mobile.jornadas.investimentos.ComprovantePoupancaTela;

public class ComprovantePoupancaFunc extends FuncionalidadeBase {

    /**
     * Método responsável por validar as informações contidas no comprovante
     *
     * @param enviaComprovantePorEmail Condição booleana (true/false) que valida se o comprovante vai ser enviado por e-mail
     * @param valorSolicitacao         Valor da solicitação (Aplicação ou Resgate)
     * @param campos                   Array contendo os campos a serem buscados em tela
     * @param valores                  Valores dos campos a serem validados em tela
     * @throws Exception
     */
    public void validarComprovante(boolean enviaComprovantePorEmail, String valorSolicitacao, String[] campos, String... valores) throws Exception {
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        new ComprovantePoupancaTela(getDriver())
                .validarInformacoesComprovante(
                        valorSolicitacao,
                        MobileUtils.preencheInformacoesParaValidacao(campos, valores),
                        campos
                );
        if(enviaComprovantePorEmail) {
            new ComprovantePoupancaTela(getDriver())
                    .tocarBotaoEnviarComprovantePorEmail();
            new PopUpTela(getDriver())
                    .validarMensagem(getDriver() instanceof IOSDriver ?
                            Mensagem.IOS_EMAIL_ENVIADO_COM_SUCESSO :
                            Mensagem.ANDROID_EMAIL_ENVIADO_COM_SUCESSO)
                    .tocarBotaoOk();
        } else {
            new ComprovantePoupancaTela(getDriver())
                    .tocarBotaoFechar();
        }
    }
}
