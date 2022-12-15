package br.com.next.automacao.core.massa.adesao;

import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.constantes.MetodoRequisicao;
import br.com.next.automacao.core.constantes.massa.adesao.CartaoAdesao;
import br.com.next.automacao.core.constantes.massa.adesao.PlanoAdesao;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.Utilitarios;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static br.com.next.automacao.core.base.api.RequisicaoBase.executarRequisicao;
import static io.restassured.RestAssured.given;


/**
 * Classe define os principais dados enviados em no processo de onboarding do next responsavell
 *
 * @author Rodrigo Benedetti
 *
 * */
public class RequisicaoAdesao<Reponse> {
    private static ThreadLocal<ModeloAdesao> modeloAdesao= null;

    protected static ModeloAdesao getModeloAdesao() {
        return modeloAdesao.get();
    }

    private static void setModeloAdesao() {
        if (modeloAdesao == null) {
            modeloAdesao = new ThreadLocal<ModeloAdesao>();
        }
        modeloAdesao.set(new ModeloAdesao());
    }

    public static final String uriBaseCoreBank = ReadProperties.getCaUrl();
    public static final String deviceSignature = "{\"deviceSignature\":{\"collector\":\"Android\",\"collectorVersion\":\"8.2.2\",\"system\":{\"platform\":\"Android23\",\"androidId\":\"dee820dffff3bd2f\",\"osVersion\":\"6.0.1\",\"deviceName\":\"C103\",\"model\":\"C103\",\"board\":\"c1\",\"brand\":\"Coolpad\",\"host\":\"pcnbj-cp063\",\"id\":\"ZIXOSOP5801803011S\",\"type\":\"user\",\"user\":\"letv\",\"cpuAbi\":\"arm64-v8a\",\"cpuAbi2\":null,\"hardware\":\"qcom\",\"manufacturer\":\"Coolpad\",\"serial\":\"db318f5\",\"tags\":\"release-keys\",\"locale\":\"portuguÃªs (Brasil)\",\"radio\":\"C10_201702281858-10.140.35.30 \",\"processName\":\"br.com.bradesco.next\",\"systemName\":\"Android OS\",\"jailBroken\":false,\"timeZone\":\"America/Belem\",\"debuggerAttached\":false,\"totalDiskSpace\":\"24056\",\"totalMemory\":3607,\"numberOfProcessors\":8},\"screen\":{\"displayId\":\"ZIXOSOP5801803011S release-keys\",\"width\":\"1080\",\"height\":\"1920\",\"orientation\":\"1\"},\"browser\":{\"userAgent\":\"Dalvik 2.1.0 (Linux; U; Android 6.0.1; C103 Build ZIXOSOP5801803011S)\"},\"wifi\":{\"connected\":true,\"macAddress\":\"02:00:00:00:00:00\",\"ipAddress\":\"192.168.1.69\",\"netmaskAddress\":\"255.255.255.0\",\"gatewayAddress\":\"192.168.1.254\",\"broadcastAddress\":\"192.168.1.255\",\"userEnabled\":true},\"telephony\":{\"imeiNumber\":null,\"carrierIsoCountryCode\":\"br\",\"carrierName\":\"TIM\",\"carrierMobileCountryCode\":null,\"simOperatorName\":\"TIM\",\"carrierMobileNetworkCode\":\"02\",\"networkType\":\"GPRS\",\"phoneType\":\"GSM\",\"simIsoCountryCode\":\"br\",\"isRoamingNetwork\":false,\"cellIpAddress\":null,\"simSerialNumber\":null,\"subscriberId\":null},\"camera\":{\"numberOfCameras\":null,\"rearCamera\":null,\"frontCamera\":null,\"autoFocus\":null,\"flash\":null,\"rearCameraSupportedSizes\":null,\"rearCameraSupportedFormats\":null,\"frontCameraSupportedSizes\":null,\"frontCameraSupportedFormats\":null},\"bluetooth\":{\"supported\":true,\"macAddress\":\"02:00:00:00:00:00\"},\"extra\":{\"account\":null,\"securityPolicy\":true},\"location\":{\"latitude\":-22.534503,\"longitude\":-43.2116745}},\"ipAddress\":\"192.168.1.69\"}" ;
    public static final String coreIp = "ti-lado-b" ;
    public static final String cpf = Utilitarios.gerarCpf();
    public static final String user_password = "ER6TMcrSLnVNh7W0w50IC/I5vBoDCkCFWZDQqUOD3IzfMjaXsb5cma//VM8cUzR8AAAAAAAAAAHDLqJidJhFft3aflirvGciLXY1lksRnCFyLrLJeWc0Fw6tTP4mRVzk9UoW/Wapx3w9h2vcJn88+YTdl1MFBsZ7HzuLV/oX0cLgMtyOHVbyAYoyPxlRxJNWNminMPWm0tv8uraEBTI6A6J33D5iy+0N3hD1vBjDPNwex2lAB7bA2pUtiGuhW21uFLU4LeVv+I4CeSlKCSWKsAU+dTQxaGdQ" ;
    public static String device_id = null;
    public static final String cardPassword = "ER6TMcrSLnVNh7W0w50IC/I5vBoDCkCFWZDQqUOD3IzfMjaXsb5cma//VM8cUzR8AAAAAAAAAAH8K6HliyqRGKomrJerhpSFjEUU7haJw/Rov4ELUziOEn4uX8yyGw==";

    static {
        try {
            device_id = preRegistrationNext();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método inserer as informações dos cliente gerando o deviceID
     *
     * @return
     */
    static String preRegistrationNext() throws Exception {
        List<Header> headerlist = new ArrayList<Header>();
        headerlist.add(new Header("remote-ip-address", "192.168.1.1"));
        headerlist.add(new Header("deviceSignature", deviceSignature));
        headerlist.add(new Header("coreIP", coreIp));
        Headers headers = new Headers(headerlist);

        DadosRequisicaoBase corpoRequisicao = new DadosRequisicaoBase(uriBaseCoreBank, "/v2/preregistration")
                .definirHeaders(headers)
                .definirCorpoRequisicao(
                        "cpf", cpf,
                        "deviceType", "cellphone",
                        "email", "teste@teste.com",
                        "jailBroken", true,
                        "latitude", "string",
                        "longitude", "string",
                        "manufacturer", "samsung",
                        "mobileAreaCode", "11",
                        "mobileCountryCode", "55",
                        "mobilePhoneNumber", Utilitarios.gerarNumeroCelular(),
                        "model", "v2",
                        "name", "FULANO BELTRANO DA SILVA",
                        "os", "android",
                        "phoneOperator", "timvivoclaro",
                        "platform", "android",
                        "sendedAt", "2021-01-02T17:29:55.033Z",
                        "smsPermission", false,
                        "timeZone", "asdasdasdas"
                );

        return executarRequisicao(corpoRequisicao, MetodoRequisicao.POST, 201, "Não foi capturar o deviceID!").obterValorJson("deviceId");
    }

    /**
     * Método cadastra a senha do cliente
     *
     * @param "cpf"
     * @param "deviceID"
     * @param "user_password"
     * @return
     */
    static String criarUserPassword() throws Exception {
        List<Header> headerlist = new ArrayList<Header>();
        headerlist.add(new Header("DNA", deviceSignature));
        headerlist.add(new Header("Remote-IP-Address", "192.168.1.1"));
        headerlist.add(new Header("coreIP", coreIp));
        Headers headers = new Headers(headerlist);
        DadosRequisicaoBase corpoRequisicao = new DadosRequisicaoBase(uriBaseCoreBank, "/v2/userPassword")
                .definirHeaders(headers)
                .definirCorpoRequisicao(
                        "cpf", cpf,
                        "deviceId", preRegistrationNext(),
                        "password", user_password
                );

        return executarRequisicao(corpoRequisicao, MetodoRequisicao.POST, 201, "Não foi possivel registrar o password").obterValorJson("username");
    }

    /**
     * Método criar o corpo da requisição loginApp
     */
    private static JSONObject criarCorpoRequisicao() throws Exception {
        JSONObject corpoPrincipal = new JSONObject();
        JSONObject corpoApps = new JSONObject();
        JSONObject corpologinSignature = new JSONObject();
        JSONObject corpoDevice = new JSONObject();

        JSONArray listaDevice = new JSONArray();
        JSONArray listaloginSignature = new JSONArray();
        JSONArray listaApps = new JSONArray();
        JSONArray listaCorpoPrincipal = new JSONArray();

        corpoApps.put("acess", 0);
        corpoApps.put("nome", "Next");
        corpoApps.put("pacote", "br.com.bradesco.next");
        listaApps.add(corpoApps);

        corpoDevice.put("areaCode", "");
        corpoDevice.put("browserSupplier", "");
        corpoDevice.put("browserUserAgent", "Dalvik 2.1.0 (Linux; U; Android 6.0.1; Lenovo K33a48 Build MMB29M)");
        corpoDevice.put("carrier", "");
        corpoDevice.put("chipIccid", "");
        corpoDevice.put("countryCode", null);
        corpoDevice.put("countryIsoCd", null);
        corpoDevice.put("deviceId", cpf);
        corpoDevice.put("deviceType", "Mobile");
        corpoDevice.put("imei", null);
        corpoDevice.put("jailBroken", false);
        corpoDevice.put("mac", "02:00:00:00:00:00");
        corpoDevice.put("maker", "LENOVO");
        corpoDevice.put("model", "Lenovo K33a48");
        corpoDevice.put("os", "Android23");
        corpoDevice.put("osStatusId", 0);
        corpoDevice.put("osVersion", "6.0.1");
        corpoDevice.put("phone", "");
        corpoDevice.put("serialNumber", "ef7fd3e6");
        corpoDevice.put("timeZone", "AmericaSao_Paulo");
        corpoDevice.put("tokenDevice", "");
        corpoDevice.put("uniqueID", 0);
        listaDevice.add(corpoDevice);


        corpologinSignature.put("cpf", cpf);
        corpologinSignature.put("device", corpoDevice);
        corpologinSignature.put("password", user_password);
        corpologinSignature.put("riskScore", 0);
        corpologinSignature.put("transaction", cpf);
        listaloginSignature.add(corpologinSignature);

        corpoPrincipal.put("apps", listaApps);
        corpoPrincipal.put("loginSignature", corpologinSignature);
        listaCorpoPrincipal.add(corpoPrincipal);

        return corpoPrincipal;
    }

    /**
     * Método abre a sessão do cliente
     *
     * @param "cpf"
     * @param "deviceID"
     * @param "user_password"
     * @param "coreIP"
     * @param "deviceSignature"
     * @return
     */
    static String loginApp() throws Exception {

        List<Header> headerlist = new ArrayList<Header>();
        headerlist.add(new Header("deviceSignature", deviceSignature));
        headerlist.add(new Header("cpfDeviceRegistration", cpf));
        headerlist.add(new Header("coreIP", coreIp));
        Headers headers = new Headers(headerlist);

        DadosRequisicaoBase corpoRequisicao = new DadosRequisicaoBase(uriBaseCoreBank, "/v2/login")
                .definirHeaders(headers)
                .definirCorpoRequisicao(
                        criarCorpoRequisicao()
                );

        return executarRequisicao(corpoRequisicao, MetodoRequisicao.POST, 200, "Não foi possivel efetuar o login!").obterValorJson("token");
    }

    /**
     * Método pegar o token da sessão do cliente
     *
     * @param 'esteira'
     * @param 'cpf'
     */
    static String retornaCustomeId() throws Exception {
        List<Header> headerlist = new ArrayList<Header>();
        headerlist.add(new Header("Content-Type", "application/json"));
        headerlist.add(new Header("coreIP", coreIp));
        Headers headers = new Headers(headerlist);
        DadosRequisicaoBase corpoRequisicao = new DadosRequisicaoBase(uriBaseCoreBank, "/v1/login/system")
                .definirCorpoRequisicao("cpf", cpf,
                        "system", "genesys"
                );
        ;
        return executarRequisicao(corpoRequisicao, MetodoRequisicao.POST, 200, "Não foi possivel pegar o Customer!").obterValorJson("token");
    }


    /**
     * Método criar o corpo da requisição Appçication dados Pai/Mãe e Endereço
     */
    static JSONObject criarCorpoRequisicaoAApplicationUm() throws Exception {
        JSONObject corpoPrincipal = new JSONObject();
        JSONObject corpoAddresses = new JSONObject();
        JSONObject corpoCustomerAssets = new JSONObject();
        JSONObject corpoFatcaResponses = new JSONObject();
        JSONObject corpoPhoneNumbers = new JSONObject();

        JSONArray listaAddresses = new JSONArray();
        JSONArray listaCorpoPrincipal = new JSONArray();
        JSONArray listaCustomerAssets = new JSONArray();
        JSONArray listaFatcaResponses = new JSONArray();
        JSONArray listaPhoneNumbers = new JSONArray();


        corpoAddresses.put("addressAdditionalInfo", "string string");
        corpoAddresses.put("addressType", "1");
        corpoAddresses.put("cityId", 0);
        corpoAddresses.put("createFunctionName", "string");
        corpoAddresses.put("createTimestamp", "2020-05-27T17:29:54.975Z");
        corpoAddresses.put("createUserId", 0);
        corpoAddresses.put("customerUid", 0);
        corpoAddresses.put("mailingAddressInd", "Y");
        corpoAddresses.put("neighbourhood", "string");
        corpoAddresses.put("postalCode", 6220090);
        corpoAddresses.put("stateCd", "SP");
        corpoAddresses.put("streetName", "RUA ESPIRITO SANTO");
        corpoAddresses.put("streetNumber", "100");
        corpoAddresses.put("uniqueID", 0);
        corpoAddresses.put("updateFunctionName", "string");
        corpoAddresses.put("updateTimestamp", "2020-05-27T17:29:54.975Z");
        corpoAddresses.put("updateUserId", 0);
        listaAddresses.add(corpoAddresses);

        corpoCustomerAssets.put("assetQuantity", 0);
        corpoCustomerAssets.put("assetTypeId", "1");
        corpoCustomerAssets.put("assetValueAmt", 0);
        corpoCustomerAssets.put("createFunctionName", "string");
        corpoCustomerAssets.put("createTimestamp", "2020-05-27T17:29:54.975Z");
        corpoCustomerAssets.put("createUserId", 0);
        corpoCustomerAssets.put("customerUid", 0);
        corpoCustomerAssets.put("uniqueID", 0);
        corpoCustomerAssets.put("updateFunctionName", "string");
        corpoCustomerAssets.put("updateTimestamp", "2020-05-27T17:29:54.975Z");
        corpoCustomerAssets.put("updateUserId", 0);
        listaCustomerAssets.add(corpoCustomerAssets);


        corpoFatcaResponses.put("countryId", 0);
        corpoFatcaResponses.put("createFunctionName", "string");
        corpoFatcaResponses.put("createTimestamp", "2020-05-27T17:29:54.975Z");
        corpoFatcaResponses.put("createUserId", 0);
        corpoFatcaResponses.put("customerUid", 0);
        corpoFatcaResponses.put("fatcaQuestionId", 0);
        corpoFatcaResponses.put("nationality", "string");
        corpoFatcaResponses.put("nifTaxId", "");
        corpoFatcaResponses.put("reasonMissingNifId", 2);
        corpoFatcaResponses.put("uniqueID", 2);
        corpoFatcaResponses.put("updateFunctionName", "string");
        corpoFatcaResponses.put("updateTimestamp", "2020-05-27T17:29:54.975Z");
        corpoFatcaResponses.put("updateUserId", 0);
        listaFatcaResponses.add(corpoFatcaResponses);

        corpoPhoneNumbers.put("areaCode", "11");
        corpoPhoneNumbers.put("countryCode", "55");
        corpoPhoneNumbers.put("createFunctionName", "string");
        corpoPhoneNumbers.put("createTimestamp", "2020-05-27T17:29:54.975Z");
        corpoPhoneNumbers.put("createUserId", 0);
        corpoPhoneNumbers.put("customerUid", 0);
        corpoPhoneNumbers.put("phoneNumber", 999999999);
        corpoPhoneNumbers.put("phoneType", "1");
        corpoPhoneNumbers.put("primaryPhoneInd", "Y");
        corpoPhoneNumbers.put("uniqueID", 0);
        corpoPhoneNumbers.put("updateFunctionName", "string");
        corpoPhoneNumbers.put("updateTimestamp", "2020-05-27T17:29:54.975Z");
        corpoPhoneNumbers.put("updateUserId", 0);
        listaPhoneNumbers.add(corpoPhoneNumbers);

        corpoPrincipal.put("addresses", listaAddresses);
        corpoPrincipal.put("birthPlace", "string");
        corpoPrincipal.put("birthdate", "1988-05-27");
        corpoPrincipal.put("cityOfBirth", 50830);
        corpoPrincipal.put("civilCapacityCode", 0);
        corpoPrincipal.put("cnhId", "846537846");
        corpoPrincipal.put("countryOfBirth", 46);

        corpoPrincipal.put("customerName", "FULANO BELTRANO DA SILVA");
        corpoPrincipal.put("documentIssueDate", "2020-05-27");
        corpoPrincipal.put("documentIssuerDepartment", "SSP");
        corpoPrincipal.put("documentIssuerStateId", "SP");
        corpoPrincipal.put("eduCompletionDt", "2020-05-27");
        corpoPrincipal.put("eduCurrentSemester", 0);
        corpoPrincipal.put("eduInstitutionName", "string string");
        corpoPrincipal.put("eduInstitutionStateCd", "SP");
        corpoPrincipal.put("eduLastUpdatedDt", "2020-05-27");
        corpoPrincipal.put("eduMajor", "string");
        corpoPrincipal.put("educationInstitutionStateId", "SP");
        corpoPrincipal.put("educationLevelId", 0);
        corpoPrincipal.put("email", "teste@teste.com");
        corpoPrincipal.put("fatherName", "Rodrigo Benedetti");
        corpoPrincipal.put("gender", "M");
        corpoPrincipal.put("gpsPermissionInd", true);
        corpoPrincipal.put("invoiceDay", 0);
        corpoPrincipal.put("maritalStatus", "1");
        corpoPrincipal.put("missingFatherNameReasonId", 0);
        corpoPrincipal.put("missingMotherNameReasonId", 0);
        corpoPrincipal.put("motherName", "Isaura Lima");
        corpoPrincipal.put("nickname", "Val");
        corpoPrincipal.put("pepRelatedCpf", "");
        corpoPrincipal.put("pepRelatedId", 0);
        corpoPrincipal.put("pepRelatedResponse", "N");
        corpoPrincipal.put("pepRoleResponse", "N");
        corpoPrincipal.put("pinPointChangedInd", true);
        corpoPrincipal.put("pinPointLatitude", "string");
        corpoPrincipal.put("pinPointLongitude", "string");
        corpoPrincipal.put("professionCategoryId", 1);
        corpoPrincipal.put("monthlyIncome", 1000);
        corpoPrincipal.put("professionId", 100);
        corpoPrincipal.put("referencePersonAreaCode", 0);
        corpoPrincipal.put("referencePersonCountryCode", 0);
        corpoPrincipal.put("referencePersonName", "Valentina Silva");
        corpoPrincipal.put("referencePersonPhoneNr", 0);
        corpoPrincipal.put("referencePersonTypeId", 0);
        corpoPrincipal.put("rgId", "string");
        corpoPrincipal.put("spouseName", "string string");
        corpoPrincipal.put("stateOfBirth", 11);
        corpoPrincipal.put("twitterAccount", "string");
        corpoPrincipal.put("universityStudent", true);
        corpoPrincipal.put("useAddressList", true);
        corpoPrincipal.put("useAssetList", true);
        corpoPrincipal.put("useFatcaResponseList", true);
        corpoPrincipal.put("usePhoneNumberList", true);
        corpoPrincipal.put("validateNickname", true);

        corpoPrincipal.put("customerAssets", listaCustomerAssets);
        corpoPrincipal.put("fatcaResponses", listaFatcaResponses);
        corpoPrincipal.put("phoneNumbers", listaPhoneNumbers);
        listaCorpoPrincipal.add(corpoPrincipal);


        listaCorpoPrincipal.add(corpoPrincipal);

        return corpoPrincipal;
    }


    /**
     * Método criar o corpo da requisição Application com dados do Plano
     */
    static JSONObject criarCorpoRequisicaoAApplicationDois(int planoAdesao,String descricaoPlano ,int valorPlano, int cartaoAdesao, String descricaoCartao, int valorCartao) throws Exception {

        String corpo = "{\r\n  \"addresses\": [\r\n {\r\n\"addressAdditionalInfo\": \"string string\",\r\n\"addressType" +
                "\": \"1\",\r\n\"cityId\": 0,\r\n\"createFunctionName\": \"string\",\r\n\"createTimestamp\": \"2020-05-2" +
                "7T17:29:54.975Z\",\r\n\"createUserId\": 0,\r\n\"customerUid\": 0,\r\n\"mailingAddressInd\": \"Y\",\r\n\"" +
                "neighbourhood\": \"string\",\r\n\"postalCode\": 6220090,\r\n\"stateCd\": \"SP\",\r\n\"streetName\": \"" +
                "RUA ESPIRITO SANTO\",\r\n\"streetNumber\": \"100\",\r\n\"uniqueID\": 0,\r\n\"updateFunctionName\": \"string" +
                "\",\r\n \"updateTimestamp\": \"2020-05-27T17:29:54.975Z\",\r\n\"updateUserId\": 0\r\n}\r\n],\r\n\"birth" +
                "Place\": \"string\",\r\n  \"birthdate\": \"1988-05-27\",\r\n  \"cityOfBirth\": 50830,\r\n\"civilCapacit" +
                "yCode\": 0,\r\n\"cnhId\": \"846537846\",\r\n  \"countryOfBirth\": 46,\r\n  \"customerAssets\": [\r\n{\r\n\"" +
                "assetQuantity\": 0,\r\n\"assetTypeId\": \"1\",\r\n\"assetValueAmt\": 0,\r\n\"createFunctionName\": \"str" +
                "ing\",\r\n\"createTimestamp\": \"2020-05-27T17:29:54.975Z\",\r\n\"createUserId\": 0,\r\n\"customerUid\":0," +
                "\r\n\"uniqueID\": 0,\r\n\"updateFunctionName\": \"string\",\r\n\"updateTimestamp\": \"2020-05-27T17:29:54" +
                ".975Z\",\r\n\"updateUserId\": 0\r\n}\r\n  ],\r\n  \"customerName\": \"FULANO BELTRANO DA SILVA\",\r\n  " +
                "\"documentIssueDate\": \"2020-05-27\",\r\n  \"documentIssuerDepartment\": \"SSP\",\r\n  \"documentIssuer" +
                "StateId\": \"SP\",\r\n  \"eduCompletionDt\": \"2020-05-27\",\r\n  \"eduCurrentSemester\": 0,\r\n  \"eduIn" +
                "stitutionName\": \"string string\",\r\n\"eduInstitutionStateCd\": \"SP\",\r\n  \"eduLastUpdatedDt\": \"" +
                "2020-05-27\",\r\n  \"eduMajor\": \"string\",\r\n\"educationInstitutionStateId\": \"SP\",\r\n  \"educatio" +
                "nLevelId\": 0,\r\n  \"email\": \"teste@teste.com\",\r\n  \"fatcaResponses\": [\r\n{\r\n \"countryId\": 0," +
                "\r\n\"createFunctionName\": \"string\",\r\n\"createTimestamp\": \"2020-05-27T17:29:54.975Z\",\r\n\"create" +
                "UserId\": 0,\r\n\"customerUid\": 0,\r\n\"fatcaQuestionId\": 0,\r\n\"nationality\": \"string\",\r\n\"nifT" +
                "axId\": \"\",\r\n\"reasonMissingNifId\": 2,\r\n\"uniqueID\": 2,\r\n\"updateFunctionName\": \"string\",\r" +
                "\"updateTimestamp\": \"2020-05-27T17:29:54.975Z\",\r\n\"updateUserId\": 0\r\n}\r\n],\r\n  \"fatherName\":" +
                " \"Rodrigo Benedetti\",\r\n\"gender\": \"M\",\r\n  \"gpsPermissionInd\": true,\r\n  \"invoiceDay\": 0,\r\n\"mar" +
                "italStatus\": \"1\",\r\n  \"missingFatherNameReasonId\": 0,\r\n  \"missingMotherNameReasonId\": 0,\r\n  \"" +
                "monthlyIncome\": 1000,\r\n\"motherName\": \"Isaura Lima\",\r\n  \"nickname\": \"FULANO BELTRANO DA SILVA\",\r\n  \"pepRelatedCpf" +
                "\": \"\",\r\n  \"pepRelatedId\": 0,\r\n  \"pepRelatedResponse\": \"N\",\r\n  \"pepRoleResponse\": \"N\",\r\n\"" +
                "phoneNumbers\": [\r\n{\r\n \"areaCode\": \"11\",\r\n\"countryCode\": \"55\",\r\n\"createFunctionName\": " +
                "\"string\",\r\n\"createTimestamp\": \"2020-05-27T17:29:54.975Z\",\r\n\"createUserId\": 0,\r\n\"customerU" +
                "id\": 0,\r\n\"phoneNumber\": 999999999,\r\n\"phoneType\": \"1\",\r\n\"primaryPhoneInd\": \"Y\",\r\n\"uni" +
                "queID\": 0,\r\n\"updateFunctionName\": \"string\",\r\n\"updateTimestamp\": \"2020-05-27T17:29:54.975Z\"" +
                ",\r\n\"updateUserId\": 0\r\n}\r\n  ],\r\n  \"pinPointChangedInd\": true,\r\n \"pinPointLatitude\": \"str" +
                "ing\",\r\n \"pinPointLongitude\": \"string\",\r\n \"professionCategoryId\": 1,\r\n\"professionId\": 100," +
                "\r\n  \"referencePersonAreaCode\": 0,\r\n\"referencePersonCountryCode\": 0,\r\n  \"referencePersonName\": " +
                "\"Valentina Silva\",\r\n  \"referencePersonPhoneNr\": 0,\r\n\"referencePersonTypeId\": 0,\r\n \"rgId\":" +
                " \"string\",\r\n \"spouseName\": \"string string\",\r\n \"stateOfBirth\": 11,\r\n  \"twitterAccount\": " +
                "\"string\",\r\n  \"universityStudent\": true,\r\n  \"useAddressList\": true,\r\n  \"useAssetList\": true," +
                "\r\n  \"useFatcaResponseList\": true,\r\n  \"usePhoneNumberList\": true,\r\n  \"validateNickname\": true," +
                "\r\n  \"proposal\": \r\n\t\t{\r\n\t   \"uniqueID\":"+detailedCustomerInfo()+",\r\n\t   \"planCode\":98,\r\n\t\"" +
                "planStartDate\":[\r\n\t 2000,\r\n\t1,\r\n\t 1\r\n\t],\r\n\t\"planEndDate\":[\r\n\t2099,\r\n\t12,\r\n\t 31\r\n\t" +
                "],\r\n\t   \"supportCredit\":\"N\",\r\n\t   \"planAmount\":30,\r\n\t   \"planStatus\":1,\r\n\t\"planName\":" +
                "\"Faz o Seu\",\r\n\t\"planFreePeriod\":\"5 meses\",\r\n\t\"listOfproducts\":[\r\n\t {\r\n\t\"productType\":2,\r\n\t\"" +
                "productCode\":"+cartaoAdesao+",\r\n\t\"productStartDate\":[\r\n\t2000,\r\n\t1,\r\n\t1\r\n\t],\r\n\t\"productEndDate\"" +
                ":[\r\n\t2099,\r\n\t12,\r\n\t31\r\n\t],\r\n\t\"productAmount\":"+valorCartao+",\r\n\t\"productDescription\":\""+descricaoCartao+"" +
                "\",\r\n\t\"supportCredit\":\"Y\",\r\n\t\"uniqueID\":154810\r\n\t},\r\n\t {\r\n\t\"productType\":1,\r\n\t\"" +
                "productCode\":"+planoAdesao+",\r\n\t\"productStartDate\":[\r\n\t 2000,\r\n\t1,\r\n\t1\r\n\t],\r\n\t \"productEndDate\":" +
                "[\r\n\t2099,\r\n\t12,\r\n\t31\r\n\t],\r\n\t\"productAmount\":"+valorPlano+",\r\n\t\"productDescription\":\""+descricaoPlano+"\"," +
                "\r\n\t\"supportCredit\":\"N\",\r\n\t\"uniqueID\":154811\r\n\t}\r\n\t   ]\r\n\t}\r\n\t\r\n}";

        JSONParser parser = new JSONParser();
        JSONObject corpoBody = (JSONObject) parser.parse(corpo);

        return corpoBody;
    }

    /**
     * Método registra a dados do Pai/Mãe e Endereço
     *  @param 'esteira'
     * @param 'cpf'
     * @param 'token'
     * @return
     */
    static Response application(JSONObject corpoBody) throws Exception {
        List<Header> headerlist = new ArrayList<Header>();
        headerlist.add(new Header("X-Next-AuthToken",loginApp()));
        headerlist.add(new Header("coreIP", coreIp));
        Headers headers = new Headers(headerlist);

        DadosRequisicaoBase corpoRequisicao = new DadosRequisicaoBase(uriBaseCoreBank, "/v2/onboarding/applications")
                .definirHeaders(headers)
                .definirCorpoRequisicao(corpoBody);

            return executarRequisicao(corpoRequisicao, MetodoRequisicao.PUT,200, "Não foi possivel registar os dados! ").getResponse();

    }
    /**
     * Método validar documentos requeridos.
     *  @param 'esteira'
     * @param 'token'
     * @return
     */
    static Response requiredDocuments() throws Exception {
        List<Header> headerlist = new ArrayList<Header>();
        headerlist.add(new Header("X-Next-AuthToken", loginApp()));
        headerlist.add(new Header("coreIP", coreIp));
        Headers headers = new Headers(headerlist);
        DadosRequisicaoBase corpoRequisicao = new DadosRequisicaoBase(uriBaseCoreBank, "/v1/profiles/requiredDocuments")
                .definirHeaders(headers)
                .definirCorpoRequisicao();
        return executarRequisicao(corpoRequisicao, MetodoRequisicao.GET,200, "Não foi verificar os documento exigidos!").getResponse();
    }
    /**
     * Método para upload do video do cliente
     * @param 'esteira'
     * @param 'token'
     * @Arquivo videoMP4
     *
     */
    static Response uploadVideo() throws Exception {
        List<Header> headerlist = new ArrayList<Header>();
        headerlist.add(new Header("X-Next-AuthToken", loginApp()));
        headerlist.add(new Header("coreip", coreIp));
        Headers headers = new Headers(headerlist);
        File file = new File("./src/main/resources/arquivos/video.mp4");

        DadosRequisicaoBase corpoRequisicao = new DadosRequisicaoBase(uriBaseCoreBank, "/v1/profiles/documents")
                .definirHeaders(headers)
                .definirParametros("metadata", "{\"documentType\":\"video\",\"documentExtension\":\"MP4\",\"mimeType\":\"video/MP4\"}")
                .definirDadosUploadArquivo("documents", file,"multipart/form-data");

        return executarRequisicao(corpoRequisicao, MetodoRequisicao.POST, 201, "Não foi possivel efetuar o upload do video!").getResponse();
    }
    /**
     * Método para upload da cnh cliente
     * @param 'esteira'
     * @param 'token'
     * @Arquivo rgFrente.jpg
     * @Arquivo rgVerso.jpg
     *
     * @return
     */
    static RespostaBase uploadRg() throws Exception {
        File rg_frente = new File("./src/main/resources/arquivos/rg-frente.png");
        File rg_verso = new File("./src/main/resources/arquivos/video.mp4");

        given().
                relaxedHTTPSValidation().
                param("metadata", "{\"documentType\":\"rgWithCpf\",\"documentExtension\":\"JPEG\",\"mimeType\":\"IMAGE/JPEG\"}").
                header("X-Next-AuthToken", loginApp()).
                header("coreip", coreIp).
                multiPart("documents", rg_frente).
                multiPart("documents", rg_verso).
                formParam("name", "value").
                expect().
                statusCode(201).
                when().
                post(uriBaseCoreBank + "/v1/profiles/documents");
        return null;
    }
    /**
     * Método para upload do RG cliente
     * @param 'token'
     * @Arquivo cnhFrente.jpg
     * @Arquivo cnhVerso.jpg
     *
     */
    static Response uploadCnh() throws Exception {
        File cnhFrente = new File("./src/main/resources/arquivos/rg-frente.png");
        File cnhVerso = new File("./src/main/resources/arquivos/rg-verso.png");

        given().
                relaxedHTTPSValidation().
                param("metadata", "{\"documentType\": \"driverLicence\",\"documentExtension\":\"JPEG\",\"mimeType\":\"IMAGE/JPEG\"}").
                header("X-Next-AuthToken", loginApp()).
                header("coreip", coreIp).
                multiPart("documents", cnhFrente).
                multiPart("documents", cnhVerso).
                formParam("name", "value").
                expect().
                statusCode(201).
                when().
                post(uriBaseCoreBank + "/v1/profiles/documents");
        return null;

    }

    /**
     * Método para Avaliação de crédito
     * @param 'Token'
     * @param 'esteira'
     *
     */
    static Response creditAssessment() throws Exception {
        List<Header> headerlist = new ArrayList<Header>();
        headerlist.add(new Header("X-Next-AuthToken", loginApp()));
        headerlist.add(new Header("coreIP", coreIp));
        Headers headers = new Headers(headerlist);
        DadosRequisicaoBase corpoRequisicao = new DadosRequisicaoBase(uriBaseCoreBank, "/v1/creditAssessment")
                .definirHeaders(headers);

        return executarRequisicao(corpoRequisicao, MetodoRequisicao.POST,200, "Não foi efetuar a Avaliação de crédito!").getResponse();
    }

    /**
     * Método para retorna os planos disponiveis
     * @param 'token'
     * @param 'CoreIP'
     * @oaram diaVencimento
     *
     */
    static Response returnsPlansCard() throws Exception {
        List<Header> headerlist = new ArrayList<Header>();
        headerlist.add(new Header("X-Next-AuthToken", loginApp()));
        headerlist.add(new Header("coreIP", coreIp));
        Headers headers = new Headers(headerlist);
        DadosRequisicaoBase corpoRequisicao = new DadosRequisicaoBase(uriBaseCoreBank, "/v2/plans")
                .definirHeaders(headers)
                .definirCorpoRequisicao("creditCardInvoiceDay", 10);

        return executarRequisicao(corpoRequisicao, MetodoRequisicao.GET,200, "Não foi possivel listar os Planos disponiveis parea o Cliente!").getResponse();
    }
    /**
     * Método retorna dados da proposta(Informações detalhadas do cliente)
     * @param 'token'
     * @param 'esteira'
     * @return
     */
    static String detailedCustomerInfo() throws Exception {
        List<Header> headerlist = new ArrayList<Header>();
        headerlist.add(new Header("X-Next-AuthToken", loginApp()));
        headerlist.add(new Header("coreIP", coreIp));
        Headers headers = new Headers(headerlist);
        DadosRequisicaoBase corpoRequisicao = new DadosRequisicaoBase(uriBaseCoreBank, "/v1/profiles/detailedCustomerInfo")
                .definirHeaders(headers)
                .definirCorpoRequisicao();

        return executarRequisicao(corpoRequisicao, MetodoRequisicao.GET,200, "Não foi possivel recuperar as Informações detalhadas do cliente !").obterValorJson("proposalData","uniqueID");
    }

        /**
         * Método retorna para gravar senha do cartão
         * @param 'token'
         * @param 'esteira'
         * @param 'encryptedCardPassword'
         * @return
         */
        static RespostaBase cardPassword() throws Exception {
            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header("X-Next-AuthToken", loginApp()));
          //  headerlist.add(new Header("coreIP", coreIp));
            headerlist.add(new Header("Content-Type", "application/json"));
            Headers headers = new Headers(headerlist);

            DadosRequisicaoBase corpoRequisicao = new DadosRequisicaoBase(uriBaseCoreBank, "/v1/cardPassword")
                    .definirHeaders(headers)
                    .definirCorpoRequisicao("cpf", cpf,
                    "encryptedCardPassword", cardPassword);

            return executarRequisicao(corpoRequisicao, MetodoRequisicao.POST,200, "Não foi possivel gravar a senha do cliente !");
        }
        /**
         * Método captura o token do Termos e Condições
         * @param 'token'
         * @param 'esteira'
         * @return
         */
        static String termsAndConditions() throws Exception {
            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header("X-Next-AuthToken", loginApp()));
            headerlist.add(new Header("coreIP", coreIp));
            Headers headers = new Headers(headerlist);
            DadosRequisicaoBase corpoRequisicao = new DadosRequisicaoBase(uriBaseCoreBank, "/v1/termsAndConditions")
                    .definirHeaders(headers);
            return executarRequisicao(corpoRequisicao, MetodoRequisicao.GET,200, "Não foi possivel capturar código termsAndConditions !").obterValorJson("termsAndConditions", "termsAndConditionsUid");
        }

    /**
     * Método submeter o aceite do termpo e condições do App
     * @param 'token'
     * @param 'deviceId'
     * @param 'deviceSignature'
     * @param 'esteira'
     * @param 'cpf'
     *
     * @return
     */
    static Response submitApplicationAndCodes() throws Exception {
        List<Header> headerlist = new ArrayList<Header>();
        headerlist.add(new Header("X-Next-AuthToken", loginApp()));
        headerlist.add(new Header("Content-Type", "application/json"));
        headerlist.add(new Header("deviceID", device_id));
        headerlist.add(new Header("deviceDNA", deviceSignature));
        headerlist.add(new Header("Remote-IP-Address", "192.168.1.1"));
        headerlist.add(new Header("coreIP", coreIp));
        headerlist.add(new Header("cpf", cpf));
        headerlist.add(new Header("deviceSignature", deviceSignature));
        Headers headers = new Headers(headerlist);

        JSONParser parser = new JSONParser();
        Object obj  = parser.parse(termsAndConditions());


        DadosRequisicaoBase corpoRequisicao = new DadosRequisicaoBase(uriBaseCoreBank, "/v2/submitApplicationAndCodes")
                .definirHeaders(headers)
                .definirCorpoRequisicao(
                        "email", "teste@teste.com",
                        "termsAndConditionsUIDs",obj);

        return  definirModeloAdesao(executarRequisicao(corpoRequisicao, MetodoRequisicao.POST,200, "Não foi possivel aceitar o termo em condições.!").getResponse());

    }

    private static Response definirModeloAdesao(Response response) {
        setModeloAdesao();
        getModeloAdesao().setCpf(response.jsonPath().getString("cpf"));

        return response;
    }
}
