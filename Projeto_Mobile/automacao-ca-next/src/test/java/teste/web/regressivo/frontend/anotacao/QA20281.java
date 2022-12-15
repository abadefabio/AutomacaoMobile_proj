package teste.web.regressivo.frontend.anotacao;

import base.teste.TesteBaseFrontEnd;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.tools.ReadProperties;
import constantes.frontend.anotacoes.AlertaModalRetornar;
import constantes.frontend.anotacoes.AnotacaoGestaoStrings;
import funcionalidade.frontend.anotacoes.AnotacaoCadastroFunc;
import funcionalidade.frontend.anotacoes.AnotacoesCpfFunc;
import funcionalidade.frontend.login.LoginGestaoOcorrenciasFunc;
import funcionalidade.frontend.menu.MenuGestaoOcorrenciasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.ATENDIMENTO)
public class QA20281 extends TesteBaseFrontEnd {

    LoginGestaoOcorrenciasFunc loginGestao = new LoginGestaoOcorrenciasFunc();
    MenuGestaoOcorrenciasFunc menuGestao = new MenuGestaoOcorrenciasFunc();
    AnotacaoCadastroFunc anotacaoCad = new AnotacaoCadastroFunc();
    AnotacoesCpfFunc anotacoesCpf = new AnotacoesCpfFunc();

    @Test(description = "[QA AUT] Validar no modal de inclusão de uma anotação que ao clicar em Retornar o sistema exibirá um modal e ao clicar em Sim deverá fechar o modal")
    @Description("Pré-condições:" +
            "1. Ter perfil de acesso ao Anotacoes\n" +
            "2. Possuir CPF valido para a criacao de uma anotacao;")
    @Severity(SeverityLevel.NORMAL)

    public void QA20281() throws Exception {
        loginGestao.loginGestaoOcorrencias(ReadProperties.getGestaoUser(), ReadProperties.getGestaoPass());
        menuGestao.acessarMenuAnotacoes();
        anotacoesCpf.inserirCPFBuscarAnotacao(recuperarMassa(JSON.CPF));
        anotacaoCad.incluirAnotacao(AnotacaoGestaoStrings.TITULO_ANOTACAO, AnotacaoGestaoStrings.DESCRICAO_TEXTAREA);
        anotacaoCad.validarModalRetornar(AlertaModalRetornar.ALERTA_MODAL_RETORNAR.toString());

    }
}
