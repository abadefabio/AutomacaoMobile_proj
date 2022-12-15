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
    // Texto numero do protocolo da tela SUCESSO DE CONTRATA��O
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_await_activation")
    @iOSXCUITFindBy(accessibility = "titleLabel")
    private MobileElement labelNumeroProtocolo;

    // bot�o VER DETALHES DO PLANO da tela SUCESSO DE CONTRATA��O
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_plans_details")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'finishButton')]")
    private MobileElement btnVerDetalhesPlanoTelaSucessoContratacao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_conclude")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'CONCLUIR')]")
    private MobileElement botaoConcluir;
    /*     *************************     */

    /*
    M�todo para Valida tela SUCESSO DE CONTRATA��O
    */
    @Step("Valida tela SUCESSO DE CONTRATA��O")
    public SucessoContratacaoDebitoTela validaTelaSucessoContratacao() throws Exception {
        aguardarCarregamentoElemento(labelNumeroProtocolo);
        compararElementoTexto(labelNumeroProtocolo, SegurosDebito.TEXTO_ATIVACAO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela SUCESSO DE CONTRATA��O");
        return this;
    }
    /*
    M�todo para Tocar no bot�o <VER DETALHES DO PLANO> da tela de SUCESSO DE CONTRATA��O
    */
    @Step("Tocar no bot�o <VER DETALHES DO PLANO> da tela de SUCESSO DE CONTRATA��O")
    public SucessoContratacaoDebitoTela tocarBtnVerDetalhesPlanoDebito() throws Exception {
        aguardarCarregamentoElemento(btnVerDetalhesPlanoTelaSucessoContratacao);
        salvarEvidencia("Tocar no bot�o <VER DETALHES DO PLANO> da tela de SUCESSO DE CONTRATA��O");
        tocarElemento(btnVerDetalhesPlanoTelaSucessoContratacao, "N�o foi poss�vel clicar no tocar <VER DETALHES DO PLANO> da tela de SUCESSO DE CONTRATA��O.");
        return this;
    }

    /**
     * Tocar no bot�o 'Concluir'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o 'Concluir'")
    public SucessoContratacaoDebitoTela tocarBotaoConcluir() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Concluir'");
        tocarElemento(botaoConcluir, "N�o foi poss�vel tocar no bot�o 'Concluir'");
        return this;
    }
}
