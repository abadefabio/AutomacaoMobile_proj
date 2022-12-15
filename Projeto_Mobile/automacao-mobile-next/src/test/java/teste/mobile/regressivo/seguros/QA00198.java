package teste.mobile.regressivo.seguros;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

import constantes.seguros.Protecao;
import constantes.seguros.TipoSecaoProtecao;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.seguros.ProtecaoDebitoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.SEGUROS)
public class QA00198 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ProtecaoDebitoFunc protecaoDebito = new ProtecaoDebitoFunc();

    @Test(description = "REG.PRO.02.03 - Validar jornada completa de \"Proteção/Seguro Cartão de Débito\" pela opção \"proteção/seguro cartao DEBITO/btn_contratar\"")
    @Description("Este Teste contempla a contratação do Seguro Cartão de Debito, visualização do card contratado, e sua exclusão pela opção \"proteção/seguro cartao DEBITO/btn_contratar\"")
    @Severity(SeverityLevel.NORMAL)
    public void QA00198() throws Exception {

        login.efetuarLoginUsuarioExistente( recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarSeguros();

        protecaoDebito.validarCardProtecaoFromBtnContratar();

        protecaoDebito.validarCardTelaConfirmacaoDeDados(TipoSecaoProtecao.INFORMACOES_SEGURO_FROM_CONFIRMACAO_DADOS, Protecao.BOTAO_CONTRATAR_FROM_CARD,null);

        protecaoDebito.validarTelaConfirmacaoContratacao(TipoSecaoProtecao.CONTRATACAO);

        protecaoDebito.validarCardContratado(TipoSecaoProtecao.INFORMACOES_SEGURO_FROM_CARD_CONTRATADO, Protecao.BOTAO_CONTRATAR_FROM_CARD);

        protecaoDebito.cancelarProtecao(TipoSecaoProtecao.CANCELAMENTO);

        protecaoDebito.navegarCardProtecao();

    }
}
