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
     * Informar Url da Contingência
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Login URL Contingência")
    public LoginContingenciaTela navegarPaginaContingencia(String contingencia_Url) throws Exception {
        navegar(contingencia_Url);
        return this;
    }

    /**
     * Informar CPF/CNPJ na página de login da Contingência web
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Entrar com CPF")
    public LoginContingenciaTela informarCpf(String cpf) throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        apagarCampoTexto(elementoCpf, "Não foi possível limpar o texto do campo CPF");
        digitarTexto(elementoCpf, cpf, "Não foi possível digitar o texto " + cpf);
        salvarEvidencia("Informar CPF");
        return this;
    }

    /**
     * Informar CPF/CNPJ incorreto na página de login da Contingência web
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Informar CPF incorreto")
    public LoginContingenciaTela informarCpfIncorreto(String cpf) throws Exception {
        aguardarPaginaConterQualquerTexto(LoginWebMensagens.LISTA_PALAVRAS_BOTAO_CONTINUAR_LOGIN);
        apagarCampoTexto(elementoCpf,"Não foi possível limpar o texto do campo CPF");
        digitarTexto(elementoCpf, cpf, "Não foi possível digitar o texto " + cpf);
        salvarEvidencia("Informar CPF incorreto");
        aguardarCarregamentoElemento(labelCpfErro);
        clicarBotaoContinuar();
        return this;
    }

    /**
     * Validar conteúdo do campo CPF se a entrada tiver sido alfabética
     * O conteúdo deverá ser em branco
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Informar CPF incorreto")
    public LoginContingenciaTela validarConteudoCpfQuandoEntradaEmBranco(String cpf) throws Exception {

        if (cpf.trim().length() != 0) // validação ocorre só se for em branco
            return this;
        clicarElemento(tituloLogin, "Não foi possível desfocar do campo de documento CPF");
        validarAtributoTexto(elementoCpf, "", "Não foi possível validar que o conteúdo está em branco.");
        return this;
    }

    /**
     * Validar conteúdo do campo CPF se a entrada tiver sido em branco
     * O conteúdo deverá ser em branco
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Informar CPF incorreto")
    public LoginContingenciaTela validarConteudoCpfQuandoEntradaAlfabetica(String cpf) throws Exception {

        if (!cpf.matches("[a-zA-Z]+")) // se todos os caracteres forem alfabéticos
            return this;
        clicarElemento(tituloLogin, "Não foi possível desfocar do campo de documento CPF");
        validarAtributoTexto(elementoCpf, "", "Não foi possível validar que o conteúdo está em branco.");
        return this;
    }


    /**
     * Validar mensagem de erro na validação do CPF/CNPJ
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Validar menssagem de erro da validação do CPF/CNPJ")
    public LoginContingenciaTela validarMensagemErroValidacaoCpf(String menssagemErro) throws Exception {
        validarAtributoTexto(labelCpfErro, menssagemErro, "Não foi possível validar menssagem de erro campo cpf: " + menssagemErro);
        salvarEvidencia("Validado menssagem de erro validação cpf igual a: " + menssagemErro);
        return this;
    }

    /**
     * Refrescar a tela de login da web
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Validar menssagem de erro da validação do CPF/CNPJ")
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
     * Clicar no botão 'Continuar'
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Clicar Continuar")
    public LoginContingenciaTela clicarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(elementoCpf);
        aguardarCarregamentoElemento(botaoContinuar);
        clicarElemento(botaoContinuar, "Não foi possível clicar em \"Continuar\"");
        return this;
    }

    /**
     * Aguardar até que o QR Code esteja expirado
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Esperar até que o QR Code esteja expirado")
    public LoginContingenciaTela aguardarExpiracaoQrCode(int tempoMaxExpiracaoQrCode) throws Exception {
        long inicio = System.currentTimeMillis();
        List<WebElement> listQrCodeExpirado = null;
        do  {
            listQrCodeExpirado = retornarLista(By.id("buttonReloadQRCode"), "Não foi possível localizar o QR Code expirado");
            //* Estamos dando tempoMaxExpiracaoQrCode segundos de máximo para que a validação ocorra
            Thread.sleep(1000);
        } while (listQrCodeExpirado.size() < 1 &&
                System.currentTimeMillis() - inicio < tempoMaxExpiracaoQrCode * 1000);

        validarCondicaoBooleana(listQrCodeExpirado.size() > 0,
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível determinar que o QR Code expirou.");
        salvarEvidencia("O QR Code foi expirado.");
        return this;
    }

    /**
     * Validar tempo de expiração do QR Code
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Validar tempo de expiração do QR Code recente")
    public LoginContingenciaTela validarTempoExpiracaoQRCodeRecente(int tempo) throws Exception {
        /*
        Devido a delays de sincronização com a página,
        o tempo a ser validado não pode ser exatamente igual ao tempo esperado.
        O parâmetro de tempo deve ter um período de graça (concessão) contido.
        Por exemplo, se o tempo esperado real na página é de 60 segundos,
        o parâmetro aqui recebido poderia ser de 65 segundos (com margem de tolerância)
         */

        aguardarCarregamentoElemento(qrCodeImg);
        long inicio = System.currentTimeMillis();
        OperadorEvidencia.logarPasso("Validando tempo de expiração do QR Code em até " + tempo + " segundos.");
        boolean qrCodeExpiradoEncontrado = false;
        List<WebElement> listQrCodeExpirado = null;
        while (System.currentTimeMillis() - inicio < 1.2 * tempo * 1000) {
            /*
            Estamos dando 20% a mais de tempo para que a validação ocorra
            Esse tempo é para, em caso de problemas na página ou bug,
            o teste não ficar parado indefinidamente.
            Obviamente, se tudo estiver bem, a expiração ocorrerá em até 'tempo' segundos
            aproximadamente.
             */
            listQrCodeExpirado = retornarLista(By.id("buttonReloadQRCode"), "Não foi possível encontrar o QR Code expirado");
            if (listQrCodeExpirado.size() > 0) {
                qrCodeExpiradoEncontrado = true;
                break;
                /*
                Trabalhar com este booleano evita checar o elemento na página
                em passo posterior, porque após isto o acesso do webdriver
                na página passa a ficar muito lento.
                 */
            }

            Thread.sleep(1000);
        }
        long tempoMedido = (System.currentTimeMillis() - inicio) / 1000;

        validarCondicaoBooleana(qrCodeExpiradoEncontrado,
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível determinar que o QR Code expirou.");

        validarCondicaoBooleana(tempoMedido <= tempo,
                MetodoComparacaoBooleano.VERDADEIRO,
                "O tempo de expiração foi superior ao esperado.\n" +
                        "Tempo esperado (até): " + tempo + ". Tempo medido: " + tempoMedido);
        salvarEvidencia("O tempo máximo de expiração do QR Code foi validado OK: " + tempoMedido + " segundos.\n" +
                "O tempo máximo esperado é de " + tempo + " segundos.\n" +
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
        O clique padrão do Selenium esteve um tanto demorado,
        razão pela qual utilizamos Javascript
         */
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].click();", qrCodeExpirado);
        return this;
    }

    /**
     * Validar a presença do QR Code recém-criado (não expirado)
     *
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Renovar QR Code")
    public LoginContingenciaTela validarQrCodePresente() throws Exception {
        for(int i = 0; i < 3; i++) if(aguardarCarregamentoElemento(qrCodeImg)) break;
        validarCondicaoBooleana(aguardarCarregamentoElemento(qrCodeImg), MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar que o QR Code está presente na tela.");
        aguardarCarregamentoDaPagina(driver);
        salvarEvidencia("Validação de QR Code presente na tela");
        return this;
    }

    /**
     * Fazer leitura do QR Code
     * Este método utiliza o atributo SRC para obter a string base64
     * equivalente à imagem do QR Code, mas também pode ser modificado
     * para utilizar o método de screenshot
     * Ambos estabilizam o QR Code antes de realizar a leitura:
     * 1. Ou esperando que se estabilizem o número de bytes lidos do SRC
     * 2. Ou esperando que a imagem do QR Code pare de se deslocar na tela,
     * para a realização de um screenshot estabilizado.
     *
     * @throws Exception
     * @return String
     */
    @Step("Efetuar leitura do QR Code")
    public String lerQRCode() throws Exception {
        /*
        Pode escolher entre:
        getImagemBase64Header -> obtém o SRC do elemento
        getBufferedImageScreenshot -> obtém primeiro o screenshot via Selenium
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
     * Navegar para a página de login da Contingência Web
     * A url foi definida em parâmetro de execução do XML no TestNG,
     * razão pela qual obtemos esse parâmetro previamente na classe do teste e o
     * passamos neste método.
     *
     * @param url
     * @throws Exception
     * @return LoginContingenciaTela
     */
    @Step("Navegar para página inicial do login da Contingência Web")
    public LoginContingenciaTela navegar(String url) throws Exception {
        getWebDriver().get(url);
        return this;
    }

    /**
     * Salvar print da página ao abrir uma nova guia na página de login da contingência.
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
     * Salvar print da página ao abrir uma nova guia na página de login da contingência.
     *
     * @return LoginContingenciaTela
     */
    @Step("Salvar evidencia nova guia aberta")
    public LoginContingenciaTela salvarEvidenciaAlternarAbas() {
        salvarEvidencia("Alternar aba");
        return this;


    }
}
