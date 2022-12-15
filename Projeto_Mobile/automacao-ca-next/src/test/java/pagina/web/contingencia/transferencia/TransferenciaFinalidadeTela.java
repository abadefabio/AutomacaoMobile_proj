package pagina.web.contingencia.transferencia;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TransferenciaFinalidadeTela extends TransferenciaTela {

    public TransferenciaFinalidadeTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "purpose")
    private WebElement campoFinalidade;

    @FindBy(xpath = "//*[@id='next-select__select__item-0']/span")
    private WebElement itemFinalidade;

    @FindBy(xpath = "//*[@id='purpose']/../div/div/span")
    private WebElement listaFinalidade;

    /**
     * Metódo para selecionar qual da finalidade da transferência
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar o item da finalidade da transferência")
    public TransferenciaFinalidadeTela  selecionarFinalidadeTransferencia(String finalidade) throws Exception {
        rolarParaBaixoAteElemento(campoFinalidade);
        aguardarCarregamentoElemento(campoFinalidade);
        selecionarTextoCombobox(campoFinalidade, finalidade, "Erro ao selecionar");
        salvarEvidencia("Selecionado finalidade: " + finalidade);
        return this;
    }
}
