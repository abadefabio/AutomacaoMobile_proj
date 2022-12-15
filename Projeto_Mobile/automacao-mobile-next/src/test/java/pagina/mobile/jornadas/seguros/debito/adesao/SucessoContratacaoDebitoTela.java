package pagina.mobile.jornadas.seguros.debito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosDebito;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class SucessoContratacaoDebitoTela extends PaginaBase {

    public SucessoContratacaoDebitoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Texto numero do protocolo da tela SUCESSO DE CONTRATAÇÃO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_await_activation")
    @iOSXCUITFindBy(accessibility = "titleLabel")
    private MobileElement labelNumeroProtocolo;

    // botão VER DETALHES DO PLANO da tela SUCESSO DE CONTRATAÇÃO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_plans_details")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'finishButton')]")
    private MobileElement btnVerDetalhesPlanoTelaSucessoContratacao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_conclude")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'CONCLUIR')]")
    private MobileElement botaoConcluir;
    /*     *************************     */

    /*
    Método para Valida tela SUCESSO DE CONTRATAÇÃO
    */
    @Step("Valida tela SUCESSO DE CONTRATAÇÃO")
    public SucessoContratacaoDebitoTela validaTelaSucessoContratacao() throws Exception {
        aguardarCarregamentoElemento(labelNumeroProtocolo);
        compararElementoTexto(labelNumeroProtocolo, SegurosDebito.TEXTO_ATIVACAO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela SUCESSO DE CONTRATAÇÃO");
        return this;
    }
    /*
    Método para Tocar no botão <VER DETALHES DO PLANO> da tela de SUCESSO DE CONTRATAÇÃO
    */
    @Step("Tocar no botão <VER DETALHES DO PLANO> da tela de SUCESSO DE CONTRATAÇÃO")
    public SucessoContratacaoDebitoTela tocarBtnVerDetalhesPlanoDebito() throws Exception {
        aguardarCarregamentoElemento(btnVerDetalhesPlanoTelaSucessoContratacao);
        salvarEvidencia("Tocar no botão <VER DETALHES DO PLANO> da tela de SUCESSO DE CONTRATAÇÃO");
        tocarElemento(btnVerDetalhesPlanoTelaSucessoContratacao, "Não foi possível clicar no tocar <VER DETALHES DO PLANO> da tela de SUCESSO DE CONTRATAÇÃO.");
        return this;
    }

    /**
     * Tocar no botão 'Concluir'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão 'Concluir'")
    public SucessoContratacaoDebitoTela tocarBotaoConcluir() throws Exception {
        salvarEvidencia("Tocar no botão 'Concluir'");
        tocarElemento(botaoConcluir, "Não foi possível tocar no botão 'Concluir'");
        return this;
    }
}
