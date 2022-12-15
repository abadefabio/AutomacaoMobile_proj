package pagina.mobile.jornadas.vaquinha;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class PushVaquinhaTela extends PaginaBase {

    //push vaquinha recusada
    @AndroidFindBy(id = "br.com.bradesco.next:id/img_background")
    @iOSXCUITFindBy(xpath = "//*[@name = \"nextLogoName\"]/parent::XCUIElementTypeOther/../XCUIElementTypeOther/XCUIElementTypeCollectionView")
    private MobileElement pushVaquinhaRecusada;

    @AndroidFindBy(id= "br.com.bradesco.next:id/tv_description_nt")
    private MobileElement textoPushVaquinha;

    public PushVaquinhaTela(AppiumDriver driver) {
        super(driver);
    }


    /** Validar Presença e texto do push de vaquinha recusada
     * @param nome
     * @param textoId
     * @return
     * @throws Exception
     */
    @Step("Validar Presenca Push Vaquinha Recusada")
    public PushVaquinhaTela validarPush(String nome,String textoId) throws Exception {

        MobileBy by = new MobileBy.ByAccessibilityId("Poxa, "+nome+" não aceitou a vaquinha :(");
        boolean encontrou = false;
        for (int x=0;x<3;x++){
                deslizar(pushVaquinhaRecusada, Direcao.ESQUERDA, 40,90);
            if (ios) {
                encontrou = verificarPresencaElemento(by);
            }else {
                encontrou = verificarPresencaElemento(pushVaquinhaRecusada);
                if (encontrou)
                    encontrou = retornarTexto(textoPushVaquinha,"Nao foi possivel recuperar o texto do elemento").equalsIgnoreCase(textoId);
            }
            if(encontrou)   break;
        }
        validarCondicaoBooleana(encontrou, MetodoComparacaoBooleano.VERDADEIRO,"Nao foi possivel encontrar o elemento");
        salvarEvidencia("Validar Presenca Push Vaquinha Recusada");
        return this;
    }


}
