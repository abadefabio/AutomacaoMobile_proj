package funcionalidade.mobile.configuracoes.perfil.meusDados;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.tools.Utilitarios;
import pagina.mobile.jornadas.configuracoes.perfil.configuracoes.pagamento.PerfilTela;
import pagina.mobile.jornadas.configuracoes.perfil.meus.dados.MeusDadosTela;
import pagina.mobile.jornadas.configuracoes.perfil.meus.dados.editarDados.EnderecoResidencialTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class EnderecoResidencialFunc extends FuncionalidadeBase {

    /**
     * M�todo de altera��o de endere�o residencial
     * @param cep
     * @param numero 
     *
     * @throws Exception
     */
    public void editarEnderecoResidencial(String cep, String numero) throws Exception{
        new PerfilTela(getDriver())
                .validarTelaPerfil()
                .tocarMeusDados();
        new MeusDadosTela(getDriver())
                .validarTelaMeusDados()
                .tocarBotaoEnderecos();
        new EnderecoResidencialTela(getDriver())
                .validarTelaEndere�oResidencial()
                .tocarBotaoEditar()
                .validarTelaEditarEndere�oResidencial()
                .preencherCampoCep(cep)
                .preencherCampoNumero(numero)
                .tocarBotaoContinuar()
                .tocarBotaoInformacao()
                .validarTelaLeiNumero7115()
                .tocarBotaoFechar()
                .tocarCheckboxDeDadosEntregues()
                .tocarBotaoContinuar()
                .validarTelaDeSucessoDeDadosAlterados();
    }


}
