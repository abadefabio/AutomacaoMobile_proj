package funcionalidade.frontend.anotacoes;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.frontend.anotacoes.AnotacaoCpfTela;
import pagina.web.frontend.frames.componentes.AnnotationsBackOfficeFrame;
import tools.ContensorTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class AnotacoesCpfFunc extends FuncionalidadeBase {

    /**
     * Inserir o CPF para acessar o Anotacoes
     *
     * @param cpf
     * @throws Exception
     */
    public void inserirCPFBuscarAnotacao(String cpf) throws Exception {
        new ContensorTela(getWebDriver(), AnnotationsBackOfficeFrame.class)
                .executar(new AnotacaoCpfTela(getWebDriver())
                            .informarCpf(cpf)
                            .clicarBuscar())
                .desfazer();
    }
}
