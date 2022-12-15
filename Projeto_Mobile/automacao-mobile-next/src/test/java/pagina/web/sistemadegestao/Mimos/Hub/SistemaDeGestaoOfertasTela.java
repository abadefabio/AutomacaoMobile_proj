package pagina.web.sistemadegestao.Mimos.Hub;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import constantes.mimos.web.ValoresPadraoPreenchimento;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Date;

import static br.com.next.automacao.core.tools.Utilitarios.pegarDataAtualEpoch;
import static br.com.next.automacao.core.tools.Utilitarios.proximoDiaUtil;

public class SistemaDeGestaoOfertasTela extends PaginaBaseWeb {

    private static ThreadLocal<String> valorDataEHoraAltual = new ThreadLocal<>();

    public static ThreadLocal<String> valorNomeOferta = new ThreadLocal<>();

    public static ThreadLocal<String> valorIDOferta = new ThreadLocal<>();

    @FindBy(id = "formCadastro:inputValidoAte")
    private WebElement campoValidoAte;

    @FindBy(id = "formCadastro:inputDataHoraInicio")
    private WebElement campoDataEHoraInicio;

    @FindBy(xpath = "//a[contains(.,\"Alterar\")]")
    private WebElement botaoAlterar;

    @FindBy(xpath = "//button[.=\"Sim\"]")
    private WebElement botaoSim;

    @FindBy(xpath = "//button[.=\"OK\"]")
    private WebElement botaoOk;

    @FindBy(xpath = "//a[contains(. ,\"Aprovar\")]")
    private WebElement botaoAprovar;

    @FindBy(xpath = "//i[.=\" Cadastrar\"]/parent::a")
    private WebElement botaoMaisCadastrar;

    @FindBy(xpath = "//select[@id = \"formFilter:comboboxStatus\"]")
    private WebElement comboboxStatus;

    @FindBy(xpath = "//input[@value=\"Consultar\"]")
    private WebElement botaoConsultar;

    @FindBy(id = "formCadastro:nomeOferta")
    private WebElement campoNomeOferta;

    @FindBy(id = "formCadastro:comboCategoria")
    private WebElement comboboxCategoria;

    @FindBy(id = "formCadastro:comboParceiro")
    private WebElement comboboxParceiro;

    @FindBy(id = "formCadastro:textoTopo")
    private WebElement campoTexto;

    @FindBy(css = "div[class=\"fileUpload btn\"]")
    private WebElement botaoSelecionarArquivoImagem;

    @FindBy(id = "formCadastro:valorBeneficioTodos")
    private WebElement campoBeneficio;

    @FindBy(id = "formCadastro:comboTpConcessao")
    private WebElement comboboxFormaDePagamento;

    @FindBy(id = "formCadastro:regrasDeUso")
    private WebElement campoComoUsar;

    @FindBy(xpath = "//label[contains(.,\"Base de voucher\")]/span[@class = \"circle\"]")
    private WebElement radioButtonBaseDeVoucher;

    @FindBy(xpath = "//label[contains(.,\"Cupom �nico\")]/span[@class = \"circle\"]")
    private WebElement radioButtonCupomUnico;

    @FindBy(id = "formCadastro:botaoApp")
    private WebElement campoTituloBotao;

    @FindBy(xpath = "//a[contains(.,\"Cadastrar\")]")
    private WebElement botaoCadastrar;

    @FindBy(xpath = "//p[contains(.,\"Banner\")]/following-sibling::div/div/div/div/input")
    private WebElement botaoSelecionarArquivoImagemBaseVoucher;

    @FindBy(id = "formCadastro:comboQtdVoucherPorCpf")
    private WebElement comboboxVoucherPorCPF;

    @FindBy(css = "input[type=\"file\"][name=\"UIFileUpload_formCadastro:upload_csv\"]")
    private WebElement botaoSelecionarArquivoCSV;

    @FindBy(id = "formCadastro:j_idt80")
    private WebElement campoVoucherValidoAte;

    @FindBy(xpath = "//span[text() = '100%']")
    private WebElement iconeProcessamentoVoucher;

    @FindBy(xpath = "//a[contains(.,\"Sair\")]")
    private WebElement botaoSair;

    @FindBy(id = "formCadastro:linkSite")
    private WebElement campoURLSite;

    @FindBy(xpath = "//a[contains(.,\"Ativar\")]")
    private WebElement botaoAtivar;

    @FindBy(xpath = "//label[contains(.,\"App\")]/span[@class = \"circle\"]")
    private WebElement radioButtonApp;

    @FindBy(id = "formCadastro:linkAndroid")
    private WebElement campoAndroidApp;

    @FindBy(id = "formCadastro:linkIosApp")
    private WebElement campoIOSAPP;

    @FindBy(id = "formCadastro:linkIosSchema")
    private WebElement campoIOSSchema;

    @FindBy(id = "formCadastro:idOferta")
    private WebElement campoIDOferta;

    @FindBy(xpath = "//a[contains(.,\"Desativar\")]")
    private WebElement botaoDesativar;

    public SistemaDeGestaoOfertasTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicar bot�o editar da oferta
     *
     * @param idOferta
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar bot�o editar da oferta")
    public SistemaDeGestaoOfertasTela clicarBotaoEditarOferta(String idOferta) throws Exception{
        try{
            tentarClicarBotaoEditarOferta(idOferta);
        }catch (AssertionError e){
            tentarClicarBotaoEditarOferta(idOferta);
        }
        return this;
    }

    /**
     * Clicar bot�o editar da oferta
     *
     * @param idOferta
     * @throws Exception
     */
    @Step("Clicar bot�o editar da oferta")
    public void tentarClicarBotaoEditarOferta(String idOferta) throws Exception{
        By botaoEditarOferta = By.xpath("//span[contains(. ,'"+idOferta+"')]/parent::td/following-sibling::td/a[@title='Editar']");
        aguardarCarregamentoElemento(botaoEditarOferta);
        rolarAteElemento(botaoEditarOferta, "N�o foi poss�vel rolar at� bot�o Editar oferta");
        salvarEvidencia("Visualizar oferta com id: '"+idOferta+"'");
        clicarElemento(botaoEditarOferta, "N�o foi poss�vel clicar em editar oferta");
        if(!aguardarCarregamentoElemento(campoIDOferta)){
            throw new AssertionError("O sistema n�o carregou o campo 'ID Oferta'");
        }
        salvarEvidencia("Clicar bot�o editar da oferta '"+valorNomeOferta.get()+"' com id: '"+idOferta+"'");
    }

    /**
     * Clicar bot�o editar da oferta
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar bot�o editar da oferta")
    public SistemaDeGestaoOfertasTela clicarBotaoEditarOferta() throws Exception{
        By botaoEditarOferta = By.xpath("//span[contains(. ,'"+valorIDOferta.get()+"')]/parent::td/following-sibling::td/a[@title='Editar']");
        aguardarCarregamentoElemento(botaoEditarOferta);
        rolarAteElemento(botaoEditarOferta, "N�o foi poss�vel rolar at� bot�o Editar oferta");
        clicarElemento(botaoEditarOferta, "N�o foi poss�vel clicar em editar oferta");
        salvarEvidencia("Clicar bot�o editar da oferta: '"+valorNomeOferta.get()+"' com id: '"+valorIDOferta.get()+"'");
        return this;
    }

    /**
     * Clicar bot�o editando da oferta
     *
     * @param oferta
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar bot�o editando da oferta")
    public SistemaDeGestaoOfertasTela clicarBotaoEditandoOferta(String oferta) throws Exception{
        By botaoEditandoOferta = By.xpath("//span[contains(. ,\"" + oferta + "\")]/parent::td/following-sibling::td/a/img[contains(@src, \"editando.png\")]/parent::a");
        aguardarCarregamentoElemento(botaoEditandoOferta);
        rolarAteElemento(botaoEditandoOferta, "N�o foi poss�vel rolar at� bot�o Editar oferta");
        salvarEvidencia("Visualizar oferta: \"" + oferta + "\"");
        clicarElemento(botaoEditandoOferta, "N�o foi poss�vel clicar em editar oferta");
        salvarEvidencia("Clicar bot�o editar da oferta: \"" + oferta + "\"");
        return this;
    }

    /**
     * Apagar campo valido At� em cadastrar oferta
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Apagar Campo \"Valido At�\"")
    public SistemaDeGestaoOfertasTela apagarCampoValidoAte() throws Exception{
        aguardarCarregamentoElemento(campoValidoAte);
        rolarAteElemento(campoValidoAte, "N�o foi poss�vel rolar at� campo 'Valido At�'");
        salvarEvidencia("Visulizar o campo 'Valido At�'");
        apagarCampoTexto(campoValidoAte,"N�o foi poss�vel apagar o campo Valido At�");
        return this;
    }

    /**
     * Preencher campo Data e Hora Inicial  com valor de data e hora atual acrescido de 2minutos em cadastrar oferta
     * Realiza chamado do m�todo: retornarDataEHoraAtualMaisDoisMin()
     * Formato: "dd/MM/yyyy HH:mm + 2 min"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Data e Hora Inicial\" com data e hora atual mais dois minutos")
    public SistemaDeGestaoOfertasTela preencherCampoDataEHoraInicComDataAtualMaisDoisMin() throws Exception{
        aguardarCarregamentoElemento(campoDataEHoraInicio);
        rolarAteElemento(campoDataEHoraInicio, "N�o foi poss�vel rolar at� campo 'Data e Hora In�cio'");
        String DataEHoraAtualMaisDoisMin = retornarDataEHoraAtualMaisDoisMin();
        digitarTexto(campoDataEHoraInicio, DataEHoraAtualMaisDoisMin ,"N�o foi poss�vel preencher o campo Data e Hora In�cio");
        salvarEvidencia("Preencher campo 'Data e Hora In�cio' com: " + DataEHoraAtualMaisDoisMin);
        return this;
    }

    /**
     * Preencher campo valido At�  com valor de data  acrescida de 2dias e hora atual em cadastrar oferta
     * Realiza chamado do m�todo: retornarDataEHoraAtualMaisDoisDias()
     * Formato: "dd + 2dias/MM/yyyy HH:mm"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"ValidoAte\" com data e hora atual mais dois dias")
    public SistemaDeGestaoOfertasTela preencherCampoValidoAteComDataAtualMaisDoisDias() throws Exception{
        aguardarCarregamentoElemento(campoValidoAte);
        rolarAteElemento(campoValidoAte, "N�o foi poss�vel rolar at� campo 'Valido At�'");
        String DataEHoraAtualMaisDoisDias = retornarDataEHoraAtualMaisDoisDias();
        digitarTexto(campoValidoAte, DataEHoraAtualMaisDoisDias ,"N�o foi poss�vel preencher o campo Valido At�");
        salvarEvidencia("Preencher campo 'Valido At�' com: " + DataEHoraAtualMaisDoisDias);
        return this;
    }

    /**
     * Preencher campo valido At�  com valor de data e hora atual acrescido de 2minutos em cadastrar oferta
     * Realiza chamado dos m�todos: carregarDataEHoraAtual() e retornarDataEHoraAtualMaisDoisMin()
     * Formato: "dd/MM/yyyy HH:mm + 2 min"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Vatido At�\" com data e hora atual mais dois minutos")
    public SistemaDeGestaoOfertasTela preencherCampoValidoAteComHoraAtualMaisDoisMin() throws Exception{
        aguardarCarregamentoElemento(campoValidoAte);
        rolarAteElemento(campoValidoAte, "N�o foi poss�vel rolar at� campo 'Valido At�'");
        carregarDataEHoraAtual();
        digitarTexto(campoValidoAte, retornarDataEHoraAtualMaisDoisMin(),"N�o foi poss�vel preencher o campo Valido At�");
        salvarEvidencia("Preencher campo 'Valido At�' com hora atual mais dois minutos");
        return this;
    }

    /**
     * Armazena o valor da data e hora atual do sistema em uma vari�vel est�tica
     * Formato: "dd/MM/yyyy HH:mm"
     *
     * @return SistemaDeGestaoOfertasTela
     */
    public SistemaDeGestaoOfertasTela carregarDataEHoraAtual(){
        String dataEHoraAtual = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
        valorDataEHoraAltual.set(dataEHoraAtual);
        return this;
    }

    /**
     * Retorna uma String com data atual do sistema e hora atual do sistema acrescida de 2 min
     * "dd/MM/yyyy HH:mm + 2 min"
     *
     *
     * @return String: timeStamp com dia atual e hora atual mais dois minutos
     */
    private String retornarDataEHoraAtualMaisDoisMin(){
        String dataAtual = valorDataEHoraAltual.get().substring(0,10);
        String horaAtual = valorDataEHoraAltual.get().substring(10,13);
        String minutoAtualMaisDois = String.valueOf(Integer.parseInt(valorDataEHoraAltual.get().substring(14,16)) + 2);
        return dataAtual + horaAtual + ":" + minutoAtualMaisDois;
    }

    /**
     * Retorna uma String com data atual do sistema acrescida de dois dias e hora atual do sistema
     * Obs: No m�todo ainda n�o est� implementado tratamento especial quando dia 29, 30 ou 31 ou dia 27/02, 28/02 e 29/02
     * "dd + 2dias/MM/yyyy HH:mm"
     *
     * @return String: timeStamp com dia atual mais dois e hora atual
     */
    private String retornarDataEHoraAtualMaisDoisDias(){
        String diaAtualMaisDois = String.valueOf(Integer.parseInt(valorDataEHoraAltual.get().substring(0,2)) + 2);
        String mesAnoAtual = valorDataEHoraAltual.get().substring(2,10);
        String horaAtual = valorDataEHoraAltual.get().substring(10,16);
        return diaAtualMaisDois + mesAnoAtual + horaAtual;
    }

    /**
     * Clicar no bot�o "Alterar"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar bot�o \"Alterar\"")
    public SistemaDeGestaoOfertasTela clicarBotaoAlterar() throws Exception{
        aguardarCarregamentoElemento(botaoAlterar);
        rolarAteElemento(botaoAlterar, "N�o foi poss�vel rolar at� o bot�o 'Alterar'");
        salvarEvidencia("Visualizar bot�o 'Alterar'");
        clicarElemento(botaoAlterar,"N�o foi poss�vel clicar no bot�o 'Alterar'");
        salvarEvidencia("Clicar no bot�o 'Alterar'");
        return this;
    }

    /**
     * Clicar no bot�o Sim
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar bot�o \"Sim\"")
    public SistemaDeGestaoOfertasTela clicarBotaoSim() throws Exception{
        aguardarCarregamentoElemento(botaoSim);
        salvarEvidencia("Visualizar bot�o 'Sim'");
        clicarElemento(botaoSim,"N�o foi poss�vel clicar no bot�o 'Sim'");
        return this;
    }

    /**
     * Clicar no bot�o "OK"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar bot�o \"OK\"")
    public SistemaDeGestaoOfertasTela clicarBotaoOK() throws Exception{
        aguardarCarregamentoElemento(botaoOk);
        rolarAteElemento(botaoOk, "N�o foi poss�vel rolar at� o bot�o 'OK'");
        salvarEvidencia("Visualizar bot�o 'OK'");
        clicarElemento(botaoOk,"N�o foi poss�vel clicar no bot�o 'OK'");
        salvarEvidencia("Clicar no bot�o 'OK'");
        return this;
    }

    /**
     * Clicar no bot�o Aprovar
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar bot�o \"Aprovar\"")
    public SistemaDeGestaoOfertasTela clicarBotaoAprovar() throws Exception{
        aguardarCarregamentoElemento(botaoAprovar);
        rolarAteElemento(botaoAprovar, "N�o foi poss�vel rolar at� o bot�o 'Aprovar'");
        salvarEvidencia("Visualizar bot�o 'Aprovar'");
        clicarElemento(botaoAprovar,"N�o foi poss�vel clicar no bot�o 'Aprovar'");
        salvarEvidencia("Clicar no bot�o 'Aprovar'");
        return this;
    }

    /**
     * Clicar no bot�o "Excluir"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    public SistemaDeGestaoOfertasTela clicarBotaoExcluirOferta(String idOferta) throws Exception {
        By botaoEditarOferta = By.xpath("//span[contains(. ,'"+idOferta+"')]/parent::td/following-sibling::td/a[@title= 'Excluir']/Img");
        rolarAteElemento(botaoEditarOferta, "N�o foi poss�vel rolar at� bot�o Excluir oferta");
        salvarEvidencia("Visualizar oferta com id: '"+idOferta+"'");
        clicarElemento(botaoEditarOferta, "N�o foi poss�vel clicar em excluir oferta");
        salvarEvidencia("Clicar bot�o Excluir da oferta '"+valorNomeOferta.get()+"' com id '"+idOferta+"'");
        return this;
    }

    /**
     * Clicar no bot�o Cadastrar
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Cocar bot�o \"+Cadastrar\"")
    public SistemaDeGestaoOfertasTela clicarBotaoMaisCadastrar() throws Exception{
        //Durante a execu��o do m�todo percebeu-se que as vezes o m�todo desliza at� o elemento e clica nele antes
        //de finalizar o carregamento da tela, o que pode quebrar o teste. Ao inv�s de utilizar um m�todo do tipo threadSleep,
        //optou-se pela implementa��o dos blocos try, catch, para reexecutar a a��o de deslizar at� o elemento e clicar nele
        //quando a instabilidade acontecer na tela
        try{
            tentarClicarBotaoMaisCadastrarRolandoAteEle();
        }catch(AssertionError e){
            tentarClicarBotaoMaisCadastrarRolandoAteEle();
        }
        return this;
    }

    /**
     * Realiza a��o de clicar no bot�o "+Cadastrar"
     *
     * @throws Exception
     */
    private void tentarClicarBotaoMaisCadastrarRolandoAteEle() throws Exception{
        aguardarCarregamentoElemento(botaoMaisCadastrar);
        rolarAteElemento(botaoMaisCadastrar, "N�o foi poss�vel rolar at� elemento \"+Cadastrar\"");
        salvarEvidencia("Visualizar bot�o \"+Cadastrar\"");
        clicarElemento(botaoMaisCadastrar, "N�o foi poss�vel clicar no bot�o \"+Cadastrar\"");
        if(!aguardarCarregamentoElemento(campoNomeOferta)){
            throw new AssertionError("Elemento campo \"Nome Oferta\" n�o foi carregado");
        }
        salvarEvidencia("Clicar bot�o \"+Cadastrar\"");
    }

    /**
     * Preemcher campo com nome da oferta com valor Aleat�rio
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Nome Oferta\"")
    public SistemaDeGestaoOfertasTela preencherCampoNomeOferta() throws Exception{
        preencherCampoNomeOferta("NOME " + pegarDataAtualEpoch());
        return this;
    }

    /**
     * Preemcher campo com nome da oferta
     *
     * @param nomeOferta
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Nome Oferta\"")
    public SistemaDeGestaoOfertasTela preencherCampoNomeOferta(String nomeOferta) throws Exception{
        aguardarCarregamentoElemento(campoNomeOferta);
        digitarTexto(campoNomeOferta,nomeOferta ,"N�o foi poss�vel preencher campo Nome Oferta");
        valorNomeOferta.set(nomeOferta);
        salvarEvidencia("Preencher campo \"Nome Oferta\" com: "+ valorNomeOferta.get());
        return this;
    }

    /**
     * Selecionar categoria desejada para a oferta em combobox
     *
     * @param categoria
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Selecionar Categoria em \"Combobox\"")
    public SistemaDeGestaoOfertasTela selecionarCategoriaCombobox(String categoria) throws Exception{
        aguardarCarregamentoElemento(comboboxCategoria);
        rolarAteElemento(comboboxCategoria,"N�o foi poss�vel rolar a tela at� combobox \"Categoria\"");
        clicarElemento(comboboxCategoria, "N�o foi poss�vel clicar no elemento do combobox");
        clicarElemento(comboboxCategoria.findElement(By.xpath("//option[contains(.,\""+ categoria +"\")]")),"N�o foi poss�vel selecionar a op��o \"" + categoria + "\" no cobobox \"Categoria\"");
        salvarEvidencia("Selecionar \""+ categoria +"\" em Combobox \"Categoria\"");
        return this;
    }

    /**
     * Selecionar parceiro desejado para a oferta em combobox
     *
     * @param parceiro
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Selecionar Parceiro em \"Combobox\"")
    public SistemaDeGestaoOfertasTela selecionarParceiroCombobox(String parceiro) throws Exception{
        aguardarCarregamentoElemento(comboboxParceiro);
        rolarAteElemento(comboboxParceiro,"N�o foi poss�vel rolar a tela at� combobox \"Parceiro\"");
        clicarElemento(comboboxParceiro, "N�o foi poss�vel clicar no elemento do combobox");
        clicarElemento(comboboxParceiro.findElement(By.xpath("//option[contains(.,\""+ parceiro +"\")]")),"N�o foi poss�vel selecionar a op��o \"" + parceiro + "\" no cobobox \"Parceiro\"");
        salvarEvidencia("Selecionar \""+ parceiro +"\" em Combobox \"Parceiro\"");
        return this;
    }


    /**
     * Preencher campo Texto
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Texto\"")
    public SistemaDeGestaoOfertasTela preencherCampoTexto() throws Exception{
        preencherCampoTexto(ValoresPadraoPreenchimento.CAMPO_TEXTO.toString());
        return this;
    }

    /**
     * Preencher campo Texto
     *
     * @param texto
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Texto\"")
    public SistemaDeGestaoOfertasTela preencherCampoTexto(String texto) throws Exception{
        aguardarCarregamentoElemento(campoTexto);
        rolarAteElemento(campoTexto, "N�o foi possivel rolar tela at� \"Campo Texto\"");
        digitarTexto(campoTexto, texto ,"N�o foi poss�vel preencher campo Texto");
        salvarEvidencia("Preencher campo \"Texto\" com: "+ texto);
        return this;
    }

    /**
     * M�todo realiza upload de arquivo de imagem, enviando caminho para o arquivo no elemento input type="file"
     *
     * @param pathArquivoImagem
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Fazer upload de arquivo de imagem")
    public SistemaDeGestaoOfertasTela fazerUploadArquivoImagem(String pathArquivoImagem) throws Exception{
        aguardarCarregamentoElemento(botaoSelecionarArquivoImagem);
        rolarAteElemento(botaoSelecionarArquivoImagem, "N�o foi poss�vel rolar at� bot�o de upload");
        //O m�todo sendKeys foi utilizado diretamente aqui, pois o teste est� lan�ando uma exce��o ao preencher o campo
        //pela implementa��o do m�todo digitarTexto().
        botaoSelecionarArquivoImagem.findElement(By.cssSelector("input[type=\"file\"]")).sendKeys(lerArquivo(pathArquivoImagem));
        salvarEvidencia("Fazer upload de arquivo de imagem");
        return this;
    }

    /**
     * M�todo realiza upload de arquivo de imagem, enviando caminho para o arquivo no elemento input type="file"
     *
     * @param pathArquivoImagem
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Fazer upload de arquivo de imagem")
    public SistemaDeGestaoOfertasTela fazerUploadArquivoImagemVoucher(String pathArquivoImagem) throws Exception{
        aguardarCarregamentoElemento(botaoSelecionarArquivoImagemBaseVoucher);
        rolarAteElemento(botaoSelecionarArquivoImagemBaseVoucher, "N�o foi poss�vel rolar at� bot�o de upload");
        //O m�todo sendKeys foi utilizado diretamente aqui, pois o teste est� lan�ando uma exce��o ao preencher o campo
        //pela implementa��o do m�todo digitarTexto().
        botaoSelecionarArquivoImagemBaseVoucher.sendKeys(lerArquivo(pathArquivoImagem));
        salvarEvidencia("Fazer upload de arquivo de imagem");
        return this;
    }

    /**
     * M�todo realiza upload de arquivo csv, enviando caminho para o arquivo no elemento input type="file"
     *
     * @param pathArquivoVoucher
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Fazer upload de arquivo csv")
    public SistemaDeGestaoOfertasTela fazerUploadArquivoVoucher(String pathArquivoVoucher) throws Exception{
        aguardarCarregamentoElemento(botaoSelecionarArquivoCSV);
        rolarAteElemento(botaoSelecionarArquivoCSV, "N�o foi poss�vel rolar at� bot�o de upload");
        //O m�todo sendKeys foi utilizado diretamente aqui, pois o teste est� lan�ando uma exce��o ao preencher o campo
        //pela implementa��o do m�todo digitarTexto().
        botaoSelecionarArquivoCSV.sendKeys(lerArquivo(pathArquivoVoucher));
        salvarEvidencia("Fazer upload de arquivo");
        return this;
    }

    /**
     * Preencher campo Benef�cio
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Benef�cio\"")
    public SistemaDeGestaoOfertasTela preencherCampoBeneficio() throws Exception{
        preencherCampoBeneficio(ValoresPadraoPreenchimento.CAMPO_BENEFICIO.toString());
        return this;
    }

    /**
     * Preencher campo Benef�cio
     *
     * @param beneficio
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Benef�cio\"")
    public SistemaDeGestaoOfertasTela preencherCampoBeneficio(String beneficio) throws Exception{
        aguardarCarregamentoElemento(campoBeneficio);
        rolarAteElemento(campoBeneficio, "N�o foi possivel rolar tela at� \"Benef�cio\"");
        digitarTexto(campoBeneficio, beneficio ,"N�o foi poss�vel preencher campo Bef�cio");
        salvarEvidencia("Preencher campo \"Beneficio\" com: "+ beneficio);
        return this;
    }

    /**
     * Selecionar Forma de Pagamento desejado em combobox
     *
     * @param formaDePagamento
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Selecionar Combobox com \"Forma de Pagamento\"")
    public SistemaDeGestaoOfertasTela selecionarFormaPagamentoComboBox(String formaDePagamento) throws Exception{
        aguardarCarregamentoElemento(comboboxFormaDePagamento);
        rolarAteElemento(comboboxFormaDePagamento,"N�o foi poss�vel rolar a tela at� combobox \"Forma de Pagamento\"");
        clicarElemento(comboboxFormaDePagamento.findElement(By.xpath("//option[contains(@value,\""+ formaDePagamento +"\")]")),"N�o foi poss�vel selecionar a op��o \"" + formaDePagamento + "\" no cobobox \"Forma de Pagamento\"");
        salvarEvidencia("Selecionar \""+ formaDePagamento +"\" em Combobox \"Forma de Pagamento\"");
        return this;
    }

    /**
     * Preencher campo "Como Usar"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Como Usar\"")
    public SistemaDeGestaoOfertasTela preencherCampoComoUsar() throws Exception{
        preencherCampoComoUsar(ValoresPadraoPreenchimento.CAMPO_COMO_USAR.toString());
        return this;
    }

    /**
     * Preencher campo "Como Usar"
     *
     * @param comoUsar
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Como Usar\"")
    public SistemaDeGestaoOfertasTela preencherCampoComoUsar(String comoUsar) throws Exception{
        aguardarCarregamentoElemento(campoComoUsar);
        rolarAteElemento(campoComoUsar, "N�o foi possivel rolar tela at� \"Como Usar\"");
        digitarTexto(campoComoUsar, comoUsar ,"N�o foi poss�vel preencher campo Como Usar");
        salvarEvidencia("Preencher campo \"Como Usar\" com: "+ comoUsar);
        return this;
    }

    /**
     * Selecionar Radio-button "Base de Voucher"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Selecionar radio-button \"Base de Voucher\"")
    public SistemaDeGestaoOfertasTela selecionarRadioButtonBaseDeVoucher() throws Exception{
        aguardarCarregamentoElemento(radioButtonBaseDeVoucher);
        rolarAteElemento(radioButtonBaseDeVoucher, "N�o foi poss�vel rolar at� o radio-button \"Base de Voucher\"");
        clicarElemento(radioButtonBaseDeVoucher,"N�o foi poss�vel clicar no radio-button \"Base de Voucher\"");
        salvarEvidencia("Clicar no radio-button \"Base de Voucher\"");
        return this;
    }

    /**
     * Selecionar Radio-button "Cupom �nico/ sem cupom"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Selecionar radio-button \"Cupom ?nico / sem cupom\"")
    public SistemaDeGestaoOfertasTela selecionarRadioButtonCupomUnico() throws Exception{
        aguardarCarregamentoElemento(radioButtonCupomUnico);
        rolarAteElemento(radioButtonCupomUnico, "N�o foi poss�vel rolar at� o radio-button \"Cupom �nico / sem cupom\"");
        clicarElemento(radioButtonCupomUnico,"N�o foi poss�vel clicar no radio-button \"Cupom �nico / sem cupom\"");
        salvarEvidencia("Clicar no radio-button \"Cupom �nico / sem cupom\"");
        return this;
    }

    /**
     * Preencher campo "Nome Bot�o"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher nome bot�o")
    public SistemaDeGestaoOfertasTela preencherNomeBotao() throws Exception{
        preencherNomeBotao(ValoresPadraoPreenchimento.NOME_BOTAO.toString());
        return this;
    }

    /**
     * Preencher campo "Nome Bot�o"
     *
     * @param nomeBotao
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher nome bot�o")
    public SistemaDeGestaoOfertasTela preencherNomeBotao(String nomeBotao) throws Exception{
        aguardarCarregamentoElemento(campoTituloBotao);
        rolarAteElemento(campoTituloBotao, "N�o foi possivel rolar tela at� \"T�tulo Bot�o\"");
        digitarTexto(campoTituloBotao, nomeBotao ,"N�o foi poss�vel preencher campo Como Usar");
        salvarEvidencia("Preencher campo \"T�tulo Bot�o\" com: "+ nomeBotao);
        return this;
    }

    /**
     * Clicar Bot�o "Cadastrar"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar bot�o \"Cadastrar\"")
    public SistemaDeGestaoOfertasTela clicarBotaoCadastrar() throws Exception{
        aguardarCarregamentoElemento(botaoCadastrar);
        rolarAteElemento(botaoCadastrar, "N�o foi poss�vel rolar a tela at� o bot�o \"Cadastrar\"");
        salvarEvidencia("Clicar bot�o \"Cadastrar\"");
        clicarElemento(botaoCadastrar,"N�o foi poss�vel clicar bot�o \"Cadastrar\"");
        return this;
    }

    /**
     * Registrar ID gerado para oferta
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Registrar ID criado para a oferta")
    public SistemaDeGestaoOfertasTela registrarIDOferta() throws Exception{
        aguardarCarregamentoElemento(campoIDOferta);
        valorIDOferta.set(campoIDOferta.getAttribute("value"));
        salvarEvidencia("Oferta gerada com ID: " + valorIDOferta.get());
        return this;
    }

    /**
     * Preencher campo "Vadido At�" em cadastra Voucher
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Valido At�\"")
    public SistemaDeGestaoOfertasTela preencherCampoValidadeVoucher() throws Exception{
        String data = proximoDiaUtil(1);
        aguardarCarregamentoElemento(campoVoucherValidoAte);
        rolarAteElemento(campoVoucherValidoAte, "N�o foi possivel rolar tela at� \"V�lido At�\"");
        digitarTexto(campoVoucherValidoAte, data,"N�o foi poss�vel preencher campo \"V�lido At�\"");
        salvarEvidencia("Preencher campo \"V�lido At�\" com: "+ data);
        return this;
    }

    /**
     * Clicar bot�o "Sair"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar bot�o \"Sair\"")
    public SistemaDeGestaoOfertasTela clicarBotaoSair() throws Exception{
        aguardarCarregamentoElemento(botaoSair);
        rolarAteElemento(botaoSair, "N�o foi poss�vel rolar a tela at� o bot�o \"Sair\"");
        salvarEvidencia("Visualizar bot�o \"Sair\"");
        clicarElemento(botaoSair,"N�o foi poss�vel clicar bot�o \"Sair\"");
        salvarEvidencia("Clicar bot�o \"Sair\"");
        return this;
    }

    /**
     * Aguardar at� que o processamento esteja em 100%
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Aguardar Processamento 100%")
    public SistemaDeGestaoOfertasTela aguardarProcessamento() throws Exception{
        aguardarCarregamentoElemento(iconeProcessamentoVoucher);
        rolarAteElemento(iconeProcessamentoVoucher, "N�o foi poss�vel rolar at� processamento 100%");

        salvarEvidencia("Aguardar Processamento 100%");
        return this;
    }

    /**
     * Selecionar op��o "Inativo" em combobox "Status"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Selecionar \"Inativo\" em combobox \"Situa��o\"")
    public SistemaDeGestaoOfertasTela selecionarInativoEmComboboxSituacao() throws Exception{
        aguardarCarregamentoElemento(comboboxStatus);
        clicarElemento(comboboxStatus,"N�o foi Poss�vel abrir combobox Status");
        clicarElemento(comboboxStatus.findElement(By.xpath("//option[.=\"Inativo\"]")),"N�o foi poss�vel selecionar Inativo");
        salvarEvidencia("Selecionar op��o \"Inativo\" em combobox \"Situa��o\"");
        return this;
    }

    /**
     * Selecionar op��o "Ativo" em combobox "Status"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Selecionar \"Ativo\" em combobox \"Status\"")
    public SistemaDeGestaoOfertasTela selecionarAtivoEmComboboxSituacao() throws Exception{
        aguardarCarregamentoElemento(comboboxStatus);
        clicarElemento(comboboxStatus,"N�o foi Poss�vel abrir combobox Status");
        clicarElemento(comboboxStatus.findElement(By.xpath("//option[.=\"Ativo\"]")),"N�o foi poss�vel selecionar Ativo");
        salvarEvidencia("Selecionar op��o \"Ativo\" em combobox \"Status\"");
        return this;
    }

    /**
     * Validar que oferta foi inclu�da no sistema (Procurar por ID e Nome)
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Validar Oferta Cadastrada")
    public SistemaDeGestaoOfertasTela validarOfertaCadastradaPorID() throws Exception{
        if(verificarPresencaOfertaPorID()){
            salvarEvidencia("validar oferta \"" + valorNomeOferta.get() +"\" est� cadastrada com ID: " +  valorIDOferta.get());
        }else{
            throw new AssertionError("Resultado Esperado: Encontrar oferta - \""+ valorNomeOferta.get() + "\"; Resultado Obtido: \"Oferta n�o encontrada\"");
        }
        return this;
    }

    /**
     * M�todo retorna true se oferta encontrada e, false se n�o encontrada
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    private boolean verificarPresencaOfertaPorID() throws Exception{
        try{
            WebElement celulaOferta = retornaElemento(By.xpath("//span[.=\""+ valorIDOferta.get() +"\"]"));
            rolarAteElemento(celulaOferta, "Nao foi poss�vel rolar at� c�lula oferta");
            return true;
        }catch(AssertionError var){
            throw new NoSuchElementException(var.getMessage());
        }catch (org.openqa.selenium.NoSuchElementException var1){
            return false;
        }
    }

    /**
     * Validar que oferta foi inclu�da no sistema
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Validar Oferta Cadastrada")
    public SistemaDeGestaoOfertasTela validarOfertaCadastrada() throws Exception{
        if(verificarPresencaOferta()){
            salvarEvidencia("validar oferta \"" + valorNomeOferta.get() +"\" est� cadastrada");
        }else{
            throw new AssertionError("Resultado Esperado: Encontrar oferta - \""+ valorNomeOferta.get() + "\"; Resultado Obtido: \"Oferta n�o encontrada\"");
        }
        return this;
    }

    /**
     * Validar que oferta n�o est� exibida na lista de ofertas
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Validar Oferta N�o Cadastrada")
    public SistemaDeGestaoOfertasTela validarOfertaNaoCadastrada() {
        By idOferta = By.xpath("//span[.='"+ valorIDOferta.get() +"']");
        if(!aguardarExistenciaElemento(idOferta)){
            salvarEvidencia("validar oferta '"+valorNomeOferta.get()+"' com id '"+valorIDOferta.get()+"' n�o encontrada na lista");
        }else{
            throw new AssertionError("Resultado Esperado: N�o encontrada a oferta - '"+valorNomeOferta.get()+"' com id '"+valorIDOferta.get()+"'; Resultado Obtido: 'Oferta encontrada'");
        }
        return this;
    }

    /**
     * M�todo retorna true se oferta encontrada e, false se n�o encontrada
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    private boolean verificarPresencaOferta() throws Exception{
        try{
            By celulaOferta = By.xpath("//span[.=\""+ valorNomeOferta.get() +"\"]");
            rolarAteElemento(celulaOferta, "N�o foi poss�vel rolar at� c�lula oferta");
            return true;
        }catch(AssertionError var){
            return false;
        }
    }

    /**
     * Clicar no bot�o "Consultar"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar bot�o \"Consultar\"")
    public SistemaDeGestaoOfertasTela clicarBotaoConsultar() throws Exception{
        aguardarCarregamentoElemento(botaoConsultar);
        salvarEvidencia("Clicar bot�o \"Consultar\"");
        clicarElemento(botaoConsultar, "N�o foi poss�vel clicar no bot�o \"Consultar\"");
        return this;
    }

    /**
     * Selecionar quantidade de vouchers por CPF em combobox
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Selecionar combobox quantidade Voucher por CPF")
    public SistemaDeGestaoOfertasTela selecionarVoucherPorCPFCombobox() throws Exception{
        selecionarVoucherPorCPFCombobox(String.valueOf((Math.random() * 100.0D)));
        return this;
    }

    /**
     * Selecionar quantidade de vouchers por CPF em combobox
     *
     * @param quantidade
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Selecionar combobox quantidade Voucher por CPF")
    public SistemaDeGestaoOfertasTela selecionarVoucherPorCPFCombobox(String quantidade) throws Exception{
        aguardarCarregamentoElemento(comboboxVoucherPorCPF);
        rolarAteElemento(comboboxVoucherPorCPF,"N�o foi poss�vel rolar a tela at� combobox \"Vouchers por CPF\"");
        clicarElemento(comboboxVoucherPorCPF, "N�o foi poss�vel clicar no elemento do combobox");
        clicarElemento(comboboxVoucherPorCPF.findElement(By.xpath("//option[contains(.,\""+ quantidade +"\")]")),"N�o foi poss�vel selecionar a op��o \"" + quantidade + "\" no combobox \"Vouchers por CPF\"");
        salvarEvidencia("Selecionar \""+ quantidade +"\" em Combobox \"Vouchers por CPF\"");
        return this;
    }

    /**
     * Preencher campo "url site" com valor padr�o
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    public SistemaDeGestaoOfertasTela preencherCampoURLSite() throws Exception{
        preencherCampoURLSite(ValoresPadraoPreenchimento.URL_SITE.toString());
        return this;
    }

    /**
     * Preencher campo "url site"
     *
     * @param url
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    public SistemaDeGestaoOfertasTela preencherCampoURLSite(String url) throws Exception{
        aguardarCarregamentoElemento(campoURLSite);
        rolarAteElemento(campoURLSite, "N�o foi possivel rolar tela at� \"url site\"");
        digitarTexto(campoURLSite, url ,"N�o foi poss�vel preencher campo \"url site\"");
        salvarEvidencia("Preencher campo \"url site\" com: "+ url);
        return this;
    }

    /**
     * Clicar no bot�o "Ativar"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar bot�o \"Ativar\"")
    public SistemaDeGestaoOfertasTela clicarBotaoAtivar() throws Exception{
        aguardarCarregamentoElemento(botaoAtivar);
        rolarAteElemento(botaoAtivar, "Erro ao rolar tela at� elemento \"Ativar\"");
        salvarEvidencia("Visualizar bot�o \"Ativar\"");
        clicarElemento(botaoAtivar, "N�o foi poss�vel clicar no bot�o \"Ativar\"");
        salvarEvidencia("Clicou bot�o \"Ativar\"");
        return this;
    }

    /**
     * Clicar no bot�o "Desativar"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar bot�o \"Desativar\"")
    public SistemaDeGestaoOfertasTela clicarBotaoDesativar() throws Exception{
        aguardarCarregamentoElemento(botaoDesativar);
        rolarAteElemento(botaoDesativar, "N�o foi poss�vel rolar at� o bot�o 'Desativar'");
        salvarEvidencia("Visualizar bot�o 'Desativar'");
        clicarElemento(botaoDesativar,"N�o foi poss�vel clicar no bot�o 'Desativar'");
        salvarEvidencia("Clicar no bot�o 'Desativar'");
        return this;
    }

    /**
     * Selecionar radio-button "App"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    public SistemaDeGestaoOfertasTela selecionarRadioButtonApp() throws Exception{
        aguardarCarregamentoElemento(radioButtonApp);
        rolarAteElemento(radioButtonApp, "N�o foi poss�vel rolar at� o radio-button \"App\"");
        clicarElemento(radioButtonApp,"N�o foi poss�vel clicar no radio-button \"App\"");
        salvarEvidencia("Clicar no radio-button \"App\"");
        return this;
    }

    /**
     * Preencher campo "Android App"
     *
     * @param androidApp
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    public SistemaDeGestaoOfertasTela preencherCampoAndroidApp(String androidApp) throws Exception{
        aguardarCarregamentoElemento(campoAndroidApp);
        digitarTexto(campoAndroidApp,androidApp ,"N�o foi poss�vel preencher campo \"Android APP\"");
        salvarEvidencia("Preencher campo \"Android APP\" com: "+ androidApp);
        return this;
    }

    /**
     * Preencher campo "iOS APP"
     *
     * @param iOSApp
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    public SistemaDeGestaoOfertasTela preencherCampoiOSApp(String iOSApp) throws Exception{
        aguardarCarregamentoElemento(campoIOSAPP);
        digitarTexto(campoIOSAPP,iOSApp ,"N�o foi poss�vel preencher campo \"iOS APP\"");
        salvarEvidencia("Preencher campo \"iOS APP\" com: "+ iOSApp);
        return this;
    }

    /**
     * Preencher campo "iOS Schema"
     *
     * @param iOSSchema
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    public SistemaDeGestaoOfertasTela preencherCampoiOSSchema(String iOSSchema) throws Exception{
        aguardarCarregamentoElemento(campoIOSSchema);
        digitarTexto(campoIOSSchema,iOSSchema ,"N�o foi poss�vel preencher campo \"iOS Schema\"");
        salvarEvidencia("Preencher campo \"iOS Schema\" com: "+ iOSSchema);
        return this;
    }

    /**
     * Faz a leitura de um arquivo no diret�rio para upload no sistema de gest�o
     */
    public String lerArquivo (String pathArquivo){
        String filePath = System.getProperty("user.dir") + pathArquivo;
        return filePath;
    }
}
