package teste.mobile.regressivo.adesao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.adesao.TipoCartao;
import constantes.adesao.termosECondicoes.TermosECondicoes;
import funcionalidade.mobile.adesao.CompleteSeuCadastroFunc;
import funcionalidade.mobile.login.LoginFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


@Jornada(Jornadas.ADESAO)
public class QA03408 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private CompleteSeuCadastroFunc completeSeuCadastroAdesao = new CompleteSeuCadastroFunc();

    @Test(description = "REG.ADS.01.02.01 - Validar termo de ades�o proposta de abertura de conta")
    @Description("Descri��o" +
            "� Garantir que o termo ades�o proposta de abertura de conta e apresentado conforme esperado." +
            "Pr� requisitos:" +
            "Ter o next instalado" +
            "Ter CPF de ades�o status 0, com as etapas 1,2,3,4,5 conclu�das;")

    @Severity(SeverityLevel.NORMAL)
    public void QA03408() throws Exception{

        login.efetuarLoginCadastroIncompleto(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        completeSeuCadastroAdesao.validarTermosDaJornadaDeAdesao(
                recuperarMassa("pacotePadronizado"),
                recuperarMassa("senhaCartao"),
                recuperarMassa("confirmarSenhaCartao"),
                TermosECondicoes.TERMO_PROPOSTA_DE_ABERTURA_DE_CONTA,
                recuperarMassa("diaDeVencimento"),
                recuperarMassa("tipoPagamento"),
                TipoCartao.VISA_NEXT_INTERNACIONAL);
    }

}
