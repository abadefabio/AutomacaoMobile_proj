package br.com.next.automacao.core.massa.conta;


import br.com.next.automacao.core.constantes.massa.conta.Conta;
import br.com.next.automacao.core.constantes.massa.conta.TipoConta;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.massa.conta.RequisicaoConta.consultaDadosConta;



public class ConsultaConta {

    public static void consultaConta(TipoConta conta, String cpf) {
        try {
            switch (conta) {
                case CONTA_NEXT_CPF:
                    consultaDadosConta(cpf);
                    break;
                case CONTA_NEXTJOY_CPF:
                    consultaDadosConta(cpf);
                    break;
            }
        } catch (NullPointerException e) {
            e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
