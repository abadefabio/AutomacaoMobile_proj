package funcionalidade.mobile.adesao;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.adesao.TipoCartao;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.adesao.CompleteSeuCadastroTela;
import pagina.mobile.jornadas.adesao.EscolhaSeuCartaoTela;
import pagina.mobile.jornadas.adesao.EscolhaSuaCestaTela;
import pagina.mobile.jornadas.adesao.FaturaTela;
import pagina.mobile.jornadas.adesao.MaisDetalhesTela;
import pagina.mobile.jornadas.adesao.PacotesPadronizadosTela;
import pagina.mobile.jornadas.adesao.PacotesTela;
import pagina.mobile.jornadas.adesao.PassoCincoDeSeisTela;
import pagina.mobile.jornadas.adesao.PassoQuatroDeSeisTela;
import pagina.mobile.jornadas.adesao.PassoSeisDeSeisTela;
import pagina.mobile.jornadas.adesao.ResumoTela;
import pagina.mobile.jornadas.adesao.SenhaTela;
import pagina.mobile.jornadas.adesao.termosecondicoes.TermosECondicoesTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static constantes.adesao.termosECondicoes.TermosECondicoes.CONDICOES_PROPOSTA_DE_ABERTURA_DE_CONTA;
import static constantes.adesao.termosECondicoes.TermosECondicoes.CONDICOES_REGULAMENTO_DA_FUNCAO_CREDITO_DOS_CARTOES_NEXT;
import static constantes.adesao.termosECondicoes.TermosECondicoes.CONDICOES_REGULAMENTO_DO_PROGRAMA_DE_FIDELIDADE_CARTOES_BRADESCO;
import static constantes.adesao.termosECondicoes.TermosECondicoes.CONDICOES_TERMOS_E_CONDICOES_DE_USO_DO_APLICATIVO_NEXT;
import static constantes.adesao.termosECondicoes.TermosECondicoes.TERMO_PROPOSTA_DE_ABERTURA_DE_CONTA;
import static constantes.adesao.termosECondicoes.TermosECondicoes.TERMO_REGULAMENTO_DA_FUNCAO_CREDITO_DOS_CARTOES_NEXT;
import static constantes.adesao.termosECondicoes.TermosECondicoes.TERMO_REGULAMENTO_DO_PROGRAMA_DE_FIDELIDADE_CARTOES_BRADESCO;
import static constantes.adesao.termosECondicoes.TermosECondicoes.TERMO_TERMOS_E_CONDICOES_DE_USO_DO_APLICATIVO_NEXT;

public class CompleteSeuCadastroFunc extends FuncionalidadeBase {

    /**
     * Acessar a funcionalidade 'Escolha de cesta e Cartão'
     * @throws Exception
     */
    public void validarAdesaoTermo(String senha, String pacotePadronizado,
                                   String senhaCartao,
                                   String confirmarSenhaCartao) throws Exception {
        new CompleteSeuCadastroTela(getDriver())
                .validaTelaCompleSeuCadastro()
                .tocarBotaoEscolhaCestaCartao();
        new PassoSeisDeSeisTela(getDriver())
                .validarTituloTelaPassoSeisDeSeis()
                .tocarVamosLa();
        new EscolhaSuaCestaTela(getDriver())
                .validarTituloTelaEscolhaSuaCesta()
                .tocarVerPacotesPadronizados();
        new PacotesTela(getDriver())
                .validarTituloTelaPacotes()
                .tocarMaisDetalhesDoPacotePadronizado(pacotePadronizado);
        new MaisDetalhesTela(getDriver())
                .validarTituloTelaMaisDetalhes()
                .tocarFechar();
        new PacotesTela(getDriver())
                .validarTituloTelaPacotes()
                .selecionarCheckboxDoPacotePadronizado(pacotePadronizado)
                .tocarEscolherPacote();
        new PacotesPadronizadosTela(getDriver())
                .validarTituloTelaPacotesPadronizados()
                .tocarEscolherPacotePadronizado();
        new EscolhaSeuCartaoTela(getDriver())
                .validarTituloTelaEscolhaSeuCartao()
                .tocarbotaoQueroEsteCartao();
        new ResumoTela(getDriver())
                .validarTituloTelaResumo()
                .tocarTudoCertoContinuar();
        new SenhaTela(getDriver())
                .validarTituloTelaSenha()
                .inserirSenhaSeisDigitosDoCartao(senhaCartao)
                .confirmarSenhaSeisDigitosDoCartao(confirmarSenhaCartao)
                .tocarVisualizarSenha()
                .tocarContinuar();
        new TermosECondicoesTela(getDriver())
                .validarTermosECondicoesTela();
    }

    /**
     * Validar tela Complete Seu Cadastro
     *
     * @throws Exception
     */
    public void validarTelaCompleteSeuCadastro() throws Exception {
        new CompleteSeuCadastroTela(getDriver())
                .validaTelaCompleSeuCadastro();
    }

    /**
     * Validar retomada Estagio Foto do Documento
     * @throws Exception
     */
    public void validarRetomadaNoEstagioFotoDoDocumento() throws Exception {

        new CompleteSeuCadastroTela(getDriver())
                .validaTelaCompleSeuCadastro()
                .tocarBotaoFotoDocumento();
        new PassoQuatroDeSeisTela(getDriver())
                .validarMensagemFoto()
                .tocarBotaoVoltar();
        new CompleteSeuCadastroTela(getDriver())
                .validaTelaCompleSeuCadastro();
    }

    /**
     * Validar Termos
     * @throws Exception
     */
    public void validarTermosDaJornadaDeAdesao(String pacotePadronizado,
                                               String senhaCartao,
                                               String confirmarSenhaCartao,
                                               String termosECondicoes,
                                               String diaDeVencimento,
                                               String tipoPagamento,
                                               TipoCartao tipoCartao) throws Exception {
        new CompleteSeuCadastroTela(getDriver())
                .validaTelaCompleSeuCadastro()
                .tocarBotaoEscolhaCestaCartao();
        new PassoSeisDeSeisTela(getDriver())
                .validarTituloTelaPassoSeisDeSeis()
                .tocarVamosLa();
        new EscolhaSuaCestaTela(getDriver())
                .validarTituloTelaEscolhaSuaCesta()
                .tocarVerPacotesPadronizados();
        new PacotesTela(getDriver())
                .validarTituloTelaPacotes()
                .tocarMaisDetalhesDoPacotePadronizado(pacotePadronizado);
        new MaisDetalhesTela(getDriver())
                .validarTituloTelaMaisDetalhes()
                .tocarFechar();
        new PacotesTela(getDriver())
                .validarTituloTelaPacotes()
                .selecionarCheckboxDoPacotePadronizado(pacotePadronizado)
                .tocarEscolherPacote();
        new PacotesPadronizadosTela(getDriver())
                .validarTituloTelaPacotesPadronizados()
                .tocarEscolherPacotePadronizado();
        switch (tipoCartao) {
            case VISA_NEXT_INTERNACIONAL:
                new EscolhaSeuCartaoTela(getDriver())
                        .validarTituloTelaEscolhaSeuCartao()
                        .tocarbotaoQueroEsteCartao();
                break;
            case VISA_NEXT_PLATINUM:
                new EscolhaSeuCartaoTela(getDriver())
                        .validarTituloTelaEscolhaSeuCartao()
                        .tocarProximo()
                        .tocarbotaoQueroEsteCartao();
                break;
        }
        new ResumoTela(getDriver())
                .validarTituloTelaResumo()
                .tocarTudoCertoContinuar();
        new SenhaTela(getDriver())
                .validarTituloTelaSenha()
                .inserirSenhaSeisDigitosDoCartao(senhaCartao)
                .confirmarSenhaSeisDigitosDoCartao(confirmarSenhaCartao)
                .tocarVisualizarSenha()
                .tocarContinuar();
        new FaturaTela(getDriver())
                .validarTituloTelaFatura()
                .tocarVparaAbrirEsteiraComDiasDeVencimento()
                .selecionarDiaDeVencimento(diaDeVencimento)
                .selecionarFormaDePagamento(tipoPagamento)
                .tocarConfirmar();
        new TermosECondicoesTela(getDriver())
                .validarCarregamentoTela()
                .selecionarTermo(termosECondicoes);
        switch (termosECondicoes){
            case TERMO_PROPOSTA_DE_ABERTURA_DE_CONTA:
                new ValidaMensagensTela(getDriver())
                        .validarTodasAsMensagens(CONDICOES_PROPOSTA_DE_ABERTURA_DE_CONTA);
                new TermosECondicoesTela(getDriver())
                        .tocarBotaoRetornarMenu();
                break;
            case TERMO_TERMOS_E_CONDICOES_DE_USO_DO_APLICATIVO_NEXT:
                new ValidaMensagensTela(getDriver())
                        .validarTodasAsMensagens(CONDICOES_TERMOS_E_CONDICOES_DE_USO_DO_APLICATIVO_NEXT);
                new TermosECondicoesTela(getDriver())
                        .tocarBotaoRetornarMenu();
                break;
            case TERMO_REGULAMENTO_DA_FUNCAO_CREDITO_DOS_CARTOES_NEXT:
                new ValidaMensagensTela(getDriver())
                        .validarTodasAsMensagens(CONDICOES_REGULAMENTO_DA_FUNCAO_CREDITO_DOS_CARTOES_NEXT);
                new TermosECondicoesTela(getDriver())
                        .tocarBotaoRetornarMenu();
                break;
            case TERMO_REGULAMENTO_DO_PROGRAMA_DE_FIDELIDADE_CARTOES_BRADESCO:
                new ValidaMensagensTela(getDriver())
                        .validarTodasAsMensagens(CONDICOES_REGULAMENTO_DO_PROGRAMA_DE_FIDELIDADE_CARTOES_BRADESCO);
                new TermosECondicoesTela(getDriver())
                        .tocarBotaoRetornarMenu();
                break;
        }
    }
}
