package funcionalidade.mobile.menu;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.investimentos.Decisao;
import io.qameta.allure.Step;
import pagina.mobile.comum.next.PopUpTela;
import pagina.mobile.jornadas.adesao.CompleteSeuCadastroTela;
import pagina.mobile.jornadas.adesao.termosecondicoes.TermosECondicoesTela;
import pagina.mobile.jornadas.investimentos.PrimeiroAcessoInvestimentosTela;
import pagina.mobile.jornadas.investimentos.home.HomeInvestimentosTela;
import pagina.mobile.jornadas.menu.ConfiguracoesApp.ConfiguracoesAppTela;
import pagina.mobile.jornadas.menu.MenuTela;
import pagina.mobile.jornadas.menu.ReorganizarMenu.ReorganizarMenuTela;
import pagina.mobile.jornadas.pagamentos.PagamentosTela;
import pagina.mobile.jornadas.recarga.RecargaCelularTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class MenuFunc extends FuncionalidadeBase {
    boolean android;

    /**
     * Selecionar a jornada de Transferencia
     *
     * @throws Exception
     */
    @Step("Selecionar a jornada de Transferencia")
    public void selecionarTransferencia() throws Exception {
        new MenuTela(getDriver())
                .tocarMenuTransferencia();
    }

    /**
     * Selecionar a jornada de Recarga
     *
     * @throws Exception
     */
    @Step("Selecionar a jornada de Recarga")
    public void selecionarRecarga() throws Exception {
        new MenuTela(getDriver())
                .tocarMenuRecarga();
        new RecargaCelularTela(getDriver())
                .validarExibicaoTelaRecarga();
    }

    /**
     * Selecionar 'Saldo e Extrato'
     *
     * @throws Exception
     */
    @Step("Selecionar 'Saldo e Extrato'")
    public void selecionarSaldoExtrato() throws Exception {
        new MenuTela(getDriver())
                .tocarMenuSaldoExtrato();
    }


    /**
     * Selecionar a jornada 'Depósitos e Saques'
     *
     * @throws Exception
     */
    @Step("Selecionar a jornada 'Depósitos e Saques'")
    public void selecionarDepositosSaques() throws Exception {
        new MenuTela(getDriver())
                .tocarMenuDepositosSaques();
    }

    /**
     * Selecionar a jornada 'Trazer meu Salário'
     *
     * @throws Exception
     */
    @Step("Selecionar a jornada 'Trazer meu Salário'")
    public void selecionarTrazerSalario() throws Exception {
        new MenuTela(getDriver())
                .tocarMenuTrazerSalario();
    }

    /**
     * Selecionar a jornada 'Vaquinha'
     *
     * @throws Exception
     */
    @Step("Selecionar a jornada 'Vaquinha'")
    public void selecionarVaquinha() throws Exception {
        new MenuTela(getDriver())
                .tocarMenuVaquinha();
    }

    /**
     * Selecionar o botão 'Sair'
     *
     * @throws Exception
     */
    @Step("Selecionar o botão 'Sair'")
    public void selecionarSair() throws Exception {
        new MenuTela(getDriver())
                .tocarMenuSair();
    }

    /**
     * Selecionar a jornada 'Notificacoes'
     *
     * @throws Exception
     */
    @Step("Selecionar a jornada 'Notificacoes'")
    public void selecionarNotificacoes() throws Exception {
        new MenuTela(getDriver())
                .tocarMenuNotificacoes();
    }

    /**
     * Selecionar o Botão "Sim" Popup
     *
     * @throws Exception
     */
    @Step("Selecionar o Botão \"Sim\" Popup")
    public void tocarBotaoSimPopup() throws Exception {
        new PopUpTela(getDriver())
                .tocarBotaoSim();
    }

    /**
     * Selecionar 'Parceiros'
     *
     * @throws Exception
     */
    @Step("Selecionar 'Parceiros'")
    public void selecionarParceiros() throws Exception {
        new MenuTela(getDriver())
                .tocarMenuParceiros();
    }

    /**
     * Método que seleciona o Menu 'Parcerias'
     *
     * @throws Exception
     */
    @Step("Selecionar 'Parcerias'")
    public void selecionarParcerias() throws Exception {
        new MenuTela(getDriver())
                .tocarMenuParcerias();
    }

    /**
     * Selecionar a Jornada 'Seguros'
     *
     * @throws Exception
     */
    @Step("Selecionar a Jornada de 'Seguros'")
    public void selecionarSeguros() throws Exception {
        new MenuTela(getDriver())
                .tocarMenuSeguros();
    }

    /**
     * Selecionar 'CONFIGURAÇÕES DO APP'
     *
     * @throws Exception
     */
    @Step("Selecionar 'CONFIGURAÇÕES DO APP'")
    public void selecionarConfiguracoesApp() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoConfiguracoesApp();
    }

    /**
     * Retornar ao menu da tela 'CONFIGURAÇÃO'
     *
     * @throws Exception
     */
    @Step("Retornar ao menu da tela 'CONFIGURAÇÃO'")
    public void retornarMenuConfiguracoesApp() throws Exception {
        new ConfiguracoesAppTela(getDriver())
                .validarCarregamentoTela()
                .tocarBotaoRetornarMenu();
    }

    /**
     * Selecionar 'Termos e Condições'
     *
     * @throws Exception
     */
    @Step("Selecionar 'Termos e Condições'")
    public void selecionarTermosECondicoes() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoTermosECondicoes();
    }

    /**
     * Retornar ao menu da tela 'Termos e Condições'
     *
     * @throws Exception
     */
    @Step("Retornar ao menu da tela 'Termos e Condições'")
    public void retornarMenuTermosECondicoes() throws Exception {
        new TermosECondicoesTela(getDriver())
                .validarCarregamentoTela()
                .tocarBotaoRetornarMenu();
    }

    /**
     * Selecionar 'REORGANIZAR MENU'
     *
     * @throws Exception
     */
    @Step("Selecionar 'REORGANIZAR MENU'")
    public void selecionarReorganizarMenu() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoReorganizarMenu();
    }

    /**
     * Tocar botão salvar da tela 'Reorganizar Menu'
     *
     * @throws Exception
     */
    @Step("Tocar botão salvar da tela 'Reorganizar Menu'")
    public void tocarBotaoSalvarReorganizarMenu() throws Exception {
        new ReorganizarMenuTela(getDriver())
                .validarCarregamentoTela()
                .tocarBotaoSalvar();
    }

    /**
     * Validar a não exibição da opção 'PARCEIROS' no menu
     *
     * @throws Exception
     */
    @Step("Validar a não exibição da opção 'PARCEIROS' no menu")
    public void validarMenuSemParceiros() throws Exception {
        new MenuTela(getDriver())
                .validarMenuSemParceiros();
    }

    /**
     * Tocar botão 'OK, Entendi'
     *
     * @throws Exception
     */
    @Step("Tocar botão 'OK, Entendi'")
    public void tocarBotaoOKEntendi() throws Exception {
        new ReorganizarMenuTela(getDriver())
                .tocarBotaoOKEntendi();
    }

    /**
     * Selecionar 'Mimos'
     *
     * @throws Exception
     */
    @Step("Selecionar 'Mimos'")
    public void selecionarMimos() throws Exception {
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu()
                .tocarBotaoMimos();
    }

    /**
     * Selecionar 'Investimentos'
     *
     * @throws Exception
     */
    @Step("Selecionar \"Investimentos\"")
    public void selecionarInvestimentos() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoVerMaisMenu()
                .clicarMenuInvestimentos();
    }

    /**
     * Selecionar 'Investimentos'
     *
     * @throws Exception
     */
    @Step("Selecionar 'Investimentos'")
    public void selecionarInvestimentos(Decisao decisao) throws Exception {
        new MenuTela(getDriver())
                .clicarMenuInvestimentos();
        switch (decisao) {
            case PRIMEIRO_ACESSO:
                new PrimeiroAcessoInvestimentosTela(getDriver())
                        .validarPresencaTelaInvestimentosPrimeiroAcesso()
                        .tocarBotaoOkEntendi();
                break;
            case JA_ACESSOU_COM_INVESTIMENTOS:
                new HomeInvestimentosTela(getDriver())
                        .validarPresencaTelaInvestimentos();
                break;
        }
    }

    /**

     * Validar exibição da tela "MENU"
     *
     * @throws Exception
     */
    @Step("Validar exibição da tela \"MENU\"")
    public void validarTelaMenu() throws Exception {
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu();
    }

    /**
     * Selecionar 'Objetivos'
     *
     * @throws Exception
     */
    @Step("Selecionar 'Objetivos'")
    public void selecionarObjetivos() throws Exception {
        new MenuTela(getDriver())
                .tocarMenuObjetivos();
    }

    /**
     * Selecionar 'Comprovantes'
     *
     * @throws Exception
     */
    @Step("Selecionar 'Comprovantes'")
    public void selecionarComprovantes() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoComprovantes();
    }

    /**
     * Selecionar 'Pagamentos'
     *
     * @throws Exception
     */
    @Step("Selecionar 'Pagamentos'")
    public void selecionarPagamentos() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoPagamentos();
        new PagamentosTela(getDriver())
                .validarPresencaTelaPagamentos();
    }

    /**
     * Fecha tela de clicar Sugestão de crédito parcelado
     */
    public void fecharTelaCreditoParceladoInicio() {
        new MenuTela(getDriver())
                .fecharTelaCreditoParceladoInicio();
    }

    /**
     * Selecionar 'Flow'
     *
     * @throws Exception
     */
    @Step("Selecionar 'Flow'")
    public void selecionarFlow() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoFlow();
    }

    /**
     * Selecionar 'Ajuda'
     *
     * @throws Exception
     */
    @Step("Selecionar 'Ajuda'")
    public void selecionarAjuda() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoAjuda();
    }

    /**
     * Selecionar 'Empréstimos'
     *
     * @throws Exception
     */
    @Step("Selecionar 'Empréstimos'")
    public void selecionarEmprestimos() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoEmprestimos();
    }

    /**
     * Selecionar 'Cartão'
     *
     * @throws Exception
     */
    @Step("Selecionar 'Cartão'")
    public void selecionarCartao() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoCartao();

    }

    /**
     * Selecionar 'Doações'
     *
     * @throws Exception
     */
    @Step("Selecionar 'Doações'")
    public void selecionarDoacoes() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoDoacoes();

    }

    /**
     * Selecionar o Banner (Card) 'Complete seu cadastro'
     */
    @Step("Selecionar o Banner (Card) 'Complete seu cadastro'")
    public void selecionarBannerCompleteSeuCadastro() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoCompleteSeuCadastro();
        new CompleteSeuCadastroTela(getDriver())
                .validaTelaCompleSeuCadastro();
    }

    /**
     * Tocar exibir saldo'
     * fr
     * @throws Exception
     */
    @Step("Tocar exibir o saldo da conta'")
    public void tocarExibirSaldoConta(ThreadLocal valorDisponivel) throws Exception {
        new MenuTela(getDriver())
                .tocarExibirSaldo()
                .retornarValorSaldoDisponivel(valorDisponivel);
    }

    /**
     * validar saldo final apos investimento concluido
     * fr
     * @throws Exception
     */
    @Step("validar saldo final apos investimento concluido")
    public void validaSaldoFinal(String valorDisponivel) throws Exception {
        new MenuTela(getDriver())
                .tocarExibirSaldo()
                .validarSaldoFinal(valorDisponivel);
    }


    /**
     * Selecionar a jornada 'PIX'
     *
     * @throws Exception
     */
    @Step("Selecionar a jornada 'PIX'")
    public void selecionarPix() throws Exception {
        new MenuTela(getDriver())
                .tocarMenuPix();
    }

    /**
     * Selecionar a jornada 'nextJoy'
     *
     * @throws Exception
     */
    @Step("Selecionar a jornada 'nextJoy'")
    public void selecionarNextJoy () throws Exception {
        new MenuTela(getDriver())
                .tocarMenuNextJoy();
    }

    /**
     * Selecionar a jornada 'next shop'
     *
     * @throws Exception
     */
    @Step("Selecionar a jornada 'next shop'")
    public void selecionarNextShop() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoNextShop();
    }

    /**
     * Selecionar a jornada 'Open Finance'
     * fr
     * @throws Exception
     */
    @Step("Selecionar a jornada 'Open Finance'")
    public void selecionarOpenFinance() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoOpenFinance();
    }

    /**
     * Selecionar 'Poupança'
     *
     * @throws Exception
     */
    @Step("Selecionar \"Poupança\"")
    public void selecionarPoupanca() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoVerMaisMenu()
                .clicarMenuPoupanca();
    }

    /**
     * Selecionar Perfil
     *
     * @throws Exception
     */
    @Step("Selecionar Perfil")
    public void selecionarPerfil() throws Exception {
        new MenuTela(getDriver())
                .tocarBotaoVerPerfil();
    }
}

