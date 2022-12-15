package funcionalidade.mobile.mimos;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.exception.NextException;

import constantes.mimos.NumeroEstrelas;
import io.appium.java_client.android.AndroidDriver;
import pagina.mobile.jornadas.login.LoginTela;
import pagina.mobile.jornadas.menu.MenuTela;
import pagina.mobile.jornadas.mimos.CupomDescontoMimosTela;
import pagina.mobile.jornadas.mimos.MimosTela;
import pagina.mobile.jornadas.mimos.RegrasUsoMimosTela;

public class MimosFunc extends FuncionalidadeBase {

    /**
     * Deslizar tela Mimos com card aleat�rio carregado para cima
     *
     * @throws Exception
     */
    public void deslizarCardParaCima() throws Exception {
        new MimosTela(getDriver())
                .deslizarCardParaCima();
    }

    /**
     * Selecionar oferta desejada usando o campo de busca da tela
     *
     * @param oferta
     * @throws Exception
     */
    public void selecionarOfertaPorBusca(String oferta, String textoOferta, boolean verMeusCupons ) throws Exception {
        new MimosTela(getDriver())
                .validarPresencaTelaMimos()
                .preenherCampoBusca(oferta)
                .selecionarOfertaConsultada(textoOferta);
        if (verMeusCupons){
            new MimosTela(getDriver())
                    .tocarBotaoVerMeusCupons();
        }
    }

    /**
     * Validar Usu�rio n�o possui cupons gerados atrav�s de mensagem exibida na tela
     */
    public void validarMensagemNaoPossuiCuponsGerados() throws Exception {
        new MimosTela(getDriver())
                .validarMensagemNaoPossuiCuponsGerados();
    }

    /**
     * Tocar Bot�o "Pr�ximo"
     *
     * @throws Exception
     */
    public void tocarBotaoProximo() throws Exception {
        new MimosTela(getDriver())
                .tocarBotaoProximo();
    }

    /**
     * Validar Mensagem na Primeira Tela Tutorial Mimos
     */
    public void validarMensagemPrimeiraTelaTutorialMimos() throws Exception {
        new MimosTela(getDriver())
                .validarPresencaTelaMimos()
                .validarMensagemPrimeiraTelaTutorialMimos();
    }

    /**
     * Validar Mensagem na Segunda Tela Tutorial Mimos
     */
    public void validarMensagemSegundaTelaTutorialMimos() throws Exception {
        new MimosTela(getDriver())
                .validarMensagemSegundaTelaTutorialMimos();
    }

    /**
     * Validar Mensagem na Terceira Tela Tutorial Mimos
     */
    public void validarMensagemTerceiraTelaTutorialMimos() throws Exception {
        new MimosTela(getDriver())
                .validarMensagemTerceiraTelaTutorialMimos();
    }

    /**
     * Tocar Bot�o "Categorias"
     *
     * @throws Exception
     */
    public void tocarBotaoCategorias() throws Exception {
        new MimosTela(getDriver())
                .tocarBotaoCategorias();
    }

    /**
     * Deslizar Carrossel at� encontrar Categoria
     *
     * @param categoria
     */
    public void deslizarCarrosselAteAcharCategoria(Enum categoria) throws Exception {
        new MimosTela(getDriver())
                .deslizarCarrosselAteAcharCategoria(categoria.toString());
    }


    /**
     * Deslizar Carrossel at� encontrar Categoria
     *
     * @param categoria
     */
    public void deslizarCarrosselAteAcharCategoria(String categoria) throws Exception {
        new MimosTela(getDriver())
                .deslizarCarrosselAteAcharCategoria(categoria);
    }

    /**
     * Selecionar oferta desejada no carrossel
     *
     * @param oferta
     * @throws Exception
     */
    public void selecionarOfertaCategoria(String oferta) throws Exception {
        new MimosTela(getDriver())
                .selecionarCardOferta(oferta);
    }

    /**
     * Tocar �cone "Como Usar"
     *
     * @throws Exception
     */
    public void tocarIconeComoUsar() throws Exception {
        new MimosTela(getDriver())
                .tocarIconeComoUsar();
    }

    /**
     * Tocar C�digo Promocional
     *
     * @throws Exception
     */
    public void tocarBotaoCodigoPromocional() throws Exception {
        new MimosTela(getDriver())
                .tocarBotaoCodigoPromocional()
                .tocarBotaoIrParaParceiros()
                .validarRedirecionamentoAppWeb();
    }

    public void recarregarAplicativoAcessaMimos(String cpf, String senha) throws Exception {
        getDriver().launchApp();
        if (getDriver() instanceof AndroidDriver) {
            new LoginTela(getDriver())
                    .informarSenha(senha)
                    .tocarEntrar();
            new MenuTela(getDriver())
                    .tocarBotaoMimosSemEvidencia();
        }
    }

    /**
     * Validar que a tela n�o exibe bot�o "..."
     */
    public void validarNaoExibicaoBotaoMaisOpcoes() throws Exception {
        new MimosTela(getDriver())
                .validarNaoExibicaoBotaoMaisOpcoes();
    }

    /**
     * Tocar Bot�o Voltar
     *
     * @throws Exception
     */
    public void voltarMenuPrincipalMimosApartirTelaCupons() throws Exception {
        new MimosTela(getDriver())
                .tocarBotaoVoltar()
                .tocarBotaoVoltar();
        new MimosTela(getDriver())
                .tocarBotaoVoltar();
    }

    /**
     * Retorna Tela Carrossel
     *
     * @throws Exception
     */
    public void retornarCarrossel() throws Exception {
        new MimosTela(getDriver())
                .tocarBotaoVoltar()
                .apagarCampoBusca();
    }

    /**
     * Retorna Menu
     *
     * @throws Exception
     */
    public void retornarMenu() throws Exception {
        new MimosTela(getDriver())
                .tocarBotaoVoltar();
    }

    /**
     * Retorna Tela Categoria/Mimo
     * Tocar Bot�o Voltar
     *
     * @throws Exception
     */
    public void retornarTelaCategoriaOuMimo() throws Exception {
        new MimosTela(getDriver())
                .tocarBotaoVoltar();
    }

    /**
     * Tocar Bot�o "Voltar"
     *
     * @throws Exception
     */
    public void tocarVoltar() throws Exception {
        new MimosTela(getDriver())
                .tocarVoltar();
    }

    /**
     * Tocar Bot�o "Conhecer"
     *
     * @throws Exception
     */
    public void tocarCategorias() throws Exception {
        new MimosTela(getDriver())
                .tocarCategorias();
    }

    /**
     * Tocar Bot�o "Conhecer"
     *
     * @throws Exception
     */
    public void moverCarrossel() throws Exception {
        new MimosTela(getDriver())
                .moverCarrossel();
    }

    /**
     * Tocar Bot�o "acessar  oferta"
     *
     * @throws Exception
     */
    public void acessarOferta() throws Exception {
        new MimosTela(getDriver())
                .acessarOferta();
    }

    /**
     * Tocar Bot�o de oferta com descri��o espec�fica
     * @param descricao
     * @param promocao
     * @throws Exception
     */
    public void acessarOferta(String promocao, String descricao) throws Exception {
        new MimosTela(getDriver())
                .acessarOferta(promocao, descricao)
                .validarLabelParceria()
                .validarPresencaBotaoUse();
    }

    /**
     * Validar exibi��o do carrossel
     *

     * @throws Exception
     */
    public void validarExibicaoCarrossel() throws Exception {
        new MimosTela(getDriver())
                .validarExibicaoCarrossel();
    }

    /**
     * Tocar Bot�o "acessar  oferta"
     *
     * @throws Exception
     */
    public void preenherCampoBusca(String oferta) throws Exception {
        new MimosTela(getDriver())
                .preenherCampoBusca(oferta);
    }

    /**
     * Tocar Bot�o "LimparTexto"
     *
     * @throws Exception
     */
    public void LimparTexto() throws Exception {
        new MimosTela(getDriver())
                .limparTexto();
    }

    /**
     * Validar mensagem do popup agendamento realizado
     *
     * @throws Exception
     */
    public void validarNomeOFertaAlterada() throws Exception {
        new MimosTela(getDriver())
                .validarNomeOferta();
    }

    /**Tocar bot�o "Gerar Cupom de Desconto"
     * @param regraUso
     * @throws Exception
     */
    public void tocarBotaoGerarCupomDeDesconto(boolean regraUso) throws Exception{
        new MimosTela(getDriver())
                .tocarBotaoGerarCupomDeDesconto();
        if (regraUso){
            new RegrasUsoMimosTela(getDriver())
                .tocarBotaoRegrasDeUso();
            new RegrasUsoMimosTela(getDriver())
                .validarExibicaoTextoCadastradoRegrasDeUso();
        }
    }

    /**
     * Validar Fluxo de Mensagem exibida pelo PopUp
     *
     */
    public void validarMensagemPopup(String oferta) throws Exception {
        new MimosTela(getDriver())
                .validarMensagemPopUp(oferta);
        new CupomDescontoMimosTela(getDriver())
                .tocarBotaoOkPopUp()
                .validarExibicaoHeaderCupomDeDesconto();
    }

    /**
     * Validar Limite do Scroll acima
     *
     * @throws Exception
     */
    public void validaLimiteScrollAcima() throws Exception {
        new MimosTela(getDriver())
                .validaLimiteScrollAcima();
    }

    /**
     * validar Limite Scroll Abaixo
     *
     * @throws Exception
     */
    public void validaLimiteScrollAbaixo() throws Exception {
        new MimosTela(getDriver())
                .validaLimiteScrollAbaixo();
    }

    /**
     * Tocar bot�o "Favoritar"
     *
     * @throws Exception
     */
    public void tocarBotaoFavoritar() throws Exception{
        new MimosTela(getDriver())
                .tocarBotaoFavoritar();
    }

    /**
     * Selecionar bot�o "Desfavoritar"
     *
     * @throws Exception
     */
    public void selecionarDesfavoritar() throws Exception{
        new MimosTela(getDriver())
                .selecionarDesfavoritar();
    }

    /**
     * Validar oferta em categoria favoritos
     *
     * @param oferta
     */
    public void validarOfertaNaCategoria(String categoria, String oferta) throws Exception {
        new MimosTela(getDriver())
                .deslizarCarrosselAteAcharCategoria(categoria)
                .validarOfertaNaCategoria(categoria,oferta);
    }

    /**
     * Validar oferta n�o presente em favoritos
     *
     * @param oferta
     * @throws Exception
     */
    public void validarOfertaNaoPresenteNaCategoria(String categoria, String oferta) throws Exception{
        new MimosTela(getDriver())
                .validarOfertaNaoPresenteNaCategoria(categoria, oferta);
    }


    /**
     * Tocar bot�o c�digo "Ir para loja"
     *
     * @throws Exception
     */
    public void tocarBotaoCopiarCodigoIrParaLoja(String link) throws Exception{
        new CupomDescontoMimosTela(getDriver())
            .tocarBotaoGerarCupomDesconto();
        new MimosTela(getDriver())
                .validarAberturaBrowser(link);
    }

    /**
     * Tocar bot�o retornar para menu principal
     *
     * @throws Exception
     */
    public void voltarParaMenuPrincipal() throws Exception{
        new MimosTela(getDriver())
                .tocarBotaoVoltarMenuPrincipal();
    }

    /**
     * Selecionar Categoria e oferta via dados do params
     *
     * @throws Exception
     */
    public void selecionarCategoriaeOferta(String categoria, String oferta) throws Exception {
        new MimosTela(getDriver())
                .tocarBotaoConhecerTelaPrimeiroAcesso()
                .deslizarCarrosselAteAcharCategoria(categoria)
                .selecionarCardOferta(oferta);
    }

    /**
     * Ir para Site da Oferta e voltar para app Next
     *
     * @throws Exception
     */
    public void irParaSiteOferta() throws Exception {
        new MimosTela(getDriver())
                .tocarBotaoIrParaParceiros()
                .validarRedirecionamentoAppWeb();
    }

    public void irParaOferta(String oferta) throws Exception {
        new MimosTela(getDriver())
                .retornarAppNext(oferta)
                .tocarBotaoVoltar();
    }

    /**
     * Validar tela detalhamento da Oferta
     * Tem codigo Promocional=True
     *
     * @throws Exception
     */
    public void validarTelaOferta(Boolean temCodigoPromocional) throws Exception {
        new MimosTela(getDriver())
                .tocarIconeComoUsar()
                .validarCodigoPromocional(temCodigoPromocional);
    }

    /**
     * Tocar bot�o "Fechar"
     *
     * @throws Exception
     */
    public void tocarBotaoFechar() throws Exception {
        new MimosTela(getDriver())
                .tocarBotaoFechar();
    }

    /**
     * M�todo que seleciona o 'Mimo' atrav�s das categorias do Carrossel para realiza��o a sua avalia��o.
     * @param categoria Categoria a ser encontrada no Carrossel
     * @param oferta Oferta/Mimo a ser encontrado na categoria
     * @param numeroEstrelas Quantidade de estrelas para avalia��o
     * @throws Exception
     */
    public void avaliarMimo(String categoria, String oferta, NumeroEstrelas numeroEstrelas, boolean NaoExibirBtnMaisOpcoes) throws Exception {

        selecionarOfertaDeslizandoCarrossel(categoria, oferta, true);
        new MimosTela(getDriver())
                .tocarBotaoMaisOpcoes()
                .tocarBotaoAvaliarMimos();
        switch (numeroEstrelas) {
            case DUAS_ESTRELAS:
                new MimosTela(getDriver())
                        .tocarSegundaEstrelaAvaliacao()
                        .preencherComentarios();
                break;
            case CINCO_ESTRELAS:
                new MimosTela(getDriver())
                        .tocarQuintaEstrelaAvaliacao();
                break;
        }

        new MimosTela(getDriver())
                .tocarBotaoEnviar()
                .tocarBotaoVoltar();

        if (NaoExibirBtnMaisOpcoes) {
            new MimosTela(getDriver())
                .tocarBotaoRetornarMenu();
        }
    }

    /**
     * M�todo que seleciona o 'Mimo' atrav�s das categorias do Carrossel para validar os detalhes.
     * @param categoria Categoria a ser encontrada no Carrossel
     * @param oferta Oferta/Mimo a ser encontrado na categoria
     * @throws Exception
     */
    public void validarDetalhesMimo(String categoria, String oferta, String texto) throws Exception {

        selecionarOfertaDeslizandoCarrossel(categoria, oferta, true);
        new MimosTela(getDriver())
                .tocarIconeComoUsar()
                .tocarBotaoVerMeusCupons();
        new MimosTela(getDriver())
                .tocarBotaoTextoOferta(texto);
        new RegrasUsoMimosTela(getDriver())
                .tocarBotaoRegrasDeUso();
        new MimosTela(getDriver())
                .tocarBotaoVoltar();
        new CupomDescontoMimosTela(getDriver())
                .tocarBotaoGerarCupomDesconto();

    }

    /** M�todo que realiza o primeiro acesso na tela de mimos e loga novamente para validar se as mensagens de primeiro acesso n�o s�o mais exibidas.
     * @throws Exception
     */
    public void validarAusenciaDoTutorialNoSegundoAcessoAoMenuMimos() throws Exception {
        new MimosTela(getDriver())
                .validarPresencaTelaMimos()
                .tocarBotaoVoltarMenuPrincipal();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu()
                .tocarBotaoMimos();
        new MimosTela(getDriver())
                .validarPresencaTelaMimos()
                .validarMensagemPrimeiraTelaTutorialMimos()
                .tocarProximo()
                .validarMensagemSegundaTelaTutorialMimos()
                .tocarProximo()
                .validarMensagemTerceiraTelaTutorialMimos()
                .tocarBotaoConhecer()
                .validarPresencaTelaMimos()
                .tocarBotaoRetornarMenu();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu()
                .tocarBotaoMimos();
        new MimosTela(getDriver())
                .validarPresencaTelaMimos();
    }

    private void selecionarOfertaDeslizandoCarrossel(String categoria, String oferta, Boolean selecionaOferta) throws Exception {

        new MimosTela(getDriver())
            .deslizarCarrosselAteAcharCategoria(categoria);
        if (selecionaOferta) {
            new MimosTela(getDriver())
                .selecionarCardOferta(oferta);
        }
    }

    /**
     * Avan�ar no Tutorial Caso Exista.
     * @throws NextException
     */
    public void avancarTutorialCasoExista() throws Exception {
        new MimosTela(getDriver())
                .validarPresencaTelaMimos()
                .tocarBotaoProximoSeExistir()
                .tocarBotaoProximoSeExistir()
                .tocarBotaoConhecerSeExistir()
                .tocarBotaoCategoriasSeExistir();
    }
}
