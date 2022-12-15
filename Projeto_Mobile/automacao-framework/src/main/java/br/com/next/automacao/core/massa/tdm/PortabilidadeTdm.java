package br.com.next.automacao.core.massa.tdm;

import br.com.next.automacao.core.constantes.massa.tdm.StatusPortabilidade;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static br.com.next.automacao.core.tools.ApiCoreBanking.retornarAgenciaConta;

public class PortabilidadeTdm {

    private static List<String> parametros = new ArrayList<>();

    public static void alterarStatusPortabilidade(String agencia, String conta, StatusPortabilidade statusPortabilidade) {
        setParametros();
        RequisicoesTdm requisicoesTdm = new RequisicoesTdm();

        requisicoesTdm.implementarListaVariaveis("p_Agencia2", agencia);
        requisicoesTdm.implementarListaVariaveis("p_conta2", conta);
        requisicoesTdm.implementarListaVariaveis("P_Segmento_Port", statusPortabilidade.getValue());
        requisicoesTdm.executarFluxoMassa(parametros);
    }

    public static void alterarStatusPortabilidade(String cpf, StatusPortabilidade statusPortabilidade) {
        setParametros();
        String[] dados = retornarAgenciaConta(cpf);

        RequisicoesTdm requisicoesTdm = new RequisicoesTdm();

        requisicoesTdm.implementarListaVariaveis("p_Agencia2", dados[0]);
        requisicoesTdm.implementarListaVariaveis("p_conta2", dados[1]);
        requisicoesTdm.implementarListaVariaveis("P_Segmento_Port", statusPortabilidade.getValue());
        requisicoesTdm.executarFluxoMassa(parametros);
    }

    private static void setParametros() {
            parametros.add(0, "2873");
            parametros.add(1, "420");
            parametros.add(2, "Atualizar dados portabilidade");
            parametros.add(3, "Atualizar dados de Portabilidade de Salario Data Request");
            parametros.add(4, "2476");
            parametros.add(5, "2477");
    }
}