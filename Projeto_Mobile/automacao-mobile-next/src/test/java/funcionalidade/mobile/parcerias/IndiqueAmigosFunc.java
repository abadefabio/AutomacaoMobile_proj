package funcionalidade.mobile.parcerias;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.geradorNomeCompleto;

import java.util.ArrayList;
import java.util.List;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.tools.Utilitarios;

import constantes.parcerias.ConviteIndiqueAmigos;
import constantes.parcerias.AmigoParcerias;
import constantes.parcerias.Parcerias;
import pagina.mobile.jornadas.parcerias.ConviteEnviadoIndiqueAmigosTela;
import pagina.mobile.jornadas.parcerias.IndiqueAmigosTela;
import pagina.mobile.comum.next.PopUpTela;

public class IndiqueAmigosFunc extends FuncionalidadeBase {

    /**
     * Indica amigo com nome e n�mero de celular v�lidos e gerados aleatoriamente
     *
     * @throws Exception
     */
    public void indicarAmigoAleatorioValido() throws Exception {
        new IndiqueAmigosTela(getDriver())
                .preencherCampoNome(geradorNomeCompleto(5, 6))
                .preencherCampoNumeroCelular(Utilitarios.geradorTelefone("celular"))
                .tocarBotaoIndicarAmigo();
    }

    /**
     * Preencher nome e celular e enviar o convite
     *
     * @throws Exception
     */
    public void indicarAmigoEnviarConvite(AmigoParcerias amigo) throws Exception {
        new IndiqueAmigosTela(getDriver())
                .preencherCampoNome(amigo.recuperarNomeAmigo())
                .preencherCampoNumeroCelular(amigo.recuperarCelularAmigo())
                .tocarBotaoIndicarAmigo();
    }

    /**
     * Preencher nome e celular e enviar o convite
     *
     * @throws Exception
     */
    public void indicarAmigoEnviarConvite(Parcerias nome, String celular) throws Exception {
        new IndiqueAmigosTela(getDriver())
                .preencherCampoNome(nome.toString())
                .preencherCampoNumeroCelular(celular)
                .tocarBotaoIndicarAmigo();
    }

    /**
     * Indicar m�ltiplos amigos at� atingir o n�mero de 30 convites enviados e a tentativa do convite de n�mero 31
     * O m�todo verifica, a cada envio de convite, se o n�mero m�ximo de convites foi enviado.
     *
     * @throws Exception
     */
    public void indicarMultiplosAmigos(int maxIndicacoesPossiveis) throws Exception {

        int indicacoesRealizadas = 0;
        IndiqueAmigosTela indiqueAmigosTela = new IndiqueAmigosTela(getDriver());
        ConviteEnviadoIndiqueAmigosTela conviteEnviadoIndiqueAmigosTela = new ConviteEnviadoIndiqueAmigosTela(getDriver());

        String numeroCelular = "null";
        List<String> numerosCelularUtilizados = new ArrayList<>();
        numerosCelularUtilizados.add(numeroCelular);

        while (indicacoesRealizadas <= maxIndicacoesPossiveis + 1) {
            indiqueAmigosTela.preencherCampoNome(geradorNomeCompleto(5, 6));
            while (numerosCelularUtilizados.contains(numeroCelular)) {
                // Evitar utilizar o mesmo n�mero de celular gerado aleatoriamente
                numeroCelular = "11" + Utilitarios.numeroAleatorio(911111111, 999999999);
            }
            indiqueAmigosTela.preencherCampoNumeroCelular(numeroCelular);
            indiqueAmigosTela.tocarBotaoIndicarAmigo();
            try {
                conviteEnviadoIndiqueAmigosTela.validarMensagemConsultorJequiti(Parcerias.MENSAGEM_VALIDACAO_CONSULTOR_JEQUETI);
                conviteEnviadoIndiqueAmigosTela.tocarBotaoIndicarNovoAmigo();
                numerosCelularUtilizados.add(numeroCelular); // registra celular utilizado na lista
                indicacoesRealizadas++;
            } catch (AssertionError | Exception jequitiNotValidated) {
                break;
            }
        }

        indiqueAmigosTela.salvarEvidencia("Foram " + indicacoesRealizadas +
                " indica��es realizadas nesta execu��o, de um m�ximo de " +
                Integer.parseInt(Parcerias.MAXIMO_INDICACOES_POSSIVEIS.toString()) + " indica��es poss�veis.");
    }

    /**
     * Tocar Bot�o fechar tela parceria
     *
     * @throws Exception
     */
    public void tocarBotaoFecharTelaParceria() throws Exception {
        new IndiqueAmigosTela(getDriver())
                .tocarBotaoFecharTelaParceria();
    }

    /**
     * Valida se mensagem exibida ao concluir convite de amigo � igual a mensagem enviada.
     * Al�m disso caso desejado convida mais amigos ou encerra o processo
     *
     * @param conviteIndiqueAmigos - Enum contendo a mensagem esperada e a decis�o de indicari mais amigos ou n�o
     * @throws Exception
     */
    public void validarConviteEnviado(ConviteIndiqueAmigos conviteIndiqueAmigos) throws Exception {
        switch (conviteIndiqueAmigos.retornaQuantidadeAmigos()) {
            case APENAS_UM:

                switch (conviteIndiqueAmigos) {

                    case CONVITE_ENVIADO_APENAS_UM:
                        new ConviteEnviadoIndiqueAmigosTela(getDriver())
                                .validarMensagemConviteEnviado()
                                .tocarBotaoOK();
                        break;
                    default:
                        new ConviteEnviadoIndiqueAmigosTela(getDriver())
                                .validarMensagemEsperada(conviteIndiqueAmigos)
                                .tocarBotaoOK();
                }
                break;

            case MAIS_AMIGOS:
                switch (conviteIndiqueAmigos) {
                    case CONVITE_ENVIADO_MAIS_AMIGOS:
                        new ConviteEnviadoIndiqueAmigosTela(getDriver())
                                .validarMensagemConviteEnviado()
                                .tocarBotaoIndicarNovoAmigo();
                        break;
                    default:
                        new ConviteEnviadoIndiqueAmigosTela(getDriver())
                                .validarMensagemEsperada(conviteIndiqueAmigos)
                                .tocarBotaoOK();
                }
        }
    }

    /**
     * Validar mensagem exibida em PopUp n�mero m�ximo de indica��es
     *
     * @param mensagem
     * @throws Exception
     */
    public void validarMensagemPopUpIndicacoesUltrapassadas(Enum mensagem) throws Exception {
        new PopUpTela(getDriver())
                .validarMensagem(mensagem.toString())
                .tocarBotaoOk();
    }

    /**
     * Validar mensagem exibida em PopUp
     *
     * @param mensagem
     * @throws Exception
     */
    public void validarMensagemEsperada(Enum mensagem) throws Exception {
        new ConviteEnviadoIndiqueAmigosTela(getDriver())
                .validarMensagemEsperada(mensagem);
    }

    /**
     * Tocar Botao OK
     *
     * @throws Exception
     */
    public void tocarBotaoOK() throws Exception {
        new ConviteEnviadoIndiqueAmigosTela(getDriver())
                .tocarBotaoOK();
    }

    /**
     * Validar Campos em Branco
     *
     * @throws Exception
     */
    public void validarCamposEmBranco() throws Exception {
        new IndiqueAmigosTela(getDriver())
                .validarCampoNomeEmBranco(Parcerias.CAMPO_NOME_VAZIO)
                .validarCampoNumeroCelularEmBranco(Parcerias.CAMPO_CELULAR_VAZIO);
    }

    /**
     * Validar Texto/ Abre conta tem
     *
     * @throws Exception
     */
    public void validarTelaTextoQuemAbreConta() throws Exception {
        new IndiqueAmigosTela(getDriver())
                .validarTextoAbreContaTem();
    }

    /**
     * Validar Texto/ Abre conta tem
     *
     * @throws Exception
     */
    public void validarTelaTextoBancoDigital() throws Exception {
        new IndiqueAmigosTela(getDriver())
                .validarTextoBancoDigital();
    }

    /**
     * Validar Celular incompleto
     *
     * @throws Exception
     */
    public void validarTelaCelularIncompleto() throws Exception {
        new IndiqueAmigosTela(getDriver())
                .validarMensagemCelularIncompleto();
    }

    /**
     * Validar Nome invalido
     *
     * @throws Exception
     */
    public void validarTelaTextoNomeInvalido(Parcerias nomeInvalido) throws Exception {
        new PopUpTela(getDriver())
                .validarMensagem(nomeInvalido.toString())
                .tocarBotaoOk();
    }
}
