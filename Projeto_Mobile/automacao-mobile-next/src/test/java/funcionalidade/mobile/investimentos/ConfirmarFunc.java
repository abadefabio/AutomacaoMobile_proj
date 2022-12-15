package funcionalidade.mobile.investimentos;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.investimentos.Perfil;
import constantes.investimentos.Texto;
import constantes.investimentos.TituloTela;
import framework.MobileUtils;
import pagina.mobile.comum.next.CarregamentoTela;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.comum.so.ModalCompartilhamentoTela;
import pagina.mobile.jornadas.investimentos.ConfirmarTela;
import pagina.mobile.jornadas.investimentos.TermosECondicoesTela;
import pagina.mobile.jornadas.investimentos.aplicacao.InvestimentoTela;
import pagina.mobile.jornadas.investimentos.comprovantes.ComprovanteTela;
import pagina.mobile.jornadas.investimentos.resgate.ResgateInvestimentoTela;

public class ConfirmarFunc extends FuncionalidadeBase {

    /**
     * Método responsável por validar as informações da tela de confirmação de Aplicação ou Resgate
     *
     * @param camposParaValidacao  Campos que serão buscados em tela para validação
     * @param produto              Produto aplicado ou resgatado
     * @param valoresParaValidacao Valores que serão validados
     * @throws Exception
     */
    public void validarInformacoesAplicacaoOuResgate(
            String produto,
            String[] camposParaValidacao,
            String... valoresParaValidacao) throws Exception {

        new ConfirmarTela(getDriver())
                .validarInformacoes(
                        produto,
                        MobileUtils.preencheInformacoesParaValidacao(
                                camposParaValidacao,
                                valoresParaValidacao),
                        camposParaValidacao);
    }

    /**
     * Método responsável por confirmar uma aplicação
     *
     * @param produto            Produto a ser validado (next CDB, next Ibov, next Alocação Arrojada, etc)
     * @param valor              Valor da aplicação
     * @param data               Data da aplicação
     * @param perfil             Perfil de investidor a se validado (utilizado para tomada de decisões)
     * @param primeiraAplicacao  Condição booleana (true/false) utilizada para validar se é primeira aplicação a ser realizada
     * @param validarComprovante Condição booleana (true/false) utilizada para validar ou não o comprovante gerado
     * @throws Exception
     */
    public void confirmarAplicacao(
            String produto,
            String valor,
            String data,
            Perfil perfil,
            boolean primeiraAplicacao,
            boolean validarComprovante) throws Exception {
        switch (perfil) {
            case PERFIL_DESENQUADRADO:
                new ConfirmarTela(getDriver())
                        .tocarBotaoLeituraTermosECondicoes();
                new TermosECondicoesTela(getDriver())
                        .tocarBotaoTermoDeCienciaERisco();
                new ValidaMensagensTela(getDriver())
                        .validarTodasAsMensagens(Texto.TERMO_DE_CIENCIA_E_RISCO.toString());
                new TermosECondicoesTela(getDriver())
                        .tocarBotaoFechar();
                new ConfirmarTela(getDriver())
                        .tocarCheckboxAceiteTermosECondicoes();
                break;
        }

        if (primeiraAplicacao) {
            new ConfirmarTela(getDriver())
                    .tocarCheckboxAceiteTermosECondicoes();
        }

        new ConfirmarTela(getDriver())
                .tocarBotaoConfirmar();

        validarTelaSucesso(produto, valor, data);

        if (validarComprovante) {
            new InvestimentoTela(getDriver())
                    .tocarBotaoVerComprovante();
            validarModalCompartilhamentoComprovante();
        }

        retornarMenuInvestimentos();
    }

    /**
     * Método responsável por confirmar um resgate de investimento
     *
     * @param produto            Produto a ser validado (next CDB, next Ibov, next Alocação Arrojada, etc)
     * @param valor              Valor do resgate
     * @param validarComprovante Condição booleana (true/false) utilizada para validar ou não o comprovante gerado
     * @throws Exception
     */
    public void confirmarResgate(String produto, String valor, String data, boolean validarComprovante) throws Exception {
        new ConfirmarTela(getDriver())
                .tocarBotaoConfirmar();

        validarTelaSucesso(produto, valor, data);

        if (validarComprovante) {
            new ResgateInvestimentoTela(getDriver())
                    .tocarBotaoVerComprovante();
            validarModalCompartilhamentoComprovante();
        }

        retornarMenuInvestimentos();
    }

    /**
     * Método responsável por validar a tela de sucesso da solicitação (Aplicação ou Resgate)
     *
     * @param produto Produto a ser validado (next CDB, next Ibov, next Alocação Arrojada, etc)
     * @param valor   Valor da aplicação/resgate
     */
    private void validarTelaSucesso(String produto, String valor, String data) {
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(produto, valor, data);
    }

    /**
     * Método responsável por validar o modal de compartilhamento do comprovante
     *
     * @throws Exception
     */
    private void validarModalCompartilhamentoComprovante() throws Exception {
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(TituloTela.COMPROVANTE.toString());
        new ComprovanteTela(getDriver())
                .tocarBotaoCompartilhar();
        new ModalCompartilhamentoTela(getDriver())
                .validarModalCompartilhamento()
                .fecharModalCompartilhamento();
        new ComprovanteTela(getDriver())
                .tocarBotaoVoltar();
    }

    /**
     * Método responsável por voltar ao menu 'Investimentos'
     *
     * @throws Exception
     */
    private void retornarMenuInvestimentos() throws Exception {
        new InvestimentoTela(getDriver())
                .tocarBotaoFechar();
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(
                        TituloTela.INVESTIMENTOS.toString(),
                        Texto.SALDO_DISPONIVEL_EM_CONTA.toString()
                );
    }
}
