package funcionalidade.mobile.adesao;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.comum.next.HomeJornadaTela;
import pagina.mobile.comum.next.PopUpTela;
import pagina.mobile.jornadas.adesao.DadosPessoaisTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class DadosPessoaisFunc extends FuncionalidadeBase {

    /**
     * Validar as opções do campo "Estado Civil"
     *
     * @throws Exception
     */
    public void validarOpcoesCampoEstadoCivil() throws Exception {
        new DadosPessoaisTela(getDriver())
                .validarOpcoesCampoEstadoCivil();
    }

    /**
     * Validar cadastro em 'Terminar mais tarde'
     *
     * @throws Exception
     */
    public void validarCadastroTerminarMaisTarde() throws Exception {
        new DadosPessoaisTela(getDriver())
                .tocarTerminarMaisTarde();
        new PopUpTela(getDriver())
                .validarPopupPodeTerminarOutraHora()
                .tocarBotaoSairDoNext();
        new HomeJornadaTela(getDriver())
                .validarTituloNext();
    }

}
