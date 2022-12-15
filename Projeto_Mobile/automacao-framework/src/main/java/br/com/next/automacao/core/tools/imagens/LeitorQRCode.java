package br.com.next.automacao.core.tools.imagens;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.bouncycastle.util.encoders.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

/**
 * Classe define agente para ler QR code em tempo de execução do teste
 * @author Marcos Ghiraldelli
 * @since 18-05
 * @version 3.7.3
 */
public class LeitorQRCode {

    /**
     * Método para ler o QR Code exibido na tela
     * @param base64Image - screenshot com o QRCode convertido em base 64
     * @return String com o texto obtido do QRCode
     */
    public static String lerQRCode(String base64Image) {
        String encodedContent = null;
        try {
            byte[] imageBytes = Base64.decode(base64Image);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageBytes);
            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
            encodedContent = lerQRCode(bufferedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedContent;
    }

    /**
     * Método para ler o QR Code a partir de arquivo
     * @param qrCodeFile - arquivo imagem com QR code
     * @return String com o texto obtido do QRCode
     */
    public static String lerQRCode(File qrCodeFile) {
        String encodedContent = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(qrCodeFile);

            encodedContent = lerQRCode(bufferedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedContent;
    }

    /**
     * Método para ler o QR Code a partir de objeto BufferedImage
     * @param bufferedImage
     * @return String com o texto obtido do QRCode
     */
    public static String lerQRCode(BufferedImage bufferedImage) {
        String encodedContent = null;
        try {
            BufferedImageLuminanceSource bufferedImageLuminanceSource = new BufferedImageLuminanceSource(bufferedImage);
            HybridBinarizer hybridBinarizer = new HybridBinarizer(bufferedImageLuminanceSource);
            BinaryBitmap binaryBitmap = new BinaryBitmap(hybridBinarizer);
            MultiFormatReader multiFormatReader = new MultiFormatReader();

            Result result = multiFormatReader.decode(binaryBitmap);
            encodedContent = result.getText();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return encodedContent;
    }
}