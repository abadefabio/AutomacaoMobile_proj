package funcionalidade.mobile.credito;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pagina.mobile.jornadas.credito.CreditoTela;
import pagina.mobile.jornadas.credito.emprestimo.contratacao.EmprestimoDataPrimeiraParcelaTela;
import pagina.mobile.jornadas.credito.emprestimo.contratacao.EmprestimoNomeTela;
import pagina.mobile.jornadas.credito.emprestimo.contratacao.EmprestimoPessoalTela;
import pagina.mobile.jornadas.credito.emprestimo.contratacao.EmprestimoQuantidadeParcelasTela;
import pagina.mobile.jornadas.credito.emprestimo.contratacao.EmprestimoValorTela;
import pagina.mobile.jornadas.credito.emprestimo.contratacao.SimularCreditoTela;
import pagina.mobile.jornadas.credito.limite.flex.ConfigurarContaTela;
import pagina.mobile.jornadas.credito.limite.flex.ConfigurarLimiteTela;
import pagina.mobile.jornadas.credito.limite.ConfirmacaoAntecipacaoPagamentoTela;
import pagina.mobile.comum.so.ModalCompartilhamentoTela;
import pagina.mobile.jornadas.credito.limite.flex.ProdutosCreditoTela;
import pagina.mobile.jornadas.credito.limite.flex.TermosCondicoesTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class CreditoFunc extends FuncionalidadeBase {

    /**
     * Contratar Emprestimo pessoal com temosinha
     *
     * @param nome
     * @param valor
     * @throws Exception
     */
    public void contratarEmprestimoPessoalTemosinha(String nome, String valor, String texto) throws Exception {

        new CreditoTela(getDriver())
                .tocarBotaoSimularEmprestimoPessoal();

        new EmprestimoNomeTela(getDriver())
                .preencherCampoNome(nome);

        if (!new EmprestimoValorTela(getDriver()).verificarCampoValorPresente()) {
            new EmprestimoNomeTela(getDriver())
                    .tocarbotaoContinuar();
        }

        new EmprestimoValorTela(getDriver())
                .preencherCampoValor(valor);
        if (!new EmprestimoDataPrimeiraParcelaTela(getDriver()).verificarLinkEscolherPresente()) {
            new EmprestimoValorTela(getDriver())
                    .tocarbotaoContinuar();
        }

        new EmprestimoDataPrimeiraParcelaTela(getDriver())
                .tocarLinkEscolher()
                .selecionarDataPrimeiraParcela()
                .tocarBotaoConfirmar()
                .tocarbotaoContinuar();

        new EmprestimoQuantidadeParcelasTela(getDriver())
                .tocarbotaoContinuar();

        new EmprestimoPessoalTela(getDriver())
                .tocarCheckUsarGranaDeEmergenciaParaPagamentoDeParcelas()
                .tocarbotaoContinuar()
                .selecionarCheckoxLiTermos()
                .tocarbotaoContinuarTermos()
                .tocarbotaoVerComprovante()
                .validarTextoDebitoAutomaticoAutorizado(texto)
                .tocarBotaoCompartilhar();
    }


    /**
     * Acessar a funcinalidade 'Pedir mais Limite'
     *
     * @throws NextException
     */
    public void pedirMaisLimite() throws Exception {
        new CreditoTela(getDriver())
                .validarExibicaoTelaCredito()
                .tocarBotaoVerDetalhes()
                .tocarBotaoPedirMaisLimite();
    }

    /**
     * @param texto
     * @throws Exception
     */
    public void validarAntecipacaoCredito(String valorCredito, String texto, String textoTitulo) throws Exception {
        new CreditoTela(getDriver())
                .tocarAbaMeusContratos()
                .tocarBotaoPagar(valorCredito);
        new ConfirmacaoAntecipacaoPagamentoTela(getDriver())
                .verificarTextoListaParcelas(textoTitulo)
                .tocarProximaParcela()
                .verificarTextoDescricao(texto);

    }


    /**
     * Validar Comprovante Teimosinha e Grana de Emergência
     *
     * @param valor
     * @param valorMensal
     * @throws Exception
     */
    public void creditoComTeimosinha(String valor, String valorMensal, String texto) throws Exception {

        new CreditoTela(getDriver())
                .tocarBotaoSimularCreditoParcelado();

        new SimularCreditoTela(getDriver())
                .tocarBotaoEditarValor()
                .preencherCampoValor(valor)
                .arrastarSlideQtdeVezes()
                .tocarBotaoCalcular()
                .validarValorMensalSimulacao(valorMensal)
                .tocarBotaoContinuar();

        new EmprestimoPessoalTela(getDriver())
                .tocarbotaoContinuar()
                .selecionarCheckoxLiTermos()
                .tocarbotaoContinuarTermos()
                .tocarbotaoVerComprovante()
                .validarTextoDebitoAutomaticoAutorizado(texto)
                .validarTextoUsarGranaEmergenciaAutorizado(texto)
                .tocarBotaoCompartilhar();
        new ModalCompartilhamentoTela(getDriver())
                .validarModalCompartilhamento();
    }

    /**
     * Validar desabilitacao da Opcao de Credito Pessoal
     *
     * @throws Exception
     */
    public void desabilitarCreditoPessoal() throws Exception {
        new CreditoTela(getDriver())
                .validarExibicaoTelaCredito()
                .tocarAbaMeusContratos()
                .tocarBotaoLimites()
                .validarEmprestimoHabilitadoNoLimiteFlex()
                .tocarBotaoConfigurarUsoLimite();

        new ConfigurarLimiteTela(getDriver())
                .tocarCheckboxEmprestimo()
                .tocarBotaoConfirmar();

        if (getDriver() instanceof AndroidDriver) {
            new ConfigurarContaTela(getDriver()).
                    tocarCheckConfirmacao().
                    tocarBotaoConfirmar();

            new ProdutosCreditoTela(getDriver())
                    .tocarBotaoContinuar();
        }

        new TermosCondicoesTela(getDriver())
                .validarExibicaoTermosProduto()
                .tocarCheboxConfirmoSolicitacao()
                .tocarBotaoContinuar();

        new ConfigurarContaTela(getDriver())
                .validarMensagemSucesso()
                .tocarBotaoOk();

        new CreditoTela(getDriver())
                .validarExibicaoTelaCredito()
                .tocarAbaMeusContratos()
                .tocarBotaoLimites()
                .validarEmprestimoDesabilitadoNoLimiteFlex();
    }

    /**
     * Validar habilitacao da Opcao de Grana de Emergencia
     *
     * @throws Exception
     */
    public void habilitarGranaEmergencia() throws Exception {
        new CreditoTela(getDriver())
                .validarExibicaoTelaCredito()
                .tocarAbaMeusContratos()
                .tocarBotaoLimites()
                .validarGranaDeEmergenciaDesabilitadoNoLimiteFlex()
                .tocarBotaoConfigurarUsoLimite();

        new ConfigurarLimiteTela(getDriver())
                .tocarCheckboxGranaEmergencia()
                .tocarBotaoConfirmar();

        new TermosCondicoesTela(getDriver())
                .validarExibicaoTermosProduto()
                .tocarCheboxConfirmoSolicitacao()
                .tocarBotaoContinuar();

        if (getDriver() instanceof AndroidDriver) {
            new ProdutosCreditoTela(getDriver()).tocarBotaoAgoraNao();
        } else {
            new ConfigurarContaTela(getDriver())
                    .validarMensagemSucesso()
                    .tocarBotaoOk();
        }

        new CreditoTela(getDriver())
                .validarExibicaoTelaCredito()
                .tocarAbaMeusContratos()
                .tocarBotaoLimites()
                .validarGranaDeEmergenciaHabilitadoNoLimiteFlex();

    }


    /**
     * Validar desabilitacao da Opcao de Grana de emergência
     *
     * @throws Exception
     */
    public void desabilitarGranaEmergencia() throws Exception {
        new CreditoTela(getDriver())
                .validarExibicaoTelaCredito()
                .tocarAbaMeusContratos()
                .tocarBotaoLimites()
                .validarGranaDeEmergenciaHabilitadoNoLimiteFlex()
                .tocarBotaoConfigurarUsoLimite();

        new ConfigurarLimiteTela(getDriver())
                .tocarCheckboxGranaEmergencia()
                .tocarBotaoConfirmar();

        if (getDriver() instanceof AndroidDriver) {
            new ConfigurarContaTela(getDriver())
                    .tocarCheckConfirmacao()
                    .tocarBotaoConfirmar();

            new ProdutosCreditoTela(getDriver())
                    .tocarBotaoContinuar();
        }

        new TermosCondicoesTela(getDriver())
                .validarExibicaoTermosProduto()
                .tocarCheboxConfirmoSolicitacao()
                .tocarBotaoContinuar();

        new ConfigurarContaTela(getDriver())
                .validarMensagemSucesso()
                .tocarBotaoOk();

        new CreditoTela(getDriver())
                .validarExibicaoTelaCredito()
                .tocarAbaMeusContratos()
                .tocarBotaoLimites()
                .validarGranaDeEmergenciaDesabilitadoNoLimiteFlex();
    }

    /**
     * Validar habilitacao da Opcao de Credito Pessoal
     *
     * @throws Exception
     */
    public void habilitarCreditoPessoal() throws Exception {
        new CreditoTela(getDriver())
                .validarExibicaoTelaCredito()
                .tocarAbaMeusContratos()
                .tocarBotaoLimites()
                .tocarBotaoConfigurarUsoLimite();

        new ConfigurarLimiteTela(getDriver())
                .tocarCheckboxEmprestimo()
                .tocarBotaoConfirmar();

        new TermosCondicoesTela(getDriver())
                .validarExibicaoTermosAtivacaoProduto()
                .tocarCheboxConfirmoSolicitacao()
                .tocarBotaoContinuar();

        new ConfigurarContaTela(getDriver())
                .validarMensagemSucesso()
                .tocarBotaoOk();

        new CreditoTela(getDriver())
                .validarExibicaoTelaCredito()
                .tocarBotaoMenu();
    }

}
