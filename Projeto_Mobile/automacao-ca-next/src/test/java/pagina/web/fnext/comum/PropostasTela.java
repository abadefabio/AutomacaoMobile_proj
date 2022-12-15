package pagina.web.fnext.comum;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.AtributoElemento;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PropostasTela extends PaginaBaseWeb {


    @FindBy(xpath = "//*[@class=\"mat-cell cdk-column-CPF-do-solicitante mat-column-CPF-do-solicitante ng-star-inserted\"]")
    private WebElement cpfSolicitante;

    @FindBy(xpath = "//*[@ng-reflect-message=\"Editar\"]")
    private WebElement botaoEditarProposta;

    @FindBy(xpath = "//*[contains(@class, \"A-conta-foi-aberta\") and (text()=\"SIM \")]'")
    private WebElement aContaFoiAbertaSim;

    @FindBy(xpath = "//td[contains(@class,\"mat-cell cdk-column-Data-da-Atualiza--o-da-Proposta\")]")
    private WebElement dataAtualizacaoProposta;

    @FindBy(xpath = "//td[contains(@class,\"mat-cell cdk-column-Fila-de-Atendimento\")]")
    private WebElement filaAtendimentoProposta;

    @FindBy(xpath = "(//td[@class=\"mat-cell paddingth-td\"]/following-sibling::td)[3]")
    private WebElement dataFimEtapaProposta;

    @FindBy(xpath = "//strong[text()=\"ATUALIZAÇÃO MOTOR DE SEGURANÇA\"]")
    private WebElement ultimaEtapaProposta;

    public PropostasTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Validar resultado da Pesquisa por CPF
     *
     * @throws Exception
     */
    @Step("Validar resultado da Pesquisa por CPF")
    public PropostasTela validarResultadoPesquisaCpf(String cpf) throws Exception {
        aguardarElementoClicavel(cpfSolicitante);
        validarAtributoTexto(cpfSolicitante, cpf, "CPF não encontrado!");
        salvarEvidencia("Validar resultado da pesquisa por CPF");
        return this;
    }

    /**
     * Clicar CPF pesquisado
     *
     * @throws Exception
     */
    @Step("Clicar CPF pesquisado")
    public PropostasTela clicarCpfPesquisado() throws Exception {
        aguardarElementoClicavel(cpfSolicitante);
        clicarElemento(cpfSolicitante, "Erro para clicar CPF pesquisado");
        salvarEvidencia("Clicar no CPF pesquisado");
        return this;
    }

    /**
     * Clicar botão Editar Proposta
     *
     * @throws Exception
     */
    @Step("Clicar botão Editar Proposta")
    public PropostasTela clicarBotaoEditar() throws Exception {
        aguardarElementoClicavel(botaoEditarProposta);
        clicarElemento(botaoEditarProposta, "Erro ao clicar no botão Editar");
        salvarEvidencia("Clicar no botão editar proposta");
        return this;
    }

    /**
     * Validar Sim no campo A conta foi aberta?
     *
     * @throws Exception
     */
    @Step("Validar Sim no campo A conta foi aberta?")
    public PropostasTela validarSimCampoAContaFoiAberta() throws Exception {
        aguardarExistenciaElemento(aContaFoiAbertaSim);
        salvarEvidencia("Validar texto Sim no campo A conta foi aberta");
        return this;
    }

    /**
     * Validar data da coluna Data de Atualização do Card Propostas
     *
     * @throws Exception
     */
    @Step("Validar data da coluna Data de Atualização do Card Propostas")
    public PropostasTela validarDataAtualizacaoProposta() throws Exception {
        String retornarDataFimEtapaProposta;
        retornarDataFimEtapaProposta = retornarAtributoElemento(dataFimEtapaProposta, AtributoElemento.TEXTO,"Erro ao retornar atributo do elemento");
        compararElementoTexto(dataAtualizacaoProposta, retornarDataFimEtapaProposta, MetodoComparacao.IGUAL);
        salvarEvidencia("Validar Data da Atualização do Card Proposta é igual a Data Fim do Card Etapas da Proposta");
        return this;
    }

    /**
     * Validar etapa da coluna Fila de Atendimento do Card Propostas
     *
     * @throws Exception
     */
    @Step("Validar etapa da coluna Fila de Atendimento do Card Propostas")
    public PropostasTela validarFilaAtendimentoProposta() throws Exception {
        String retornarEtapaProposta;
        retornarEtapaProposta = retornarAtributoElemento(ultimaEtapaProposta, AtributoElemento.TEXTO,"Erro ao retornar atributo do elemento");
        compararElementoTexto(filaAtendimentoProposta, retornarEtapaProposta, MetodoComparacao.IGUAL);
        salvarEvidencia("Validar Fila de Atendimento do Card Proposta é igual a última Etapa do Card Etapas da Proposta");
        return this;
    }

}
