package teste.web.regressivo.mimos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.web.sistemadegestao.login.SistemaDeGestaoLoginFunc;
import funcionalidade.web.sistemadegestao.menu.SistemaDeGestaoMenuFunc;
import funcionalidade.web.sistemadegestao.mimos.hub.SistemaDeGestaoMenuHubFunc;
import funcionalidade.web.sistemadegestao.mimos.hub.SistemaDeGestaoOfertasFunc;
import funcionalidade.web.sistemadegestao.mimos.menu.SistemaDeGestaoMenuMimosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.MIMOS)
public class QA00238 extends TesteBase{

    SistemaDeGestaoLoginFunc loginSistemaDeGestao = new SistemaDeGestaoLoginFunc();
    SistemaDeGestaoMenuFunc menuSistemaDeGestao = new SistemaDeGestaoMenuFunc();
    SistemaDeGestaoMenuMimosFunc menuMimosSistemaDeGestao = new SistemaDeGestaoMenuMimosFunc();
    SistemaDeGestaoMenuHubFunc menuHubSistemaDeGestao = new SistemaDeGestaoMenuHubFunc();
    SistemaDeGestaoOfertasFunc ofertasHubSistemaDeGestao = new SistemaDeGestaoOfertasFunc();

    @Test(description = "REG.MIMO.01.08 - Validação de cadastramento de uma oferta HUB com base de voucher - Loja Física")
    @Description("Validar cadastramento de uma oferta HUB com base de voucher - Loja Física.")
    @Severity(SeverityLevel.NORMAL)

    public void QA00238() throws Exception{

        loginSistemaDeGestao.preencherCampoLogin(recuperarMassa("loginGestao"));

        loginSistemaDeGestao.preencherCampoSenha(recuperarMassa("senhaGestao"));

        loginSistemaDeGestao.clicarBotaoLogin();

        menuSistemaDeGestao.clicarLinkMIMOS();

        menuMimosSistemaDeGestao.clicarLinkHub();

        menuHubSistemaDeGestao.clicarLinkOfertas();

        ofertasHubSistemaDeGestao.clicarBotaoMaisCadastrar();

        ofertasHubSistemaDeGestao.preencherCampoNomeOferta(recuperarMassa("ofertaNome"));

        ofertasHubSistemaDeGestao.selecionarCategoriaCombobox(recuperarMassa("categoria"));

        ofertasHubSistemaDeGestao.selecionarParceiroCombobox(recuperarMassa("parceiro"));

        ofertasHubSistemaDeGestao.preencherCampoTexto(recuperarMassa("texto"));

        ofertasHubSistemaDeGestao.fazerUploadArquivoImagem(recuperarMassa("pathArquivoImagem"));

        ofertasHubSistemaDeGestao.preencherCampoBeneficio(recuperarMassa("beneficio"));

        ofertasHubSistemaDeGestao.preencherCampoDataEHoraInicComDataAtualMaisDoisMin();

        ofertasHubSistemaDeGestao.preencherCampoValidoAteComDataAtualMaisDoisDias();

        ofertasHubSistemaDeGestao.selecionarFormaPagamentoComboBox(recuperarMassa("formaDePagamento"));

        ofertasHubSistemaDeGestao.preencherCampoComoUsar(recuperarMassa("comoUsar"));

        ofertasHubSistemaDeGestao.selecionarRadioButtonBaseDeVoucher();

        ofertasHubSistemaDeGestao.fazerUploadArquivoImagemVoucher(recuperarMassa("pathArquivoImagem"));

        ofertasHubSistemaDeGestao.selecionarVoucherPorCPFCombobox(recuperarMassa(JSON.VALOR));

        ofertasHubSistemaDeGestao.preencherNomeBotao(recuperarMassa("nomeBotao"));

        ofertasHubSistemaDeGestao.clicarBotaoCadastrar();

        ofertasHubSistemaDeGestao.clicarBotaoSim();

        ofertasHubSistemaDeGestao.clicarBotaoSim();

        ofertasHubSistemaDeGestao.preencherCampoValidadeVoucher();

        ofertasHubSistemaDeGestao.carregarArquivoVoucher(recuperarMassa("pathArquivoVoucher"));

        ofertasHubSistemaDeGestao.clicarBotaoCadastrar();

        ofertasHubSistemaDeGestao.clicarBotaoSim();

        ofertasHubSistemaDeGestao.clicarBotaoOK();

        ofertasHubSistemaDeGestao.clicarBotaoSairAposFimProcessamento();

        ofertasHubSistemaDeGestao.validarOfertaHubCadastradaEmInativo();
    }

}
