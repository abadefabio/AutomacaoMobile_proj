package teste.web.regressivo.frontend.anotacao;

import base.contantes.Extensao;
import base.contantes.TamanhoUpload;
import base.teste.TesteBaseFrontEnd;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.tools.ReadProperties;
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
public class QA20283 extends TesteBaseFrontEnd {

    LoginGestaoOcorrenciasFunc loginGestao = new LoginGestaoOcorrenciasFunc();
    MenuGestaoOcorrenciasFunc menuGestao = new MenuGestaoOcorrenciasFunc();
    AnotacoesCpfFunc anotacoesCpf = new AnotacoesCpfFunc();
    AnotacaoCadastroFunc anotacaoCad = new AnotacaoCadastroFunc();

    @Test(description = "[QA AUT] Validar a inclus�o de uma anota��o com flag de importante e anexo")
    @Description("Pr�-condi��es:" +
            "1. Ter acesso ao Gest�o de Ocorr�ncias\n" +
            "2. Ter perfil de acesso ao Anotac�es\n" +
            "3. Possuir um CPF v�lido para a cria��o de uma anota��o;")
    @Severity(SeverityLevel.NORMAL)
    public void QA20283() throws Exception {
        loginGestao.loginGestaoOcorrencias(ReadProperties.getGestaoUser(), ReadProperties.getGestaoPass());
        menuGestao.acessarMenuAnotacoes();
        anotacoesCpf.inserirCPFBuscarAnotacao(recuperarMassa(JSON.CPF));
        anotacaoCad.incluirAnotacao(AnotacaoGestaoStrings.TITULO_ANOTACAO, AnotacaoGestaoStrings.DESCRICAO_TEXTAREA);
        anotacaoCad.insereAnexoAnotacao(Extensao.PDF, TamanhoUpload.Mb1);
        anotacaoCad.clicarCheckboxImportante();
        anotacaoCad.salvarAnotacao(AnotacaoGestaoStrings.MSG_SALVAR_ANOTACAO);
        anotacaoCad.validarCriacaoAnotacao(AnotacaoGestaoStrings.TITULO_ANOTACAO, AnotacaoGestaoStrings.DESCRICAO_TEXTAREA, recuperarMassa(JSON.NOME), ReadProperties.getGestaoUser());
        anotacaoCad.validarAnotacaoImportanteTimeline(AnotacaoGestaoStrings.TXT_ANOTACAO_IMPORTANTE);
    }
}
