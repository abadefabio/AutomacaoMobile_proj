package funcionalidade.mobile.credito;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.exception.NextException;
import pagina.mobile.jornadas.credito.AumentarLimiteTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class AumentarLimiteFunc extends FuncionalidadeBase {

    /**
     * Solicitar Novo Valor De Limite
     * @param valor
     * @throws NextException
     */
    public void solicitarNovoValorDeLimite(String valor) throws NextException {
        new AumentarLimiteTela(getDriver())
                .validarExibicaoTelaAumentarLimite()
                .digitarValorLimite(valor)
                .tocarBotaoConfirmar();
    }

    /**
     * Validar label em tela do limite aprovado
     * @param valor
     */
    public void validarLimiteAprovado(String valor){
        new AumentarLimiteTela(getDriver())
                .validarExibicaoTelaAumentarLimite()
                .validarAumentoDeLimite(valor);
    }

}
