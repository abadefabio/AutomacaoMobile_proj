package funcionalidade.mobile.pagamentos.comprovante;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.comum.so.ModalCompartilhamentoTela;
import pagina.mobile.jornadas.menu.MenuTela;
import pagina.mobile.jornadas.pagamentos.comprovante.ComprovantePdfTela;
import pagina.mobile.jornadas.pagamentos.comprovante.ComprovanteTela;


import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ComprovanteFunc extends FuncionalidadeBase {

    /**
     * Ver Comprovante
     *
     * @param valor
     * @param dataPagamento
     * @throws Exception
     */
    public void verComprovante(String valor, String dataPagamento) throws Exception {
        new ComprovanteTela(getDriver())
                .validarDadosNaTela(valor, dataPagamento)
                .tocarLinkVisualizar();
        new ComprovantePdfTela(getDriver())
                .validarPresencaTelaComprovantePDF();
    }

    /**
     * Voltar da tela 'Comprovante PDF' até o 'Menu Inicial'
     *
     * @throws Exception
     */
    public void voltarDeComprovantePDFAteMenuInicial() throws Exception {
        new ComprovantePdfTela(getDriver())
                .tocarBotaoVoltar();
        new ComprovanteTela(getDriver())
                .tocarBotaoFechar();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu();
    }

    /**
     * Método executa ações de envio comprovante
     * @throws Exception
     */
    public void exibirCompartilhamentoComprovante() throws Exception {
        new ComprovanteTela(getDriver())
                .tocarLinkVisualizar();
        new ComprovantePdfTela(getDriver())
                .validarBotaoCompartilhar();
    }

    /**
     * Verficar compartilhamento de comprovante
     *
     * @throws Exception
     */
    public void verificarCompartilhamentoDeComprovante() throws Exception {
        new ComprovantePdfTela(getDriver())
                .tocarBotaoCompartilhar();
        new ModalCompartilhamentoTela(getDriver())
                .validarModalCompartilhamento();
    }

    /**
     * Visualizar Comprovante
     * @throws Exception
     */
    public void visualizarComprovante() throws Exception {
        new ComprovanteTela(getDriver())
                .validarComprovanteTela()
                .tocarLinkVisualizar()
                .validarComprovanteEmPdf();
    }

    public void validarDadosComprovante(String tributo, String valor) throws Exception {
        new ComprovanteTela(getDriver())
                .validarComprovanteTela()
                .validarTributoValor(tributo, valor)
                .tocarLinkVisualizar()
                .validarComprovanteEmPdf()
                .tocarBotaoVoltar()
                .tocarBotaoFechar();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu();
    }

    /**
     * Validar Dados Comprovante Agendamento
     *
     * @param valor
     * @param tributo
     * @throws Exception
     */
    public void validarDadosComprovanteAgendamento(String tributo, String valor) throws Exception {
        new ComprovanteTela(getDriver())
                .validarComprovanteEmPdf()
                .tocarBotaoVoltar()
                .validarTributoValor(tributo, valor);
    }
}
