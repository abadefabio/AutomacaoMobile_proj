package teste.mobile.regressivo.seguros;


import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

import constantes.seguros.Protecao;
import constantes.seguros.TipoProtecao;
import constantes.seguros.TipoSecaoProtecao;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.seguros.ProtecaoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.SEGUROS)
public class QA00197 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ProtecaoFunc protecao = new ProtecaoFunc();

    @Test(description = "REG.PRO.02.02 - Validar jornada completa de \"Prote��o/Seguro Cart�o de D�bito\" pela op��o \"prote��o/seguro cart�o de DEBITO/Detalhes/btn_CONTRATAR2\"")
    @Description("Este Teste contempla a contrata��o do Seguro Cart�o de Debito, visualiza��o do card contratado, e sua exclus�o pelo op��o \"prote��o/seguro cart�o de DEBITO/Detalhes/btn_CONTRATAR2\"")
    @Severity(SeverityLevel.NORMAL)
    public void QA00197() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarSeguros();
        protecao.tocarMenuNext();
        menu.selecionarSeguros();

        protecao.validarCardProtecaoFromBtnDetalhes(TipoProtecao.DEBITO, TipoSecaoProtecao.INFORMACOES_SEGURO_FROM_DETALHES, Protecao.SEGUNDO_BOTAO_CONTRATAR_FROM_DETALHES);

        protecao.validarCardTelaConfirmacaoDeDados(TipoProtecao.DEBITO, TipoSecaoProtecao.INFORMACOES_SEGURO_FROM_CONFIRMACAO_DADOS, Protecao.SEGUNDO_BOTAO_CONTRATAR_FROM_DETALHES, null);

        protecao.validarTelaConfirmacaoContratacao(TipoProtecao.DEBITO, TipoSecaoProtecao.CONTRATACAO);

        protecao.validarCardContratado(TipoProtecao.DEBITO, TipoSecaoProtecao.INFORMACOES_SEGURO_FROM_CARD_CONTRATADO);

        protecao.cancelarProtecao(TipoProtecao.DEBITO, TipoSecaoProtecao.CANCELAMENTO);

        protecao.navegarCardProtecao(TipoProtecao.DEBITO);

    }
}
