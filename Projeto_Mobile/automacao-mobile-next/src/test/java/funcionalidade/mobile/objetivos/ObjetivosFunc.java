package funcionalidade.mobile.objetivos;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.exception.NextException;
import constantes.perfil.investidor.StatusPerfil;
import io.appium.java_client.ios.IOSDriver;
import pagina.mobile.jornadas.objetivos.DetalhesTela;
import pagina.mobile.jornadas.objetivos.EdicaoObjetivoTela;
import pagina.mobile.jornadas.objetivos.MeusObjetivosTela;
import pagina.mobile.jornadas.objetivos.ObjetivosTela;
import pagina.mobile.jornadas.objetivos.ProdutoObjetivoTela;
import pagina.mobile.jornadas.objetivos.aporte.EditarAplicacaoTela;
import pagina.mobile.jornadas.perfil.investidor.PerfilVencidoTela;
import pagina.mobile.jornadas.perfil.investidor.SeuPerfilDeInvestidorTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ObjetivosFunc extends FuncionalidadeBase {

    private void fecharTelaPrimeiroAcessoObjetivoPresente() throws Exception {
        new ObjetivosTela(getDriver())
                .verificarBotaoVerMeusObjetivosEstaPresente();
    }

    /**
     * Método para tocar no botao criar objetivo'
     *
     * @throws Exception
     */
    public void tocarBotaoCriarObjetivo() throws Exception {
        new ObjetivosTela(getDriver())
                .tocarCriarObjetivo()
                .validarEstarTelaObjetivos();
    }

    /**
     * Método para tocar no botao aporte
     *
     * @throws Exception
     */
    public void tocarBotaoAporteObjetivo() throws Exception {
        fecharTelaPrimeiroAcessoObjetivoPresente();
        new ObjetivosTela(getDriver())
                .tocarMeusObjetivos()
                .tocarBotaoAporte();
    }

    /**
     * Método para validar que esta na tela de Objetivos'
     *
     * @throws Exception
     */
    public void validarQueEstaNaTelaObjetivo() throws Exception {
        new ObjetivosTela(getDriver())
                .validarEstarTelaObjetivos();
    }

    /**
     * Método para validar que a tela de tutorial de Objetivos está presente'
     *
     * @throws Exception
     */
    public void validarTutorialObjetivos() throws Exception {
        new ObjetivosTela(getDriver())
                .validarTutorial();
    }

    /**
     * Método para tocar no botão 'Ver meus objetivos'
     *
     * @throws Exception
     */
    public void tocarBotaoVerMeusObjetivos() throws Exception {
        new ObjetivosTela(getDriver())
                .tocarBotaoVerMeusObjetivos();
    }

    /**
     * Método para validar 'Objetivos Criados'
     *
     * @throws Exception
     */
    public void validarObjetivosCriados() throws Exception {
        new ObjetivosTela(getDriver())
                .validarObjetivosCriados();
    }

    /**
     * Editar agendamento de aporte objetivo
     *
     * @throws Exception
     */
    public void editarAgendamentoAporteObjetivo(String tituloObjetivo) throws Exception {
        fecharTelaPrimeiroAcessoObjetivoPresente();
        new ObjetivosTela(getDriver())
                .tocarBotaoDetalhes();
        new DetalhesTela(getDriver())
                .tocarBotaoEditarAgendamentoAporte();
        new EditarAplicacaoTela(getDriver())
                .validarTituloTelaEdicaoAporte(tituloObjetivo);
    }

    /**
     * Acessar Detalhes no card de Objetivos
     * @throws Exception
     */
    public void acessarDetalhesCardMeusObjetivos() throws Exception {
        fecharTelaPrimeiroAcessoObjetivoPresente();
        new ObjetivosTela(getDriver())
                .validarTelaObjetivos()
                .tocarMeusObjetivos()
                .tocarBotaoDetalhes();
        new DetalhesTela(getDriver())
                .validarExibicaoDetalhesTela();
    }

    /**
     * Metodo para tocar o botao aporte
     *
     * @throws Exception
     */
    public void selecionarAporte(StatusPerfil statusPerfil) throws Exception {
        new ObjetivosTela((getDriver()))
                .tocarBotaoVerMeusObjetivos()
                .rolarTelaCima();
        new MeusObjetivosTela((getDriver()))
                .validarPresencaCardObjetivo()
                .tocarBotaoAporte();
        switch (statusPerfil) {
            case PERFIL_VENCIDO:
                new PerfilVencidoTela(getDriver())
                        .validarTituloTela()
                        .tocarBotaoRefazerPerfilOuDecobrirPerfil();
        }
    }

    /**
     * Acessar o 'Perfil Investidor' via menu
     * @throws NextException
     */
    public void acessarPerfilInvestidorViaMenu() throws NextException {
        new ObjetivosTela(getDriver())
                .tocarBotaoVerMeusObjetivos()
                .tocarBotaoHeaderListaTresPontos()
                .tocarBotaoPerfilInvestidor();
        new SeuPerfilDeInvestidorTela(getDriver())
                .validaExibicaoSeuPerfilDeInvestidorTela();
    }


    /** Ver produto shopFacil quando o objetivo está concluído
     * @param primeira
     * @throws Exception
     */
    public void verProdutoShopFacil(boolean primeira) throws Exception {
        if (getDriver() instanceof IOSDriver){
            new ObjetivosTela(getDriver())
                    .tocarMeusObjetivos();
        }else{
            if (primeira){
                fecharTelaPrimeiroAcessoObjetivoPresente();
            }
            new ObjetivosTela(getDriver())
                    .tocarMeusObjetivos();
        }
        new DetalhesTela(getDriver())
                .tocarCardObjetivo();
        new EdicaoObjetivoTela(getDriver())
                .encontrarDetalhesCardObjetivo();
        new DetalhesTela(getDriver())
                .tocarBotaoVerProduto();

        new ProdutoObjetivoTela(getDriver())
                .tocarBotaoShoppFacil();
    }

    /** Acessar 'Detalhes' via card
     * fr
     * @throws Exception
     */
    public void acessarDetalhesObjetivo() throws Exception {
        fecharTelaPrimeiroAcessoObjetivoPresente();

        new ObjetivosTela(getDriver())
                .validarTelaObjetivos()
                .tocarBotaoDetalhes();

        new DetalhesTela(getDriver())
                .validarExibicaoDetalhesTela();
    }

    /** Acessar 'Detalhes' via card
     * fr
     * @throws Exception
     */
    public void acessarInformacoes() throws Exception {
        fecharTelaPrimeiroAcessoObjetivoPresente();

        new ObjetivosTela(getDriver())
                .validarTelaObjetivos()
                .tocarBotaoDetalhes();

        new DetalhesTela(getDriver())
                .validarExibicaoDetalhesTela();

        new ObjetivosTela(getDriver())
                .tocarBotaoVoltar();
    }

    /** Acessar e validar 'Detalhes' do I na tela inicial de objetivos
     * fr
     * @throws Exception
     */
    public void acessarDetalhes() throws Exception {

        new ObjetivosTela(getDriver())
                .validarTelaObjetivos()
                .tocarBotaoDetalhes();

        new DetalhesTela(getDriver())
                .validarExibicaoDetalhesTela();

        new ObjetivosTela(getDriver())
                .tocarBotaoVoltar();
    }

    /**
     * Esse método vai acessar o icone de detalhes (i) da tela de tutorial de Objetivos, validar a tela detalhes e voltar para tela de tutorial
     *
     * @throws Exception
     */
    public void validarDetalhesTelaTutorialObjetivos() throws Exception {
        new ObjetivosTela(getDriver())
                .validarTutorial()
                .tocarBotaoInformacoes();
        new DetalhesTela(getDriver())
                .validarTituloTelaDetalhes()
                .tocarBotaoFechar();
        new ObjetivosTela(getDriver())
                .validarTutorial()
                .tocarBotaoVoltar();
    }
}
