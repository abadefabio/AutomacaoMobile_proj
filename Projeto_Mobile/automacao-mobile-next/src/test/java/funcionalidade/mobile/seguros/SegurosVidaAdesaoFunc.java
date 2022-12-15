package funcionalidade.mobile.seguros;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.seguros.vida.adesao.*;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class SegurosVidaAdesaoFunc extends FuncionalidadeBase {

    /**
     * Validar layout da tela Proteção
     * contratados=false (nao possui card contratado)
     * @throws Exception
     */

    /*
    Método para validar Detalhes Produto
     */
    public void validarDetalhesProduto() throws Exception {
        new ProdutoVidaTela(getDriver())
                .tocarBtnSaibaMaisIndenizacao();
        new DetalhesProdutoVidaTela(getDriver())
                .tocarBtnVoltarTelaDetalhesIndenizacao();
        new ProdutoVidaTela(getDriver())
                .validaTelaProdutoVida();
    }

    /*
    Método para validar Condicoes Gerais
     */
    public void validarCondicoesGerais() throws Exception {
        new ProdutoVidaTela(getDriver())
                .tocarBtnInfoCondicoesGerais();
        new ListaCondicoesGeraisVidaTela(getDriver())
                .visualizarCondicoesGerais();
        new CondicoesGeraisVidaTela(getDriver())
                .tocarBtnVoltarTelaCondicoesGerais();
        new ListaCondicoesGeraisVidaTela(getDriver())
                .tocarBtnFecharTelaListaCondicoesGerais();
        new ProdutoVidaTela(getDriver())
                .validaTelaProdutoVida();
    }

    /*
    Método para validar Informacoes Parceiro
     */
    public void validarInformacoesParceiro() throws Exception {
        new ProdutoVidaTela(getDriver())
                .tocarBtnSaibaMaisInfoParceiro();
        new InformacoesParceiroVidaTela(getDriver())
                .tocarBtnVoltarTelaSaibaMaisInfoParceiro();
        new ProdutoVidaTela(getDriver())
                .validaTelaProdutoVida();
    }
}
