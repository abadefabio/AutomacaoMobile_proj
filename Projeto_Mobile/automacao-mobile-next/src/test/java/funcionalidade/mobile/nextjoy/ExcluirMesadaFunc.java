package funcionalidade.mobile.nextjoy;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import io.appium.java_client.ios.IOSDriver;
import pagina.mobile.jornadas.nextjoy.DependentesTela;
import pagina.mobile.jornadas.nextjoy.DetalhesMesadaTela;
import pagina.mobile.jornadas.nextjoy.MenuDependenteTela;
import pagina.mobile.jornadas.nextjoy.MesadaExcluidaTela;
import pagina.mobile.jornadas.nextjoy.MesadaTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ExcluirMesadaFunc extends FuncionalidadeBase {

    /**
     * Fluxo de Exclusão de Mesada
     *
     * @param mensagemMesadaExcluida    Mensagem de validação para mesada excluída com sucesso
     * @param mensagemMesadasNãoCriadas Mensagem de validação para mesadas não criadas
     * @throws Exception
     */
    public void excluirMesadaAgendada(String mensagemMesadaExcluida, String mensagemMesadasNãoCriadas, String nome) throws Exception {

        if (getDriver() instanceof IOSDriver) {
            new DependentesTela(getDriver())
                    .selecionarDependente(nome);
        }
        new MenuDependenteTela(getDriver())
                .validarMenuDependente(nome)
                .tocarMenuMesada();
        new MesadaTela(getDriver())
                .tocarDetalhesMesada();
        new DetalhesMesadaTela(getDriver())
                .tocarBotaoExcluirMesada();
        new MesadaExcluidaTela(getDriver())
                .validarMensagem(mensagemMesadaExcluida)
                .tocarBotaoOK();
        new MesadaTela(getDriver())
                .validarMensagem(mensagemMesadasNãoCriadas);
    }

}
