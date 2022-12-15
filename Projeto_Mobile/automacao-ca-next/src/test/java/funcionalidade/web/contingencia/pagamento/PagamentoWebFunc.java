package funcionalidade.web.contingencia.pagamento;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.alertas.AlertaCodigoBarrasInvalido;
import funcionalidade.web.contingencia.login.LoginContingenciaFunc;
import pagina.mobile.contingencia.MobileContingenciaTela;
import pagina.web.contingencia.pagamento.PagamentoTela;
import pagina.web.contingencia.saldo.SaldoContaCorrenteTela;
import pagina.web.contingencia.views.alertas.AlertasPagamentoTela;
import pagina.web.contingencia.views.base.ContingenciaBaseTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class PagamentoWebFunc extends FuncionalidadeBase {

    /**
     * Validar titulo de pagamento ap�s clicar no menu lateral de pagamento.
     * @throws Exception
     */
    public void validarTituloPagamentoWeb() throws Exception {
        new ContingenciaBaseTela(getWebDriver())
                .clicarMenuPagamento();
        new PagamentoTela(getWebDriver())
                .validarTituloPagamento();
    }

    /**
     * M�todo para clicar no menu lateral de Pagamento e acessar a tela de Pagamento.
     * @throws Exception
     */
    public void acessarMenuPagamento() throws Exception {
        new ContingenciaBaseTela(getWebDriver())
                .clicarMenuPagamento();
    }

    /**
     * M�todo para digitar c�digos de barras inv�lido nos blocos 1, 2, 3 e 4 e validar as mensagens de alerta.
     * @throws Exception
     */
    public void digitarCodigoBarrasInvalido(String codigoBarras) throws Exception {
        fluxoCodigoBarrasInvalido(codigoBarras, 5, AlertaCodigoBarrasInvalido.ALERTA_BLOCO_1_INVALIDO);
        fluxoCodigoBarrasInvalido(codigoBarras, 15, AlertaCodigoBarrasInvalido.ALERTA_BLOCO_2_INVALIDO);
        fluxoCodigoBarrasInvalido(codigoBarras, 30, AlertaCodigoBarrasInvalido.ALERTA_BLOCO_3_INVALIDO);
        fluxoCodigoBarrasInvalido(codigoBarras, 38, AlertaCodigoBarrasInvalido.ALERTA_BLOCO_4_INVALIDO);
    }

    /**
     * Metodo para inserir um c�digo de barras v�lido
     * @throws Exception
     */
    public void digitarCodigoBarrasValido(String codigoBarras) throws Exception {
        new PagamentoTela(getWebDriver())
                .digitarCodigoBarras(codigoBarras);
    }

    /**
     * M�todo para validar se a p�gina retorna � anterior ap�s clicar nos bot�es de voltar.
     * @throws Exception
     */
    public void validarTelasClicarBotaoVoltar() throws Exception {
            new PagamentoTela(getWebDriver())
                .validarBeneficiarioPagamento()
                .clicarBotaoVoltarDadosPagamento()
                .validarTituloPagamento()
                .clicarBotaoVoltarDadosPagamento();
            new SaldoContaCorrenteTela(getWebDriver())
                    .validarTituloSaldo();
    }

    /**
     * M�todo de a��o para o fluxo de digitar um c�digo de barras, validar o alerta de um c�digo inv�lido, clicar no bot�o voltar do alerta e limpar o campo do c�digo de barras.
     * @param codigoBarras
     * @param index
     * @param alertaCodigoBarrasInvalido
     * @throws Exception
     */
    public void fluxoCodigoBarrasInvalido (String codigoBarras, int index, AlertaCodigoBarrasInvalido alertaCodigoBarrasInvalido) throws  Exception{
        /*
        Este m�todo faz parte do m�todo digitarCodigoBarrasInvalido.
         */
        PagamentoTela pagamentoTela = new PagamentoTela(getWebDriver());
        AlertasPagamentoTela alertasPagamento = new AlertasPagamentoTela(getWebDriver());
        pagamentoTela
                .digitarCodigoBarrasInvalido(codigoBarras, index);
        alertasPagamento
                .validarCodigoInvalido(alertaCodigoBarrasInvalido)
                .clicarBotaoVoltarAlerta();
        pagamentoTela
                .limparCodigoBarras();
    }

    /**
     * Realizar o fluxo de um pagamento de Boleto de Consumo
     * @param senha
     * @throws Exception
     */
    public void pagarBoletoConsumo(String senha) throws Exception {
        MobileContingenciaTela mobileContingenciaTela = new MobileContingenciaTela(getDriver());
        PagamentoTela pagamentoTela = new PagamentoTela(getWebDriver());
        pagamentoTela
                .informarDescricaoDadosPagamento()
                .selecionarContaCorrente()
                .clicarBotaoAvancarPagamento()
                .validarQrCodePresente();
                String TID = pagamentoTela
                .lerTID();

        mobileContingenciaTela
                .apagarTextoCampoSessionKey()
                .informarTID(TID)
                .tocarBotaoAvancar()
                .tocarBotaoConfirmar()
                .informarSenhaLogin(senha)
                .tocarBotaoContinuar()
                .tocarBotaoOk();
    }

    /**
     * Realizar o fluxo de um pagamento de Boleto de Cobran�a
     * @param senha
     * @throws Exception
     */
    public void pagarBoletoCobran�a(String senha) throws Exception {
        MobileContingenciaTela mobileContingenciaTela = new MobileContingenciaTela(getDriver());
        PagamentoTela pagamentoTela = new PagamentoTela(getWebDriver());
        pagamentoTela
                .selecionarConfirmarBanco()
                .selecionarContaCorrente()
                .informarDescricaoDadosPagamento()
                .clicarBotaoAvancarPagamento();
        String TID = pagamentoTela
                .lerTID();
        new LoginContingenciaFunc().acionarTelaLeituraQrCodeMobileDesdeTelaLogin();
        mobileContingenciaTela
                .informarTID(TID)
                .tocarBotaoAvancar()
                .tocarBotaoContinuar()
                .informarSenhaLogin(senha)
                .tocarBotaoContinuar();
    }
}
