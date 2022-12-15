package funcionalidade.frontend.anotacoes;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.frontend.anotacoes.AnotacaoCadastroTela;
import pagina.web.frontend.frames.componentes.AnnotationsBackOfficeFrame;
import tools.ContensorTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class AnotacaoCadastroFunc extends FuncionalidadeBase {

    /**
     * Clicar em Incluir Anota��o
     *
     * @param tituloAnotacao T�tulo da anota��o
     * @param descricao      Descri��o da anota��o
     * @throws Exception
     */
    public void incluirAnotacao(String tituloAnotacao, String descricao) throws Exception {
        new ContensorTela(getWebDriver(), AnnotationsBackOfficeFrame.class)
                .executar(
                        new AnotacaoCadastroTela(getWebDriver())
                        .clicarIncluirAnotacao()
                        .preencherTituloAnotacao(tituloAnotacao)
                        .preencherDescricaoAnotacao(descricao))
                .desfazer();
    }

    /**
     * Selecionar o checkbox de importante
     *
     * @throws Exception
     */
    public void clicarCheckboxImportante() throws Exception {
        new ContensorTela(getWebDriver(), AnnotationsBackOfficeFrame.class)
                .executar(new AnotacaoCadastroTela(getWebDriver())
                        .marcarAnotacaoImportante())
                .desfazer();
    }

    /**
     * Validar que ao clicar no bot�o Retornar dever� exibir um modal de alerta
     * ao clicar em SIM dever� fechar o modal do Retornar e do Anota��es
     *
     * @param alertaRetornar Descri��o do alerta apresentado em tela
     * @throws Exception
     */
    public void validarModalRetornar(String alertaRetornar) throws Exception {
        new ContensorTela(getWebDriver(), AnnotationsBackOfficeFrame.class)
                .executar(new AnotacaoCadastroTela(getWebDriver())
                        .clicarRetornar()
                        .validarMensagemModalBotaoRetornar(alertaRetornar)
                        .clicarSimModalBotaoRetornar()
                        .validarFechamentoModalRetornar())
                .desfazer();
    }

    /**
     * Salvar a anota��o e fechar o modal de sucesso
     *
     * @param msgAnotacao Texto a ser preenchido na anota��o
     * @throws Exception
     */
    public void salvarAnotacao(String msgAnotacao) throws Exception {
        new ContensorTela(getWebDriver(), AnnotationsBackOfficeFrame.class)
                .executar(new AnotacaoCadastroTela(getWebDriver())
                        .clicarSalvar(msgAnotacao)
                        .clicarFecharModalSalvar())
                .desfazer();
    }

    /**
     * Validar a cria��o da Anota��o na primeira linha da timeline
     *
     * @param tituloAnotacao T�tulo da anota��o a ser criada
     * @param descricao      Descri��o da anota��o
     * @param nome           Nome da anota��o
     * @param funcional      C�digo do funcional
     * @throws Exception
     */
    public void validarCriacaoAnotacao(String tituloAnotacao, String descricao, String nome, String funcional) throws Exception {
        new ContensorTela(getWebDriver(), AnnotationsBackOfficeFrame.class)
                .executar(new AnotacaoCadastroTela(getWebDriver())
                        .validarTituloAnotacaoTimeline(tituloAnotacao)
                        .validarDescricaoAnotacaoTimeline(descricao)
                        .validarNomeAnotacaoTimeline(nome)
                        .validarFuncionalAnotacaoTimeline(funcional))
                .desfazer();
    }

    /**
     * Validar a marca��o de Importante na anota��o da timeline
     *
     * @param txtImportante Texto para validar o check 'Importante'
     * @throws Exception
     */
    public void validarAnotacaoImportanteTimeline(String txtImportante) throws Exception {
        new ContensorTela(getWebDriver(), AnnotationsBackOfficeFrame.class)
                .executar(new AnotacaoCadastroTela(getWebDriver())
                        .validarMarcacaoImportanteAnotacao(txtImportante))
                .desfazer();
    }

    /**
     * Remover a marca��o de Importante da Anota��o
     *
     * @throws Exception
     */
    public void removerMarcacaoImportanteAnotacao() throws Exception {
        new ContensorTela(getWebDriver(), AnnotationsBackOfficeFrame.class)
                .executar(new AnotacaoCadastroTela(getWebDriver())
                        .removerMarcacaoImportante())
                .desfazer();
    }

    /**
     * Validar o texto retornado no modal de remo��o da flag Importante e clicar em V
     *
     * @param txtModalImportante Texto para validar o check 'Importante'
     * @throws Exception
     */
    public void validarTextoModalImportante(String txtModalImportante) throws Exception {
        new ContensorTela(getWebDriver(), AnnotationsBackOfficeFrame.class)
                .executar(new AnotacaoCadastroTela(getWebDriver())
                        .validarTextoModalImportante(txtModalImportante)
                        .clicarConfirmarRemoverImportante())
                .desfazer();
    }

    /**
     * Validar o texto retornado no modal de remo��o da flag Importante e Confirmar
     *
     * @param msgSucessoImportanteRemocao Mensagem de remo��o do check 'Importante'
     * @throws Exception
     */
    public void validarTextoSucessoFlagImportanteClicarConfirmar(String msgSucessoImportanteRemocao) throws Exception {
        new ContensorTela(getWebDriver(), AnnotationsBackOfficeFrame.class)
                .executar(new AnotacaoCadastroTela(getWebDriver())
                        .validarModalSucessoRemocaoImportante(msgSucessoImportanteRemocao)
                        .clicarFecharModalSucessoFlagImportante())
                .desfazer();
    }

    /**
     * Remover a marcacao de Importante da Anota��o e validar
     *
     * @throws Exception
     */
    public void validarremocaoMarcacaoImportante() throws Exception {
        new ContensorTela(getWebDriver(), AnnotationsBackOfficeFrame.class)
                .executar(new AnotacaoCadastroTela(getWebDriver())
                        .validarRemocaoMarcacaoImportante())
                .desfazer();
    }

    /**
     * Fun��o anexar arquivo
     *
     * @param extensaoAnexo Exten��o do arquivo a ser anexado
     * @param tamanhoAnexo  Tamanho do arquivo a ser anexado
     * @throws Exception
     */
    public void insereAnexoAnotacao(String extensaoAnexo, long tamanhoAnexo) throws Exception {
        AnotacaoCadastroTela anotacaoCadastroTela = new AnotacaoCadastroTela(getWebDriver());
        new ContensorTela(getWebDriver(), AnnotationsBackOfficeFrame.class)
                .executar(
                        anotacaoCadastroTela
                        .preencherAnexo(
                                anotacaoCadastroTela
                                        .criarArquivoTemporarioParaUpload(extensaoAnexo, tamanhoAnexo)
                        )
                );
    }
}
