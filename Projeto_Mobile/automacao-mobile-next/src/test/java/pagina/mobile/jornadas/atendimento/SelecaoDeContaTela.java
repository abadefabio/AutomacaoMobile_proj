package pagina.mobile.jornadas.atendimento;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static java.time.Duration.ofSeconds;

public class SelecaoDeContaTela extends PaginaBase {

    public SelecaoDeContaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botão "Conta Dependente"
     *
     * @return SelecaoDeContaTela
     * @throws Exception
     */
    @Step("Tocar botão 'Conta Dependente'")
    public SelecaoDeContaTela tocarNoBotaoNomeDependente(String nomeDependente) throws Exception {
        By localizador = ios ? new By.ByXPath("//*[contains(lower-case(@label), " + nomeDependente + ")]") : new By.ByXPath("//*[contains(lower-case(@text), " + nomeDependente + ")]");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(localizador, "A " + nomeDependente + "não foi encontrada em tela");
        salvarEvidencia("Tocar botão 'Conta Dependente'" + nomeDependente);
        tocarElemento(localizador, "Ocorreu um erro ao executar a ação de Tocar botão 'Conta Dependente");
        return this;
    }
}

