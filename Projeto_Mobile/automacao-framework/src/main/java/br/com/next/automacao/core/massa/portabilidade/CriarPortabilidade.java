package br.com.next.automacao.core.massa.portabilidade;

import br.com.next.automacao.core.constantes.massa.Portabilidade.TipoPortabilidade;
import br.com.next.automacao.core.tools.Utilitarios;
import static br.com.next.automacao.core.massa.portabilidade.RequisicaoPortabilidade.criarPortabilidade;



public class CriarPortabilidade {

    public static void criarPortabilidadeDeSalario(TipoPortabilidade portabilidade, String cpfCliente, String cpfEmpregador) {
        try {
            switch (portabilidade) {
                case CRIAR_PORTABILIDADE_BRADESCO_CPF:
                    criarPortabilidade(cpfCliente,null,cpfEmpregador,237);
                    break;
                case CRIAR_PORTABILIDADE_BRADESCO_CNPJ:
                    criarPortabilidade(cpfCliente,Utilitarios.geradorCnpj(),null, 237);
                    break;
                case CRIAR_PORTABILIDADE_OUTROS_BANCOS_CNPJ:
                    criarPortabilidade(cpfCliente, Utilitarios.geradorCnpj(),null, Utilitarios.geradorBancosOperantes());
                    break;
                case CRIAR_PORTABILIDADE_OUTROS_BANCOS_CPF:
                    criarPortabilidade(cpfCliente, null,Utilitarios.gerarCpf(), 33);
                    break;
            }
        } catch (NullPointerException e) {
            e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
