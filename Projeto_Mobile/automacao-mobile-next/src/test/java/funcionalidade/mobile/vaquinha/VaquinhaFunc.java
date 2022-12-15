package funcionalidade.mobile.vaquinha;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.vaquinha.ValoresVaquinha;
import constantes.vaquinha.Vaquinha;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.json.simple.JSONObject;
import pagina.mobile.comum.next.PopUpTela;
import pagina.mobile.jornadas.menu.MenuTela;
import pagina.mobile.jornadas.notificacoes.NotificacoesTela;
import pagina.mobile.jornadas.vaquinha.BancoVaquinhaTela;
import pagina.mobile.jornadas.vaquinha.ConclusaoVaquinhaTela;
import pagina.mobile.jornadas.vaquinha.ConfirmacaoVaquinhaTela;
import pagina.mobile.jornadas.vaquinha.MeusContatosTela;
import pagina.mobile.jornadas.vaquinha.NomeVaquinhaTela;
import pagina.mobile.jornadas.vaquinha.NovoContatoVaquinhaTela;
import pagina.mobile.jornadas.vaquinha.PagarVaquinhaTela;
import pagina.mobile.jornadas.vaquinha.TermoAceiteVaquinhaTela;
import pagina.mobile.jornadas.vaquinha.*;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.calcularDataRelativaHoje;
import static br.com.next.automacao.core.tools.Utilitarios.pegarDataAtualEpoch;
import static br.com.next.automacao.core.tools.Utilitarios.proximoDiaUtil;

public class VaquinhaFunc extends FuncionalidadeBase {

    /**
     * M�todo tocar bot�o criar vaquinha'
     *
     * @throws Exception
     */
    public void acessarCriarVaquinha() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoCriarVaquinha();
    }

    /**
     * M�todo tocar bot�o criar vaquinha'
     *
     * @throws Exception
     */
    public void acessarAdicionarVaquinha() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoAdicionarVaquinha();
    }

    /**
     * Fluxo para validar o quantidade m�xima de vaquinhas criadas
     *
     * @throws Exception
     */
    public void validarLimiteVaquinhasCriadas() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoAdicionarVaquinha();
        new PopUpTela(getDriver())
                .validarNumeroMaximoDeVaquinhas(Vaquinha.QTDE_MAXIMA_VAQUINHAS.toString())
                .tocarBotaoOk();
    }

    /**
     * M�todo tocar bot�o excluir vaquina vaquinha'
     *
     * @throws Exception
     */
    public void acessarExcluirVaquinha() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoExcluirVaquinha();
        new PopUpTela(getDriver())
                .tocarBotaoSim();
    }

    /**
     * M�todo tocar bot�o criar vaquinha'
     *
     * @throws Exception
     */
    public void aceitarCheckTermoCondicoes() throws Exception {

        new TermoAceiteVaquinhaTela(getDriver())
                .tocarAceitarTermoCondicoesVaquinha()
                .tocarContinuarVaquinha();
    }

    /**
     * M�todo tocar lael nome vaquinha'
     *
     * @throws Exception
     */
    public void preencherNomedaVaquinha(String nomeVaquinha) throws Exception {
        new VaquinhaTela(getDriver())
                .preencherNomeVaquinha(nomeVaquinha);
    }

    /**
     * Validar mensagem do popup agendamento realizado
     *
     * @throws Exception
     */
    public void validarValorLimiteVaquinha() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoCriarVaquinha()
                .tocarBotaoAceitar()
                .tocarBotaoContinuar()
                .preencherNomeVaquinha(pegarDataAtualEpoch())
                .tocarBotaoContinuar()
                .informaValorVaquinha(ValoresVaquinha.MAIOR_MAXIMO.toString())
                .validarMensagemValorLimiteVaquinha();
    }

    /**
     * Selecionar a data do agendamento e continuar
     *
     * @throws Exception
     */
    private void selecionarDataAgendamentoAlteracao() throws Exception {
        String data = calcularDataRelativaHoje(120);
        new VaquinhaTela(getDriver())
                .selecionarData(data)
                .tocarBotaoConfirmar();
        if (getDriver() instanceof IOSDriver) {
            new VaquinhaTela(getDriver())
                    .tocarBotaoSalvar();
        } else {
            new VaquinhaTela(getDriver())
                    .tocarContinuarVaquinha();
        }
        new PopUpTela(getDriver())
                .tocarBotaoOk();
        new VaquinhaTela(getDriver())
                .tocarBotaoFechar()
                .tocarBotaoMenu();
    }

    /**
     * Tocar bot�o sim
     *
     * @throws Exception
     */
    public void tocarBotaoSim() throws Exception {
        new PopUpTela(getDriver())
                .tocarBotaoSim();
    }

    /**
     * Tocar bot�o n�o
     */
    public void tocarBotaoNao() throws Exception {
        new PopUpTela(getDriver())
                .tocarBotaoNao();
    }

    /**
     * Tocar bot�o n�o
     */
    public void tocarBotaoConfirmaExclusaoVaquinha() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoExcluir()
                .tocarBotaoFechar();
    }

    /**
     * Tocar bot�o fechar
     */
    public void tocarBotaoFechar() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoFechar();
    }

    /**
     * Selecionar vaquinha existente
     *
     * @throws Exception
     */
    public void selecionarVaquinhaExistente(String nomeVaquinha) throws Exception {
        new VaquinhaTela(getDriver())
                .selecionarVaquinhaExistente(nomeVaquinha);
    }

    /**
     * Tocar bot�o perfil
     */
    public void tocarBotaoPerfil() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoPerfil();
    }

    /**
     * Tocar bot�o editarperfil
     */
    public void tocarBotaoEditarPerfil() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoEditarPerfil();
    }

    /**
     * Tocar bot�o editar editar nome
     */
    public void tocarBotaoEditarImagem() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoEditarImagem()
                .tocarBotaoAlterarImagem()
                .tocarBotaoSalvarEdicao();
    }

    /**
     * Tocar bot�o editar editar nome
     */
    public void tocarBotaoAlterarImagem() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoAlterarImagem();
    }

    /**
     * Tocar bot�o editar salvar edi��o
     */
    public void tocarBotaoSalvarEdicao() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoSalvarEdicao();
    }

    /**
     * Tocar bot�o editar editar nome
     */
    public void tocarBotaoEditarNome(String nomeVaquinhaAlterada) throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoEditarNome()
                .nomeVaquina(nomeVaquinhaAlterada);
    }

    /**
     * Tocar bot�o editar editar nome
     */
    public void tocarBotaoEditarData() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoEditarData();

        selecionarDataAgendamentoAlteracao();
    }

    /**
     * M�todo para Retornar ao Menu principal
     *
     * @throws Exception
     */
    public void retornarAoMenu() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoMenu();
    }

    /**
     * M�todo para alterar o nome da vaquinha
     *
     * @param nomeVaquinhaAlterada
     * @throws Exception
     */
    public void alterarNomeVaquinha(String nomeVaquinhaAlterada) throws Exception {
        new VaquinhaTela(getDriver())
                .nomeVaquina(nomeVaquinhaAlterada);
    }

    /**
     * M�todo para tocar no bot�o continuar Vaquinha
     *
     * @throws Exception
     */
    public void tocarContinuarVaquinha() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * M�todo Inserir Valor e Selecionar data e Criar Vaquinha
     *
     * @throws Exception
     */
    public void inserirValorSelecionarDataCriarVaquinha(String valorVaquinha) throws Exception {
        String data = proximoDiaUtil(30);
        if (getDriver() instanceof IOSDriver) {
            new VaquinhaTela(getDriver())
                    .tocarBotaoContinuar()
                    .tocarLabelQuanto(valorVaquinha)
                    .tocarBotaoContinuar()
                    .tocarBotaoDataEdicao()
                    .selecionarData(data)
                    .tocarBotaoConfirmar()
                    .tocarBotaoContinuar();
        } else {
            new VaquinhaTela(getDriver())
                    .tocarBotaoContinuar()
                    .tocarLabelQuanto(valorVaquinha)
                    .tocarBotaoDataEdicao()
                    .selecionarData(data)
                    .tocarBotaoConfirmar()
                    .tocarBotaoContinuar();
        }
    }

    /**
     * M�todo para tocar no bot�o "Aceitar"
     *
     * @throws Exception
     */
    public void tocarBotaoAceitar() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoAceitar();
    }

    /**
     * M�todo para tocar no bot�o "Continuar"
     *
     * @throws Exception
     */
    public void tocarBotaoContinuar() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * M�todo Tocar Botao OK
     *
     * @throws Exception
     */
    public void tocarBotaoOK() throws Exception {
        new PopUpTela(getDriver())
                .tocarBotaoOk();
    }

    /**
     * M�todo Tocar Botao Data Edi��o
     *
     * @throws Exception
     */
    public void tocarBotaoDataEdicao() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoDataEdicao();
    }

    /**
     * M�todo Bot�o Confirmar
     *
     * @throws Exception
     */
    public void tocarBotaoConfirmar() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoConfirmar();
    }

    /**
     * Fluxo para cria��o de n�mero informado de vaquinhas
     *
     * @param numeroVaquinhas
     * @throws Exception
     */
    public void criarMultiplasVaquinhas(int numeroVaquinhas) throws Exception {
        for (int i = 0; i < numeroVaquinhas; i++) {
            criarVaquinha(ValoresVaquinha.VALIDO.toString());
        }
    }

    /**
     * Criar a Primeira Vaquinha
     *
     * @param valorVaquinha, pode ser "MAIOR_MAXIMO", "VALIDO" ou "MENOR_MINIMO"
     * @throws Exception
     */
    public void criarVaquinha(String valorVaquinha) throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoCriarVaquinha()
                .tocarBotaoAceitar()
                .tocarBotaoContinuar()
                .preencherNomeVaquinha(pegarDataAtualEpoch())
                .tocarBotaoContinuar()
                .informaValorVaquinha(valorVaquinha);
        new VaquinhaTela(getDriver())
                .tocarBotaoContinuar();
        new VaquinhaTela(getDriver())
                .tocarBotaoDataEdicao()
                .selecionarData(proximoDiaUtil(1))
                .tocarBotaoConfirmar()
                .tocarBotaoContinuar()
                .tocarBotaoFechar();
    }

    /**
     * M�todo para excluir m�ltiplas vaquinhas
     *
     * @param numeroVaquinhas
     */
    public void excluirMultiplasVaquinhas(int numeroVaquinhas) throws Exception {
        for (int i = 0; i < numeroVaquinhas; i++) {
            excluirVaquinha();
        }
    }

    /**
     * M�todo para excluir vaquinha
     */
    public void excluirVaquinha() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarCardVaquinha()
                .tocarBotaoPerfil()
                .tocarBotaoExcluirVaq();

        new PopUpTela(getDriver())
                .tocarBotaoSim();

        new VaquinhaTela(getDriver())
                .tocarBotaoExcluir()
                .tocarBotaoFechar();
    }

    /**
     * M�todo para excluir M�ltiplos Cards de vaquinhas
     *
     * @param numeroVaquinhas
     * @throws Exception
     */
    public void excluirMultiplosCards(int numeroVaquinhas) throws Exception {
        for (int i = 0; i < numeroVaquinhas; i++) {
            excluirCards();
        }
    }

    /**
     * M�todo para excluir cards
     */
    public void excluirCards() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoApagarCard();
        if (getDriver() instanceof IOSDriver) {
            new PopUpTela(getDriver())
                    .tocarBotaoSim();
        }
    }

    /**
     * M�todo que realiza a cria��o de uma vaquinha'
     *
     * @param vaquinha
     * @param data
     * @throws Exception
     */
    public void criarVaquinha(JSONObject vaquinha, String data) throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoCriarVaquinha();

        new TermoAceiteVaquinhaTela(getDriver())
                .tocarAceitarTermoCondicoesVaquinha()
                .tocarContinuarVaquinha();

        if (getDriver() instanceof IOSDriver) {
            new VaquinhaTela(getDriver())
                    .tocarBotaoContinuar();

        }
        new NomeVaquinhaTela(getDriver())
                .preencherNomeVaquinha(vaquinha.get("nomeVaquinha").toString());

        new VaquinhaTela(getDriver())
                .tocarBotaoContinuar()
                .escreverLabelQuanto(vaquinha.get("valorVaquinha").toString())
                .tocarContinuar()
                .tocarBotaoDataEdicao()
                .selecionarData(data)
                .tocarBotaoConfirmar()
                .tocarBotaoContinuar();
    }

    /**
     * M�todo Convidar contato para vaquinha
     *
     * @param criarVaquinha
     * @param vaquinha
     * @param mensagemAtualizarContato
     * @throws Exception
     */
    public void convidar(JSONObject vaquinha, Vaquinha criarVaquinha,
                         Vaquinha mensagemAtualizarContato) throws Exception {

        new VaquinhaTela(getDriver())
                .tocarConvidar();

        new VaquinhaTela(getDriver())
                .tocarContinuar();

        if (getDriver() instanceof IOSDriver) {
            new NovoContatoVaquinhaTela(getDriver())
                    .preencherNomeContato((vaquinha.get("nomeConvidado").toString() + vaquinha.get("sobrenome")))
                    .preencherEmailContato(vaquinha.get("email").toString())
                    .preencherCelularContato(vaquinha.get("telefone").toString())
                    .preencherCPFContato(vaquinha.get("favorecidoCpf").toString())
                    .tocarBotaoAdicionarConta();

            new BancoVaquinhaTela(getDriver())
                    .tocarselecionarBanco()
                    .preencherBanco(vaquinha.get("banco").toString())
                    .tocarBotaoConfirmar();

            new NovoContatoVaquinhaTela(getDriver())
                    .preencherAgencia(vaquinha.get("agencia").toString())
                    .preencherContaSemDigito(vaquinha.get("conta").toString())
                    .tocarBotaoContinuar();
        } else {
            new BancoVaquinhaTela(getDriver())
                    .tocarselecionarBanco()
                    .preencherBanco(vaquinha.get("banco").toString())
                    .tocarBotaoConfirmar();

            new NovoContatoVaquinhaTela(getDriver())
                    .preencherAgencia(vaquinha.get("agencia").toString())
                    .preencherContaSemDigito(vaquinha.get("conta").toString())
                    .preencherNomeContato((vaquinha.get("nomeConvidado").toString() + vaquinha.get("sobrenome")))
                    .tocarBotaoContinuar();
        }

        new PopUpTela(getDriver())
                .validarContatoCriadoComSucesso(criarVaquinha.toString())
                .tocarBotaoOk();

        if (getDriver() instanceof AndroidDriver) {
            new MeusContatosTela(getDriver())
                    .tocarPrimeiroContatoCirculo()
                    .validarContaSelecao(vaquinha.get("agencia").toString());
            new NovoContatoVaquinhaTela(getDriver())
                    .preencherEmailContato(vaquinha.get("email").toString())
                    .preencherCelularContato(vaquinha.get("telefone").toString())
                    .preencherCPFContato(vaquinha.get("favorecidoCpf").toString())
                    .tocarBotaoContinuar();

            new PopUpTela(getDriver())
                    .validarContatoAtualizadoComSucesso(mensagemAtualizarContato.toString())
                    .tocarBotaoOk();

            new MeusContatosTela(getDriver())
                    .confirmarEnviar();
        } else {
            new MeusContatosTela(getDriver())
                    .tocarPrimeiroContatoCirculo()
                    .confirmarEnviar();
        }

        new PopUpTela(getDriver())
                .tocarBotaoOk();

        new VaquinhaTela(getDriver())
                .tocarBotaoFechar();

        if (getDriver() instanceof AndroidDriver) {
            new VaquinhaTela(getDriver())
                    .tocarBotaoFechar();
        }
    }

    /**
     * M�todo Convidar contato para vaquinha recem criada
     *
     * @param criarVaquinha
     * @param vaquinha
     * @param mensagemAtualizarContato
     * @throws Exception
     */
    public void convidarAposCriacaoVaquinha(JSONObject vaquinha, Vaquinha criarVaquinha,
                         Vaquinha mensagemAtualizarContato) throws Exception {

        new VaquinhaTela(getDriver())
                .tocarBotaoContatos()
                .tocarContinuar();

        if (getDriver() instanceof IOSDriver) {
            new NovoContatoVaquinhaTela(getDriver())
                    .preencherNomeContato((vaquinha.get("nomeConvidado").toString() + vaquinha.get("sobrenome")))
                    .preencherEmailContato(vaquinha.get("email").toString())
                    .preencherCelularContato(vaquinha.get("telefone").toString())
                    .preencherCPFContato(vaquinha.get("favorecidoCpf").toString())
                    .tocarBotaoAdicionarConta();

            new BancoVaquinhaTela(getDriver())
                    .tocarselecionarBanco()
                    .preencherBanco(vaquinha.get("banco").toString())
                    .tocarBotaoConfirmar();

            new NovoContatoVaquinhaTela(getDriver())
                    .preencherAgencia(vaquinha.get("agencia").toString())
                    .preencherContaSemDigito(vaquinha.get("conta").toString())
                    .tocarBotaoContinuar();
        } else {
            new BancoVaquinhaTela(getDriver())
                    .tocarselecionarBanco()
                    .preencherBanco(vaquinha.get("banco").toString())
                    .tocarBotaoConfirmar();

            new NovoContatoVaquinhaTela(getDriver())
                    .preencherAgencia(vaquinha.get("agencia").toString())
                    .preencherContaSemDigito(vaquinha.get("conta").toString())
                    .preencherNomeContato((vaquinha.get("nomeConvidado").toString() + vaquinha.get("sobrenome")))
                    .tocarBotaoContinuar();
        }

        new PopUpTela(getDriver())
                .validarContatoCriadoComSucesso(criarVaquinha.toString())
                .tocarBotaoOk();

        if (getDriver() instanceof AndroidDriver) {
            new MeusContatosTela(getDriver())
                    .tocarPrimeiroContatoCirculo()
                    .validarContaSelecao(vaquinha.get("agencia").toString());
            new NovoContatoVaquinhaTela(getDriver())
                    .preencherEmailContato(vaquinha.get("email").toString())
                    .preencherCelularContato(vaquinha.get("telefone").toString())
                    .preencherCPFContato(vaquinha.get("favorecidoCpf").toString())
                    .tocarBotaoContinuar();

            new PopUpTela(getDriver())
                    .validarContatoAtualizadoComSucesso(mensagemAtualizarContato.toString())
                    .tocarBotaoOk();

            new MeusContatosTela(getDriver())
                    .confirmarEnviar();
        } else {
            new MeusContatosTela(getDriver())
                    .tocarPrimeiroContatoCirculo()
                    .confirmarEnviar();
        }

        new PopUpTela(getDriver())
                .tocarBotaoOk();
    }

    /**
     * M�todo para aceitar Vaquinha
     *
     * @throws Exception
     */
    public void aceitarVaquinhaAgendandoPagamento() throws Exception {

        new VaquinhaTela(getDriver())
                .tocarBotaoToDentro();

        new TermoAceiteVaquinhaTela(getDriver())
                .tocarAceitarTermoCondicoesVaquinha()
                .tocarContinuarVaquinha();

        new PagarVaquinhaTela(getDriver())
                .tocarRadioAgendar();

    }

    /**
     * M�todo para recusar vaquinha
     *
     * @param mensagem
     * @throws Exception
     */
    public void recusarVaquinha(Vaquinha mensagem) throws Exception {

        new VaquinhaTela(getDriver())
                .tocarBotaoRecusarVaquinha();

        new PopUpTela(getDriver())
                .validarRecusaDeConvite(mensagem.toString())
                .tocarBotaoOk();
    }

    /**
     * Selecionar Primeira vaquinha existente
     *
     * @throws Exception
     */
    public void selecionarPrimeiraVaquinha() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoSelecionarVaquinha();
    }

    /**
     * Selecionar vaquinha existente
     *
     * @param nomeVaquinha
     * @throws Exception
     */
    public void selecionarVaquinha(String nomeVaquinha) throws Exception {
        new VaquinhaTela(getDriver())
                .deslizarAteAcharVaquinha(nomeVaquinha)
                .tocarBotaoSelecionarVaquinha();
    }


    /**
     * M�todo para validar a mensagem push de recusa vaquinha ao logar no app
     *
     * @param mensagemPush
     * @throws Exception
     */
    public void validarNotificacaoRecusaVaquinha(String mensagemPush) throws Exception {
        new MenuTela(getDriver())
                .tocarMenuNotificacoes()
                .validarNotificacao(mensagemPush);

        new NotificacoesTela(getDriver())
                .voltarMenu();
    }

    /**
     * M�todo para aceitar vaquinha
     *
     * @param data
     * @param vaquinha
     * @throws Exception
     */
    public void aceitarVaquinhaDataAgendada(String data, JSONObject vaquinha) throws Exception {

        new VaquinhaTela(getDriver())
                .tocarBotaoToDentro();

        new TermoAceiteVaquinhaTela(getDriver())
                .tocarAceitarTermoCondicoesVaquinha();

        new PagarVaquinhaTela(getDriver())
                .tocarRadioAgendar()
                .selecionarData(data)
                .tocarBotaoConfirmarData()
                .tocarBotaoContinuar();

        new ConfirmacaoVaquinhaTela(getDriver())
                .validarNomeVaquinha(vaquinha.get("nomeVaquinha").toString())
                .validarValorVaquinha(vaquinha.get("valorVaquinha").toString())
                .validarDataVaquinha(data)
                .tocarBotaoAgendarPagamento();

        new PopUpTela(getDriver())
                .validarPagamentoVaquinhaFeitoComSucesso(Vaquinha.MENSAGEM_SUCESSO_PAGAMENTO.toString())
                .tocarBotaoOk();
    }

    /**
     * M�todo para enviar comprovante de pagamento de vaquinha por Email
     * @param data
     * @param vaquinha
     * @throws Exception
     */
    public void enviarComprovanteVaquinhaPorEmail(String data, JSONObject vaquinha) throws Exception {

        new ConclusaoVaquinhaTela(getDriver())
                .validarValorVaquinha(vaquinha.get("valorVaquinha").toString())
                .validarDataVaquinha(data)
                .tocarEnviarPorEmail();

        new PopUpTela(getDriver())
                .validarEmailVaquinhaFeitoComSucesso(Vaquinha.MENSAGEM_SUCESSO_EMAIL.toString())
                .tocarBotaoOk();
    }


    /**
     * M�todo para cancelar vaquinha
     *
     * @throws Exception
     */
    public void cancelarVaquinha(JSONObject vaquinha, String data) throws Exception{
        new VaquinhaTela(getDriver())
                .validarTelaVaquinha()
                .tocarAdicionarVaquinha()
                .tocarBotaoCriarVaquinha();
        new TermoAceiteVaquinhaTela(getDriver())
                .tocarAceitarTermoCondicoesVaquinha();
        new VaquinhaTela(getDriver())
                .tocarContinuarVaquinha();
        new NomeVaquinhaTela(getDriver())
                .preencherNomeVaquinha(vaquinha.get("nomeVaquinha").toString());
        new VaquinhaTela(getDriver())
                .tocarBotaoContinuar()
                .escreverLabelQuanto(vaquinha.get("valorVaquinha").toString())
                .tocarContinuar()
                .tocarBotaoDataEdicao()
                .selecionarData(data)
                .tocarBotaoConfirmar()
                .tocarBotaoContinuar()
                .validarEfetivacaoVaquinha()
                .tocarBotaoMais()
                .tocarBotaoExcluirVaquinhaCriada();
        new PopUpTela(getDriver())
                .validarMensagem(Vaquinha.MENSAGEM_CANCELAR_VAQUINHA.toString())
                .tocarBotaoSim();
        new ExcluirVaquinhaTela(getDriver())
                .validarTelaExcluir()
                .tocarExcluirVaquinha();
        new VaquinhaTela(getDriver())
                .validarVaquinhaCancelada()
                .tocarNoBotaoFechar()
                .validarTelaVaquinha();
    }
}
