package br.com.next.automacao.core.tools.ssl;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Test;

import javax.net.ssl.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

import static br.com.next.automacao.core.tools.ReadProperties.getProperty;
import static io.restassured.RestAssured.given;

public class CertManager {

    public CertManager(String url) {
        storeCertificates(getCertificates(url));
    }

    private static Certificate[] getCertificates(String url) {

        URL urlConnection = null;
        try {
            urlConnection = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        SSLContext context = null;
        try {
            context = SSLContext.getInstance("SSL");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            context.init(new KeyManager[0], new TrustManager[]{new DummyTrustManager()}, new SecureRandom());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        SSLContext.setDefault(context);
        HttpsURLConnection con = null;
        try {
            con = (HttpsURLConnection) urlConnection.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        con.setHostnameVerifier(
                (hostname, session) -> true);
        con.setSSLSocketFactory(context.getSocketFactory());
        try {
            con.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Certificate[] certificates = new Certificate[0];
        try {
            certificates = con.getServerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            e.printStackTrace();
        }
        con.disconnect();
        return certificates;

    }

    private static void storeCertificates(Certificate[] certs) {
        String caminhoBase;
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            caminhoBase = getProperty("path.base.windows");
        } else {
            caminhoBase = getProperty("path.base.mac");
        }
        String keystorePath = caminhoBase + "certificados";
        String keystorePassword = "changeit";
        KeyStore keystore = null;
        try {
            keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try {
            keystore.load(null, keystorePassword.toCharArray());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        for (Certificate c : certs) {
            try {
                keystore.setCertificateEntry(Integer.toHexString(c.hashCode()), c);
            } catch (KeyStoreException e) {
                e.printStackTrace();
            }
        }
        File f = new File(keystorePath);
        FileOutputStream out_stream = null;
        try {
            out_stream = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            keystore.store(out_stream, keystorePassword.toCharArray());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        try {
            out_stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty("javax.net.ssl.trustStore", keystorePath);
        System.setProperty("javax.net.debug", "all");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
    }

    @Test
    public void teste() {
        try {
            storeCertificates(getCertificates("https://api.int.tu.aznxt.local/v1/login/csr"));

            JSONObject resquestBody = new JSONObject();
            resquestBody.put("agentId", "I931050");
            resquestBody.put("cpf", "11189357135");
            resquestBody.put("password", "testemar");
            resquestBody.put("csrUserId", "I931050");
            resquestBody.put("host", "D4253E0227");
            resquestBody.put("ticketId", "1235656");

            Response response =
                    given()
//                    .keyStore(keystorePath, keystorePass)
//                            .relaxedHTTPSValidation()
                            .contentType(ContentType.JSON)
                            .accept(ContentType.TEXT)
                            .header("channel", "MNCC")
                            .body(resquestBody.toJSONString())
                            .when()
                            .post("https://api.int.tu.aznxt.local/v1/login/csr")
                            .then()
                            .statusCode(200)
                            .extract()
                            .response();

            response.body().prettyPeek();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
