package funcionalidade.mobile.objetivos;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.tools.Utilitarios;

import constantes.objetivos.MensagensObjetivos;
import constantes.objetivos.TipoEdicao;
import io.appium.java_client.ios.IOSDriver;
import pagina.mobile.jornadas.objetivos.DetalhesTela;
import pagina.mobile.jornadas.objetivos.DiaAplicacaoParcelasTela;
import pagina.mobile.jornadas.objetivos.EdicaoObjetivoTela;
import pagina.mobile.jornadas.objetivos.MeusObjetivosTela;
import pagina.mobile.jornadas.objetivos.ObjetivosTela;
import pagina.mobile.comum.next.PopUpTela;

public class EditarObjetivoFunc extends FuncionalidadeBase {

    /**
     * Método para tocar em 'editar objetivo'
     *
     * @throws Exception
     */
    public void tocarEditarObjetivo() throws Exception {
       if (getDriver() instanceof IOSDriver){
            new ObjetivosTela(getDriver())
               .tocarBotaoVerMeusObjetivos()
               .tocarMeusObjetivos();
        }else{
            new ObjetivosTela(getDriver())
                    .validarEstarTelaObjetivos()
                    .tocarCriarObjetivo();
           }
        new MeusObjetivosTela(getDriver())
                .tocarDetalhes();
        new EdicaoObjetivoTela(getDriver())
                .tocarEditar()
                .validarTelaEdicaoObjetivo();
    }

    /**
     * Método para alterar 'Dados Objetivo'
     *
     * @throws Exception
     */
    public void alteraDadosObjetivo() throws Exception {
        String novoNome= Utilitarios.gerarNomeAleatorio();
        String meta = String.valueOf(Utilitarios.numeroAleatorio(3000000,700000));
        String parcela = String.valueOf(Utilitarios.numeroAleatorio(10000,30000));
        new EdicaoObjetivoTela(getDriver())
                .apagarNome()
                .alterarNome(novoNome)
                .alteraMeta(meta)
                .deslizarPrazoMes()
                .deslizarPrazoAno()
                .alterarParcelasMensais(parcela)
                .alterarDataDia();
        new DiaAplicacaoParcelasTela(getDriver())
                .validaExibicaoDiaDeAplicacaoDasParcelasTela()
                .selecionarDia(String.valueOf(Utilitarios.numeroAleatorio(1,28)))
                .tocarBotaoHeaderConfirmar();
        new EdicaoObjetivoTela(getDriver())
                .tocarBotaoConcluir();
        new PopUpTela(getDriver())
                .validarMensagem(MensagensObjetivos.MENSAGEM_TUDO_CERTO)
                .tocarBotaoOk();
        new EdicaoObjetivoTela(getDriver())
                .validarTextoObjetivo();
    }

    /**
     * Método para Acessar a tela de editar Objetivos
     *
     * @throws Exception
     */
    public void editarObjetivo(TipoEdicao tipoEdicao,String texto,boolean primeiraEdicao) throws Exception {

        if (getDriver() instanceof IOSDriver){
            new ObjetivosTela(getDriver())
                    .tocarBotaoVerMeusObjetivos()
                    .tocarMeusObjetivos();
        }else{
            if (primeiraEdicao){
                fecharTelaPrimeiroAcessoObjetivoPresente();
            }
            new ObjetivosTela(getDriver())
                    .tocarMeusObjetivos();
        }
        new MeusObjetivosTela(getDriver())
                .tocarDetalhes();
        new EdicaoObjetivoTela(getDriver())
                .encontrarDetalhesCardObjetivo();
        new DetalhesTela(getDriver())
                .tocarBotaoEditar();
        switch (tipoEdicao){
            case EDICAO_PRAZO:
                new EdicaoObjetivoTela(getDriver())
                        .deslizarDireitaMes()
                        .tocarBotaoSalvar(texto)
                        .tocarVoltar();
                break;
            case EDICAO_PRAZO_E_DIA:
                new EdicaoObjetivoTela(getDriver())
                        .deslizarEsquerdaMes()
                        .alterarDataDia();
                 new DiaAplicacaoParcelasTela(getDriver())
                        .validaExibicaoDiaDeAplicacaoDasParcelasTela()
                        .selecionarDia(String.valueOf(Utilitarios.numeroAleatorio(1,28)))
                        .tocarBotaoHeaderConfirmar();
                new EdicaoObjetivoTela(getDriver())
                        .tocarBotaoSalvar(texto);
                break;
        }
    }

    /** Valida se a tela inicial dos meus objetivos está sendo apresentada e toca na
     * @throws Exception
     */
    private void fecharTelaPrimeiroAcessoObjetivoPresente() throws Exception{
        new ObjetivosTela(getDriver())
                .verificarBotaoVerMeusObjetivosECriarEstaoPresentes();
    }
}


