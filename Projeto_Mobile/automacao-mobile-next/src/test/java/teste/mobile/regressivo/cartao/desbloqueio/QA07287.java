package teste.mobile.regressivo.cartao.desbloqueio;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.cartao.desbloqueio.Mensagens;
import funcionalidade.mobile.cartao.desbloqueio.CartaoDesbloqueioFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.CARTOES)
public class QA07287 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    CartaoDesbloqueioFunc desbloqueioFunc = new CartaoDesbloqueioFunc();

    @Test(description = "PIB-76264.96563.001 – Desbloqueio de Cartões – Debito Puro")
    @Description("Eu enquanto cliente quero desbloquear meu cartão de debito puro" +
            "*Ser cliente Next\n" +
            "*Ter acesso ao APP Next\n" +
            "*Estar logado no APP Next\n" +
            "*Ser cliente debito puro")

    @Severity(SeverityLevel.NORMAL)
    public void QA07287()throws Exception{

        String numCartao = (String) recuperarJSSONMassa("dadosDesbloqueio").get("numCartao");
        String cvv = (String) recuperarJSSONMassa("dadosDesbloqueio").get("cvv");

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarCartao();
        desbloqueioFunc.informarRecebimento(Mensagens.INDISPONIBILIDADE_SISTEMA, Mensagens.MENSAGEM_SUGESTAO_DESBLOQUEIO);
        desbloqueioFunc.desbloquearCartao();
        desbloqueioFunc.desbloquearSemSeguro();
        desbloqueioFunc.informarDigitosCartao(numCartao);
        desbloqueioFunc.informarCodigoSegurancaCvv(cvv, Mensagens.MENSAGENS_DESBLOQUEIO_CONFIRMADO);
        desbloqueioFunc.aceitarMensagemConfirmacaoDesbloqueio(Mensagens.MEU_TIPO_CARTAO_DEBITO);
    }
}
