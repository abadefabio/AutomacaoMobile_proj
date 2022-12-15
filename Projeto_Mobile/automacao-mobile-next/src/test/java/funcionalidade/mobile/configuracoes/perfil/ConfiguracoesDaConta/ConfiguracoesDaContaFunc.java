package funcionalidade.mobile.configuracoes.perfil.ConfiguracoesDaConta;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.configuracoes.perfil.configuracoes.da.conta.ConfiguracoesDaContaTela;
import pagina.mobile.jornadas.configuracoes.perfil.configuracoes.da.conta.EncerrarContaTela;
import pagina.mobile.jornadas.configuracoes.perfil.configuracoes.pagamento.PerfilTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ConfiguracoesDaContaFunc extends FuncionalidadeBase {

    /**
     * Método para encerrar conta next
     *
     * @throws Exception
     */
    public void encerrarContaNext() throws Exception{
        new PerfilTela(getDriver())
                .validarTelaPerfil()
                .tocarBotaoConfiguracoesDaConta();
        new ConfiguracoesDaContaTela(getDriver())
                .validarTelaConfiguraçõesDaConta()
                .tocarBotaoEncerrarConta();
        new EncerrarContaTela(getDriver())
                .validarTelaEncerrarConta()
                .tocarBotaoQueroEncerrarConta()
                .selecionarMotivoEncerrarConta()
                .tocarBotaoQueroEncerrarConta()
                .validarMensagemAntesDeEncerrarConta()
                .tocarBotaoQueroEncerrarConta()
                .tocarBotaoQueroEncerrarConta()
                .tocarBotaoLiEConcordoComOsTermosECondiçõesAcimaListados()
                .tocarBotaoQueroEncerrarConta()
                .validarMensagemEncerramentoDeConta();
    }
}
