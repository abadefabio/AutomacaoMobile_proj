package funcionalidade.mobile.configuracoes.perfil.meusDados;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.tools.Utilitarios;
import pagina.mobile.jornadas.configuracoes.perfil.configuracoes.pagamento.PerfilTela;
import pagina.mobile.jornadas.configuracoes.perfil.meus.dados.MeusDadosTela;
import pagina.mobile.jornadas.configuracoes.perfil.meus.dados.editarDados.EditarDadosTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class EditarDadosFunc extends FuncionalidadeBase {

    /**
     * Método que faz a alteração do Apelido
     *
     *
     * @throws Exception
     */
    public void editarApelido() throws Exception {

        String apelido = Utilitarios.gerarNomeAleatorio();

        new MeusDadosTela(getDriver())
                .tocarCampoApelido();
        new EditarDadosTela(getDriver())
                .validarTelaEditarApelido()
                .escreverApelido(apelido)
                .tocarBotaoSalvar()
                .validarMensagemApelidoAlterado()
                .tocarBotaoOk();
        new MeusDadosTela(getDriver())
                .validarAlteracaoCampoApelido(apelido)
                .tocarBotaoVoltar();
        new PerfilTela(getDriver())
                .validarTelaPerfil();
    }
}
