package funcionalidade.mobile.pagamentos;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.pagamentos.FluxoPagamento;
import pagina.mobile.jornadas.pagamentos.PagamentosTela;
import pagina.mobile.jornadas.pagamentos.codigo.barras.LeitorCodigoDeBarrasTela;
import pagina.mobile.jornadas.pagamentos.comprovante.ComprovantePdfTela;
import pagina.mobile.jornadas.pagamentos.veiculos.DebitoDeVeiculosTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class PagamentosFunc extends FuncionalidadeBase {

    /**
     * Esse método será utilizado para selecionar o fluxo de pagamento a ser efetuado:
     * - Débito de Veículos;
     * - Código de Barras
     * @param pagamento - fluxo de pagamento a ser selecionado
     * @throws Exception
     */
    public void selecionarFluxoPagamento(FluxoPagamento pagamento) throws Exception {
        switch(pagamento){
            case DEBITO_VEICULOS:
                new PagamentosTela(getDriver())
                        .tocarCelulaDebitoDeVeiculos();
                new DebitoDeVeiculosTela(getDriver())
                        .validarPresencaDebitoDeVeiculosTela();
                break;
            case CODIGO_BARRAS:
                new PagamentosTela(getDriver())
                        .tocarPagarComCodigoDeBarras();
                new LeitorCodigoDeBarrasTela(getDriver())
                        .validarPresencaLeitorCodigoDeBarrasTela();
                break;
        }
    }

    /**
     * Acessar comprovante de pagamento
     * @param nomePagamento - Nome do pagamento
     * @throws Exception
     */
    public void acessarComprovantePagamento(String nomePagamento) throws Exception {
        new PagamentosTela(getDriver())
                .tocarPagamentoRealizado(nomePagamento)
                .tocarBotaoComprovante();
        new ComprovantePdfTela(getDriver())
                .validarPresencaTelaComprovantePDF();
    }
}
