package qrcodeapi.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class QrCodeService {
    public BufferedImage createImage(String content, int size) {
        QRCodeWriter writer = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, size, size);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public Map<String, String> errorHandler(String contents, int size, String type) {
        Map<String, String> error = new HashMap<>();
        String[] possibleTypes = {"png", "jpeg", "gif"};
        if (contents.trim().isEmpty()) {
            error.put("error", "Contents cannot be null or blank");
            return error;
        }
        if (size > 350 || size < 150) {
            error.put("error", "Image size must be between 150 and 350 pixels");
            return error;
        }

        if (Arrays.stream(possibleTypes).noneMatch(type::equals))
            error.put("error", "Only png, jpeg and gif image types are supported");
        return error;
    }

    public MediaType getMediaType(String type) {
        switch (type) {
            case "png" -> {
                return MediaType.IMAGE_PNG;
            }
            case "jpeg" -> {
                return MediaType.IMAGE_JPEG;
            }
            case "gif" -> {
                return MediaType.IMAGE_GIF;
            }
            default -> {
                return null;
            }
        }
    }
}
