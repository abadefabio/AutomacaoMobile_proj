package funcionalidade.mobile.vaquinha;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.comum.next.PopUpTela;
import pagina.mobile.jornadas.vaquinha.MeusContatosTela;
import pagina.mobile.jornadas.vaquinha.VaquinhaTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class MeusContatosFunc extends FuncionalidadeBase {

    public void excluirVaquinha() throws Exception {
        new VaquinhaTela(getDriver())
                .tocarBotaoSelecionarVaquinha()
                .tocarConvidar()
                .tocarBotaoContinuar();
        MeusContatosTela meusContatosTela = new MeusContatosTela(getDriver());
        if(meusContatosTela.contatoCirculoExiste()) {
            meusContatosTela
                    .manterPressionadoContato()
                    .tocarBotaoExcluir();
            new PopUpTela(getDriver())
                    .tocarBotaoSim();
            new MeusContatosTela(getDriver())
                    .validarTelaContatoDeletado()
                    .tocarBotaoOk()
                    .tocarVoltar();
        }
        else{
            meusContatosTela.tocarBotaoHeaderFechar();
        }
        new VaquinhaTela(getDriver())
                .tocarBotaoLista()
                .tocarBotaoExcluirVaq();
        new PopUpTela(getDriver())
                .tocarBotaoSim();
        new VaquinhaTela(getDriver())
                .tocarBotaoExcluir()
                .tocarBotaoFechar();
    }
}
