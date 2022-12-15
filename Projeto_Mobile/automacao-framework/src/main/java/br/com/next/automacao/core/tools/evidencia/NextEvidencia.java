package br.com.next.automacao.core.tools.evidencia;

import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

/**
 * Objeto de evidência
 *
 * @author Lucas Santos
 * @version 1.0
 * @since 2020-02
 */

public class NextEvidencia {

    /**
     * Mensagem da evidência
     */
    private String message;

    /**
     * String retornada do teste
     */
    private String imageString;

    /**
     * Imagem para o relatório de evidência
     */
    private BufferedImage image;

    /**
     * Construtor para criar nova instância de evidência com imagem
     *
     * @param message
     * @param imageString
     * @throws Exception
     */
    public NextEvidencia(String message, String imageString) {
        setMessage(message);
        setImageString(imageString);
    }


    /**
     * Pega mensagem da evidência
     *
     * @return mensagem
     */
    public String getMessage() {
        return message;
    }

    /**
     * Seta a mensgaem da evidência
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Pega a imagem
     *
     * @return imagem
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Seta a imagem
     *
     * @param image imagem recuperada do teste
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * Pega imagem em Base64
     *
     * @return
     */
    public String getImageString() {
        return imageString;
    }

    /**
     * Cria uma ImageIO baseada na string vinda do teste
     *
     * @param imageString
     * @throws Exception
     */
    public void setImageString(String imageString) {
        this.imageString = imageString;
        try {
            setImage( ImageIO.read( new ByteArrayInputStream( toImage( imageString ) ) ) );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Transforma a string retornada em Base64
     *
     * @param string string retornada pelo teste
     * @return uma instância de BASE64Decoder
     * @throws Exception
     */
    public static byte[] toImage(String string) throws Exception {
        return Base64.decodeBase64( string );
    }

}
