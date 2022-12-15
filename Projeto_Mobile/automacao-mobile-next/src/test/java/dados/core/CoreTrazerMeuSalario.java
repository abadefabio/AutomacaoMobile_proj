package dados.core;

import br.com.next.automacao.core.constantes.massa.Portabilidade.Portabilidade;
import br.com.next.automacao.core.constantes.massa.Portabilidade.TipoPortabilidade;
import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.constantes.massa.tdm.StatusPortabilidade;
import br.com.next.automacao.core.massa.portabilidade.CriarPortabilidade;
import br.com.next.automacao.core.massa.portabilidade.DadosPortabilidade;
import br.com.next.automacao.core.massa.tdm.PortabilidadeTdm;
import constantes.portabilidade.DetalhesPortabilidade;


public class CoreTrazerMeuSalario extends FuncionalidadeBase {

    /**
     * Criar portabilidade de salario
     *
     * @param cpf
     */
    public void criarPortabilidadeDeSalario(String cpf, DetalhesPortabilidade portabilidade) throws InterruptedException {
        switch (portabilidade.retornarTipoPortabilidade()) {
            case CRIAR_PORTABILIDADE_OUTROS_BANCOS_CPF:
            case CRIAR_PORTABILIDADE_OUTROS_BANCOS_CNPJ:
                Thread.sleep(100000);
                CriarPortabilidade.criarPortabilidadeDeSalario(portabilidade.retornarTipoPortabilidade(), cpf, null);
                Thread.sleep(100000);
                break;
            default:
                Thread.sleep(100000);
                CriarPortabilidade.criarPortabilidadeDeSalario(portabilidade.retornarTipoPortabilidade(), cpf, portabilidade.retornarCpfCnpjEmpregador());
                Thread.sleep(100000);
        }

        PortabilidadeTdm.alterarStatusPortabilidade(cpf, portabilidade.retornarStatusPortabilidade());
    }

    /**
     * Alterar status da portabilidade
     *
     * @throws Exception
     */
    public void alterarStatusPortabilidade(String cpf, DetalhesPortabilidade Portabilidade) throws Exception {
        PortabilidadeTdm.alterarStatusPortabilidade(cpf, Portabilidade.retornarStatusPortabilidade());
    }

    /**
     * Alterar status da portabilidade
     *
     * @throws Exception
     */
    public void alterarStatusPortabilidade(String cpf, StatusPortabilidade statusPortabilidade) throws Exception {
        PortabilidadeTdm.alterarStatusPortabilidade(cpf, statusPortabilidade);
    }

    /**
     * Criar portabilidade de salario
     *
     * @throws Exception
     */
    public void criarPortabilidade(TipoPortabilidade tipoPortabilidade, String cpfCli, String cpfEmpregador) throws Exception {
        CriarPortabilidade.criarPortabilidadeDeSalario(tipoPortabilidade, cpfCli, cpfEmpregador);
    }

    /**
     * Criar portabilidade de salario
     *
     * @throws Exception
     */
    public void criarPortabilidade(DetalhesPortabilidade portabilidade, String cpfCli) throws Exception {
        TipoPortabilidade tipoPortabilidade = portabilidade.retornarTipoPortabilidade();
        switch (tipoPortabilidade) {
            case CRIAR_PORTABILIDADE_BRADESCO_CPF:
            case CRIAR_PORTABILIDADE_BRADESCO_CNPJ:
                Thread.sleep(100000);
                CriarPortabilidade.criarPortabilidadeDeSalario(tipoPortabilidade, cpfCli, portabilidade.retornarCpfCnpjEmpregador());
                Thread.sleep(100000);
                default:
                Thread.sleep(100000);
                CriarPortabilidade.criarPortabilidadeDeSalario(tipoPortabilidade, cpfCli, null);
                Thread.sleep(100000);
        }
    }

    /**
     * Criar portabilidade de sálario
     *
     * @param cpf
     */
    public void criarNovaPortabilidadeDeSalario(String cpf, DetalhesPortabilidade portabilidade) {
        PortabilidadeTdm.alterarStatusPortabilidade(cpf, StatusPortabilidade.CANCELADA_PARTICIPANTE_DESTINO);
        CriarPortabilidade.criarPortabilidadeDeSalario(portabilidade.retornarTipoPortabilidade(), cpf, portabilidade.retornarCpfCnpjEmpregador());
    }

    /**
     * Recuperar dados da portabilidade
     *
     * @throws Exception
     */
    public String recuperarCnpjDePortabilidade(Portabilidade cnpjPortabilidade) throws Exception {
        return DadosPortabilidade.recuperarDadosPortabilidade(cnpjPortabilidade);
    }
}
