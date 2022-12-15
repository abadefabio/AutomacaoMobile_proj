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
public class QA03414 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private CompleteSeuCadastroFunc completeSeuCadastroAdesao = new CompleteSeuCadastroFunc();

    @Test(description = "REG.ADS.01.02.07 - Validar na adesão termo de regulamento do programa de fidelidade cartões Bradesco next")
    @Description("Descrição:" +
            "• Garantir que o termo adesão de regulamento do programa de fidelidade cartões Bradesco next conforme esperado.Pré requisitos:\n" +
            "Ter o next instalado" +
            "Ter CPF de adesão status 0, com as etapas 1,2,3,4,5 concluídas;")

    @Severity(SeverityLevel.NORMAL)
    public void QA03414() throws Exception{

        login.efetuarLoginCadastroIncompleto(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        completeSeuCadastroAdesao.validarTermosDaJornadaDeAdesao(
                recuperarMassa("pacotePadronizado"),
                recuperarMassa("senhaCartao"),
                recuperarMassa("confirmarSenhaCartao"),
                TermosECondicoes.TERMO_REGULAMENTO_DO_PROGRAMA_DE_FIDELIDADE_CARTOES_BRADESCO,
                recuperarMassa("diaDeVencimento"),
                recuperarMassa("tipoPagamento"),
                TipoCartao.VISA_NEXT_PLATINUM);
    }
}
