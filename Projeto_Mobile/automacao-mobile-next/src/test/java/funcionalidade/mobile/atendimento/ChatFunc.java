package funcionalidade.mobile.atendimento;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.atendimento.TitulosTelasRedirecionadas;
import io.appium.java_client.android.AndroidDriver;
import pagina.mobile.jornadas.atendimento.AjudaNextTela;
import pagina.mobile.jornadas.atendimento.ChatTela;
import pagina.mobile.jornadas.cartao.fatura.CartaoTela;
import pagina.mobile.jornadas.credito.CreditoTela;
import pagina.mobile.jornadas.depositos.DepositosSaquesTela;
import pagina.mobile.jornadas.objetivos.ObjetivosTela;
import pagina.mobile.jornadas.mimos.MimosTela;
import pagina.mobile.jornadas.notificacoes.NotificacoesTela;
import pagina.mobile.jornadas.pagamentos.PagamentosTela;
import pagina.mobile.jornadas.perfil.investidor.PerfilTela;
import pagina.mobile.jornadas.recarga.RecargaCelularTela;
import pagina.mobile.jornadas.transferencia.TecladoNextTela;
import pagina.mobile.jornadas.transferencia.TransferenciaTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ChatFunc extends FuncionalidadeBase {

    /**
     * Acessar o Chat via Menu Ajuda
     */
    public void acessarChatViaMenuAjuda() throws Exception {
        new AjudaNextTela(getDriver())
                .validarPresencaAjudaNextTela()
                .tocarBotaoIniciarChat();
        new ChatTela(getDriver())
                .validarTelaChat();
    }

    /**
     * Validar redirecionamento do DeepLink
     */
    public void validarRedirecionamentoDeepLink(TitulosTelasRedirecionadas telaRedirecionada, String deepLink, String textoDeepLink) throws Exception {
        if (getDriver() instanceof AndroidDriver) {
            new ChatTela(getDriver())
                    .tocarOutrosAssuntos()
                    .preencherCampoMensagem(deepLink)
                    .tocarIconeEnviar()
                    .tocarDeeplink(textoDeepLink);
        }else{
            new ChatTela(getDriver())
                    .tocarOutrosAssuntos()
                    .preencherCampoMensagem(deepLink)
                    .tocarDeeplink(textoDeepLink);
                    }
        switch (telaRedirecionada) {
            case PAGAMENTOS:
                new PagamentosTela(getDriver())
                        .validarTelaPagamentos();
                break;
            case CARTAO:
                new CartaoTela(getDriver())
                        .validarTelaCartao();
                break;
            case MIMOS:
                new MimosTela(getDriver())
                        .validarPresencaTelaMimos();
                break;
            case CREDITO:
                new CreditoTela(getDriver())
                        .validarPresencaTelaCredito();
                break;
            case OBJETIVOS:
                new ObjetivosTela(getDriver())
                        .validarTextoTelaObjetivos();
                break;
            case NOTIFICACOES:
                new NotificacoesTela(getDriver())
                        .validarPresencaNotificacoesTela();
                break;
            case PERFIL:
                new PerfilTela(getDriver())
                        .validarPresencaPerfilTela();
                break;
            case RECARGA_DE_CELULAR:
                new RecargaCelularTela(getDriver())
                        .validarExibicaoTelaRecarga();
                break;
            case DEPOSITOS_SAQUES:
                new DepositosSaquesTela(getDriver())
                        .validarPresencaDepositosESaquesTela();
                break;
            case TRANSFERENCIA:
                new TecladoNextTela(getDriver())
                        .aceitarTecladoNext();
                new TransferenciaTela(getDriver())
                        .validarPresencaTelaTransferencia();
                break;

        }
    }

    /**
     * Validar chat Nenhuma Opcao
     */
    public void validarChatNenhumaOpcao(String primeiraResposta, String segundaResposta, String terceiraResposta) throws Exception {
        new ChatTela(getDriver())
                .validarConversandoComBia();
        if (getDriver() instanceof AndroidDriver) {
            new ChatTela(getDriver())
                    .validarChatApresentacaoBia()
                    .tocarOutrosAssuntos()
                    .preencherCampoMensagem(primeiraResposta)
                    .tocarIconeEnviar()
                    .validarChatSemProblemas()
                    .preencherCampoMensagem(segundaResposta)
                    .tocarIconeEnviar()
                    .validarChatEscolhaUmNumero()
                    .preencherCampoMensagem(terceiraResposta)
                    .tocarIconeEnviar()
                    .validarChatApresentacaoBia();
        } else {
            new ChatTela(getDriver())
                    .validarChatApresentacaoBia()
                    .tocarOutrosAssuntos()
                    .preencherCampoMensagem(primeiraResposta)
                    .validarChatSemProblemas()
                    .preencherCampoMensagem(segundaResposta)
                    .validarChatEscolhaUmNumero()
                    .preencherCampoMensagem(terceiraResposta)
                    .validarChatApresentacaoBia();
        }
    }
}
