package pagina.web.contingencia.login;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import br.com.next.automacao.core.tools.imagens.LeitorQRCode;

import constantes.login.contingencia.web.LoginWebMensagens;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;
import static framework.WebUtils.aguardarCarregamentoDaPagina;

public class LoginContingenciaTela extends PaginaBaseWeb {

    public LoginContingenciaTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(),'Login')]")
    private WebElement tituloLogin;

    @FindBy(id = "documentNumber")
    private WebElement elementoCpf;

    @FindBy(id = "ErrorMessage")
    private WebElement labelCpfErro;

    @FindBy(xpath = "//*[@id='buttonSubmitLogin' and contains(text(), 'Continuar')]")
    private WebElement botaoContinuar;

    @FindAll({
            @FindBy(id = "qrCodeValue"),
            @FindBy(xpath = "//img[contains(@alt,'Code')]"),
            @FindBy(id = "qrCode")
    })
    private WebElement qrCodeImg;

    @FindBy(id = "buttonReloadQRCode")
    private WebElement qrCodeExpirado;

    @FindBy(xpath = "//div[contains(@class,'next-box next-box__display-grid')]")
    // funciona com base64 e screenshot
    private WebElement qrCodeDivImg;

    /**
     * Informar Url da ContingĂȘncia
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Login URL ContingĂȘncia")
    public LoginContingenciaTela navegarPaginaContingencia(String contingencia_Url) throws Exception {
        navegar(contingencia_Url);
        return this;
    }

    /**
     * Informar CPF/CNPJ na pĂĄgina de login da ContingĂȘncia web
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Entrar com CPF")
    public LoginContingenciaTela informarCpf(String cpf) throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        apagarCampoTexto(elementoCpf, "NĂŁo foi possĂ­vel limpar o texto do campo CPF");
        digitarTexto(elementoCpf, cpf, "NĂŁo foi possĂ­vel digitar o texto " + cpf);
        salvarEvidencia("Informar CPF");
        return this;
    }

    /**
     * Informar CPF/CNPJ incorreto na pĂĄgina de login da ContingĂȘncia web
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Informar CPF incorreto")
    public LoginContingenciaTela informarCpfIncorreto(String cpf) throws Exception {
        aguardarPaginaConterQualquerTexto(LoginWebMensagens.LISTA_PALAVRAS_BOTAO_CONTINUAR_LOGIN);
        apagarCampoTexto(elementoCpf,"NĂŁo foi possĂ­vel limpar o texto do campo CPF");
        digitarTexto(elementoCpf, cpf, "NĂŁo foi possĂ­vel digitar o texto " + cpf);
        salvarEvidencia("Informar CPF incorreto");
        aguardarCarregamentoElemento(labelCpfErro);
        clicarBotaoContinuar();
        return this;
    }

    /**
     * Validar conteĂșdo do campo CPF se a entrada tiver sido alfabĂ©tica
     * O conteĂșdo deverĂĄ ser em branco
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Informar CPF incorreto")
    public LoginContingenciaTela validarConteudoCpfQuandoEntradaEmBranco(String cpf) throws Exception {

        if (cpf.trim().length() != 0) // validaĂ§ĂŁo ocorre sĂł se for em branco
            return this;
        clicarElemento(tituloLogin, "NĂŁo foi possĂ­vel desfocar do campo de documento CPF");
        validarAtributoTexto(elementoCpf, "", "NĂŁo foi possĂ­vel validar que o conteĂșdo estĂĄ em branco.");
        return this;
    }

    /**
     * Validar conteĂșdo do campo CPF se a entrada tiver sido em branco
     * O conteĂșdo deverĂĄ ser em branco
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Informar CPF incorreto")
    public LoginContingenciaTela validarConteudoCpfQuandoEntradaAlfabetica(String cpf) throws Exception {

        if (!cpf.matches("[a-zA-Z]+")) // se todos os caracteres forem alfabĂ©ticos
            return this;
        clicarElemento(tituloLogin, "NĂŁo foi possĂ­vel desfocar do campo de documento CPF");
        validarAtributoTexto(elementoCpf, "", "NĂŁo foi possĂ­vel validar que o conteĂșdo estĂĄ em branco.");
        return this;
    }


    /**
     * Validar mensagem de erro na validaĂ§ĂŁo do CPF/CNPJ
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Validar menssagem de erro da validaĂ§ĂŁo do CPF/CNPJ")
    public LoginContingenciaTela validarMensagemErroValidacaoCpf(String menssagemErro) throws Exception {
        validarAtributoTexto(labelCpfErro, menssagemErro, "NĂŁo foi possĂ­vel validar menssagem de erro campo cpf: " + menssagemErro);
        salvarEvidencia("Validado menssagem de erro validaĂ§ĂŁo cpf igual a: " + menssagemErro);
        return this;
    }

    /**
     * Refrescar a tela de login da web
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Validar menssagem de erro da validaĂ§ĂŁo do CPF/CNPJ")
    public LoginContingenciaTela verificarTelaLoginWebBotaoContinuar() throws Exception {
        int i = 0;
            do {
                aguardarCarregamentoDaPagina(driver);
                getWebDriver().navigate().refresh();
                i++;
            }while (!aguardarCarregamentoElemento(botaoContinuar) && i < 4);
            salvarEvidencia(String.format("Atualizado tela de login (depois %s tentativas)", i));
            return this;
        }

    /**
     * Aguardar carregametno a tela de login da web
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Aguardar carregametno a tela de login da web")
    public LoginContingenciaTela aguardarCarregamentoTelaLoginWeb() {
        aguardarCarregamentoElemento(botaoContinuar);
        return this;
    }

    /**
     * Clicar no botĂŁo 'Continuar'
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Clicar Continuar")
    public LoginContingenciaTela clicarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(elementoCpf);
        aguardarCarregamentoElemento(botaoContinuar);
        clicarElemento(botaoContinuar, "NĂŁo foi possĂ­vel clicar em \"Continuar\"");
        return this;
    }

    /**
     * Aguardar atĂ© que o QR Code esteja expirado
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Esperar atĂ© que o QR Code esteja expirado")
    public LoginContingenciaTela aguardarExpiracaoQrCode(int tempoMaxExpiracaoQrCode) throws Exception {
        long inicio = System.currentTimeMillis();
        List<WebElement> listQrCodeExpirado = null;
        do  {
            listQrCodeExpirado = retornarLista(By.id("buttonReloadQRCode"), "NĂŁo foi possĂ­vel localizar o QR Code expirado");
            //* Estamos dando tempoMaxExpiracaoQrCode segundos de mĂĄximo para que a validaĂ§ĂŁo ocorra
            Thread.sleep(1000);
        } while (listQrCodeExpirado.size() < 1 &&
                System.currentTimeMillis() - inicio < tempoMaxExpiracaoQrCode * 1000);

        validarCondicaoBooleana(listQrCodeExpirado.size() > 0,
                MetodoComparacaoBooleano.VERDADEIRO,
                "NĂŁo foi possĂ­vel determinar que o QR Code expirou.");
        salvarEvidencia("O QR Code foi expirado.");
        return this;
    }

    /**
     * Validar tempo de expiraĂ§ĂŁo do QR Code
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Validar tempo de expiraĂ§ĂŁo do QR Code recente")
    public LoginContingenciaTela validarTempoExpiracaoQRCodeRecente(int tempo) throws Exception {
        /*
        Devido a delays de sincronizaĂ§ĂŁo com a pĂĄgina,
        o tempo a ser validado nĂŁo pode ser exatamente igual ao tempo esperado.
        O parĂąmetro de tempo deve ter um perĂ­odo de graĂ§a (concessĂŁo) contido.
        Por exemplo, se o tempo esperado real na pĂĄgina Ă© de 60 segundos,
        o parĂąmetro aqui recebido poderia ser de 65 segundos (com margem de tolerĂąncia)
         */

        aguardarCarregamentoElemento(qrCodeImg);
        long inicio = System.currentTimeMillis();
        OperadorEvidencia.logarPasso("Validando tempo de expiraĂ§ĂŁo do QR Code em atĂ© " + tempo + " segundos.");
        boolean qrCodeExpiradoEncontrado = false;
        List<WebElement> listQrCodeExpirado = null;
        while (System.currentTimeMillis() - inicio < 1.2 * tempo * 1000) {
            /*
            Estamos dando 20% a mais de tempo para que a validaĂ§ĂŁo ocorra
            Esse tempo Ă© para, em caso de problemas na pĂĄgina ou bug,
            o teste nĂŁo ficar parado indefinidamente.
            Obviamente, se tudo estiver bem, a expiraĂ§ĂŁo ocorrerĂĄ em atĂ© 'tempo' segundos
            aproximadamente.
             */
            listQrCodeExpirado = retornarLista(By.id("buttonReloadQRCode"), "NĂŁo foi possĂ­vel encontrar o QR Code expirado");
            if (listQrCodeExpirado.size() > 0) {
                qrCodeExpiradoEncontrado = true;
                break;
                /*
                Trabalhar com este booleano evita checar o elemento na pĂĄgina
                em passo posterior, porque apĂłs isto o acesso do webdriver
                na pĂĄgina passa a ficar muito lento.
                 */
            }

            Thread.sleep(1000);
        }
        long tempoMedido = (System.currentTimeMillis() - inicio) / 1000;

        validarCondicaoBooleana(qrCodeExpiradoEncontrado,
                MetodoComparacaoBooleano.VERDADEIRO,
                "NĂŁo foi possĂ­vel determinar que o QR Code expirou.");

        validarCondicaoBooleana(tempoMedido <= tempo,
                MetodoComparacaoBooleano.VERDADEIRO,
                "O tempo de expiraĂ§ĂŁo foi superior ao esperado.\n" +
                        "Tempo esperado (atĂ©): " + tempo + ". Tempo medido: " + tempoMedido);
        salvarEvidencia("O tempo mĂĄximo de expiraĂ§ĂŁo do QR Code foi validado OK: " + tempoMedido + " segundos.\n" +
                "O tempo mĂĄximo esperado Ă© de " + tempo + " segundos.\n" +
                tempoMedido + " <= " + tempo);
        return this;
    }


    /**
     * Renovar o QR Code
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Renovar QR Code")
    public LoginContingenciaTela clicarQrCodeExpirado() throws Exception {
        aguardarCarregamentoElemento(qrCodeExpirado);
        salvarEvidencia("Renovar QR Code");
        /*
        O clique padrĂŁo do Selenium esteve um tanto demorado,
        razĂŁo pela qual utilizamos Javascript
         */
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].click();", qrCodeExpirado);
        return this;
    }

    /**
     * Validar a presenĂ§a do QR Code recĂ©m-criado (nĂŁo expirado)
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Renovar QR Code")
    public LoginContingenciaTela validarQrCodePresente() throws Exception {
        for(int i = 0; i < 3; i++) if(aguardarCarregamentoElemento(qrCodeImg)) break;
        validarCondicaoBooleana(aguardarCarregamentoElemento(qrCodeImg), MetodoComparacaoBooleano.VERDADEIRO,
                "NĂŁo foi possĂ­vel validar que o QR Code estĂĄ presente na tela.");
        aguardarCarregamentoDaPagina(driver);
        salvarEvidencia("ValidaĂ§ĂŁo de QR Code presente na tela");
        return this;
    }

    /**
     * Fazer leitura do QR Code
     * Este mĂ©todo utiliza o atributo SRC para obter a string base64
     * equivalente Ă  imagem do QR Code, mas tambĂ©m pode ser modificado
     * para utilizar o mĂ©todo de screenshot
     * Ambos estabilizam o QR Code antes de realizar a leitura:
     * 1. Ou esperando que se estabilizem o nĂșmero de bytes lidos do SRC
     * 2. Ou esperando que a imagem do QR Code pare de se deslocar na tela,
     * para a realizaĂ§ĂŁo de um screenshot estabilizado.
     *
     * @throws Exception
     * @return String
     */
    @Step("Efetuar leitura do QR Code")
    public String lerQRCode() throws Exception {
        /*
        Pode escolher entre:
        getImagemBase64Header -> obtĂ©m o SRC do elemento
        getBufferedImageScreenshot -> obtĂ©m primeiro o screenshot via Selenium
         */
        String sessionKey = null;

        String resposta = LeitorQRCode.lerQRCode(getImagemBase64Header(qrCodeImg));
        sessionKey = StringUtils.substringAfter(resposta, "{\"sessionKey\":\"");
        sessionKey = StringUtils.substringBefore(sessionKey, "\"}");
        if (sessionKey == null) {
            OperadorEvidencia.logarPasso("Realizado nova tentativa da leitura do QR code!");
        }
        OperadorEvidencia.logarPasso("Session Key: " + sessionKey);
        return sessionKey;
    }

    /**
     * Navegar para a pĂĄgina de login da ContingĂȘncia Web
     * A url foi definida em parĂąmetro de execuĂ§ĂŁo do XML no TestNG,
     * razĂŁo pela qual obtemos esse parĂąmetro previamente na classe do teste e o
     * passamos neste mĂ©todo.
     *
     * @param url
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Navegar para pĂĄgina inicial do login da ContingĂȘncia Web")
    public LoginContingenciaTela navegar(String url) throws Exception {
        getWebDriver().get(url);
        return this;
    }

    /**
     * Salvar print da pĂĄgina ao abrir uma nova guia na pĂĄgina de login da contingĂȘncia.
     *
     * @return LoginContingenciaTela
     */
    @Step("Salvar evidencia nova guia aberta")
    public LoginContingenciaTela salvarEvidenciaNovaGuiaAberta() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Abrir nova guia");
        return this;
    }

    /**
     * Salvar print da pĂĄgina ao abrir uma nova guia na pĂĄgina de login da contingĂȘncia.
     *
     * @return LoginContingenciaTela
     */
    @Step("Salvar evidencia nova guia aberta")
    public LoginContingenciaTela salvarEvidenciaAlternarAbas() {
        salvarEvidencia("Alternar aba");
        return this;


    }
}
