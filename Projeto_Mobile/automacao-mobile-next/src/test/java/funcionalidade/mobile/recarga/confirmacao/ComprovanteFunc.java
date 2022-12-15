package funcionalidade.mobile.recarga.confirmacao;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.recarga.RecargaCelularTela;
import pagina.mobile.jornadas.recarga.confirmacao.ComprovanteTela;
import pagina.mobile.comum.so.ModalCompartilhamentoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ComprovanteFunc  extends FuncionalidadeBase {

    /**
     * Valida a apresentação do Comprovante
     * @throws Exception
     */
    public void validarComprovanteRecarga() throws Exception {
        new ComprovanteTela(getDriver())
                .tocarBotaoCompartilhar();
        new ModalCompartilhamentoTela(getDriver())
                .validarModalCompartilhamento();
        new ComprovanteTela(getDriver())
                .voltarParaTelaDeComprovante()
                .tocarBotaoFechar();
        new RecargaCelularTela(getDriver())
                .validarExibicaoTelaRecarga();
    }

}
