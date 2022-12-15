package funcionalidade.web.sistemadegestao.mimos.hub;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import constantes.mimos.web.BaseDeCupons;
import constantes.mimos.web.TipoDeLink;
import pagina.web.sistemadegestao.Mimos.Hub.SistemaDeGestaoOfertasTela;

public class SistemaDeGestaoOfertasFunc extends FuncionalidadeBase {

    /**
     * Clicar no ícone Editar Oferta
     *
     * @param oferta
     * @throws Exception
     */
    public void clicarEditarOferta(String oferta) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoEditarOferta(oferta);
    }

    /**
     * Editar campo "válido até" com data e hora atual mais 2 minutos
     *
     * @throws Exception
     */
    public void editarCampoValidoAteHoraAtualMaisDoisMin() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .carregarDataEHoraAtual()
                .apagarCampoValidoAte()
                .preencherCampoValidoAteComHoraAtualMaisDoisMin();
    }

    /**
     * Editar campo "válido até" com nenhum valor
     *
     * @throws Exception
     */
    public void editarCampoValidoAteComoVazio() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .carregarDataEHoraAtual()
                .apagarCampoValidoAte();
    }

    /**
     * Clicar botão "Alterar"
     *
     * @throws Exception
     */
    public void clicarBotaoAlterar() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoAlterar();
    }

    /**
     *Clicar botão "Sim"
     *
     * @throws Exception
     */
    public void clicarBotaoSim()throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoSim();
    }

    /**
     * Clicar botão "OK"
     *
     * @throws Exception
     */
    public void clicarBotaoOK()throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoOK();
    }

    /**
     * Clicar ícone "Editando Oferta"
     *
     * @param oferta
     * @throws Exception
     */
    public void clicarEditandoOferta(String oferta) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoEditandoOferta(oferta);
    }

    /**
     * Clicar botão "Aprovar"
     *
     * @throws Exception
     */
    public void clicarBotaoAprovar() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoAprovar();
    }

    /**
     * Clicar botão +Cadastrar
     *
     * @throws Exception
     */
    public void clicarBotaoMaisCadastrar() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoMaisCadastrar();
    }

    /**
     * Preencher campo "Nome Oferta"
     *
     * @param nomeOferta
     * @throws Exception
     */
    public void preencherCampoNomeOferta(String nomeOferta) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .preencherCampoNomeOferta(nomeOferta);
    }

    /**
     * Selecionar categoria em combobox
     *
     * @param categoria
     * @throws Exception
     */
    public void selecionarCategoriaCombobox(String categoria) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .selecionarCategoriaCombobox(categoria);
    }

    /**
     * Selecionar parceiro em combobox
     *
     * @param parceiro
     * @throws Exception
     */
    public void selecionarParceiroCombobox(String parceiro) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .selecionarParceiroCombobox(parceiro);
    }

    public void preencherCampoTexto(String texto) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .preencherCampoTexto(texto);
    }

    /**
     * Realizar upload de  imagem de oferta
     *
     * @param pathArquivoImagem
     * @throws Exception
     */
    public void fazerUploadArquivoImagem(String pathArquivoImagem) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .fazerUploadArquivoImagem(pathArquivoImagem);
    }

    /**
     * Preencher campo Beneficio
     *
     * @param beneficio
     * @throws Exception
     */
    public void preencherCampoBeneficio(String beneficio) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .preencherCampoBeneficio(beneficio);
    }

    /**
     * Preencher campo E Hora Inicio com data e hora atual mais 2 minutos
     *
     * @throws Exception
     */
    public void preencherCampoDataEHoraInicComDataAtualMaisDoisMin() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .carregarDataEHoraAtual()
                .preencherCampoDataEHoraInicComDataAtualMaisDoisMin();
    }

    /**
     * Preencher campo "Válido Ate" com data e hora atual mais dois dias
     *
     * @throws Exception
     */
    public void preencherCampoValidoAteComDataAtualMaisDoisDias() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .preencherCampoValidoAteComDataAtualMaisDoisDias();
    }

    /**
     * Selecionar combobox com "Forma de Pagamento"
     *
     * @param formaDePagamento
     * @throws Exception
     */
    public void selecionarFormaPagamentoComboBox(String formaDePagamento) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .selecionarFormaPagamentoComboBox(formaDePagamento);
    }

    /**
     * Preencher campo "Como usar"
     *
     * @param comoUsar
     * @throws Exception
     */
    public void preencherCampoComoUsar(String comoUsar)throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .preencherCampoComoUsar(comoUsar);
    }

    /**
     * Selecionar checkbox "Base de Voucher"
     *
     * @throws Exception
     */
    public void selecionarRadioButtonBaseDeVoucher() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .selecionarRadioButtonBaseDeVoucher();
    }

    /**
     * Preencher campo "Nome Botao"
     *
     * @param nomeBotao
     * @throws Exception
     */
    public void preencherNomeBotao(String nomeBotao) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .preencherNomeBotao(nomeBotao);
    }

    /**
     * Clicar botão "Cadastrar"
     *
     * @throws Exception
     */
    public void clicarBotaoCadastrar() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoCadastrar();
    }

    /**
     * Selecionar Validade em Combobox
     *
     * @throws Exception
     */
    public void preencherCampoValidadeVoucher() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .preencherCampoValidadeVoucher();
    }

    /**
     * Carregar Arquivo Voucher
     *
     * @param pathArquivoVoucher
     * @throws Exception
     */
    public void carregarArquivoVoucher(String pathArquivoVoucher) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .fazerUploadArquivoVoucher(pathArquivoVoucher);
    }

    /**
     * Clicar botão "Sair"
     *
     * @throws Exception
     */
    public void clicarBotaoSair() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoSair();
    }

    /**
     * Clicar botão "Sair"
     *
     * @throws Exception
     */
    public void clicarBotaoSairAposFimProcessamento() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .aguardarProcessamento()
                .clicarBotaoSair();
    }

    /**
     * Validar Oferta cadastrada em Inativas
     *
     * @throws Exception
     */
    public void validarOfertaHubCadastradaEmInativo() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .selecionarInativoEmComboboxSituacao()
                .clicarBotaoConsultar()
                .validarOfertaCadastrada();
    }

    /**
     * Validar Oferta cadastrada com status Ativo
     *
     * @throws Exception
     */
    public void validarOfertaHubCadastradaEmAtivo() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .selecionarAtivoEmComboboxSituacao()
                .clicarBotaoConsultar()
                .validarOfertaCadastrada();
    }

    /**
     * Fazer upload de arquivo de imagem (.png - 512x512 pixels) de voucher
     *
     * @param pathArquivoImagem
     * @throws Exception
     */
    public void fazerUploadArquivoImagemVoucher(String pathArquivoImagem) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .fazerUploadArquivoImagemVoucher(pathArquivoImagem);
    }

    /**
     * Selecionar quantidade de vouchers por CPF em combobox
     *
     * @param quantidade
     * @throws Exception
     */
    public void selecionarVoucherPorCPFCombobox(String quantidade) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .selecionarVoucherPorCPFCombobox(quantidade);
    }

    /**
     * Preencher Campo "url site"
     *
     * @param url
     * @throws Exception
     */
    public void preencherCampoURLSite(String url) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .preencherCampoURLSite(url);
    }

    /**
     * Clicar no botão Exluir Oferta
     *
     * @param oferta
     * @throws Exception
     */
    public void clicarBotaoExcluirOferta(String oferta) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoExcluirOferta(oferta);
    }

    /**
     * Selecionar opcão "Inativo" em combobox Status
     *
     * @throws Exception
     */
    public void selecionarInativoEmComboboxSituacao() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .selecionarInativoEmComboboxSituacao();
    }

    /**
     * Clicar no botao Consultar
     *
     * @throws Exception
     */
    public void clicarBotaoConsultar() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoConsultar();
    }

    /**
     * Validar Oferta nao cadastrada
     *
     * @throws Exception
     */
    public void validarOfertaNaoCadastrada() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .selecionarInativoEmComboboxSituacao()
                .clicarBotaoConsultar()
                .validarOfertaNaoCadastrada();
    }

    /**
     * Clicar no botão Ativar
     *
     * @throws Exception
     */
    public void clicarBotaoAtivar() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoAtivar();
    }

    /**
     * Cadastrar informacoes Step 1 (Dados da Oferta HUB) e Step 2 (App-Menu) de oferta:
     * - Clicar botão "Cadastrar +"
     * - Preencher campo "Nome da Oferta
     * - Selecionar categoria em combobox "Categoria"
     * - Selecionar parceito em combobox "Parceiro"
     * - Preencher campo "Texto (produto da promoção + valor)*
     * - Realizar upload de imagem em "LOGO"
     *
     *
     *
     * @param nomeOferta
     * @param categoria
     * @param parceiro
     * @param texto
     * @param pathArquivoImagem
     * @throws Exception
     */
    public void preencherInfoOferta(String nomeOferta,
                                    String categoria,
                                    String parceiro,
                                    String texto,
                                    String pathArquivoImagem) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoMaisCadastrar()
                .preencherCampoNomeOferta(nomeOferta)
                .selecionarCategoriaCombobox(categoria)
                .selecionarParceiroCombobox(parceiro)
                .preencherCampoTexto(texto)
                .fazerUploadArquivoImagem(pathArquivoImagem);
    }

    /**
     * Preencher campos:
     * - Benefício;
     * - Data e Hora de Início (data e hora atual + 2 min);
     * - Valido Até (data atual + 2 dias e hora atual);
     * - Selecionar Forma de Pagamento;
     * - Preencher campo "Como Usar"
     *
     * @param beneficio
     * @param formaDePagamento
     * @param comoUsar
     * @throws Exception
     */
    public void preencherInfoDadosEComoUsar(String beneficio,
                                            String formaDePagamento,
                                            String comoUsar) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .preencherCampoBeneficio(beneficio)
                .carregarDataEHoraAtual()
                .preencherCampoDataEHoraInicComDataAtualMaisDoisMin()
                .preencherCampoValidoAteComDataAtualMaisDoisDias()
                .selecionarFormaPagamentoComboBox(formaDePagamento)
                .preencherCampoComoUsar(comoUsar);
    }

    /**
     * Selecionar tipo de base de cupons:
     * case: CUPOM_UNICO_SEM_CUPOM -> Selecionar radio-button "Cupom único / sem cupom"
     * case: BASE_DE_VOUCHER -> Selecionar radio-button "Base de Voucher"
     *                       -> Fazer upload de imagem de Voucher
     *                       -> Selecionar quantidade de "Voucher por CPF"
     *
     * @param baseDeCupons
     * @param pathArquivoImagem
     * @param quantidade
     * @throws Exception
     */
    public void selecionarBaseDeCupons(BaseDeCupons baseDeCupons,
                                       String pathArquivoImagem,
                                       String quantidade) throws Exception{
        switch (baseDeCupons){
            case CUPOM_UNICO_SEM_CUPOM:
                new SistemaDeGestaoOfertasTela(getWebDriver())
                        .selecionarRadioButtonCupomUnico();
                break;
            case BASE_DE_VOUCHER:
                new SistemaDeGestaoOfertasTela(getWebDriver())
                        .selecionarRadioButtonBaseDeVoucher()
                        .fazerUploadArquivoImagemVoucher(pathArquivoImagem)
                        .selecionarVoucherPorCPFCombobox(quantidade);
                break;
        }

    }

    /**
     * Informar dados em "Tipo de Link"
     *
     * @param nomeBotao
     * @param tipoDeLink
     * @param url
     * @param androidApp
     * @param iOSApp
     * @param iOSSchema
     * @throws Exception
     */
    public void informarTipoDeLink(String nomeBotao,
                                   TipoDeLink tipoDeLink,
                                   String url,
                                   String androidApp,
                                   String iOSApp,
                                   String iOSSchema) throws Exception{
        switch (tipoDeLink){
            case SITE:
                new SistemaDeGestaoOfertasTela(getWebDriver())
                        .preencherNomeBotao(nomeBotao)
                        .preencherCampoURLSite(url);
                break;
            case APP:
                new SistemaDeGestaoOfertasTela(getWebDriver())
                        .preencherNomeBotao(nomeBotao)
                        .selecionarRadioButtonApp()
                        .preencherCampoAndroidApp(androidApp)
                        .preencherCampoiOSApp(iOSApp)
                        .preencherCampoiOSSchema(iOSSchema);
                break;
            case LOJA_FISICA:
                new SistemaDeGestaoOfertasTela(getWebDriver())
                        .preencherNomeBotao(nomeBotao);
        }
    }

    /**
     * Cadastrar Voucher em oferta
     *
     * @param pathArquivoVoucher
     * @throws Exception
     */
    public void cadastrarVoucher(String pathArquivoVoucher) throws Exception {
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoCadastrar()
                .clicarBotaoSim()
                .clicarBotaoSim()
                .registrarIDOferta()
                .preencherCampoValidadeVoucher()
                .fazerUploadArquivoVoucher(pathArquivoVoucher)
                .clicarBotaoCadastrar()
                .clicarBotaoSim()
                .clicarBotaoOK()
                .aguardarProcessamento()
                .clicarBotaoSair()
                .selecionarInativoEmComboboxSituacao()
                .clicarBotaoConsultar()
                .validarOfertaCadastradaPorID();
    }

    /**
     * Ativar oferta cadastrada
     *
     * @throws Exception
     */
    public void ativarOferta() throws Exception {
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoEditarOferta()
                .clicarBotaoAtivar()
                .clicarBotaoSim()
                .clicarBotaoOK()
                .selecionarAtivoEmComboboxSituacao()
                .clicarBotaoConsultar()
                .validarOfertaCadastradaPorID();
    }

    /**
     * Cadastrar nova oferta sem voucher e com link para site
     *
     * @param categoria
     * @param parceiro
     * @param formaDePagamento
     * @param arquivoImagem
     * @throws Exception
     */
    public void cadastrarOfertaSiteSemVoucher(Enum categoria,
                                              Enum parceiro,
                                              Enum formaDePagamento,
                                              Enum arquivoImagem) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoMaisCadastrar()
                .preencherCampoNomeOferta()
                .selecionarCategoriaCombobox(categoria.toString())
                .selecionarParceiroCombobox(parceiro.toString())
                .preencherCampoTexto()
                .fazerUploadArquivoImagem(arquivoImagem.toString())
                .preencherCampoBeneficio()
                .carregarDataEHoraAtual()
                .preencherCampoDataEHoraInicComDataAtualMaisDoisMin()
                .selecionarFormaPagamentoComboBox(formaDePagamento.toString())
                .preencherCampoComoUsar()
                .preencherNomeBotao()
                .preencherCampoURLSite()
                .clicarBotaoCadastrar()
                .clicarBotaoSim()
                .clicarBotaoOK()
                .selecionarInativoEmComboboxSituacao()
                .clicarBotaoConsultar()
                .clicarBotaoEditarOferta(SistemaDeGestaoOfertasTela.valorNomeOferta.get())
                .clicarBotaoAtivar()
                .clicarBotaoSim()
                .clicarBotaoOK();
    }
    /**
     * Cadastrar nova oferta sem voucher e com link para site
     *
     * @param categoria
     * @param parceiro
     * @param formaDePagamento
     * @param arquivoImagem
     * @throws Exception
     */
    public void cadastrarOfertaSiteSemVoucher(Enum categoria,
                                              Enum parceiro,
                                              Enum formaDePagamento,
                                              Enum arquivoImagem, String nomeOferta) throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .clicarBotaoMaisCadastrar()
                .preencherCampoNomeOferta(nomeOferta)
                .selecionarCategoriaCombobox(categoria.toString())
                .selecionarParceiroCombobox(parceiro.toString())
                .preencherCampoTexto()
                .fazerUploadArquivoImagem(arquivoImagem.toString())
                .preencherCampoBeneficio()
                .carregarDataEHoraAtual()
                .preencherCampoDataEHoraInicComDataAtualMaisDoisMin()
                .selecionarFormaPagamentoComboBox(formaDePagamento.toString())
                .preencherCampoComoUsar()
                .preencherNomeBotao()
                .preencherCampoURLSite()
                .clicarBotaoCadastrar()
                .clicarBotaoSim()
                .clicarBotaoOK()
                .selecionarInativoEmComboboxSituacao()
                .clicarBotaoConsultar()
                .clicarBotaoEditarOferta(SistemaDeGestaoOfertasTela.valorNomeOferta.get())
                .clicarBotaoAtivar()
                .clicarBotaoSim()
                .clicarBotaoOK();
    }

    /**
     * Desativar Oferta criada durante o teste
     *
     * @throws Exception
     */
    public void desativarOferta() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .selecionarAtivoEmComboboxSituacao()
                .clicarBotaoConsultar()
                .clicarBotaoEditarOferta(SistemaDeGestaoOfertasTela.valorIDOferta.get())
                .clicarBotaoDesativar()
                .clicarBotaoSim()
                .clicarBotaoOK();
    }

    /**
     * Deletar oferta criada durante o teste
     *
     * @throws Exception
     */
    public void deletarOferta() throws Exception{
        new SistemaDeGestaoOfertasTela(getWebDriver())
                .selecionarInativoEmComboboxSituacao()
                .clicarBotaoConsultar()
                .clicarBotaoExcluirOferta(SistemaDeGestaoOfertasTela.valorIDOferta.get())
                .clicarBotaoSim()
                .clicarBotaoOK()
                .validarOfertaNaoCadastrada();
    }
}
