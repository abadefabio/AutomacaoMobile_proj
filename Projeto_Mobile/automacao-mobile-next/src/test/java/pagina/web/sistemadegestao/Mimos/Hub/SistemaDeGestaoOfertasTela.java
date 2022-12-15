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

    @FindBy(xpath = "//label[contains(.,\"Cupom único\")]/span[@class = \"circle\"]")
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
     * Clicar botão editar da oferta
     *
     * @param idOferta
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar botão editar da oferta")
    public SistemaDeGestaoOfertasTela clicarBotaoEditarOferta(String idOferta) throws Exception{
        try{
            tentarClicarBotaoEditarOferta(idOferta);
        }catch (AssertionError e){
            tentarClicarBotaoEditarOferta(idOferta);
        }
        return this;
    }

    /**
     * Clicar botão editar da oferta
     *
     * @param idOferta
     * @throws Exception
     */
    @Step("Clicar botão editar da oferta")
    public void tentarClicarBotaoEditarOferta(String idOferta) throws Exception{
        By botaoEditarOferta = By.xpath("//span[contains(. ,'"+idOferta+"')]/parent::td/following-sibling::td/a[@title='Editar']");
        aguardarCarregamentoElemento(botaoEditarOferta);
        rolarAteElemento(botaoEditarOferta, "Não foi possível rolar até botão Editar oferta");
        salvarEvidencia("Visualizar oferta com id: '"+idOferta+"'");
        clicarElemento(botaoEditarOferta, "Não foi possível clicar em editar oferta");
        if(!aguardarCarregamentoElemento(campoIDOferta)){
            throw new AssertionError("O sistema não carregou o campo 'ID Oferta'");
        }
        salvarEvidencia("Clicar botão editar da oferta '"+valorNomeOferta.get()+"' com id: '"+idOferta+"'");
    }

    /**
     * Clicar botão editar da oferta
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar botão editar da oferta")
    public SistemaDeGestaoOfertasTela clicarBotaoEditarOferta() throws Exception{
        By botaoEditarOferta = By.xpath("//span[contains(. ,'"+valorIDOferta.get()+"')]/parent::td/following-sibling::td/a[@title='Editar']");
        aguardarCarregamentoElemento(botaoEditarOferta);
        rolarAteElemento(botaoEditarOferta, "Não foi possível rolar até botão Editar oferta");
        clicarElemento(botaoEditarOferta, "Não foi possível clicar em editar oferta");
        salvarEvidencia("Clicar botão editar da oferta: '"+valorNomeOferta.get()+"' com id: '"+valorIDOferta.get()+"'");
        return this;
    }

    /**
     * Clicar botão editando da oferta
     *
     * @param oferta
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar botão editando da oferta")
    public SistemaDeGestaoOfertasTela clicarBotaoEditandoOferta(String oferta) throws Exception{
        By botaoEditandoOferta = By.xpath("//span[contains(. ,\"" + oferta + "\")]/parent::td/following-sibling::td/a/img[contains(@src, \"editando.png\")]/parent::a");
        aguardarCarregamentoElemento(botaoEditandoOferta);
        rolarAteElemento(botaoEditandoOferta, "Não foi possível rolar até botão Editar oferta");
        salvarEvidencia("Visualizar oferta: \"" + oferta + "\"");
        clicarElemento(botaoEditandoOferta, "Não foi possível clicar em editar oferta");
        salvarEvidencia("Clicar botão editar da oferta: \"" + oferta + "\"");
        return this;
    }

    /**
     * Apagar campo valido Até em cadastrar oferta
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Apagar Campo \"Valido Até\"")
    public SistemaDeGestaoOfertasTela apagarCampoValidoAte() throws Exception{
        aguardarCarregamentoElemento(campoValidoAte);
        rolarAteElemento(campoValidoAte, "Não foi possível rolar até campo 'Valido Até'");
        salvarEvidencia("Visulizar o campo 'Valido Até'");
        apagarCampoTexto(campoValidoAte,"Não foi possível apagar o campo Valido Até");
        return this;
    }

    /**
     * Preencher campo Data e Hora Inicial  com valor de data e hora atual acrescido de 2minutos em cadastrar oferta
     * Realiza chamado do método: retornarDataEHoraAtualMaisDoisMin()
     * Formato: "dd/MM/yyyy HH:mm + 2 min"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Data e Hora Inicial\" com data e hora atual mais dois minutos")
    public SistemaDeGestaoOfertasTela preencherCampoDataEHoraInicComDataAtualMaisDoisMin() throws Exception{
        aguardarCarregamentoElemento(campoDataEHoraInicio);
        rolarAteElemento(campoDataEHoraInicio, "Não foi possível rolar até campo 'Data e Hora Início'");
        String DataEHoraAtualMaisDoisMin = retornarDataEHoraAtualMaisDoisMin();
        digitarTexto(campoDataEHoraInicio, DataEHoraAtualMaisDoisMin ,"Não foi possível preencher o campo Data e Hora Início");
        salvarEvidencia("Preencher campo 'Data e Hora Início' com: " + DataEHoraAtualMaisDoisMin);
        return this;
    }

    /**
     * Preencher campo valido Até  com valor de data  acrescida de 2dias e hora atual em cadastrar oferta
     * Realiza chamado do método: retornarDataEHoraAtualMaisDoisDias()
     * Formato: "dd + 2dias/MM/yyyy HH:mm"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"ValidoAte\" com data e hora atual mais dois dias")
    public SistemaDeGestaoOfertasTela preencherCampoValidoAteComDataAtualMaisDoisDias() throws Exception{
        aguardarCarregamentoElemento(campoValidoAte);
        rolarAteElemento(campoValidoAte, "Não foi possível rolar até campo 'Valido Até'");
        String DataEHoraAtualMaisDoisDias = retornarDataEHoraAtualMaisDoisDias();
        digitarTexto(campoValidoAte, DataEHoraAtualMaisDoisDias ,"Não foi possível preencher o campo Valido Até");
        salvarEvidencia("Preencher campo 'Valido Até' com: " + DataEHoraAtualMaisDoisDias);
        return this;
    }

    /**
     * Preencher campo valido Até  com valor de data e hora atual acrescido de 2minutos em cadastrar oferta
     * Realiza chamado dos métodos: carregarDataEHoraAtual() e retornarDataEHoraAtualMaisDoisMin()
     * Formato: "dd/MM/yyyy HH:mm + 2 min"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Vatido Até\" com data e hora atual mais dois minutos")
    public SistemaDeGestaoOfertasTela preencherCampoValidoAteComHoraAtualMaisDoisMin() throws Exception{
        aguardarCarregamentoElemento(campoValidoAte);
        rolarAteElemento(campoValidoAte, "Não foi possível rolar até campo 'Valido Até'");
        carregarDataEHoraAtual();
        digitarTexto(campoValidoAte, retornarDataEHoraAtualMaisDoisMin(),"Não foi possível preencher o campo Valido Até");
        salvarEvidencia("Preencher campo 'Valido Até' com hora atual mais dois minutos");
        return this;
    }

    /**
     * Armazena o valor da data e hora atual do sistema em uma variável estática
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
     * Obs: No método ainda não esté implementado tratamento especial quando dia 29, 30 ou 31 ou dia 27/02, 28/02 e 29/02
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
     * Clicar no botão "Alterar"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar botão \"Alterar\"")
    public SistemaDeGestaoOfertasTela clicarBotaoAlterar() throws Exception{
        aguardarCarregamentoElemento(botaoAlterar);
        rolarAteElemento(botaoAlterar, "Não foi possível rolar até o botão 'Alterar'");
        salvarEvidencia("Visualizar botão 'Alterar'");
        clicarElemento(botaoAlterar,"Não foi possível clicar no botão 'Alterar'");
        salvarEvidencia("Clicar no botão 'Alterar'");
        return this;
    }

    /**
     * Clicar no botão Sim
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar botão \"Sim\"")
    public SistemaDeGestaoOfertasTela clicarBotaoSim() throws Exception{
        aguardarCarregamentoElemento(botaoSim);
        salvarEvidencia("Visualizar botão 'Sim'");
        clicarElemento(botaoSim,"Não foi possível clicar no botão 'Sim'");
        return this;
    }

    /**
     * Clicar no botão "OK"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar botão \"OK\"")
    public SistemaDeGestaoOfertasTela clicarBotaoOK() throws Exception{
        aguardarCarregamentoElemento(botaoOk);
        rolarAteElemento(botaoOk, "Não foi possível rolar até o botão 'OK'");
        salvarEvidencia("Visualizar botão 'OK'");
        clicarElemento(botaoOk,"Não foi possível clicar no botão 'OK'");
        salvarEvidencia("Clicar no botão 'OK'");
        return this;
    }

    /**
     * Clicar no botão Aprovar
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar botão \"Aprovar\"")
    public SistemaDeGestaoOfertasTela clicarBotaoAprovar() throws Exception{
        aguardarCarregamentoElemento(botaoAprovar);
        rolarAteElemento(botaoAprovar, "Não foi possível rolar até o botão 'Aprovar'");
        salvarEvidencia("Visualizar botão 'Aprovar'");
        clicarElemento(botaoAprovar,"Não foi possível clicar no botão 'Aprovar'");
        salvarEvidencia("Clicar no botão 'Aprovar'");
        return this;
    }

    /**
     * Clicar no botão "Excluir"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    public SistemaDeGestaoOfertasTela clicarBotaoExcluirOferta(String idOferta) throws Exception {
        By botaoEditarOferta = By.xpath("//span[contains(. ,'"+idOferta+"')]/parent::td/following-sibling::td/a[@title= 'Excluir']/Img");
        rolarAteElemento(botaoEditarOferta, "Não foi possível rolar até botão Excluir oferta");
        salvarEvidencia("Visualizar oferta com id: '"+idOferta+"'");
        clicarElemento(botaoEditarOferta, "Não foi possível clicar em excluir oferta");
        salvarEvidencia("Clicar botão Excluir da oferta '"+valorNomeOferta.get()+"' com id '"+idOferta+"'");
        return this;
    }

    /**
     * Clicar no botão Cadastrar
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Cocar botão \"+Cadastrar\"")
    public SistemaDeGestaoOfertasTela clicarBotaoMaisCadastrar() throws Exception{
        //Durante a execução do método percebeu-se que as vezes o método desliza até o elemento e clica nele antes
        //de finalizar o carregamento da tela, o que pode quebrar o teste. Ao invés de utilizar um método do tipo threadSleep,
        //optou-se pela implementação dos blocos try, catch, para reexecutar a ação de deslizar até o elemento e clicar nele
        //quando a instabilidade acontecer na tela
        try{
            tentarClicarBotaoMaisCadastrarRolandoAteEle();
        }catch(AssertionError e){
            tentarClicarBotaoMaisCadastrarRolandoAteEle();
        }
        return this;
    }

    /**
     * Realiza ação de clicar no botão "+Cadastrar"
     *
     * @throws Exception
     */
    private void tentarClicarBotaoMaisCadastrarRolandoAteEle() throws Exception{
        aguardarCarregamentoElemento(botaoMaisCadastrar);
        rolarAteElemento(botaoMaisCadastrar, "Não foi possível rolar até elemento \"+Cadastrar\"");
        salvarEvidencia("Visualizar botão \"+Cadastrar\"");
        clicarElemento(botaoMaisCadastrar, "Não foi possível clicar no botão \"+Cadastrar\"");
        if(!aguardarCarregamentoElemento(campoNomeOferta)){
            throw new AssertionError("Elemento campo \"Nome Oferta\" não foi carregado");
        }
        salvarEvidencia("Clicar botão \"+Cadastrar\"");
    }

    /**
     * Preemcher campo com nome da oferta com valor Aleatório
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
        digitarTexto(campoNomeOferta,nomeOferta ,"Não foi possível preencher campo Nome Oferta");
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
        rolarAteElemento(comboboxCategoria,"Não foi possível rolar a tela até combobox \"Categoria\"");
        clicarElemento(comboboxCategoria, "Não foi possível clicar no elemento do combobox");
        clicarElemento(comboboxCategoria.findElement(By.xpath("//option[contains(.,\""+ categoria +"\")]")),"Não foi possível selecionar a opção \"" + categoria + "\" no cobobox \"Categoria\"");
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
        rolarAteElemento(comboboxParceiro,"Não foi possível rolar a tela até combobox \"Parceiro\"");
        clicarElemento(comboboxParceiro, "Não foi possível clicar no elemento do combobox");
        clicarElemento(comboboxParceiro.findElement(By.xpath("//option[contains(.,\""+ parceiro +"\")]")),"Não foi possível selecionar a opção \"" + parceiro + "\" no cobobox \"Parceiro\"");
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
        rolarAteElemento(campoTexto, "Não foi possivel rolar tela até \"Campo Texto\"");
        digitarTexto(campoTexto, texto ,"Não foi possível preencher campo Texto");
        salvarEvidencia("Preencher campo \"Texto\" com: "+ texto);
        return this;
    }

    /**
     * Método realiza upload de arquivo de imagem, enviando caminho para o arquivo no elemento input type="file"
     *
     * @param pathArquivoImagem
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Fazer upload de arquivo de imagem")
    public SistemaDeGestaoOfertasTela fazerUploadArquivoImagem(String pathArquivoImagem) throws Exception{
        aguardarCarregamentoElemento(botaoSelecionarArquivoImagem);
        rolarAteElemento(botaoSelecionarArquivoImagem, "Não foi possível rolar até botão de upload");
        //O método sendKeys foi utilizado diretamente aqui, pois o teste está lançando uma exceção ao preencher o campo
        //pela implementação do método digitarTexto().
        botaoSelecionarArquivoImagem.findElement(By.cssSelector("input[type=\"file\"]")).sendKeys(lerArquivo(pathArquivoImagem));
        salvarEvidencia("Fazer upload de arquivo de imagem");
        return this;
    }

    /**
     * Método realiza upload de arquivo de imagem, enviando caminho para o arquivo no elemento input type="file"
     *
     * @param pathArquivoImagem
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Fazer upload de arquivo de imagem")
    public SistemaDeGestaoOfertasTela fazerUploadArquivoImagemVoucher(String pathArquivoImagem) throws Exception{
        aguardarCarregamentoElemento(botaoSelecionarArquivoImagemBaseVoucher);
        rolarAteElemento(botaoSelecionarArquivoImagemBaseVoucher, "Não foi possível rolar até botão de upload");
        //O método sendKeys foi utilizado diretamente aqui, pois o teste está lançando uma exceção ao preencher o campo
        //pela implementação do método digitarTexto().
        botaoSelecionarArquivoImagemBaseVoucher.sendKeys(lerArquivo(pathArquivoImagem));
        salvarEvidencia("Fazer upload de arquivo de imagem");
        return this;
    }

    /**
     * Método realiza upload de arquivo csv, enviando caminho para o arquivo no elemento input type="file"
     *
     * @param pathArquivoVoucher
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Fazer upload de arquivo csv")
    public SistemaDeGestaoOfertasTela fazerUploadArquivoVoucher(String pathArquivoVoucher) throws Exception{
        aguardarCarregamentoElemento(botaoSelecionarArquivoCSV);
        rolarAteElemento(botaoSelecionarArquivoCSV, "Não foi possível rolar até botão de upload");
        //O método sendKeys foi utilizado diretamente aqui, pois o teste esté lançando uma exceção ao preencher o campo
        //pela implementação do método digitarTexto().
        botaoSelecionarArquivoCSV.sendKeys(lerArquivo(pathArquivoVoucher));
        salvarEvidencia("Fazer upload de arquivo");
        return this;
    }

    /**
     * Preencher campo Benefício
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Benefício\"")
    public SistemaDeGestaoOfertasTela preencherCampoBeneficio() throws Exception{
        preencherCampoBeneficio(ValoresPadraoPreenchimento.CAMPO_BENEFICIO.toString());
        return this;
    }

    /**
     * Preencher campo Benefício
     *
     * @param beneficio
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Benefício\"")
    public SistemaDeGestaoOfertasTela preencherCampoBeneficio(String beneficio) throws Exception{
        aguardarCarregamentoElemento(campoBeneficio);
        rolarAteElemento(campoBeneficio, "Não foi possivel rolar tela até \"Benefício\"");
        digitarTexto(campoBeneficio, beneficio ,"Não foi possível preencher campo Befício");
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
        rolarAteElemento(comboboxFormaDePagamento,"Não foi possível rolar a tela até combobox \"Forma de Pagamento\"");
        clicarElemento(comboboxFormaDePagamento.findElement(By.xpath("//option[contains(@value,\""+ formaDePagamento +"\")]")),"Não foi possível selecionar a opção \"" + formaDePagamento + "\" no cobobox \"Forma de Pagamento\"");
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
        rolarAteElemento(campoComoUsar, "Não foi possivel rolar tela até \"Como Usar\"");
        digitarTexto(campoComoUsar, comoUsar ,"Não foi possível preencher campo Como Usar");
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
        rolarAteElemento(radioButtonBaseDeVoucher, "Não foi possível rolar até o radio-button \"Base de Voucher\"");
        clicarElemento(radioButtonBaseDeVoucher,"Não foi possível clicar no radio-button \"Base de Voucher\"");
        salvarEvidencia("Clicar no radio-button \"Base de Voucher\"");
        return this;
    }

    /**
     * Selecionar Radio-button "Cupom único/ sem cupom"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Selecionar radio-button \"Cupom ?nico / sem cupom\"")
    public SistemaDeGestaoOfertasTela selecionarRadioButtonCupomUnico() throws Exception{
        aguardarCarregamentoElemento(radioButtonCupomUnico);
        rolarAteElemento(radioButtonCupomUnico, "Não foi possível rolar até o radio-button \"Cupom único / sem cupom\"");
        clicarElemento(radioButtonCupomUnico,"Não foi possível clicar no radio-button \"Cupom único / sem cupom\"");
        salvarEvidencia("Clicar no radio-button \"Cupom único / sem cupom\"");
        return this;
    }

    /**
     * Preencher campo "Nome Botão"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher nome botão")
    public SistemaDeGestaoOfertasTela preencherNomeBotao() throws Exception{
        preencherNomeBotao(ValoresPadraoPreenchimento.NOME_BOTAO.toString());
        return this;
    }

    /**
     * Preencher campo "Nome Botão"
     *
     * @param nomeBotao
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher nome botão")
    public SistemaDeGestaoOfertasTela preencherNomeBotao(String nomeBotao) throws Exception{
        aguardarCarregamentoElemento(campoTituloBotao);
        rolarAteElemento(campoTituloBotao, "Não foi possivel rolar tela até \"Título Botão\"");
        digitarTexto(campoTituloBotao, nomeBotao ,"Não foi possível preencher campo Como Usar");
        salvarEvidencia("Preencher campo \"Título Botão\" com: "+ nomeBotao);
        return this;
    }

    /**
     * Clicar Botão "Cadastrar"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar botão \"Cadastrar\"")
    public SistemaDeGestaoOfertasTela clicarBotaoCadastrar() throws Exception{
        aguardarCarregamentoElemento(botaoCadastrar);
        rolarAteElemento(botaoCadastrar, "Não foi possível rolar a tela até o botão \"Cadastrar\"");
        salvarEvidencia("Clicar botão \"Cadastrar\"");
        clicarElemento(botaoCadastrar,"Não foi possível clicar botão \"Cadastrar\"");
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
     * Preencher campo "Vadido Até" em cadastra Voucher
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Preencher campo \"Valido Até\"")
    public SistemaDeGestaoOfertasTela preencherCampoValidadeVoucher() throws Exception{
        String data = proximoDiaUtil(1);
        aguardarCarregamentoElemento(campoVoucherValidoAte);
        rolarAteElemento(campoVoucherValidoAte, "Não foi possivel rolar tela até \"Válido Até\"");
        digitarTexto(campoVoucherValidoAte, data,"Não foi possível preencher campo \"Válido Até\"");
        salvarEvidencia("Preencher campo \"Válido Até\" com: "+ data);
        return this;
    }

    /**
     * Clicar botão "Sair"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar botão \"Sair\"")
    public SistemaDeGestaoOfertasTela clicarBotaoSair() throws Exception{
        aguardarCarregamentoElemento(botaoSair);
        rolarAteElemento(botaoSair, "Não foi possível rolar a tela até o botão \"Sair\"");
        salvarEvidencia("Visualizar botão \"Sair\"");
        clicarElemento(botaoSair,"Não foi possível clicar botão \"Sair\"");
        salvarEvidencia("Clicar botão \"Sair\"");
        return this;
    }

    /**
     * Aguardar até que o processamento esteja em 100%
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Aguardar Processamento 100%")
    public SistemaDeGestaoOfertasTela aguardarProcessamento() throws Exception{
        aguardarCarregamentoElemento(iconeProcessamentoVoucher);
        rolarAteElemento(iconeProcessamentoVoucher, "Não foi possível rolar até processamento 100%");

        salvarEvidencia("Aguardar Processamento 100%");
        return this;
    }

    /**
     * Selecionar opção "Inativo" em combobox "Status"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Selecionar \"Inativo\" em combobox \"Situação\"")
    public SistemaDeGestaoOfertasTela selecionarInativoEmComboboxSituacao() throws Exception{
        aguardarCarregamentoElemento(comboboxStatus);
        clicarElemento(comboboxStatus,"Não foi Possível abrir combobox Status");
        clicarElemento(comboboxStatus.findElement(By.xpath("//option[.=\"Inativo\"]")),"Não foi possível selecionar Inativo");
        salvarEvidencia("Selecionar opção \"Inativo\" em combobox \"Situação\"");
        return this;
    }

    /**
     * Selecionar opção "Ativo" em combobox "Status"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Selecionar \"Ativo\" em combobox \"Status\"")
    public SistemaDeGestaoOfertasTela selecionarAtivoEmComboboxSituacao() throws Exception{
        aguardarCarregamentoElemento(comboboxStatus);
        clicarElemento(comboboxStatus,"Não foi Possível abrir combobox Status");
        clicarElemento(comboboxStatus.findElement(By.xpath("//option[.=\"Ativo\"]")),"Não foi possível selecionar Ativo");
        salvarEvidencia("Selecionar opção \"Ativo\" em combobox \"Status\"");
        return this;
    }

    /**
     * Validar que oferta foi incluída no sistema (Procurar por ID e Nome)
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Validar Oferta Cadastrada")
    public SistemaDeGestaoOfertasTela validarOfertaCadastradaPorID() throws Exception{
        if(verificarPresencaOfertaPorID()){
            salvarEvidencia("validar oferta \"" + valorNomeOferta.get() +"\" está cadastrada com ID: " +  valorIDOferta.get());
        }else{
            throw new AssertionError("Resultado Esperado: Encontrar oferta - \""+ valorNomeOferta.get() + "\"; Resultado Obtido: \"Oferta não encontrada\"");
        }
        return this;
    }

    /**
     * Método retorna true se oferta encontrada e, false se não encontrada
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    private boolean verificarPresencaOfertaPorID() throws Exception{
        try{
            WebElement celulaOferta = retornaElemento(By.xpath("//span[.=\""+ valorIDOferta.get() +"\"]"));
            rolarAteElemento(celulaOferta, "Nao foi possível rolar até célula oferta");
            return true;
        }catch(AssertionError var){
            throw new NoSuchElementException(var.getMessage());
        }catch (org.openqa.selenium.NoSuchElementException var1){
            return false;
        }
    }

    /**
     * Validar que oferta foi incluída no sistema
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Validar Oferta Cadastrada")
    public SistemaDeGestaoOfertasTela validarOfertaCadastrada() throws Exception{
        if(verificarPresencaOferta()){
            salvarEvidencia("validar oferta \"" + valorNomeOferta.get() +"\" esté cadastrada");
        }else{
            throw new AssertionError("Resultado Esperado: Encontrar oferta - \""+ valorNomeOferta.get() + "\"; Resultado Obtido: \"Oferta não encontrada\"");
        }
        return this;
    }

    /**
     * Validar que oferta não esté exibida na lista de ofertas
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Validar Oferta Não Cadastrada")
    public SistemaDeGestaoOfertasTela validarOfertaNaoCadastrada() {
        By idOferta = By.xpath("//span[.='"+ valorIDOferta.get() +"']");
        if(!aguardarExistenciaElemento(idOferta)){
            salvarEvidencia("validar oferta '"+valorNomeOferta.get()+"' com id '"+valorIDOferta.get()+"' não encontrada na lista");
        }else{
            throw new AssertionError("Resultado Esperado: Não encontrada a oferta - '"+valorNomeOferta.get()+"' com id '"+valorIDOferta.get()+"'; Resultado Obtido: 'Oferta encontrada'");
        }
        return this;
    }

    /**
     * Método retorna true se oferta encontrada e, false se não encontrada
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    private boolean verificarPresencaOferta() throws Exception{
        try{
            By celulaOferta = By.xpath("//span[.=\""+ valorNomeOferta.get() +"\"]");
            rolarAteElemento(celulaOferta, "Não foi possível rolar até célula oferta");
            return true;
        }catch(AssertionError var){
            return false;
        }
    }

    /**
     * Clicar no botão "Consultar"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar botão \"Consultar\"")
    public SistemaDeGestaoOfertasTela clicarBotaoConsultar() throws Exception{
        aguardarCarregamentoElemento(botaoConsultar);
        salvarEvidencia("Clicar botão \"Consultar\"");
        clicarElemento(botaoConsultar, "Não foi possível clicar no botão \"Consultar\"");
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
        rolarAteElemento(comboboxVoucherPorCPF,"Não foi possível rolar a tela até combobox \"Vouchers por CPF\"");
        clicarElemento(comboboxVoucherPorCPF, "Não foi possível clicar no elemento do combobox");
        clicarElemento(comboboxVoucherPorCPF.findElement(By.xpath("//option[contains(.,\""+ quantidade +"\")]")),"Não foi possível selecionar a opção \"" + quantidade + "\" no combobox \"Vouchers por CPF\"");
        salvarEvidencia("Selecionar \""+ quantidade +"\" em Combobox \"Vouchers por CPF\"");
        return this;
    }

    /**
     * Preencher campo "url site" com valor padrão
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
        rolarAteElemento(campoURLSite, "Não foi possivel rolar tela até \"url site\"");
        digitarTexto(campoURLSite, url ,"Não foi possível preencher campo \"url site\"");
        salvarEvidencia("Preencher campo \"url site\" com: "+ url);
        return this;
    }

    /**
     * Clicar no botão "Ativar"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar botão \"Ativar\"")
    public SistemaDeGestaoOfertasTela clicarBotaoAtivar() throws Exception{
        aguardarCarregamentoElemento(botaoAtivar);
        rolarAteElemento(botaoAtivar, "Erro ao rolar tela até elemento \"Ativar\"");
        salvarEvidencia("Visualizar botão \"Ativar\"");
        clicarElemento(botaoAtivar, "Não foi possível clicar no botão \"Ativar\"");
        salvarEvidencia("Clicou botão \"Ativar\"");
        return this;
    }

    /**
     * Clicar no botão "Desativar"
     *
     * @return SistemaDeGestaoOfertasTela
     * @throws Exception
     */
    @Step("Clicar botão \"Desativar\"")
    public SistemaDeGestaoOfertasTela clicarBotaoDesativar() throws Exception{
        aguardarCarregamentoElemento(botaoDesativar);
        rolarAteElemento(botaoDesativar, "Não foi possível rolar até o botão 'Desativar'");
        salvarEvidencia("Visualizar botão 'Desativar'");
        clicarElemento(botaoDesativar,"Não foi possível clicar no botão 'Desativar'");
        salvarEvidencia("Clicar no botão 'Desativar'");
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
        rolarAteElemento(radioButtonApp, "Não foi possível rolar até o radio-button \"App\"");
        clicarElemento(radioButtonApp,"Não foi possível clicar no radio-button \"App\"");
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
        digitarTexto(campoAndroidApp,androidApp ,"Não foi possível preencher campo \"Android APP\"");
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
        digitarTexto(campoIOSAPP,iOSApp ,"Não foi possível preencher campo \"iOS APP\"");
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
        digitarTexto(campoIOSSchema,iOSSchema ,"Não foi possível preencher campo \"iOS Schema\"");
        salvarEvidencia("Preencher campo \"iOS Schema\" com: "+ iOSSchema);
        return this;
    }

    /**
     * Faz a leitura de um arquivo no diretório para upload no sistema de gestão
     */
    public String lerArquivo (String pathArquivo){
        String filePath = System.getProperty("user.dir") + pathArquivo;
        return filePath;
    }
}
